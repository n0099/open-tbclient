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
import com.baidu.tbadk.core.data.bh;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.core.util.x;
import com.baidu.tbadk.core.view.PbListView;
import com.baidu.tbadk.core.view.g;
import com.baidu.tbadk.h.f;
import com.baidu.tbadk.widget.horizontalpullview.PullLeftRefreshLayout;
import com.baidu.tieba.R;
import com.baidu.tieba.enterForum.tabfeed.EnterForumTabFeedFragment;
import com.baidu.tieba.frs.SmartBubbleAnimatedView;
import com.baidu.tieba.frs.bc;
import com.baidu.tieba.play.i;
/* loaded from: classes16.dex */
public class a {
    private TextView dJr;
    private PbListView fsC;
    private BdSwipeRefreshLayout fuP;
    private boolean hasMore;
    private EnterForumTabFeedFragment hnG;
    private BdTypeRecyclerView hnH;
    private com.baidu.tieba.enterForum.tabfeed.b hoD;
    private ViewGroup hoO;
    private bc hoP;
    private SmartBubbleAnimatedView hoQ;
    private b hoR;
    private boolean hoS;
    private RecommendForumLayout hoT;
    private i hoU;
    private com.baidu.tieba.enterForum.tabfeed.a hoV;
    private g mPullView;
    private String tabName;
    private BdListView.e fLV = new BdListView.e() { // from class: com.baidu.tieba.enterForum.tabfeed.view.a.1
        @Override // com.baidu.adp.widget.ListView.BdListView.e
        public void onScrollToBottom() {
            if (a.this.hnH != null) {
                a.this.hnH.stopScroll();
            }
            if (a.this.fsC != null && a.this.hoD != null) {
                if (j.isNetWorkAvailable()) {
                    a.this.hnH.setNextPage(a.this.fsC);
                    a.this.fsC.showEmptyView(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
                    a.this.fsC.setOnClickListener(null);
                    if (a.this.hasMore) {
                        a.this.fsC.showLoading();
                        a.this.hoD.bWk();
                        return;
                    }
                    a.this.fsC.setText(a.this.hnG.getResources().getString(R.string.list_has_no_more));
                    a.this.fsC.endLoadData();
                    return;
                }
                a.this.hnH.setNextPage(null);
            }
        }
    };
    private RecyclerView.OnScrollListener gPJ = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.enterForum.tabfeed.view.a.2
        private boolean hoZ;

        @Override // android.support.v7.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i) {
            if (i == 0) {
                if (a.this.hoU != null) {
                    a.this.hoU.a(a.this.hnH.getFirstVisiblePosition(), a.this.hnH.getLastVisiblePosition(), this.hoZ, true);
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001630, Boolean.valueOf(a.this.bWy() ? false : true)));
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
    private View.OnClickListener hoW = new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.tabfeed.view.a.3
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (a.this.hnH != null) {
                a.this.hnH.stopScroll();
            }
            if (a.this.fsC != null && a.this.hoD != null && j.isNetWorkAvailable()) {
                a.this.fsC.showEmptyView(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
                a.this.fsC.setOnClickListener(null);
                if (a.this.hasMore) {
                    a.this.fsC.showLoading();
                    a.this.hoD.bWk();
                }
            }
        }
    };
    private f agN = new f<bh>() { // from class: com.baidu.tieba.enterForum.tabfeed.view.a.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tbadk.h.f
        public void a(View view, bh bhVar, int i, long j) {
            if (bhVar == null) {
                com.baidu.tieba.enterForum.b.d(a.this.hnG.getPageContext(), a.this.tabName);
                if (a.this.hoT != null) {
                    ap apVar = new ap("c13645");
                    apVar.t("uid", TbadkApplication.getCurrentAccountId());
                    apVar.ah("obj_locate", 1);
                    apVar.ah("obj_type", a.this.hoT.agM ? 5 : 1);
                    apVar.ah("obj_source", 5);
                    TiebaStatic.log(apVar);
                }
            } else if (bhVar != null && a.this.hnG != null) {
                String forumName = bhVar.getForumName();
                if (as.isForumName(forumName)) {
                    a.this.hnG.sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(a.this.hnG.getFragmentActivity()).createNormalCfg(forumName, FrsActivityConfig.FRS_FROM_ENTERFORUM_RECOMMEND).setCallFrom(3)));
                    if (a.this.hoT != null) {
                        ap apVar2 = new ap("c13643");
                        apVar2.t("uid", TbadkApplication.getCurrentAccountId());
                        apVar2.t("fid", bhVar.getForumId());
                        if (a.this.hoT.mFrom != 0) {
                            if (a.this.hoT.mFrom == 1) {
                                apVar2.ah("obj_locate", 2);
                                apVar2.dn("resource_id", a.this.tabName);
                            }
                        } else {
                            apVar2.ah("obj_locate", 1);
                            apVar2.ah("obj_type", a.this.hoT.agM ? 4 : 1);
                        }
                        TiebaStatic.log(apVar2);
                    }
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tbadk.h.f
        public void b(View view, bh bhVar, int i, long j) {
            if (bhVar != null) {
                ap apVar = new ap("c13642");
                apVar.t("uid", TbadkApplication.getCurrentAccountId());
                apVar.t("fid", bhVar.getForumId());
                if (a.this.hoT.mFrom != 0) {
                    if (a.this.hoT.mFrom == 1) {
                        apVar.ah("obj_locate", 2);
                        apVar.dn("resource_id", a.this.tabName);
                    }
                } else {
                    apVar.ah("obj_locate", 1);
                    apVar.ah("obj_type", a.this.hoT.agM ? 3 : 1);
                }
                TiebaStatic.log(apVar);
            }
        }
    };
    private View.OnClickListener hoX = new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.tabfeed.view.a.5
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            com.baidu.tieba.enterForum.b.d(a.this.hnG.getPageContext(), a.this.tabName);
            if (a.this.hoT != null) {
                ap apVar = new ap("c13645");
                apVar.t("uid", TbadkApplication.getCurrentAccountId());
                apVar.ah("obj_locate", 1);
                apVar.ah("obj_type", a.this.hoT.agM ? 5 : 1);
                apVar.ah("obj_source", 2);
                TiebaStatic.log(apVar);
            }
        }
    };
    private PullLeftRefreshLayout.a ajj = new PullLeftRefreshLayout.a() { // from class: com.baidu.tieba.enterForum.tabfeed.view.a.6
        @Override // com.baidu.tbadk.widget.horizontalpullview.PullLeftRefreshLayout.a
        public void bog() {
            com.baidu.tieba.enterForum.b.d(a.this.hnG.getPageContext(), a.this.tabName);
            ap apVar = new ap("c13645");
            apVar.t("uid", TbadkApplication.getCurrentAccountId());
            apVar.ah("obj_locate", 1);
            apVar.ah("obj_type", a.this.hoT.agM ? 5 : 1);
            apVar.ah("obj_source", 4);
            TiebaStatic.log(apVar);
        }
    };

    public a(EnterForumTabFeedFragment enterForumTabFeedFragment, com.baidu.tieba.enterForum.tabfeed.b bVar, ViewGroup viewGroup, String str) {
        this.hnG = enterForumTabFeedFragment;
        this.hoD = bVar;
        this.tabName = str;
        aT(viewGroup);
        this.hoV = new com.baidu.tieba.enterForum.tabfeed.a(enterForumTabFeedFragment, this.hnH);
        jH(false);
    }

    private void aT(ViewGroup viewGroup) {
        this.hoO = viewGroup;
        this.hnH = (BdTypeRecyclerView) viewGroup.findViewById(R.id.tab_feed_recycler_view);
        this.hnH.setLayoutManager(new LinearLayoutManager(this.hnG.getContext()));
        this.hnH.setFadingEdgeLength(0);
        this.hnH.setOverScrollMode(2);
        this.hnH.setOnSrollToBottomListener(this.fLV);
        this.hnH.addOnScrollListener(this.gPJ);
        this.mPullView = new g(this.hnG.getPageContext());
        this.mPullView.setListPullRefreshListener(this.hoD);
        this.hnH.setRecyclerListener(new RecyclerView.RecyclerListener() { // from class: com.baidu.tieba.enterForum.tabfeed.view.a.7
            @Override // android.support.v7.widget.RecyclerView.RecyclerListener
            public void onViewRecycled(RecyclerView.ViewHolder viewHolder) {
                View view = viewHolder.itemView;
                if (view != null && a.this.hoU != null) {
                    a.this.hoU.cA(view);
                }
            }
        });
        this.fsC = new PbListView(this.hnG.getPageContext().getPageActivity());
        this.fsC.getView();
        this.fsC.setContainerBackgroundColorResId(R.color.cp_bg_line_e);
        this.fsC.setHeight(l.getDimens(this.hnG.getPageContext().getPageActivity(), R.dimen.tbds182));
        this.fsC.setLineGone();
        this.fsC.setTextSize(R.dimen.tbfontsize33);
        this.fsC.setTextColor(ao.getColor(R.color.cp_cont_j));
        this.fsC.setNoMoreTextColorId(R.color.cp_cont_e);
        this.fsC.bbZ();
        this.fsC.setOnClickListener(this.hoW);
        if (this.fuP == null) {
            this.fuP = (BdSwipeRefreshLayout) viewGroup.findViewById(R.id.tab_feed_pull_refresh_layout);
            this.fuP.setProgressView(this.mPullView);
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.fuP.getLayoutParams();
            marginLayoutParams.topMargin = UtilHelper.getStatusBarHeight() + l.getDimens(this.hnG.getPageContext().getPageActivity(), R.dimen.tbds219);
            this.fuP.setLayoutParams(marginLayoutParams);
        }
        this.hoP = new bc();
        this.hoQ = new SmartBubbleAnimatedView(this.hnG.getContext());
        this.hoQ.setLayoutParams(new FrameLayout.LayoutParams(-1, l.getDimens(this.hnG.getContext(), R.dimen.tbds83)));
        if (this.hoU == null) {
            this.hoU = new i(this.hnG.getPageContext(), this.hnH);
            this.hoU.Dm(1);
            this.hoU.setUniqueId(this.hnG.getUniqueId());
        }
        this.hoR = new b(this.hnG.getPageContext());
        this.hoR.setTabName(this.tabName);
    }

    public void b(com.baidu.tieba.enterForum.tabfeed.b.b bVar) {
        if (bVar != null) {
            this.hasMore = bVar.hasMore;
        }
        jH(false);
        if (bVar != null && this.hoV != null && this.hnH != null && this.fsC != null) {
            bWw();
            d(bVar);
            c(bVar);
            if (bVar.hoz > 0) {
                int firstVisiblePosition = this.hnH.getFirstVisiblePosition();
                View childAt = this.hnH.getChildAt(0);
                int top = childAt == null ? 0 : childAt.getTop();
                RecyclerView.LayoutManager layoutManager = this.hnH.getLayoutManager();
                int i = firstVisiblePosition - bVar.hoz;
                if (layoutManager instanceof LinearLayoutManager) {
                    this.hnH.pn();
                    ((LinearLayoutManager) layoutManager).scrollToPositionWithOffset(i, top);
                    this.hnH.po();
                }
                bVar.hoz = 0;
            }
            this.hoV.setIsFromCDN(bVar.aib);
            this.hoV.setData(bVar.hoy);
            this.hoV.notifyDataSetChanged();
            if (bVar.eZg) {
                tW(bVar.refreshCount);
            }
            if (this.hoU != null) {
                this.hoU.a(this.hnH.getFirstVisiblePosition(), this.hnH.getLastVisiblePosition(), false, true);
            }
        }
    }

    private void bWw() {
        if (this.dJr == null) {
            this.dJr = new TextView(this.hnG.getContext());
            this.dJr.setPadding(l.getDimens(this.hnG.getContext(), R.dimen.tbds44), l.getDimens(this.hnG.getContext(), R.dimen.tbds60), 0, l.getDimens(this.hnG.getContext(), R.dimen.tbds24));
            this.dJr.setText(R.string.tab_feed_title);
            this.dJr.setTextSize(0, l.getDimens(this.hnG.getContext(), R.dimen.tbds46));
            this.dJr.setTypeface(Typeface.DEFAULT_BOLD);
            this.hnH.removeHeaderView(this.dJr);
            this.hnH.addHeaderView(this.dJr, 0);
            ao.setViewTextColor(this.dJr, R.color.cp_cont_b);
        }
    }

    private void c(com.baidu.tieba.enterForum.tabfeed.b.b bVar) {
        if (bVar != null && this.hnH != null && this.hnG != null && bVar.eZg) {
            if (!((bVar.hox == null || x.isEmpty(bVar.hox.aVr())) ? false : true)) {
                if (this.hoT != null) {
                    this.hnH.removeHeaderView(this.hoT);
                    return;
                }
                return;
            }
            if (this.hoT == null) {
                this.hoT = new RecommendForumLayout(this.hnG.getPageContext());
                this.hoT.setShowMore(true);
                this.hoT.setSquareEntranceAtStart(true);
                this.hoT.setTabName(this.tabName);
                this.hoT.setFrom(1);
            }
            this.hoT.setOnClickRightArrowListener(this.hoX);
            this.hoT.setOnRullOkCallbackr(this.ajj);
            this.hoT.setOnItemCoverListener(this.agN);
            this.hoT.b(bVar.hox);
            this.hnH.removeHeaderView(this.hoT);
            this.hnH.addHeaderView(this.hoT, 0);
            ap apVar = new ap("c13641");
            apVar.t("uid", TbadkApplication.getCurrentAccountId());
            apVar.ah("obj_locate", 2);
            apVar.dn("resource_id", this.tabName);
            TiebaStatic.log(apVar);
        }
    }

    private void d(com.baidu.tieba.enterForum.tabfeed.b.b bVar) {
        if (bVar.hoA != null && bVar.hoA.hot_user != null && bVar.hoA.hot_user.size() > 0 && !TextUtils.isEmpty(bVar.hoA.module_name)) {
            this.hoR.a(bVar.hoA);
            if (this.hoR.getView().getParent() == null && !this.hoS) {
                this.hoS = true;
                this.hnH.addHeaderView(this.hoR.getView(), 0);
                ap apVar = new ap("c13656");
                apVar.t("uid", TbadkApplication.getCurrentAccountId());
                apVar.dn("resource_id", this.tabName);
                TiebaStatic.log(apVar);
                return;
            }
            return;
        }
        this.hoS = false;
        this.hnH.removeHeaderView(this.hoR.getView());
    }

    public void onChangeSkinType(int i) {
        if (this.mPullView != null) {
            this.mPullView.changeSkin(i);
        }
        if (this.fsC != null) {
            this.fsC.setTextColor(ao.getColor(R.color.cp_cont_j));
            this.fsC.changeSkin(i);
        }
        if (this.hoV != null) {
            this.hoV.notifyDataSetChanged();
        }
        if (this.dJr != null) {
            ao.setViewTextColor(this.dJr, R.color.cp_cont_b);
        }
        if (this.hoR != null) {
            this.hoR.onChangeSkinType();
        }
        if (this.hoT != null) {
            this.hoT.onChangeSkinType();
        }
        if (this.hoQ != null) {
            this.hoQ.onChangeSkinType(i);
        }
    }

    public void resume() {
        if (this.hoU != null) {
            this.hoU.qZ(true);
            if (this.hnH != null) {
                this.hoU.a(this.hnH.getFirstVisiblePosition(), this.hnH.getLastVisiblePosition(), false, true);
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
        if (this.hnH != null) {
            this.hnH.scrollToPosition(0);
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
        return this.hnH == null || this.hnH.getChildCount() == 0 || this.hnH.getChildAt(0).getTop() == 0;
    }

    private void tW(int i) {
        String string;
        if (i >= 0) {
            this.hoP.cdN();
            if (i > 0) {
                string = String.format(TbadkCoreApplication.getInst().getString(R.string.recommend_frs_refresh_return), Integer.valueOf(i));
            } else {
                string = TbadkCoreApplication.getInst().getString(R.string.recommend_frs_refresh_nodata);
            }
            if (!TextUtils.isEmpty(string) && j.isNetWorkAvailable()) {
                this.hoQ.ejr = string;
                this.hoQ.hKq = 2000L;
                FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
                layoutParams.gravity = 49;
                layoutParams.topMargin = UtilHelper.getStatusBarHeight() + l.getDimens(this.hnG.getPageContext().getPageActivity(), R.dimen.tbds228);
                if (this.hoO != null) {
                    this.hoO.removeView(this.hoQ);
                    this.hoO.addView(this.hoQ, layoutParams);
                    this.hoQ.cdL();
                }
            }
        }
    }

    public void bT(int i, int i2) {
        if (this.hnH != null && i < i2) {
            this.hnH.m(i, i2);
        }
    }
}
