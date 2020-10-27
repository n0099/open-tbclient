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
    private TextView epn;
    private PbListView gdy;
    private BdSwipeRefreshLayout gfT;
    private boolean hasMore;
    private com.baidu.tieba.enterForum.tabfeed.b ijX;
    private EnterForumTabFeedFragment ija;
    private BdTypeRecyclerView ijb;
    private ViewGroup iki;
    private be ikj;
    private SmartBubbleAnimatedView ikk;
    private b ikl;
    private boolean ikm;
    private RecommendForumLayout ikn;
    private i iko;
    private com.baidu.tieba.enterForum.tabfeed.a ikp;
    private g mPullView;
    private String tabName;
    private BdListView.e gxH = new BdListView.e() { // from class: com.baidu.tieba.enterForum.tabfeed.view.a.1
        @Override // com.baidu.adp.widget.ListView.BdListView.e
        public void onScrollToBottom() {
            if (a.this.ijb != null) {
                a.this.ijb.stopScroll();
            }
            if (a.this.gdy != null && a.this.ijX != null) {
                if (j.isNetWorkAvailable()) {
                    a.this.ijb.setNextPage(a.this.gdy);
                    a.this.gdy.showEmptyView(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
                    a.this.gdy.setOnClickListener(null);
                    if (a.this.hasMore) {
                        a.this.gdy.showLoading();
                        a.this.ijX.cqq();
                        return;
                    }
                    a.this.gdy.setText(a.this.ija.getResources().getString(R.string.list_has_no_more));
                    a.this.gdy.endLoadData();
                    return;
                }
                a.this.ijb.setNextPage(null);
            }
        }
    };
    private RecyclerView.OnScrollListener hKT = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.enterForum.tabfeed.view.a.2
        private boolean ikt;

        @Override // android.support.v7.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i) {
            if (i == 0) {
                if (a.this.iko != null) {
                    a.this.iko.a(a.this.ijb.getFirstVisiblePosition(), a.this.ijb.getLastVisiblePosition(), this.ikt, true);
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001630, Boolean.valueOf(a.this.cqE() ? false : true)));
            }
        }

        @Override // android.support.v7.widget.RecyclerView.OnScrollListener
        public void onScrolled(RecyclerView recyclerView, int i, int i2) {
            super.onScrolled(recyclerView, i, i2);
            if (i2 > 0) {
                this.ikt = false;
            } else {
                this.ikt = true;
            }
        }
    };
    private View.OnClickListener ikq = new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.tabfeed.view.a.3
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (a.this.ijb != null) {
                a.this.ijb.stopScroll();
            }
            if (a.this.gdy != null && a.this.ijX != null && j.isNetWorkAvailable()) {
                a.this.gdy.showEmptyView(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
                a.this.gdy.setOnClickListener(null);
                if (a.this.hasMore) {
                    a.this.gdy.showLoading();
                    a.this.ijX.cqq();
                }
            }
        }
    };
    private f aiM = new f<bi>() { // from class: com.baidu.tieba.enterForum.tabfeed.view.a.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tbadk.h.f
        public void a(View view, bi biVar, int i, long j) {
            if (biVar == null) {
                com.baidu.tieba.enterForum.b.d(a.this.ija.getPageContext(), a.this.tabName);
                if (a.this.ikn != null) {
                    aq aqVar = new aq("c13645");
                    aqVar.w("uid", TbadkApplication.getCurrentAccountId());
                    aqVar.aj("obj_locate", 1);
                    aqVar.aj("obj_type", a.this.ikn.aiL ? 5 : 1);
                    aqVar.aj("obj_source", 5);
                    TiebaStatic.log(aqVar);
                }
            } else if (biVar != null && a.this.ija != null) {
                String forumName = biVar.getForumName();
                if (at.isForumName(forumName)) {
                    a.this.ija.sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(a.this.ija.getFragmentActivity()).createNormalCfg(forumName, FrsActivityConfig.FRS_FROM_ENTERFORUM_RECOMMEND).setCallFrom(3)));
                    if (a.this.ikn != null) {
                        aq aqVar2 = new aq("c13643");
                        aqVar2.w("uid", TbadkApplication.getCurrentAccountId());
                        aqVar2.w("fid", biVar.getForumId());
                        if (a.this.ikn.mFrom != 0) {
                            if (a.this.ikn.mFrom == 1) {
                                aqVar2.aj("obj_locate", 2);
                                aqVar2.dR("resource_id", a.this.tabName);
                            }
                        } else {
                            aqVar2.aj("obj_locate", 1);
                            aqVar2.aj("obj_type", a.this.ikn.aiL ? 4 : 1);
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
                aqVar.w("uid", TbadkApplication.getCurrentAccountId());
                aqVar.w("fid", biVar.getForumId());
                if (a.this.ikn.mFrom != 0) {
                    if (a.this.ikn.mFrom == 1) {
                        aqVar.aj("obj_locate", 2);
                        aqVar.dR("resource_id", a.this.tabName);
                    }
                } else {
                    aqVar.aj("obj_locate", 1);
                    aqVar.aj("obj_type", a.this.ikn.aiL ? 3 : 1);
                }
                TiebaStatic.log(aqVar);
            }
        }
    };
    private View.OnClickListener ikr = new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.tabfeed.view.a.5
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            com.baidu.tieba.enterForum.b.d(a.this.ija.getPageContext(), a.this.tabName);
            if (a.this.ikn != null) {
                aq aqVar = new aq("c13645");
                aqVar.w("uid", TbadkApplication.getCurrentAccountId());
                aqVar.aj("obj_locate", 1);
                aqVar.aj("obj_type", a.this.ikn.aiL ? 5 : 1);
                aqVar.aj("obj_source", 2);
                TiebaStatic.log(aqVar);
            }
        }
    };
    private PullLeftRefreshLayout.a alt = new PullLeftRefreshLayout.a() { // from class: com.baidu.tieba.enterForum.tabfeed.view.a.6
        @Override // com.baidu.tbadk.widget.horizontalpullview.PullLeftRefreshLayout.a
        public void bCG() {
            com.baidu.tieba.enterForum.b.d(a.this.ija.getPageContext(), a.this.tabName);
            aq aqVar = new aq("c13645");
            aqVar.w("uid", TbadkApplication.getCurrentAccountId());
            aqVar.aj("obj_locate", 1);
            aqVar.aj("obj_type", a.this.ikn.aiL ? 5 : 1);
            aqVar.aj("obj_source", 4);
            TiebaStatic.log(aqVar);
        }
    };

    public a(EnterForumTabFeedFragment enterForumTabFeedFragment, com.baidu.tieba.enterForum.tabfeed.b bVar, ViewGroup viewGroup, String str) {
        this.ija = enterForumTabFeedFragment;
        this.ijX = bVar;
        this.tabName = str;
        aV(viewGroup);
        this.ikp = new com.baidu.tieba.enterForum.tabfeed.a(enterForumTabFeedFragment, this.ijb);
        kT(false);
    }

    private void aV(ViewGroup viewGroup) {
        this.iki = viewGroup;
        this.ijb = (BdTypeRecyclerView) viewGroup.findViewById(R.id.tab_feed_recycler_view);
        this.ijb.setLayoutManager(new LinearLayoutManager(this.ija.getContext()));
        this.ijb.setFadingEdgeLength(0);
        this.ijb.setOverScrollMode(2);
        this.ijb.setOnSrollToBottomListener(this.gxH);
        this.ijb.addOnScrollListener(this.hKT);
        this.mPullView = new g(this.ija.getPageContext());
        this.mPullView.setListPullRefreshListener(this.ijX);
        this.ijb.setRecyclerListener(new RecyclerView.RecyclerListener() { // from class: com.baidu.tieba.enterForum.tabfeed.view.a.7
            @Override // android.support.v7.widget.RecyclerView.RecyclerListener
            public void onViewRecycled(RecyclerView.ViewHolder viewHolder) {
                View view = viewHolder.itemView;
                if (view != null && a.this.iko != null) {
                    a.this.iko.cV(view);
                }
            }
        });
        this.gdy = new PbListView(this.ija.getPageContext().getPageActivity());
        this.gdy.getView();
        this.gdy.setContainerBackgroundColorResId(R.color.cp_bg_line_e);
        this.gdy.setHeight(l.getDimens(this.ija.getPageContext().getPageActivity(), R.dimen.tbds182));
        this.gdy.setLineGone();
        this.gdy.setTextSize(R.dimen.tbfontsize33);
        this.gdy.setTextColor(ap.getColor(R.color.cp_cont_j));
        this.gdy.setNoMoreTextColorId(R.color.cp_cont_e);
        this.gdy.bpT();
        this.gdy.setOnClickListener(this.ikq);
        if (this.gfT == null) {
            this.gfT = (BdSwipeRefreshLayout) viewGroup.findViewById(R.id.tab_feed_pull_refresh_layout);
            this.gfT.setProgressView(this.mPullView);
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.gfT.getLayoutParams();
            marginLayoutParams.topMargin = UtilHelper.getStatusBarHeight() + l.getDimens(this.ija.getPageContext().getPageActivity(), R.dimen.tbds219);
            this.gfT.setLayoutParams(marginLayoutParams);
        }
        this.ikj = new be();
        this.ikk = new SmartBubbleAnimatedView(this.ija.getContext());
        this.ikk.setLayoutParams(new FrameLayout.LayoutParams(-1, l.getDimens(this.ija.getContext(), R.dimen.tbds83)));
        if (this.iko == null) {
            this.iko = new i(this.ija.getPageContext(), this.ijb);
            this.iko.Hh(1);
            this.iko.setUniqueId(this.ija.getUniqueId());
        }
        this.ikl = new b(this.ija.getPageContext());
        this.ikl.setTabName(this.tabName);
    }

    public void b(com.baidu.tieba.enterForum.tabfeed.b.b bVar) {
        if (bVar != null) {
            this.hasMore = bVar.hasMore;
        }
        kT(false);
        if (bVar != null && this.ikp != null && this.ijb != null && this.gdy != null) {
            cqC();
            d(bVar);
            c(bVar);
            if (bVar.ijT > 0) {
                int firstVisiblePosition = this.ijb.getFirstVisiblePosition();
                View childAt = this.ijb.getChildAt(0);
                int top = childAt == null ? 0 : childAt.getTop();
                RecyclerView.LayoutManager layoutManager = this.ijb.getLayoutManager();
                int i = firstVisiblePosition - bVar.ijT;
                if (layoutManager instanceof LinearLayoutManager) {
                    this.ijb.qR();
                    ((LinearLayoutManager) layoutManager).scrollToPositionWithOffset(i, top);
                    this.ijb.qS();
                }
                bVar.ijT = 0;
            }
            this.ikp.setIsFromCDN(bVar.akk);
            this.ikp.setData(bVar.ijS);
            this.ikp.notifyDataSetChanged();
            if (bVar.fIe) {
                xJ(bVar.refreshCount);
            }
            if (this.iko != null) {
                this.iko.a(this.ijb.getFirstVisiblePosition(), this.ijb.getLastVisiblePosition(), false, true);
            }
        }
    }

    private void cqC() {
        if (this.epn == null) {
            this.epn = new TextView(this.ija.getContext());
            this.epn.setPadding(l.getDimens(this.ija.getContext(), R.dimen.tbds44), l.getDimens(this.ija.getContext(), R.dimen.tbds60), 0, l.getDimens(this.ija.getContext(), R.dimen.tbds24));
            this.epn.setText(R.string.tab_feed_title);
            this.epn.setTextSize(0, l.getDimens(this.ija.getContext(), R.dimen.tbds46));
            this.epn.setTypeface(Typeface.DEFAULT_BOLD);
            this.ijb.removeHeaderView(this.epn);
            this.ijb.addHeaderView(this.epn, 0);
            ap.setViewTextColor(this.epn, R.color.cp_cont_b);
        }
    }

    private void c(com.baidu.tieba.enterForum.tabfeed.b.b bVar) {
        if (bVar != null && this.ijb != null && this.ija != null && bVar.fIe) {
            if (!((bVar.ijR == null || y.isEmpty(bVar.ijR.bjg())) ? false : true)) {
                if (this.ikn != null) {
                    this.ijb.removeHeaderView(this.ikn);
                    return;
                }
                return;
            }
            if (this.ikn == null) {
                this.ikn = new RecommendForumLayout(this.ija.getPageContext());
                this.ikn.setShowMore(true);
                this.ikn.setSquareEntranceAtStart(true);
                this.ikn.setTabName(this.tabName);
                this.ikn.setFrom(1);
            }
            this.ikn.setOnClickRightArrowListener(this.ikr);
            this.ikn.setOnRullOkCallbackr(this.alt);
            this.ikn.setOnItemCoverListener(this.aiM);
            this.ikn.b(bVar.ijR);
            this.ijb.removeHeaderView(this.ikn);
            this.ijb.addHeaderView(this.ikn, 0);
            aq aqVar = new aq("c13641");
            aqVar.w("uid", TbadkApplication.getCurrentAccountId());
            aqVar.aj("obj_locate", 2);
            aqVar.dR("resource_id", this.tabName);
            TiebaStatic.log(aqVar);
        }
    }

    private void d(com.baidu.tieba.enterForum.tabfeed.b.b bVar) {
        if (bVar.ijU != null && bVar.ijU.hot_user != null && bVar.ijU.hot_user.size() > 0 && !TextUtils.isEmpty(bVar.ijU.module_name)) {
            this.ikl.a(bVar.ijU);
            if (this.ikl.getView().getParent() == null && !this.ikm) {
                this.ikm = true;
                this.ijb.addHeaderView(this.ikl.getView(), 0);
                aq aqVar = new aq("c13656");
                aqVar.w("uid", TbadkApplication.getCurrentAccountId());
                aqVar.dR("resource_id", this.tabName);
                TiebaStatic.log(aqVar);
                return;
            }
            return;
        }
        this.ikm = false;
        this.ijb.removeHeaderView(this.ikl.getView());
    }

    public void onChangeSkinType(int i) {
        if (this.mPullView != null) {
            this.mPullView.changeSkin(i);
        }
        if (this.gdy != null) {
            this.gdy.setTextColor(ap.getColor(R.color.cp_cont_j));
            this.gdy.changeSkin(i);
        }
        if (this.ikp != null) {
            this.ikp.notifyDataSetChanged();
        }
        if (this.epn != null) {
            ap.setViewTextColor(this.epn, R.color.cp_cont_b);
        }
        if (this.ikl != null) {
            this.ikl.onChangeSkinType();
        }
        if (this.ikn != null) {
            this.ikn.onChangeSkinType();
        }
        if (this.ikk != null) {
            this.ikk.onChangeSkinType(i);
        }
    }

    public void resume() {
        if (this.iko != null) {
            this.iko.sO(true);
            if (this.ijb != null) {
                this.iko.a(this.ijb.getFirstVisiblePosition(), this.ijb.getLastVisiblePosition(), false, true);
            }
        }
    }

    public void pause() {
        if (this.iko != null) {
            this.iko.cXA();
            this.iko.sO(false);
        }
    }

    public void cqD() {
        if (this.ijb != null) {
            this.ijb.scrollToPosition(0);
        }
    }

    public void kT(boolean z) {
        if (this.gfT != null) {
            this.gfT.setRefreshing(z);
        }
    }

    public void oR(boolean z) {
        if (this.gfT != null) {
            this.gfT.setVisibility(z ? 0 : 8);
        }
    }

    public boolean cqE() {
        return this.ijb == null || this.ijb.getChildCount() == 0 || this.ijb.getChildAt(0).getTop() == 0;
    }

    private void xJ(int i) {
        String string;
        if (i >= 0) {
            this.ikj.cyf();
            if (i > 0) {
                string = String.format(TbadkCoreApplication.getInst().getString(R.string.recommend_frs_refresh_return), Integer.valueOf(i));
            } else {
                string = TbadkCoreApplication.getInst().getString(R.string.recommend_frs_refresh_nodata);
            }
            if (!TextUtils.isEmpty(string) && j.isNetWorkAvailable()) {
                this.ikk.eQa = string;
                this.ikk.iGs = 2000L;
                FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
                layoutParams.gravity = 49;
                layoutParams.topMargin = UtilHelper.getStatusBarHeight() + l.getDimens(this.ija.getPageContext().getPageActivity(), R.dimen.tbds228);
                if (this.iki != null) {
                    this.iki.removeView(this.ikk);
                    this.iki.addView(this.ikk, layoutParams);
                    this.ikk.cyd();
                }
            }
        }
    }

    public void cg(int i, int i2) {
        if (this.ijb != null && i < i2) {
            this.ijb.o(i, i2);
        }
    }
}
