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
    private TextView dSD;
    private PbListView fEa;
    private BdSwipeRefreshLayout fGm;
    private EnterForumTabFeedFragment hAD;
    private BdTypeRecyclerView hAE;
    private com.baidu.tieba.enterForum.tabfeed.b hBA;
    private ViewGroup hBL;
    private be hBM;
    private SmartBubbleAnimatedView hBN;
    private b hBO;
    private boolean hBP;
    private RecommendForumLayout hBQ;
    private i hBR;
    private com.baidu.tieba.enterForum.tabfeed.a hBS;
    private boolean hasMore;
    private g mPullView;
    private String tabName;
    private BdListView.e fXX = new BdListView.e() { // from class: com.baidu.tieba.enterForum.tabfeed.view.a.1
        @Override // com.baidu.adp.widget.ListView.BdListView.e
        public void onScrollToBottom() {
            if (a.this.hAE != null) {
                a.this.hAE.stopScroll();
            }
            if (a.this.fEa != null && a.this.hBA != null) {
                if (j.isNetWorkAvailable()) {
                    a.this.hAE.setNextPage(a.this.fEa);
                    a.this.fEa.showEmptyView(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
                    a.this.fEa.setOnClickListener(null);
                    if (a.this.hasMore) {
                        a.this.fEa.showLoading();
                        a.this.hBA.cgy();
                        return;
                    }
                    a.this.fEa.setText(a.this.hAD.getResources().getString(R.string.list_has_no_more));
                    a.this.fEa.endLoadData();
                    return;
                }
                a.this.hAE.setNextPage(null);
            }
        }
    };
    private RecyclerView.OnScrollListener hcD = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.enterForum.tabfeed.view.a.2
        private boolean hBW;

        @Override // android.support.v7.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i) {
            if (i == 0) {
                if (a.this.hBR != null) {
                    a.this.hBR.a(a.this.hAE.getFirstVisiblePosition(), a.this.hAE.getLastVisiblePosition(), this.hBW, true);
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001630, Boolean.valueOf(a.this.cgM() ? false : true)));
            }
        }

        @Override // android.support.v7.widget.RecyclerView.OnScrollListener
        public void onScrolled(RecyclerView recyclerView, int i, int i2) {
            super.onScrolled(recyclerView, i, i2);
            if (i2 > 0) {
                this.hBW = false;
            } else {
                this.hBW = true;
            }
        }
    };
    private View.OnClickListener hBT = new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.tabfeed.view.a.3
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (a.this.hAE != null) {
                a.this.hAE.stopScroll();
            }
            if (a.this.fEa != null && a.this.hBA != null && j.isNetWorkAvailable()) {
                a.this.fEa.showEmptyView(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
                a.this.fEa.setOnClickListener(null);
                if (a.this.hasMore) {
                    a.this.fEa.showLoading();
                    a.this.hBA.cgy();
                }
            }
        }
    };
    private f ahY = new f<bi>() { // from class: com.baidu.tieba.enterForum.tabfeed.view.a.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tbadk.h.f
        public void a(View view, bi biVar, int i, long j) {
            if (biVar == null) {
                com.baidu.tieba.enterForum.b.d(a.this.hAD.getPageContext(), a.this.tabName);
                if (a.this.hBQ != null) {
                    aq aqVar = new aq("c13645");
                    aqVar.u("uid", TbadkApplication.getCurrentAccountId());
                    aqVar.ai("obj_locate", 1);
                    aqVar.ai("obj_type", a.this.hBQ.ahX ? 5 : 1);
                    aqVar.ai("obj_source", 5);
                    TiebaStatic.log(aqVar);
                }
            } else if (biVar != null && a.this.hAD != null) {
                String forumName = biVar.getForumName();
                if (at.isForumName(forumName)) {
                    a.this.hAD.sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(a.this.hAD.getFragmentActivity()).createNormalCfg(forumName, FrsActivityConfig.FRS_FROM_ENTERFORUM_RECOMMEND).setCallFrom(3)));
                    if (a.this.hBQ != null) {
                        aq aqVar2 = new aq("c13643");
                        aqVar2.u("uid", TbadkApplication.getCurrentAccountId());
                        aqVar2.u("fid", biVar.getForumId());
                        if (a.this.hBQ.mFrom != 0) {
                            if (a.this.hBQ.mFrom == 1) {
                                aqVar2.ai("obj_locate", 2);
                                aqVar2.dD("resource_id", a.this.tabName);
                            }
                        } else {
                            aqVar2.ai("obj_locate", 1);
                            aqVar2.ai("obj_type", a.this.hBQ.ahX ? 4 : 1);
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
                if (a.this.hBQ.mFrom != 0) {
                    if (a.this.hBQ.mFrom == 1) {
                        aqVar.ai("obj_locate", 2);
                        aqVar.dD("resource_id", a.this.tabName);
                    }
                } else {
                    aqVar.ai("obj_locate", 1);
                    aqVar.ai("obj_type", a.this.hBQ.ahX ? 3 : 1);
                }
                TiebaStatic.log(aqVar);
            }
        }
    };
    private View.OnClickListener hBU = new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.tabfeed.view.a.5
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            com.baidu.tieba.enterForum.b.d(a.this.hAD.getPageContext(), a.this.tabName);
            if (a.this.hBQ != null) {
                aq aqVar = new aq("c13645");
                aqVar.u("uid", TbadkApplication.getCurrentAccountId());
                aqVar.ai("obj_locate", 1);
                aqVar.ai("obj_type", a.this.hBQ.ahX ? 5 : 1);
                aqVar.ai("obj_source", 2);
                TiebaStatic.log(aqVar);
            }
        }
    };
    private PullLeftRefreshLayout.a akA = new PullLeftRefreshLayout.a() { // from class: com.baidu.tieba.enterForum.tabfeed.view.a.6
        @Override // com.baidu.tbadk.widget.horizontalpullview.PullLeftRefreshLayout.a
        public void bwU() {
            com.baidu.tieba.enterForum.b.d(a.this.hAD.getPageContext(), a.this.tabName);
            aq aqVar = new aq("c13645");
            aqVar.u("uid", TbadkApplication.getCurrentAccountId());
            aqVar.ai("obj_locate", 1);
            aqVar.ai("obj_type", a.this.hBQ.ahX ? 5 : 1);
            aqVar.ai("obj_source", 4);
            TiebaStatic.log(aqVar);
        }
    };

    public a(EnterForumTabFeedFragment enterForumTabFeedFragment, com.baidu.tieba.enterForum.tabfeed.b bVar, ViewGroup viewGroup, String str) {
        this.hAD = enterForumTabFeedFragment;
        this.hBA = bVar;
        this.tabName = str;
        aS(viewGroup);
        this.hBS = new com.baidu.tieba.enterForum.tabfeed.a(enterForumTabFeedFragment, this.hAE);
        kh(false);
    }

    private void aS(ViewGroup viewGroup) {
        this.hBL = viewGroup;
        this.hAE = (BdTypeRecyclerView) viewGroup.findViewById(R.id.tab_feed_recycler_view);
        this.hAE.setLayoutManager(new LinearLayoutManager(this.hAD.getContext()));
        this.hAE.setFadingEdgeLength(0);
        this.hAE.setOverScrollMode(2);
        this.hAE.setOnSrollToBottomListener(this.fXX);
        this.hAE.addOnScrollListener(this.hcD);
        this.mPullView = new g(this.hAD.getPageContext());
        this.mPullView.setListPullRefreshListener(this.hBA);
        this.hAE.setRecyclerListener(new RecyclerView.RecyclerListener() { // from class: com.baidu.tieba.enterForum.tabfeed.view.a.7
            @Override // android.support.v7.widget.RecyclerView.RecyclerListener
            public void onViewRecycled(RecyclerView.ViewHolder viewHolder) {
                View view = viewHolder.itemView;
                if (view != null && a.this.hBR != null) {
                    a.this.hBR.cE(view);
                }
            }
        });
        this.fEa = new PbListView(this.hAD.getPageContext().getPageActivity());
        this.fEa.getView();
        this.fEa.setContainerBackgroundColorResId(R.color.cp_bg_line_e);
        this.fEa.setHeight(l.getDimens(this.hAD.getPageContext().getPageActivity(), R.dimen.tbds182));
        this.fEa.setLineGone();
        this.fEa.setTextSize(R.dimen.tbfontsize33);
        this.fEa.setTextColor(ap.getColor(R.color.cp_cont_j));
        this.fEa.setNoMoreTextColorId(R.color.cp_cont_e);
        this.fEa.bkv();
        this.fEa.setOnClickListener(this.hBT);
        if (this.fGm == null) {
            this.fGm = (BdSwipeRefreshLayout) viewGroup.findViewById(R.id.tab_feed_pull_refresh_layout);
            this.fGm.setProgressView(this.mPullView);
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.fGm.getLayoutParams();
            marginLayoutParams.topMargin = UtilHelper.getStatusBarHeight() + l.getDimens(this.hAD.getPageContext().getPageActivity(), R.dimen.tbds219);
            this.fGm.setLayoutParams(marginLayoutParams);
        }
        this.hBM = new be();
        this.hBN = new SmartBubbleAnimatedView(this.hAD.getContext());
        this.hBN.setLayoutParams(new FrameLayout.LayoutParams(-1, l.getDimens(this.hAD.getContext(), R.dimen.tbds83)));
        if (this.hBR == null) {
            this.hBR = new i(this.hAD.getPageContext(), this.hAE);
            this.hBR.FH(1);
            this.hBR.setUniqueId(this.hAD.getUniqueId());
        }
        this.hBO = new b(this.hAD.getPageContext());
        this.hBO.setTabName(this.tabName);
    }

    public void b(com.baidu.tieba.enterForum.tabfeed.b.b bVar) {
        if (bVar != null) {
            this.hasMore = bVar.hasMore;
        }
        kh(false);
        if (bVar != null && this.hBS != null && this.hAE != null && this.fEa != null) {
            cgK();
            d(bVar);
            c(bVar);
            if (bVar.hBw > 0) {
                int firstVisiblePosition = this.hAE.getFirstVisiblePosition();
                View childAt = this.hAE.getChildAt(0);
                int top = childAt == null ? 0 : childAt.getTop();
                RecyclerView.LayoutManager layoutManager = this.hAE.getLayoutManager();
                int i = firstVisiblePosition - bVar.hBw;
                if (layoutManager instanceof LinearLayoutManager) {
                    this.hAE.qM();
                    ((LinearLayoutManager) layoutManager).scrollToPositionWithOffset(i, top);
                    this.hAE.qN();
                }
                bVar.hBw = 0;
            }
            this.hBS.setIsFromCDN(bVar.ajt);
            this.hBS.setData(bVar.hBv);
            this.hBS.notifyDataSetChanged();
            if (bVar.fkC) {
                wl(bVar.refreshCount);
            }
            if (this.hBR != null) {
                this.hBR.a(this.hAE.getFirstVisiblePosition(), this.hAE.getLastVisiblePosition(), false, true);
            }
        }
    }

    private void cgK() {
        if (this.dSD == null) {
            this.dSD = new TextView(this.hAD.getContext());
            this.dSD.setPadding(l.getDimens(this.hAD.getContext(), R.dimen.tbds44), l.getDimens(this.hAD.getContext(), R.dimen.tbds60), 0, l.getDimens(this.hAD.getContext(), R.dimen.tbds24));
            this.dSD.setText(R.string.tab_feed_title);
            this.dSD.setTextSize(0, l.getDimens(this.hAD.getContext(), R.dimen.tbds46));
            this.dSD.setTypeface(Typeface.DEFAULT_BOLD);
            this.hAE.removeHeaderView(this.dSD);
            this.hAE.addHeaderView(this.dSD, 0);
            ap.setViewTextColor(this.dSD, R.color.cp_cont_b);
        }
    }

    private void c(com.baidu.tieba.enterForum.tabfeed.b.b bVar) {
        if (bVar != null && this.hAE != null && this.hAD != null && bVar.fkC) {
            if (!((bVar.hBu == null || y.isEmpty(bVar.hBu.bdK())) ? false : true)) {
                if (this.hBQ != null) {
                    this.hAE.removeHeaderView(this.hBQ);
                    return;
                }
                return;
            }
            if (this.hBQ == null) {
                this.hBQ = new RecommendForumLayout(this.hAD.getPageContext());
                this.hBQ.setShowMore(true);
                this.hBQ.setSquareEntranceAtStart(true);
                this.hBQ.setTabName(this.tabName);
                this.hBQ.setFrom(1);
            }
            this.hBQ.setOnClickRightArrowListener(this.hBU);
            this.hBQ.setOnRullOkCallbackr(this.akA);
            this.hBQ.setOnItemCoverListener(this.ahY);
            this.hBQ.b(bVar.hBu);
            this.hAE.removeHeaderView(this.hBQ);
            this.hAE.addHeaderView(this.hBQ, 0);
            aq aqVar = new aq("c13641");
            aqVar.u("uid", TbadkApplication.getCurrentAccountId());
            aqVar.ai("obj_locate", 2);
            aqVar.dD("resource_id", this.tabName);
            TiebaStatic.log(aqVar);
        }
    }

    private void d(com.baidu.tieba.enterForum.tabfeed.b.b bVar) {
        if (bVar.hBx != null && bVar.hBx.hot_user != null && bVar.hBx.hot_user.size() > 0 && !TextUtils.isEmpty(bVar.hBx.module_name)) {
            this.hBO.a(bVar.hBx);
            if (this.hBO.getView().getParent() == null && !this.hBP) {
                this.hBP = true;
                this.hAE.addHeaderView(this.hBO.getView(), 0);
                aq aqVar = new aq("c13656");
                aqVar.u("uid", TbadkApplication.getCurrentAccountId());
                aqVar.dD("resource_id", this.tabName);
                TiebaStatic.log(aqVar);
                return;
            }
            return;
        }
        this.hBP = false;
        this.hAE.removeHeaderView(this.hBO.getView());
    }

    public void onChangeSkinType(int i) {
        if (this.mPullView != null) {
            this.mPullView.changeSkin(i);
        }
        if (this.fEa != null) {
            this.fEa.setTextColor(ap.getColor(R.color.cp_cont_j));
            this.fEa.changeSkin(i);
        }
        if (this.hBS != null) {
            this.hBS.notifyDataSetChanged();
        }
        if (this.dSD != null) {
            ap.setViewTextColor(this.dSD, R.color.cp_cont_b);
        }
        if (this.hBO != null) {
            this.hBO.onChangeSkinType();
        }
        if (this.hBQ != null) {
            this.hBQ.onChangeSkinType();
        }
        if (this.hBN != null) {
            this.hBN.onChangeSkinType(i);
        }
    }

    public void resume() {
        if (this.hBR != null) {
            this.hBR.rH(true);
            if (this.hAE != null) {
                this.hBR.a(this.hAE.getFirstVisiblePosition(), this.hAE.getLastVisiblePosition(), false, true);
            }
        }
    }

    public void pause() {
        if (this.hBR != null) {
            this.hBR.cNe();
            this.hBR.rH(false);
        }
    }

    public void cgL() {
        if (this.hAE != null) {
            this.hAE.scrollToPosition(0);
        }
    }

    public void kh(boolean z) {
        if (this.fGm != null) {
            this.fGm.setRefreshing(z);
        }
    }

    public void nO(boolean z) {
        if (this.fGm != null) {
            this.fGm.setVisibility(z ? 0 : 8);
        }
    }

    public boolean cgM() {
        return this.hAE == null || this.hAE.getChildCount() == 0 || this.hAE.getChildAt(0).getTop() == 0;
    }

    private void wl(int i) {
        String string;
        if (i >= 0) {
            this.hBM.con();
            if (i > 0) {
                string = String.format(TbadkCoreApplication.getInst().getString(R.string.recommend_frs_refresh_return), Integer.valueOf(i));
            } else {
                string = TbadkCoreApplication.getInst().getString(R.string.recommend_frs_refresh_nodata);
            }
            if (!TextUtils.isEmpty(string) && j.isNetWorkAvailable()) {
                this.hBN.etq = string;
                this.hBN.hXV = 2000L;
                FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
                layoutParams.gravity = 49;
                layoutParams.topMargin = UtilHelper.getStatusBarHeight() + l.getDimens(this.hAD.getPageContext().getPageActivity(), R.dimen.tbds228);
                if (this.hBL != null) {
                    this.hBL.removeView(this.hBN);
                    this.hBL.addView(this.hBN, layoutParams);
                    this.hBN.col();
                }
            }
        }
    }

    public void cb(int i, int i2) {
        if (this.hAE != null && i < i2) {
            this.hAE.o(i, i2);
        }
    }
}
