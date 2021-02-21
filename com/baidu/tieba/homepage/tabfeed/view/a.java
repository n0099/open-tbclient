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
    private BdTypeRecyclerView XW;
    private PbListView gAw;
    private BdSwipeRefreshLayout gCQ;
    private SmartBubbleAnimatedView iPs;
    private i iPw;
    private HomePageTabFeedFragment kmR;
    private c kob;
    private bb koj;
    private HomePageTabFeedHeaderView kok;
    private com.baidu.tieba.homepage.tabfeed.a kol;
    private g mPullView;
    private ViewGroup mRootView;
    private String tabName;
    private boolean hasMore = true;
    private BdListView.e gWf = new BdListView.e() { // from class: com.baidu.tieba.homepage.tabfeed.view.a.1
        @Override // com.baidu.adp.widget.ListView.BdListView.e
        public void onScrollToBottom() {
            if (a.this.XW != null) {
                a.this.XW.stopScroll();
            }
            a.this.WX();
        }
    };
    private RecyclerView.OnScrollListener ipZ = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.homepage.tabfeed.view.a.2
        private boolean fiZ;

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i) {
            if (i == 0) {
                if (a.this.iPw != null) {
                    a.this.iPw.b(a.this.XW.getFirstVisiblePosition(), a.this.XW.getLastVisiblePosition(), this.fiZ, true);
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001630, Boolean.valueOf(a.this.cxt() ? false : true)));
                t.csB().bOM();
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrolled(RecyclerView recyclerView, int i, int i2) {
            super.onScrolled(recyclerView, i, i2);
            if (i2 > 0) {
                this.fiZ = false;
            } else {
                this.fiZ = true;
            }
        }
    };
    private View.OnClickListener iPy = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.tabfeed.view.a.3
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (a.this.XW != null) {
                a.this.XW.stopScroll();
            }
            if (a.this.gAw != null && a.this.kob != null && j.isNetWorkAvailable()) {
                a.this.gAw.showEmptyView(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
                a.this.gAw.setOnClickListener(null);
                if (a.this.hasMore) {
                    a.this.gAw.showLoading();
                    a.this.kob.cxf();
                }
            }
        }
    };

    public void WX() {
        if (this.gAw != null && this.kob != null) {
            if (j.isNetWorkAvailable()) {
                this.XW.setNextPage(this.gAw);
                this.gAw.showEmptyView(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
                this.gAw.setOnClickListener(null);
                if (this.hasMore) {
                    this.gAw.showLoading();
                    this.kob.cxf();
                    return;
                }
                this.gAw.setText(this.kmR.getResources().getString(R.string.list_has_no_more));
                this.gAw.endLoadData();
                return;
            }
            this.XW.setNextPage(null);
        }
    }

    public a(HomePageTabFeedFragment homePageTabFeedFragment, c cVar, ViewGroup viewGroup, String str) {
        this.kmR = homePageTabFeedFragment;
        this.kob = cVar;
        this.tabName = str;
        bf(viewGroup);
        this.kol = new com.baidu.tieba.homepage.tabfeed.a(homePageTabFeedFragment, this.XW);
        this.kol.setTabName(str);
        lU(false);
    }

    private void bf(ViewGroup viewGroup) {
        this.mRootView = viewGroup;
        this.XW = (BdTypeRecyclerView) viewGroup.findViewById(R.id.tab_feed_recycler_view);
        this.XW.setLayoutManager(new LinearLayoutManager(this.kmR.getContext()));
        this.XW.setFadingEdgeLength(0);
        this.XW.setOverScrollMode(2);
        this.XW.setOnSrollToBottomListener(this.gWf);
        this.XW.addOnScrollListener(this.ipZ);
        this.mPullView = new g(this.kmR.getPageContext());
        this.mPullView.setListPullRefreshListener(this.kob);
        this.XW.setRecyclerListener(new RecyclerView.RecyclerListener() { // from class: com.baidu.tieba.homepage.tabfeed.view.a.4
            @Override // androidx.recyclerview.widget.RecyclerView.RecyclerListener
            public void onViewRecycled(RecyclerView.ViewHolder viewHolder) {
                View view = viewHolder.itemView;
                if (view != null && a.this.iPw != null) {
                    a.this.iPw.dt(view);
                }
            }
        });
        int dimenPixelSize = UtilHelper.getDimenPixelSize(R.dimen.M_W_X004);
        this.XW.setPadding(dimenPixelSize, 0, dimenPixelSize, 0);
        this.gAw = new PbListView(this.kmR.getPageContext().getPageActivity());
        this.gAw.getView();
        this.gAw.setContainerBackgroundColorResId(R.color.transparent);
        this.gAw.setHeight(l.getDimens(this.kmR.getPageContext().getPageActivity(), R.dimen.tbds182));
        this.gAw.setLineGone();
        this.gAw.setTextSize(R.dimen.tbfontsize33);
        this.gAw.setTextColor(ap.getColor(R.color.CAM_X0107));
        this.gAw.setNoMoreTextColorId(R.color.CAM_X0110);
        this.gAw.bud();
        this.gAw.setOnClickListener(this.iPy);
        if (this.gCQ == null) {
            this.gCQ = (BdSwipeRefreshLayout) viewGroup.findViewById(R.id.tab_feed_pull_refresh_layout);
            this.gCQ.setProgressView(this.mPullView);
        }
        this.koj = new bb();
        this.iPs = new SmartBubbleAnimatedView(this.kmR.getContext());
        this.iPs.setLayoutParams(new FrameLayout.LayoutParams(-1, l.getDimens(this.kmR.getContext(), R.dimen.tbds83)));
        if (this.iPw == null) {
            this.iPw = new i(this.kmR.getPageContext(), this.XW);
            this.iPw.Ho(1);
            this.iPw.setUniqueId(this.kmR.getUniqueId());
        }
    }

    public void b(com.baidu.tieba.homepage.tabfeed.data.c cVar) {
        lU(false);
        if (cVar != null && this.kol != null && this.XW != null && this.gAw != null) {
            this.hasMore = cVar.hasMore;
            if (cVar.knZ != null || cVar.koa != null) {
                if (this.kok == null) {
                    this.kok = new HomePageTabFeedHeaderView(this.kmR.getContext());
                    this.XW.addHeaderView(this.kok);
                }
                this.kok.setData(cVar);
            } else if (this.kok != null && this.kok.getParent() != null) {
                this.XW.removeHeaderView(this.kok);
                this.kok = null;
            }
            if (cVar.klZ > 0) {
                int firstVisiblePosition = this.XW.getFirstVisiblePosition();
                View childAt = this.XW.getChildAt(0);
                int top = childAt == null ? 0 : childAt.getTop();
                RecyclerView.LayoutManager layoutManager = this.XW.getLayoutManager();
                int i = firstVisiblePosition - cVar.klZ;
                if (layoutManager instanceof LinearLayoutManager) {
                    this.XW.qt();
                    ((LinearLayoutManager) layoutManager).scrollToPositionWithOffset(i, top);
                    this.XW.qu();
                }
            }
            this.kol.setData(cVar.knY);
            this.kol.notifyDataSetChanged();
            if (this.iPw != null) {
                this.iPw.b(this.XW.getFirstVisiblePosition(), this.XW.getLastVisiblePosition(), false, true);
            }
        }
    }

    public void onDestroy() {
        if (this.iPw != null) {
            this.iPw.destroy();
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mPullView != null) {
            this.mPullView.changeSkin(i);
        }
        if (this.gAw != null) {
            this.gAw.setTextColor(ap.getColor(R.color.CAM_X0107));
            this.gAw.changeSkin(i);
        }
        if (this.kok != null) {
            this.kok.onChangeSkinType(i);
        }
        if (this.kol != null) {
            this.kol.notifyDataSetChanged();
        }
        if (this.iPs != null) {
            this.iPs.onChangeSkinType(i);
        }
    }

    public void resume() {
        if (this.iPw != null) {
            this.iPw.tN(true);
            if (this.XW != null) {
                this.iPw.b(this.XW.getFirstVisiblePosition(), this.XW.getLastVisiblePosition(), false, true);
            }
        }
    }

    public void pause() {
        if (this.iPw != null) {
            this.iPw.dcJ();
            this.iPw.tN(false);
        }
    }

    public void cxs() {
        if (this.XW != null) {
            this.XW.scrollToPosition(0);
        }
    }

    public void lU(boolean z) {
        if (this.gCQ != null) {
            this.gCQ.setRefreshing(z);
        }
    }

    public void qc(boolean z) {
        if (this.gCQ != null) {
            this.gCQ.setVisibility(z ? 0 : 8);
        }
    }

    public boolean cxt() {
        return this.XW == null || this.XW.getChildCount() == 0 || this.XW.getChildAt(0).getTop() == 0;
    }
}
