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
/* loaded from: classes21.dex */
public class a {
    private BdTypeRecyclerView WM;
    private PbListView fHm;
    private BdSwipeRefreshLayout fJy;
    private SmartBubbleAnimatedView hIP;
    private i hIT;
    private HomePageTabFeedFragment jad;
    private c jbn;
    private be jbv;
    private HomePageTabFeedHeaderView jbw;
    private com.baidu.tieba.homepage.tabfeed.a jbx;
    private g mPullView;
    private ViewGroup mRootView;
    private String tabName;
    private boolean hasMore = true;
    private BdListView.e gbl = new BdListView.e() { // from class: com.baidu.tieba.homepage.tabfeed.view.a.1
        @Override // com.baidu.adp.widget.ListView.BdListView.e
        public void onScrollToBottom() {
            if (a.this.WM != null) {
                a.this.WM.stopScroll();
            }
            a.this.bIi();
        }
    };
    private RecyclerView.OnScrollListener hjC = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.homepage.tabfeed.view.a.2
        private boolean hIY;

        @Override // android.support.v7.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i) {
            if (i == 0) {
                if (a.this.hIT != null) {
                    a.this.hIT.a(a.this.WM.getFirstVisiblePosition(), a.this.WM.getLastVisiblePosition(), this.hIY, true);
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001630, Boolean.valueOf(a.this.ckb() ? false : true)));
                s.cfn().bFm();
            }
        }

        @Override // android.support.v7.widget.RecyclerView.OnScrollListener
        public void onScrolled(RecyclerView recyclerView, int i, int i2) {
            super.onScrolled(recyclerView, i, i2);
            if (i2 > 0) {
                this.hIY = false;
            } else {
                this.hIY = true;
            }
        }
    };
    private View.OnClickListener hIV = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.tabfeed.view.a.3
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (a.this.WM != null) {
                a.this.WM.stopScroll();
            }
            if (a.this.fHm != null && a.this.jbn != null && j.isNetWorkAvailable()) {
                a.this.fHm.showEmptyView(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
                a.this.fHm.setOnClickListener(null);
                if (a.this.hasMore) {
                    a.this.fHm.showLoading();
                    a.this.jbn.cjN();
                }
            }
        }
    };

    public void bIi() {
        if (this.fHm != null && this.jbn != null) {
            if (j.isNetWorkAvailable()) {
                this.WM.setNextPage(this.fHm);
                this.fHm.showEmptyView(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
                this.fHm.setOnClickListener(null);
                if (this.hasMore) {
                    this.fHm.showLoading();
                    this.jbn.cjN();
                    return;
                }
                this.fHm.setText(this.jad.getResources().getString(R.string.list_has_no_more));
                this.fHm.endLoadData();
                return;
            }
            this.WM.setNextPage(null);
        }
    }

    public a(HomePageTabFeedFragment homePageTabFeedFragment, c cVar, ViewGroup viewGroup, String str) {
        this.jad = homePageTabFeedFragment;
        this.jbn = cVar;
        this.tabName = str;
        aT(viewGroup);
        this.jbx = new com.baidu.tieba.homepage.tabfeed.a(homePageTabFeedFragment, this.WM);
        this.jbx.setTabName(str);
        ki(false);
    }

    private void aT(ViewGroup viewGroup) {
        this.mRootView = viewGroup;
        this.WM = (BdTypeRecyclerView) viewGroup.findViewById(R.id.tab_feed_recycler_view);
        this.WM.setLayoutManager(new LinearLayoutManager(this.jad.getContext()));
        this.WM.setFadingEdgeLength(0);
        this.WM.setOverScrollMode(2);
        this.WM.setOnSrollToBottomListener(this.gbl);
        this.WM.addOnScrollListener(this.hjC);
        this.mPullView = new g(this.jad.getPageContext());
        this.mPullView.setListPullRefreshListener(this.jbn);
        this.WM.setRecyclerListener(new RecyclerView.RecyclerListener() { // from class: com.baidu.tieba.homepage.tabfeed.view.a.4
            @Override // android.support.v7.widget.RecyclerView.RecyclerListener
            public void onViewRecycled(RecyclerView.ViewHolder viewHolder) {
                View view = viewHolder.itemView;
                if (view != null && a.this.hIT != null) {
                    a.this.hIT.cN(view);
                }
            }
        });
        this.fHm = new PbListView(this.jad.getPageContext().getPageActivity());
        this.fHm.getView();
        this.fHm.setContainerBackgroundColorResId(R.color.cp_bg_line_e);
        this.fHm.setHeight(l.getDimens(this.jad.getPageContext().getPageActivity(), R.dimen.tbds182));
        this.fHm.setLineGone();
        this.fHm.setTextSize(R.dimen.tbfontsize33);
        this.fHm.setTextColor(ap.getColor(R.color.cp_cont_j));
        this.fHm.setNoMoreTextColorId(R.color.cp_cont_e);
        this.fHm.blq();
        this.fHm.setOnClickListener(this.hIV);
        if (this.fJy == null) {
            this.fJy = (BdSwipeRefreshLayout) viewGroup.findViewById(R.id.tab_feed_pull_refresh_layout);
            this.fJy.setProgressView(this.mPullView);
        }
        this.jbv = new be();
        this.hIP = new SmartBubbleAnimatedView(this.jad.getContext());
        this.hIP.setLayoutParams(new FrameLayout.LayoutParams(-1, l.getDimens(this.jad.getContext(), R.dimen.tbds83)));
        if (this.hIT == null) {
            this.hIT = new i(this.jad.getPageContext(), this.WM);
            this.hIT.Gi(1);
            this.hIT.setUniqueId(this.jad.getUniqueId());
        }
    }

    public void b(com.baidu.tieba.homepage.tabfeed.data.c cVar) {
        ki(false);
        if (cVar != null && this.jbx != null && this.WM != null && this.fHm != null) {
            this.hasMore = cVar.hasMore;
            if (cVar.jbl != null || cVar.jbm != null) {
                if (this.jbw == null) {
                    this.jbw = new HomePageTabFeedHeaderView(this.jad.getContext());
                    this.WM.addHeaderView(this.jbw);
                }
                this.jbw.setData(cVar);
            } else if (this.jbw != null && this.jbw.getParent() != null) {
                this.WM.removeHeaderView(this.jbw);
                this.jbw = null;
            }
            if (cVar.iYW > 0) {
                int firstVisiblePosition = this.WM.getFirstVisiblePosition();
                View childAt = this.WM.getChildAt(0);
                int top = childAt == null ? 0 : childAt.getTop();
                RecyclerView.LayoutManager layoutManager = this.WM.getLayoutManager();
                int i = firstVisiblePosition - cVar.iYW;
                if (layoutManager instanceof LinearLayoutManager) {
                    this.WM.qR();
                    ((LinearLayoutManager) layoutManager).scrollToPositionWithOffset(i, top);
                    this.WM.qS();
                }
            }
            this.jbx.setData(cVar.jbk);
            this.jbx.notifyDataSetChanged();
            if (this.hIT != null) {
                this.hIT.a(this.WM.getFirstVisiblePosition(), this.WM.getLastVisiblePosition(), false, true);
            }
        }
    }

    public void onDestroy() {
        if (this.hIT != null) {
            this.hIT.destroy();
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mPullView != null) {
            this.mPullView.changeSkin(i);
        }
        if (this.fHm != null) {
            this.fHm.setTextColor(ap.getColor(R.color.cp_cont_j));
            this.fHm.changeSkin(i);
        }
        if (this.jbw != null) {
            this.jbw.onChangeSkinType(i);
        }
        if (this.jbx != null) {
            this.jbx.notifyDataSetChanged();
        }
        if (this.hIP != null) {
            this.hIP.onChangeSkinType(i);
        }
    }

    public void resume() {
        if (this.hIT != null) {
            this.hIT.rP(true);
            if (this.WM != null) {
                this.hIT.a(this.WM.getFirstVisiblePosition(), this.WM.getLastVisiblePosition(), false, true);
            }
        }
    }

    public void pause() {
        if (this.hIT != null) {
            this.hIT.cQJ();
            this.hIT.rP(false);
        }
    }

    public void cka() {
        if (this.WM != null) {
            this.WM.scrollToPosition(0);
        }
    }

    public void ki(boolean z) {
        if (this.fJy != null) {
            this.fJy.setRefreshing(z);
        }
    }

    public void nU(boolean z) {
        if (this.fJy != null) {
            this.fJy.setVisibility(z ? 0 : 8);
        }
    }

    public boolean ckb() {
        return this.WM == null || this.WM.getChildCount() == 0 || this.WM.getChildAt(0).getTop() == 0;
    }
}
