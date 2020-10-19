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
/* loaded from: classes22.dex */
public class a {
    private TextView egP;
    private PbListView fTv;
    private BdSwipeRefreshLayout fVP;
    private EnterForumTabFeedFragment hWA;
    private BdTypeRecyclerView hWB;
    private ViewGroup hXI;
    private be hXJ;
    private SmartBubbleAnimatedView hXK;
    private b hXL;
    private boolean hXM;
    private RecommendForumLayout hXN;
    private i hXO;
    private com.baidu.tieba.enterForum.tabfeed.a hXP;
    private com.baidu.tieba.enterForum.tabfeed.b hXx;
    private boolean hasMore;
    private g mPullView;
    private String tabName;
    private BdListView.e gnC = new BdListView.e() { // from class: com.baidu.tieba.enterForum.tabfeed.view.a.1
        @Override // com.baidu.adp.widget.ListView.BdListView.e
        public void onScrollToBottom() {
            if (a.this.hWB != null) {
                a.this.hWB.stopScroll();
            }
            if (a.this.fTv != null && a.this.hXx != null) {
                if (j.isNetWorkAvailable()) {
                    a.this.hWB.setNextPage(a.this.fTv);
                    a.this.fTv.showEmptyView(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
                    a.this.fTv.setOnClickListener(null);
                    if (a.this.hasMore) {
                        a.this.fTv.showLoading();
                        a.this.hXx.cnj();
                        return;
                    }
                    a.this.fTv.setText(a.this.hWA.getResources().getString(R.string.list_has_no_more));
                    a.this.fTv.endLoadData();
                    return;
                }
                a.this.hWB.setNextPage(null);
            }
        }
    };
    private RecyclerView.OnScrollListener hyx = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.enterForum.tabfeed.view.a.2
        private boolean hXT;

        @Override // android.support.v7.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i) {
            if (i == 0) {
                if (a.this.hXO != null) {
                    a.this.hXO.a(a.this.hWB.getFirstVisiblePosition(), a.this.hWB.getLastVisiblePosition(), this.hXT, true);
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001630, Boolean.valueOf(a.this.cnx() ? false : true)));
            }
        }

        @Override // android.support.v7.widget.RecyclerView.OnScrollListener
        public void onScrolled(RecyclerView recyclerView, int i, int i2) {
            super.onScrolled(recyclerView, i, i2);
            if (i2 > 0) {
                this.hXT = false;
            } else {
                this.hXT = true;
            }
        }
    };
    private View.OnClickListener hXQ = new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.tabfeed.view.a.3
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (a.this.hWB != null) {
                a.this.hWB.stopScroll();
            }
            if (a.this.fTv != null && a.this.hXx != null && j.isNetWorkAvailable()) {
                a.this.fTv.showEmptyView(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
                a.this.fTv.setOnClickListener(null);
                if (a.this.hasMore) {
                    a.this.fTv.showLoading();
                    a.this.hXx.cnj();
                }
            }
        }
    };
    private f aiL = new f<bi>() { // from class: com.baidu.tieba.enterForum.tabfeed.view.a.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tbadk.h.f
        public void a(View view, bi biVar, int i, long j) {
            if (biVar == null) {
                com.baidu.tieba.enterForum.b.d(a.this.hWA.getPageContext(), a.this.tabName);
                if (a.this.hXN != null) {
                    aq aqVar = new aq("c13645");
                    aqVar.u("uid", TbadkApplication.getCurrentAccountId());
                    aqVar.aj("obj_locate", 1);
                    aqVar.aj("obj_type", a.this.hXN.aiK ? 5 : 1);
                    aqVar.aj("obj_source", 5);
                    TiebaStatic.log(aqVar);
                }
            } else if (biVar != null && a.this.hWA != null) {
                String forumName = biVar.getForumName();
                if (at.isForumName(forumName)) {
                    a.this.hWA.sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(a.this.hWA.getFragmentActivity()).createNormalCfg(forumName, FrsActivityConfig.FRS_FROM_ENTERFORUM_RECOMMEND).setCallFrom(3)));
                    if (a.this.hXN != null) {
                        aq aqVar2 = new aq("c13643");
                        aqVar2.u("uid", TbadkApplication.getCurrentAccountId());
                        aqVar2.u("fid", biVar.getForumId());
                        if (a.this.hXN.mFrom != 0) {
                            if (a.this.hXN.mFrom == 1) {
                                aqVar2.aj("obj_locate", 2);
                                aqVar2.dK("resource_id", a.this.tabName);
                            }
                        } else {
                            aqVar2.aj("obj_locate", 1);
                            aqVar2.aj("obj_type", a.this.hXN.aiK ? 4 : 1);
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
                if (a.this.hXN.mFrom != 0) {
                    if (a.this.hXN.mFrom == 1) {
                        aqVar.aj("obj_locate", 2);
                        aqVar.dK("resource_id", a.this.tabName);
                    }
                } else {
                    aqVar.aj("obj_locate", 1);
                    aqVar.aj("obj_type", a.this.hXN.aiK ? 3 : 1);
                }
                TiebaStatic.log(aqVar);
            }
        }
    };
    private View.OnClickListener hXR = new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.tabfeed.view.a.5
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            com.baidu.tieba.enterForum.b.d(a.this.hWA.getPageContext(), a.this.tabName);
            if (a.this.hXN != null) {
                aq aqVar = new aq("c13645");
                aqVar.u("uid", TbadkApplication.getCurrentAccountId());
                aqVar.aj("obj_locate", 1);
                aqVar.aj("obj_type", a.this.hXN.aiK ? 5 : 1);
                aqVar.aj("obj_source", 2);
                TiebaStatic.log(aqVar);
            }
        }
    };
    private PullLeftRefreshLayout.a als = new PullLeftRefreshLayout.a() { // from class: com.baidu.tieba.enterForum.tabfeed.view.a.6
        @Override // com.baidu.tbadk.widget.horizontalpullview.PullLeftRefreshLayout.a
        public void bAN() {
            com.baidu.tieba.enterForum.b.d(a.this.hWA.getPageContext(), a.this.tabName);
            aq aqVar = new aq("c13645");
            aqVar.u("uid", TbadkApplication.getCurrentAccountId());
            aqVar.aj("obj_locate", 1);
            aqVar.aj("obj_type", a.this.hXN.aiK ? 5 : 1);
            aqVar.aj("obj_source", 4);
            TiebaStatic.log(aqVar);
        }
    };

    public a(EnterForumTabFeedFragment enterForumTabFeedFragment, com.baidu.tieba.enterForum.tabfeed.b bVar, ViewGroup viewGroup, String str) {
        this.hWA = enterForumTabFeedFragment;
        this.hXx = bVar;
        this.tabName = str;
        aV(viewGroup);
        this.hXP = new com.baidu.tieba.enterForum.tabfeed.a(enterForumTabFeedFragment, this.hWB);
        kG(false);
    }

    private void aV(ViewGroup viewGroup) {
        this.hXI = viewGroup;
        this.hWB = (BdTypeRecyclerView) viewGroup.findViewById(R.id.tab_feed_recycler_view);
        this.hWB.setLayoutManager(new LinearLayoutManager(this.hWA.getContext()));
        this.hWB.setFadingEdgeLength(0);
        this.hWB.setOverScrollMode(2);
        this.hWB.setOnSrollToBottomListener(this.gnC);
        this.hWB.addOnScrollListener(this.hyx);
        this.mPullView = new g(this.hWA.getPageContext());
        this.mPullView.setListPullRefreshListener(this.hXx);
        this.hWB.setRecyclerListener(new RecyclerView.RecyclerListener() { // from class: com.baidu.tieba.enterForum.tabfeed.view.a.7
            @Override // android.support.v7.widget.RecyclerView.RecyclerListener
            public void onViewRecycled(RecyclerView.ViewHolder viewHolder) {
                View view = viewHolder.itemView;
                if (view != null && a.this.hXO != null) {
                    a.this.hXO.cR(view);
                }
            }
        });
        this.fTv = new PbListView(this.hWA.getPageContext().getPageActivity());
        this.fTv.getView();
        this.fTv.setContainerBackgroundColorResId(R.color.cp_bg_line_e);
        this.fTv.setHeight(l.getDimens(this.hWA.getPageContext().getPageActivity(), R.dimen.tbds182));
        this.fTv.setLineGone();
        this.fTv.setTextSize(R.dimen.tbfontsize33);
        this.fTv.setTextColor(ap.getColor(R.color.cp_cont_j));
        this.fTv.setNoMoreTextColorId(R.color.cp_cont_e);
        this.fTv.boa();
        this.fTv.setOnClickListener(this.hXQ);
        if (this.fVP == null) {
            this.fVP = (BdSwipeRefreshLayout) viewGroup.findViewById(R.id.tab_feed_pull_refresh_layout);
            this.fVP.setProgressView(this.mPullView);
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.fVP.getLayoutParams();
            marginLayoutParams.topMargin = UtilHelper.getStatusBarHeight() + l.getDimens(this.hWA.getPageContext().getPageActivity(), R.dimen.tbds219);
            this.fVP.setLayoutParams(marginLayoutParams);
        }
        this.hXJ = new be();
        this.hXK = new SmartBubbleAnimatedView(this.hWA.getContext());
        this.hXK.setLayoutParams(new FrameLayout.LayoutParams(-1, l.getDimens(this.hWA.getContext(), R.dimen.tbds83)));
        if (this.hXO == null) {
            this.hXO = new i(this.hWA.getPageContext(), this.hWB);
            this.hXO.GO(1);
            this.hXO.setUniqueId(this.hWA.getUniqueId());
        }
        this.hXL = new b(this.hWA.getPageContext());
        this.hXL.setTabName(this.tabName);
    }

    public void b(com.baidu.tieba.enterForum.tabfeed.b.b bVar) {
        if (bVar != null) {
            this.hasMore = bVar.hasMore;
        }
        kG(false);
        if (bVar != null && this.hXP != null && this.hWB != null && this.fTv != null) {
            cnv();
            d(bVar);
            c(bVar);
            if (bVar.hXt > 0) {
                int firstVisiblePosition = this.hWB.getFirstVisiblePosition();
                View childAt = this.hWB.getChildAt(0);
                int top = childAt == null ? 0 : childAt.getTop();
                RecyclerView.LayoutManager layoutManager = this.hWB.getLayoutManager();
                int i = firstVisiblePosition - bVar.hXt;
                if (layoutManager instanceof LinearLayoutManager) {
                    this.hWB.qR();
                    ((LinearLayoutManager) layoutManager).scrollToPositionWithOffset(i, top);
                    this.hWB.qS();
                }
                bVar.hXt = 0;
            }
            this.hXP.setIsFromCDN(bVar.akj);
            this.hXP.setData(bVar.hXs);
            this.hXP.notifyDataSetChanged();
            if (bVar.fzJ) {
                xq(bVar.refreshCount);
            }
            if (this.hXO != null) {
                this.hXO.a(this.hWB.getFirstVisiblePosition(), this.hWB.getLastVisiblePosition(), false, true);
            }
        }
    }

    private void cnv() {
        if (this.egP == null) {
            this.egP = new TextView(this.hWA.getContext());
            this.egP.setPadding(l.getDimens(this.hWA.getContext(), R.dimen.tbds44), l.getDimens(this.hWA.getContext(), R.dimen.tbds60), 0, l.getDimens(this.hWA.getContext(), R.dimen.tbds24));
            this.egP.setText(R.string.tab_feed_title);
            this.egP.setTextSize(0, l.getDimens(this.hWA.getContext(), R.dimen.tbds46));
            this.egP.setTypeface(Typeface.DEFAULT_BOLD);
            this.hWB.removeHeaderView(this.egP);
            this.hWB.addHeaderView(this.egP, 0);
            ap.setViewTextColor(this.egP, R.color.cp_cont_b);
        }
    }

    private void c(com.baidu.tieba.enterForum.tabfeed.b.b bVar) {
        if (bVar != null && this.hWB != null && this.hWA != null && bVar.fzJ) {
            if (!((bVar.hXr == null || y.isEmpty(bVar.hXr.bhn())) ? false : true)) {
                if (this.hXN != null) {
                    this.hWB.removeHeaderView(this.hXN);
                    return;
                }
                return;
            }
            if (this.hXN == null) {
                this.hXN = new RecommendForumLayout(this.hWA.getPageContext());
                this.hXN.setShowMore(true);
                this.hXN.setSquareEntranceAtStart(true);
                this.hXN.setTabName(this.tabName);
                this.hXN.setFrom(1);
            }
            this.hXN.setOnClickRightArrowListener(this.hXR);
            this.hXN.setOnRullOkCallbackr(this.als);
            this.hXN.setOnItemCoverListener(this.aiL);
            this.hXN.b(bVar.hXr);
            this.hWB.removeHeaderView(this.hXN);
            this.hWB.addHeaderView(this.hXN, 0);
            aq aqVar = new aq("c13641");
            aqVar.u("uid", TbadkApplication.getCurrentAccountId());
            aqVar.aj("obj_locate", 2);
            aqVar.dK("resource_id", this.tabName);
            TiebaStatic.log(aqVar);
        }
    }

    private void d(com.baidu.tieba.enterForum.tabfeed.b.b bVar) {
        if (bVar.hXu != null && bVar.hXu.hot_user != null && bVar.hXu.hot_user.size() > 0 && !TextUtils.isEmpty(bVar.hXu.module_name)) {
            this.hXL.a(bVar.hXu);
            if (this.hXL.getView().getParent() == null && !this.hXM) {
                this.hXM = true;
                this.hWB.addHeaderView(this.hXL.getView(), 0);
                aq aqVar = new aq("c13656");
                aqVar.u("uid", TbadkApplication.getCurrentAccountId());
                aqVar.dK("resource_id", this.tabName);
                TiebaStatic.log(aqVar);
                return;
            }
            return;
        }
        this.hXM = false;
        this.hWB.removeHeaderView(this.hXL.getView());
    }

    public void onChangeSkinType(int i) {
        if (this.mPullView != null) {
            this.mPullView.changeSkin(i);
        }
        if (this.fTv != null) {
            this.fTv.setTextColor(ap.getColor(R.color.cp_cont_j));
            this.fTv.changeSkin(i);
        }
        if (this.hXP != null) {
            this.hXP.notifyDataSetChanged();
        }
        if (this.egP != null) {
            ap.setViewTextColor(this.egP, R.color.cp_cont_b);
        }
        if (this.hXL != null) {
            this.hXL.onChangeSkinType();
        }
        if (this.hXN != null) {
            this.hXN.onChangeSkinType();
        }
        if (this.hXK != null) {
            this.hXK.onChangeSkinType(i);
        }
    }

    public void resume() {
        if (this.hXO != null) {
            this.hXO.sw(true);
            if (this.hWB != null) {
                this.hXO.a(this.hWB.getFirstVisiblePosition(), this.hWB.getLastVisiblePosition(), false, true);
            }
        }
    }

    public void pause() {
        if (this.hXO != null) {
            this.hXO.cUt();
            this.hXO.sw(false);
        }
    }

    public void cnw() {
        if (this.hWB != null) {
            this.hWB.scrollToPosition(0);
        }
    }

    public void kG(boolean z) {
        if (this.fVP != null) {
            this.fVP.setRefreshing(z);
        }
    }

    public void oz(boolean z) {
        if (this.fVP != null) {
            this.fVP.setVisibility(z ? 0 : 8);
        }
    }

    public boolean cnx() {
        return this.hWB == null || this.hWB.getChildCount() == 0 || this.hWB.getChildAt(0).getTop() == 0;
    }

    private void xq(int i) {
        String string;
        if (i >= 0) {
            this.hXJ.cuY();
            if (i > 0) {
                string = String.format(TbadkCoreApplication.getInst().getString(R.string.recommend_frs_refresh_return), Integer.valueOf(i));
            } else {
                string = TbadkCoreApplication.getInst().getString(R.string.recommend_frs_refresh_nodata);
            }
            if (!TextUtils.isEmpty(string) && j.isNetWorkAvailable()) {
                this.hXK.eHE = string;
                this.hXK.itW = 2000L;
                FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
                layoutParams.gravity = 49;
                layoutParams.topMargin = UtilHelper.getStatusBarHeight() + l.getDimens(this.hWA.getPageContext().getPageActivity(), R.dimen.tbds228);
                if (this.hXI != null) {
                    this.hXI.removeView(this.hXK);
                    this.hXI.addView(this.hXK, layoutParams);
                    this.hXK.cuW();
                }
            }
        }
    }

    public void ce(int i, int i2) {
        if (this.hWB != null && i < i2) {
            this.hWB.o(i, i2);
        }
    }
}
