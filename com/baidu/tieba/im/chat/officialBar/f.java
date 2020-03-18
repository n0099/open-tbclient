package com.baidu.tieba.im.chat.officialBar;

import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.lib.util.l;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.core.data.ImMessageCenterShowItemData;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoDataView;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tieba.R;
import java.util.List;
/* loaded from: classes13.dex */
public class f extends com.baidu.adp.base.c<OfficialBarTipActivity> {
    private TextView dYm;
    private NoNetworkView elL;
    private BdListView hwS;
    private OfficialBarTipListAdapter hwT;
    private OfficialBarTipActivity hwU;
    private boolean hwV;
    private RelativeLayout hwW;
    private TextView hwX;
    private boolean hwY;
    private TextView hwZ;
    private View hxa;
    private TextView hxb;
    private NavigationBar mNavigationBar;
    private NoDataView mNoDataView;
    private ViewGroup mRootView;

    public f(OfficialBarTipActivity officialBarTipActivity) {
        super(officialBarTipActivity.getPageContext());
        this.hwV = false;
        this.hwW = null;
        this.hwY = false;
        officialBarTipActivity.setContentView(R.layout.officialbar_msg_activity);
        this.hwU = officialBarTipActivity;
        j(officialBarTipActivity);
        k(officialBarTipActivity);
        l(officialBarTipActivity);
    }

    private void j(final OfficialBarTipActivity officialBarTipActivity) {
        this.mNavigationBar = (NavigationBar) officialBarTipActivity.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.setCenterTextTitle(officialBarTipActivity.getPageContext().getString(R.string.subscribe_bar_title));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.officialBar.f.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                officialBarTipActivity.finish();
            }
        });
        this.mNavigationBar.showBottomLine();
        this.mRootView = (ViewGroup) officialBarTipActivity.findViewById(R.id.root_view);
        this.elL = (NoNetworkView) this.mRootView.findViewById(R.id.no_network_view);
        this.hxa = LayoutInflater.from(this.hwU.getBaseContext()).inflate(R.layout.im_ba_btn, (ViewGroup) null);
        this.hxb = (TextView) this.hxa.findViewById(R.id.all_read);
        this.hxb.setVisibility(8);
        this.dYm = (TextView) this.hxa.findViewById(R.id.edit);
        this.dYm.setVisibility(0);
        this.hxa = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.hxa, (View.OnClickListener) null);
        this.dYm.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.officialBar.f.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!f.this.hwV) {
                    if (f.this.hwU.bSY()) {
                        f.this.hxb.setVisibility(0);
                    }
                    f.this.a(officialBarTipActivity, true);
                    return;
                }
                f.this.a(officialBarTipActivity, false);
            }
        });
    }

    public void onChangeSkinType(int i) {
        this.hwU.getLayoutMode().setNightMode(i == 1);
        this.hwU.getLayoutMode().onModeChanged(this.mRootView);
        this.mNavigationBar.onChangeSkinType(this.hwU.getPageContext(), i);
        am.setNavbarTitleColor(this.dYm, R.color.navi_op_text, R.color.navi_op_text_skin);
        am.setNavbarTitleColor(this.hxb, R.color.navi_op_text, R.color.navi_op_text_skin);
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(this.hwU.getPageContext(), i);
        }
        if (this.elL != null) {
            this.elL.onChangeSkinType(this.hwU.getPageContext(), i);
        }
        this.hwT.notifyDataSetChanged();
    }

    private void k(OfficialBarTipActivity officialBarTipActivity) {
        this.hwS = (BdListView) officialBarTipActivity.findViewById(R.id.msg_list);
        this.hwT = new OfficialBarTipListAdapter(officialBarTipActivity);
        this.hwS.setAdapter((ListAdapter) this.hwT);
        this.mNoDataView = NoDataViewFactory.a(officialBarTipActivity.getPageContext().getPageActivity(), this.mRootView, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA), NoDataViewFactory.d.lh(R.string.official_message_activity_no_data), null);
    }

    private void l(final OfficialBarTipActivity officialBarTipActivity) {
        this.hwW = (RelativeLayout) officialBarTipActivity.findViewById(R.id.tip_footer);
        this.hwZ = (TextView) this.hwW.findViewById(R.id.delete_txt);
        this.hwZ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.officialBar.f.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                officialBarTipActivity.bSV();
                f.this.a(officialBarTipActivity, false);
            }
        });
        this.hwX = (TextView) this.hwW.findViewById(R.id.select_all_txt);
        int dimens = l.getDimens(this.hwU.getPageContext().getPageActivity(), R.dimen.ds40);
        Drawable drawable = am.getDrawable(R.drawable.btn_bgb_choice_n);
        drawable.setBounds(0, 0, dimens, dimens);
        this.hwX.setText(this.hwU.getPageContext().getString(R.string.select_all));
        this.hwX.setCompoundDrawables(drawable, null, null, null);
        this.hwX.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.officialBar.f.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!f.this.hwY) {
                    f.this.nr(true);
                } else {
                    f.this.nr(false);
                }
            }
        });
    }

    public BdListView bTa() {
        return this.hwS;
    }

    public OfficialBarTipListAdapter bTb() {
        return this.hwT;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final OfficialBarTipActivity officialBarTipActivity, boolean z) {
        if (z) {
            this.hwW.setVisibility(0);
            this.hwT.nm(true);
            this.hwT.notifyDataSetChanged();
            if (officialBarTipActivity.bSW()) {
                nq(true);
            } else {
                nq(false);
            }
            this.dYm.setText(officialBarTipActivity.getPageContext().getString(R.string.cancel));
            this.hxb.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.officialBar.f.5
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    f.this.hwU.bSX();
                    f.this.a(officialBarTipActivity, false);
                }
            });
            this.hwV = true;
            return;
        }
        this.hwW.setVisibility(8);
        this.hxb.setVisibility(8);
        this.hwT.nm(false);
        this.hwT.notifyDataSetChanged();
        this.dYm.setText(officialBarTipActivity.getPageContext().getString(R.string.edit));
        this.hwV = false;
    }

    public void nq(boolean z) {
        if (z) {
            this.hwZ.setAlpha(1.0f);
            this.hwZ.setEnabled(true);
            return;
        }
        this.hwZ.setAlpha(0.3f);
        this.hwZ.setEnabled(false);
    }

    public void setData(List<ImMessageCenterShowItemData> list) {
        this.hwT.setData(list);
        if (list != null && list.size() <= 0) {
            this.dYm.setVisibility(8);
        }
    }

    public void nr(boolean z) {
        int dimens = l.getDimens(this.hwU.getPageContext().getPageActivity(), R.dimen.ds40);
        if (z) {
            Drawable drawable = am.getDrawable(R.drawable.btn_bgb_choice_s);
            drawable.setBounds(0, 0, dimens, dimens);
            this.hwX.setText(this.hwU.getPageContext().getString(R.string.cancel_select_all));
            this.hwX.setCompoundDrawables(drawable, null, null, null);
            nq(true);
            this.hwY = true;
            this.hwU.updateEditStatus(true);
            return;
        }
        Drawable drawable2 = am.getDrawable(R.drawable.btn_bgb_choice_n);
        drawable2.setBounds(0, 0, dimens, dimens);
        this.hwX.setText(this.hwU.getPageContext().getString(R.string.select_all));
        this.hwX.setCompoundDrawables(drawable2, null, null, null);
        nq(false);
        this.hwY = false;
        this.hwU.updateEditStatus(false);
    }
}
