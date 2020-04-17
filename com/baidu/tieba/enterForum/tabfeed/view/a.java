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
    private TextView dkk;
    private PbListView ePm;
    private BdSwipeRefreshLayout eRw;
    private EnterForumTabFeedFragment gGp;
    private BdTypeRecyclerView gGq;
    private com.baidu.tieba.enterForum.tabfeed.b gHh;
    private ViewGroup gHp;
    private aw gHq;
    private SmartBubbleAnimatedView gHr;
    private b gHs;
    private boolean gHt;
    private RecommendForumHorizontalView gHu;
    private m gHv;
    private com.baidu.tieba.enterForum.tabfeed.a gHw;
    private boolean hasMore;
    private h mPullView;
    private String tabName;
    private BdListView.e fhr = new BdListView.e() { // from class: com.baidu.tieba.enterForum.tabfeed.view.a.1
        @Override // com.baidu.adp.widget.ListView.BdListView.e
        public void onScrollToBottom() {
            if (a.this.gGq != null) {
                a.this.gGq.stopScroll();
            }
            if (a.this.ePm != null && a.this.gHh != null) {
                if (j.isNetWorkAvailable()) {
                    a.this.gGq.setNextPage(a.this.ePm);
                    a.this.ePm.showEmptyView(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
                    a.this.ePm.setOnClickListener(null);
                    if (a.this.hasMore) {
                        a.this.ePm.showLoading();
                        a.this.gHh.bJv();
                        return;
                    }
                    a.this.ePm.setText(a.this.gGp.getResources().getString(R.string.list_has_no_more));
                    a.this.ePm.endLoadData();
                    return;
                }
                a.this.gGq.setNextPage(null);
            }
        }
    };
    private RecyclerView.OnScrollListener gii = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.enterForum.tabfeed.view.a.2
        private boolean gHz;

        @Override // android.support.v7.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i) {
            if (i == 0) {
                if (a.this.gHv != null) {
                    a.this.gHv.a(a.this.gGq.getFirstVisiblePosition(), a.this.gGq.getLastVisiblePosition(), this.gHz, true);
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001630, Boolean.valueOf(a.this.bJH() ? false : true)));
            }
        }

        @Override // android.support.v7.widget.RecyclerView.OnScrollListener
        public void onScrolled(RecyclerView recyclerView, int i, int i2) {
            super.onScrolled(recyclerView, i, i2);
            if (i2 > 0) {
                this.gHz = false;
            } else {
                this.gHz = true;
            }
        }
    };
    private View.OnClickListener gHx = new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.tabfeed.view.a.3
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (a.this.gGq != null) {
                a.this.gGq.stopScroll();
            }
            if (a.this.ePm != null && a.this.gHh != null && j.isNetWorkAvailable()) {
                a.this.ePm.showEmptyView(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
                a.this.ePm.setOnClickListener(null);
                if (a.this.hasMore) {
                    a.this.ePm.showLoading();
                    a.this.gHh.bJv();
                }
            }
        }
    };

    public a(EnterForumTabFeedFragment enterForumTabFeedFragment, com.baidu.tieba.enterForum.tabfeed.b bVar, ViewGroup viewGroup, String str) {
        this.gGp = enterForumTabFeedFragment;
        this.gHh = bVar;
        this.tabName = str;
        aC(viewGroup);
        this.gHw = new com.baidu.tieba.enterForum.tabfeed.a(enterForumTabFeedFragment, this.gGq);
        it(false);
    }

    private void aC(ViewGroup viewGroup) {
        this.gHp = viewGroup;
        this.gGq = (BdTypeRecyclerView) viewGroup.findViewById(R.id.tab_feed_recycler_view);
        this.gGq.setLayoutManager(new LinearLayoutManager(this.gGp.getContext()));
        this.gGq.setFadingEdgeLength(0);
        this.gGq.setOverScrollMode(2);
        this.gGq.setOnSrollToBottomListener(this.fhr);
        this.gGq.addOnScrollListener(this.gii);
        this.mPullView = new h(this.gGp.getPageContext());
        this.mPullView.setListPullRefreshListener(this.gHh);
        this.gGq.setRecyclerListener(new RecyclerView.RecyclerListener() { // from class: com.baidu.tieba.enterForum.tabfeed.view.a.4
            @Override // android.support.v7.widget.RecyclerView.RecyclerListener
            public void onViewRecycled(RecyclerView.ViewHolder viewHolder) {
                View view = viewHolder.itemView;
                if (view != null && a.this.gHv != null) {
                    a.this.gHv.ct(view);
                }
            }
        });
        this.ePm = new PbListView(this.gGp.getPageContext().getPageActivity());
        this.ePm.getView();
        this.ePm.setContainerBackgroundColorResId(R.color.cp_bg_line_e);
        this.ePm.setHeight(l.getDimens(this.gGp.getPageContext().getPageActivity(), R.dimen.tbds182));
        this.ePm.setLineGone();
        this.ePm.setTextSize(R.dimen.tbfontsize33);
        this.ePm.setTextColor(am.getColor(R.color.cp_cont_j));
        this.ePm.setNoMoreTextColorId(R.color.cp_cont_e);
        this.ePm.aQd();
        this.ePm.setOnClickListener(this.gHx);
        if (this.eRw == null) {
            this.eRw = (BdSwipeRefreshLayout) viewGroup.findViewById(R.id.tab_feed_pull_refresh_layout);
            this.eRw.setProgressView(this.mPullView);
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.eRw.getLayoutParams();
            marginLayoutParams.topMargin = UtilHelper.getStatusBarHeight() + l.getDimens(this.gGp.getPageContext().getPageActivity(), R.dimen.tbds219);
            this.eRw.setLayoutParams(marginLayoutParams);
        }
        this.gHq = new aw();
        this.gHr = new SmartBubbleAnimatedView(this.gGp.getContext());
        this.gHr.setLayoutParams(new FrameLayout.LayoutParams(-1, l.getDimens(this.gGp.getContext(), R.dimen.tbds83)));
        if (this.gHv == null) {
            this.gHv = new m(this.gGp.getPageContext(), this.gGq);
            this.gHv.AZ(1);
            this.gHv.setUniqueId(this.gGp.getUniqueId());
        }
        this.gHs = new b(this.gGp.getPageContext());
        this.gHs.setTabName(this.tabName);
    }

    public void b(com.baidu.tieba.enterForum.tabfeed.b.b bVar) {
        if (bVar != null) {
            this.hasMore = bVar.hasMore;
        }
        it(false);
        if (bVar != null && this.gHw != null && this.gGq != null && this.ePm != null) {
            bJF();
            d(bVar);
            c(bVar);
            if (bVar.gHb > 0) {
                int firstVisiblePosition = this.gGq.getFirstVisiblePosition();
                View childAt = this.gGq.getChildAt(0);
                int top2 = childAt == null ? 0 : childAt.getTop();
                RecyclerView.LayoutManager layoutManager = this.gGq.getLayoutManager();
                int i = firstVisiblePosition - bVar.gHb;
                if (layoutManager instanceof LinearLayoutManager) {
                    this.gGq.oQ();
                    ((LinearLayoutManager) layoutManager).scrollToPositionWithOffset(i, top2);
                    this.gGq.oR();
                }
                bVar.gHb = 0;
            }
            this.gHw.setIsFromCDN(bVar.agt);
            this.gHw.setData(bVar.gHa);
            this.gHw.notifyDataSetChanged();
            if (bVar.etK) {
                sw(bVar.refreshCount);
            }
            if (this.gHv != null) {
                this.gHv.a(this.gGq.getFirstVisiblePosition(), this.gGq.getLastVisiblePosition(), false, true);
            }
        }
    }

    private void bJF() {
        if (this.dkk == null) {
            this.dkk = new TextView(this.gGp.getContext());
            this.dkk.setPadding(l.getDimens(this.gGp.getContext(), R.dimen.tbds44), l.getDimens(this.gGp.getContext(), R.dimen.tbds60), 0, l.getDimens(this.gGp.getContext(), R.dimen.tbds24));
            this.dkk.setText(R.string.tab_feed_title);
            this.dkk.setTextSize(0, l.getDimens(this.gGp.getContext(), R.dimen.tbds46));
            this.dkk.setTypeface(Typeface.DEFAULT_BOLD);
            this.gGq.removeHeaderView(this.dkk);
            this.gGq.addHeaderView(this.dkk, 0);
            am.setViewTextColor(this.dkk, (int) R.color.cp_cont_b);
        }
    }

    private void c(com.baidu.tieba.enterForum.tabfeed.b.b bVar) {
        if (bVar != null && this.gGq != null && this.gGp != null && bVar.etK) {
            if (!((bVar.gGZ == null || v.isEmpty(bVar.gGZ.bHY())) ? false : true)) {
                if (this.gHu != null) {
                    this.gGq.removeHeaderView(this.gHu);
                    return;
                }
                return;
            }
            if (this.gHu == null) {
                this.gHu = new RecommendForumHorizontalView(this.gGp.getPageContext());
                this.gHu.setShowMore(true);
                this.gHu.setSquareEntranceAtStart(true);
                this.gHu.setTabName(this.tabName);
                this.gHu.setFrom(1);
            }
            this.gHu.b(bVar.gGZ);
            this.gGq.removeHeaderView(this.gHu);
            this.gGq.addHeaderView(this.gHu, 0);
            an anVar = new an("c13641");
            anVar.t("uid", TbadkApplication.getCurrentAccountId());
            anVar.af("obj_locate", 2);
            anVar.cI("resource_id", this.tabName);
            TiebaStatic.log(anVar);
        }
    }

    private void d(com.baidu.tieba.enterForum.tabfeed.b.b bVar) {
        if (bVar.gHc != null && bVar.gHc.hot_user != null && bVar.gHc.hot_user.size() > 0 && !TextUtils.isEmpty(bVar.gHc.module_name)) {
            this.gHs.a(bVar.gHc);
            if (this.gHs.getView().getParent() == null && !this.gHt) {
                this.gHt = true;
                this.gGq.addHeaderView(this.gHs.getView(), 0);
                an anVar = new an("c13656");
                anVar.t("uid", TbadkApplication.getCurrentAccountId());
                anVar.cI("resource_id", this.tabName);
                TiebaStatic.log(anVar);
                return;
            }
            return;
        }
        this.gHt = false;
        this.gGq.removeHeaderView(this.gHs.getView());
    }

    public void onChangeSkinType(int i) {
        if (this.mPullView != null) {
            this.mPullView.changeSkin(i);
        }
        if (this.ePm != null) {
            this.ePm.setTextColor(am.getColor(R.color.cp_cont_j));
            this.ePm.changeSkin(i);
        }
        if (this.gHw != null) {
            this.gHw.notifyDataSetChanged();
        }
        if (this.dkk != null) {
            am.setViewTextColor(this.dkk, (int) R.color.cp_cont_b);
        }
        if (this.gHs != null) {
            this.gHs.onChangeSkinType();
        }
        if (this.gHu != null) {
            this.gHu.onChangeSkinType();
        }
        if (this.gHr != null) {
            this.gHr.onChangeSkinType(i);
        }
    }

    public void resume() {
        if (this.gHv != null) {
            this.gHv.pL(true);
            if (this.gGq != null) {
                this.gHv.a(this.gGq.getFirstVisiblePosition(), this.gGq.getLastVisiblePosition(), false, true);
            }
        }
    }

    public void pause() {
        if (this.gHv != null) {
            this.gHv.cnO();
            this.gHv.pL(false);
        }
    }

    public void bJG() {
        if (this.gGq != null) {
            this.gGq.scrollToPosition(0);
        }
    }

    public void it(boolean z) {
        if (this.eRw != null) {
            this.eRw.setRefreshing(z);
        }
    }

    public void lX(boolean z) {
        if (this.eRw != null) {
            this.eRw.setVisibility(z ? 0 : 8);
        }
    }

    public boolean bJH() {
        return this.gGq == null || this.gGq.getChildCount() == 0 || this.gGq.getChildAt(0).getTop() == 0;
    }

    private void sw(int i) {
        String string;
        if (i >= 0) {
            this.gHq.bQG();
            if (i > 0) {
                string = String.format(TbadkCoreApplication.getInst().getString(R.string.recommend_frs_refresh_return), Integer.valueOf(i));
            } else {
                string = TbadkCoreApplication.getInst().getString(R.string.recommend_frs_refresh_nodata);
            }
            if (!TextUtils.isEmpty(string) && j.isNetWorkAvailable()) {
                this.gHr.dHs = string;
                this.gHr.hcw = 2000L;
                FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
                layoutParams.gravity = 49;
                layoutParams.topMargin = UtilHelper.getStatusBarHeight() + l.getDimens(this.gGp.getPageContext().getPageActivity(), R.dimen.tbds228);
                if (this.gHp != null) {
                    this.gHp.removeView(this.gHr);
                    this.gHp.addView(this.gHr, layoutParams);
                    this.gHr.bQE();
                }
            }
        }
    }

    public void bI(int i, int i2) {
        if (this.gGq != null && i < i2) {
            this.gGq.l(i, i2);
        }
    }
}
