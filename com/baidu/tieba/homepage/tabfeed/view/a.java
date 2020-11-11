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
    private PbListView gjo;
    private BdSwipeRefreshLayout glI;
    private SmartBubbleAnimatedView iqj;
    private i iqn;
    private HomePageTabFeedFragment jHz;
    private c jIJ;
    private be jIR;
    private HomePageTabFeedHeaderView jIS;
    private com.baidu.tieba.homepage.tabfeed.a jIT;
    private g mPullView;
    private ViewGroup mRootView;
    private String tabName;
    private boolean hasMore = true;
    private BdListView.e gDv = new BdListView.e() { // from class: com.baidu.tieba.homepage.tabfeed.view.a.1
        @Override // com.baidu.adp.widget.ListView.BdListView.e
        public void onScrollToBottom() {
            if (a.this.Xe != null) {
                a.this.Xe.stopScroll();
            }
            a.this.Wi();
        }
    };
    private RecyclerView.OnScrollListener hQQ = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.homepage.tabfeed.view.a.2
        private boolean iqs;

        @Override // android.support.v7.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i) {
            if (i == 0) {
                if (a.this.iqn != null) {
                    a.this.iqn.a(a.this.Xe.getFirstVisiblePosition(), a.this.Xe.getLastVisiblePosition(), this.iqs, true);
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001630, Boolean.valueOf(a.this.ctf() ? false : true)));
                t.cor().bMp();
            }
        }

        @Override // android.support.v7.widget.RecyclerView.OnScrollListener
        public void onScrolled(RecyclerView recyclerView, int i, int i2) {
            super.onScrolled(recyclerView, i, i2);
            if (i2 > 0) {
                this.iqs = false;
            } else {
                this.iqs = true;
            }
        }
    };
    private View.OnClickListener iqp = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.tabfeed.view.a.3
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (a.this.Xe != null) {
                a.this.Xe.stopScroll();
            }
            if (a.this.gjo != null && a.this.jIJ != null && j.isNetWorkAvailable()) {
                a.this.gjo.showEmptyView(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
                a.this.gjo.setOnClickListener(null);
                if (a.this.hasMore) {
                    a.this.gjo.showLoading();
                    a.this.jIJ.csR();
                }
            }
        }
    };

    public void Wi() {
        if (this.gjo != null && this.jIJ != null) {
            if (j.isNetWorkAvailable()) {
                this.Xe.setNextPage(this.gjo);
                this.gjo.showEmptyView(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
                this.gjo.setOnClickListener(null);
                if (this.hasMore) {
                    this.gjo.showLoading();
                    this.jIJ.csR();
                    return;
                }
                this.gjo.setText(this.jHz.getResources().getString(R.string.list_has_no_more));
                this.gjo.endLoadData();
                return;
            }
            this.Xe.setNextPage(null);
        }
    }

    public a(HomePageTabFeedFragment homePageTabFeedFragment, c cVar, ViewGroup viewGroup, String str) {
        this.jHz = homePageTabFeedFragment;
        this.jIJ = cVar;
        this.tabName = str;
        aX(viewGroup);
        this.jIT = new com.baidu.tieba.homepage.tabfeed.a(homePageTabFeedFragment, this.Xe);
        this.jIT.setTabName(str);
        lc(false);
    }

    private void aX(ViewGroup viewGroup) {
        this.mRootView = viewGroup;
        this.Xe = (BdTypeRecyclerView) viewGroup.findViewById(R.id.tab_feed_recycler_view);
        this.Xe.setLayoutManager(new LinearLayoutManager(this.jHz.getContext()));
        this.Xe.setFadingEdgeLength(0);
        this.Xe.setOverScrollMode(2);
        this.Xe.setOnSrollToBottomListener(this.gDv);
        this.Xe.addOnScrollListener(this.hQQ);
        this.mPullView = new g(this.jHz.getPageContext());
        this.mPullView.setListPullRefreshListener(this.jIJ);
        this.Xe.setRecyclerListener(new RecyclerView.RecyclerListener() { // from class: com.baidu.tieba.homepage.tabfeed.view.a.4
            @Override // android.support.v7.widget.RecyclerView.RecyclerListener
            public void onViewRecycled(RecyclerView.ViewHolder viewHolder) {
                View view = viewHolder.itemView;
                if (view != null && a.this.iqn != null) {
                    a.this.iqn.da(view);
                }
            }
        });
        this.gjo = new PbListView(this.jHz.getPageContext().getPageActivity());
        this.gjo.getView();
        this.gjo.setContainerBackgroundColorResId(R.color.cp_bg_line_e);
        this.gjo.setHeight(l.getDimens(this.jHz.getPageContext().getPageActivity(), R.dimen.tbds182));
        this.gjo.setLineGone();
        this.gjo.setTextSize(R.dimen.tbfontsize33);
        this.gjo.setTextColor(ap.getColor(R.color.cp_cont_j));
        this.gjo.setNoMoreTextColorId(R.color.cp_cont_e);
        this.gjo.bst();
        this.gjo.setOnClickListener(this.iqp);
        if (this.glI == null) {
            this.glI = (BdSwipeRefreshLayout) viewGroup.findViewById(R.id.tab_feed_pull_refresh_layout);
            this.glI.setProgressView(this.mPullView);
        }
        this.jIR = new be();
        this.iqj = new SmartBubbleAnimatedView(this.jHz.getContext());
        this.iqj.setLayoutParams(new FrameLayout.LayoutParams(-1, l.getDimens(this.jHz.getContext(), R.dimen.tbds83)));
        if (this.iqn == null) {
            this.iqn = new i(this.jHz.getPageContext(), this.Xe);
            this.iqn.Hu(1);
            this.iqn.setUniqueId(this.jHz.getUniqueId());
        }
    }

    public void b(com.baidu.tieba.homepage.tabfeed.data.c cVar) {
        lc(false);
        if (cVar != null && this.jIT != null && this.Xe != null && this.gjo != null) {
            this.hasMore = cVar.hasMore;
            if (cVar.jIH != null || cVar.jII != null) {
                if (this.jIS == null) {
                    this.jIS = new HomePageTabFeedHeaderView(this.jHz.getContext());
                    this.Xe.addHeaderView(this.jIS);
                }
                this.jIS.setData(cVar);
            } else if (this.jIS != null && this.jIS.getParent() != null) {
                this.Xe.removeHeaderView(this.jIS);
                this.jIS = null;
            }
            if (cVar.jGs > 0) {
                int firstVisiblePosition = this.Xe.getFirstVisiblePosition();
                View childAt = this.Xe.getChildAt(0);
                int top = childAt == null ? 0 : childAt.getTop();
                RecyclerView.LayoutManager layoutManager = this.Xe.getLayoutManager();
                int i = firstVisiblePosition - cVar.jGs;
                if (layoutManager instanceof LinearLayoutManager) {
                    this.Xe.qR();
                    ((LinearLayoutManager) layoutManager).scrollToPositionWithOffset(i, top);
                    this.Xe.qS();
                }
            }
            this.jIT.setData(cVar.jIG);
            this.jIT.notifyDataSetChanged();
            if (this.iqn != null) {
                this.iqn.a(this.Xe.getFirstVisiblePosition(), this.Xe.getLastVisiblePosition(), false, true);
            }
        }
    }

    public void onDestroy() {
        if (this.iqn != null) {
            this.iqn.destroy();
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mPullView != null) {
            this.mPullView.changeSkin(i);
        }
        if (this.gjo != null) {
            this.gjo.setTextColor(ap.getColor(R.color.cp_cont_j));
            this.gjo.changeSkin(i);
        }
        if (this.jIS != null) {
            this.jIS.onChangeSkinType(i);
        }
        if (this.jIT != null) {
            this.jIT.notifyDataSetChanged();
        }
        if (this.iqj != null) {
            this.iqj.onChangeSkinType(i);
        }
    }

    public void resume() {
        if (this.iqn != null) {
            this.iqn.sX(true);
            if (this.Xe != null) {
                this.iqn.a(this.Xe.getFirstVisiblePosition(), this.Xe.getLastVisiblePosition(), false, true);
            }
        }
    }

    public void pause() {
        if (this.iqn != null) {
            this.iqn.dab();
            this.iqn.sX(false);
        }
    }

    public void cte() {
        if (this.Xe != null) {
            this.Xe.scrollToPosition(0);
        }
    }

    public void lc(boolean z) {
        if (this.glI != null) {
            this.glI.setRefreshing(z);
        }
    }

    public void pa(boolean z) {
        if (this.glI != null) {
            this.glI.setVisibility(z ? 0 : 8);
        }
    }

    public boolean ctf() {
        return this.Xe == null || this.Xe.getChildCount() == 0 || this.Xe.getChildAt(0).getTop() == 0;
    }
}
