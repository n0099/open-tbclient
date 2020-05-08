package com.baidu.tieba.enterForum.tabfeed.view;

import android.graphics.Typeface;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.j;
import com.baidu.adp.lib.util.l;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.adp.widget.refresh.BdSwipeRefreshLayout;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.core.view.PbListView;
import com.baidu.tbadk.core.view.h;
import com.baidu.tieba.R;
import com.baidu.tieba.enterForum.tabfeed.EnterForumTabFeedFragment;
import com.baidu.tieba.enterForum.view.RecommendForumHorizontalView;
import com.baidu.tieba.frs.SmartBubbleAnimatedView;
import com.baidu.tieba.frs.aw;
import com.baidu.tieba.play.m;
/* loaded from: classes9.dex */
public class a {
    private TextView dko;
    private PbListView ePr;
    private BdSwipeRefreshLayout eRB;
    private EnterForumTabFeedFragment gGv;
    private BdTypeRecyclerView gGw;
    private RecommendForumHorizontalView gHA;
    private m gHB;
    private com.baidu.tieba.enterForum.tabfeed.a gHC;
    private com.baidu.tieba.enterForum.tabfeed.b gHn;
    private ViewGroup gHv;
    private aw gHw;
    private SmartBubbleAnimatedView gHx;
    private b gHy;
    private boolean gHz;
    private boolean hasMore;
    private h mPullView;
    private String tabName;
    private BdListView.e fhw = new BdListView.e() { // from class: com.baidu.tieba.enterForum.tabfeed.view.a.1
        @Override // com.baidu.adp.widget.ListView.BdListView.e
        public void onScrollToBottom() {
            if (a.this.gGw != null) {
                a.this.gGw.stopScroll();
            }
            if (a.this.ePr != null && a.this.gHn != null) {
                if (j.isNetWorkAvailable()) {
                    a.this.gGw.setNextPage(a.this.ePr);
                    a.this.ePr.showEmptyView(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
                    a.this.ePr.setOnClickListener(null);
                    if (a.this.hasMore) {
                        a.this.ePr.showLoading();
                        a.this.gHn.bJt();
                        return;
                    }
                    a.this.ePr.setText(a.this.gGv.getResources().getString(R.string.list_has_no_more));
                    a.this.ePr.endLoadData();
                    return;
                }
                a.this.gGw.setNextPage(null);
            }
        }
    };
    private RecyclerView.OnScrollListener gio = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.enterForum.tabfeed.view.a.2
        private boolean gHF;

        @Override // android.support.v7.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i) {
            if (i == 0) {
                if (a.this.gHB != null) {
                    a.this.gHB.a(a.this.gGw.getFirstVisiblePosition(), a.this.gGw.getLastVisiblePosition(), this.gHF, true);
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001630, Boolean.valueOf(a.this.bJF() ? false : true)));
            }
        }

        @Override // android.support.v7.widget.RecyclerView.OnScrollListener
        public void onScrolled(RecyclerView recyclerView, int i, int i2) {
            super.onScrolled(recyclerView, i, i2);
            if (i2 > 0) {
                this.gHF = false;
            } else {
                this.gHF = true;
            }
        }
    };
    private View.OnClickListener gHD = new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.tabfeed.view.a.3
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (a.this.gGw != null) {
                a.this.gGw.stopScroll();
            }
            if (a.this.ePr != null && a.this.gHn != null && j.isNetWorkAvailable()) {
                a.this.ePr.showEmptyView(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
                a.this.ePr.setOnClickListener(null);
                if (a.this.hasMore) {
                    a.this.ePr.showLoading();
                    a.this.gHn.bJt();
                }
            }
        }
    };

    public a(EnterForumTabFeedFragment enterForumTabFeedFragment, com.baidu.tieba.enterForum.tabfeed.b bVar, ViewGroup viewGroup, String str) {
        this.gGv = enterForumTabFeedFragment;
        this.gHn = bVar;
        this.tabName = str;
        aC(viewGroup);
        this.gHC = new com.baidu.tieba.enterForum.tabfeed.a(enterForumTabFeedFragment, this.gGw);
        it(false);
    }

    private void aC(ViewGroup viewGroup) {
        this.gHv = viewGroup;
        this.gGw = (BdTypeRecyclerView) viewGroup.findViewById(R.id.tab_feed_recycler_view);
        this.gGw.setLayoutManager(new LinearLayoutManager(this.gGv.getContext()));
        this.gGw.setFadingEdgeLength(0);
        this.gGw.setOverScrollMode(2);
        this.gGw.setOnSrollToBottomListener(this.fhw);
        this.gGw.addOnScrollListener(this.gio);
        this.mPullView = new h(this.gGv.getPageContext());
        this.mPullView.setListPullRefreshListener(this.gHn);
        this.gGw.setRecyclerListener(new RecyclerView.RecyclerListener() { // from class: com.baidu.tieba.enterForum.tabfeed.view.a.4
            @Override // android.support.v7.widget.RecyclerView.RecyclerListener
            public void onViewRecycled(RecyclerView.ViewHolder viewHolder) {
                View view = viewHolder.itemView;
                if (view != null && a.this.gHB != null) {
                    a.this.gHB.ct(view);
                }
            }
        });
        this.ePr = new PbListView(this.gGv.getPageContext().getPageActivity());
        this.ePr.getView();
        this.ePr.setContainerBackgroundColorResId(R.color.cp_bg_line_e);
        this.ePr.setHeight(l.getDimens(this.gGv.getPageContext().getPageActivity(), R.dimen.tbds182));
        this.ePr.setLineGone();
        this.ePr.setTextSize(R.dimen.tbfontsize33);
        this.ePr.setTextColor(am.getColor(R.color.cp_cont_j));
        this.ePr.setNoMoreTextColorId(R.color.cp_cont_e);
        this.ePr.aQa();
        this.ePr.setOnClickListener(this.gHD);
        if (this.eRB == null) {
            this.eRB = (BdSwipeRefreshLayout) viewGroup.findViewById(R.id.tab_feed_pull_refresh_layout);
            this.eRB.setProgressView(this.mPullView);
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.eRB.getLayoutParams();
            marginLayoutParams.topMargin = UtilHelper.getStatusBarHeight() + l.getDimens(this.gGv.getPageContext().getPageActivity(), R.dimen.tbds219);
            this.eRB.setLayoutParams(marginLayoutParams);
        }
        this.gHw = new aw();
        this.gHx = new SmartBubbleAnimatedView(this.gGv.getContext());
        this.gHx.setLayoutParams(new FrameLayout.LayoutParams(-1, l.getDimens(this.gGv.getContext(), R.dimen.tbds83)));
        if (this.gHB == null) {
            this.gHB = new m(this.gGv.getPageContext(), this.gGw);
            this.gHB.AZ(1);
            this.gHB.setUniqueId(this.gGv.getUniqueId());
        }
        this.gHy = new b(this.gGv.getPageContext());
        this.gHy.setTabName(this.tabName);
    }

    public void b(com.baidu.tieba.enterForum.tabfeed.b.b bVar) {
        if (bVar != null) {
            this.hasMore = bVar.hasMore;
        }
        it(false);
        if (bVar != null && this.gHC != null && this.gGw != null && this.ePr != null) {
            bJD();
            d(bVar);
            c(bVar);
            if (bVar.gHh > 0) {
                int firstVisiblePosition = this.gGw.getFirstVisiblePosition();
                View childAt = this.gGw.getChildAt(0);
                int top2 = childAt == null ? 0 : childAt.getTop();
                RecyclerView.LayoutManager layoutManager = this.gGw.getLayoutManager();
                int i = firstVisiblePosition - bVar.gHh;
                if (layoutManager instanceof LinearLayoutManager) {
                    this.gGw.oQ();
                    ((LinearLayoutManager) layoutManager).scrollToPositionWithOffset(i, top2);
                    this.gGw.oR();
                }
                bVar.gHh = 0;
            }
            this.gHC.setIsFromCDN(bVar.agw);
            this.gHC.setData(bVar.gHg);
            this.gHC.notifyDataSetChanged();
            if (bVar.etP) {
                sw(bVar.refreshCount);
            }
            if (this.gHB != null) {
                this.gHB.a(this.gGw.getFirstVisiblePosition(), this.gGw.getLastVisiblePosition(), false, true);
            }
        }
    }

    private void bJD() {
        if (this.dko == null) {
            this.dko = new TextView(this.gGv.getContext());
            this.dko.setPadding(l.getDimens(this.gGv.getContext(), R.dimen.tbds44), l.getDimens(this.gGv.getContext(), R.dimen.tbds60), 0, l.getDimens(this.gGv.getContext(), R.dimen.tbds24));
            this.dko.setText(R.string.tab_feed_title);
            this.dko.setTextSize(0, l.getDimens(this.gGv.getContext(), R.dimen.tbds46));
            this.dko.setTypeface(Typeface.DEFAULT_BOLD);
            this.gGw.removeHeaderView(this.dko);
            this.gGw.addHeaderView(this.dko, 0);
            am.setViewTextColor(this.dko, (int) R.color.cp_cont_b);
        }
    }

    private void c(com.baidu.tieba.enterForum.tabfeed.b.b bVar) {
        if (bVar != null && this.gGw != null && this.gGv != null && bVar.etP) {
            if (!((bVar.gHf == null || v.isEmpty(bVar.gHf.bHW())) ? false : true)) {
                if (this.gHA != null) {
                    this.gGw.removeHeaderView(this.gHA);
                    return;
                }
                return;
            }
            if (this.gHA == null) {
                this.gHA = new RecommendForumHorizontalView(this.gGv.getPageContext());
                this.gHA.setShowMore(true);
                this.gHA.setSquareEntranceAtStart(true);
                this.gHA.setTabName(this.tabName);
                this.gHA.setFrom(1);
            }
            this.gHA.b(bVar.gHf);
            this.gGw.removeHeaderView(this.gHA);
            this.gGw.addHeaderView(this.gHA, 0);
            an anVar = new an("c13641");
            anVar.t("uid", TbadkApplication.getCurrentAccountId());
            anVar.af("obj_locate", 2);
            anVar.cI("resource_id", this.tabName);
            TiebaStatic.log(anVar);
        }
    }

    private void d(com.baidu.tieba.enterForum.tabfeed.b.b bVar) {
        if (bVar.gHi != null && bVar.gHi.hot_user != null && bVar.gHi.hot_user.size() > 0 && !TextUtils.isEmpty(bVar.gHi.module_name)) {
            this.gHy.a(bVar.gHi);
            if (this.gHy.getView().getParent() == null && !this.gHz) {
                this.gHz = true;
                this.gGw.addHeaderView(this.gHy.getView(), 0);
                an anVar = new an("c13656");
                anVar.t("uid", TbadkApplication.getCurrentAccountId());
                anVar.cI("resource_id", this.tabName);
                TiebaStatic.log(anVar);
                return;
            }
            return;
        }
        this.gHz = false;
        this.gGw.removeHeaderView(this.gHy.getView());
    }

    public void onChangeSkinType(int i) {
        if (this.mPullView != null) {
            this.mPullView.changeSkin(i);
        }
        if (this.ePr != null) {
            this.ePr.setTextColor(am.getColor(R.color.cp_cont_j));
            this.ePr.changeSkin(i);
        }
        if (this.gHC != null) {
            this.gHC.notifyDataSetChanged();
        }
        if (this.dko != null) {
            am.setViewTextColor(this.dko, (int) R.color.cp_cont_b);
        }
        if (this.gHy != null) {
            this.gHy.onChangeSkinType();
        }
        if (this.gHA != null) {
            this.gHA.onChangeSkinType();
        }
        if (this.gHx != null) {
            this.gHx.onChangeSkinType(i);
        }
    }

    public void resume() {
        if (this.gHB != null) {
            this.gHB.pL(true);
            if (this.gGw != null) {
                this.gHB.a(this.gGw.getFirstVisiblePosition(), this.gGw.getLastVisiblePosition(), false, true);
            }
        }
    }

    public void pause() {
        if (this.gHB != null) {
            this.gHB.cnL();
            this.gHB.pL(false);
        }
    }

    public void bJE() {
        if (this.gGw != null) {
            this.gGw.scrollToPosition(0);
        }
    }

    public void it(boolean z) {
        if (this.eRB != null) {
            this.eRB.setRefreshing(z);
        }
    }

    public void lX(boolean z) {
        if (this.eRB != null) {
            this.eRB.setVisibility(z ? 0 : 8);
        }
    }

    public boolean bJF() {
        return this.gGw == null || this.gGw.getChildCount() == 0 || this.gGw.getChildAt(0).getTop() == 0;
    }

    private void sw(int i) {
        String string;
        if (i >= 0) {
            this.gHw.bQE();
            if (i > 0) {
                string = String.format(TbadkCoreApplication.getInst().getString(R.string.recommend_frs_refresh_return), Integer.valueOf(i));
            } else {
                string = TbadkCoreApplication.getInst().getString(R.string.recommend_frs_refresh_nodata);
            }
            if (!TextUtils.isEmpty(string) && j.isNetWorkAvailable()) {
                this.gHx.dHw = string;
                this.gHx.hcC = 2000L;
                FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
                layoutParams.gravity = 49;
                layoutParams.topMargin = UtilHelper.getStatusBarHeight() + l.getDimens(this.gGv.getPageContext().getPageActivity(), R.dimen.tbds228);
                if (this.gHv != null) {
                    this.gHv.removeView(this.gHx);
                    this.gHv.addView(this.gHx, layoutParams);
                    this.gHx.bQC();
                }
            }
        }
    }

    public void bI(int i, int i2) {
        if (this.gGw != null && i < i2) {
            this.gGw.l(i, i2);
        }
    }
}
