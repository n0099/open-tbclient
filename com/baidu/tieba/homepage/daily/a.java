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
    private f bGG;
    private PbListView bKJ;
    private BdSwipeRefreshLayout bNu;
    private AutoBannerView ekX;
    private BdTypeRecyclerView ekY;
    private com.baidu.tieba.homepage.daily.a.a ekZ;
    private View.OnClickListener ela;
    private TbPageContext<?> mPageContext;
    private k mPullView;
    private g mRefreshView;
    private ViewGroup mRootView;
    private int mSkinType = 3;
    private d<com.baidu.tieba.homepage.daily.b.a> ecd = new d<com.baidu.tieba.homepage.daily.b.a>() { // from class: com.baidu.tieba.homepage.daily.a.1
        @Override // com.baidu.tbadk.core.flow.a.d
        public void g(int i, String str) {
            if (a.this.ekX != null) {
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
        this.bNu = (BdSwipeRefreshLayout) this.mRootView.findViewById(e.g.daily_refresh_layout);
        ((FrameLayout.LayoutParams) this.bNu.getLayoutParams()).topMargin = BdListViewHelper.a(BdListViewHelper.HeadType.DEFAULT);
        this.ekY = (BdTypeRecyclerView) this.mRootView.findViewById(e.g.daily_listview);
        this.ekY.setLayoutManager(new LinearLayoutManager(pageActivity));
        this.ekY.setFadingEdgeLength(0);
        this.ekY.setOverScrollMode(2);
        this.ekZ = new com.baidu.tieba.homepage.daily.a.a(tbPageContext, this.ekY);
        this.mPullView = new k(tbPageContext);
        this.bNu.setProgressView(this.mPullView);
        this.bKJ = new PbListView(pageActivity);
        this.bKJ.getView();
        this.bKJ.ej(e.d.cp_bg_line_e);
        this.bKJ.DV();
        this.bKJ.setTextColor(al.getColor(e.d.cp_cont_j));
        this.bKJ.setTextSize(e.C0200e.tbfontsize33);
        this.bKJ.ei(e.d.cp_cont_e);
        this.bKJ.setHeight(l.h(pageActivity, e.C0200e.tbds182));
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public View getRootView() {
        return this.mRootView;
    }

    public void a(b bVar) {
        if (bVar != null) {
            bS(bVar.aIy());
            this.ekZ.setData(bVar.getDataList());
        }
    }

    public void bS(List<com.baidu.tieba.homepage.daily.b.a> list) {
        if (this.ekY != null) {
            if (v.I(list)) {
                if (this.ekX != null) {
                    this.ekY.removeHeaderView(this.ekX);
                    this.ekX = null;
                    return;
                }
                return;
            }
            if (this.ekX == null) {
                this.ekX = new AutoBannerView(this.mPageContext.getPageActivity());
                this.ekX.setOutOnCoverViewCallback(this.ecd);
                this.ekY.addHeaderView(this.ekX, 0);
            }
            this.ekX.bT(list);
            this.ekX.Ez();
        }
    }

    public void showLoadingView() {
        h(false, this.mPageContext.getResources().getDimensionPixelSize(e.C0200e.ds520));
    }

    public void h(boolean z, int i) {
        Activity pageActivity = this.mPageContext.getPageActivity();
        if (this.bGG == null) {
            if (i < 0) {
                this.bGG = new f(pageActivity);
            } else {
                this.bGG = new f(pageActivity, i);
            }
            this.bGG.onChangeSkinType();
        }
        this.bGG.attachView(this.mRootView, z);
        this.ekY.setNextPage(null);
    }

    public void hideLoadingView() {
        if (this.bGG != null) {
            this.bGG.dettachView(this.mRootView);
            this.bGG = null;
            this.ekY.setNextPage(this.bKJ);
        }
        if (this.bNu != null) {
            this.bNu.setVisibility(0);
        }
    }

    public void showNetRefreshView(View view, String str) {
        Activity pageActivity = this.mPageContext.getPageActivity();
        if (this.mRefreshView == null) {
            this.mRefreshView = new g(pageActivity, new View.OnClickListener() { // from class: com.baidu.tieba.homepage.daily.a.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (a.this.ela != null) {
                        a.this.ela.onClick(view2);
                    }
                }
            });
        }
        this.mRefreshView.fP(pageActivity.getResources().getDimensionPixelSize(e.C0200e.ds280));
        this.mRefreshView.hV(str);
        this.mRefreshView.attachView(view, false);
        this.mRefreshView.MH();
    }

    public void ZS() {
        if (this.mRefreshView != null) {
            this.mRefreshView.dettachView(this.mRootView);
            this.mRefreshView = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void ZT() {
        this.ekY.setNextPage(this.bKJ);
        this.bKJ.el(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        this.bKJ.DY();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void ZV() {
        this.ekY.setNextPage(null);
    }

    public void ZU() {
        this.ekY.setNextPage(this.bKJ);
        this.bKJ.el(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        this.bKJ.Ea();
        this.bKJ.setText(this.mPageContext.getResources().getString(e.j.list_has_no_more));
    }

    public void aIw() {
        this.ekY.setNextPage(this.bKJ);
        this.bKJ.DZ();
        this.bKJ.el(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
    }

    public void startPullRefresh() {
        this.bNu.setRefreshing(true);
    }

    public void aIx() {
        this.bNu.setRefreshing(false);
    }

    public void reload() {
        this.ekY.setSelection(0);
        startPullRefresh();
    }

    public void ZQ() {
        this.ekZ.notifyDataSetChanged();
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            this.mSkinType = i;
            if (this.bGG != null) {
                this.bGG.onChangeSkinType();
            }
            if (this.mRefreshView != null) {
                this.mRefreshView.onChangeSkinType();
            }
            if (this.mPullView != null) {
                this.mPullView.ek(i);
            }
            if (this.bKJ != null) {
                this.bKJ.setTextColor(al.getColor(e.d.cp_cont_d));
                this.bKJ.ek(i);
            }
            if (this.ekX != null) {
                this.ekX.onChangeSkinType(i);
            }
            if (this.ekZ != null) {
                this.ekZ.onChangeSkinType(i);
            }
            al.j(this.bNu, e.d.cp_bg_line_e);
            al.j(this.ekY, e.d.cp_bg_line_d);
        }
    }

    public void a(j.b bVar) {
        if (this.mPullView != null) {
            this.mPullView.a(bVar);
        }
    }

    public void setOnSrollToBottomListener(BdListView.e eVar) {
        if (this.ekY != null) {
            this.ekY.setOnSrollToBottomListener(eVar);
        }
    }

    public void t(View.OnClickListener onClickListener) {
        this.ela = onClickListener;
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.ekZ != null) {
            this.ekZ.setPageUniqueId(bdUniqueId);
        }
        if (this.mPullView != null) {
            this.mPullView.setTag(bdUniqueId);
        }
    }

    public void onDestroy() {
        if (this.ekX != null) {
            this.ekX.EA();
        }
        this.ekY.setOnSrollToBottomListener(null);
        aIx();
    }
}
