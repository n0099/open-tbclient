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
    private final BdListView WV;
    private final NoNetworkView gCe;
    private View iUJ;
    private p iUK;
    private final TbPageContext<o> iUb;
    private final NavigationBar iUc;
    private final View mParent;
    private final com.baidu.tbadk.core.view.g mPullView;

    public q(TbPageContext<o> tbPageContext) {
        this.iUb = tbPageContext;
        tbPageContext.getPageActivity().setContentView(R.layout.face_purchase_records_layout);
        this.mParent = tbPageContext.getPageActivity().findViewById(R.id.purchase_record);
        this.iUc = (NavigationBar) this.mParent.findViewById(R.id.view_navigation_bar);
        this.iUc.setTitleText(tbPageContext.getResources().getString(R.string.purchase_record));
        this.iUc.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.gCe = (NoNetworkView) this.mParent.findViewById(R.id.view_no_network);
        this.WV = (BdListView) this.mParent.findViewById(R.id.purchase_record_list);
        this.mPullView = new com.baidu.tbadk.core.view.g(tbPageContext);
        this.WV.setPullRefresh(this.mPullView);
        this.iUJ = BdListViewHelper.a(this.iUb.getPageActivity(), this.WV, BdListViewHelper.HeadType.DEFAULT);
    }

    public void c(FacePurchaseRecordsData facePurchaseRecordsData) {
        if (this.iUK == null) {
            this.iUK = new p(this.iUb.getOrignalPage());
            this.WV.setAdapter((ListAdapter) this.iUK);
        }
        this.iUK.a(facePurchaseRecordsData);
        cBS();
    }

    public p cBR() {
        return this.iUK;
    }

    public void cBS() {
        this.WV.completePullRefreshPostDelayed(0L);
    }

    public void a(AdapterView.OnItemClickListener onItemClickListener) {
        this.WV.setOnItemClickListener(onItemClickListener);
    }

    public void a(f.c cVar) {
        this.mPullView.setListPullRefreshListener(cVar);
    }

    public void c(NoNetworkView.a aVar) {
        this.gCe.a(aVar);
    }

    public void qc(boolean z) {
        BdListViewHelper.a(this.iUJ, BdListViewHelper.HeadType.DEFAULT, z);
    }

    public void d(NoNetworkView.a aVar) {
        this.gCe.b(aVar);
    }

    public void onChangeSkinType(int i) {
        com.baidu.tbadk.core.c layoutMode = this.iUb.getLayoutMode();
        layoutMode.setNightMode(i == 1);
        layoutMode.onModeChanged(this.mParent);
        this.iUc.onChangeSkinType(this.iUb, i);
        this.gCe.onChangeSkinType(this.iUb, i);
        this.mPullView.changeSkin(i);
    }
}
