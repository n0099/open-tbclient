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
    private TextView eMO;
    private NoNetworkView fbX;
    private boolean ivA;
    private TextView ivB;
    private View ivC;
    private TextView ivD;
    private BdListView ivu;
    private OfficialBarTipListAdapter ivv;
    private OfficialBarTipActivity ivw;
    private boolean ivx;
    private RelativeLayout ivy;
    private TextView ivz;
    private NavigationBar mNavigationBar;
    private NoDataView mNoDataView;
    private ViewGroup mRootView;

    public f(OfficialBarTipActivity officialBarTipActivity) {
        super(officialBarTipActivity.getPageContext());
        this.ivx = false;
        this.ivy = null;
        this.ivA = false;
        officialBarTipActivity.setContentView(R.layout.officialbar_msg_activity);
        this.ivw = officialBarTipActivity;
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
        this.fbX = (NoNetworkView) this.mRootView.findViewById(R.id.no_network_view);
        this.ivC = LayoutInflater.from(this.ivw.getBaseContext()).inflate(R.layout.im_ba_btn, (ViewGroup) null);
        this.ivD = (TextView) this.ivC.findViewById(R.id.all_read);
        this.ivD.setVisibility(8);
        this.eMO = (TextView) this.ivC.findViewById(R.id.edit);
        this.eMO.setVisibility(0);
        this.ivC = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.ivC, (View.OnClickListener) null);
        this.eMO.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.officialBar.f.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!f.this.ivx) {
                    if (f.this.ivw.cjU()) {
                        f.this.ivD.setVisibility(0);
                    }
                    f.this.a(officialBarTipActivity, true);
                    return;
                }
                f.this.a(officialBarTipActivity, false);
            }
        });
    }

    public void onChangeSkinType(int i) {
        this.ivw.getLayoutMode().setNightMode(i == 1);
        this.ivw.getLayoutMode().onModeChanged(this.mRootView);
        this.mNavigationBar.onChangeSkinType(this.ivw.getPageContext(), i);
        am.setNavbarTitleColor(this.eMO, R.color.navi_op_text, R.color.navi_op_text_skin);
        am.setNavbarTitleColor(this.ivD, R.color.navi_op_text, R.color.navi_op_text_skin);
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(this.ivw.getPageContext(), i);
        }
        if (this.fbX != null) {
            this.fbX.onChangeSkinType(this.ivw.getPageContext(), i);
        }
        this.ivv.notifyDataSetChanged();
    }

    private void k(OfficialBarTipActivity officialBarTipActivity) {
        this.ivu = (BdListView) officialBarTipActivity.findViewById(R.id.msg_list);
        this.ivv = new OfficialBarTipListAdapter(officialBarTipActivity);
        this.ivu.setAdapter((ListAdapter) this.ivv);
        this.mNoDataView = NoDataViewFactory.a(officialBarTipActivity.getPageContext().getPageActivity(), this.mRootView, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA), NoDataViewFactory.d.lT(R.string.official_message_activity_no_data), null);
    }

    private void l(final OfficialBarTipActivity officialBarTipActivity) {
        this.ivy = (RelativeLayout) officialBarTipActivity.findViewById(R.id.tip_footer);
        this.ivB = (TextView) this.ivy.findViewById(R.id.delete_txt);
        this.ivB.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.officialBar.f.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                officialBarTipActivity.cjR();
                f.this.a(officialBarTipActivity, false);
            }
        });
        this.ivz = (TextView) this.ivy.findViewById(R.id.select_all_txt);
        int dimens = l.getDimens(this.ivw.getPageContext().getPageActivity(), R.dimen.ds40);
        Drawable drawable = am.getDrawable(R.drawable.btn_bgb_choice_n);
        drawable.setBounds(0, 0, dimens, dimens);
        this.ivz.setText(this.ivw.getPageContext().getString(R.string.select_all));
        this.ivz.setCompoundDrawables(drawable, null, null, null);
        this.ivz.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.officialBar.f.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!f.this.ivA) {
                    f.this.oR(true);
                } else {
                    f.this.oR(false);
                }
            }
        });
    }

    public BdListView cjX() {
        return this.ivu;
    }

    public OfficialBarTipListAdapter cjY() {
        return this.ivv;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final OfficialBarTipActivity officialBarTipActivity, boolean z) {
        if (z) {
            this.ivy.setVisibility(0);
            this.ivv.oM(true);
            this.ivv.notifyDataSetChanged();
            if (officialBarTipActivity.cjS()) {
                oQ(true);
            } else {
                oQ(false);
            }
            this.eMO.setText(officialBarTipActivity.getPageContext().getString(R.string.cancel));
            this.ivD.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.officialBar.f.5
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    f.this.ivw.cjT();
                    f.this.a(officialBarTipActivity, false);
                }
            });
            this.ivx = true;
            return;
        }
        this.ivy.setVisibility(8);
        this.ivD.setVisibility(8);
        this.ivv.oM(false);
        this.ivv.notifyDataSetChanged();
        this.eMO.setText(officialBarTipActivity.getPageContext().getString(R.string.edit));
        this.ivx = false;
    }

    public void oQ(boolean z) {
        if (z) {
            this.ivB.setAlpha(1.0f);
            this.ivB.setEnabled(true);
            return;
        }
        this.ivB.setAlpha(0.3f);
        this.ivB.setEnabled(false);
    }

    public void setData(List<ImMessageCenterShowItemData> list) {
        this.ivv.setData(list);
        if (list != null && list.size() <= 0) {
            this.eMO.setVisibility(8);
        }
    }

    public void oR(boolean z) {
        int dimens = l.getDimens(this.ivw.getPageContext().getPageActivity(), R.dimen.ds40);
        if (z) {
            Drawable drawable = am.getDrawable(R.drawable.btn_bgb_choice_s);
            drawable.setBounds(0, 0, dimens, dimens);
            this.ivz.setText(this.ivw.getPageContext().getString(R.string.cancel_select_all));
            this.ivz.setCompoundDrawables(drawable, null, null, null);
            oQ(true);
            this.ivA = true;
            this.ivw.updateEditStatus(true);
            return;
        }
        Drawable drawable2 = am.getDrawable(R.drawable.btn_bgb_choice_n);
        drawable2.setBounds(0, 0, dimens, dimens);
        this.ivz.setText(this.ivw.getPageContext().getString(R.string.select_all));
        this.ivz.setCompoundDrawables(drawable2, null, null, null);
        oQ(false);
        this.ivA = false;
        this.ivw.updateEditStatus(false);
    }
}
