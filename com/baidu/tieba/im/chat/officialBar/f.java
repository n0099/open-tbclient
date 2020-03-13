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
    private TextView dXW;
    private NoNetworkView elv;
    private View hvA;
    private TextView hvB;
    private BdListView hvs;
    private OfficialBarTipListAdapter hvt;
    private OfficialBarTipActivity hvu;
    private boolean hvv;
    private RelativeLayout hvw;
    private TextView hvx;
    private boolean hvy;
    private TextView hvz;
    private NavigationBar mNavigationBar;
    private NoDataView mNoDataView;
    private ViewGroup mRootView;

    public f(OfficialBarTipActivity officialBarTipActivity) {
        super(officialBarTipActivity.getPageContext());
        this.hvv = false;
        this.hvw = null;
        this.hvy = false;
        officialBarTipActivity.setContentView(R.layout.officialbar_msg_activity);
        this.hvu = officialBarTipActivity;
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
        this.elv = (NoNetworkView) this.mRootView.findViewById(R.id.no_network_view);
        this.hvA = LayoutInflater.from(this.hvu.getBaseContext()).inflate(R.layout.im_ba_btn, (ViewGroup) null);
        this.hvB = (TextView) this.hvA.findViewById(R.id.all_read);
        this.hvB.setVisibility(8);
        this.dXW = (TextView) this.hvA.findViewById(R.id.edit);
        this.dXW.setVisibility(0);
        this.hvA = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.hvA, (View.OnClickListener) null);
        this.dXW.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.officialBar.f.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!f.this.hvv) {
                    if (f.this.hvu.bSG()) {
                        f.this.hvB.setVisibility(0);
                    }
                    f.this.a(officialBarTipActivity, true);
                    return;
                }
                f.this.a(officialBarTipActivity, false);
            }
        });
    }

    public void onChangeSkinType(int i) {
        this.hvu.getLayoutMode().setNightMode(i == 1);
        this.hvu.getLayoutMode().onModeChanged(this.mRootView);
        this.mNavigationBar.onChangeSkinType(this.hvu.getPageContext(), i);
        am.setNavbarTitleColor(this.dXW, R.color.navi_op_text, R.color.navi_op_text_skin);
        am.setNavbarTitleColor(this.hvB, R.color.navi_op_text, R.color.navi_op_text_skin);
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(this.hvu.getPageContext(), i);
        }
        if (this.elv != null) {
            this.elv.onChangeSkinType(this.hvu.getPageContext(), i);
        }
        this.hvt.notifyDataSetChanged();
    }

    private void k(OfficialBarTipActivity officialBarTipActivity) {
        this.hvs = (BdListView) officialBarTipActivity.findViewById(R.id.msg_list);
        this.hvt = new OfficialBarTipListAdapter(officialBarTipActivity);
        this.hvs.setAdapter((ListAdapter) this.hvt);
        this.mNoDataView = NoDataViewFactory.a(officialBarTipActivity.getPageContext().getPageActivity(), this.mRootView, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA), NoDataViewFactory.d.lh(R.string.official_message_activity_no_data), null);
    }

    private void l(final OfficialBarTipActivity officialBarTipActivity) {
        this.hvw = (RelativeLayout) officialBarTipActivity.findViewById(R.id.tip_footer);
        this.hvz = (TextView) this.hvw.findViewById(R.id.delete_txt);
        this.hvz.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.officialBar.f.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                officialBarTipActivity.bSD();
                f.this.a(officialBarTipActivity, false);
            }
        });
        this.hvx = (TextView) this.hvw.findViewById(R.id.select_all_txt);
        int dimens = l.getDimens(this.hvu.getPageContext().getPageActivity(), R.dimen.ds40);
        Drawable drawable = am.getDrawable(R.drawable.btn_bgb_choice_n);
        drawable.setBounds(0, 0, dimens, dimens);
        this.hvx.setText(this.hvu.getPageContext().getString(R.string.select_all));
        this.hvx.setCompoundDrawables(drawable, null, null, null);
        this.hvx.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.officialBar.f.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!f.this.hvy) {
                    f.this.nl(true);
                } else {
                    f.this.nl(false);
                }
            }
        });
    }

    public BdListView bSI() {
        return this.hvs;
    }

    public OfficialBarTipListAdapter bSJ() {
        return this.hvt;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final OfficialBarTipActivity officialBarTipActivity, boolean z) {
        if (z) {
            this.hvw.setVisibility(0);
            this.hvt.ng(true);
            this.hvt.notifyDataSetChanged();
            if (officialBarTipActivity.bSE()) {
                nk(true);
            } else {
                nk(false);
            }
            this.dXW.setText(officialBarTipActivity.getPageContext().getString(R.string.cancel));
            this.hvB.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.officialBar.f.5
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    f.this.hvu.bSF();
                    f.this.a(officialBarTipActivity, false);
                }
            });
            this.hvv = true;
            return;
        }
        this.hvw.setVisibility(8);
        this.hvB.setVisibility(8);
        this.hvt.ng(false);
        this.hvt.notifyDataSetChanged();
        this.dXW.setText(officialBarTipActivity.getPageContext().getString(R.string.edit));
        this.hvv = false;
    }

    public void nk(boolean z) {
        if (z) {
            this.hvz.setAlpha(1.0f);
            this.hvz.setEnabled(true);
            return;
        }
        this.hvz.setAlpha(0.3f);
        this.hvz.setEnabled(false);
    }

    public void setData(List<ImMessageCenterShowItemData> list) {
        this.hvt.setData(list);
        if (list != null && list.size() <= 0) {
            this.dXW.setVisibility(8);
        }
    }

    public void nl(boolean z) {
        int dimens = l.getDimens(this.hvu.getPageContext().getPageActivity(), R.dimen.ds40);
        if (z) {
            Drawable drawable = am.getDrawable(R.drawable.btn_bgb_choice_s);
            drawable.setBounds(0, 0, dimens, dimens);
            this.hvx.setText(this.hvu.getPageContext().getString(R.string.cancel_select_all));
            this.hvx.setCompoundDrawables(drawable, null, null, null);
            nk(true);
            this.hvy = true;
            this.hvu.updateEditStatus(true);
            return;
        }
        Drawable drawable2 = am.getDrawable(R.drawable.btn_bgb_choice_n);
        drawable2.setBounds(0, 0, dimens, dimens);
        this.hvx.setText(this.hvu.getPageContext().getString(R.string.select_all));
        this.hvx.setCompoundDrawables(drawable2, null, null, null);
        nk(false);
        this.hvy = false;
        this.hvu.updateEditStatus(false);
    }
}
