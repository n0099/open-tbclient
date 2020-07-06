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
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.j;
import com.baidu.adp.lib.util.l;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.adp.widget.refresh.BdSwipeRefreshLayout;
import com.baidu.card.view.RecommendForumLayout;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.data.bg;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.w;
import com.baidu.tbadk.core.view.PbListView;
import com.baidu.tbadk.core.view.g;
import com.baidu.tbadk.h.f;
import com.baidu.tbadk.widget.horizontalpullview.PullLeftRefreshLayout;
import com.baidu.tieba.R;
import com.baidu.tieba.enterForum.tabfeed.EnterForumTabFeedFragment;
import com.baidu.tieba.frs.SmartBubbleAnimatedView;
import com.baidu.tieba.frs.bc;
import com.baidu.tieba.play.m;
/* loaded from: classes9.dex */
public class a {
    private TextView dDu;
    private PbListView fnt;
    private BdSwipeRefreshLayout fpF;
    private boolean hasMore;
    private EnterForumTabFeedFragment hhW;
    private BdTypeRecyclerView hhX;
    private com.baidu.tieba.enterForum.tabfeed.b hiU;
    private ViewGroup hjg;
    private bc hjh;
    private SmartBubbleAnimatedView hji;
    private b hjj;
    private boolean hjk;
    private RecommendForumLayout hjl;
    private m hjm;
    private com.baidu.tieba.enterForum.tabfeed.a hjn;
    private g mPullView;
    private String tabName;
    private BdListView.e fGA = new BdListView.e() { // from class: com.baidu.tieba.enterForum.tabfeed.view.a.1
        @Override // com.baidu.adp.widget.ListView.BdListView.e
        public void onScrollToBottom() {
            if (a.this.hhX != null) {
                a.this.hhX.stopScroll();
            }
            if (a.this.fnt != null && a.this.hiU != null) {
                if (j.isNetWorkAvailable()) {
                    a.this.hhX.setNextPage(a.this.fnt);
                    a.this.fnt.showEmptyView(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
                    a.this.fnt.setOnClickListener(null);
                    if (a.this.hasMore) {
                        a.this.fnt.showLoading();
                        a.this.hiU.bST();
                        return;
                    }
                    a.this.fnt.setText(a.this.hhW.getResources().getString(R.string.list_has_no_more));
                    a.this.fnt.endLoadData();
                    return;
                }
                a.this.hhX.setNextPage(null);
            }
        }
    };
    private RecyclerView.OnScrollListener gKd = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.enterForum.tabfeed.view.a.2
        private boolean hjr;

        @Override // android.support.v7.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i) {
            if (i == 0) {
                if (a.this.hjm != null) {
                    a.this.hjm.a(a.this.hhX.getFirstVisiblePosition(), a.this.hhX.getLastVisiblePosition(), this.hjr, true);
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001630, Boolean.valueOf(a.this.bTh() ? false : true)));
            }
        }

        @Override // android.support.v7.widget.RecyclerView.OnScrollListener
        public void onScrolled(RecyclerView recyclerView, int i, int i2) {
            super.onScrolled(recyclerView, i, i2);
            if (i2 > 0) {
                this.hjr = false;
            } else {
                this.hjr = true;
            }
        }
    };
    private View.OnClickListener hjo = new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.tabfeed.view.a.3
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (a.this.hhX != null) {
                a.this.hhX.stopScroll();
            }
            if (a.this.fnt != null && a.this.hiU != null && j.isNetWorkAvailable()) {
                a.this.fnt.showEmptyView(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
                a.this.fnt.setOnClickListener(null);
                if (a.this.hasMore) {
                    a.this.fnt.showLoading();
                    a.this.hiU.bST();
                }
            }
        }
    };
    private f agW = new f<bg>() { // from class: com.baidu.tieba.enterForum.tabfeed.view.a.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tbadk.h.f
        public void a(View view, bg bgVar, int i, long j) {
            if (bgVar == null) {
                com.baidu.tieba.enterForum.b.b(a.this.hhW.getPageContext(), a.this.tabName);
                if (a.this.hjl != null) {
                    ao aoVar = new ao("c13645");
                    aoVar.s("uid", TbadkApplication.getCurrentAccountId());
                    aoVar.ag("obj_locate", 1);
                    aoVar.ag("obj_type", a.this.hjl.agV ? 5 : 1);
                    aoVar.ag("obj_source", 5);
                    TiebaStatic.log(aoVar);
                }
            } else if (bgVar != null && a.this.hhW != null) {
                String forumName = bgVar.getForumName();
                if (ar.isForumName(forumName)) {
                    a.this.hhW.sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(a.this.hhW.getFragmentActivity()).createNormalCfg(forumName, FrsActivityConfig.FRS_FROM_ENTERFORUM_RECOMMEND).setCallFrom(3)));
                    if (a.this.hjl != null) {
                        ao aoVar2 = new ao("c13643");
                        aoVar2.s("uid", TbadkApplication.getCurrentAccountId());
                        aoVar2.s("fid", bgVar.getForumId());
                        if (a.this.hjl.mFrom != 0) {
                            if (a.this.hjl.mFrom == 1) {
                                aoVar2.ag("obj_locate", 2);
                                aoVar2.dk("resource_id", a.this.tabName);
                            }
                        } else {
                            aoVar2.ag("obj_locate", 1);
                            aoVar2.ag("obj_type", a.this.hjl.agV ? 4 : 1);
                        }
                        TiebaStatic.log(aoVar2);
                    }
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tbadk.h.f
        public void b(View view, bg bgVar, int i, long j) {
            if (bgVar != null) {
                ao aoVar = new ao("c13642");
                aoVar.s("uid", TbadkApplication.getCurrentAccountId());
                aoVar.s("fid", bgVar.getForumId());
                if (a.this.hjl.mFrom != 0) {
                    if (a.this.hjl.mFrom == 1) {
                        aoVar.ag("obj_locate", 2);
                        aoVar.dk("resource_id", a.this.tabName);
                    }
                } else {
                    aoVar.ag("obj_locate", 1);
                    aoVar.ag("obj_type", a.this.hjl.agV ? 3 : 1);
                }
                TiebaStatic.log(aoVar);
            }
        }
    };
    private View.OnClickListener hjp = new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.tabfeed.view.a.5
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            com.baidu.tieba.enterForum.b.b(a.this.hhW.getPageContext(), a.this.tabName);
            if (a.this.hjl != null) {
                ao aoVar = new ao("c13645");
                aoVar.s("uid", TbadkApplication.getCurrentAccountId());
                aoVar.ag("obj_locate", 1);
                aoVar.ag("obj_type", a.this.hjl.agV ? 5 : 1);
                aoVar.ag("obj_source", 2);
                TiebaStatic.log(aoVar);
            }
        }
    };
    private PullLeftRefreshLayout.a ajo = new PullLeftRefreshLayout.a() { // from class: com.baidu.tieba.enterForum.tabfeed.view.a.6
        @Override // com.baidu.tbadk.widget.horizontalpullview.PullLeftRefreshLayout.a
        public void bkn() {
            com.baidu.tieba.enterForum.b.b(a.this.hhW.getPageContext(), a.this.tabName);
            ao aoVar = new ao("c13645");
            aoVar.s("uid", TbadkApplication.getCurrentAccountId());
            aoVar.ag("obj_locate", 1);
            aoVar.ag("obj_type", a.this.hjl.agV ? 5 : 1);
            aoVar.ag("obj_source", 4);
            TiebaStatic.log(aoVar);
        }
    };

    public a(EnterForumTabFeedFragment enterForumTabFeedFragment, com.baidu.tieba.enterForum.tabfeed.b bVar, ViewGroup viewGroup, String str) {
        this.hhW = enterForumTabFeedFragment;
        this.hiU = bVar;
        this.tabName = str;
        aS(viewGroup);
        this.hjn = new com.baidu.tieba.enterForum.tabfeed.a(enterForumTabFeedFragment, this.hhX);
        jc(false);
    }

    private void aS(ViewGroup viewGroup) {
        this.hjg = viewGroup;
        this.hhX = (BdTypeRecyclerView) viewGroup.findViewById(R.id.tab_feed_recycler_view);
        this.hhX.setLayoutManager(new LinearLayoutManager(this.hhW.getContext()));
        this.hhX.setFadingEdgeLength(0);
        this.hhX.setOverScrollMode(2);
        this.hhX.setOnSrollToBottomListener(this.fGA);
        this.hhX.addOnScrollListener(this.gKd);
        this.mPullView = new g(this.hhW.getPageContext());
        this.mPullView.setListPullRefreshListener(this.hiU);
        this.hhX.setRecyclerListener(new RecyclerView.RecyclerListener() { // from class: com.baidu.tieba.enterForum.tabfeed.view.a.7
            @Override // android.support.v7.widget.RecyclerView.RecyclerListener
            public void onViewRecycled(RecyclerView.ViewHolder viewHolder) {
                View view = viewHolder.itemView;
                if (view != null && a.this.hjm != null) {
                    a.this.hjm.cu(view);
                }
            }
        });
        this.fnt = new PbListView(this.hhW.getPageContext().getPageActivity());
        this.fnt.getView();
        this.fnt.setContainerBackgroundColorResId(R.color.cp_bg_line_e);
        this.fnt.setHeight(l.getDimens(this.hhW.getPageContext().getPageActivity(), R.dimen.tbds182));
        this.fnt.setLineGone();
        this.fnt.setTextSize(R.dimen.tbfontsize33);
        this.fnt.setTextColor(an.getColor(R.color.cp_cont_j));
        this.fnt.setNoMoreTextColorId(R.color.cp_cont_e);
        this.fnt.aXZ();
        this.fnt.setOnClickListener(this.hjo);
        if (this.fpF == null) {
            this.fpF = (BdSwipeRefreshLayout) viewGroup.findViewById(R.id.tab_feed_pull_refresh_layout);
            this.fpF.setProgressView(this.mPullView);
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.fpF.getLayoutParams();
            marginLayoutParams.topMargin = UtilHelper.getStatusBarHeight() + l.getDimens(this.hhW.getPageContext().getPageActivity(), R.dimen.tbds219);
            this.fpF.setLayoutParams(marginLayoutParams);
        }
        this.hjh = new bc();
        this.hji = new SmartBubbleAnimatedView(this.hhW.getContext());
        this.hji.setLayoutParams(new FrameLayout.LayoutParams(-1, l.getDimens(this.hhW.getContext(), R.dimen.tbds83)));
        if (this.hjm == null) {
            this.hjm = new m(this.hhW.getPageContext(), this.hhX);
            this.hjm.CN(1);
            this.hjm.setUniqueId(this.hhW.getUniqueId());
        }
        this.hjj = new b(this.hhW.getPageContext());
        this.hjj.setTabName(this.tabName);
    }

    public void b(com.baidu.tieba.enterForum.tabfeed.b.b bVar) {
        if (bVar != null) {
            this.hasMore = bVar.hasMore;
        }
        jc(false);
        if (bVar != null && this.hjn != null && this.hhX != null && this.fnt != null) {
            bTf();
            d(bVar);
            c(bVar);
            if (bVar.hiQ > 0) {
                int firstVisiblePosition = this.hhX.getFirstVisiblePosition();
                View childAt = this.hhX.getChildAt(0);
                int top2 = childAt == null ? 0 : childAt.getTop();
                RecyclerView.LayoutManager layoutManager = this.hhX.getLayoutManager();
                int i = firstVisiblePosition - bVar.hiQ;
                if (layoutManager instanceof LinearLayoutManager) {
                    this.hhX.pm();
                    ((LinearLayoutManager) layoutManager).scrollToPositionWithOffset(i, top2);
                    this.hhX.pn();
                }
                bVar.hiQ = 0;
            }
            this.hjn.setIsFromCDN(bVar.aik);
            this.hjn.setData(bVar.hiP);
            this.hjn.notifyDataSetChanged();
            if (bVar.eSL) {
                tE(bVar.refreshCount);
            }
            if (this.hjm != null) {
                this.hjm.a(this.hhX.getFirstVisiblePosition(), this.hhX.getLastVisiblePosition(), false, true);
            }
        }
    }

    private void bTf() {
        if (this.dDu == null) {
            this.dDu = new TextView(this.hhW.getContext());
            this.dDu.setPadding(l.getDimens(this.hhW.getContext(), R.dimen.tbds44), l.getDimens(this.hhW.getContext(), R.dimen.tbds60), 0, l.getDimens(this.hhW.getContext(), R.dimen.tbds24));
            this.dDu.setText(R.string.tab_feed_title);
            this.dDu.setTextSize(0, l.getDimens(this.hhW.getContext(), R.dimen.tbds46));
            this.dDu.setTypeface(Typeface.DEFAULT_BOLD);
            this.hhX.removeHeaderView(this.dDu);
            this.hhX.addHeaderView(this.dDu, 0);
            an.setViewTextColor(this.dDu, (int) R.color.cp_cont_b);
        }
    }

    private void c(com.baidu.tieba.enterForum.tabfeed.b.b bVar) {
        if (bVar != null && this.hhX != null && this.hhW != null && bVar.eSL) {
            if (!((bVar.hiO == null || w.isEmpty(bVar.hiO.aRv())) ? false : true)) {
                if (this.hjl != null) {
                    this.hhX.removeHeaderView(this.hjl);
                    return;
                }
                return;
            }
            if (this.hjl == null) {
                this.hjl = new RecommendForumLayout(this.hhW.getPageContext());
                this.hjl.setShowMore(true);
                this.hjl.setSquareEntranceAtStart(true);
                this.hjl.setTabName(this.tabName);
                this.hjl.setFrom(1);
            }
            this.hjl.setOnClickRightArrowListener(this.hjp);
            this.hjl.setOnRullOkCallbackr(this.ajo);
            this.hjl.setOnItemCoverListener(this.agW);
            this.hjl.b(bVar.hiO);
            this.hhX.removeHeaderView(this.hjl);
            this.hhX.addHeaderView(this.hjl, 0);
            ao aoVar = new ao("c13641");
            aoVar.s("uid", TbadkApplication.getCurrentAccountId());
            aoVar.ag("obj_locate", 2);
            aoVar.dk("resource_id", this.tabName);
            TiebaStatic.log(aoVar);
        }
    }

    private void d(com.baidu.tieba.enterForum.tabfeed.b.b bVar) {
        if (bVar.hiR != null && bVar.hiR.hot_user != null && bVar.hiR.hot_user.size() > 0 && !TextUtils.isEmpty(bVar.hiR.module_name)) {
            this.hjj.a(bVar.hiR);
            if (this.hjj.getView().getParent() == null && !this.hjk) {
                this.hjk = true;
                this.hhX.addHeaderView(this.hjj.getView(), 0);
                ao aoVar = new ao("c13656");
                aoVar.s("uid", TbadkApplication.getCurrentAccountId());
                aoVar.dk("resource_id", this.tabName);
                TiebaStatic.log(aoVar);
                return;
            }
            return;
        }
        this.hjk = false;
        this.hhX.removeHeaderView(this.hjj.getView());
    }

    public void onChangeSkinType(int i) {
        if (this.mPullView != null) {
            this.mPullView.changeSkin(i);
        }
        if (this.fnt != null) {
            this.fnt.setTextColor(an.getColor(R.color.cp_cont_j));
            this.fnt.changeSkin(i);
        }
        if (this.hjn != null) {
            this.hjn.notifyDataSetChanged();
        }
        if (this.dDu != null) {
            an.setViewTextColor(this.dDu, (int) R.color.cp_cont_b);
        }
        if (this.hjj != null) {
            this.hjj.onChangeSkinType();
        }
        if (this.hjl != null) {
            this.hjl.onChangeSkinType();
        }
        if (this.hji != null) {
            this.hji.onChangeSkinType(i);
        }
    }

    public void resume() {
        if (this.hjm != null) {
            this.hjm.qs(true);
            if (this.hhX != null) {
                this.hjm.a(this.hhX.getFirstVisiblePosition(), this.hhX.getLastVisiblePosition(), false, true);
            }
        }
    }

    public void pause() {
        if (this.hjm != null) {
            this.hjm.cyn();
            this.hjm.qs(false);
        }
    }

    public void bTg() {
        if (this.hhX != null) {
            this.hhX.scrollToPosition(0);
        }
    }

    public void jc(boolean z) {
        if (this.fpF != null) {
            this.fpF.setRefreshing(z);
        }
    }

    public void mD(boolean z) {
        if (this.fpF != null) {
            this.fpF.setVisibility(z ? 0 : 8);
        }
    }

    public boolean bTh() {
        return this.hhX == null || this.hhX.getChildCount() == 0 || this.hhX.getChildAt(0).getTop() == 0;
    }

    private void tE(int i) {
        String string;
        if (i >= 0) {
            this.hjh.cap();
            if (i > 0) {
                string = String.format(TbadkCoreApplication.getInst().getString(R.string.recommend_frs_refresh_return), Integer.valueOf(i));
            } else {
                string = TbadkCoreApplication.getInst().getString(R.string.recommend_frs_refresh_nodata);
            }
            if (!TextUtils.isEmpty(string) && j.isNetWorkAvailable()) {
                this.hji.edh = string;
                this.hji.hEs = 2000L;
                FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
                layoutParams.gravity = 49;
                layoutParams.topMargin = UtilHelper.getStatusBarHeight() + l.getDimens(this.hhW.getPageContext().getPageActivity(), R.dimen.tbds228);
                if (this.hjg != null) {
                    this.hjg.removeView(this.hji);
                    this.hjg.addView(this.hji, layoutParams);
                    this.hji.can();
                }
            }
        }
    }

    public void bQ(int i, int i2) {
        if (this.hhX != null && i < i2) {
            this.hhX.m(i, i2);
        }
    }
}
