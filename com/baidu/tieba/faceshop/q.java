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
    private final BdListView Yj;
    private final NoNetworkView gCe;
    private final TbPageContext<o> iWY;
    private final NavigationBar iWZ;
    private View iXG;
    private p iXH;
    private final View mParent;
    private final com.baidu.tbadk.core.view.g mPullView;

    public q(TbPageContext<o> tbPageContext) {
        this.iWY = tbPageContext;
        tbPageContext.getPageActivity().setContentView(R.layout.face_purchase_records_layout);
        this.mParent = tbPageContext.getPageActivity().findViewById(R.id.purchase_record);
        this.iWZ = (NavigationBar) this.mParent.findViewById(R.id.view_navigation_bar);
        this.iWZ.setTitleText(tbPageContext.getResources().getString(R.string.purchase_record));
        this.iWZ.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.gCe = (NoNetworkView) this.mParent.findViewById(R.id.view_no_network);
        this.Yj = (BdListView) this.mParent.findViewById(R.id.purchase_record_list);
        this.mPullView = new com.baidu.tbadk.core.view.g(tbPageContext);
        this.Yj.setPullRefresh(this.mPullView);
        this.iXG = BdListViewHelper.a(this.iWY.getPageActivity(), this.Yj, BdListViewHelper.HeadType.DEFAULT);
    }

    public void c(FacePurchaseRecordsData facePurchaseRecordsData) {
        if (this.iXH == null) {
            this.iXH = new p(this.iWY.getOrignalPage());
            this.Yj.setAdapter((ListAdapter) this.iXH);
        }
        this.iXH.a(facePurchaseRecordsData);
        czy();
    }

    public p czx() {
        return this.iXH;
    }

    public void czy() {
        this.Yj.completePullRefreshPostDelayed(0L);
    }

    public void a(AdapterView.OnItemClickListener onItemClickListener) {
        this.Yj.setOnItemClickListener(onItemClickListener);
    }

    public void a(f.c cVar) {
        this.mPullView.setListPullRefreshListener(cVar);
    }

    public void c(NoNetworkView.a aVar) {
        this.gCe.a(aVar);
    }

    public void qi(boolean z) {
        BdListViewHelper.a(this.iXG, BdListViewHelper.HeadType.DEFAULT, z);
    }

    public void d(NoNetworkView.a aVar) {
        this.gCe.b(aVar);
    }

    public void onChangeSkinType(int i) {
        com.baidu.tbadk.core.c layoutMode = this.iWY.getLayoutMode();
        layoutMode.setNightMode(i == 1);
        layoutMode.onModeChanged(this.mParent);
        this.iWZ.onChangeSkinType(this.iWY, i);
        this.gCe.onChangeSkinType(this.iWY, i);
        this.mPullView.changeSkin(i);
    }
}
