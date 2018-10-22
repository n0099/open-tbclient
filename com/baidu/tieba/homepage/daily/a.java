package com.baidu.tieba.homepage.daily;

import android.app.Activity;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.l;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.adp.widget.refresh.BdSwipeRefreshLayout;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.flow.a.d;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.core.view.PbListView;
import com.baidu.tbadk.core.view.j;
import com.baidu.tbadk.core.view.k;
import com.baidu.tbadk.k.f;
import com.baidu.tbadk.k.g;
import com.baidu.tbadk.util.BdListViewHelper;
import com.baidu.tieba.e;
import com.baidu.tieba.homepage.daily.b.b;
import com.baidu.tieba.homepage.daily.view.AutoBannerView;
import java.util.List;
/* loaded from: classes6.dex */
public class a {
    private f bFV;
    private PbListView bJY;
    private BdSwipeRefreshLayout bMJ;
    private AutoBannerView ejD;
    private BdTypeRecyclerView ejE;
    private com.baidu.tieba.homepage.daily.a.a ejF;
    private View.OnClickListener ejG;
    private TbPageContext<?> mPageContext;
    private k mPullView;
    private g mRefreshView;
    private ViewGroup mRootView;
    private int mSkinType = 3;
    private d<com.baidu.tieba.homepage.daily.b.a> eaJ = new d<com.baidu.tieba.homepage.daily.b.a>() { // from class: com.baidu.tieba.homepage.daily.a.1
        @Override // com.baidu.tbadk.core.flow.a.d
        public void h(int i, String str) {
            if (a.this.ejD != null) {
                TiebaStatic.log(new am("c13173").x("obj_locate", i));
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tbadk.core.flow.a.d
        public void a(int i, com.baidu.tieba.homepage.daily.b.a aVar) {
            TiebaStatic.log(new am("c13174").x("obj_locate", i));
        }
    };

    public a(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
        f(this.mPageContext);
    }

    private void f(TbPageContext tbPageContext) {
        Activity pageActivity = tbPageContext.getPageActivity();
        this.mRootView = (ViewGroup) LayoutInflater.from(pageActivity).inflate(e.h.daily_page_view, (ViewGroup) null);
        this.bMJ = (BdSwipeRefreshLayout) this.mRootView.findViewById(e.g.daily_refresh_layout);
        ((FrameLayout.LayoutParams) this.bMJ.getLayoutParams()).topMargin = BdListViewHelper.a(BdListViewHelper.HeadType.DEFAULT);
        this.ejE = (BdTypeRecyclerView) this.mRootView.findViewById(e.g.daily_listview);
        this.ejE.setLayoutManager(new LinearLayoutManager(pageActivity));
        this.ejE.setFadingEdgeLength(0);
        this.ejE.setOverScrollMode(2);
        this.ejF = new com.baidu.tieba.homepage.daily.a.a(tbPageContext, this.ejE);
        this.mPullView = new k(tbPageContext);
        this.bMJ.setProgressView(this.mPullView);
        this.bJY = new PbListView(pageActivity);
        this.bJY.getView();
        this.bJY.dV(e.d.cp_bg_line_e);
        this.bJY.DL();
        this.bJY.setTextColor(al.getColor(e.d.cp_cont_j));
        this.bJY.setTextSize(e.C0175e.tbfontsize33);
        this.bJY.dU(e.d.cp_cont_e);
        this.bJY.setHeight(l.h(pageActivity, e.C0175e.tbds182));
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public View getRootView() {
        return this.mRootView;
    }

    public void a(b bVar) {
        if (bVar != null) {
            bU(bVar.aJa());
            this.ejF.setData(bVar.getDataList());
        }
    }

    public void bU(List<com.baidu.tieba.homepage.daily.b.a> list) {
        if (this.ejE != null) {
            if (v.J(list)) {
                if (this.ejD != null) {
                    this.ejE.removeHeaderView(this.ejD);
                    this.ejD = null;
                    return;
                }
                return;
            }
            if (this.ejD == null) {
                this.ejD = new AutoBannerView(this.mPageContext.getPageActivity());
                this.ejD.setOutOnCoverViewCallback(this.eaJ);
                this.ejE.addHeaderView(this.ejD, 0);
            }
            this.ejD.bV(list);
            this.ejD.Ep();
        }
    }

    public void showLoadingView() {
        h(false, this.mPageContext.getResources().getDimensionPixelSize(e.C0175e.ds520));
    }

    public void h(boolean z, int i) {
        Activity pageActivity = this.mPageContext.getPageActivity();
        if (this.bFV == null) {
            if (i < 0) {
                this.bFV = new f(pageActivity);
            } else {
                this.bFV = new f(pageActivity, i);
            }
            this.bFV.onChangeSkinType();
        }
        this.bFV.c(this.mRootView, z);
        this.ejE.setNextPage(null);
    }

    public void hideLoadingView() {
        if (this.bFV != null) {
            this.bFV.ad(this.mRootView);
            this.bFV = null;
            this.ejE.setNextPage(this.bJY);
        }
        if (this.bMJ != null) {
            this.bMJ.setVisibility(0);
        }
    }

    public void showNetRefreshView(View view, String str) {
        Activity pageActivity = this.mPageContext.getPageActivity();
        if (this.mRefreshView == null) {
            this.mRefreshView = new g(pageActivity, new View.OnClickListener() { // from class: com.baidu.tieba.homepage.daily.a.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (a.this.ejG != null) {
                        a.this.ejG.onClick(view2);
                    }
                }
            });
        }
        this.mRefreshView.fB(pageActivity.getResources().getDimensionPixelSize(e.C0175e.ds280));
        this.mRefreshView.hU(str);
        this.mRefreshView.c(view, false);
        this.mRefreshView.My();
    }

    public void ZI() {
        if (this.mRefreshView != null) {
            this.mRefreshView.ad(this.mRootView);
            this.mRefreshView = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void ZJ() {
        this.ejE.setNextPage(this.bJY);
        this.bJY.dX(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        this.bJY.DO();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void ZL() {
        this.ejE.setNextPage(null);
    }

    public void ZK() {
        this.ejE.setNextPage(this.bJY);
        this.bJY.dX(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        this.bJY.DQ();
        this.bJY.setText(this.mPageContext.getResources().getString(e.j.list_has_no_more));
    }

    public void aIY() {
        this.ejE.setNextPage(this.bJY);
        this.bJY.DP();
        this.bJY.dX(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
    }

    public void startPullRefresh() {
        this.bMJ.setRefreshing(true);
    }

    public void aIZ() {
        this.bMJ.setRefreshing(false);
    }

    public void reload() {
        this.ejE.setSelection(0);
        startPullRefresh();
    }

    public void ZG() {
        this.ejF.notifyDataSetChanged();
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            this.mSkinType = i;
            if (this.bFV != null) {
                this.bFV.onChangeSkinType();
            }
            if (this.mRefreshView != null) {
                this.mRefreshView.onChangeSkinType();
            }
            if (this.mPullView != null) {
                this.mPullView.dW(i);
            }
            if (this.bJY != null) {
                this.bJY.setTextColor(al.getColor(e.d.cp_cont_d));
                this.bJY.dW(i);
            }
            if (this.ejD != null) {
                this.ejD.onChangeSkinType(i);
            }
            if (this.ejF != null) {
                this.ejF.onChangeSkinType(i);
            }
            al.j(this.bMJ, e.d.cp_bg_line_e);
            al.j(this.ejE, e.d.cp_bg_line_d);
        }
    }

    public void a(j.b bVar) {
        if (this.mPullView != null) {
            this.mPullView.a(bVar);
        }
    }

    public void setOnSrollToBottomListener(BdListView.e eVar) {
        if (this.ejE != null) {
            this.ejE.setOnSrollToBottomListener(eVar);
        }
    }

    public void r(View.OnClickListener onClickListener) {
        this.ejG = onClickListener;
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.ejF != null) {
            this.ejF.setPageUniqueId(bdUniqueId);
        }
        if (this.mPullView != null) {
            this.mPullView.setTag(bdUniqueId);
        }
    }

    public void onDestroy() {
        if (this.ejD != null) {
            this.ejD.Eq();
        }
        this.ejE.setOnSrollToBottomListener(null);
        aIZ();
    }
}
