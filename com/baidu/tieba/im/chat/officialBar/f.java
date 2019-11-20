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
/* loaded from: classes3.dex */
public class f extends com.baidu.adp.base.c<OfficialBarTipActivity> {
    private TextView dfJ;
    private NoNetworkView dvR;
    private boolean gBA;
    private RelativeLayout gBB;
    private TextView gBC;
    private boolean gBD;
    private TextView gBE;
    private View gBF;
    private TextView gBG;
    private BdListView gBx;
    private OfficialBarTipListAdapter gBy;
    private OfficialBarTipActivity gBz;
    private NavigationBar mNavigationBar;
    private NoDataView mNoDataView;
    private ViewGroup mRootView;

    public f(OfficialBarTipActivity officialBarTipActivity) {
        super(officialBarTipActivity.getPageContext());
        this.gBA = false;
        this.gBB = null;
        this.gBD = false;
        officialBarTipActivity.setContentView(R.layout.officialbar_msg_activity);
        this.gBz = officialBarTipActivity;
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
        this.dvR = (NoNetworkView) this.mRootView.findViewById(R.id.no_network_view);
        this.gBF = LayoutInflater.from(this.gBz.getBaseContext()).inflate(R.layout.im_ba_btn, (ViewGroup) null);
        this.gBG = (TextView) this.gBF.findViewById(R.id.all_read);
        this.gBG.setVisibility(8);
        this.dfJ = (TextView) this.gBF.findViewById(R.id.edit);
        this.dfJ.setVisibility(0);
        this.gBF = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.gBF, (View.OnClickListener) null);
        this.dfJ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.officialBar.f.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!f.this.gBA) {
                    if (f.this.gBz.byB()) {
                        f.this.gBG.setVisibility(0);
                    }
                    f.this.a(officialBarTipActivity, true);
                    return;
                }
                f.this.a(officialBarTipActivity, false);
            }
        });
    }

    public void onChangeSkinType(int i) {
        this.gBz.getLayoutMode().setNightMode(i == 1);
        this.gBz.getLayoutMode().onModeChanged(this.mRootView);
        this.mNavigationBar.onChangeSkinType(this.gBz.getPageContext(), i);
        am.setNavbarTitleColor(this.dfJ, R.color.navi_op_text, R.color.navi_op_text_skin);
        am.setNavbarTitleColor(this.gBG, R.color.navi_op_text, R.color.navi_op_text_skin);
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(this.gBz.getPageContext(), i);
        }
        if (this.dvR != null) {
            this.dvR.onChangeSkinType(this.gBz.getPageContext(), i);
        }
        this.gBy.notifyDataSetChanged();
    }

    private void k(OfficialBarTipActivity officialBarTipActivity) {
        this.gBx = (BdListView) officialBarTipActivity.findViewById(R.id.msg_list);
        this.gBy = new OfficialBarTipListAdapter(officialBarTipActivity);
        this.gBx.setAdapter((ListAdapter) this.gBy);
        this.mNoDataView = NoDataViewFactory.a(officialBarTipActivity.getPageContext().getPageActivity(), this.mRootView, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA), NoDataViewFactory.d.iK(R.string.official_message_activity_no_data), null);
    }

    private void l(final OfficialBarTipActivity officialBarTipActivity) {
        this.gBB = (RelativeLayout) officialBarTipActivity.findViewById(R.id.tip_footer);
        this.gBE = (TextView) this.gBB.findViewById(R.id.delete_txt);
        this.gBE.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.officialBar.f.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                officialBarTipActivity.byy();
                f.this.a(officialBarTipActivity, false);
            }
        });
        this.gBC = (TextView) this.gBB.findViewById(R.id.select_all_txt);
        int dimens = l.getDimens(this.gBz.getPageContext().getPageActivity(), R.dimen.ds40);
        Drawable drawable = am.getDrawable(R.drawable.btn_bgb_choice_n);
        drawable.setBounds(0, 0, dimens, dimens);
        this.gBC.setText(this.gBz.getPageContext().getString(R.string.select_all));
        this.gBC.setCompoundDrawables(drawable, null, null, null);
        this.gBC.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.officialBar.f.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!f.this.gBD) {
                    f.this.lJ(true);
                } else {
                    f.this.lJ(false);
                }
            }
        });
    }

    public BdListView byE() {
        return this.gBx;
    }

    public OfficialBarTipListAdapter byF() {
        return this.gBy;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final OfficialBarTipActivity officialBarTipActivity, boolean z) {
        if (z) {
            this.gBB.setVisibility(0);
            this.gBy.lE(true);
            this.gBy.notifyDataSetChanged();
            if (officialBarTipActivity.byz()) {
                lI(true);
            } else {
                lI(false);
            }
            this.dfJ.setText(officialBarTipActivity.getPageContext().getString(R.string.cancel));
            this.gBG.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.officialBar.f.5
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    f.this.gBz.byA();
                    f.this.a(officialBarTipActivity, false);
                }
            });
            this.gBA = true;
            return;
        }
        this.gBB.setVisibility(8);
        this.gBG.setVisibility(8);
        this.gBy.lE(false);
        this.gBy.notifyDataSetChanged();
        this.dfJ.setText(officialBarTipActivity.getPageContext().getString(R.string.edit));
        this.gBA = false;
    }

    public void lI(boolean z) {
        if (z) {
            this.gBE.setAlpha(1.0f);
            this.gBE.setEnabled(true);
            return;
        }
        this.gBE.setAlpha(0.3f);
        this.gBE.setEnabled(false);
    }

    public void setData(List<ImMessageCenterShowItemData> list) {
        this.gBy.setData(list);
        if (list != null && list.size() <= 0) {
            this.dfJ.setVisibility(8);
        }
    }

    public void lJ(boolean z) {
        int dimens = l.getDimens(this.gBz.getPageContext().getPageActivity(), R.dimen.ds40);
        if (z) {
            Drawable drawable = am.getDrawable(R.drawable.btn_bgb_choice_s);
            drawable.setBounds(0, 0, dimens, dimens);
            this.gBC.setText(this.gBz.getPageContext().getString(R.string.cancel_select_all));
            this.gBC.setCompoundDrawables(drawable, null, null, null);
            lI(true);
            this.gBD = true;
            this.gBz.updateEditStatus(true);
            return;
        }
        Drawable drawable2 = am.getDrawable(R.drawable.btn_bgb_choice_n);
        drawable2.setBounds(0, 0, dimens, dimens);
        this.gBC.setText(this.gBz.getPageContext().getString(R.string.select_all));
        this.gBC.setCompoundDrawables(drawable2, null, null, null);
        lI(false);
        this.gBD = false;
        this.gBz.updateEditStatus(false);
    }
}
