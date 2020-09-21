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
/* loaded from: classes21.dex */
public class a {
    private TextView dUN;
    private PbListView fHm;
    private BdSwipeRefreshLayout fJy;
    private EnterForumTabFeedFragment hHF;
    private BdTypeRecyclerView hHG;
    private com.baidu.tieba.enterForum.tabfeed.b hIC;
    private ViewGroup hIN;
    private be hIO;
    private SmartBubbleAnimatedView hIP;
    private b hIQ;
    private boolean hIR;
    private RecommendForumLayout hIS;
    private i hIT;
    private com.baidu.tieba.enterForum.tabfeed.a hIU;
    private boolean hasMore;
    private g mPullView;
    private String tabName;
    private BdListView.e gbl = new BdListView.e() { // from class: com.baidu.tieba.enterForum.tabfeed.view.a.1
        @Override // com.baidu.adp.widget.ListView.BdListView.e
        public void onScrollToBottom() {
            if (a.this.hHG != null) {
                a.this.hHG.stopScroll();
            }
            if (a.this.fHm != null && a.this.hIC != null) {
                if (j.isNetWorkAvailable()) {
                    a.this.hHG.setNextPage(a.this.fHm);
                    a.this.fHm.showEmptyView(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
                    a.this.fHm.setOnClickListener(null);
                    if (a.this.hasMore) {
                        a.this.fHm.showLoading();
                        a.this.hIC.cjN();
                        return;
                    }
                    a.this.fHm.setText(a.this.hHF.getResources().getString(R.string.list_has_no_more));
                    a.this.fHm.endLoadData();
                    return;
                }
                a.this.hHG.setNextPage(null);
            }
        }
    };
    private RecyclerView.OnScrollListener hjC = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.enterForum.tabfeed.view.a.2
        private boolean hIY;

        @Override // android.support.v7.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i) {
            if (i == 0) {
                if (a.this.hIT != null) {
                    a.this.hIT.a(a.this.hHG.getFirstVisiblePosition(), a.this.hHG.getLastVisiblePosition(), this.hIY, true);
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001630, Boolean.valueOf(a.this.ckb() ? false : true)));
            }
        }

        @Override // android.support.v7.widget.RecyclerView.OnScrollListener
        public void onScrolled(RecyclerView recyclerView, int i, int i2) {
            super.onScrolled(recyclerView, i, i2);
            if (i2 > 0) {
                this.hIY = false;
            } else {
                this.hIY = true;
            }
        }
    };
    private View.OnClickListener hIV = new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.tabfeed.view.a.3
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (a.this.hHG != null) {
                a.this.hHG.stopScroll();
            }
            if (a.this.fHm != null && a.this.hIC != null && j.isNetWorkAvailable()) {
                a.this.fHm.showEmptyView(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
                a.this.fHm.setOnClickListener(null);
                if (a.this.hasMore) {
                    a.this.fHm.showLoading();
                    a.this.hIC.cjN();
                }
            }
        }
    };
    private f ait = new f<bi>() { // from class: com.baidu.tieba.enterForum.tabfeed.view.a.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tbadk.h.f
        public void a(View view, bi biVar, int i, long j) {
            if (biVar == null) {
                com.baidu.tieba.enterForum.b.d(a.this.hHF.getPageContext(), a.this.tabName);
                if (a.this.hIS != null) {
                    aq aqVar = new aq("c13645");
                    aqVar.u("uid", TbadkApplication.getCurrentAccountId());
                    aqVar.ai("obj_locate", 1);
                    aqVar.ai("obj_type", a.this.hIS.ais ? 5 : 1);
                    aqVar.ai("obj_source", 5);
                    TiebaStatic.log(aqVar);
                }
            } else if (biVar != null && a.this.hHF != null) {
                String forumName = biVar.getForumName();
                if (at.isForumName(forumName)) {
                    a.this.hHF.sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(a.this.hHF.getFragmentActivity()).createNormalCfg(forumName, FrsActivityConfig.FRS_FROM_ENTERFORUM_RECOMMEND).setCallFrom(3)));
                    if (a.this.hIS != null) {
                        aq aqVar2 = new aq("c13643");
                        aqVar2.u("uid", TbadkApplication.getCurrentAccountId());
                        aqVar2.u("fid", biVar.getForumId());
                        if (a.this.hIS.mFrom != 0) {
                            if (a.this.hIS.mFrom == 1) {
                                aqVar2.ai("obj_locate", 2);
                                aqVar2.dF("resource_id", a.this.tabName);
                            }
                        } else {
                            aqVar2.ai("obj_locate", 1);
                            aqVar2.ai("obj_type", a.this.hIS.ais ? 4 : 1);
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
                if (a.this.hIS.mFrom != 0) {
                    if (a.this.hIS.mFrom == 1) {
                        aqVar.ai("obj_locate", 2);
                        aqVar.dF("resource_id", a.this.tabName);
                    }
                } else {
                    aqVar.ai("obj_locate", 1);
                    aqVar.ai("obj_type", a.this.hIS.ais ? 3 : 1);
                }
                TiebaStatic.log(aqVar);
            }
        }
    };
    private View.OnClickListener hIW = new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.tabfeed.view.a.5
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            com.baidu.tieba.enterForum.b.d(a.this.hHF.getPageContext(), a.this.tabName);
            if (a.this.hIS != null) {
                aq aqVar = new aq("c13645");
                aqVar.u("uid", TbadkApplication.getCurrentAccountId());
                aqVar.ai("obj_locate", 1);
                aqVar.ai("obj_type", a.this.hIS.ais ? 5 : 1);
                aqVar.ai("obj_source", 2);
                TiebaStatic.log(aqVar);
            }
        }
    };
    private PullLeftRefreshLayout.a akZ = new PullLeftRefreshLayout.a() { // from class: com.baidu.tieba.enterForum.tabfeed.view.a.6
        @Override // com.baidu.tbadk.widget.horizontalpullview.PullLeftRefreshLayout.a
        public void byd() {
            com.baidu.tieba.enterForum.b.d(a.this.hHF.getPageContext(), a.this.tabName);
            aq aqVar = new aq("c13645");
            aqVar.u("uid", TbadkApplication.getCurrentAccountId());
            aqVar.ai("obj_locate", 1);
            aqVar.ai("obj_type", a.this.hIS.ais ? 5 : 1);
            aqVar.ai("obj_source", 4);
            TiebaStatic.log(aqVar);
        }
    };

    public a(EnterForumTabFeedFragment enterForumTabFeedFragment, com.baidu.tieba.enterForum.tabfeed.b bVar, ViewGroup viewGroup, String str) {
        this.hHF = enterForumTabFeedFragment;
        this.hIC = bVar;
        this.tabName = str;
        aT(viewGroup);
        this.hIU = new com.baidu.tieba.enterForum.tabfeed.a(enterForumTabFeedFragment, this.hHG);
        ki(false);
    }

    private void aT(ViewGroup viewGroup) {
        this.hIN = viewGroup;
        this.hHG = (BdTypeRecyclerView) viewGroup.findViewById(R.id.tab_feed_recycler_view);
        this.hHG.setLayoutManager(new LinearLayoutManager(this.hHF.getContext()));
        this.hHG.setFadingEdgeLength(0);
        this.hHG.setOverScrollMode(2);
        this.hHG.setOnSrollToBottomListener(this.gbl);
        this.hHG.addOnScrollListener(this.hjC);
        this.mPullView = new g(this.hHF.getPageContext());
        this.mPullView.setListPullRefreshListener(this.hIC);
        this.hHG.setRecyclerListener(new RecyclerView.RecyclerListener() { // from class: com.baidu.tieba.enterForum.tabfeed.view.a.7
            @Override // android.support.v7.widget.RecyclerView.RecyclerListener
            public void onViewRecycled(RecyclerView.ViewHolder viewHolder) {
                View view = viewHolder.itemView;
                if (view != null && a.this.hIT != null) {
                    a.this.hIT.cN(view);
                }
            }
        });
        this.fHm = new PbListView(this.hHF.getPageContext().getPageActivity());
        this.fHm.getView();
        this.fHm.setContainerBackgroundColorResId(R.color.cp_bg_line_e);
        this.fHm.setHeight(l.getDimens(this.hHF.getPageContext().getPageActivity(), R.dimen.tbds182));
        this.fHm.setLineGone();
        this.fHm.setTextSize(R.dimen.tbfontsize33);
        this.fHm.setTextColor(ap.getColor(R.color.cp_cont_j));
        this.fHm.setNoMoreTextColorId(R.color.cp_cont_e);
        this.fHm.blq();
        this.fHm.setOnClickListener(this.hIV);
        if (this.fJy == null) {
            this.fJy = (BdSwipeRefreshLayout) viewGroup.findViewById(R.id.tab_feed_pull_refresh_layout);
            this.fJy.setProgressView(this.mPullView);
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.fJy.getLayoutParams();
            marginLayoutParams.topMargin = UtilHelper.getStatusBarHeight() + l.getDimens(this.hHF.getPageContext().getPageActivity(), R.dimen.tbds219);
            this.fJy.setLayoutParams(marginLayoutParams);
        }
        this.hIO = new be();
        this.hIP = new SmartBubbleAnimatedView(this.hHF.getContext());
        this.hIP.setLayoutParams(new FrameLayout.LayoutParams(-1, l.getDimens(this.hHF.getContext(), R.dimen.tbds83)));
        if (this.hIT == null) {
            this.hIT = new i(this.hHF.getPageContext(), this.hHG);
            this.hIT.Gi(1);
            this.hIT.setUniqueId(this.hHF.getUniqueId());
        }
        this.hIQ = new b(this.hHF.getPageContext());
        this.hIQ.setTabName(this.tabName);
    }

    public void b(com.baidu.tieba.enterForum.tabfeed.b.b bVar) {
        if (bVar != null) {
            this.hasMore = bVar.hasMore;
        }
        ki(false);
        if (bVar != null && this.hIU != null && this.hHG != null && this.fHm != null) {
            cjZ();
            d(bVar);
            c(bVar);
            if (bVar.hIy > 0) {
                int firstVisiblePosition = this.hHG.getFirstVisiblePosition();
                View childAt = this.hHG.getChildAt(0);
                int top = childAt == null ? 0 : childAt.getTop();
                RecyclerView.LayoutManager layoutManager = this.hHG.getLayoutManager();
                int i = firstVisiblePosition - bVar.hIy;
                if (layoutManager instanceof LinearLayoutManager) {
                    this.hHG.qR();
                    ((LinearLayoutManager) layoutManager).scrollToPositionWithOffset(i, top);
                    this.hHG.qS();
                }
                bVar.hIy = 0;
            }
            this.hIU.setIsFromCDN(bVar.ajR);
            this.hIU.setData(bVar.hIx);
            this.hIU.notifyDataSetChanged();
            if (bVar.fnv) {
                wK(bVar.refreshCount);
            }
            if (this.hIT != null) {
                this.hIT.a(this.hHG.getFirstVisiblePosition(), this.hHG.getLastVisiblePosition(), false, true);
            }
        }
    }

    private void cjZ() {
        if (this.dUN == null) {
            this.dUN = new TextView(this.hHF.getContext());
            this.dUN.setPadding(l.getDimens(this.hHF.getContext(), R.dimen.tbds44), l.getDimens(this.hHF.getContext(), R.dimen.tbds60), 0, l.getDimens(this.hHF.getContext(), R.dimen.tbds24));
            this.dUN.setText(R.string.tab_feed_title);
            this.dUN.setTextSize(0, l.getDimens(this.hHF.getContext(), R.dimen.tbds46));
            this.dUN.setTypeface(Typeface.DEFAULT_BOLD);
            this.hHG.removeHeaderView(this.dUN);
            this.hHG.addHeaderView(this.dUN, 0);
            ap.setViewTextColor(this.dUN, R.color.cp_cont_b);
        }
    }

    private void c(com.baidu.tieba.enterForum.tabfeed.b.b bVar) {
        if (bVar != null && this.hHG != null && this.hHF != null && bVar.fnv) {
            if (!((bVar.hIw == null || y.isEmpty(bVar.hIw.beE())) ? false : true)) {
                if (this.hIS != null) {
                    this.hHG.removeHeaderView(this.hIS);
                    return;
                }
                return;
            }
            if (this.hIS == null) {
                this.hIS = new RecommendForumLayout(this.hHF.getPageContext());
                this.hIS.setShowMore(true);
                this.hIS.setSquareEntranceAtStart(true);
                this.hIS.setTabName(this.tabName);
                this.hIS.setFrom(1);
            }
            this.hIS.setOnClickRightArrowListener(this.hIW);
            this.hIS.setOnRullOkCallbackr(this.akZ);
            this.hIS.setOnItemCoverListener(this.ait);
            this.hIS.b(bVar.hIw);
            this.hHG.removeHeaderView(this.hIS);
            this.hHG.addHeaderView(this.hIS, 0);
            aq aqVar = new aq("c13641");
            aqVar.u("uid", TbadkApplication.getCurrentAccountId());
            aqVar.ai("obj_locate", 2);
            aqVar.dF("resource_id", this.tabName);
            TiebaStatic.log(aqVar);
        }
    }

    private void d(com.baidu.tieba.enterForum.tabfeed.b.b bVar) {
        if (bVar.hIz != null && bVar.hIz.hot_user != null && bVar.hIz.hot_user.size() > 0 && !TextUtils.isEmpty(bVar.hIz.module_name)) {
            this.hIQ.a(bVar.hIz);
            if (this.hIQ.getView().getParent() == null && !this.hIR) {
                this.hIR = true;
                this.hHG.addHeaderView(this.hIQ.getView(), 0);
                aq aqVar = new aq("c13656");
                aqVar.u("uid", TbadkApplication.getCurrentAccountId());
                aqVar.dF("resource_id", this.tabName);
                TiebaStatic.log(aqVar);
                return;
            }
            return;
        }
        this.hIR = false;
        this.hHG.removeHeaderView(this.hIQ.getView());
    }

    public void onChangeSkinType(int i) {
        if (this.mPullView != null) {
            this.mPullView.changeSkin(i);
        }
        if (this.fHm != null) {
            this.fHm.setTextColor(ap.getColor(R.color.cp_cont_j));
            this.fHm.changeSkin(i);
        }
        if (this.hIU != null) {
            this.hIU.notifyDataSetChanged();
        }
        if (this.dUN != null) {
            ap.setViewTextColor(this.dUN, R.color.cp_cont_b);
        }
        if (this.hIQ != null) {
            this.hIQ.onChangeSkinType();
        }
        if (this.hIS != null) {
            this.hIS.onChangeSkinType();
        }
        if (this.hIP != null) {
            this.hIP.onChangeSkinType(i);
        }
    }

    public void resume() {
        if (this.hIT != null) {
            this.hIT.rP(true);
            if (this.hHG != null) {
                this.hIT.a(this.hHG.getFirstVisiblePosition(), this.hHG.getLastVisiblePosition(), false, true);
            }
        }
    }

    public void pause() {
        if (this.hIT != null) {
            this.hIT.cQJ();
            this.hIT.rP(false);
        }
    }

    public void cka() {
        if (this.hHG != null) {
            this.hHG.scrollToPosition(0);
        }
    }

    public void ki(boolean z) {
        if (this.fJy != null) {
            this.fJy.setRefreshing(z);
        }
    }

    public void nU(boolean z) {
        if (this.fJy != null) {
            this.fJy.setVisibility(z ? 0 : 8);
        }
    }

    public boolean ckb() {
        return this.hHG == null || this.hHG.getChildCount() == 0 || this.hHG.getChildAt(0).getTop() == 0;
    }

    private void wK(int i) {
        String string;
        if (i >= 0) {
            this.hIO.crA();
            if (i > 0) {
                string = String.format(TbadkCoreApplication.getInst().getString(R.string.recommend_frs_refresh_return), Integer.valueOf(i));
            } else {
                string = TbadkCoreApplication.getInst().getString(R.string.recommend_frs_refresh_nodata);
            }
            if (!TextUtils.isEmpty(string) && j.isNetWorkAvailable()) {
                this.hIP.evu = string;
                this.hIP.ieZ = 2000L;
                FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
                layoutParams.gravity = 49;
                layoutParams.topMargin = UtilHelper.getStatusBarHeight() + l.getDimens(this.hHF.getPageContext().getPageActivity(), R.dimen.tbds228);
                if (this.hIN != null) {
                    this.hIN.removeView(this.hIP);
                    this.hIN.addView(this.hIP, layoutParams);
                    this.hIP.cry();
                }
            }
        }
    }

    public void ce(int i, int i2) {
        if (this.hHG != null && i < i2) {
            this.hHG.o(i, i2);
        }
    }
}
