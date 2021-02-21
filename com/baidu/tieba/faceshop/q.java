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
    private final NoNetworkView gAv;
    private View iVX;
    private p iVY;
    private final TbPageContext<o> iVp;
    private final NavigationBar iVq;
    private final View mParent;
    private final com.baidu.tbadk.core.view.g mPullView;

    public q(TbPageContext<o> tbPageContext) {
        this.iVp = tbPageContext;
        tbPageContext.getPageActivity().setContentView(R.layout.face_purchase_records_layout);
        this.mParent = tbPageContext.getPageActivity().findViewById(R.id.purchase_record);
        this.iVq = (NavigationBar) this.mParent.findViewById(R.id.view_navigation_bar);
        this.iVq.setTitleText(tbPageContext.getResources().getString(R.string.purchase_record));
        this.iVq.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.gAv = (NoNetworkView) this.mParent.findViewById(R.id.view_no_network);
        this.WO = (BdListView) this.mParent.findViewById(R.id.purchase_record_list);
        this.mPullView = new com.baidu.tbadk.core.view.g(tbPageContext);
        this.WO.setPullRefresh(this.mPullView);
        this.iVX = BdListViewHelper.a(this.iVp.getPageActivity(), this.WO, BdListViewHelper.HeadType.DEFAULT);
    }

    public void c(FacePurchaseRecordsData facePurchaseRecordsData) {
        if (this.iVY == null) {
            this.iVY = new p(this.iVp.getOrignalPage());
            this.WO.setAdapter((ListAdapter) this.iVY);
        }
        this.iVY.a(facePurchaseRecordsData);
        czs();
    }

    public p czr() {
        return this.iVY;
    }

    public void czs() {
        this.WO.completePullRefreshPostDelayed(0L);
    }

    public void a(AdapterView.OnItemClickListener onItemClickListener) {
        this.WO.setOnItemClickListener(onItemClickListener);
    }

    public void a(f.c cVar) {
        this.mPullView.setListPullRefreshListener(cVar);
    }

    public void c(NoNetworkView.a aVar) {
        this.gAv.a(aVar);
    }

    public void qi(boolean z) {
        BdListViewHelper.a(this.iVX, BdListViewHelper.HeadType.DEFAULT, z);
    }

    public void d(NoNetworkView.a aVar) {
        this.gAv.b(aVar);
    }

    public void onChangeSkinType(int i) {
        com.baidu.tbadk.core.c layoutMode = this.iVp.getLayoutMode();
        layoutMode.setNightMode(i == 1);
        layoutMode.onModeChanged(this.mParent);
        this.iVq.onChangeSkinType(this.iVp, i);
        this.gAv.onChangeSkinType(this.iVp, i);
        this.mPullView.changeSkin(i);
    }
}
