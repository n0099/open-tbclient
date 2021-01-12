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
    private TextView eFr;
    private PbListView gxy;
    private BdSwipeRefreshLayout gzS;
    private boolean hasMore;
    private EnterForumTabFeedFragment iIm;
    private BdTypeRecyclerView iIn;
    private i iJA;
    private com.baidu.tieba.enterForum.tabfeed.a iJB;
    private com.baidu.tieba.enterForum.tabfeed.b iJj;
    private ViewGroup iJu;
    private bb iJv;
    private SmartBubbleAnimatedView iJw;
    private b iJx;
    private boolean iJy;
    private RecommendForumLayout iJz;
    private g mPullView;
    private String tabName;
    private BdListView.e gTh = new BdListView.e() { // from class: com.baidu.tieba.enterForum.tabfeed.view.a.1
        @Override // com.baidu.adp.widget.ListView.BdListView.e
        public void onScrollToBottom() {
            if (a.this.iIn != null) {
                a.this.iIn.stopScroll();
            }
            if (a.this.gxy != null && a.this.iJj != null) {
                if (j.isNetWorkAvailable()) {
                    a.this.iIn.setNextPage(a.this.gxy);
                    a.this.gxy.showEmptyView(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
                    a.this.gxy.setOnClickListener(null);
                    if (a.this.hasMore) {
                        a.this.gxy.showLoading();
                        a.this.iJj.cvM();
                        return;
                    }
                    a.this.gxy.setText(a.this.iIm.getResources().getString(R.string.list_has_no_more));
                    a.this.gxy.endLoadData();
                    return;
                }
                a.this.iIn.setNextPage(null);
            }
        }
    };
    private RecyclerView.OnScrollListener ikd = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.enterForum.tabfeed.view.a.2
        private boolean fgG;

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i) {
            if (i == 0) {
                if (a.this.iJA != null) {
                    a.this.iJA.b(a.this.iIn.getFirstVisiblePosition(), a.this.iIn.getLastVisiblePosition(), this.fgG, true);
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001630, Boolean.valueOf(a.this.cwa() ? false : true)));
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrolled(RecyclerView recyclerView, int i, int i2) {
            super.onScrolled(recyclerView, i, i2);
            if (i2 > 0) {
                this.fgG = false;
            } else {
                this.fgG = true;
            }
        }
    };
    private View.OnClickListener iJC = new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.tabfeed.view.a.3
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (a.this.iIn != null) {
                a.this.iIn.stopScroll();
            }
            if (a.this.gxy != null && a.this.iJj != null && j.isNetWorkAvailable()) {
                a.this.gxy.showEmptyView(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
                a.this.gxy.setOnClickListener(null);
                if (a.this.hasMore) {
                    a.this.gxy.showLoading();
                    a.this.iJj.cvM();
                }
            }
        }
    };
    private f ajB = new f<bl>() { // from class: com.baidu.tieba.enterForum.tabfeed.view.a.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tbadk.h.f
        public void a(View view, bl blVar, int i, long j) {
            if (blVar == null) {
                com.baidu.tieba.enterForum.b.d(a.this.iIm.getPageContext(), a.this.tabName);
                if (a.this.iJz != null) {
                    aq aqVar = new aq("c13645");
                    aqVar.w("uid", TbadkApplication.getCurrentAccountId());
                    aqVar.an("obj_locate", 1);
                    aqVar.an("obj_type", a.this.iJz.ajA ? 5 : 1);
                    aqVar.an("obj_source", 5);
                    TiebaStatic.log(aqVar);
                }
            } else if (blVar != null && a.this.iIm != null) {
                String forumName = blVar.getForumName();
                if (at.isForumName(forumName)) {
                    a.this.iIm.sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(a.this.iIm.getFragmentActivity()).createNormalCfg(forumName, FrsActivityConfig.FRS_FROM_ENTERFORUM_RECOMMEND).setCallFrom(3)));
                    if (a.this.iJz != null) {
                        aq aqVar2 = new aq("c13643");
                        aqVar2.w("uid", TbadkApplication.getCurrentAccountId());
                        aqVar2.w("fid", blVar.getForumId());
                        if (a.this.iJz.mFrom != 0) {
                            if (a.this.iJz.mFrom == 1) {
                                aqVar2.an("obj_locate", 2);
                                aqVar2.dW("resource_id", a.this.tabName);
                            }
                        } else {
                            aqVar2.an("obj_locate", 1);
                            aqVar2.an("obj_type", a.this.iJz.ajA ? 4 : 1);
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
                if (a.this.iJz.mFrom != 0) {
                    if (a.this.iJz.mFrom == 1) {
                        aqVar.an("obj_locate", 2);
                        aqVar.dW("resource_id", a.this.tabName);
                    }
                } else {
                    aqVar.an("obj_locate", 1);
                    aqVar.an("obj_type", a.this.iJz.ajA ? 3 : 1);
                }
                TiebaStatic.log(aqVar);
            }
        }
    };
    private View.OnClickListener iJD = new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.tabfeed.view.a.5
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            com.baidu.tieba.enterForum.b.d(a.this.iIm.getPageContext(), a.this.tabName);
            if (a.this.iJz != null) {
                aq aqVar = new aq("c13645");
                aqVar.w("uid", TbadkApplication.getCurrentAccountId());
                aqVar.an("obj_locate", 1);
                aqVar.an("obj_type", a.this.iJz.ajA ? 5 : 1);
                aqVar.an("obj_source", 2);
                TiebaStatic.log(aqVar);
            }
        }
    };
    private PullLeftRefreshLayout.a amj = new PullLeftRefreshLayout.a() { // from class: com.baidu.tieba.enterForum.tabfeed.view.a.6
        @Override // com.baidu.tbadk.widget.horizontalpullview.PullLeftRefreshLayout.a
        public void bGC() {
            com.baidu.tieba.enterForum.b.d(a.this.iIm.getPageContext(), a.this.tabName);
            aq aqVar = new aq("c13645");
            aqVar.w("uid", TbadkApplication.getCurrentAccountId());
            aqVar.an("obj_locate", 1);
            aqVar.an("obj_type", a.this.iJz.ajA ? 5 : 1);
            aqVar.an("obj_source", 4);
            TiebaStatic.log(aqVar);
        }
    };

    public a(EnterForumTabFeedFragment enterForumTabFeedFragment, com.baidu.tieba.enterForum.tabfeed.b bVar, ViewGroup viewGroup, String str) {
        this.iIm = enterForumTabFeedFragment;
        this.iJj = bVar;
        this.tabName = str;
        bf(viewGroup);
        this.iJB = new com.baidu.tieba.enterForum.tabfeed.a(enterForumTabFeedFragment, this.iIn);
        lQ(false);
    }

    private void bf(ViewGroup viewGroup) {
        this.iJu = viewGroup;
        this.iIn = (BdTypeRecyclerView) viewGroup.findViewById(R.id.tab_feed_recycler_view);
        this.iIn.setLayoutManager(new LinearLayoutManager(this.iIm.getContext()));
        this.iIn.setFadingEdgeLength(0);
        this.iIn.setOverScrollMode(2);
        this.iIn.setOnSrollToBottomListener(this.gTh);
        this.iIn.addOnScrollListener(this.ikd);
        this.mPullView = new g(this.iIm.getPageContext());
        this.mPullView.setListPullRefreshListener(this.iJj);
        this.iIn.setRecyclerListener(new RecyclerView.RecyclerListener() { // from class: com.baidu.tieba.enterForum.tabfeed.view.a.7
            @Override // androidx.recyclerview.widget.RecyclerView.RecyclerListener
            public void onViewRecycled(RecyclerView.ViewHolder viewHolder) {
                View view = viewHolder.itemView;
                if (view != null && a.this.iJA != null) {
                    a.this.iJA.dv(view);
                }
            }
        });
        this.gxy = new PbListView(this.iIm.getPageContext().getPageActivity());
        this.gxy.getView();
        this.gxy.setContainerBackgroundColorResId(R.color.CAM_X0205);
        this.gxy.setHeight(l.getDimens(this.iIm.getPageContext().getPageActivity(), R.dimen.tbds182));
        this.gxy.setLineGone();
        this.gxy.setTextSize(R.dimen.tbfontsize33);
        this.gxy.setTextColor(ao.getColor(R.color.CAM_X0107));
        this.gxy.setNoMoreTextColorId(R.color.CAM_X0110);
        this.gxy.btJ();
        this.gxy.setOnClickListener(this.iJC);
        if (this.gzS == null) {
            this.gzS = (BdSwipeRefreshLayout) viewGroup.findViewById(R.id.tab_feed_pull_refresh_layout);
            this.gzS.setProgressView(this.mPullView);
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.gzS.getLayoutParams();
            marginLayoutParams.topMargin = UtilHelper.getStatusBarHeight() + l.getDimens(this.iIm.getPageContext().getPageActivity(), R.dimen.tbds219);
            this.gzS.setLayoutParams(marginLayoutParams);
        }
        this.iJv = new bb();
        this.iJw = new SmartBubbleAnimatedView(this.iIm.getContext());
        this.iJw.setLayoutParams(new FrameLayout.LayoutParams(-1, l.getDimens(this.iIm.getContext(), R.dimen.tbds83)));
        if (this.iJA == null) {
            this.iJA = new i(this.iIm.getPageContext(), this.iIn);
            this.iJA.GW(1);
            this.iJA.setUniqueId(this.iIm.getUniqueId());
        }
        this.iJx = new b(this.iIm.getPageContext());
        this.iJx.setTabName(this.tabName);
    }

    public void b(com.baidu.tieba.enterForum.tabfeed.b.b bVar) {
        if (bVar != null) {
            this.hasMore = bVar.hasMore;
        }
        lQ(false);
        if (bVar != null && this.iJB != null && this.iIn != null && this.gxy != null) {
            cvY();
            d(bVar);
            c(bVar);
            if (bVar.iJf > 0) {
                int firstVisiblePosition = this.iIn.getFirstVisiblePosition();
                View childAt = this.iIn.getChildAt(0);
                int top = childAt == null ? 0 : childAt.getTop();
                RecyclerView.LayoutManager layoutManager = this.iIn.getLayoutManager();
                int i = firstVisiblePosition - bVar.iJf;
                if (layoutManager instanceof LinearLayoutManager) {
                    this.iIn.qv();
                    ((LinearLayoutManager) layoutManager).scrollToPositionWithOffset(i, top);
                    this.iIn.qw();
                }
                bVar.iJf = 0;
            }
            this.iJB.setIsFromCDN(bVar.akY);
            this.iJB.setData(bVar.iJe);
            this.iJB.notifyDataSetChanged();
            if (bVar.gae) {
                xG(bVar.refreshCount);
            }
            if (this.iJA != null) {
                this.iJA.b(this.iIn.getFirstVisiblePosition(), this.iIn.getLastVisiblePosition(), false, true);
            }
        }
    }

    private void cvY() {
        if (this.eFr == null) {
            this.eFr = new TextView(this.iIm.getContext());
            this.eFr.setPadding(l.getDimens(this.iIm.getContext(), R.dimen.tbds44), l.getDimens(this.iIm.getContext(), R.dimen.tbds60), 0, l.getDimens(this.iIm.getContext(), R.dimen.tbds24));
            this.eFr.setText(R.string.tab_feed_title);
            this.eFr.setTextSize(0, l.getDimens(this.iIm.getContext(), R.dimen.tbds46));
            this.eFr.setTypeface(Typeface.DEFAULT_BOLD);
            this.iIn.removeHeaderView(this.eFr);
            this.iIn.addHeaderView(this.eFr, 0);
            ao.setViewTextColor(this.eFr, R.color.CAM_X0105);
        }
    }

    private void c(com.baidu.tieba.enterForum.tabfeed.b.b bVar) {
        if (bVar != null && this.iIn != null && this.iIm != null && bVar.gae) {
            if (!((bVar.iJd == null || x.isEmpty(bVar.iJd.bmD())) ? false : true)) {
                if (this.iJz != null) {
                    this.iIn.removeHeaderView(this.iJz);
                    return;
                }
                return;
            }
            if (this.iJz == null) {
                this.iJz = new RecommendForumLayout(this.iIm.getPageContext());
                this.iJz.setShowMore(true);
                this.iJz.setSquareEntranceAtStart(true);
                this.iJz.setTabName(this.tabName);
                this.iJz.setFrom(1);
            }
            this.iJz.setOnClickRightArrowListener(this.iJD);
            this.iJz.setOnRullOkCallbackr(this.amj);
            this.iJz.setOnItemCoverListener(this.ajB);
            this.iJz.b(bVar.iJd);
            this.iIn.removeHeaderView(this.iJz);
            this.iIn.addHeaderView(this.iJz, 0);
            aq aqVar = new aq("c13641");
            aqVar.w("uid", TbadkApplication.getCurrentAccountId());
            aqVar.an("obj_locate", 2);
            aqVar.dW("resource_id", this.tabName);
            TiebaStatic.log(aqVar);
        }
    }

    private void d(com.baidu.tieba.enterForum.tabfeed.b.b bVar) {
        if (bVar.iJg != null && bVar.iJg.hot_user != null && bVar.iJg.hot_user.size() > 0 && !TextUtils.isEmpty(bVar.iJg.module_name)) {
            this.iJx.a(bVar.iJg);
            if (this.iJx.getView().getParent() == null && !this.iJy) {
                this.iJy = true;
                this.iIn.addHeaderView(this.iJx.getView(), 0);
                aq aqVar = new aq("c13656");
                aqVar.w("uid", TbadkApplication.getCurrentAccountId());
                aqVar.dW("resource_id", this.tabName);
                TiebaStatic.log(aqVar);
                return;
            }
            return;
        }
        this.iJy = false;
        this.iIn.removeHeaderView(this.iJx.getView());
    }

    public void onChangeSkinType(int i) {
        if (this.mPullView != null) {
            this.mPullView.changeSkin(i);
        }
        if (this.gxy != null) {
            this.gxy.setTextColor(ao.getColor(R.color.CAM_X0107));
            this.gxy.changeSkin(i);
        }
        if (this.iJB != null) {
            this.iJB.notifyDataSetChanged();
        }
        if (this.eFr != null) {
            ao.setViewTextColor(this.eFr, R.color.CAM_X0105);
        }
        if (this.iJx != null) {
            this.iJx.onChangeSkinType();
        }
        if (this.iJz != null) {
            this.iJz.onChangeSkinType();
        }
        if (this.iJw != null) {
            this.iJw.onChangeSkinType(i);
        }
    }

    public void resume() {
        if (this.iJA != null) {
            this.iJA.tA(true);
            if (this.iIn != null) {
                this.iJA.b(this.iIn.getFirstVisiblePosition(), this.iIn.getLastVisiblePosition(), false, true);
            }
        }
    }

    public void pause() {
        if (this.iJA != null) {
            this.iJA.daE();
            this.iJA.tA(false);
        }
    }

    public void cvZ() {
        if (this.iIn != null) {
            this.iIn.scrollToPosition(0);
        }
    }

    public void lQ(boolean z) {
        if (this.gzS != null) {
            this.gzS.setRefreshing(z);
        }
    }

    public void pS(boolean z) {
        if (this.gzS != null) {
            this.gzS.setVisibility(z ? 0 : 8);
        }
    }

    public boolean cwa() {
        return this.iIn == null || this.iIn.getChildCount() == 0 || this.iIn.getChildAt(0).getTop() == 0;
    }

    private void xG(int i) {
        String string;
        if (i >= 0) {
            this.iJv.cDE();
            if (i > 0) {
                string = String.format(TbadkCoreApplication.getInst().getString(R.string.recommend_frs_refresh_return), Integer.valueOf(i));
            } else {
                string = TbadkCoreApplication.getInst().getString(R.string.recommend_frs_refresh_nodata);
            }
            if (!TextUtils.isEmpty(string) && j.isNetWorkAvailable()) {
                this.iJw.fht = string;
                this.iJw.jfB = 2000L;
                FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
                layoutParams.gravity = 49;
                layoutParams.topMargin = UtilHelper.getStatusBarHeight() + l.getDimens(this.iIm.getPageContext().getPageActivity(), R.dimen.tbds228);
                if (this.iJu != null) {
                    this.iJu.removeView(this.iJw);
                    this.iJu.addView(this.iJw, layoutParams);
                    this.iJw.cDC();
                }
            }
        }
    }

    public void cl(int i, int i2) {
        if (this.iIn != null && i < i2) {
            this.iIn.p(i, i2);
        }
    }
}
