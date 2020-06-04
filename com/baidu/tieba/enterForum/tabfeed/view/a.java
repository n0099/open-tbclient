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
    private PbListView fcj;
    private BdSwipeRefreshLayout feu;
    private EnterForumTabFeedFragment gVn;
    private BdTypeRecyclerView gVo;
    private com.baidu.tieba.enterForum.tabfeed.b gWf;
    private ViewGroup gWr;
    private aw gWs;
    private SmartBubbleAnimatedView gWt;
    private b gWu;
    private boolean gWv;
    private RecommendForumHorizontalView gWw;
    private m gWx;
    private com.baidu.tieba.enterForum.tabfeed.a gWy;
    private boolean hasMore;
    private g mPullView;
    private String tabName;
    private BdListView.e fvq = new BdListView.e() { // from class: com.baidu.tieba.enterForum.tabfeed.view.a.1
        @Override // com.baidu.adp.widget.ListView.BdListView.e
        public void onScrollToBottom() {
            if (a.this.gVo != null) {
                a.this.gVo.stopScroll();
            }
            if (a.this.fcj != null && a.this.gWf != null) {
                if (j.isNetWorkAvailable()) {
                    a.this.gVo.setNextPage(a.this.fcj);
                    a.this.fcj.showEmptyView(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
                    a.this.fcj.setOnClickListener(null);
                    if (a.this.hasMore) {
                        a.this.fcj.showLoading();
                        a.this.gWf.bPP();
                        return;
                    }
                    a.this.fcj.setText(a.this.gVn.getResources().getString(R.string.list_has_no_more));
                    a.this.fcj.endLoadData();
                    return;
                }
                a.this.gVo.setNextPage(null);
            }
        }
    };
    private RecyclerView.OnScrollListener gxp = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.enterForum.tabfeed.view.a.2
        private boolean gWB;

        @Override // android.support.v7.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i) {
            if (i == 0) {
                if (a.this.gWx != null) {
                    a.this.gWx.a(a.this.gVo.getFirstVisiblePosition(), a.this.gVo.getLastVisiblePosition(), this.gWB, true);
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001630, Boolean.valueOf(a.this.bQd() ? false : true)));
            }
        }

        @Override // android.support.v7.widget.RecyclerView.OnScrollListener
        public void onScrolled(RecyclerView recyclerView, int i, int i2) {
            super.onScrolled(recyclerView, i, i2);
            if (i2 > 0) {
                this.gWB = false;
            } else {
                this.gWB = true;
            }
        }
    };
    private View.OnClickListener gWz = new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.tabfeed.view.a.3
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (a.this.gVo != null) {
                a.this.gVo.stopScroll();
            }
            if (a.this.fcj != null && a.this.gWf != null && j.isNetWorkAvailable()) {
                a.this.fcj.showEmptyView(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
                a.this.fcj.setOnClickListener(null);
                if (a.this.hasMore) {
                    a.this.fcj.showLoading();
                    a.this.gWf.bPP();
                }
            }
        }
    };

    public a(EnterForumTabFeedFragment enterForumTabFeedFragment, com.baidu.tieba.enterForum.tabfeed.b bVar, ViewGroup viewGroup, String str) {
        this.gVn = enterForumTabFeedFragment;
        this.gWf = bVar;
        this.tabName = str;
        aO(viewGroup);
        this.gWy = new com.baidu.tieba.enterForum.tabfeed.a(enterForumTabFeedFragment, this.gVo);
        iQ(false);
    }

    private void aO(ViewGroup viewGroup) {
        this.gWr = viewGroup;
        this.gVo = (BdTypeRecyclerView) viewGroup.findViewById(R.id.tab_feed_recycler_view);
        this.gVo.setLayoutManager(new LinearLayoutManager(this.gVn.getContext()));
        this.gVo.setFadingEdgeLength(0);
        this.gVo.setOverScrollMode(2);
        this.gVo.setOnSrollToBottomListener(this.fvq);
        this.gVo.addOnScrollListener(this.gxp);
        this.mPullView = new g(this.gVn.getPageContext());
        this.mPullView.setListPullRefreshListener(this.gWf);
        this.gVo.setRecyclerListener(new RecyclerView.RecyclerListener() { // from class: com.baidu.tieba.enterForum.tabfeed.view.a.4
            @Override // android.support.v7.widget.RecyclerView.RecyclerListener
            public void onViewRecycled(RecyclerView.ViewHolder viewHolder) {
                View view = viewHolder.itemView;
                if (view != null && a.this.gWx != null) {
                    a.this.gWx.ct(view);
                }
            }
        });
        this.fcj = new PbListView(this.gVn.getPageContext().getPageActivity());
        this.fcj.getView();
        this.fcj.setContainerBackgroundColorResId(R.color.cp_bg_line_e);
        this.fcj.setHeight(l.getDimens(this.gVn.getPageContext().getPageActivity(), R.dimen.tbds182));
        this.fcj.setLineGone();
        this.fcj.setTextSize(R.dimen.tbfontsize33);
        this.fcj.setTextColor(am.getColor(R.color.cp_cont_j));
        this.fcj.setNoMoreTextColorId(R.color.cp_cont_e);
        this.fcj.aWf();
        this.fcj.setOnClickListener(this.gWz);
        if (this.feu == null) {
            this.feu = (BdSwipeRefreshLayout) viewGroup.findViewById(R.id.tab_feed_pull_refresh_layout);
            this.feu.setProgressView(this.mPullView);
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.feu.getLayoutParams();
            marginLayoutParams.topMargin = UtilHelper.getStatusBarHeight() + l.getDimens(this.gVn.getPageContext().getPageActivity(), R.dimen.tbds219);
            this.feu.setLayoutParams(marginLayoutParams);
        }
        this.gWs = new aw();
        this.gWt = new SmartBubbleAnimatedView(this.gVn.getContext());
        this.gWt.setLayoutParams(new FrameLayout.LayoutParams(-1, l.getDimens(this.gVn.getContext(), R.dimen.tbds83)));
        if (this.gWx == null) {
            this.gWx = new m(this.gVn.getPageContext(), this.gVo);
            this.gWx.BL(1);
            this.gWx.setUniqueId(this.gVn.getUniqueId());
        }
        this.gWu = new b(this.gVn.getPageContext());
        this.gWu.setTabName(this.tabName);
    }

    public void b(com.baidu.tieba.enterForum.tabfeed.b.b bVar) {
        if (bVar != null) {
            this.hasMore = bVar.hasMore;
        }
        iQ(false);
        if (bVar != null && this.gWy != null && this.gVo != null && this.fcj != null) {
            bQb();
            d(bVar);
            c(bVar);
            if (bVar.gVZ > 0) {
                int firstVisiblePosition = this.gVo.getFirstVisiblePosition();
                View childAt = this.gVo.getChildAt(0);
                int top2 = childAt == null ? 0 : childAt.getTop();
                RecyclerView.LayoutManager layoutManager = this.gVo.getLayoutManager();
                int i = firstVisiblePosition - bVar.gVZ;
                if (layoutManager instanceof LinearLayoutManager) {
                    this.gVo.oV();
                    ((LinearLayoutManager) layoutManager).scrollToPositionWithOffset(i, top2);
                    this.gVo.oW();
                }
                bVar.gVZ = 0;
            }
            this.gWy.setIsFromCDN(bVar.aha);
            this.gWy.setData(bVar.gVY);
            this.gWy.notifyDataSetChanged();
            if (bVar.eIz) {
                td(bVar.refreshCount);
            }
            if (this.gWx != null) {
                this.gWx.a(this.gVo.getFirstVisiblePosition(), this.gVo.getLastVisiblePosition(), false, true);
            }
        }
    }

    private void bQb() {
        if (this.dyo == null) {
            this.dyo = new TextView(this.gVn.getContext());
            this.dyo.setPadding(l.getDimens(this.gVn.getContext(), R.dimen.tbds44), l.getDimens(this.gVn.getContext(), R.dimen.tbds60), 0, l.getDimens(this.gVn.getContext(), R.dimen.tbds24));
            this.dyo.setText(R.string.tab_feed_title);
            this.dyo.setTextSize(0, l.getDimens(this.gVn.getContext(), R.dimen.tbds46));
            this.dyo.setTypeface(Typeface.DEFAULT_BOLD);
            this.gVo.removeHeaderView(this.dyo);
            this.gVo.addHeaderView(this.dyo, 0);
            am.setViewTextColor(this.dyo, (int) R.color.cp_cont_b);
        }
    }

    private void c(com.baidu.tieba.enterForum.tabfeed.b.b bVar) {
        if (bVar != null && this.gVo != null && this.gVn != null && bVar.eIz) {
            if (!((bVar.gVX == null || v.isEmpty(bVar.gVX.bOs())) ? false : true)) {
                if (this.gWw != null) {
                    this.gVo.removeHeaderView(this.gWw);
                    return;
                }
                return;
            }
            if (this.gWw == null) {
                this.gWw = new RecommendForumHorizontalView(this.gVn.getPageContext());
                this.gWw.setShowMore(true);
                this.gWw.setSquareEntranceAtStart(true);
                this.gWw.setTabName(this.tabName);
                this.gWw.setFrom(1);
            }
            this.gWw.b(bVar.gVX);
            this.gVo.removeHeaderView(this.gWw);
            this.gVo.addHeaderView(this.gWw, 0);
            an anVar = new an("c13641");
            anVar.s("uid", TbadkApplication.getCurrentAccountId());
            anVar.ag("obj_locate", 2);
            anVar.dh("resource_id", this.tabName);
            TiebaStatic.log(anVar);
        }
    }

    private void d(com.baidu.tieba.enterForum.tabfeed.b.b bVar) {
        if (bVar.gWa != null && bVar.gWa.hot_user != null && bVar.gWa.hot_user.size() > 0 && !TextUtils.isEmpty(bVar.gWa.module_name)) {
            this.gWu.a(bVar.gWa);
            if (this.gWu.getView().getParent() == null && !this.gWv) {
                this.gWv = true;
                this.gVo.addHeaderView(this.gWu.getView(), 0);
                an anVar = new an("c13656");
                anVar.s("uid", TbadkApplication.getCurrentAccountId());
                anVar.dh("resource_id", this.tabName);
                TiebaStatic.log(anVar);
                return;
            }
            return;
        }
        this.gWv = false;
        this.gVo.removeHeaderView(this.gWu.getView());
    }

    public void onChangeSkinType(int i) {
        if (this.mPullView != null) {
            this.mPullView.changeSkin(i);
        }
        if (this.fcj != null) {
            this.fcj.setTextColor(am.getColor(R.color.cp_cont_j));
            this.fcj.changeSkin(i);
        }
        if (this.gWy != null) {
            this.gWy.notifyDataSetChanged();
        }
        if (this.dyo != null) {
            am.setViewTextColor(this.dyo, (int) R.color.cp_cont_b);
        }
        if (this.gWu != null) {
            this.gWu.onChangeSkinType();
        }
        if (this.gWw != null) {
            this.gWw.onChangeSkinType();
        }
        if (this.gWt != null) {
            this.gWt.onChangeSkinType(i);
        }
    }

    public void resume() {
        if (this.gWx != null) {
            this.gWx.qi(true);
            if (this.gVo != null) {
                this.gWx.a(this.gVo.getFirstVisiblePosition(), this.gVo.getLastVisiblePosition(), false, true);
            }
        }
    }

    public void pause() {
        if (this.gWx != null) {
            this.gWx.cux();
            this.gWx.qi(false);
        }
    }

    public void bQc() {
        if (this.gVo != null) {
            this.gVo.scrollToPosition(0);
        }
    }

    public void iQ(boolean z) {
        if (this.feu != null) {
            this.feu.setRefreshing(z);
        }
    }

    public void ms(boolean z) {
        if (this.feu != null) {
            this.feu.setVisibility(z ? 0 : 8);
        }
    }

    public boolean bQd() {
        return this.gVo == null || this.gVo.getChildCount() == 0 || this.gVo.getChildAt(0).getTop() == 0;
    }

    private void td(int i) {
        String string;
        if (i >= 0) {
            this.gWs.bXd();
            if (i > 0) {
                string = String.format(TbadkCoreApplication.getInst().getString(R.string.recommend_frs_refresh_return), Integer.valueOf(i));
            } else {
                string = TbadkCoreApplication.getInst().getString(R.string.recommend_frs_refresh_nodata);
            }
            if (!TextUtils.isEmpty(string) && j.isNetWorkAvailable()) {
                this.gWt.dVI = string;
                this.gWt.hrB = 2000L;
                FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
                layoutParams.gravity = 49;
                layoutParams.topMargin = UtilHelper.getStatusBarHeight() + l.getDimens(this.gVn.getPageContext().getPageActivity(), R.dimen.tbds228);
                if (this.gWr != null) {
                    this.gWr.removeView(this.gWt);
                    this.gWr.addView(this.gWt, layoutParams);
                    this.gWt.bXb();
                }
            }
        }
    }

    public void bM(int i, int i2) {
        if (this.gVo != null && i < i2) {
            this.gVo.l(i, i2);
        }
    }
}
