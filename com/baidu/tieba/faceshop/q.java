package com.baidu.tieba.faceshop;

import android.view.View;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.core.view.f;
import com.baidu.tbadk.util.BdListViewHelper;
import com.baidu.tieba.R;
/* loaded from: classes9.dex */
public class q {
    private final BdListView WO;
    private final NoNetworkView gAh;
    private View iVJ;
    private p iVK;
    private final TbPageContext<o> iVb;
    private final NavigationBar iVc;
    private final View mParent;
    private final com.baidu.tbadk.core.view.g mPullView;

    public q(TbPageContext<o> tbPageContext) {
        this.iVb = tbPageContext;
        tbPageContext.getPageActivity().setContentView(R.layout.face_purchase_records_layout);
        this.mParent = tbPageContext.getPageActivity().findViewById(R.id.purchase_record);
        this.iVc = (NavigationBar) this.mParent.findViewById(R.id.view_navigation_bar);
        this.iVc.setTitleText(tbPageContext.getResources().getString(R.string.purchase_record));
        this.iVc.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.gAh = (NoNetworkView) this.mParent.findViewById(R.id.view_no_network);
        this.WO = (BdListView) this.mParent.findViewById(R.id.purchase_record_list);
        this.mPullView = new com.baidu.tbadk.core.view.g(tbPageContext);
        this.WO.setPullRefresh(this.mPullView);
        this.iVJ = BdListViewHelper.a(this.iVb.getPageActivity(), this.WO, BdListViewHelper.HeadType.DEFAULT);
    }

    public void c(FacePurchaseRecordsData facePurchaseRecordsData) {
        if (this.iVK == null) {
            this.iVK = new p(this.iVb.getOrignalPage());
            this.WO.setAdapter((ListAdapter) this.iVK);
        }
        this.iVK.a(facePurchaseRecordsData);
        czl();
    }

    public p czk() {
        return this.iVK;
    }

    public void czl() {
        this.WO.completePullRefreshPostDelayed(0L);
    }

    public void a(AdapterView.OnItemClickListener onItemClickListener) {
        this.WO.setOnItemClickListener(onItemClickListener);
    }

    public void a(f.c cVar) {
        this.mPullView.setListPullRefreshListener(cVar);
    }

    public void c(NoNetworkView.a aVar) {
        this.gAh.a(aVar);
    }

    public void qi(boolean z) {
        BdListViewHelper.a(this.iVJ, BdListViewHelper.HeadType.DEFAULT, z);
    }

    public void d(NoNetworkView.a aVar) {
        this.gAh.b(aVar);
    }

    public void onChangeSkinType(int i) {
        com.baidu.tbadk.core.c layoutMode = this.iVb.getLayoutMode();
        layoutMode.setNightMode(i == 1);
        layoutMode.onModeChanged(this.mParent);
        this.iVc.onChangeSkinType(this.iVb, i);
        this.gAh.onChangeSkinType(this.iVb, i);
        this.mPullView.changeSkin(i);
    }
}
