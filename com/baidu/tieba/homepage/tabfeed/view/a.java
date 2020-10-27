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
import com.baidu.tieba.card.t;
import com.baidu.tieba.frs.SmartBubbleAnimatedView;
import com.baidu.tieba.frs.be;
import com.baidu.tieba.homepage.tabfeed.HomePageTabFeedFragment;
import com.baidu.tieba.homepage.tabfeed.c;
import com.baidu.tieba.play.i;
/* loaded from: classes22.dex */
public class a {
    private BdTypeRecyclerView Xe;
    private PbListView gdy;
    private BdSwipeRefreshLayout gfT;
    private SmartBubbleAnimatedView ikk;
    private i iko;
    private HomePageTabFeedFragment jBC;
    private c jCM;
    private be jCU;
    private HomePageTabFeedHeaderView jCV;
    private com.baidu.tieba.homepage.tabfeed.a jCW;
    private g mPullView;
    private ViewGroup mRootView;
    private String tabName;
    private boolean hasMore = true;
    private BdListView.e gxH = new BdListView.e() { // from class: com.baidu.tieba.homepage.tabfeed.view.a.1
        @Override // com.baidu.adp.widget.ListView.BdListView.e
        public void onScrollToBottom() {
            if (a.this.Xe != null) {
                a.this.Xe.stopScroll();
            }
            a.this.TI();
        }
    };
    private RecyclerView.OnScrollListener hKT = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.homepage.tabfeed.view.a.2
        private boolean ikt;

        @Override // android.support.v7.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i) {
            if (i == 0) {
                if (a.this.iko != null) {
                    a.this.iko.a(a.this.Xe.getFirstVisiblePosition(), a.this.Xe.getLastVisiblePosition(), this.ikt, true);
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001630, Boolean.valueOf(a.this.cqE() ? false : true)));
                t.clQ().bJQ();
            }
        }

        @Override // android.support.v7.widget.RecyclerView.OnScrollListener
        public void onScrolled(RecyclerView recyclerView, int i, int i2) {
            super.onScrolled(recyclerView, i, i2);
            if (i2 > 0) {
                this.ikt = false;
            } else {
                this.ikt = true;
            }
        }
    };
    private View.OnClickListener ikq = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.tabfeed.view.a.3
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (a.this.Xe != null) {
                a.this.Xe.stopScroll();
            }
            if (a.this.gdy != null && a.this.jCM != null && j.isNetWorkAvailable()) {
                a.this.gdy.showEmptyView(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
                a.this.gdy.setOnClickListener(null);
                if (a.this.hasMore) {
                    a.this.gdy.showLoading();
                    a.this.jCM.cqq();
                }
            }
        }
    };

    public void TI() {
        if (this.gdy != null && this.jCM != null) {
            if (j.isNetWorkAvailable()) {
                this.Xe.setNextPage(this.gdy);
                this.gdy.showEmptyView(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
                this.gdy.setOnClickListener(null);
                if (this.hasMore) {
                    this.gdy.showLoading();
                    this.jCM.cqq();
                    return;
                }
                this.gdy.setText(this.jBC.getResources().getString(R.string.list_has_no_more));
                this.gdy.endLoadData();
                return;
            }
            this.Xe.setNextPage(null);
        }
    }

    public a(HomePageTabFeedFragment homePageTabFeedFragment, c cVar, ViewGroup viewGroup, String str) {
        this.jBC = homePageTabFeedFragment;
        this.jCM = cVar;
        this.tabName = str;
        aV(viewGroup);
        this.jCW = new com.baidu.tieba.homepage.tabfeed.a(homePageTabFeedFragment, this.Xe);
        this.jCW.setTabName(str);
        kT(false);
    }

    private void aV(ViewGroup viewGroup) {
        this.mRootView = viewGroup;
        this.Xe = (BdTypeRecyclerView) viewGroup.findViewById(R.id.tab_feed_recycler_view);
        this.Xe.setLayoutManager(new LinearLayoutManager(this.jBC.getContext()));
        this.Xe.setFadingEdgeLength(0);
        this.Xe.setOverScrollMode(2);
        this.Xe.setOnSrollToBottomListener(this.gxH);
        this.Xe.addOnScrollListener(this.hKT);
        this.mPullView = new g(this.jBC.getPageContext());
        this.mPullView.setListPullRefreshListener(this.jCM);
        this.Xe.setRecyclerListener(new RecyclerView.RecyclerListener() { // from class: com.baidu.tieba.homepage.tabfeed.view.a.4
            @Override // android.support.v7.widget.RecyclerView.RecyclerListener
            public void onViewRecycled(RecyclerView.ViewHolder viewHolder) {
                View view = viewHolder.itemView;
                if (view != null && a.this.iko != null) {
                    a.this.iko.cV(view);
                }
            }
        });
        this.gdy = new PbListView(this.jBC.getPageContext().getPageActivity());
        this.gdy.getView();
        this.gdy.setContainerBackgroundColorResId(R.color.cp_bg_line_e);
        this.gdy.setHeight(l.getDimens(this.jBC.getPageContext().getPageActivity(), R.dimen.tbds182));
        this.gdy.setLineGone();
        this.gdy.setTextSize(R.dimen.tbfontsize33);
        this.gdy.setTextColor(ap.getColor(R.color.cp_cont_j));
        this.gdy.setNoMoreTextColorId(R.color.cp_cont_e);
        this.gdy.bpT();
        this.gdy.setOnClickListener(this.ikq);
        if (this.gfT == null) {
            this.gfT = (BdSwipeRefreshLayout) viewGroup.findViewById(R.id.tab_feed_pull_refresh_layout);
            this.gfT.setProgressView(this.mPullView);
        }
        this.jCU = new be();
        this.ikk = new SmartBubbleAnimatedView(this.jBC.getContext());
        this.ikk.setLayoutParams(new FrameLayout.LayoutParams(-1, l.getDimens(this.jBC.getContext(), R.dimen.tbds83)));
        if (this.iko == null) {
            this.iko = new i(this.jBC.getPageContext(), this.Xe);
            this.iko.Hh(1);
            this.iko.setUniqueId(this.jBC.getUniqueId());
        }
    }

    public void b(com.baidu.tieba.homepage.tabfeed.data.c cVar) {
        kT(false);
        if (cVar != null && this.jCW != null && this.Xe != null && this.gdy != null) {
            this.hasMore = cVar.hasMore;
            if (cVar.jCK != null || cVar.jCL != null) {
                if (this.jCV == null) {
                    this.jCV = new HomePageTabFeedHeaderView(this.jBC.getContext());
                    this.Xe.addHeaderView(this.jCV);
                }
                this.jCV.setData(cVar);
            } else if (this.jCV != null && this.jCV.getParent() != null) {
                this.Xe.removeHeaderView(this.jCV);
                this.jCV = null;
            }
            if (cVar.jAv > 0) {
                int firstVisiblePosition = this.Xe.getFirstVisiblePosition();
                View childAt = this.Xe.getChildAt(0);
                int top = childAt == null ? 0 : childAt.getTop();
                RecyclerView.LayoutManager layoutManager = this.Xe.getLayoutManager();
                int i = firstVisiblePosition - cVar.jAv;
                if (layoutManager instanceof LinearLayoutManager) {
                    this.Xe.qR();
                    ((LinearLayoutManager) layoutManager).scrollToPositionWithOffset(i, top);
                    this.Xe.qS();
                }
            }
            this.jCW.setData(cVar.jCJ);
            this.jCW.notifyDataSetChanged();
            if (this.iko != null) {
                this.iko.a(this.Xe.getFirstVisiblePosition(), this.Xe.getLastVisiblePosition(), false, true);
            }
        }
    }

    public void onDestroy() {
        if (this.iko != null) {
            this.iko.destroy();
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mPullView != null) {
            this.mPullView.changeSkin(i);
        }
        if (this.gdy != null) {
            this.gdy.setTextColor(ap.getColor(R.color.cp_cont_j));
            this.gdy.changeSkin(i);
        }
        if (this.jCV != null) {
            this.jCV.onChangeSkinType(i);
        }
        if (this.jCW != null) {
            this.jCW.notifyDataSetChanged();
        }
        if (this.ikk != null) {
            this.ikk.onChangeSkinType(i);
        }
    }

    public void resume() {
        if (this.iko != null) {
            this.iko.sO(true);
            if (this.Xe != null) {
                this.iko.a(this.Xe.getFirstVisiblePosition(), this.Xe.getLastVisiblePosition(), false, true);
            }
        }
    }

    public void pause() {
        if (this.iko != null) {
            this.iko.cXA();
            this.iko.sO(false);
        }
    }

    public void cqD() {
        if (this.Xe != null) {
            this.Xe.scrollToPosition(0);
        }
    }

    public void kT(boolean z) {
        if (this.gfT != null) {
            this.gfT.setRefreshing(z);
        }
    }

    public void oR(boolean z) {
        if (this.gfT != null) {
            this.gfT.setVisibility(z ? 0 : 8);
        }
    }

    public boolean cqE() {
        return this.Xe == null || this.Xe.getChildCount() == 0 || this.Xe.getChildAt(0).getTop() == 0;
    }
}
