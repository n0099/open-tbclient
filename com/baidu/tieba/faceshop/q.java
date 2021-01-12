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
/* loaded from: classes8.dex */
public class q {
    private final BdListView WT;
    private final NoNetworkView gxx;
    private final TbPageContext<o> iPu;
    private final NavigationBar iPv;
    private View iQc;
    private p iQd;
    private final View mParent;
    private final com.baidu.tbadk.core.view.g mPullView;

    public q(TbPageContext<o> tbPageContext) {
        this.iPu = tbPageContext;
        tbPageContext.getPageActivity().setContentView(R.layout.face_purchase_records_layout);
        this.mParent = tbPageContext.getPageActivity().findViewById(R.id.purchase_record);
        this.iPv = (NavigationBar) this.mParent.findViewById(R.id.view_navigation_bar);
        this.iPv.setTitleText(tbPageContext.getResources().getString(R.string.purchase_record));
        this.iPv.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.gxx = (NoNetworkView) this.mParent.findViewById(R.id.view_no_network);
        this.WT = (BdListView) this.mParent.findViewById(R.id.purchase_record_list);
        this.mPullView = new com.baidu.tbadk.core.view.g(tbPageContext);
        this.WT.setPullRefresh(this.mPullView);
        this.iQc = BdListViewHelper.a(this.iPu.getPageActivity(), this.WT, BdListViewHelper.HeadType.DEFAULT);
    }

    public void c(FacePurchaseRecordsData facePurchaseRecordsData) {
        if (this.iQd == null) {
            this.iQd = new p(this.iPu.getOrignalPage());
            this.WT.setAdapter((ListAdapter) this.iQd);
        }
        this.iQd.a(facePurchaseRecordsData);
        cya();
    }

    public p cxZ() {
        return this.iQd;
    }

    public void cya() {
        this.WT.completePullRefreshPostDelayed(0L);
    }

    public void a(AdapterView.OnItemClickListener onItemClickListener) {
        this.WT.setOnItemClickListener(onItemClickListener);
    }

    public void a(f.c cVar) {
        this.mPullView.setListPullRefreshListener(cVar);
    }

    public void c(NoNetworkView.a aVar) {
        this.gxx.a(aVar);
    }

    public void pY(boolean z) {
        BdListViewHelper.a(this.iQc, BdListViewHelper.HeadType.DEFAULT, z);
    }

    public void d(NoNetworkView.a aVar) {
        this.gxx.b(aVar);
    }

    public void onChangeSkinType(int i) {
        com.baidu.tbadk.core.c layoutMode = this.iPu.getLayoutMode();
        layoutMode.setNightMode(i == 1);
        layoutMode.onModeChanged(this.mParent);
        this.iPv.onChangeSkinType(this.iPu, i);
        this.gxx.onChangeSkinType(this.iPu, i);
        this.mPullView.changeSkin(i);
    }
}
