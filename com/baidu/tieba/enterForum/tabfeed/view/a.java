package com.baidu.tieba.enterForum.tabfeed.view;

import android.graphics.Typeface;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
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
import com.baidu.tbadk.core.data.bl;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.util.x;
import com.baidu.tbadk.core.view.PbListView;
import com.baidu.tbadk.core.view.g;
import com.baidu.tbadk.h.f;
import com.baidu.tbadk.widget.horizontalpullview.PullLeftRefreshLayout;
import com.baidu.tieba.R;
import com.baidu.tieba.enterForum.tabfeed.EnterForumTabFeedFragment;
import com.baidu.tieba.frs.SmartBubbleAnimatedView;
import com.baidu.tieba.frs.bb;
import com.baidu.tieba.play.i;
/* loaded from: classes2.dex */
public class a {
    private TextView eKc;
    private PbListView gCf;
    private BdSwipeRefreshLayout gEz;
    private boolean hasMore;
    private EnterForumTabFeedFragment iMT;
    private BdTypeRecyclerView iMU;
    private com.baidu.tieba.enterForum.tabfeed.b iNQ;
    private ViewGroup iOb;
    private bb iOc;
    private SmartBubbleAnimatedView iOd;
    private b iOe;
    private boolean iOf;
    private RecommendForumLayout iOg;
    private i iOh;
    private com.baidu.tieba.enterForum.tabfeed.a iOi;
    private g mPullView;
    private String tabName;
    private BdListView.e gXN = new BdListView.e() { // from class: com.baidu.tieba.enterForum.tabfeed.view.a.1
        @Override // com.baidu.adp.widget.ListView.BdListView.e
        public void onScrollToBottom() {
            if (a.this.iMU != null) {
                a.this.iMU.stopScroll();
            }
            if (a.this.gCf != null && a.this.iNQ != null) {
                if (j.isNetWorkAvailable()) {
                    a.this.iMU.setNextPage(a.this.gCf);
                    a.this.gCf.showEmptyView(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
                    a.this.gCf.setOnClickListener(null);
                    if (a.this.hasMore) {
                        a.this.gCf.showLoading();
                        a.this.iNQ.czE();
                        return;
                    }
                    a.this.gCf.setText(a.this.iMT.getResources().getString(R.string.list_has_no_more));
                    a.this.gCf.endLoadData();
                    return;
                }
                a.this.iMU.setNextPage(null);
            }
        }
    };
    private RecyclerView.OnScrollListener ioM = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.enterForum.tabfeed.view.a.2
        private boolean flr;

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i) {
            if (i == 0) {
                if (a.this.iOh != null) {
                    a.this.iOh.b(a.this.iMU.getFirstVisiblePosition(), a.this.iMU.getLastVisiblePosition(), this.flr, true);
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001630, Boolean.valueOf(a.this.czS() ? false : true)));
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrolled(RecyclerView recyclerView, int i, int i2) {
            super.onScrolled(recyclerView, i, i2);
            if (i2 > 0) {
                this.flr = false;
            } else {
                this.flr = true;
            }
        }
    };
    private View.OnClickListener iOj = new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.tabfeed.view.a.3
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (a.this.iMU != null) {
                a.this.iMU.stopScroll();
            }
            if (a.this.gCf != null && a.this.iNQ != null && j.isNetWorkAvailable()) {
                a.this.gCf.showEmptyView(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
                a.this.gCf.setOnClickListener(null);
                if (a.this.hasMore) {
                    a.this.gCf.showLoading();
                    a.this.iNQ.czE();
                }
            }
        }
    };
    private f aks = new f<bl>() { // from class: com.baidu.tieba.enterForum.tabfeed.view.a.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tbadk.h.f
        public void a(View view, bl blVar, int i, long j) {
            if (blVar == null) {
                com.baidu.tieba.enterForum.b.d(a.this.iMT.getPageContext(), a.this.tabName);
                if (a.this.iOg != null) {
                    aq aqVar = new aq("c13645");
                    aqVar.w("uid", TbadkApplication.getCurrentAccountId());
                    aqVar.an("obj_locate", 1);
                    aqVar.an("obj_type", a.this.iOg.akr ? 5 : 1);
                    aqVar.an("obj_source", 5);
                    TiebaStatic.log(aqVar);
                }
            } else if (blVar != null && a.this.iMT != null) {
                String forumName = blVar.getForumName();
                if (at.isForumName(forumName)) {
                    a.this.iMT.sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(a.this.iMT.getFragmentActivity()).createNormalCfg(forumName, FrsActivityConfig.FRS_FROM_ENTERFORUM_RECOMMEND).setCallFrom(3)));
                    if (a.this.iOg != null) {
                        aq aqVar2 = new aq("c13643");
                        aqVar2.w("uid", TbadkApplication.getCurrentAccountId());
                        aqVar2.w("fid", blVar.getForumId());
                        if (a.this.iOg.mFrom != 0) {
                            if (a.this.iOg.mFrom == 1) {
                                aqVar2.an("obj_locate", 2);
                                aqVar2.dX("resource_id", a.this.tabName);
                            }
                        } else {
                            aqVar2.an("obj_locate", 1);
                            aqVar2.an("obj_type", a.this.iOg.akr ? 4 : 1);
                        }
                        TiebaStatic.log(aqVar2);
                    }
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tbadk.h.f
        public void b(View view, bl blVar, int i, long j) {
            if (blVar != null) {
                aq aqVar = new aq("c13642");
                aqVar.w("uid", TbadkApplication.getCurrentAccountId());
                aqVar.w("fid", blVar.getForumId());
                if (a.this.iOg.mFrom != 0) {
                    if (a.this.iOg.mFrom == 1) {
                        aqVar.an("obj_locate", 2);
                        aqVar.dX("resource_id", a.this.tabName);
                    }
                } else {
                    aqVar.an("obj_locate", 1);
                    aqVar.an("obj_type", a.this.iOg.akr ? 3 : 1);
                }
                TiebaStatic.log(aqVar);
            }
        }
    };
    private View.OnClickListener iOk = new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.tabfeed.view.a.5
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            com.baidu.tieba.enterForum.b.d(a.this.iMT.getPageContext(), a.this.tabName);
            if (a.this.iOg != null) {
                aq aqVar = new aq("c13645");
                aqVar.w("uid", TbadkApplication.getCurrentAccountId());
                aqVar.an("obj_locate", 1);
                aqVar.an("obj_type", a.this.iOg.akr ? 5 : 1);
                aqVar.an("obj_source", 2);
                TiebaStatic.log(aqVar);
            }
        }
    };
    private PullLeftRefreshLayout.a ana = new PullLeftRefreshLayout.a() { // from class: com.baidu.tieba.enterForum.tabfeed.view.a.6
        @Override // com.baidu.tbadk.widget.horizontalpullview.PullLeftRefreshLayout.a
        public void bKu() {
            com.baidu.tieba.enterForum.b.d(a.this.iMT.getPageContext(), a.this.tabName);
            aq aqVar = new aq("c13645");
            aqVar.w("uid", TbadkApplication.getCurrentAccountId());
            aqVar.an("obj_locate", 1);
            aqVar.an("obj_type", a.this.iOg.akr ? 5 : 1);
            aqVar.an("obj_source", 4);
            TiebaStatic.log(aqVar);
        }
    };

    public a(EnterForumTabFeedFragment enterForumTabFeedFragment, com.baidu.tieba.enterForum.tabfeed.b bVar, ViewGroup viewGroup, String str) {
        this.iMT = enterForumTabFeedFragment;
        this.iNQ = bVar;
        this.tabName = str;
        bf(viewGroup);
        this.iOi = new com.baidu.tieba.enterForum.tabfeed.a(enterForumTabFeedFragment, this.iMU);
        lU(false);
    }

    private void bf(ViewGroup viewGroup) {
        this.iOb = viewGroup;
        this.iMU = (BdTypeRecyclerView) viewGroup.findViewById(R.id.tab_feed_recycler_view);
        this.iMU.setLayoutManager(new LinearLayoutManager(this.iMT.getContext()));
        this.iMU.setFadingEdgeLength(0);
        this.iMU.setOverScrollMode(2);
        this.iMU.setOnSrollToBottomListener(this.gXN);
        this.iMU.addOnScrollListener(this.ioM);
        this.mPullView = new g(this.iMT.getPageContext());
        this.mPullView.setListPullRefreshListener(this.iNQ);
        this.iMU.setRecyclerListener(new RecyclerView.RecyclerListener() { // from class: com.baidu.tieba.enterForum.tabfeed.view.a.7
            @Override // androidx.recyclerview.widget.RecyclerView.RecyclerListener
            public void onViewRecycled(RecyclerView.ViewHolder viewHolder) {
                View view = viewHolder.itemView;
                if (view != null && a.this.iOh != null) {
                    a.this.iOh.dv(view);
                }
            }
        });
        this.gCf = new PbListView(this.iMT.getPageContext().getPageActivity());
        this.gCf.getView();
        this.gCf.setContainerBackgroundColorResId(R.color.CAM_X0205);
        this.gCf.setHeight(l.getDimens(this.iMT.getPageContext().getPageActivity(), R.dimen.tbds182));
        this.gCf.setLineGone();
        this.gCf.setTextSize(R.dimen.tbfontsize33);
        this.gCf.setTextColor(ao.getColor(R.color.CAM_X0107));
        this.gCf.setNoMoreTextColorId(R.color.CAM_X0110);
        this.gCf.bxD();
        this.gCf.setOnClickListener(this.iOj);
        if (this.gEz == null) {
            this.gEz = (BdSwipeRefreshLayout) viewGroup.findViewById(R.id.tab_feed_pull_refresh_layout);
            this.gEz.setProgressView(this.mPullView);
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.gEz.getLayoutParams();
            marginLayoutParams.topMargin = UtilHelper.getStatusBarHeight() + l.getDimens(this.iMT.getPageContext().getPageActivity(), R.dimen.tbds219);
            this.gEz.setLayoutParams(marginLayoutParams);
        }
        this.iOc = new bb();
        this.iOd = new SmartBubbleAnimatedView(this.iMT.getContext());
        this.iOd.setLayoutParams(new FrameLayout.LayoutParams(-1, l.getDimens(this.iMT.getContext(), R.dimen.tbds83)));
        if (this.iOh == null) {
            this.iOh = new i(this.iMT.getPageContext(), this.iMU);
            this.iOh.ID(1);
            this.iOh.setUniqueId(this.iMT.getUniqueId());
        }
        this.iOe = new b(this.iMT.getPageContext());
        this.iOe.setTabName(this.tabName);
    }

    public void b(com.baidu.tieba.enterForum.tabfeed.b.b bVar) {
        if (bVar != null) {
            this.hasMore = bVar.hasMore;
        }
        lU(false);
        if (bVar != null && this.iOi != null && this.iMU != null && this.gCf != null) {
            czQ();
            d(bVar);
            c(bVar);
            if (bVar.iNM > 0) {
                int firstVisiblePosition = this.iMU.getFirstVisiblePosition();
                View childAt = this.iMU.getChildAt(0);
                int top = childAt == null ? 0 : childAt.getTop();
                RecyclerView.LayoutManager layoutManager = this.iMU.getLayoutManager();
                int i = firstVisiblePosition - bVar.iNM;
                if (layoutManager instanceof LinearLayoutManager) {
                    this.iMU.qv();
                    ((LinearLayoutManager) layoutManager).scrollToPositionWithOffset(i, top);
                    this.iMU.qw();
                }
                bVar.iNM = 0;
            }
            this.iOi.setIsFromCDN(bVar.alQ);
            this.iOi.setData(bVar.iNL);
            this.iOi.notifyDataSetChanged();
            if (bVar.geO) {
                zm(bVar.refreshCount);
            }
            if (this.iOh != null) {
                this.iOh.b(this.iMU.getFirstVisiblePosition(), this.iMU.getLastVisiblePosition(), false, true);
            }
        }
    }

    private void czQ() {
        if (this.eKc == null) {
            this.eKc = new TextView(this.iMT.getContext());
            this.eKc.setPadding(l.getDimens(this.iMT.getContext(), R.dimen.tbds44), l.getDimens(this.iMT.getContext(), R.dimen.tbds60), 0, l.getDimens(this.iMT.getContext(), R.dimen.tbds24));
            this.eKc.setText(R.string.tab_feed_title);
            this.eKc.setTextSize(0, l.getDimens(this.iMT.getContext(), R.dimen.tbds46));
            this.eKc.setTypeface(Typeface.DEFAULT_BOLD);
            this.iMU.removeHeaderView(this.eKc);
            this.iMU.addHeaderView(this.eKc, 0);
            ao.setViewTextColor(this.eKc, R.color.CAM_X0105);
        }
    }

    private void c(com.baidu.tieba.enterForum.tabfeed.b.b bVar) {
        if (bVar != null && this.iMU != null && this.iMT != null && bVar.geO) {
            if (!((bVar.iNK == null || x.isEmpty(bVar.iNK.bqx())) ? false : true)) {
                if (this.iOg != null) {
                    this.iMU.removeHeaderView(this.iOg);
                    return;
                }
                return;
            }
            if (this.iOg == null) {
                this.iOg = new RecommendForumLayout(this.iMT.getPageContext());
                this.iOg.setShowMore(true);
                this.iOg.setSquareEntranceAtStart(true);
                this.iOg.setTabName(this.tabName);
                this.iOg.setFrom(1);
            }
            this.iOg.setOnClickRightArrowListener(this.iOk);
            this.iOg.setOnRullOkCallbackr(this.ana);
            this.iOg.setOnItemCoverListener(this.aks);
            this.iOg.b(bVar.iNK);
            this.iMU.removeHeaderView(this.iOg);
            this.iMU.addHeaderView(this.iOg, 0);
            aq aqVar = new aq("c13641");
            aqVar.w("uid", TbadkApplication.getCurrentAccountId());
            aqVar.an("obj_locate", 2);
            aqVar.dX("resource_id", this.tabName);
            TiebaStatic.log(aqVar);
        }
    }

    private void d(com.baidu.tieba.enterForum.tabfeed.b.b bVar) {
        if (bVar.iNN != null && bVar.iNN.hot_user != null && bVar.iNN.hot_user.size() > 0 && !TextUtils.isEmpty(bVar.iNN.module_name)) {
            this.iOe.a(bVar.iNN);
            if (this.iOe.getView().getParent() == null && !this.iOf) {
                this.iOf = true;
                this.iMU.addHeaderView(this.iOe.getView(), 0);
                aq aqVar = new aq("c13656");
                aqVar.w("uid", TbadkApplication.getCurrentAccountId());
                aqVar.dX("resource_id", this.tabName);
                TiebaStatic.log(aqVar);
                return;
            }
            return;
        }
        this.iOf = false;
        this.iMU.removeHeaderView(this.iOe.getView());
    }

    public void onChangeSkinType(int i) {
        if (this.mPullView != null) {
            this.mPullView.changeSkin(i);
        }
        if (this.gCf != null) {
            this.gCf.setTextColor(ao.getColor(R.color.CAM_X0107));
            this.gCf.changeSkin(i);
        }
        if (this.iOi != null) {
            this.iOi.notifyDataSetChanged();
        }
        if (this.eKc != null) {
            ao.setViewTextColor(this.eKc, R.color.CAM_X0105);
        }
        if (this.iOe != null) {
            this.iOe.onChangeSkinType();
        }
        if (this.iOg != null) {
            this.iOg.onChangeSkinType();
        }
        if (this.iOd != null) {
            this.iOd.onChangeSkinType(i);
        }
    }

    public void resume() {
        if (this.iOh != null) {
            this.iOh.tE(true);
            if (this.iMU != null) {
                this.iOh.b(this.iMU.getFirstVisiblePosition(), this.iMU.getLastVisiblePosition(), false, true);
            }
        }
    }

    public void pause() {
        if (this.iOh != null) {
            this.iOh.dew();
            this.iOh.tE(false);
        }
    }

    public void czR() {
        if (this.iMU != null) {
            this.iMU.scrollToPosition(0);
        }
    }

    public void lU(boolean z) {
        if (this.gEz != null) {
            this.gEz.setRefreshing(z);
        }
    }

    public void pW(boolean z) {
        if (this.gEz != null) {
            this.gEz.setVisibility(z ? 0 : 8);
        }
    }

    public boolean czS() {
        return this.iMU == null || this.iMU.getChildCount() == 0 || this.iMU.getChildAt(0).getTop() == 0;
    }

    private void zm(int i) {
        String string;
        if (i >= 0) {
            this.iOc.cHw();
            if (i > 0) {
                string = String.format(TbadkCoreApplication.getInst().getString(R.string.recommend_frs_refresh_return), Integer.valueOf(i));
            } else {
                string = TbadkCoreApplication.getInst().getString(R.string.recommend_frs_refresh_nodata);
            }
            if (!TextUtils.isEmpty(string) && j.isNetWorkAvailable()) {
                this.iOd.fme = string;
                this.iOd.jki = 2000L;
                FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
                layoutParams.gravity = 49;
                layoutParams.topMargin = UtilHelper.getStatusBarHeight() + l.getDimens(this.iMT.getPageContext().getPageActivity(), R.dimen.tbds228);
                if (this.iOb != null) {
                    this.iOb.removeView(this.iOd);
                    this.iOb.addView(this.iOd, layoutParams);
                    this.iOd.cHu();
                }
            }
        }
    }

    public void cl(int i, int i2) {
        if (this.iMU != null && i < i2) {
            this.iMU.p(i, i2);
        }
    }
}
