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
/* loaded from: classes22.dex */
public class a {
    private BdTypeRecyclerView Xc;
    private PbListView fTv;
    private BdSwipeRefreshLayout fVP;
    private SmartBubbleAnimatedView hXK;
    private i hXO;
    private HomePageTabFeedFragment jpc;
    private c jqm;
    private be jqu;
    private HomePageTabFeedHeaderView jqv;
    private com.baidu.tieba.homepage.tabfeed.a jqw;
    private g mPullView;
    private ViewGroup mRootView;
    private String tabName;
    private boolean hasMore = true;
    private BdListView.e gnC = new BdListView.e() { // from class: com.baidu.tieba.homepage.tabfeed.view.a.1
        @Override // com.baidu.adp.widget.ListView.BdListView.e
        public void onScrollToBottom() {
            if (a.this.Xc != null) {
                a.this.Xc.stopScroll();
            }
            a.this.SI();
        }
    };
    private RecyclerView.OnScrollListener hyx = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.homepage.tabfeed.view.a.2
        private boolean hXT;

        @Override // android.support.v7.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i) {
            if (i == 0) {
                if (a.this.hXO != null) {
                    a.this.hXO.a(a.this.Xc.getFirstVisiblePosition(), a.this.Xc.getLastVisiblePosition(), this.hXT, true);
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001630, Boolean.valueOf(a.this.cnx() ? false : true)));
                s.ciJ().bHY();
            }
        }

        @Override // android.support.v7.widget.RecyclerView.OnScrollListener
        public void onScrolled(RecyclerView recyclerView, int i, int i2) {
            super.onScrolled(recyclerView, i, i2);
            if (i2 > 0) {
                this.hXT = false;
            } else {
                this.hXT = true;
            }
        }
    };
    private View.OnClickListener hXQ = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.tabfeed.view.a.3
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (a.this.Xc != null) {
                a.this.Xc.stopScroll();
            }
            if (a.this.fTv != null && a.this.jqm != null && j.isNetWorkAvailable()) {
                a.this.fTv.showEmptyView(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
                a.this.fTv.setOnClickListener(null);
                if (a.this.hasMore) {
                    a.this.fTv.showLoading();
                    a.this.jqm.cnj();
                }
            }
        }
    };

    public void SI() {
        if (this.fTv != null && this.jqm != null) {
            if (j.isNetWorkAvailable()) {
                this.Xc.setNextPage(this.fTv);
                this.fTv.showEmptyView(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
                this.fTv.setOnClickListener(null);
                if (this.hasMore) {
                    this.fTv.showLoading();
                    this.jqm.cnj();
                    return;
                }
                this.fTv.setText(this.jpc.getResources().getString(R.string.list_has_no_more));
                this.fTv.endLoadData();
                return;
            }
            this.Xc.setNextPage(null);
        }
    }

    public a(HomePageTabFeedFragment homePageTabFeedFragment, c cVar, ViewGroup viewGroup, String str) {
        this.jpc = homePageTabFeedFragment;
        this.jqm = cVar;
        this.tabName = str;
        aV(viewGroup);
        this.jqw = new com.baidu.tieba.homepage.tabfeed.a(homePageTabFeedFragment, this.Xc);
        this.jqw.setTabName(str);
        kG(false);
    }

    private void aV(ViewGroup viewGroup) {
        this.mRootView = viewGroup;
        this.Xc = (BdTypeRecyclerView) viewGroup.findViewById(R.id.tab_feed_recycler_view);
        this.Xc.setLayoutManager(new LinearLayoutManager(this.jpc.getContext()));
        this.Xc.setFadingEdgeLength(0);
        this.Xc.setOverScrollMode(2);
        this.Xc.setOnSrollToBottomListener(this.gnC);
        this.Xc.addOnScrollListener(this.hyx);
        this.mPullView = new g(this.jpc.getPageContext());
        this.mPullView.setListPullRefreshListener(this.jqm);
        this.Xc.setRecyclerListener(new RecyclerView.RecyclerListener() { // from class: com.baidu.tieba.homepage.tabfeed.view.a.4
            @Override // android.support.v7.widget.RecyclerView.RecyclerListener
            public void onViewRecycled(RecyclerView.ViewHolder viewHolder) {
                View view = viewHolder.itemView;
                if (view != null && a.this.hXO != null) {
                    a.this.hXO.cR(view);
                }
            }
        });
        this.fTv = new PbListView(this.jpc.getPageContext().getPageActivity());
        this.fTv.getView();
        this.fTv.setContainerBackgroundColorResId(R.color.cp_bg_line_e);
        this.fTv.setHeight(l.getDimens(this.jpc.getPageContext().getPageActivity(), R.dimen.tbds182));
        this.fTv.setLineGone();
        this.fTv.setTextSize(R.dimen.tbfontsize33);
        this.fTv.setTextColor(ap.getColor(R.color.cp_cont_j));
        this.fTv.setNoMoreTextColorId(R.color.cp_cont_e);
        this.fTv.boa();
        this.fTv.setOnClickListener(this.hXQ);
        if (this.fVP == null) {
            this.fVP = (BdSwipeRefreshLayout) viewGroup.findViewById(R.id.tab_feed_pull_refresh_layout);
            this.fVP.setProgressView(this.mPullView);
        }
        this.jqu = new be();
        this.hXK = new SmartBubbleAnimatedView(this.jpc.getContext());
        this.hXK.setLayoutParams(new FrameLayout.LayoutParams(-1, l.getDimens(this.jpc.getContext(), R.dimen.tbds83)));
        if (this.hXO == null) {
            this.hXO = new i(this.jpc.getPageContext(), this.Xc);
            this.hXO.GO(1);
            this.hXO.setUniqueId(this.jpc.getUniqueId());
        }
    }

    public void b(com.baidu.tieba.homepage.tabfeed.data.c cVar) {
        kG(false);
        if (cVar != null && this.jqw != null && this.Xc != null && this.fTv != null) {
            this.hasMore = cVar.hasMore;
            if (cVar.jqk != null || cVar.jql != null) {
                if (this.jqv == null) {
                    this.jqv = new HomePageTabFeedHeaderView(this.jpc.getContext());
                    this.Xc.addHeaderView(this.jqv);
                }
                this.jqv.setData(cVar);
            } else if (this.jqv != null && this.jqv.getParent() != null) {
                this.Xc.removeHeaderView(this.jqv);
                this.jqv = null;
            }
            if (cVar.jnV > 0) {
                int firstVisiblePosition = this.Xc.getFirstVisiblePosition();
                View childAt = this.Xc.getChildAt(0);
                int top = childAt == null ? 0 : childAt.getTop();
                RecyclerView.LayoutManager layoutManager = this.Xc.getLayoutManager();
                int i = firstVisiblePosition - cVar.jnV;
                if (layoutManager instanceof LinearLayoutManager) {
                    this.Xc.qR();
                    ((LinearLayoutManager) layoutManager).scrollToPositionWithOffset(i, top);
                    this.Xc.qS();
                }
            }
            this.jqw.setData(cVar.jqj);
            this.jqw.notifyDataSetChanged();
            if (this.hXO != null) {
                this.hXO.a(this.Xc.getFirstVisiblePosition(), this.Xc.getLastVisiblePosition(), false, true);
            }
        }
    }

    public void onDestroy() {
        if (this.hXO != null) {
            this.hXO.destroy();
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mPullView != null) {
            this.mPullView.changeSkin(i);
        }
        if (this.fTv != null) {
            this.fTv.setTextColor(ap.getColor(R.color.cp_cont_j));
            this.fTv.changeSkin(i);
        }
        if (this.jqv != null) {
            this.jqv.onChangeSkinType(i);
        }
        if (this.jqw != null) {
            this.jqw.notifyDataSetChanged();
        }
        if (this.hXK != null) {
            this.hXK.onChangeSkinType(i);
        }
    }

    public void resume() {
        if (this.hXO != null) {
            this.hXO.sw(true);
            if (this.Xc != null) {
                this.hXO.a(this.Xc.getFirstVisiblePosition(), this.Xc.getLastVisiblePosition(), false, true);
            }
        }
    }

    public void pause() {
        if (this.hXO != null) {
            this.hXO.cUt();
            this.hXO.sw(false);
        }
    }

    public void cnw() {
        if (this.Xc != null) {
            this.Xc.scrollToPosition(0);
        }
    }

    public void kG(boolean z) {
        if (this.fVP != null) {
            this.fVP.setRefreshing(z);
        }
    }

    public void oz(boolean z) {
        if (this.fVP != null) {
            this.fVP.setVisibility(z ? 0 : 8);
        }
    }

    public boolean cnx() {
        return this.Xc == null || this.Xc.getChildCount() == 0 || this.Xc.getChildAt(0).getTop() == 0;
    }
}
