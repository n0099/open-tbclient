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
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.view.PbListView;
import com.baidu.tbadk.core.view.g;
import com.baidu.tieba.R;
import com.baidu.tieba.card.s;
import com.baidu.tieba.frs.SmartBubbleAnimatedView;
import com.baidu.tieba.frs.bc;
import com.baidu.tieba.homepage.tabfeed.HomePageTabFeedFragment;
import com.baidu.tieba.homepage.tabfeed.c;
import com.baidu.tieba.play.i;
/* loaded from: classes16.dex */
public class a {
    private BdTypeRecyclerView VT;
    private PbListView fsC;
    private BdSwipeRefreshLayout fuP;
    private SmartBubbleAnimatedView hoQ;
    private i hoU;
    private HomePageTabFeedFragment iCr;
    private c iDB;
    private bc iDJ;
    private HomePageTabFeedHeaderView iDK;
    private com.baidu.tieba.homepage.tabfeed.a iDL;
    private g mPullView;
    private ViewGroup mRootView;
    private String tabName;
    private boolean hasMore = true;
    private BdListView.e fLV = new BdListView.e() { // from class: com.baidu.tieba.homepage.tabfeed.view.a.1
        @Override // com.baidu.adp.widget.ListView.BdListView.e
        public void onScrollToBottom() {
            if (a.this.VT != null) {
                a.this.VT.stopScroll();
            }
            a.this.bxS();
        }
    };
    private RecyclerView.OnScrollListener gPJ = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.homepage.tabfeed.view.a.2
        private boolean hoZ;

        @Override // android.support.v7.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i) {
            if (i == 0) {
                if (a.this.hoU != null) {
                    a.this.hoU.a(a.this.VT.getFirstVisiblePosition(), a.this.VT.getLastVisiblePosition(), this.hoZ, true);
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001630, Boolean.valueOf(a.this.bWy() ? false : true)));
                s.bRL().bva();
            }
        }

        @Override // android.support.v7.widget.RecyclerView.OnScrollListener
        public void onScrolled(RecyclerView recyclerView, int i, int i2) {
            super.onScrolled(recyclerView, i, i2);
            if (i2 > 0) {
                this.hoZ = false;
            } else {
                this.hoZ = true;
            }
        }
    };
    private View.OnClickListener hoW = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.tabfeed.view.a.3
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (a.this.VT != null) {
                a.this.VT.stopScroll();
            }
            if (a.this.fsC != null && a.this.iDB != null && j.isNetWorkAvailable()) {
                a.this.fsC.showEmptyView(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
                a.this.fsC.setOnClickListener(null);
                if (a.this.hasMore) {
                    a.this.fsC.showLoading();
                    a.this.iDB.bWk();
                }
            }
        }
    };

    public void bxS() {
        if (this.fsC != null && this.iDB != null) {
            if (j.isNetWorkAvailable()) {
                this.VT.setNextPage(this.fsC);
                this.fsC.showEmptyView(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
                this.fsC.setOnClickListener(null);
                if (this.hasMore) {
                    this.fsC.showLoading();
                    this.iDB.bWk();
                    return;
                }
                this.fsC.setText(this.iCr.getResources().getString(R.string.list_has_no_more));
                this.fsC.endLoadData();
                return;
            }
            this.VT.setNextPage(null);
        }
    }

    public a(HomePageTabFeedFragment homePageTabFeedFragment, c cVar, ViewGroup viewGroup, String str) {
        this.iCr = homePageTabFeedFragment;
        this.iDB = cVar;
        this.tabName = str;
        aT(viewGroup);
        this.iDL = new com.baidu.tieba.homepage.tabfeed.a(homePageTabFeedFragment, this.VT);
        this.iDL.setTabName(str);
        jH(false);
    }

    private void aT(ViewGroup viewGroup) {
        this.mRootView = viewGroup;
        this.VT = (BdTypeRecyclerView) viewGroup.findViewById(R.id.tab_feed_recycler_view);
        this.VT.setLayoutManager(new LinearLayoutManager(this.iCr.getContext()));
        this.VT.setFadingEdgeLength(0);
        this.VT.setOverScrollMode(2);
        this.VT.setOnSrollToBottomListener(this.fLV);
        this.VT.addOnScrollListener(this.gPJ);
        this.mPullView = new g(this.iCr.getPageContext());
        this.mPullView.setListPullRefreshListener(this.iDB);
        this.VT.setRecyclerListener(new RecyclerView.RecyclerListener() { // from class: com.baidu.tieba.homepage.tabfeed.view.a.4
            @Override // android.support.v7.widget.RecyclerView.RecyclerListener
            public void onViewRecycled(RecyclerView.ViewHolder viewHolder) {
                View view = viewHolder.itemView;
                if (view != null && a.this.hoU != null) {
                    a.this.hoU.cA(view);
                }
            }
        });
        this.fsC = new PbListView(this.iCr.getPageContext().getPageActivity());
        this.fsC.getView();
        this.fsC.setContainerBackgroundColorResId(R.color.cp_bg_line_e);
        this.fsC.setHeight(l.getDimens(this.iCr.getPageContext().getPageActivity(), R.dimen.tbds182));
        this.fsC.setLineGone();
        this.fsC.setTextSize(R.dimen.tbfontsize33);
        this.fsC.setTextColor(ao.getColor(R.color.cp_cont_j));
        this.fsC.setNoMoreTextColorId(R.color.cp_cont_e);
        this.fsC.bbZ();
        this.fsC.setOnClickListener(this.hoW);
        if (this.fuP == null) {
            this.fuP = (BdSwipeRefreshLayout) viewGroup.findViewById(R.id.tab_feed_pull_refresh_layout);
            this.fuP.setProgressView(this.mPullView);
        }
        this.iDJ = new bc();
        this.hoQ = new SmartBubbleAnimatedView(this.iCr.getContext());
        this.hoQ.setLayoutParams(new FrameLayout.LayoutParams(-1, l.getDimens(this.iCr.getContext(), R.dimen.tbds83)));
        if (this.hoU == null) {
            this.hoU = new i(this.iCr.getPageContext(), this.VT);
            this.hoU.Dm(1);
            this.hoU.setUniqueId(this.iCr.getUniqueId());
        }
    }

    public void b(com.baidu.tieba.homepage.tabfeed.data.c cVar) {
        jH(false);
        if (cVar != null && this.iDL != null && this.VT != null && this.fsC != null) {
            this.hasMore = cVar.hasMore;
            if (cVar.iDz != null || cVar.iDA != null) {
                if (this.iDK == null) {
                    this.iDK = new HomePageTabFeedHeaderView(this.iCr.getContext());
                    this.VT.addHeaderView(this.iDK);
                }
                this.iDK.setData(cVar);
            } else if (this.iDK != null && this.iDK.getParent() != null) {
                this.VT.removeHeaderView(this.iDK);
                this.iDK = null;
            }
            if (cVar.iBq > 0) {
                int firstVisiblePosition = this.VT.getFirstVisiblePosition();
                View childAt = this.VT.getChildAt(0);
                int top = childAt == null ? 0 : childAt.getTop();
                RecyclerView.LayoutManager layoutManager = this.VT.getLayoutManager();
                int i = firstVisiblePosition - cVar.iBq;
                if (layoutManager instanceof LinearLayoutManager) {
                    this.VT.pn();
                    ((LinearLayoutManager) layoutManager).scrollToPositionWithOffset(i, top);
                    this.VT.po();
                }
            }
            this.iDL.setData(cVar.iDy);
            this.iDL.notifyDataSetChanged();
            if (this.hoU != null) {
                this.hoU.a(this.VT.getFirstVisiblePosition(), this.VT.getLastVisiblePosition(), false, true);
            }
        }
    }

    public void onDestroy() {
        if (this.hoU != null) {
            this.hoU.destroy();
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mPullView != null) {
            this.mPullView.changeSkin(i);
        }
        if (this.fsC != null) {
            this.fsC.setTextColor(ao.getColor(R.color.cp_cont_j));
            this.fsC.changeSkin(i);
        }
        if (this.iDK != null) {
            this.iDK.onChangeSkinType(i);
        }
        if (this.iDL != null) {
            this.iDL.notifyDataSetChanged();
        }
        if (this.hoQ != null) {
            this.hoQ.onChangeSkinType(i);
        }
    }

    public void resume() {
        if (this.hoU != null) {
            this.hoU.qZ(true);
            if (this.VT != null) {
                this.hoU.a(this.VT.getFirstVisiblePosition(), this.VT.getLastVisiblePosition(), false, true);
            }
        }
    }

    public void pause() {
        if (this.hoU != null) {
            this.hoU.cCl();
            this.hoU.qZ(false);
        }
    }

    public void bWx() {
        if (this.VT != null) {
            this.VT.scrollToPosition(0);
        }
    }

    public void jH(boolean z) {
        if (this.fuP != null) {
            this.fuP.setRefreshing(z);
        }
    }

    public void ni(boolean z) {
        if (this.fuP != null) {
            this.fuP.setVisibility(z ? 0 : 8);
        }
    }

    public boolean bWy() {
        return this.VT == null || this.VT.getChildCount() == 0 || this.VT.getChildAt(0).getTop() == 0;
    }
}
