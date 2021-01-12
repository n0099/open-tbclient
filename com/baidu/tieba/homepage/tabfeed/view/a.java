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
    private BdTypeRecyclerView Ya;
    private PbListView gxy;
    private BdSwipeRefreshLayout gzS;
    private i iJA;
    private SmartBubbleAnimatedView iJw;
    private HomePageTabFeedFragment keu;
    private c kfF;
    private bb kfN;
    private HomePageTabFeedHeaderView kfO;
    private com.baidu.tieba.homepage.tabfeed.a kfP;
    private g mPullView;
    private ViewGroup mRootView;
    private String tabName;
    private boolean hasMore = true;
    private BdListView.e gTh = new BdListView.e() { // from class: com.baidu.tieba.homepage.tabfeed.view.a.1
        @Override // com.baidu.adp.widget.ListView.BdListView.e
        public void onScrollToBottom() {
            if (a.this.Ya != null) {
                a.this.Ya.stopScroll();
            }
            a.this.Vo();
        }
    };
    private RecyclerView.OnScrollListener ikd = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.homepage.tabfeed.view.a.2
        private boolean fgG;

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i) {
            if (i == 0) {
                if (a.this.iJA != null) {
                    a.this.iJA.b(a.this.Ya.getFirstVisiblePosition(), a.this.Ya.getLastVisiblePosition(), this.fgG, true);
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001630, Boolean.valueOf(a.this.cwa() ? false : true)));
                s.crj().bOb();
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrolled(RecyclerView recyclerView, int i, int i2) {
            super.onScrolled(recyclerView, i, i2);
            if (i2 > 0) {
                this.fgG = false;
            } else {
                this.fgG = true;
            }
        }
    };
    private View.OnClickListener iJC = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.tabfeed.view.a.3
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (a.this.Ya != null) {
                a.this.Ya.stopScroll();
            }
            if (a.this.gxy != null && a.this.kfF != null && j.isNetWorkAvailable()) {
                a.this.gxy.showEmptyView(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
                a.this.gxy.setOnClickListener(null);
                if (a.this.hasMore) {
                    a.this.gxy.showLoading();
                    a.this.kfF.cvM();
                }
            }
        }
    };

    public void Vo() {
        if (this.gxy != null && this.kfF != null) {
            if (j.isNetWorkAvailable()) {
                this.Ya.setNextPage(this.gxy);
                this.gxy.showEmptyView(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
                this.gxy.setOnClickListener(null);
                if (this.hasMore) {
                    this.gxy.showLoading();
                    this.kfF.cvM();
                    return;
                }
                this.gxy.setText(this.keu.getResources().getString(R.string.list_has_no_more));
                this.gxy.endLoadData();
                return;
            }
            this.Ya.setNextPage(null);
        }
    }

    public a(HomePageTabFeedFragment homePageTabFeedFragment, c cVar, ViewGroup viewGroup, String str) {
        this.keu = homePageTabFeedFragment;
        this.kfF = cVar;
        this.tabName = str;
        bf(viewGroup);
        this.kfP = new com.baidu.tieba.homepage.tabfeed.a(homePageTabFeedFragment, this.Ya);
        this.kfP.setTabName(str);
        lQ(false);
    }

    private void bf(ViewGroup viewGroup) {
        this.mRootView = viewGroup;
        this.Ya = (BdTypeRecyclerView) viewGroup.findViewById(R.id.tab_feed_recycler_view);
        this.Ya.setLayoutManager(new LinearLayoutManager(this.keu.getContext()));
        this.Ya.setFadingEdgeLength(0);
        this.Ya.setOverScrollMode(2);
        this.Ya.setOnSrollToBottomListener(this.gTh);
        this.Ya.addOnScrollListener(this.ikd);
        this.mPullView = new g(this.keu.getPageContext());
        this.mPullView.setListPullRefreshListener(this.kfF);
        this.Ya.setRecyclerListener(new RecyclerView.RecyclerListener() { // from class: com.baidu.tieba.homepage.tabfeed.view.a.4
            @Override // androidx.recyclerview.widget.RecyclerView.RecyclerListener
            public void onViewRecycled(RecyclerView.ViewHolder viewHolder) {
                View view = viewHolder.itemView;
                if (view != null && a.this.iJA != null) {
                    a.this.iJA.dv(view);
                }
            }
        });
        int dimenPixelSize = UtilHelper.getDimenPixelSize(R.dimen.M_W_X004);
        this.Ya.setPadding(dimenPixelSize, 0, dimenPixelSize, 0);
        this.gxy = new PbListView(this.keu.getPageContext().getPageActivity());
        this.gxy.getView();
        this.gxy.setContainerBackgroundColorResId(R.color.transparent);
        this.gxy.setHeight(l.getDimens(this.keu.getPageContext().getPageActivity(), R.dimen.tbds182));
        this.gxy.setLineGone();
        this.gxy.setTextSize(R.dimen.tbfontsize33);
        this.gxy.setTextColor(ao.getColor(R.color.CAM_X0107));
        this.gxy.setNoMoreTextColorId(R.color.CAM_X0110);
        this.gxy.btJ();
        this.gxy.setOnClickListener(this.iJC);
        if (this.gzS == null) {
            this.gzS = (BdSwipeRefreshLayout) viewGroup.findViewById(R.id.tab_feed_pull_refresh_layout);
            this.gzS.setProgressView(this.mPullView);
        }
        this.kfN = new bb();
        this.iJw = new SmartBubbleAnimatedView(this.keu.getContext());
        this.iJw.setLayoutParams(new FrameLayout.LayoutParams(-1, l.getDimens(this.keu.getContext(), R.dimen.tbds83)));
        if (this.iJA == null) {
            this.iJA = new i(this.keu.getPageContext(), this.Ya);
            this.iJA.GW(1);
            this.iJA.setUniqueId(this.keu.getUniqueId());
        }
    }

    public void b(com.baidu.tieba.homepage.tabfeed.data.c cVar) {
        lQ(false);
        if (cVar != null && this.kfP != null && this.Ya != null && this.gxy != null) {
            this.hasMore = cVar.hasMore;
            if (cVar.kfD != null || cVar.kfE != null) {
                if (this.kfO == null) {
                    this.kfO = new HomePageTabFeedHeaderView(this.keu.getContext());
                    this.Ya.addHeaderView(this.kfO);
                }
                this.kfO.setData(cVar);
            } else if (this.kfO != null && this.kfO.getParent() != null) {
                this.Ya.removeHeaderView(this.kfO);
                this.kfO = null;
            }
            if (cVar.kdB > 0) {
                int firstVisiblePosition = this.Ya.getFirstVisiblePosition();
                View childAt = this.Ya.getChildAt(0);
                int top = childAt == null ? 0 : childAt.getTop();
                RecyclerView.LayoutManager layoutManager = this.Ya.getLayoutManager();
                int i = firstVisiblePosition - cVar.kdB;
                if (layoutManager instanceof LinearLayoutManager) {
                    this.Ya.qv();
                    ((LinearLayoutManager) layoutManager).scrollToPositionWithOffset(i, top);
                    this.Ya.qw();
                }
            }
            this.kfP.setData(cVar.kfC);
            this.kfP.notifyDataSetChanged();
            if (this.iJA != null) {
                this.iJA.b(this.Ya.getFirstVisiblePosition(), this.Ya.getLastVisiblePosition(), false, true);
            }
        }
    }

    public void onDestroy() {
        if (this.iJA != null) {
            this.iJA.destroy();
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mPullView != null) {
            this.mPullView.changeSkin(i);
        }
        if (this.gxy != null) {
            this.gxy.setTextColor(ao.getColor(R.color.CAM_X0107));
            this.gxy.changeSkin(i);
        }
        if (this.kfO != null) {
            this.kfO.onChangeSkinType(i);
        }
        if (this.kfP != null) {
            this.kfP.notifyDataSetChanged();
        }
        if (this.iJw != null) {
            this.iJw.onChangeSkinType(i);
        }
    }

    public void resume() {
        if (this.iJA != null) {
            this.iJA.tA(true);
            if (this.Ya != null) {
                this.iJA.b(this.Ya.getFirstVisiblePosition(), this.Ya.getLastVisiblePosition(), false, true);
            }
        }
    }

    public void pause() {
        if (this.iJA != null) {
            this.iJA.daE();
            this.iJA.tA(false);
        }
    }

    public void cvZ() {
        if (this.Ya != null) {
            this.Ya.scrollToPosition(0);
        }
    }

    public void lQ(boolean z) {
        if (this.gzS != null) {
            this.gzS.setRefreshing(z);
        }
    }

    public void pS(boolean z) {
        if (this.gzS != null) {
            this.gzS.setVisibility(z ? 0 : 8);
        }
    }

    public boolean cwa() {
        return this.Ya == null || this.Ya.getChildCount() == 0 || this.Ya.getChildAt(0).getTop() == 0;
    }
}
