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
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.view.PbListView;
import com.baidu.tbadk.core.view.g;
import com.baidu.tieba.R;
import com.baidu.tieba.card.s;
import com.baidu.tieba.frs.SmartBubbleAnimatedView;
import com.baidu.tieba.frs.bb;
import com.baidu.tieba.homepage.tabfeed.HomePageTabFeedFragment;
import com.baidu.tieba.homepage.tabfeed.c;
import com.baidu.tieba.play.i;
/* loaded from: classes2.dex */
public class a {
    private BdTypeRecyclerView Yc;
    private PbListView gCf;
    private BdSwipeRefreshLayout gEz;
    private SmartBubbleAnimatedView iOd;
    private i iOh;
    private HomePageTabFeedFragment kjb;
    private c kkl;
    private bb kkt;
    private HomePageTabFeedHeaderView kku;
    private com.baidu.tieba.homepage.tabfeed.a kkv;
    private g mPullView;
    private ViewGroup mRootView;
    private String tabName;
    private boolean hasMore = true;
    private BdListView.e gXN = new BdListView.e() { // from class: com.baidu.tieba.homepage.tabfeed.view.a.1
        @Override // com.baidu.adp.widget.ListView.BdListView.e
        public void onScrollToBottom() {
            if (a.this.Yc != null) {
                a.this.Yc.stopScroll();
            }
            a.this.Zh();
        }
    };
    private RecyclerView.OnScrollListener ioM = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.homepage.tabfeed.view.a.2
        private boolean flr;

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i) {
            if (i == 0) {
                if (a.this.iOh != null) {
                    a.this.iOh.b(a.this.Yc.getFirstVisiblePosition(), a.this.Yc.getLastVisiblePosition(), this.flr, true);
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001630, Boolean.valueOf(a.this.czS() ? false : true)));
                s.cvb().bRT();
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrolled(RecyclerView recyclerView, int i, int i2) {
            super.onScrolled(recyclerView, i, i2);
            if (i2 > 0) {
                this.flr = false;
            } else {
                this.flr = true;
            }
        }
    };
    private View.OnClickListener iOj = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.tabfeed.view.a.3
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (a.this.Yc != null) {
                a.this.Yc.stopScroll();
            }
            if (a.this.gCf != null && a.this.kkl != null && j.isNetWorkAvailable()) {
                a.this.gCf.showEmptyView(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
                a.this.gCf.setOnClickListener(null);
                if (a.this.hasMore) {
                    a.this.gCf.showLoading();
                    a.this.kkl.czE();
                }
            }
        }
    };

    public void Zh() {
        if (this.gCf != null && this.kkl != null) {
            if (j.isNetWorkAvailable()) {
                this.Yc.setNextPage(this.gCf);
                this.gCf.showEmptyView(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
                this.gCf.setOnClickListener(null);
                if (this.hasMore) {
                    this.gCf.showLoading();
                    this.kkl.czE();
                    return;
                }
                this.gCf.setText(this.kjb.getResources().getString(R.string.list_has_no_more));
                this.gCf.endLoadData();
                return;
            }
            this.Yc.setNextPage(null);
        }
    }

    public a(HomePageTabFeedFragment homePageTabFeedFragment, c cVar, ViewGroup viewGroup, String str) {
        this.kjb = homePageTabFeedFragment;
        this.kkl = cVar;
        this.tabName = str;
        bf(viewGroup);
        this.kkv = new com.baidu.tieba.homepage.tabfeed.a(homePageTabFeedFragment, this.Yc);
        this.kkv.setTabName(str);
        lU(false);
    }

    private void bf(ViewGroup viewGroup) {
        this.mRootView = viewGroup;
        this.Yc = (BdTypeRecyclerView) viewGroup.findViewById(R.id.tab_feed_recycler_view);
        this.Yc.setLayoutManager(new LinearLayoutManager(this.kjb.getContext()));
        this.Yc.setFadingEdgeLength(0);
        this.Yc.setOverScrollMode(2);
        this.Yc.setOnSrollToBottomListener(this.gXN);
        this.Yc.addOnScrollListener(this.ioM);
        this.mPullView = new g(this.kjb.getPageContext());
        this.mPullView.setListPullRefreshListener(this.kkl);
        this.Yc.setRecyclerListener(new RecyclerView.RecyclerListener() { // from class: com.baidu.tieba.homepage.tabfeed.view.a.4
            @Override // androidx.recyclerview.widget.RecyclerView.RecyclerListener
            public void onViewRecycled(RecyclerView.ViewHolder viewHolder) {
                View view = viewHolder.itemView;
                if (view != null && a.this.iOh != null) {
                    a.this.iOh.dv(view);
                }
            }
        });
        int dimenPixelSize = UtilHelper.getDimenPixelSize(R.dimen.M_W_X004);
        this.Yc.setPadding(dimenPixelSize, 0, dimenPixelSize, 0);
        this.gCf = new PbListView(this.kjb.getPageContext().getPageActivity());
        this.gCf.getView();
        this.gCf.setContainerBackgroundColorResId(R.color.transparent);
        this.gCf.setHeight(l.getDimens(this.kjb.getPageContext().getPageActivity(), R.dimen.tbds182));
        this.gCf.setLineGone();
        this.gCf.setTextSize(R.dimen.tbfontsize33);
        this.gCf.setTextColor(ao.getColor(R.color.CAM_X0107));
        this.gCf.setNoMoreTextColorId(R.color.CAM_X0110);
        this.gCf.bxD();
        this.gCf.setOnClickListener(this.iOj);
        if (this.gEz == null) {
            this.gEz = (BdSwipeRefreshLayout) viewGroup.findViewById(R.id.tab_feed_pull_refresh_layout);
            this.gEz.setProgressView(this.mPullView);
        }
        this.kkt = new bb();
        this.iOd = new SmartBubbleAnimatedView(this.kjb.getContext());
        this.iOd.setLayoutParams(new FrameLayout.LayoutParams(-1, l.getDimens(this.kjb.getContext(), R.dimen.tbds83)));
        if (this.iOh == null) {
            this.iOh = new i(this.kjb.getPageContext(), this.Yc);
            this.iOh.ID(1);
            this.iOh.setUniqueId(this.kjb.getUniqueId());
        }
    }

    public void b(com.baidu.tieba.homepage.tabfeed.data.c cVar) {
        lU(false);
        if (cVar != null && this.kkv != null && this.Yc != null && this.gCf != null) {
            this.hasMore = cVar.hasMore;
            if (cVar.kkj != null || cVar.kkk != null) {
                if (this.kku == null) {
                    this.kku = new HomePageTabFeedHeaderView(this.kjb.getContext());
                    this.Yc.addHeaderView(this.kku);
                }
                this.kku.setData(cVar);
            } else if (this.kku != null && this.kku.getParent() != null) {
                this.Yc.removeHeaderView(this.kku);
                this.kku = null;
            }
            if (cVar.kii > 0) {
                int firstVisiblePosition = this.Yc.getFirstVisiblePosition();
                View childAt = this.Yc.getChildAt(0);
                int top = childAt == null ? 0 : childAt.getTop();
                RecyclerView.LayoutManager layoutManager = this.Yc.getLayoutManager();
                int i = firstVisiblePosition - cVar.kii;
                if (layoutManager instanceof LinearLayoutManager) {
                    this.Yc.qv();
                    ((LinearLayoutManager) layoutManager).scrollToPositionWithOffset(i, top);
                    this.Yc.qw();
                }
            }
            this.kkv.setData(cVar.kki);
            this.kkv.notifyDataSetChanged();
            if (this.iOh != null) {
                this.iOh.b(this.Yc.getFirstVisiblePosition(), this.Yc.getLastVisiblePosition(), false, true);
            }
        }
    }

    public void onDestroy() {
        if (this.iOh != null) {
            this.iOh.destroy();
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mPullView != null) {
            this.mPullView.changeSkin(i);
        }
        if (this.gCf != null) {
            this.gCf.setTextColor(ao.getColor(R.color.CAM_X0107));
            this.gCf.changeSkin(i);
        }
        if (this.kku != null) {
            this.kku.onChangeSkinType(i);
        }
        if (this.kkv != null) {
            this.kkv.notifyDataSetChanged();
        }
        if (this.iOd != null) {
            this.iOd.onChangeSkinType(i);
        }
    }

    public void resume() {
        if (this.iOh != null) {
            this.iOh.tE(true);
            if (this.Yc != null) {
                this.iOh.b(this.Yc.getFirstVisiblePosition(), this.Yc.getLastVisiblePosition(), false, true);
            }
        }
    }

    public void pause() {
        if (this.iOh != null) {
            this.iOh.dew();
            this.iOh.tE(false);
        }
    }

    public void czR() {
        if (this.Yc != null) {
            this.Yc.scrollToPosition(0);
        }
    }

    public void lU(boolean z) {
        if (this.gEz != null) {
            this.gEz.setRefreshing(z);
        }
    }

    public void pW(boolean z) {
        if (this.gEz != null) {
            this.gEz.setVisibility(z ? 0 : 8);
        }
    }

    public boolean czS() {
        return this.Yc == null || this.Yc.getChildCount() == 0 || this.Yc.getChildAt(0).getTop() == 0;
    }
}
