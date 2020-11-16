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
import com.baidu.tbadk.core.util.UtilHelper;
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
/* loaded from: classes21.dex */
public class a {
    private BdTypeRecyclerView Xi;
    private PbListView giV;
    private BdSwipeRefreshLayout glp;
    private SmartBubbleAnimatedView iqX;
    private i irb;
    private HomePageTabFeedFragment jIk;
    private be jJC;
    private HomePageTabFeedHeaderView jJD;
    private com.baidu.tieba.homepage.tabfeed.a jJE;
    private c jJu;
    private g mPullView;
    private ViewGroup mRootView;
    private String tabName;
    private boolean hasMore = true;
    private BdListView.e gDc = new BdListView.e() { // from class: com.baidu.tieba.homepage.tabfeed.view.a.1
        @Override // com.baidu.adp.widget.ListView.BdListView.e
        public void onScrollToBottom() {
            if (a.this.Xi != null) {
                a.this.Xi.stopScroll();
            }
            a.this.Vz();
        }
    };
    private RecyclerView.OnScrollListener hRq = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.homepage.tabfeed.view.a.2
        private boolean eUl;

        @Override // android.support.v7.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i) {
            if (i == 0) {
                if (a.this.irb != null) {
                    a.this.irb.a(a.this.Xi.getFirstVisiblePosition(), a.this.Xi.getLastVisiblePosition(), this.eUl, true);
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001630, Boolean.valueOf(a.this.csI() ? false : true)));
                t.cnT().bLI();
            }
        }

        @Override // android.support.v7.widget.RecyclerView.OnScrollListener
        public void onScrolled(RecyclerView recyclerView, int i, int i2) {
            super.onScrolled(recyclerView, i, i2);
            if (i2 > 0) {
                this.eUl = false;
            } else {
                this.eUl = true;
            }
        }
    };
    private View.OnClickListener ird = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.tabfeed.view.a.3
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (a.this.Xi != null) {
                a.this.Xi.stopScroll();
            }
            if (a.this.giV != null && a.this.jJu != null && j.isNetWorkAvailable()) {
                a.this.giV.showEmptyView(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
                a.this.giV.setOnClickListener(null);
                if (a.this.hasMore) {
                    a.this.giV.showLoading();
                    a.this.jJu.csu();
                }
            }
        }
    };

    public void Vz() {
        if (this.giV != null && this.jJu != null) {
            if (j.isNetWorkAvailable()) {
                this.Xi.setNextPage(this.giV);
                this.giV.showEmptyView(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
                this.giV.setOnClickListener(null);
                if (this.hasMore) {
                    this.giV.showLoading();
                    this.jJu.csu();
                    return;
                }
                this.giV.setText(this.jIk.getResources().getString(R.string.list_has_no_more));
                this.giV.endLoadData();
                return;
            }
            this.Xi.setNextPage(null);
        }
    }

    public a(HomePageTabFeedFragment homePageTabFeedFragment, c cVar, ViewGroup viewGroup, String str) {
        this.jIk = homePageTabFeedFragment;
        this.jJu = cVar;
        this.tabName = str;
        aT(viewGroup);
        this.jJE = new com.baidu.tieba.homepage.tabfeed.a(homePageTabFeedFragment, this.Xi);
        this.jJE.setTabName(str);
        ld(false);
    }

    private void aT(ViewGroup viewGroup) {
        this.mRootView = viewGroup;
        this.Xi = (BdTypeRecyclerView) viewGroup.findViewById(R.id.tab_feed_recycler_view);
        this.Xi.setLayoutManager(new LinearLayoutManager(this.jIk.getContext()));
        this.Xi.setFadingEdgeLength(0);
        this.Xi.setOverScrollMode(2);
        this.Xi.setOnSrollToBottomListener(this.gDc);
        this.Xi.addOnScrollListener(this.hRq);
        this.mPullView = new g(this.jIk.getPageContext());
        this.mPullView.setListPullRefreshListener(this.jJu);
        this.Xi.setRecyclerListener(new RecyclerView.RecyclerListener() { // from class: com.baidu.tieba.homepage.tabfeed.view.a.4
            @Override // android.support.v7.widget.RecyclerView.RecyclerListener
            public void onViewRecycled(RecyclerView.ViewHolder viewHolder) {
                View view = viewHolder.itemView;
                if (view != null && a.this.irb != null) {
                    a.this.irb.de(view);
                }
            }
        });
        int dimenPixelSize = UtilHelper.getDimenPixelSize(R.dimen.M_W_X004);
        this.Xi.setPadding(dimenPixelSize, 0, dimenPixelSize, 0);
        this.giV = new PbListView(this.jIk.getPageContext().getPageActivity());
        this.giV.getView();
        this.giV.setContainerBackgroundColorResId(R.color.transparent);
        this.giV.setHeight(l.getDimens(this.jIk.getPageContext().getPageActivity(), R.dimen.tbds182));
        this.giV.setLineGone();
        this.giV.setTextSize(R.dimen.tbfontsize33);
        this.giV.setTextColor(ap.getColor(R.color.CAM_X0107));
        this.giV.setNoMoreTextColorId(R.color.CAM_X0110);
        this.giV.brI();
        this.giV.setOnClickListener(this.ird);
        if (this.glp == null) {
            this.glp = (BdSwipeRefreshLayout) viewGroup.findViewById(R.id.tab_feed_pull_refresh_layout);
            this.glp.setProgressView(this.mPullView);
        }
        this.jJC = new be();
        this.iqX = new SmartBubbleAnimatedView(this.jIk.getContext());
        this.iqX.setLayoutParams(new FrameLayout.LayoutParams(-1, l.getDimens(this.jIk.getContext(), R.dimen.tbds83)));
        if (this.irb == null) {
            this.irb = new i(this.jIk.getPageContext(), this.Xi);
            this.irb.HS(1);
            this.irb.setUniqueId(this.jIk.getUniqueId());
        }
    }

    public void b(com.baidu.tieba.homepage.tabfeed.data.c cVar) {
        ld(false);
        if (cVar != null && this.jJE != null && this.Xi != null && this.giV != null) {
            this.hasMore = cVar.hasMore;
            if (cVar.jJs != null || cVar.jJt != null) {
                if (this.jJD == null) {
                    this.jJD = new HomePageTabFeedHeaderView(this.jIk.getContext());
                    this.Xi.addHeaderView(this.jJD);
                }
                this.jJD.setData(cVar);
            } else if (this.jJD != null && this.jJD.getParent() != null) {
                this.Xi.removeHeaderView(this.jJD);
                this.jJD = null;
            }
            if (cVar.jHr > 0) {
                int firstVisiblePosition = this.Xi.getFirstVisiblePosition();
                View childAt = this.Xi.getChildAt(0);
                int top = childAt == null ? 0 : childAt.getTop();
                RecyclerView.LayoutManager layoutManager = this.Xi.getLayoutManager();
                int i = firstVisiblePosition - cVar.jHr;
                if (layoutManager instanceof LinearLayoutManager) {
                    this.Xi.qR();
                    ((LinearLayoutManager) layoutManager).scrollToPositionWithOffset(i, top);
                    this.Xi.qS();
                }
            }
            this.jJE.setData(cVar.jJr);
            this.jJE.notifyDataSetChanged();
            if (this.irb != null) {
                this.irb.a(this.Xi.getFirstVisiblePosition(), this.Xi.getLastVisiblePosition(), false, true);
            }
        }
    }

    public void onDestroy() {
        if (this.irb != null) {
            this.irb.destroy();
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mPullView != null) {
            this.mPullView.changeSkin(i);
        }
        if (this.giV != null) {
            this.giV.setTextColor(ap.getColor(R.color.CAM_X0107));
            this.giV.changeSkin(i);
        }
        if (this.jJD != null) {
            this.jJD.onChangeSkinType(i);
        }
        if (this.jJE != null) {
            this.jJE.notifyDataSetChanged();
        }
        if (this.iqX != null) {
            this.iqX.onChangeSkinType(i);
        }
    }

    public void resume() {
        if (this.irb != null) {
            this.irb.ta(true);
            if (this.Xi != null) {
                this.irb.a(this.Xi.getFirstVisiblePosition(), this.Xi.getLastVisiblePosition(), false, true);
            }
        }
    }

    public void pause() {
        if (this.irb != null) {
            this.irb.cZy();
            this.irb.ta(false);
        }
    }

    public void csH() {
        if (this.Xi != null) {
            this.Xi.scrollToPosition(0);
        }
    }

    public void ld(boolean z) {
        if (this.glp != null) {
            this.glp.setRefreshing(z);
        }
    }

    public void pd(boolean z) {
        if (this.glp != null) {
            this.glp.setVisibility(z ? 0 : 8);
        }
    }

    public boolean csI() {
        return this.Xi == null || this.Xi.getChildCount() == 0 || this.Xi.getChildAt(0).getTop() == 0;
    }
}
