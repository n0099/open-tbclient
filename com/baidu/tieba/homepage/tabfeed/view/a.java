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
/* loaded from: classes22.dex */
public class a {
    private BdTypeRecyclerView Yf;
    private PbListView gre;
    private BdSwipeRefreshLayout gty;
    private SmartBubbleAnimatedView iBP;
    private i iBT;
    private HomePageTabFeedFragment jVN;
    private c jWX;
    private be jXf;
    private HomePageTabFeedHeaderView jXg;
    private com.baidu.tieba.homepage.tabfeed.a jXh;
    private g mPullView;
    private ViewGroup mRootView;
    private String tabName;
    private boolean hasMore = true;
    private BdListView.e gLZ = new BdListView.e() { // from class: com.baidu.tieba.homepage.tabfeed.view.a.1
        @Override // com.baidu.adp.widget.ListView.BdListView.e
        public void onScrollToBottom() {
            if (a.this.Yf != null) {
                a.this.Yf.stopScroll();
            }
            a.this.XZ();
        }
    };
    private RecyclerView.OnScrollListener ick = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.homepage.tabfeed.view.a.2
        private boolean fbI;

        @Override // android.support.v7.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i) {
            if (i == 0) {
                if (a.this.iBT != null) {
                    a.this.iBT.a(a.this.Yf.getFirstVisiblePosition(), a.this.Yf.getLastVisiblePosition(), this.fbI, true);
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001630, Boolean.valueOf(a.this.cwX() ? false : true)));
                t.csg().bPr();
            }
        }

        @Override // android.support.v7.widget.RecyclerView.OnScrollListener
        public void onScrolled(RecyclerView recyclerView, int i, int i2) {
            super.onScrolled(recyclerView, i, i2);
            if (i2 > 0) {
                this.fbI = false;
            } else {
                this.fbI = true;
            }
        }
    };
    private View.OnClickListener iBV = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.tabfeed.view.a.3
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (a.this.Yf != null) {
                a.this.Yf.stopScroll();
            }
            if (a.this.gre != null && a.this.jWX != null && j.isNetWorkAvailable()) {
                a.this.gre.showEmptyView(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
                a.this.gre.setOnClickListener(null);
                if (a.this.hasMore) {
                    a.this.gre.showLoading();
                    a.this.jWX.cwJ();
                }
            }
        }
    };

    public void XZ() {
        if (this.gre != null && this.jWX != null) {
            if (j.isNetWorkAvailable()) {
                this.Yf.setNextPage(this.gre);
                this.gre.showEmptyView(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
                this.gre.setOnClickListener(null);
                if (this.hasMore) {
                    this.gre.showLoading();
                    this.jWX.cwJ();
                    return;
                }
                this.gre.setText(this.jVN.getResources().getString(R.string.list_has_no_more));
                this.gre.endLoadData();
                return;
            }
            this.Yf.setNextPage(null);
        }
    }

    public a(HomePageTabFeedFragment homePageTabFeedFragment, c cVar, ViewGroup viewGroup, String str) {
        this.jVN = homePageTabFeedFragment;
        this.jWX = cVar;
        this.tabName = str;
        aT(viewGroup);
        this.jXh = new com.baidu.tieba.homepage.tabfeed.a(homePageTabFeedFragment, this.Yf);
        this.jXh.setTabName(str);
        lx(false);
    }

    private void aT(ViewGroup viewGroup) {
        this.mRootView = viewGroup;
        this.Yf = (BdTypeRecyclerView) viewGroup.findViewById(R.id.tab_feed_recycler_view);
        this.Yf.setLayoutManager(new LinearLayoutManager(this.jVN.getContext()));
        this.Yf.setFadingEdgeLength(0);
        this.Yf.setOverScrollMode(2);
        this.Yf.setOnSrollToBottomListener(this.gLZ);
        this.Yf.addOnScrollListener(this.ick);
        this.mPullView = new g(this.jVN.getPageContext());
        this.mPullView.setListPullRefreshListener(this.jWX);
        this.Yf.setRecyclerListener(new RecyclerView.RecyclerListener() { // from class: com.baidu.tieba.homepage.tabfeed.view.a.4
            @Override // android.support.v7.widget.RecyclerView.RecyclerListener
            public void onViewRecycled(RecyclerView.ViewHolder viewHolder) {
                View view = viewHolder.itemView;
                if (view != null && a.this.iBT != null) {
                    a.this.iBT.dl(view);
                }
            }
        });
        int dimenPixelSize = UtilHelper.getDimenPixelSize(R.dimen.M_W_X004);
        this.Yf.setPadding(dimenPixelSize, 0, dimenPixelSize, 0);
        this.gre = new PbListView(this.jVN.getPageContext().getPageActivity());
        this.gre.getView();
        this.gre.setContainerBackgroundColorResId(R.color.transparent);
        this.gre.setHeight(l.getDimens(this.jVN.getPageContext().getPageActivity(), R.dimen.tbds182));
        this.gre.setLineGone();
        this.gre.setTextSize(R.dimen.tbfontsize33);
        this.gre.setTextColor(ap.getColor(R.color.CAM_X0107));
        this.gre.setNoMoreTextColorId(R.color.CAM_X0110);
        this.gre.bvh();
        this.gre.setOnClickListener(this.iBV);
        if (this.gty == null) {
            this.gty = (BdSwipeRefreshLayout) viewGroup.findViewById(R.id.tab_feed_pull_refresh_layout);
            this.gty.setProgressView(this.mPullView);
        }
        this.jXf = new be();
        this.iBP = new SmartBubbleAnimatedView(this.jVN.getContext());
        this.iBP.setLayoutParams(new FrameLayout.LayoutParams(-1, l.getDimens(this.jVN.getContext(), R.dimen.tbds83)));
        if (this.iBT == null) {
            this.iBT = new i(this.jVN.getPageContext(), this.Yf);
            this.iBT.IJ(1);
            this.iBT.setUniqueId(this.jVN.getUniqueId());
        }
    }

    public void b(com.baidu.tieba.homepage.tabfeed.data.c cVar) {
        lx(false);
        if (cVar != null && this.jXh != null && this.Yf != null && this.gre != null) {
            this.hasMore = cVar.hasMore;
            if (cVar.jWV != null || cVar.jWW != null) {
                if (this.jXg == null) {
                    this.jXg = new HomePageTabFeedHeaderView(this.jVN.getContext());
                    this.Yf.addHeaderView(this.jXg);
                }
                this.jXg.setData(cVar);
            } else if (this.jXg != null && this.jXg.getParent() != null) {
                this.Yf.removeHeaderView(this.jXg);
                this.jXg = null;
            }
            if (cVar.jUU > 0) {
                int firstVisiblePosition = this.Yf.getFirstVisiblePosition();
                View childAt = this.Yf.getChildAt(0);
                int top = childAt == null ? 0 : childAt.getTop();
                RecyclerView.LayoutManager layoutManager = this.Yf.getLayoutManager();
                int i = firstVisiblePosition - cVar.jUU;
                if (layoutManager instanceof LinearLayoutManager) {
                    this.Yf.qT();
                    ((LinearLayoutManager) layoutManager).scrollToPositionWithOffset(i, top);
                    this.Yf.qU();
                }
            }
            this.jXh.setData(cVar.jWU);
            this.jXh.notifyDataSetChanged();
            if (this.iBT != null) {
                this.iBT.a(this.Yf.getFirstVisiblePosition(), this.Yf.getLastVisiblePosition(), false, true);
            }
        }
    }

    public void onDestroy() {
        if (this.iBT != null) {
            this.iBT.destroy();
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mPullView != null) {
            this.mPullView.changeSkin(i);
        }
        if (this.gre != null) {
            this.gre.setTextColor(ap.getColor(R.color.CAM_X0107));
            this.gre.changeSkin(i);
        }
        if (this.jXg != null) {
            this.jXg.onChangeSkinType(i);
        }
        if (this.jXh != null) {
            this.jXh.notifyDataSetChanged();
        }
        if (this.iBP != null) {
            this.iBP.onChangeSkinType(i);
        }
    }

    public void resume() {
        if (this.iBT != null) {
            this.iBT.tC(true);
            if (this.Yf != null) {
                this.iBT.a(this.Yf.getFirstVisiblePosition(), this.Yf.getLastVisiblePosition(), false, true);
            }
        }
    }

    public void pause() {
        if (this.iBT != null) {
            this.iBT.deJ();
            this.iBT.tC(false);
        }
    }

    public void cwW() {
        if (this.Yf != null) {
            this.Yf.scrollToPosition(0);
        }
    }

    public void lx(boolean z) {
        if (this.gty != null) {
            this.gty.setRefreshing(z);
        }
    }

    public void pz(boolean z) {
        if (this.gty != null) {
            this.gty.setVisibility(z ? 0 : 8);
        }
    }

    public boolean cwX() {
        return this.Yf == null || this.Yf.getChildCount() == 0 || this.Yf.getChildAt(0).getTop() == 0;
    }
}
