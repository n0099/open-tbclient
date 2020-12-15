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
    private PbListView grg;
    private BdSwipeRefreshLayout gtA;
    private SmartBubbleAnimatedView iBR;
    private i iBV;
    private HomePageTabFeedFragment jVP;
    private c jWZ;
    private be jXh;
    private HomePageTabFeedHeaderView jXi;
    private com.baidu.tieba.homepage.tabfeed.a jXj;
    private g mPullView;
    private ViewGroup mRootView;
    private String tabName;
    private boolean hasMore = true;
    private BdListView.e gMb = new BdListView.e() { // from class: com.baidu.tieba.homepage.tabfeed.view.a.1
        @Override // com.baidu.adp.widget.ListView.BdListView.e
        public void onScrollToBottom() {
            if (a.this.Yf != null) {
                a.this.Yf.stopScroll();
            }
            a.this.XZ();
        }
    };
    private RecyclerView.OnScrollListener icm = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.homepage.tabfeed.view.a.2
        private boolean fbI;

        @Override // android.support.v7.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i) {
            if (i == 0) {
                if (a.this.iBV != null) {
                    a.this.iBV.a(a.this.Yf.getFirstVisiblePosition(), a.this.Yf.getLastVisiblePosition(), this.fbI, true);
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001630, Boolean.valueOf(a.this.cwY() ? false : true)));
                t.csh().bPs();
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
    private View.OnClickListener iBX = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.tabfeed.view.a.3
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (a.this.Yf != null) {
                a.this.Yf.stopScroll();
            }
            if (a.this.grg != null && a.this.jWZ != null && j.isNetWorkAvailable()) {
                a.this.grg.showEmptyView(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
                a.this.grg.setOnClickListener(null);
                if (a.this.hasMore) {
                    a.this.grg.showLoading();
                    a.this.jWZ.cwK();
                }
            }
        }
    };

    public void XZ() {
        if (this.grg != null && this.jWZ != null) {
            if (j.isNetWorkAvailable()) {
                this.Yf.setNextPage(this.grg);
                this.grg.showEmptyView(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
                this.grg.setOnClickListener(null);
                if (this.hasMore) {
                    this.grg.showLoading();
                    this.jWZ.cwK();
                    return;
                }
                this.grg.setText(this.jVP.getResources().getString(R.string.list_has_no_more));
                this.grg.endLoadData();
                return;
            }
            this.Yf.setNextPage(null);
        }
    }

    public a(HomePageTabFeedFragment homePageTabFeedFragment, c cVar, ViewGroup viewGroup, String str) {
        this.jVP = homePageTabFeedFragment;
        this.jWZ = cVar;
        this.tabName = str;
        aT(viewGroup);
        this.jXj = new com.baidu.tieba.homepage.tabfeed.a(homePageTabFeedFragment, this.Yf);
        this.jXj.setTabName(str);
        lx(false);
    }

    private void aT(ViewGroup viewGroup) {
        this.mRootView = viewGroup;
        this.Yf = (BdTypeRecyclerView) viewGroup.findViewById(R.id.tab_feed_recycler_view);
        this.Yf.setLayoutManager(new LinearLayoutManager(this.jVP.getContext()));
        this.Yf.setFadingEdgeLength(0);
        this.Yf.setOverScrollMode(2);
        this.Yf.setOnSrollToBottomListener(this.gMb);
        this.Yf.addOnScrollListener(this.icm);
        this.mPullView = new g(this.jVP.getPageContext());
        this.mPullView.setListPullRefreshListener(this.jWZ);
        this.Yf.setRecyclerListener(new RecyclerView.RecyclerListener() { // from class: com.baidu.tieba.homepage.tabfeed.view.a.4
            @Override // android.support.v7.widget.RecyclerView.RecyclerListener
            public void onViewRecycled(RecyclerView.ViewHolder viewHolder) {
                View view = viewHolder.itemView;
                if (view != null && a.this.iBV != null) {
                    a.this.iBV.dl(view);
                }
            }
        });
        int dimenPixelSize = UtilHelper.getDimenPixelSize(R.dimen.M_W_X004);
        this.Yf.setPadding(dimenPixelSize, 0, dimenPixelSize, 0);
        this.grg = new PbListView(this.jVP.getPageContext().getPageActivity());
        this.grg.getView();
        this.grg.setContainerBackgroundColorResId(R.color.transparent);
        this.grg.setHeight(l.getDimens(this.jVP.getPageContext().getPageActivity(), R.dimen.tbds182));
        this.grg.setLineGone();
        this.grg.setTextSize(R.dimen.tbfontsize33);
        this.grg.setTextColor(ap.getColor(R.color.CAM_X0107));
        this.grg.setNoMoreTextColorId(R.color.CAM_X0110);
        this.grg.bvh();
        this.grg.setOnClickListener(this.iBX);
        if (this.gtA == null) {
            this.gtA = (BdSwipeRefreshLayout) viewGroup.findViewById(R.id.tab_feed_pull_refresh_layout);
            this.gtA.setProgressView(this.mPullView);
        }
        this.jXh = new be();
        this.iBR = new SmartBubbleAnimatedView(this.jVP.getContext());
        this.iBR.setLayoutParams(new FrameLayout.LayoutParams(-1, l.getDimens(this.jVP.getContext(), R.dimen.tbds83)));
        if (this.iBV == null) {
            this.iBV = new i(this.jVP.getPageContext(), this.Yf);
            this.iBV.IJ(1);
            this.iBV.setUniqueId(this.jVP.getUniqueId());
        }
    }

    public void b(com.baidu.tieba.homepage.tabfeed.data.c cVar) {
        lx(false);
        if (cVar != null && this.jXj != null && this.Yf != null && this.grg != null) {
            this.hasMore = cVar.hasMore;
            if (cVar.jWX != null || cVar.jWY != null) {
                if (this.jXi == null) {
                    this.jXi = new HomePageTabFeedHeaderView(this.jVP.getContext());
                    this.Yf.addHeaderView(this.jXi);
                }
                this.jXi.setData(cVar);
            } else if (this.jXi != null && this.jXi.getParent() != null) {
                this.Yf.removeHeaderView(this.jXi);
                this.jXi = null;
            }
            if (cVar.jUW > 0) {
                int firstVisiblePosition = this.Yf.getFirstVisiblePosition();
                View childAt = this.Yf.getChildAt(0);
                int top = childAt == null ? 0 : childAt.getTop();
                RecyclerView.LayoutManager layoutManager = this.Yf.getLayoutManager();
                int i = firstVisiblePosition - cVar.jUW;
                if (layoutManager instanceof LinearLayoutManager) {
                    this.Yf.qT();
                    ((LinearLayoutManager) layoutManager).scrollToPositionWithOffset(i, top);
                    this.Yf.qU();
                }
            }
            this.jXj.setData(cVar.jWW);
            this.jXj.notifyDataSetChanged();
            if (this.iBV != null) {
                this.iBV.a(this.Yf.getFirstVisiblePosition(), this.Yf.getLastVisiblePosition(), false, true);
            }
        }
    }

    public void onDestroy() {
        if (this.iBV != null) {
            this.iBV.destroy();
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mPullView != null) {
            this.mPullView.changeSkin(i);
        }
        if (this.grg != null) {
            this.grg.setTextColor(ap.getColor(R.color.CAM_X0107));
            this.grg.changeSkin(i);
        }
        if (this.jXi != null) {
            this.jXi.onChangeSkinType(i);
        }
        if (this.jXj != null) {
            this.jXj.notifyDataSetChanged();
        }
        if (this.iBR != null) {
            this.iBR.onChangeSkinType(i);
        }
    }

    public void resume() {
        if (this.iBV != null) {
            this.iBV.tC(true);
            if (this.Yf != null) {
                this.iBV.a(this.Yf.getFirstVisiblePosition(), this.Yf.getLastVisiblePosition(), false, true);
            }
        }
    }

    public void pause() {
        if (this.iBV != null) {
            this.iBV.deK();
            this.iBV.tC(false);
        }
    }

    public void cwX() {
        if (this.Yf != null) {
            this.Yf.scrollToPosition(0);
        }
    }

    public void lx(boolean z) {
        if (this.gtA != null) {
            this.gtA.setRefreshing(z);
        }
    }

    public void pz(boolean z) {
        if (this.gtA != null) {
            this.gtA.setVisibility(z ? 0 : 8);
        }
    }

    public boolean cwY() {
        return this.Yf == null || this.Yf.getChildCount() == 0 || this.Yf.getChildAt(0).getTop() == 0;
    }
}
