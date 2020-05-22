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
import com.baidu.tbadk.core.view.g;
import com.baidu.tieba.R;
import com.baidu.tieba.enterForum.tabfeed.EnterForumTabFeedFragment;
import com.baidu.tieba.enterForum.view.RecommendForumHorizontalView;
import com.baidu.tieba.frs.SmartBubbleAnimatedView;
import com.baidu.tieba.frs.aw;
import com.baidu.tieba.play.m;
/* loaded from: classes9.dex */
public class a {
    private TextView dyo;
    private PbListView fbY;
    private BdSwipeRefreshLayout fej;
    private com.baidu.tieba.enterForum.tabfeed.b gVU;
    private EnterForumTabFeedFragment gVc;
    private BdTypeRecyclerView gVd;
    private ViewGroup gWg;
    private aw gWh;
    private SmartBubbleAnimatedView gWi;
    private b gWj;
    private boolean gWk;
    private RecommendForumHorizontalView gWl;
    private m gWm;
    private com.baidu.tieba.enterForum.tabfeed.a gWn;
    private boolean hasMore;
    private g mPullView;
    private String tabName;
    private BdListView.e fvf = new BdListView.e() { // from class: com.baidu.tieba.enterForum.tabfeed.view.a.1
        @Override // com.baidu.adp.widget.ListView.BdListView.e
        public void onScrollToBottom() {
            if (a.this.gVd != null) {
                a.this.gVd.stopScroll();
            }
            if (a.this.fbY != null && a.this.gVU != null) {
                if (j.isNetWorkAvailable()) {
                    a.this.gVd.setNextPage(a.this.fbY);
                    a.this.fbY.showEmptyView(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
                    a.this.fbY.setOnClickListener(null);
                    if (a.this.hasMore) {
                        a.this.fbY.showLoading();
                        a.this.gVU.bPN();
                        return;
                    }
                    a.this.fbY.setText(a.this.gVc.getResources().getString(R.string.list_has_no_more));
                    a.this.fbY.endLoadData();
                    return;
                }
                a.this.gVd.setNextPage(null);
            }
        }
    };
    private RecyclerView.OnScrollListener gxe = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.enterForum.tabfeed.view.a.2
        private boolean gWq;

        @Override // android.support.v7.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i) {
            if (i == 0) {
                if (a.this.gWm != null) {
                    a.this.gWm.a(a.this.gVd.getFirstVisiblePosition(), a.this.gVd.getLastVisiblePosition(), this.gWq, true);
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001630, Boolean.valueOf(a.this.bQb() ? false : true)));
            }
        }

        @Override // android.support.v7.widget.RecyclerView.OnScrollListener
        public void onScrolled(RecyclerView recyclerView, int i, int i2) {
            super.onScrolled(recyclerView, i, i2);
            if (i2 > 0) {
                this.gWq = false;
            } else {
                this.gWq = true;
            }
        }
    };
    private View.OnClickListener gWo = new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.tabfeed.view.a.3
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (a.this.gVd != null) {
                a.this.gVd.stopScroll();
            }
            if (a.this.fbY != null && a.this.gVU != null && j.isNetWorkAvailable()) {
                a.this.fbY.showEmptyView(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
                a.this.fbY.setOnClickListener(null);
                if (a.this.hasMore) {
                    a.this.fbY.showLoading();
                    a.this.gVU.bPN();
                }
            }
        }
    };

    public a(EnterForumTabFeedFragment enterForumTabFeedFragment, com.baidu.tieba.enterForum.tabfeed.b bVar, ViewGroup viewGroup, String str) {
        this.gVc = enterForumTabFeedFragment;
        this.gVU = bVar;
        this.tabName = str;
        aO(viewGroup);
        this.gWn = new com.baidu.tieba.enterForum.tabfeed.a(enterForumTabFeedFragment, this.gVd);
        iQ(false);
    }

    private void aO(ViewGroup viewGroup) {
        this.gWg = viewGroup;
        this.gVd = (BdTypeRecyclerView) viewGroup.findViewById(R.id.tab_feed_recycler_view);
        this.gVd.setLayoutManager(new LinearLayoutManager(this.gVc.getContext()));
        this.gVd.setFadingEdgeLength(0);
        this.gVd.setOverScrollMode(2);
        this.gVd.setOnSrollToBottomListener(this.fvf);
        this.gVd.addOnScrollListener(this.gxe);
        this.mPullView = new g(this.gVc.getPageContext());
        this.mPullView.setListPullRefreshListener(this.gVU);
        this.gVd.setRecyclerListener(new RecyclerView.RecyclerListener() { // from class: com.baidu.tieba.enterForum.tabfeed.view.a.4
            @Override // android.support.v7.widget.RecyclerView.RecyclerListener
            public void onViewRecycled(RecyclerView.ViewHolder viewHolder) {
                View view = viewHolder.itemView;
                if (view != null && a.this.gWm != null) {
                    a.this.gWm.ct(view);
                }
            }
        });
        this.fbY = new PbListView(this.gVc.getPageContext().getPageActivity());
        this.fbY.getView();
        this.fbY.setContainerBackgroundColorResId(R.color.cp_bg_line_e);
        this.fbY.setHeight(l.getDimens(this.gVc.getPageContext().getPageActivity(), R.dimen.tbds182));
        this.fbY.setLineGone();
        this.fbY.setTextSize(R.dimen.tbfontsize33);
        this.fbY.setTextColor(am.getColor(R.color.cp_cont_j));
        this.fbY.setNoMoreTextColorId(R.color.cp_cont_e);
        this.fbY.aWe();
        this.fbY.setOnClickListener(this.gWo);
        if (this.fej == null) {
            this.fej = (BdSwipeRefreshLayout) viewGroup.findViewById(R.id.tab_feed_pull_refresh_layout);
            this.fej.setProgressView(this.mPullView);
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.fej.getLayoutParams();
            marginLayoutParams.topMargin = UtilHelper.getStatusBarHeight() + l.getDimens(this.gVc.getPageContext().getPageActivity(), R.dimen.tbds219);
            this.fej.setLayoutParams(marginLayoutParams);
        }
        this.gWh = new aw();
        this.gWi = new SmartBubbleAnimatedView(this.gVc.getContext());
        this.gWi.setLayoutParams(new FrameLayout.LayoutParams(-1, l.getDimens(this.gVc.getContext(), R.dimen.tbds83)));
        if (this.gWm == null) {
            this.gWm = new m(this.gVc.getPageContext(), this.gVd);
            this.gWm.BJ(1);
            this.gWm.setUniqueId(this.gVc.getUniqueId());
        }
        this.gWj = new b(this.gVc.getPageContext());
        this.gWj.setTabName(this.tabName);
    }

    public void b(com.baidu.tieba.enterForum.tabfeed.b.b bVar) {
        if (bVar != null) {
            this.hasMore = bVar.hasMore;
        }
        iQ(false);
        if (bVar != null && this.gWn != null && this.gVd != null && this.fbY != null) {
            bPZ();
            d(bVar);
            c(bVar);
            if (bVar.gVO > 0) {
                int firstVisiblePosition = this.gVd.getFirstVisiblePosition();
                View childAt = this.gVd.getChildAt(0);
                int top2 = childAt == null ? 0 : childAt.getTop();
                RecyclerView.LayoutManager layoutManager = this.gVd.getLayoutManager();
                int i = firstVisiblePosition - bVar.gVO;
                if (layoutManager instanceof LinearLayoutManager) {
                    this.gVd.oV();
                    ((LinearLayoutManager) layoutManager).scrollToPositionWithOffset(i, top2);
                    this.gVd.oW();
                }
                bVar.gVO = 0;
            }
            this.gWn.setIsFromCDN(bVar.aha);
            this.gWn.setData(bVar.gVN);
            this.gWn.notifyDataSetChanged();
            if (bVar.eIo) {
                tb(bVar.refreshCount);
            }
            if (this.gWm != null) {
                this.gWm.a(this.gVd.getFirstVisiblePosition(), this.gVd.getLastVisiblePosition(), false, true);
            }
        }
    }

    private void bPZ() {
        if (this.dyo == null) {
            this.dyo = new TextView(this.gVc.getContext());
            this.dyo.setPadding(l.getDimens(this.gVc.getContext(), R.dimen.tbds44), l.getDimens(this.gVc.getContext(), R.dimen.tbds60), 0, l.getDimens(this.gVc.getContext(), R.dimen.tbds24));
            this.dyo.setText(R.string.tab_feed_title);
            this.dyo.setTextSize(0, l.getDimens(this.gVc.getContext(), R.dimen.tbds46));
            this.dyo.setTypeface(Typeface.DEFAULT_BOLD);
            this.gVd.removeHeaderView(this.dyo);
            this.gVd.addHeaderView(this.dyo, 0);
            am.setViewTextColor(this.dyo, (int) R.color.cp_cont_b);
        }
    }

    private void c(com.baidu.tieba.enterForum.tabfeed.b.b bVar) {
        if (bVar != null && this.gVd != null && this.gVc != null && bVar.eIo) {
            if (!((bVar.gVM == null || v.isEmpty(bVar.gVM.bOq())) ? false : true)) {
                if (this.gWl != null) {
                    this.gVd.removeHeaderView(this.gWl);
                    return;
                }
                return;
            }
            if (this.gWl == null) {
                this.gWl = new RecommendForumHorizontalView(this.gVc.getPageContext());
                this.gWl.setShowMore(true);
                this.gWl.setSquareEntranceAtStart(true);
                this.gWl.setTabName(this.tabName);
                this.gWl.setFrom(1);
            }
            this.gWl.b(bVar.gVM);
            this.gVd.removeHeaderView(this.gWl);
            this.gVd.addHeaderView(this.gWl, 0);
            an anVar = new an("c13641");
            anVar.s("uid", TbadkApplication.getCurrentAccountId());
            anVar.ag("obj_locate", 2);
            anVar.dh("resource_id", this.tabName);
            TiebaStatic.log(anVar);
        }
    }

    private void d(com.baidu.tieba.enterForum.tabfeed.b.b bVar) {
        if (bVar.gVP != null && bVar.gVP.hot_user != null && bVar.gVP.hot_user.size() > 0 && !TextUtils.isEmpty(bVar.gVP.module_name)) {
            this.gWj.a(bVar.gVP);
            if (this.gWj.getView().getParent() == null && !this.gWk) {
                this.gWk = true;
                this.gVd.addHeaderView(this.gWj.getView(), 0);
                an anVar = new an("c13656");
                anVar.s("uid", TbadkApplication.getCurrentAccountId());
                anVar.dh("resource_id", this.tabName);
                TiebaStatic.log(anVar);
                return;
            }
            return;
        }
        this.gWk = false;
        this.gVd.removeHeaderView(this.gWj.getView());
    }

    public void onChangeSkinType(int i) {
        if (this.mPullView != null) {
            this.mPullView.changeSkin(i);
        }
        if (this.fbY != null) {
            this.fbY.setTextColor(am.getColor(R.color.cp_cont_j));
            this.fbY.changeSkin(i);
        }
        if (this.gWn != null) {
            this.gWn.notifyDataSetChanged();
        }
        if (this.dyo != null) {
            am.setViewTextColor(this.dyo, (int) R.color.cp_cont_b);
        }
        if (this.gWj != null) {
            this.gWj.onChangeSkinType();
        }
        if (this.gWl != null) {
            this.gWl.onChangeSkinType();
        }
        if (this.gWi != null) {
            this.gWi.onChangeSkinType(i);
        }
    }

    public void resume() {
        if (this.gWm != null) {
            this.gWm.qi(true);
            if (this.gVd != null) {
                this.gWm.a(this.gVd.getFirstVisiblePosition(), this.gVd.getLastVisiblePosition(), false, true);
            }
        }
    }

    public void pause() {
        if (this.gWm != null) {
            this.gWm.cuo();
            this.gWm.qi(false);
        }
    }

    public void bQa() {
        if (this.gVd != null) {
            this.gVd.scrollToPosition(0);
        }
    }

    public void iQ(boolean z) {
        if (this.fej != null) {
            this.fej.setRefreshing(z);
        }
    }

    public void ms(boolean z) {
        if (this.fej != null) {
            this.fej.setVisibility(z ? 0 : 8);
        }
    }

    public boolean bQb() {
        return this.gVd == null || this.gVd.getChildCount() == 0 || this.gVd.getChildAt(0).getTop() == 0;
    }

    private void tb(int i) {
        String string;
        if (i >= 0) {
            this.gWh.bXb();
            if (i > 0) {
                string = String.format(TbadkCoreApplication.getInst().getString(R.string.recommend_frs_refresh_return), Integer.valueOf(i));
            } else {
                string = TbadkCoreApplication.getInst().getString(R.string.recommend_frs_refresh_nodata);
            }
            if (!TextUtils.isEmpty(string) && j.isNetWorkAvailable()) {
                this.gWi.dVI = string;
                this.gWi.hrq = 2000L;
                FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
                layoutParams.gravity = 49;
                layoutParams.topMargin = UtilHelper.getStatusBarHeight() + l.getDimens(this.gVc.getPageContext().getPageActivity(), R.dimen.tbds228);
                if (this.gWg != null) {
                    this.gWg.removeView(this.gWi);
                    this.gWg.addView(this.gWi, layoutParams);
                    this.gWi.bWZ();
                }
            }
        }
    }

    public void bM(int i, int i2) {
        if (this.gVd != null && i < i2) {
            this.gVd.l(i, i2);
        }
    }
}
