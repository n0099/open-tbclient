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
    private PbListView gAi;
    private BdSwipeRefreshLayout gCC;
    private SmartBubbleAnimatedView iPe;
    private i iPi;
    private HomePageTabFeedFragment kmD;
    private c knN;
    private bb knV;
    private HomePageTabFeedHeaderView knW;
    private com.baidu.tieba.homepage.tabfeed.a knX;
    private g mPullView;
    private ViewGroup mRootView;
    private String tabName;
    private boolean hasMore = true;
    private BdListView.e gVR = new BdListView.e() { // from class: com.baidu.tieba.homepage.tabfeed.view.a.1
        @Override // com.baidu.adp.widget.ListView.BdListView.e
        public void onScrollToBottom() {
            if (a.this.XW != null) {
                a.this.XW.stopScroll();
            }
            a.this.WX();
        }
    };
    private RecyclerView.OnScrollListener ipL = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.homepage.tabfeed.view.a.2
        private boolean fiZ;

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i) {
            if (i == 0) {
                if (a.this.iPi != null) {
                    a.this.iPi.b(a.this.XW.getFirstVisiblePosition(), a.this.XW.getLastVisiblePosition(), this.fiZ, true);
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001630, Boolean.valueOf(a.this.cxm() ? false : true)));
                t.csu().bOF();
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
    private View.OnClickListener iPk = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.tabfeed.view.a.3
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (a.this.XW != null) {
                a.this.XW.stopScroll();
            }
            if (a.this.gAi != null && a.this.knN != null && j.isNetWorkAvailable()) {
                a.this.gAi.showEmptyView(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
                a.this.gAi.setOnClickListener(null);
                if (a.this.hasMore) {
                    a.this.gAi.showLoading();
                    a.this.knN.cwY();
                }
            }
        }
    };

    public void WX() {
        if (this.gAi != null && this.knN != null) {
            if (j.isNetWorkAvailable()) {
                this.XW.setNextPage(this.gAi);
                this.gAi.showEmptyView(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
                this.gAi.setOnClickListener(null);
                if (this.hasMore) {
                    this.gAi.showLoading();
                    this.knN.cwY();
                    return;
                }
                this.gAi.setText(this.kmD.getResources().getString(R.string.list_has_no_more));
                this.gAi.endLoadData();
                return;
            }
            this.XW.setNextPage(null);
        }
    }

    public a(HomePageTabFeedFragment homePageTabFeedFragment, c cVar, ViewGroup viewGroup, String str) {
        this.kmD = homePageTabFeedFragment;
        this.knN = cVar;
        this.tabName = str;
        bf(viewGroup);
        this.knX = new com.baidu.tieba.homepage.tabfeed.a(homePageTabFeedFragment, this.XW);
        this.knX.setTabName(str);
        lU(false);
    }

    private void bf(ViewGroup viewGroup) {
        this.mRootView = viewGroup;
        this.XW = (BdTypeRecyclerView) viewGroup.findViewById(R.id.tab_feed_recycler_view);
        this.XW.setLayoutManager(new LinearLayoutManager(this.kmD.getContext()));
        this.XW.setFadingEdgeLength(0);
        this.XW.setOverScrollMode(2);
        this.XW.setOnSrollToBottomListener(this.gVR);
        this.XW.addOnScrollListener(this.ipL);
        this.mPullView = new g(this.kmD.getPageContext());
        this.mPullView.setListPullRefreshListener(this.knN);
        this.XW.setRecyclerListener(new RecyclerView.RecyclerListener() { // from class: com.baidu.tieba.homepage.tabfeed.view.a.4
            @Override // androidx.recyclerview.widget.RecyclerView.RecyclerListener
            public void onViewRecycled(RecyclerView.ViewHolder viewHolder) {
                View view = viewHolder.itemView;
                if (view != null && a.this.iPi != null) {
                    a.this.iPi.dt(view);
                }
            }
        });
        int dimenPixelSize = UtilHelper.getDimenPixelSize(R.dimen.M_W_X004);
        this.XW.setPadding(dimenPixelSize, 0, dimenPixelSize, 0);
        this.gAi = new PbListView(this.kmD.getPageContext().getPageActivity());
        this.gAi.getView();
        this.gAi.setContainerBackgroundColorResId(R.color.transparent);
        this.gAi.setHeight(l.getDimens(this.kmD.getPageContext().getPageActivity(), R.dimen.tbds182));
        this.gAi.setLineGone();
        this.gAi.setTextSize(R.dimen.tbfontsize33);
        this.gAi.setTextColor(ap.getColor(R.color.CAM_X0107));
        this.gAi.setNoMoreTextColorId(R.color.CAM_X0110);
        this.gAi.bud();
        this.gAi.setOnClickListener(this.iPk);
        if (this.gCC == null) {
            this.gCC = (BdSwipeRefreshLayout) viewGroup.findViewById(R.id.tab_feed_pull_refresh_layout);
            this.gCC.setProgressView(this.mPullView);
        }
        this.knV = new bb();
        this.iPe = new SmartBubbleAnimatedView(this.kmD.getContext());
        this.iPe.setLayoutParams(new FrameLayout.LayoutParams(-1, l.getDimens(this.kmD.getContext(), R.dimen.tbds83)));
        if (this.iPi == null) {
            this.iPi = new i(this.kmD.getPageContext(), this.XW);
            this.iPi.Ho(1);
            this.iPi.setUniqueId(this.kmD.getUniqueId());
        }
    }

    public void b(com.baidu.tieba.homepage.tabfeed.data.c cVar) {
        lU(false);
        if (cVar != null && this.knX != null && this.XW != null && this.gAi != null) {
            this.hasMore = cVar.hasMore;
            if (cVar.knL != null || cVar.knM != null) {
                if (this.knW == null) {
                    this.knW = new HomePageTabFeedHeaderView(this.kmD.getContext());
                    this.XW.addHeaderView(this.knW);
                }
                this.knW.setData(cVar);
            } else if (this.knW != null && this.knW.getParent() != null) {
                this.XW.removeHeaderView(this.knW);
                this.knW = null;
            }
            if (cVar.klL > 0) {
                int firstVisiblePosition = this.XW.getFirstVisiblePosition();
                View childAt = this.XW.getChildAt(0);
                int top = childAt == null ? 0 : childAt.getTop();
                RecyclerView.LayoutManager layoutManager = this.XW.getLayoutManager();
                int i = firstVisiblePosition - cVar.klL;
                if (layoutManager instanceof LinearLayoutManager) {
                    this.XW.qt();
                    ((LinearLayoutManager) layoutManager).scrollToPositionWithOffset(i, top);
                    this.XW.qu();
                }
            }
            this.knX.setData(cVar.knK);
            this.knX.notifyDataSetChanged();
            if (this.iPi != null) {
                this.iPi.b(this.XW.getFirstVisiblePosition(), this.XW.getLastVisiblePosition(), false, true);
            }
        }
    }

    public void onDestroy() {
        if (this.iPi != null) {
            this.iPi.destroy();
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mPullView != null) {
            this.mPullView.changeSkin(i);
        }
        if (this.gAi != null) {
            this.gAi.setTextColor(ap.getColor(R.color.CAM_X0107));
            this.gAi.changeSkin(i);
        }
        if (this.knW != null) {
            this.knW.onChangeSkinType(i);
        }
        if (this.knX != null) {
            this.knX.notifyDataSetChanged();
        }
        if (this.iPe != null) {
            this.iPe.onChangeSkinType(i);
        }
    }

    public void resume() {
        if (this.iPi != null) {
            this.iPi.tN(true);
            if (this.XW != null) {
                this.iPi.b(this.XW.getFirstVisiblePosition(), this.XW.getLastVisiblePosition(), false, true);
            }
        }
    }

    public void pause() {
        if (this.iPi != null) {
            this.iPi.dcC();
            this.iPi.tN(false);
        }
    }

    public void cxl() {
        if (this.XW != null) {
            this.XW.scrollToPosition(0);
        }
    }

    public void lU(boolean z) {
        if (this.gCC != null) {
            this.gCC.setRefreshing(z);
        }
    }

    public void qc(boolean z) {
        if (this.gCC != null) {
            this.gCC.setVisibility(z ? 0 : 8);
        }
    }

    public boolean cxm() {
        return this.XW == null || this.XW.getChildCount() == 0 || this.XW.getChildAt(0).getTop() == 0;
    }
}
