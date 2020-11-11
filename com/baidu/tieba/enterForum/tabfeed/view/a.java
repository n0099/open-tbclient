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
    private TextView evg;
    private PbListView gjo;
    private BdSwipeRefreshLayout glI;
    private boolean hasMore;
    private EnterForumTabFeedFragment ioZ;
    private com.baidu.tieba.enterForum.tabfeed.b ipW;
    private BdTypeRecyclerView ipa;
    private ViewGroup iqh;
    private be iqi;
    private SmartBubbleAnimatedView iqj;
    private b iqk;
    private boolean iql;
    private RecommendForumLayout iqm;
    private i iqn;
    private com.baidu.tieba.enterForum.tabfeed.a iqo;
    private g mPullView;
    private String tabName;
    private BdListView.e gDv = new BdListView.e() { // from class: com.baidu.tieba.enterForum.tabfeed.view.a.1
        @Override // com.baidu.adp.widget.ListView.BdListView.e
        public void onScrollToBottom() {
            if (a.this.ipa != null) {
                a.this.ipa.stopScroll();
            }
            if (a.this.gjo != null && a.this.ipW != null) {
                if (j.isNetWorkAvailable()) {
                    a.this.ipa.setNextPage(a.this.gjo);
                    a.this.gjo.showEmptyView(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
                    a.this.gjo.setOnClickListener(null);
                    if (a.this.hasMore) {
                        a.this.gjo.showLoading();
                        a.this.ipW.csR();
                        return;
                    }
                    a.this.gjo.setText(a.this.ioZ.getResources().getString(R.string.list_has_no_more));
                    a.this.gjo.endLoadData();
                    return;
                }
                a.this.ipa.setNextPage(null);
            }
        }
    };
    private RecyclerView.OnScrollListener hQQ = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.enterForum.tabfeed.view.a.2
        private boolean iqs;

        @Override // android.support.v7.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i) {
            if (i == 0) {
                if (a.this.iqn != null) {
                    a.this.iqn.a(a.this.ipa.getFirstVisiblePosition(), a.this.ipa.getLastVisiblePosition(), this.iqs, true);
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001630, Boolean.valueOf(a.this.ctf() ? false : true)));
            }
        }

        @Override // android.support.v7.widget.RecyclerView.OnScrollListener
        public void onScrolled(RecyclerView recyclerView, int i, int i2) {
            super.onScrolled(recyclerView, i, i2);
            if (i2 > 0) {
                this.iqs = false;
            } else {
                this.iqs = true;
            }
        }
    };
    private View.OnClickListener iqp = new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.tabfeed.view.a.3
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (a.this.ipa != null) {
                a.this.ipa.stopScroll();
            }
            if (a.this.gjo != null && a.this.ipW != null && j.isNetWorkAvailable()) {
                a.this.gjo.showEmptyView(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
                a.this.gjo.setOnClickListener(null);
                if (a.this.hasMore) {
                    a.this.gjo.showLoading();
                    a.this.ipW.csR();
                }
            }
        }
    };
    private f aiM = new f<bi>() { // from class: com.baidu.tieba.enterForum.tabfeed.view.a.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tbadk.h.f
        public void a(View view, bi biVar, int i, long j) {
            if (biVar == null) {
                com.baidu.tieba.enterForum.b.d(a.this.ioZ.getPageContext(), a.this.tabName);
                if (a.this.iqm != null) {
                    aq aqVar = new aq("c13645");
                    aqVar.w("uid", TbadkApplication.getCurrentAccountId());
                    aqVar.al("obj_locate", 1);
                    aqVar.al("obj_type", a.this.iqm.aiL ? 5 : 1);
                    aqVar.al("obj_source", 5);
                    TiebaStatic.log(aqVar);
                }
            } else if (biVar != null && a.this.ioZ != null) {
                String forumName = biVar.getForumName();
                if (at.isForumName(forumName)) {
                    a.this.ioZ.sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(a.this.ioZ.getFragmentActivity()).createNormalCfg(forumName, FrsActivityConfig.FRS_FROM_ENTERFORUM_RECOMMEND).setCallFrom(3)));
                    if (a.this.iqm != null) {
                        aq aqVar2 = new aq("c13643");
                        aqVar2.w("uid", TbadkApplication.getCurrentAccountId());
                        aqVar2.w("fid", biVar.getForumId());
                        if (a.this.iqm.mFrom != 0) {
                            if (a.this.iqm.mFrom == 1) {
                                aqVar2.al("obj_locate", 2);
                                aqVar2.dR("resource_id", a.this.tabName);
                            }
                        } else {
                            aqVar2.al("obj_locate", 1);
                            aqVar2.al("obj_type", a.this.iqm.aiL ? 4 : 1);
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
                if (a.this.iqm.mFrom != 0) {
                    if (a.this.iqm.mFrom == 1) {
                        aqVar.al("obj_locate", 2);
                        aqVar.dR("resource_id", a.this.tabName);
                    }
                } else {
                    aqVar.al("obj_locate", 1);
                    aqVar.al("obj_type", a.this.iqm.aiL ? 3 : 1);
                }
                TiebaStatic.log(aqVar);
            }
        }
    };
    private View.OnClickListener iqq = new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.tabfeed.view.a.5
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            com.baidu.tieba.enterForum.b.d(a.this.ioZ.getPageContext(), a.this.tabName);
            if (a.this.iqm != null) {
                aq aqVar = new aq("c13645");
                aqVar.w("uid", TbadkApplication.getCurrentAccountId());
                aqVar.al("obj_locate", 1);
                aqVar.al("obj_type", a.this.iqm.aiL ? 5 : 1);
                aqVar.al("obj_source", 2);
                TiebaStatic.log(aqVar);
            }
        }
    };
    private PullLeftRefreshLayout.a alt = new PullLeftRefreshLayout.a() { // from class: com.baidu.tieba.enterForum.tabfeed.view.a.6
        @Override // com.baidu.tbadk.widget.horizontalpullview.PullLeftRefreshLayout.a
        public void bFf() {
            com.baidu.tieba.enterForum.b.d(a.this.ioZ.getPageContext(), a.this.tabName);
            aq aqVar = new aq("c13645");
            aqVar.w("uid", TbadkApplication.getCurrentAccountId());
            aqVar.al("obj_locate", 1);
            aqVar.al("obj_type", a.this.iqm.aiL ? 5 : 1);
            aqVar.al("obj_source", 4);
            TiebaStatic.log(aqVar);
        }
    };

    public a(EnterForumTabFeedFragment enterForumTabFeedFragment, com.baidu.tieba.enterForum.tabfeed.b bVar, ViewGroup viewGroup, String str) {
        this.ioZ = enterForumTabFeedFragment;
        this.ipW = bVar;
        this.tabName = str;
        aX(viewGroup);
        this.iqo = new com.baidu.tieba.enterForum.tabfeed.a(enterForumTabFeedFragment, this.ipa);
        lc(false);
    }

    private void aX(ViewGroup viewGroup) {
        this.iqh = viewGroup;
        this.ipa = (BdTypeRecyclerView) viewGroup.findViewById(R.id.tab_feed_recycler_view);
        this.ipa.setLayoutManager(new LinearLayoutManager(this.ioZ.getContext()));
        this.ipa.setFadingEdgeLength(0);
        this.ipa.setOverScrollMode(2);
        this.ipa.setOnSrollToBottomListener(this.gDv);
        this.ipa.addOnScrollListener(this.hQQ);
        this.mPullView = new g(this.ioZ.getPageContext());
        this.mPullView.setListPullRefreshListener(this.ipW);
        this.ipa.setRecyclerListener(new RecyclerView.RecyclerListener() { // from class: com.baidu.tieba.enterForum.tabfeed.view.a.7
            @Override // android.support.v7.widget.RecyclerView.RecyclerListener
            public void onViewRecycled(RecyclerView.ViewHolder viewHolder) {
                View view = viewHolder.itemView;
                if (view != null && a.this.iqn != null) {
                    a.this.iqn.da(view);
                }
            }
        });
        this.gjo = new PbListView(this.ioZ.getPageContext().getPageActivity());
        this.gjo.getView();
        this.gjo.setContainerBackgroundColorResId(R.color.cp_bg_line_e);
        this.gjo.setHeight(l.getDimens(this.ioZ.getPageContext().getPageActivity(), R.dimen.tbds182));
        this.gjo.setLineGone();
        this.gjo.setTextSize(R.dimen.tbfontsize33);
        this.gjo.setTextColor(ap.getColor(R.color.cp_cont_j));
        this.gjo.setNoMoreTextColorId(R.color.cp_cont_e);
        this.gjo.bst();
        this.gjo.setOnClickListener(this.iqp);
        if (this.glI == null) {
            this.glI = (BdSwipeRefreshLayout) viewGroup.findViewById(R.id.tab_feed_pull_refresh_layout);
            this.glI.setProgressView(this.mPullView);
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.glI.getLayoutParams();
            marginLayoutParams.topMargin = UtilHelper.getStatusBarHeight() + l.getDimens(this.ioZ.getPageContext().getPageActivity(), R.dimen.tbds219);
            this.glI.setLayoutParams(marginLayoutParams);
        }
        this.iqi = new be();
        this.iqj = new SmartBubbleAnimatedView(this.ioZ.getContext());
        this.iqj.setLayoutParams(new FrameLayout.LayoutParams(-1, l.getDimens(this.ioZ.getContext(), R.dimen.tbds83)));
        if (this.iqn == null) {
            this.iqn = new i(this.ioZ.getPageContext(), this.ipa);
            this.iqn.Hu(1);
            this.iqn.setUniqueId(this.ioZ.getUniqueId());
        }
        this.iqk = new b(this.ioZ.getPageContext());
        this.iqk.setTabName(this.tabName);
    }

    public void b(com.baidu.tieba.enterForum.tabfeed.b.b bVar) {
        if (bVar != null) {
            this.hasMore = bVar.hasMore;
        }
        lc(false);
        if (bVar != null && this.iqo != null && this.ipa != null && this.gjo != null) {
            ctd();
            d(bVar);
            c(bVar);
            if (bVar.ipS > 0) {
                int firstVisiblePosition = this.ipa.getFirstVisiblePosition();
                View childAt = this.ipa.getChildAt(0);
                int top = childAt == null ? 0 : childAt.getTop();
                RecyclerView.LayoutManager layoutManager = this.ipa.getLayoutManager();
                int i = firstVisiblePosition - bVar.ipS;
                if (layoutManager instanceof LinearLayoutManager) {
                    this.ipa.qR();
                    ((LinearLayoutManager) layoutManager).scrollToPositionWithOffset(i, top);
                    this.ipa.qS();
                }
                bVar.ipS = 0;
            }
            this.iqo.setIsFromCDN(bVar.akk);
            this.iqo.setData(bVar.ipR);
            this.iqo.notifyDataSetChanged();
            if (bVar.fNU) {
                xW(bVar.refreshCount);
            }
            if (this.iqn != null) {
                this.iqn.a(this.ipa.getFirstVisiblePosition(), this.ipa.getLastVisiblePosition(), false, true);
            }
        }
    }

    private void ctd() {
        if (this.evg == null) {
            this.evg = new TextView(this.ioZ.getContext());
            this.evg.setPadding(l.getDimens(this.ioZ.getContext(), R.dimen.tbds44), l.getDimens(this.ioZ.getContext(), R.dimen.tbds60), 0, l.getDimens(this.ioZ.getContext(), R.dimen.tbds24));
            this.evg.setText(R.string.tab_feed_title);
            this.evg.setTextSize(0, l.getDimens(this.ioZ.getContext(), R.dimen.tbds46));
            this.evg.setTypeface(Typeface.DEFAULT_BOLD);
            this.ipa.removeHeaderView(this.evg);
            this.ipa.addHeaderView(this.evg, 0);
            ap.setViewTextColor(this.evg, R.color.cp_cont_b);
        }
    }

    private void c(com.baidu.tieba.enterForum.tabfeed.b.b bVar) {
        if (bVar != null && this.ipa != null && this.ioZ != null && bVar.fNU) {
            if (!((bVar.ipQ == null || y.isEmpty(bVar.ipQ.blG())) ? false : true)) {
                if (this.iqm != null) {
                    this.ipa.removeHeaderView(this.iqm);
                    return;
                }
                return;
            }
            if (this.iqm == null) {
                this.iqm = new RecommendForumLayout(this.ioZ.getPageContext());
                this.iqm.setShowMore(true);
                this.iqm.setSquareEntranceAtStart(true);
                this.iqm.setTabName(this.tabName);
                this.iqm.setFrom(1);
            }
            this.iqm.setOnClickRightArrowListener(this.iqq);
            this.iqm.setOnRullOkCallbackr(this.alt);
            this.iqm.setOnItemCoverListener(this.aiM);
            this.iqm.b(bVar.ipQ);
            this.ipa.removeHeaderView(this.iqm);
            this.ipa.addHeaderView(this.iqm, 0);
            aq aqVar = new aq("c13641");
            aqVar.w("uid", TbadkApplication.getCurrentAccountId());
            aqVar.al("obj_locate", 2);
            aqVar.dR("resource_id", this.tabName);
            TiebaStatic.log(aqVar);
        }
    }

    private void d(com.baidu.tieba.enterForum.tabfeed.b.b bVar) {
        if (bVar.ipT != null && bVar.ipT.hot_user != null && bVar.ipT.hot_user.size() > 0 && !TextUtils.isEmpty(bVar.ipT.module_name)) {
            this.iqk.a(bVar.ipT);
            if (this.iqk.getView().getParent() == null && !this.iql) {
                this.iql = true;
                this.ipa.addHeaderView(this.iqk.getView(), 0);
                aq aqVar = new aq("c13656");
                aqVar.w("uid", TbadkApplication.getCurrentAccountId());
                aqVar.dR("resource_id", this.tabName);
                TiebaStatic.log(aqVar);
                return;
            }
            return;
        }
        this.iql = false;
        this.ipa.removeHeaderView(this.iqk.getView());
    }

    public void onChangeSkinType(int i) {
        if (this.mPullView != null) {
            this.mPullView.changeSkin(i);
        }
        if (this.gjo != null) {
            this.gjo.setTextColor(ap.getColor(R.color.cp_cont_j));
            this.gjo.changeSkin(i);
        }
        if (this.iqo != null) {
            this.iqo.notifyDataSetChanged();
        }
        if (this.evg != null) {
            ap.setViewTextColor(this.evg, R.color.cp_cont_b);
        }
        if (this.iqk != null) {
            this.iqk.onChangeSkinType();
        }
        if (this.iqm != null) {
            this.iqm.onChangeSkinType();
        }
        if (this.iqj != null) {
            this.iqj.onChangeSkinType(i);
        }
    }

    public void resume() {
        if (this.iqn != null) {
            this.iqn.sX(true);
            if (this.ipa != null) {
                this.iqn.a(this.ipa.getFirstVisiblePosition(), this.ipa.getLastVisiblePosition(), false, true);
            }
        }
    }

    public void pause() {
        if (this.iqn != null) {
            this.iqn.dab();
            this.iqn.sX(false);
        }
    }

    public void cte() {
        if (this.ipa != null) {
            this.ipa.scrollToPosition(0);
        }
    }

    public void lc(boolean z) {
        if (this.glI != null) {
            this.glI.setRefreshing(z);
        }
    }

    public void pa(boolean z) {
        if (this.glI != null) {
            this.glI.setVisibility(z ? 0 : 8);
        }
    }

    public boolean ctf() {
        return this.ipa == null || this.ipa.getChildCount() == 0 || this.ipa.getChildAt(0).getTop() == 0;
    }

    private void xW(int i) {
        String string;
        if (i >= 0) {
            this.iqi.cAG();
            if (i > 0) {
                string = String.format(TbadkCoreApplication.getInst().getString(R.string.recommend_frs_refresh_return), Integer.valueOf(i));
            } else {
                string = TbadkCoreApplication.getInst().getString(R.string.recommend_frs_refresh_nodata);
            }
            if (!TextUtils.isEmpty(string) && j.isNetWorkAvailable()) {
                this.iqj.eVP = string;
                this.iqj.iMp = 2000L;
                FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
                layoutParams.gravity = 49;
                layoutParams.topMargin = UtilHelper.getStatusBarHeight() + l.getDimens(this.ioZ.getPageContext().getPageActivity(), R.dimen.tbds228);
                if (this.iqh != null) {
                    this.iqh.removeView(this.iqj);
                    this.iqh.addView(this.iqj, layoutParams);
                    this.iqj.cAE();
                }
            }
        }
    }

    public void ci(int i, int i2) {
        if (this.ipa != null && i < i2) {
            this.ipa.o(i, i2);
        }
    }
}
