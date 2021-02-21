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
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoDataView;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tieba.R;
import java.util.List;
/* loaded from: classes8.dex */
public class f extends com.baidu.adp.base.d<OfficialBarTipActivity> {
    private NoNetworkView gAv;
    private TextView gfZ;
    private BdListView kDK;
    private OfficialBarTipListAdapter kDL;
    private OfficialBarTipActivity kDM;
    private boolean kDN;
    private RelativeLayout kDO;
    private TextView kDP;
    private boolean kDQ;
    private TextView kDR;
    private View kDS;
    private TextView kDT;
    private NavigationBar mNavigationBar;
    private NoDataView mNoDataView;
    private ViewGroup mRootView;

    public f(OfficialBarTipActivity officialBarTipActivity) {
        super(officialBarTipActivity.getPageContext());
        this.kDN = false;
        this.kDO = null;
        this.kDQ = false;
        officialBarTipActivity.setContentView(R.layout.officialbar_msg_activity);
        this.kDM = officialBarTipActivity;
        j(officialBarTipActivity);
        k(officialBarTipActivity);
        l(officialBarTipActivity);
    }

    private void j(final OfficialBarTipActivity officialBarTipActivity) {
        this.mNavigationBar = (NavigationBar) officialBarTipActivity.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.setCenterTextTitle(officialBarTipActivity.getPageContext().getString(R.string.subscribe_forum_list));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.officialBar.f.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                officialBarTipActivity.finish();
            }
        });
        this.mNavigationBar.showBottomLine();
        this.mRootView = (ViewGroup) officialBarTipActivity.findViewById(R.id.root_view);
        this.gAv = (NoNetworkView) this.mRootView.findViewById(R.id.no_network_view);
        this.kDS = LayoutInflater.from(this.kDM.getBaseContext()).inflate(R.layout.im_ba_btn, (ViewGroup) null);
        this.kDS.setVisibility(8);
        this.kDT = (TextView) this.kDS.findViewById(R.id.all_read);
        this.kDT.setVisibility(8);
        this.gfZ = (TextView) this.kDS.findViewById(R.id.edit);
        this.gfZ.setVisibility(0);
        this.kDS = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.kDS, (View.OnClickListener) null);
        this.gfZ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.officialBar.f.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!f.this.kDN) {
                    if (f.this.kDM.cVh()) {
                        f.this.kDT.setVisibility(0);
                    }
                    f.this.a(officialBarTipActivity, true);
                    return;
                }
                f.this.a(officialBarTipActivity, false);
            }
        });
    }

    public void onChangeSkinType(int i) {
        this.kDM.getLayoutMode().setNightMode(i == 1);
        this.kDM.getLayoutMode().onModeChanged(this.mRootView);
        this.mNavigationBar.onChangeSkinType(this.kDM.getPageContext(), i);
        ap.setNavbarTitleColor(this.gfZ, R.color.navi_op_text, R.color.navi_op_text_skin);
        ap.setNavbarTitleColor(this.kDT, R.color.navi_op_text, R.color.navi_op_text_skin);
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(this.kDM.getPageContext(), i);
        }
        if (this.gAv != null) {
            this.gAv.onChangeSkinType(this.kDM.getPageContext(), i);
        }
        this.kDL.notifyDataSetChanged();
    }

    private void k(OfficialBarTipActivity officialBarTipActivity) {
        this.kDK = (BdListView) officialBarTipActivity.findViewById(R.id.msg_list);
        this.kDL = new OfficialBarTipListAdapter(officialBarTipActivity);
        this.kDK.setAdapter((ListAdapter) this.kDL);
        this.mNoDataView = NoDataViewFactory.a(officialBarTipActivity.getPageContext().getPageActivity(), this.mRootView, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA), NoDataViewFactory.d.pz(R.string.official_message_activity_no_data), null);
    }

    private void l(final OfficialBarTipActivity officialBarTipActivity) {
        this.kDO = (RelativeLayout) officialBarTipActivity.findViewById(R.id.tip_footer);
        this.kDR = (TextView) this.kDO.findViewById(R.id.delete_txt);
        this.kDR.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.officialBar.f.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                officialBarTipActivity.cVe();
                f.this.a(officialBarTipActivity, false);
            }
        });
        this.kDP = (TextView) this.kDO.findViewById(R.id.select_all_txt);
        int dimens = l.getDimens(this.kDM.getPageContext().getPageActivity(), R.dimen.ds40);
        Drawable drawable = ap.getDrawable(R.drawable.btn_bgb_choice_n);
        drawable.setBounds(0, 0, dimens, dimens);
        this.kDP.setText(this.kDM.getPageContext().getString(R.string.select_all));
        this.kDP.setCompoundDrawables(drawable, null, null, null);
        this.kDP.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.officialBar.f.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!f.this.kDQ) {
                    f.this.sK(true);
                } else {
                    f.this.sK(false);
                }
            }
        });
    }

    public BdListView cVk() {
        return this.kDK;
    }

    public OfficialBarTipListAdapter cVl() {
        return this.kDL;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final OfficialBarTipActivity officialBarTipActivity, boolean z) {
        if (z) {
            this.kDO.setVisibility(0);
            this.kDL.sF(true);
            this.kDL.notifyDataSetChanged();
            if (officialBarTipActivity.cVf()) {
                sJ(true);
            } else {
                sJ(false);
            }
            this.gfZ.setText(officialBarTipActivity.getPageContext().getString(R.string.cancel));
            this.kDT.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.officialBar.f.5
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    f.this.kDM.cVg();
                    f.this.a(officialBarTipActivity, false);
                }
            });
            this.kDN = true;
            return;
        }
        this.kDO.setVisibility(8);
        this.kDT.setVisibility(8);
        this.kDL.sF(false);
        this.kDL.notifyDataSetChanged();
        this.gfZ.setText(officialBarTipActivity.getPageContext().getString(R.string.edit));
        this.kDN = false;
    }

    public void sJ(boolean z) {
        if (z) {
            this.kDR.setAlpha(1.0f);
            this.kDR.setEnabled(true);
            return;
        }
        this.kDR.setAlpha(0.3f);
        this.kDR.setEnabled(false);
    }

    public void setData(List<ImMessageCenterShowItemData> list) {
        this.kDL.setData(list);
        if (list != null && list.size() <= 0) {
            this.gfZ.setVisibility(8);
        }
    }

    public void sK(boolean z) {
        int dimens = l.getDimens(this.kDM.getPageContext().getPageActivity(), R.dimen.ds40);
        if (z) {
            Drawable drawable = ap.getDrawable(R.drawable.btn_bgb_choice_s);
            drawable.setBounds(0, 0, dimens, dimens);
            this.kDP.setText(this.kDM.getPageContext().getString(R.string.cancel_select_all));
            this.kDP.setCompoundDrawables(drawable, null, null, null);
            sJ(true);
            this.kDQ = true;
            this.kDM.updateEditStatus(true);
            return;
        }
        Drawable drawable2 = ap.getDrawable(R.drawable.btn_bgb_choice_n);
        drawable2.setBounds(0, 0, dimens, dimens);
        this.kDP.setText(this.kDM.getPageContext().getString(R.string.select_all));
        this.kDP.setCompoundDrawables(drawable2, null, null, null);
        sJ(false);
        this.kDQ = false;
        this.kDM.updateEditStatus(false);
    }
}
