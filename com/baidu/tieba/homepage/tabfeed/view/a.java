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
    private PbListView fEa;
    private BdSwipeRefreshLayout fGm;
    private SmartBubbleAnimatedView hBN;
    private i hBR;
    private HomePageTabFeedFragment iRx;
    private c iSH;
    private be iSP;
    private HomePageTabFeedHeaderView iSQ;
    private com.baidu.tieba.homepage.tabfeed.a iSR;
    private g mPullView;
    private ViewGroup mRootView;
    private String tabName;
    private boolean hasMore = true;
    private BdListView.e fXX = new BdListView.e() { // from class: com.baidu.tieba.homepage.tabfeed.view.a.1
        @Override // com.baidu.adp.widget.ListView.BdListView.e
        public void onScrollToBottom() {
            if (a.this.Wu != null) {
                a.this.Wu.stopScroll();
            }
            a.this.bGS();
        }
    };
    private RecyclerView.OnScrollListener hcD = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.homepage.tabfeed.view.a.2
        private boolean hBW;

        @Override // android.support.v7.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i) {
            if (i == 0) {
                if (a.this.hBR != null) {
                    a.this.hBR.a(a.this.Wu.getFirstVisiblePosition(), a.this.Wu.getLastVisiblePosition(), this.hBW, true);
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001630, Boolean.valueOf(a.this.cgM() ? false : true)));
                s.cbY().bDW();
            }
        }

        @Override // android.support.v7.widget.RecyclerView.OnScrollListener
        public void onScrolled(RecyclerView recyclerView, int i, int i2) {
            super.onScrolled(recyclerView, i, i2);
            if (i2 > 0) {
                this.hBW = false;
            } else {
                this.hBW = true;
            }
        }
    };
    private View.OnClickListener hBT = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.tabfeed.view.a.3
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (a.this.Wu != null) {
                a.this.Wu.stopScroll();
            }
            if (a.this.fEa != null && a.this.iSH != null && j.isNetWorkAvailable()) {
                a.this.fEa.showEmptyView(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
                a.this.fEa.setOnClickListener(null);
                if (a.this.hasMore) {
                    a.this.fEa.showLoading();
                    a.this.iSH.cgy();
                }
            }
        }
    };

    public void bGS() {
        if (this.fEa != null && this.iSH != null) {
            if (j.isNetWorkAvailable()) {
                this.Wu.setNextPage(this.fEa);
                this.fEa.showEmptyView(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
                this.fEa.setOnClickListener(null);
                if (this.hasMore) {
                    this.fEa.showLoading();
                    this.iSH.cgy();
                    return;
                }
                this.fEa.setText(this.iRx.getResources().getString(R.string.list_has_no_more));
                this.fEa.endLoadData();
                return;
            }
            this.Wu.setNextPage(null);
        }
    }

    public a(HomePageTabFeedFragment homePageTabFeedFragment, c cVar, ViewGroup viewGroup, String str) {
        this.iRx = homePageTabFeedFragment;
        this.iSH = cVar;
        this.tabName = str;
        aS(viewGroup);
        this.iSR = new com.baidu.tieba.homepage.tabfeed.a(homePageTabFeedFragment, this.Wu);
        this.iSR.setTabName(str);
        kh(false);
    }

    private void aS(ViewGroup viewGroup) {
        this.mRootView = viewGroup;
        this.Wu = (BdTypeRecyclerView) viewGroup.findViewById(R.id.tab_feed_recycler_view);
        this.Wu.setLayoutManager(new LinearLayoutManager(this.iRx.getContext()));
        this.Wu.setFadingEdgeLength(0);
        this.Wu.setOverScrollMode(2);
        this.Wu.setOnSrollToBottomListener(this.fXX);
        this.Wu.addOnScrollListener(this.hcD);
        this.mPullView = new g(this.iRx.getPageContext());
        this.mPullView.setListPullRefreshListener(this.iSH);
        this.Wu.setRecyclerListener(new RecyclerView.RecyclerListener() { // from class: com.baidu.tieba.homepage.tabfeed.view.a.4
            @Override // android.support.v7.widget.RecyclerView.RecyclerListener
            public void onViewRecycled(RecyclerView.ViewHolder viewHolder) {
                View view = viewHolder.itemView;
                if (view != null && a.this.hBR != null) {
                    a.this.hBR.cE(view);
                }
            }
        });
        this.fEa = new PbListView(this.iRx.getPageContext().getPageActivity());
        this.fEa.getView();
        this.fEa.setContainerBackgroundColorResId(R.color.cp_bg_line_e);
        this.fEa.setHeight(l.getDimens(this.iRx.getPageContext().getPageActivity(), R.dimen.tbds182));
        this.fEa.setLineGone();
        this.fEa.setTextSize(R.dimen.tbfontsize33);
        this.fEa.setTextColor(ap.getColor(R.color.cp_cont_j));
        this.fEa.setNoMoreTextColorId(R.color.cp_cont_e);
        this.fEa.bkv();
        this.fEa.setOnClickListener(this.hBT);
        if (this.fGm == null) {
            this.fGm = (BdSwipeRefreshLayout) viewGroup.findViewById(R.id.tab_feed_pull_refresh_layout);
            this.fGm.setProgressView(this.mPullView);
        }
        this.iSP = new be();
        this.hBN = new SmartBubbleAnimatedView(this.iRx.getContext());
        this.hBN.setLayoutParams(new FrameLayout.LayoutParams(-1, l.getDimens(this.iRx.getContext(), R.dimen.tbds83)));
        if (this.hBR == null) {
            this.hBR = new i(this.iRx.getPageContext(), this.Wu);
            this.hBR.FH(1);
            this.hBR.setUniqueId(this.iRx.getUniqueId());
        }
    }

    public void b(com.baidu.tieba.homepage.tabfeed.data.c cVar) {
        kh(false);
        if (cVar != null && this.iSR != null && this.Wu != null && this.fEa != null) {
            this.hasMore = cVar.hasMore;
            if (cVar.iSF != null || cVar.iSG != null) {
                if (this.iSQ == null) {
                    this.iSQ = new HomePageTabFeedHeaderView(this.iRx.getContext());
                    this.Wu.addHeaderView(this.iSQ);
                }
                this.iSQ.setData(cVar);
            } else if (this.iSQ != null && this.iSQ.getParent() != null) {
                this.Wu.removeHeaderView(this.iSQ);
                this.iSQ = null;
            }
            if (cVar.iQq > 0) {
                int firstVisiblePosition = this.Wu.getFirstVisiblePosition();
                View childAt = this.Wu.getChildAt(0);
                int top = childAt == null ? 0 : childAt.getTop();
                RecyclerView.LayoutManager layoutManager = this.Wu.getLayoutManager();
                int i = firstVisiblePosition - cVar.iQq;
                if (layoutManager instanceof LinearLayoutManager) {
                    this.Wu.qM();
                    ((LinearLayoutManager) layoutManager).scrollToPositionWithOffset(i, top);
                    this.Wu.qN();
                }
            }
            this.iSR.setData(cVar.iSE);
            this.iSR.notifyDataSetChanged();
            if (this.hBR != null) {
                this.hBR.a(this.Wu.getFirstVisiblePosition(), this.Wu.getLastVisiblePosition(), false, true);
            }
        }
    }

    public void onDestroy() {
        if (this.hBR != null) {
            this.hBR.destroy();
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mPullView != null) {
            this.mPullView.changeSkin(i);
        }
        if (this.fEa != null) {
            this.fEa.setTextColor(ap.getColor(R.color.cp_cont_j));
            this.fEa.changeSkin(i);
        }
        if (this.iSQ != null) {
            this.iSQ.onChangeSkinType(i);
        }
        if (this.iSR != null) {
            this.iSR.notifyDataSetChanged();
        }
        if (this.hBN != null) {
            this.hBN.onChangeSkinType(i);
        }
    }

    public void resume() {
        if (this.hBR != null) {
            this.hBR.rH(true);
            if (this.Wu != null) {
                this.hBR.a(this.Wu.getFirstVisiblePosition(), this.Wu.getLastVisiblePosition(), false, true);
            }
        }
    }

    public void pause() {
        if (this.hBR != null) {
            this.hBR.cNe();
            this.hBR.rH(false);
        }
    }

    public void cgL() {
        if (this.Wu != null) {
            this.Wu.scrollToPosition(0);
        }
    }

    public void kh(boolean z) {
        if (this.fGm != null) {
            this.fGm.setRefreshing(z);
        }
    }

    public void nO(boolean z) {
        if (this.fGm != null) {
            this.fGm.setVisibility(z ? 0 : 8);
        }
    }

    public boolean cgM() {
        return this.Wu == null || this.Wu.getChildCount() == 0 || this.Wu.getChildAt(0).getTop() == 0;
    }
}
