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
import com.baidu.tbadk.core.data.bi;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.util.y;
import com.baidu.tbadk.core.view.PbListView;
import com.baidu.tbadk.core.view.g;
import com.baidu.tbadk.h.f;
import com.baidu.tbadk.widget.horizontalpullview.PullLeftRefreshLayout;
import com.baidu.tieba.R;
import com.baidu.tieba.enterForum.tabfeed.EnterForumTabFeedFragment;
import com.baidu.tieba.frs.SmartBubbleAnimatedView;
import com.baidu.tieba.frs.be;
import com.baidu.tieba.play.i;
/* loaded from: classes16.dex */
public class a {
    private TextView dSz;
    private PbListView fDW;
    private BdSwipeRefreshLayout fGi;
    private EnterForumTabFeedFragment hAx;
    private BdTypeRecyclerView hAy;
    private ViewGroup hBF;
    private be hBG;
    private SmartBubbleAnimatedView hBH;
    private b hBI;
    private boolean hBJ;
    private RecommendForumLayout hBK;
    private i hBL;
    private com.baidu.tieba.enterForum.tabfeed.a hBM;
    private com.baidu.tieba.enterForum.tabfeed.b hBu;
    private boolean hasMore;
    private g mPullView;
    private String tabName;
    private BdListView.e fXT = new BdListView.e() { // from class: com.baidu.tieba.enterForum.tabfeed.view.a.1
        @Override // com.baidu.adp.widget.ListView.BdListView.e
        public void onScrollToBottom() {
            if (a.this.hAy != null) {
                a.this.hAy.stopScroll();
            }
            if (a.this.fDW != null && a.this.hBu != null) {
                if (j.isNetWorkAvailable()) {
                    a.this.hAy.setNextPage(a.this.fDW);
                    a.this.fDW.showEmptyView(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
                    a.this.fDW.setOnClickListener(null);
                    if (a.this.hasMore) {
                        a.this.fDW.showLoading();
                        a.this.hBu.cgx();
                        return;
                    }
                    a.this.fDW.setText(a.this.hAx.getResources().getString(R.string.list_has_no_more));
                    a.this.fDW.endLoadData();
                    return;
                }
                a.this.hAy.setNextPage(null);
            }
        }
    };
    private RecyclerView.OnScrollListener hcz = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.enterForum.tabfeed.view.a.2
        private boolean hBQ;

        @Override // android.support.v7.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i) {
            if (i == 0) {
                if (a.this.hBL != null) {
                    a.this.hBL.a(a.this.hAy.getFirstVisiblePosition(), a.this.hAy.getLastVisiblePosition(), this.hBQ, true);
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001630, Boolean.valueOf(a.this.cgL() ? false : true)));
            }
        }

        @Override // android.support.v7.widget.RecyclerView.OnScrollListener
        public void onScrolled(RecyclerView recyclerView, int i, int i2) {
            super.onScrolled(recyclerView, i, i2);
            if (i2 > 0) {
                this.hBQ = false;
            } else {
                this.hBQ = true;
            }
        }
    };
    private View.OnClickListener hBN = new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.tabfeed.view.a.3
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (a.this.hAy != null) {
                a.this.hAy.stopScroll();
            }
            if (a.this.fDW != null && a.this.hBu != null && j.isNetWorkAvailable()) {
                a.this.fDW.showEmptyView(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
                a.this.fDW.setOnClickListener(null);
                if (a.this.hasMore) {
                    a.this.fDW.showLoading();
                    a.this.hBu.cgx();
                }
            }
        }
    };
    private f ahW = new f<bi>() { // from class: com.baidu.tieba.enterForum.tabfeed.view.a.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tbadk.h.f
        public void a(View view, bi biVar, int i, long j) {
            if (biVar == null) {
                com.baidu.tieba.enterForum.b.d(a.this.hAx.getPageContext(), a.this.tabName);
                if (a.this.hBK != null) {
                    aq aqVar = new aq("c13645");
                    aqVar.u("uid", TbadkApplication.getCurrentAccountId());
                    aqVar.ai("obj_locate", 1);
                    aqVar.ai("obj_type", a.this.hBK.ahV ? 5 : 1);
                    aqVar.ai("obj_source", 5);
                    TiebaStatic.log(aqVar);
                }
            } else if (biVar != null && a.this.hAx != null) {
                String forumName = biVar.getForumName();
                if (at.isForumName(forumName)) {
                    a.this.hAx.sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(a.this.hAx.getFragmentActivity()).createNormalCfg(forumName, FrsActivityConfig.FRS_FROM_ENTERFORUM_RECOMMEND).setCallFrom(3)));
                    if (a.this.hBK != null) {
                        aq aqVar2 = new aq("c13643");
                        aqVar2.u("uid", TbadkApplication.getCurrentAccountId());
                        aqVar2.u("fid", biVar.getForumId());
                        if (a.this.hBK.mFrom != 0) {
                            if (a.this.hBK.mFrom == 1) {
                                aqVar2.ai("obj_locate", 2);
                                aqVar2.dD("resource_id", a.this.tabName);
                            }
                        } else {
                            aqVar2.ai("obj_locate", 1);
                            aqVar2.ai("obj_type", a.this.hBK.ahV ? 4 : 1);
                        }
                        TiebaStatic.log(aqVar2);
                    }
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tbadk.h.f
        public void b(View view, bi biVar, int i, long j) {
            if (biVar != null) {
                aq aqVar = new aq("c13642");
                aqVar.u("uid", TbadkApplication.getCurrentAccountId());
                aqVar.u("fid", biVar.getForumId());
                if (a.this.hBK.mFrom != 0) {
                    if (a.this.hBK.mFrom == 1) {
                        aqVar.ai("obj_locate", 2);
                        aqVar.dD("resource_id", a.this.tabName);
                    }
                } else {
                    aqVar.ai("obj_locate", 1);
                    aqVar.ai("obj_type", a.this.hBK.ahV ? 3 : 1);
                }
                TiebaStatic.log(aqVar);
            }
        }
    };
    private View.OnClickListener hBO = new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.tabfeed.view.a.5
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            com.baidu.tieba.enterForum.b.d(a.this.hAx.getPageContext(), a.this.tabName);
            if (a.this.hBK != null) {
                aq aqVar = new aq("c13645");
                aqVar.u("uid", TbadkApplication.getCurrentAccountId());
                aqVar.ai("obj_locate", 1);
                aqVar.ai("obj_type", a.this.hBK.ahV ? 5 : 1);
                aqVar.ai("obj_source", 2);
                TiebaStatic.log(aqVar);
            }
        }
    };
    private PullLeftRefreshLayout.a aky = new PullLeftRefreshLayout.a() { // from class: com.baidu.tieba.enterForum.tabfeed.view.a.6
        @Override // com.baidu.tbadk.widget.horizontalpullview.PullLeftRefreshLayout.a
        public void bwT() {
            com.baidu.tieba.enterForum.b.d(a.this.hAx.getPageContext(), a.this.tabName);
            aq aqVar = new aq("c13645");
            aqVar.u("uid", TbadkApplication.getCurrentAccountId());
            aqVar.ai("obj_locate", 1);
            aqVar.ai("obj_type", a.this.hBK.ahV ? 5 : 1);
            aqVar.ai("obj_source", 4);
            TiebaStatic.log(aqVar);
        }
    };

    public a(EnterForumTabFeedFragment enterForumTabFeedFragment, com.baidu.tieba.enterForum.tabfeed.b bVar, ViewGroup viewGroup, String str) {
        this.hAx = enterForumTabFeedFragment;
        this.hBu = bVar;
        this.tabName = str;
        aS(viewGroup);
        this.hBM = new com.baidu.tieba.enterForum.tabfeed.a(enterForumTabFeedFragment, this.hAy);
        kf(false);
    }

    private void aS(ViewGroup viewGroup) {
        this.hBF = viewGroup;
        this.hAy = (BdTypeRecyclerView) viewGroup.findViewById(R.id.tab_feed_recycler_view);
        this.hAy.setLayoutManager(new LinearLayoutManager(this.hAx.getContext()));
        this.hAy.setFadingEdgeLength(0);
        this.hAy.setOverScrollMode(2);
        this.hAy.setOnSrollToBottomListener(this.fXT);
        this.hAy.addOnScrollListener(this.hcz);
        this.mPullView = new g(this.hAx.getPageContext());
        this.mPullView.setListPullRefreshListener(this.hBu);
        this.hAy.setRecyclerListener(new RecyclerView.RecyclerListener() { // from class: com.baidu.tieba.enterForum.tabfeed.view.a.7
            @Override // android.support.v7.widget.RecyclerView.RecyclerListener
            public void onViewRecycled(RecyclerView.ViewHolder viewHolder) {
                View view = viewHolder.itemView;
                if (view != null && a.this.hBL != null) {
                    a.this.hBL.cE(view);
                }
            }
        });
        this.fDW = new PbListView(this.hAx.getPageContext().getPageActivity());
        this.fDW.getView();
        this.fDW.setContainerBackgroundColorResId(R.color.cp_bg_line_e);
        this.fDW.setHeight(l.getDimens(this.hAx.getPageContext().getPageActivity(), R.dimen.tbds182));
        this.fDW.setLineGone();
        this.fDW.setTextSize(R.dimen.tbfontsize33);
        this.fDW.setTextColor(ap.getColor(R.color.cp_cont_j));
        this.fDW.setNoMoreTextColorId(R.color.cp_cont_e);
        this.fDW.bkv();
        this.fDW.setOnClickListener(this.hBN);
        if (this.fGi == null) {
            this.fGi = (BdSwipeRefreshLayout) viewGroup.findViewById(R.id.tab_feed_pull_refresh_layout);
            this.fGi.setProgressView(this.mPullView);
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.fGi.getLayoutParams();
            marginLayoutParams.topMargin = UtilHelper.getStatusBarHeight() + l.getDimens(this.hAx.getPageContext().getPageActivity(), R.dimen.tbds219);
            this.fGi.setLayoutParams(marginLayoutParams);
        }
        this.hBG = new be();
        this.hBH = new SmartBubbleAnimatedView(this.hAx.getContext());
        this.hBH.setLayoutParams(new FrameLayout.LayoutParams(-1, l.getDimens(this.hAx.getContext(), R.dimen.tbds83)));
        if (this.hBL == null) {
            this.hBL = new i(this.hAx.getPageContext(), this.hAy);
            this.hBL.FH(1);
            this.hBL.setUniqueId(this.hAx.getUniqueId());
        }
        this.hBI = new b(this.hAx.getPageContext());
        this.hBI.setTabName(this.tabName);
    }

    public void b(com.baidu.tieba.enterForum.tabfeed.b.b bVar) {
        if (bVar != null) {
            this.hasMore = bVar.hasMore;
        }
        kf(false);
        if (bVar != null && this.hBM != null && this.hAy != null && this.fDW != null) {
            cgJ();
            d(bVar);
            c(bVar);
            if (bVar.hBq > 0) {
                int firstVisiblePosition = this.hAy.getFirstVisiblePosition();
                View childAt = this.hAy.getChildAt(0);
                int top = childAt == null ? 0 : childAt.getTop();
                RecyclerView.LayoutManager layoutManager = this.hAy.getLayoutManager();
                int i = firstVisiblePosition - bVar.hBq;
                if (layoutManager instanceof LinearLayoutManager) {
                    this.hAy.qM();
                    ((LinearLayoutManager) layoutManager).scrollToPositionWithOffset(i, top);
                    this.hAy.qN();
                }
                bVar.hBq = 0;
            }
            this.hBM.setIsFromCDN(bVar.ajr);
            this.hBM.setData(bVar.hBp);
            this.hBM.notifyDataSetChanged();
            if (bVar.fky) {
                wl(bVar.refreshCount);
            }
            if (this.hBL != null) {
                this.hBL.a(this.hAy.getFirstVisiblePosition(), this.hAy.getLastVisiblePosition(), false, true);
            }
        }
    }

    private void cgJ() {
        if (this.dSz == null) {
            this.dSz = new TextView(this.hAx.getContext());
            this.dSz.setPadding(l.getDimens(this.hAx.getContext(), R.dimen.tbds44), l.getDimens(this.hAx.getContext(), R.dimen.tbds60), 0, l.getDimens(this.hAx.getContext(), R.dimen.tbds24));
            this.dSz.setText(R.string.tab_feed_title);
            this.dSz.setTextSize(0, l.getDimens(this.hAx.getContext(), R.dimen.tbds46));
            this.dSz.setTypeface(Typeface.DEFAULT_BOLD);
            this.hAy.removeHeaderView(this.dSz);
            this.hAy.addHeaderView(this.dSz, 0);
            ap.setViewTextColor(this.dSz, R.color.cp_cont_b);
        }
    }

    private void c(com.baidu.tieba.enterForum.tabfeed.b.b bVar) {
        if (bVar != null && this.hAy != null && this.hAx != null && bVar.fky) {
            if (!((bVar.hBo == null || y.isEmpty(bVar.hBo.bdK())) ? false : true)) {
                if (this.hBK != null) {
                    this.hAy.removeHeaderView(this.hBK);
                    return;
                }
                return;
            }
            if (this.hBK == null) {
                this.hBK = new RecommendForumLayout(this.hAx.getPageContext());
                this.hBK.setShowMore(true);
                this.hBK.setSquareEntranceAtStart(true);
                this.hBK.setTabName(this.tabName);
                this.hBK.setFrom(1);
            }
            this.hBK.setOnClickRightArrowListener(this.hBO);
            this.hBK.setOnRullOkCallbackr(this.aky);
            this.hBK.setOnItemCoverListener(this.ahW);
            this.hBK.b(bVar.hBo);
            this.hAy.removeHeaderView(this.hBK);
            this.hAy.addHeaderView(this.hBK, 0);
            aq aqVar = new aq("c13641");
            aqVar.u("uid", TbadkApplication.getCurrentAccountId());
            aqVar.ai("obj_locate", 2);
            aqVar.dD("resource_id", this.tabName);
            TiebaStatic.log(aqVar);
        }
    }

    private void d(com.baidu.tieba.enterForum.tabfeed.b.b bVar) {
        if (bVar.hBr != null && bVar.hBr.hot_user != null && bVar.hBr.hot_user.size() > 0 && !TextUtils.isEmpty(bVar.hBr.module_name)) {
            this.hBI.a(bVar.hBr);
            if (this.hBI.getView().getParent() == null && !this.hBJ) {
                this.hBJ = true;
                this.hAy.addHeaderView(this.hBI.getView(), 0);
                aq aqVar = new aq("c13656");
                aqVar.u("uid", TbadkApplication.getCurrentAccountId());
                aqVar.dD("resource_id", this.tabName);
                TiebaStatic.log(aqVar);
                return;
            }
            return;
        }
        this.hBJ = false;
        this.hAy.removeHeaderView(this.hBI.getView());
    }

    public void onChangeSkinType(int i) {
        if (this.mPullView != null) {
            this.mPullView.changeSkin(i);
        }
        if (this.fDW != null) {
            this.fDW.setTextColor(ap.getColor(R.color.cp_cont_j));
            this.fDW.changeSkin(i);
        }
        if (this.hBM != null) {
            this.hBM.notifyDataSetChanged();
        }
        if (this.dSz != null) {
            ap.setViewTextColor(this.dSz, R.color.cp_cont_b);
        }
        if (this.hBI != null) {
            this.hBI.onChangeSkinType();
        }
        if (this.hBK != null) {
            this.hBK.onChangeSkinType();
        }
        if (this.hBH != null) {
            this.hBH.onChangeSkinType(i);
        }
    }

    public void resume() {
        if (this.hBL != null) {
            this.hBL.rF(true);
            if (this.hAy != null) {
                this.hBL.a(this.hAy.getFirstVisiblePosition(), this.hAy.getLastVisiblePosition(), false, true);
            }
        }
    }

    public void pause() {
        if (this.hBL != null) {
            this.hBL.cNd();
            this.hBL.rF(false);
        }
    }

    public void cgK() {
        if (this.hAy != null) {
            this.hAy.scrollToPosition(0);
        }
    }

    public void kf(boolean z) {
        if (this.fGi != null) {
            this.fGi.setRefreshing(z);
        }
    }

    public void nM(boolean z) {
        if (this.fGi != null) {
            this.fGi.setVisibility(z ? 0 : 8);
        }
    }

    public boolean cgL() {
        return this.hAy == null || this.hAy.getChildCount() == 0 || this.hAy.getChildAt(0).getTop() == 0;
    }

    private void wl(int i) {
        String string;
        if (i >= 0) {
            this.hBG.com();
            if (i > 0) {
                string = String.format(TbadkCoreApplication.getInst().getString(R.string.recommend_frs_refresh_return), Integer.valueOf(i));
            } else {
                string = TbadkCoreApplication.getInst().getString(R.string.recommend_frs_refresh_nodata);
            }
            if (!TextUtils.isEmpty(string) && j.isNetWorkAvailable()) {
                this.hBH.etm = string;
                this.hBH.hXP = 2000L;
                FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
                layoutParams.gravity = 49;
                layoutParams.topMargin = UtilHelper.getStatusBarHeight() + l.getDimens(this.hAx.getPageContext().getPageActivity(), R.dimen.tbds228);
                if (this.hBF != null) {
                    this.hBF.removeView(this.hBH);
                    this.hBF.addView(this.hBH, layoutParams);
                    this.hBH.cok();
                }
            }
        }
    }

    public void cb(int i, int i2) {
        if (this.hAy != null && i < i2) {
            this.hAy.o(i, i2);
        }
    }
}
