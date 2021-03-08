package com.baidu.tieba.homepage.tabfeed.view;

import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
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
import com.baidu.tieba.frs.bb;
import com.baidu.tieba.homepage.tabfeed.HomePageTabFeedFragment;
import com.baidu.tieba.homepage.tabfeed.c;
import com.baidu.tieba.play.i;
/* loaded from: classes2.dex */
public class a {
    private BdTypeRecyclerView Zq;
    private PbListView gCf;
    private BdSwipeRefreshLayout gEz;
    private SmartBubbleAnimatedView iRb;
    private i iRf;
    private HomePageTabFeedFragment koT;
    private c kqd;
    private bb kql;
    private HomePageTabFeedHeaderView kqm;
    private com.baidu.tieba.homepage.tabfeed.a kqn;
    private g mPullView;
    private ViewGroup mRootView;
    private String tabName;
    private boolean hasMore = true;
    private BdListView.e gXO = new BdListView.e() { // from class: com.baidu.tieba.homepage.tabfeed.view.a.1
        @Override // com.baidu.adp.widget.ListView.BdListView.e
        public void onScrollToBottom() {
            if (a.this.Zq != null) {
                a.this.Zq.stopScroll();
            }
            a.this.Xa();
        }
    };
    private RecyclerView.OnScrollListener irI = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.homepage.tabfeed.view.a.2
        private boolean fky;

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i) {
            if (i == 0) {
                if (a.this.iRf != null) {
                    a.this.iRf.b(a.this.Zq.getFirstVisiblePosition(), a.this.Zq.getLastVisiblePosition(), this.fky, true);
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001630, Boolean.valueOf(a.this.cxz() ? false : true)));
                t.csH().bOS();
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrolled(RecyclerView recyclerView, int i, int i2) {
            super.onScrolled(recyclerView, i, i2);
            if (i2 > 0) {
                this.fky = false;
            } else {
                this.fky = true;
            }
        }
    };
    private View.OnClickListener iRh = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.tabfeed.view.a.3
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (a.this.Zq != null) {
                a.this.Zq.stopScroll();
            }
            if (a.this.gCf != null && a.this.kqd != null && j.isNetWorkAvailable()) {
                a.this.gCf.showEmptyView(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
                a.this.gCf.setOnClickListener(null);
                if (a.this.hasMore) {
                    a.this.gCf.showLoading();
                    a.this.kqd.cxl();
                }
            }
        }
    };

    public void Xa() {
        if (this.gCf != null && this.kqd != null) {
            if (j.isNetWorkAvailable()) {
                this.Zq.setNextPage(this.gCf);
                this.gCf.showEmptyView(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
                this.gCf.setOnClickListener(null);
                if (this.hasMore) {
                    this.gCf.showLoading();
                    this.kqd.cxl();
                    return;
                }
                this.gCf.setText(this.koT.getResources().getString(R.string.list_has_no_more));
                this.gCf.endLoadData();
                return;
            }
            this.Zq.setNextPage(null);
        }
    }

    public a(HomePageTabFeedFragment homePageTabFeedFragment, c cVar, ViewGroup viewGroup, String str) {
        this.koT = homePageTabFeedFragment;
        this.kqd = cVar;
        this.tabName = str;
        bf(viewGroup);
        this.kqn = new com.baidu.tieba.homepage.tabfeed.a(homePageTabFeedFragment, this.Zq);
        this.kqn.setTabName(str);
        lU(false);
    }

    private void bf(ViewGroup viewGroup) {
        this.mRootView = viewGroup;
        this.Zq = (BdTypeRecyclerView) viewGroup.findViewById(R.id.tab_feed_recycler_view);
        this.Zq.setLayoutManager(new LinearLayoutManager(this.koT.getContext()));
        this.Zq.setFadingEdgeLength(0);
        this.Zq.setOverScrollMode(2);
        this.Zq.setOnSrollToBottomListener(this.gXO);
        this.Zq.addOnScrollListener(this.irI);
        this.mPullView = new g(this.koT.getPageContext());
        this.mPullView.setListPullRefreshListener(this.kqd);
        this.Zq.setRecyclerListener(new RecyclerView.RecyclerListener() { // from class: com.baidu.tieba.homepage.tabfeed.view.a.4
            @Override // androidx.recyclerview.widget.RecyclerView.RecyclerListener
            public void onViewRecycled(RecyclerView.ViewHolder viewHolder) {
                View view = viewHolder.itemView;
                if (view != null && a.this.iRf != null) {
                    a.this.iRf.dt(view);
                }
            }
        });
        int dimenPixelSize = UtilHelper.getDimenPixelSize(R.dimen.M_W_X004);
        this.Zq.setPadding(dimenPixelSize, 0, dimenPixelSize, 0);
        this.gCf = new PbListView(this.koT.getPageContext().getPageActivity());
        this.gCf.getView();
        this.gCf.setContainerBackgroundColorResId(R.color.transparent);
        this.gCf.setHeight(l.getDimens(this.koT.getPageContext().getPageActivity(), R.dimen.tbds182));
        this.gCf.setLineGone();
        this.gCf.setTextSize(R.dimen.tbfontsize33);
        this.gCf.setTextColor(ap.getColor(R.color.CAM_X0107));
        this.gCf.setNoMoreTextColorId(R.color.CAM_X0110);
        this.gCf.bug();
        this.gCf.setOnClickListener(this.iRh);
        if (this.gEz == null) {
            this.gEz = (BdSwipeRefreshLayout) viewGroup.findViewById(R.id.tab_feed_pull_refresh_layout);
            this.gEz.setProgressView(this.mPullView);
        }
        this.kql = new bb();
        this.iRb = new SmartBubbleAnimatedView(this.koT.getContext());
        this.iRb.setLayoutParams(new FrameLayout.LayoutParams(-1, l.getDimens(this.koT.getContext(), R.dimen.tbds83)));
        if (this.iRf == null) {
            this.iRf = new i(this.koT.getPageContext(), this.Zq);
            this.iRf.Hr(1);
            this.iRf.setUniqueId(this.koT.getUniqueId());
        }
    }

    public void b(com.baidu.tieba.homepage.tabfeed.data.c cVar) {
        lU(false);
        if (cVar != null && this.kqn != null && this.Zq != null && this.gCf != null) {
            this.hasMore = cVar.hasMore;
            if (cVar.kqb != null || cVar.kqc != null) {
                if (this.kqm == null) {
                    this.kqm = new HomePageTabFeedHeaderView(this.koT.getContext());
                    this.Zq.addHeaderView(this.kqm);
                }
                this.kqm.setData(cVar);
            } else if (this.kqm != null && this.kqm.getParent() != null) {
                this.Zq.removeHeaderView(this.kqm);
                this.kqm = null;
            }
            if (cVar.kob > 0) {
                int firstVisiblePosition = this.Zq.getFirstVisiblePosition();
                View childAt = this.Zq.getChildAt(0);
                int top = childAt == null ? 0 : childAt.getTop();
                RecyclerView.LayoutManager layoutManager = this.Zq.getLayoutManager();
                int i = firstVisiblePosition - cVar.kob;
                if (layoutManager instanceof LinearLayoutManager) {
                    this.Zq.qt();
                    ((LinearLayoutManager) layoutManager).scrollToPositionWithOffset(i, top);
                    this.Zq.qu();
                }
            }
            this.kqn.setData(cVar.kqa);
            this.kqn.notifyDataSetChanged();
            if (this.iRf != null) {
                this.iRf.b(this.Zq.getFirstVisiblePosition(), this.Zq.getLastVisiblePosition(), false, true);
            }
        }
    }

    public void onDestroy() {
        if (this.iRf != null) {
            this.iRf.destroy();
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mPullView != null) {
            this.mPullView.changeSkin(i);
        }
        if (this.gCf != null) {
            this.gCf.setTextColor(ap.getColor(R.color.CAM_X0107));
            this.gCf.changeSkin(i);
        }
        if (this.kqm != null) {
            this.kqm.onChangeSkinType(i);
        }
        if (this.kqn != null) {
            this.kqn.notifyDataSetChanged();
        }
        if (this.iRb != null) {
            this.iRb.onChangeSkinType(i);
        }
    }

    public void resume() {
        if (this.iRf != null) {
            this.iRf.tN(true);
            if (this.Zq != null) {
                this.iRf.b(this.Zq.getFirstVisiblePosition(), this.Zq.getLastVisiblePosition(), false, true);
            }
        }
    }

    public void pause() {
        if (this.iRf != null) {
            this.iRf.dcS();
            this.iRf.tN(false);
        }
    }

    public void cxy() {
        if (this.Zq != null) {
            this.Zq.scrollToPosition(0);
        }
    }

    public void lU(boolean z) {
        if (this.gEz != null) {
            this.gEz.setRefreshing(z);
        }
    }

    public void qc(boolean z) {
        if (this.gEz != null) {
            this.gEz.setVisibility(z ? 0 : 8);
        }
    }

    public boolean cxz() {
        return this.Zq == null || this.Zq.getChildCount() == 0 || this.Zq.getChildAt(0).getTop() == 0;
    }
}
