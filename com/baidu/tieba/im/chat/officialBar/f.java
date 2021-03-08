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
/* loaded from: classes7.dex */
public class f extends com.baidu.adp.base.d<OfficialBarTipActivity> {
    private NoNetworkView gCe;
    private TextView ghC;
    private BdListView kFM;
    private OfficialBarTipListAdapter kFN;
    private OfficialBarTipActivity kFO;
    private boolean kFP;
    private RelativeLayout kFQ;
    private TextView kFR;
    private boolean kFS;
    private TextView kFT;
    private View kFU;
    private TextView kFV;
    private NavigationBar mNavigationBar;
    private NoDataView mNoDataView;
    private ViewGroup mRootView;

    public f(OfficialBarTipActivity officialBarTipActivity) {
        super(officialBarTipActivity.getPageContext());
        this.kFP = false;
        this.kFQ = null;
        this.kFS = false;
        officialBarTipActivity.setContentView(R.layout.officialbar_msg_activity);
        this.kFO = officialBarTipActivity;
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
        this.gCe = (NoNetworkView) this.mRootView.findViewById(R.id.no_network_view);
        this.kFU = LayoutInflater.from(this.kFO.getBaseContext()).inflate(R.layout.im_ba_btn, (ViewGroup) null);
        this.kFU.setVisibility(8);
        this.kFV = (TextView) this.kFU.findViewById(R.id.all_read);
        this.kFV.setVisibility(8);
        this.ghC = (TextView) this.kFU.findViewById(R.id.edit);
        this.ghC.setVisibility(0);
        this.kFU = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.kFU, (View.OnClickListener) null);
        this.ghC.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.officialBar.f.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!f.this.kFP) {
                    if (f.this.kFO.cVo()) {
                        f.this.kFV.setVisibility(0);
                    }
                    f.this.a(officialBarTipActivity, true);
                    return;
                }
                f.this.a(officialBarTipActivity, false);
            }
        });
    }

    public void onChangeSkinType(int i) {
        this.kFO.getLayoutMode().setNightMode(i == 1);
        this.kFO.getLayoutMode().onModeChanged(this.mRootView);
        this.mNavigationBar.onChangeSkinType(this.kFO.getPageContext(), i);
        ap.setNavbarTitleColor(this.ghC, R.color.navi_op_text, R.color.navi_op_text_skin);
        ap.setNavbarTitleColor(this.kFV, R.color.navi_op_text, R.color.navi_op_text_skin);
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(this.kFO.getPageContext(), i);
        }
        if (this.gCe != null) {
            this.gCe.onChangeSkinType(this.kFO.getPageContext(), i);
        }
        this.kFN.notifyDataSetChanged();
    }

    private void k(OfficialBarTipActivity officialBarTipActivity) {
        this.kFM = (BdListView) officialBarTipActivity.findViewById(R.id.msg_list);
        this.kFN = new OfficialBarTipListAdapter(officialBarTipActivity);
        this.kFM.setAdapter((ListAdapter) this.kFN);
        this.mNoDataView = NoDataViewFactory.a(officialBarTipActivity.getPageContext().getPageActivity(), this.mRootView, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA), NoDataViewFactory.d.pA(R.string.official_message_activity_no_data), null);
    }

    private void l(final OfficialBarTipActivity officialBarTipActivity) {
        this.kFQ = (RelativeLayout) officialBarTipActivity.findViewById(R.id.tip_footer);
        this.kFT = (TextView) this.kFQ.findViewById(R.id.delete_txt);
        this.kFT.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.officialBar.f.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                officialBarTipActivity.cVl();
                f.this.a(officialBarTipActivity, false);
            }
        });
        this.kFR = (TextView) this.kFQ.findViewById(R.id.select_all_txt);
        int dimens = l.getDimens(this.kFO.getPageContext().getPageActivity(), R.dimen.ds40);
        Drawable drawable = ap.getDrawable(R.drawable.btn_bgb_choice_n);
        drawable.setBounds(0, 0, dimens, dimens);
        this.kFR.setText(this.kFO.getPageContext().getString(R.string.select_all));
        this.kFR.setCompoundDrawables(drawable, null, null, null);
        this.kFR.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.officialBar.f.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!f.this.kFS) {
                    f.this.sK(true);
                } else {
                    f.this.sK(false);
                }
            }
        });
    }

    public BdListView cVr() {
        return this.kFM;
    }

    public OfficialBarTipListAdapter cVs() {
        return this.kFN;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final OfficialBarTipActivity officialBarTipActivity, boolean z) {
        if (z) {
            this.kFQ.setVisibility(0);
            this.kFN.sF(true);
            this.kFN.notifyDataSetChanged();
            if (officialBarTipActivity.cVm()) {
                sJ(true);
            } else {
                sJ(false);
            }
            this.ghC.setText(officialBarTipActivity.getPageContext().getString(R.string.cancel));
            this.kFV.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.chat.officialBar.f.5
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    f.this.kFO.cVn();
                    f.this.a(officialBarTipActivity, false);
                }
            });
            this.kFP = true;
            return;
        }
        this.kFQ.setVisibility(8);
        this.kFV.setVisibility(8);
        this.kFN.sF(false);
        this.kFN.notifyDataSetChanged();
        this.ghC.setText(officialBarTipActivity.getPageContext().getString(R.string.edit));
        this.kFP = false;
    }

    public void sJ(boolean z) {
        if (z) {
            this.kFT.setAlpha(1.0f);
            this.kFT.setEnabled(true);
            return;
        }
        this.kFT.setAlpha(0.3f);
        this.kFT.setEnabled(false);
    }

    public void setData(List<ImMessageCenterShowItemData> list) {
        this.kFN.setData(list);
        if (list != null && list.size() <= 0) {
            this.ghC.setVisibility(8);
        }
    }

    public void sK(boolean z) {
        int dimens = l.getDimens(this.kFO.getPageContext().getPageActivity(), R.dimen.ds40);
        if (z) {
            Drawable drawable = ap.getDrawable(R.drawable.btn_bgb_choice_s);
            drawable.setBounds(0, 0, dimens, dimens);
            this.kFR.setText(this.kFO.getPageContext().getString(R.string.cancel_select_all));
            this.kFR.setCompoundDrawables(drawable, null, null, null);
            sJ(true);
            this.kFS = true;
            this.kFO.updateEditStatus(true);
            return;
        }
        Drawable drawable2 = ap.getDrawable(R.drawable.btn_bgb_choice_n);
        drawable2.setBounds(0, 0, dimens, dimens);
        this.kFR.setText(this.kFO.getPageContext().getString(R.string.select_all));
        this.kFR.setCompoundDrawables(drawable2, null, null, null);
        sJ(false);
        this.kFS = false;
        this.kFO.updateEditStatus(false);
    }
}
