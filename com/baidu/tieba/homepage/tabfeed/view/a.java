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
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.view.PbListView;
import com.baidu.tbadk.core.view.g;
import com.baidu.tieba.R;
import com.baidu.tieba.card.s;
import com.baidu.tieba.frs.SmartBubbleAnimatedView;
import com.baidu.tieba.frs.bc;
import com.baidu.tieba.homepage.tabfeed.HomePageTabFeedFragment;
import com.baidu.tieba.homepage.tabfeed.c;
import com.baidu.tieba.play.m;
/* loaded from: classes9.dex */
public class a {
    private BdTypeRecyclerView Wa;
    private PbListView fnt;
    private BdSwipeRefreshLayout fpF;
    private SmartBubbleAnimatedView hji;
    private m hjm;
    private HomePageTabFeedFragment iwn;
    private bc ixF;
    private HomePageTabFeedHeaderView ixG;
    private com.baidu.tieba.homepage.tabfeed.a ixH;
    private c ixx;
    private g mPullView;
    private ViewGroup mRootView;
    private String tabName;
    private boolean hasMore = true;
    private BdListView.e fGA = new BdListView.e() { // from class: com.baidu.tieba.homepage.tabfeed.view.a.1
        @Override // com.baidu.adp.widget.ListView.BdListView.e
        public void onScrollToBottom() {
            if (a.this.Wa != null) {
                a.this.Wa.stopScroll();
            }
            a.this.buJ();
        }
    };
    private RecyclerView.OnScrollListener gKd = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.homepage.tabfeed.view.a.2
        private boolean hjr;

        @Override // android.support.v7.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i) {
            if (i == 0) {
                if (a.this.hjm != null) {
                    a.this.hjm.a(a.this.Wa.getFirstVisiblePosition(), a.this.Wa.getLastVisiblePosition(), this.hjr, true);
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001630, Boolean.valueOf(a.this.bTh() ? false : true)));
                s.bOB().brU();
            }
        }

        @Override // android.support.v7.widget.RecyclerView.OnScrollListener
        public void onScrolled(RecyclerView recyclerView, int i, int i2) {
            super.onScrolled(recyclerView, i, i2);
            if (i2 > 0) {
                this.hjr = false;
            } else {
                this.hjr = true;
            }
        }
    };
    private View.OnClickListener hjo = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.tabfeed.view.a.3
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (a.this.Wa != null) {
                a.this.Wa.stopScroll();
            }
            if (a.this.fnt != null && a.this.ixx != null && j.isNetWorkAvailable()) {
                a.this.fnt.showEmptyView(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
                a.this.fnt.setOnClickListener(null);
                if (a.this.hasMore) {
                    a.this.fnt.showLoading();
                    a.this.ixx.bST();
                }
            }
        }
    };

    public void buJ() {
        if (this.fnt != null && this.ixx != null) {
            if (j.isNetWorkAvailable()) {
                this.Wa.setNextPage(this.fnt);
                this.fnt.showEmptyView(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
                this.fnt.setOnClickListener(null);
                if (this.hasMore) {
                    this.fnt.showLoading();
                    this.ixx.bST();
                    return;
                }
                this.fnt.setText(this.iwn.getResources().getString(R.string.list_has_no_more));
                this.fnt.endLoadData();
                return;
            }
            this.Wa.setNextPage(null);
        }
    }

    public a(HomePageTabFeedFragment homePageTabFeedFragment, c cVar, ViewGroup viewGroup, String str) {
        this.iwn = homePageTabFeedFragment;
        this.ixx = cVar;
        this.tabName = str;
        aS(viewGroup);
        this.ixH = new com.baidu.tieba.homepage.tabfeed.a(homePageTabFeedFragment, this.Wa);
        this.ixH.setTabName(str);
        jc(false);
    }

    private void aS(ViewGroup viewGroup) {
        this.mRootView = viewGroup;
        this.Wa = (BdTypeRecyclerView) viewGroup.findViewById(R.id.tab_feed_recycler_view);
        this.Wa.setLayoutManager(new LinearLayoutManager(this.iwn.getContext()));
        this.Wa.setFadingEdgeLength(0);
        this.Wa.setOverScrollMode(2);
        this.Wa.setOnSrollToBottomListener(this.fGA);
        this.Wa.addOnScrollListener(this.gKd);
        this.mPullView = new g(this.iwn.getPageContext());
        this.mPullView.setListPullRefreshListener(this.ixx);
        this.Wa.setRecyclerListener(new RecyclerView.RecyclerListener() { // from class: com.baidu.tieba.homepage.tabfeed.view.a.4
            @Override // android.support.v7.widget.RecyclerView.RecyclerListener
            public void onViewRecycled(RecyclerView.ViewHolder viewHolder) {
                View view = viewHolder.itemView;
                if (view != null && a.this.hjm != null) {
                    a.this.hjm.cu(view);
                }
            }
        });
        this.fnt = new PbListView(this.iwn.getPageContext().getPageActivity());
        this.fnt.getView();
        this.fnt.setContainerBackgroundColorResId(R.color.cp_bg_line_e);
        this.fnt.setHeight(l.getDimens(this.iwn.getPageContext().getPageActivity(), R.dimen.tbds182));
        this.fnt.setLineGone();
        this.fnt.setTextSize(R.dimen.tbfontsize33);
        this.fnt.setTextColor(an.getColor(R.color.cp_cont_j));
        this.fnt.setNoMoreTextColorId(R.color.cp_cont_e);
        this.fnt.aXZ();
        this.fnt.setOnClickListener(this.hjo);
        if (this.fpF == null) {
            this.fpF = (BdSwipeRefreshLayout) viewGroup.findViewById(R.id.tab_feed_pull_refresh_layout);
            this.fpF.setProgressView(this.mPullView);
        }
        this.ixF = new bc();
        this.hji = new SmartBubbleAnimatedView(this.iwn.getContext());
        this.hji.setLayoutParams(new FrameLayout.LayoutParams(-1, l.getDimens(this.iwn.getContext(), R.dimen.tbds83)));
        if (this.hjm == null) {
            this.hjm = new m(this.iwn.getPageContext(), this.Wa);
            this.hjm.CN(1);
            this.hjm.setUniqueId(this.iwn.getUniqueId());
        }
    }

    public void b(com.baidu.tieba.homepage.tabfeed.data.c cVar) {
        jc(false);
        if (cVar != null && this.ixH != null && this.Wa != null && this.fnt != null) {
            this.hasMore = cVar.hasMore;
            if (cVar.ixv != null || cVar.ixw != null) {
                if (this.ixG == null) {
                    this.ixG = new HomePageTabFeedHeaderView(this.iwn.getContext());
                    this.Wa.addHeaderView(this.ixG);
                }
                this.ixG.setData(cVar);
            } else if (this.ixG != null && this.ixG.getParent() != null) {
                this.Wa.removeHeaderView(this.ixG);
                this.ixG = null;
            }
            if (cVar.ivm > 0) {
                int firstVisiblePosition = this.Wa.getFirstVisiblePosition();
                View childAt = this.Wa.getChildAt(0);
                int top2 = childAt == null ? 0 : childAt.getTop();
                RecyclerView.LayoutManager layoutManager = this.Wa.getLayoutManager();
                int i = firstVisiblePosition - cVar.ivm;
                if (layoutManager instanceof LinearLayoutManager) {
                    this.Wa.pm();
                    ((LinearLayoutManager) layoutManager).scrollToPositionWithOffset(i, top2);
                    this.Wa.pn();
                }
            }
            this.ixH.setData(cVar.ixu);
            this.ixH.notifyDataSetChanged();
            if (this.hjm != null) {
                this.hjm.a(this.Wa.getFirstVisiblePosition(), this.Wa.getLastVisiblePosition(), false, true);
            }
        }
    }

    public void onDestroy() {
        if (this.hjm != null) {
            this.hjm.destroy();
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mPullView != null) {
            this.mPullView.changeSkin(i);
        }
        if (this.fnt != null) {
            this.fnt.setTextColor(an.getColor(R.color.cp_cont_j));
            this.fnt.changeSkin(i);
        }
        if (this.ixG != null) {
            this.ixG.onChangeSkinType(i);
        }
        if (this.ixH != null) {
            this.ixH.notifyDataSetChanged();
        }
        if (this.hji != null) {
            this.hji.onChangeSkinType(i);
        }
    }

    public void resume() {
        if (this.hjm != null) {
            this.hjm.qs(true);
            if (this.Wa != null) {
                this.hjm.a(this.Wa.getFirstVisiblePosition(), this.Wa.getLastVisiblePosition(), false, true);
            }
        }
    }

    public void pause() {
        if (this.hjm != null) {
            this.hjm.cyn();
            this.hjm.qs(false);
        }
    }

    public void bTg() {
        if (this.Wa != null) {
            this.Wa.scrollToPosition(0);
        }
    }

    public void jc(boolean z) {
        if (this.fpF != null) {
            this.fpF.setRefreshing(z);
        }
    }

    public void mD(boolean z) {
        if (this.fpF != null) {
            this.fpF.setVisibility(z ? 0 : 8);
        }
    }

    public boolean bTh() {
        return this.Wa == null || this.Wa.getChildCount() == 0 || this.Wa.getChildAt(0).getTop() == 0;
    }
}
