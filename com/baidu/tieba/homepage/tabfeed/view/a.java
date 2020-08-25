package com.baidu.tieba.homepage.tabfeed.view;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.j;
import com.baidu.adp.lib.util.l;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.adp.widget.refresh.BdSwipeRefreshLayout;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.view.PbListView;
import com.baidu.tbadk.core.view.g;
import com.baidu.tieba.R;
import com.baidu.tieba.card.s;
import com.baidu.tieba.frs.SmartBubbleAnimatedView;
import com.baidu.tieba.frs.be;
import com.baidu.tieba.homepage.tabfeed.HomePageTabFeedFragment;
import com.baidu.tieba.homepage.tabfeed.c;
import com.baidu.tieba.play.i;
/* loaded from: classes16.dex */
public class a {
    private BdTypeRecyclerView Wu;
    private PbListView fDW;
    private BdSwipeRefreshLayout fGi;
    private SmartBubbleAnimatedView hBH;
    private i hBL;
    private HomePageTabFeedFragment iRr;
    private c iSB;
    private be iSJ;
    private HomePageTabFeedHeaderView iSK;
    private com.baidu.tieba.homepage.tabfeed.a iSL;
    private g mPullView;
    private ViewGroup mRootView;
    private String tabName;
    private boolean hasMore = true;
    private BdListView.e fXT = new BdListView.e() { // from class: com.baidu.tieba.homepage.tabfeed.view.a.1
        @Override // com.baidu.adp.widget.ListView.BdListView.e
        public void onScrollToBottom() {
            if (a.this.Wu != null) {
                a.this.Wu.stopScroll();
            }
            a.this.bGR();
        }
    };
    private RecyclerView.OnScrollListener hcz = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.homepage.tabfeed.view.a.2
        private boolean hBQ;

        @Override // android.support.v7.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i) {
            if (i == 0) {
                if (a.this.hBL != null) {
                    a.this.hBL.a(a.this.Wu.getFirstVisiblePosition(), a.this.Wu.getLastVisiblePosition(), this.hBQ, true);
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001630, Boolean.valueOf(a.this.cgL() ? false : true)));
                s.cbX().bDV();
            }
        }

        @Override // android.support.v7.widget.RecyclerView.OnScrollListener
        public void onScrolled(RecyclerView recyclerView, int i, int i2) {
            super.onScrolled(recyclerView, i, i2);
            if (i2 > 0) {
                this.hBQ = false;
            } else {
                this.hBQ = true;
            }
        }
    };
    private View.OnClickListener hBN = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.tabfeed.view.a.3
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (a.this.Wu != null) {
                a.this.Wu.stopScroll();
            }
            if (a.this.fDW != null && a.this.iSB != null && j.isNetWorkAvailable()) {
                a.this.fDW.showEmptyView(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
                a.this.fDW.setOnClickListener(null);
                if (a.this.hasMore) {
                    a.this.fDW.showLoading();
                    a.this.iSB.cgx();
                }
            }
        }
    };

    public void bGR() {
        if (this.fDW != null && this.iSB != null) {
            if (j.isNetWorkAvailable()) {
                this.Wu.setNextPage(this.fDW);
                this.fDW.showEmptyView(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
                this.fDW.setOnClickListener(null);
                if (this.hasMore) {
                    this.fDW.showLoading();
                    this.iSB.cgx();
                    return;
                }
                this.fDW.setText(this.iRr.getResources().getString(R.string.list_has_no_more));
                this.fDW.endLoadData();
                return;
            }
            this.Wu.setNextPage(null);
        }
    }

    public a(HomePageTabFeedFragment homePageTabFeedFragment, c cVar, ViewGroup viewGroup, String str) {
        this.iRr = homePageTabFeedFragment;
        this.iSB = cVar;
        this.tabName = str;
        aS(viewGroup);
        this.iSL = new com.baidu.tieba.homepage.tabfeed.a(homePageTabFeedFragment, this.Wu);
        this.iSL.setTabName(str);
        kf(false);
    }

    private void aS(ViewGroup viewGroup) {
        this.mRootView = viewGroup;
        this.Wu = (BdTypeRecyclerView) viewGroup.findViewById(R.id.tab_feed_recycler_view);
        this.Wu.setLayoutManager(new LinearLayoutManager(this.iRr.getContext()));
        this.Wu.setFadingEdgeLength(0);
        this.Wu.setOverScrollMode(2);
        this.Wu.setOnSrollToBottomListener(this.fXT);
        this.Wu.addOnScrollListener(this.hcz);
        this.mPullView = new g(this.iRr.getPageContext());
        this.mPullView.setListPullRefreshListener(this.iSB);
        this.Wu.setRecyclerListener(new RecyclerView.RecyclerListener() { // from class: com.baidu.tieba.homepage.tabfeed.view.a.4
            @Override // android.support.v7.widget.RecyclerView.RecyclerListener
            public void onViewRecycled(RecyclerView.ViewHolder viewHolder) {
                View view = viewHolder.itemView;
                if (view != null && a.this.hBL != null) {
                    a.this.hBL.cE(view);
                }
            }
        });
        this.fDW = new PbListView(this.iRr.getPageContext().getPageActivity());
        this.fDW.getView();
        this.fDW.setContainerBackgroundColorResId(R.color.cp_bg_line_e);
        this.fDW.setHeight(l.getDimens(this.iRr.getPageContext().getPageActivity(), R.dimen.tbds182));
        this.fDW.setLineGone();
        this.fDW.setTextSize(R.dimen.tbfontsize33);
        this.fDW.setTextColor(ap.getColor(R.color.cp_cont_j));
        this.fDW.setNoMoreTextColorId(R.color.cp_cont_e);
        this.fDW.bkv();
        this.fDW.setOnClickListener(this.hBN);
        if (this.fGi == null) {
            this.fGi = (BdSwipeRefreshLayout) viewGroup.findViewById(R.id.tab_feed_pull_refresh_layout);
            this.fGi.setProgressView(this.mPullView);
        }
        this.iSJ = new be();
        this.hBH = new SmartBubbleAnimatedView(this.iRr.getContext());
        this.hBH.setLayoutParams(new FrameLayout.LayoutParams(-1, l.getDimens(this.iRr.getContext(), R.dimen.tbds83)));
        if (this.hBL == null) {
            this.hBL = new i(this.iRr.getPageContext(), this.Wu);
            this.hBL.FH(1);
            this.hBL.setUniqueId(this.iRr.getUniqueId());
        }
    }

    public void b(com.baidu.tieba.homepage.tabfeed.data.c cVar) {
        kf(false);
        if (cVar != null && this.iSL != null && this.Wu != null && this.fDW != null) {
            this.hasMore = cVar.hasMore;
            if (cVar.iSz != null || cVar.iSA != null) {
                if (this.iSK == null) {
                    this.iSK = new HomePageTabFeedHeaderView(this.iRr.getContext());
                    this.Wu.addHeaderView(this.iSK);
                }
                this.iSK.setData(cVar);
            } else if (this.iSK != null && this.iSK.getParent() != null) {
                this.Wu.removeHeaderView(this.iSK);
                this.iSK = null;
            }
            if (cVar.iQk > 0) {
                int firstVisiblePosition = this.Wu.getFirstVisiblePosition();
                View childAt = this.Wu.getChildAt(0);
                int top = childAt == null ? 0 : childAt.getTop();
                RecyclerView.LayoutManager layoutManager = this.Wu.getLayoutManager();
                int i = firstVisiblePosition - cVar.iQk;
                if (layoutManager instanceof LinearLayoutManager) {
                    this.Wu.qM();
                    ((LinearLayoutManager) layoutManager).scrollToPositionWithOffset(i, top);
                    this.Wu.qN();
                }
            }
            this.iSL.setData(cVar.iSy);
            this.iSL.notifyDataSetChanged();
            if (this.hBL != null) {
                this.hBL.a(this.Wu.getFirstVisiblePosition(), this.Wu.getLastVisiblePosition(), false, true);
            }
        }
    }

    public void onDestroy() {
        if (this.hBL != null) {
            this.hBL.destroy();
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mPullView != null) {
            this.mPullView.changeSkin(i);
        }
        if (this.fDW != null) {
            this.fDW.setTextColor(ap.getColor(R.color.cp_cont_j));
            this.fDW.changeSkin(i);
        }
        if (this.iSK != null) {
            this.iSK.onChangeSkinType(i);
        }
        if (this.iSL != null) {
            this.iSL.notifyDataSetChanged();
        }
        if (this.hBH != null) {
            this.hBH.onChangeSkinType(i);
        }
    }

    public void resume() {
        if (this.hBL != null) {
            this.hBL.rF(true);
            if (this.Wu != null) {
                this.hBL.a(this.Wu.getFirstVisiblePosition(), this.Wu.getLastVisiblePosition(), false, true);
            }
        }
    }

    public void pause() {
        if (this.hBL != null) {
            this.hBL.cNd();
            this.hBL.rF(false);
        }
    }

    public void cgK() {
        if (this.Wu != null) {
            this.Wu.scrollToPosition(0);
        }
    }

    public void kf(boolean z) {
        if (this.fGi != null) {
            this.fGi.setRefreshing(z);
        }
    }

    public void nM(boolean z) {
        if (this.fGi != null) {
            this.fGi.setVisibility(z ? 0 : 8);
        }
    }

    public boolean cgL() {
        return this.Wu == null || this.Wu.getChildCount() == 0 || this.Wu.getChildAt(0).getTop() == 0;
    }
}
