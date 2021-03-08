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
import com.baidu.tbadk.core.data.bn;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.core.util.y;
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
    private TextView eIY;
    private PbListView gCf;
    private BdSwipeRefreshLayout gEz;
    private boolean hasMore;
    private EnterForumTabFeedFragment iPR;
    private BdTypeRecyclerView iPS;
    private com.baidu.tieba.enterForum.tabfeed.b iQO;
    private ViewGroup iQZ;
    private bb iRa;
    private SmartBubbleAnimatedView iRb;
    private b iRc;
    private boolean iRd;
    private RecommendForumLayout iRe;
    private i iRf;
    private com.baidu.tieba.enterForum.tabfeed.a iRg;
    private g mPullView;
    private String tabName;
    private BdListView.e gXO = new BdListView.e() { // from class: com.baidu.tieba.enterForum.tabfeed.view.a.1
        @Override // com.baidu.adp.widget.ListView.BdListView.e
        public void onScrollToBottom() {
            if (a.this.iPS != null) {
                a.this.iPS.stopScroll();
            }
            if (a.this.gCf != null && a.this.iQO != null) {
                if (j.isNetWorkAvailable()) {
                    a.this.iPS.setNextPage(a.this.gCf);
                    a.this.gCf.showEmptyView(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
                    a.this.gCf.setOnClickListener(null);
                    if (a.this.hasMore) {
                        a.this.gCf.showLoading();
                        a.this.iQO.cxl();
                        return;
                    }
                    a.this.gCf.setText(a.this.iPR.getResources().getString(R.string.list_has_no_more));
                    a.this.gCf.endLoadData();
                    return;
                }
                a.this.iPS.setNextPage(null);
            }
        }
    };
    private RecyclerView.OnScrollListener irI = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.enterForum.tabfeed.view.a.2
        private boolean fky;

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i) {
            if (i == 0) {
                if (a.this.iRf != null) {
                    a.this.iRf.b(a.this.iPS.getFirstVisiblePosition(), a.this.iPS.getLastVisiblePosition(), this.fky, true);
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001630, Boolean.valueOf(a.this.cxz() ? false : true)));
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrolled(RecyclerView recyclerView, int i, int i2) {
            super.onScrolled(recyclerView, i, i2);
            if (i2 > 0) {
                this.fky = false;
            } else {
                this.fky = true;
            }
        }
    };
    private View.OnClickListener iRh = new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.tabfeed.view.a.3
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (a.this.iPS != null) {
                a.this.iPS.stopScroll();
            }
            if (a.this.gCf != null && a.this.iQO != null && j.isNetWorkAvailable()) {
                a.this.gCf.showEmptyView(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
                a.this.gCf.setOnClickListener(null);
                if (a.this.hasMore) {
                    a.this.gCf.showLoading();
                    a.this.iQO.cxl();
                }
            }
        }
    };
    private f akI = new f<bn>() { // from class: com.baidu.tieba.enterForum.tabfeed.view.a.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tbadk.h.f
        public void a(View view, bn bnVar, int i, long j) {
            if (bnVar == null) {
                com.baidu.tieba.enterForum.b.d(a.this.iPR.getPageContext(), a.this.tabName);
                if (a.this.iRe != null) {
                    ar arVar = new ar("c13645");
                    arVar.v("uid", TbadkApplication.getCurrentAccountId());
                    arVar.aq("obj_locate", 1);
                    arVar.aq("obj_type", a.this.iRe.akH ? 5 : 1);
                    arVar.aq("obj_source", 5);
                    TiebaStatic.log(arVar);
                }
            } else if (bnVar != null && a.this.iPR != null) {
                String forumName = bnVar.getForumName();
                if (au.isForumName(forumName)) {
                    a.this.iPR.sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(a.this.iPR.getFragmentActivity()).createNormalCfg(forumName, FrsActivityConfig.FRS_FROM_ENTERFORUM_RECOMMEND).setCallFrom(3)));
                    if (a.this.iRe != null) {
                        ar arVar2 = new ar("c13643");
                        arVar2.v("uid", TbadkApplication.getCurrentAccountId());
                        arVar2.v("fid", bnVar.getForumId());
                        if (a.this.iRe.mFrom != 0) {
                            if (a.this.iRe.mFrom == 1) {
                                arVar2.aq("obj_locate", 2);
                                arVar2.dR("resource_id", a.this.tabName);
                            }
                        } else {
                            arVar2.aq("obj_locate", 1);
                            arVar2.aq("obj_type", a.this.iRe.akH ? 4 : 1);
                        }
                        TiebaStatic.log(arVar2);
                    }
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tbadk.h.f
        public void b(View view, bn bnVar, int i, long j) {
            if (bnVar != null) {
                ar arVar = new ar("c13642");
                arVar.v("uid", TbadkApplication.getCurrentAccountId());
                arVar.v("fid", bnVar.getForumId());
                if (a.this.iRe.mFrom != 0) {
                    if (a.this.iRe.mFrom == 1) {
                        arVar.aq("obj_locate", 2);
                        arVar.dR("resource_id", a.this.tabName);
                    }
                } else {
                    arVar.aq("obj_locate", 1);
                    arVar.aq("obj_type", a.this.iRe.akH ? 3 : 1);
                }
                TiebaStatic.log(arVar);
            }
        }
    };
    private View.OnClickListener iRi = new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.tabfeed.view.a.5
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            com.baidu.tieba.enterForum.b.d(a.this.iPR.getPageContext(), a.this.tabName);
            if (a.this.iRe != null) {
                ar arVar = new ar("c13645");
                arVar.v("uid", TbadkApplication.getCurrentAccountId());
                arVar.aq("obj_locate", 1);
                arVar.aq("obj_type", a.this.iRe.akH ? 5 : 1);
                arVar.aq("obj_source", 2);
                TiebaStatic.log(arVar);
            }
        }
    };
    private PullLeftRefreshLayout.a anr = new PullLeftRefreshLayout.a() { // from class: com.baidu.tieba.enterForum.tabfeed.view.a.6
        @Override // com.baidu.tbadk.widget.horizontalpullview.PullLeftRefreshLayout.a
        public void bHa() {
            com.baidu.tieba.enterForum.b.d(a.this.iPR.getPageContext(), a.this.tabName);
            ar arVar = new ar("c13645");
            arVar.v("uid", TbadkApplication.getCurrentAccountId());
            arVar.aq("obj_locate", 1);
            arVar.aq("obj_type", a.this.iRe.akH ? 5 : 1);
            arVar.aq("obj_source", 4);
            TiebaStatic.log(arVar);
        }
    };

    public a(EnterForumTabFeedFragment enterForumTabFeedFragment, com.baidu.tieba.enterForum.tabfeed.b bVar, ViewGroup viewGroup, String str) {
        this.iPR = enterForumTabFeedFragment;
        this.iQO = bVar;
        this.tabName = str;
        bf(viewGroup);
        this.iRg = new com.baidu.tieba.enterForum.tabfeed.a(enterForumTabFeedFragment, this.iPS);
        lU(false);
    }

    private void bf(ViewGroup viewGroup) {
        this.iQZ = viewGroup;
        this.iPS = (BdTypeRecyclerView) viewGroup.findViewById(R.id.tab_feed_recycler_view);
        this.iPS.setLayoutManager(new LinearLayoutManager(this.iPR.getContext()));
        this.iPS.setFadingEdgeLength(0);
        this.iPS.setOverScrollMode(2);
        this.iPS.setOnSrollToBottomListener(this.gXO);
        this.iPS.addOnScrollListener(this.irI);
        this.mPullView = new g(this.iPR.getPageContext());
        this.mPullView.setListPullRefreshListener(this.iQO);
        this.iPS.setRecyclerListener(new RecyclerView.RecyclerListener() { // from class: com.baidu.tieba.enterForum.tabfeed.view.a.7
            @Override // androidx.recyclerview.widget.RecyclerView.RecyclerListener
            public void onViewRecycled(RecyclerView.ViewHolder viewHolder) {
                View view = viewHolder.itemView;
                if (view != null && a.this.iRf != null) {
                    a.this.iRf.dt(view);
                }
            }
        });
        this.gCf = new PbListView(this.iPR.getPageContext().getPageActivity());
        this.gCf.getView();
        this.gCf.setContainerBackgroundColorResId(R.color.CAM_X0205);
        this.gCf.setHeight(l.getDimens(this.iPR.getPageContext().getPageActivity(), R.dimen.tbds182));
        this.gCf.setLineGone();
        this.gCf.setTextSize(R.dimen.tbfontsize33);
        this.gCf.setTextColor(ap.getColor(R.color.CAM_X0107));
        this.gCf.setNoMoreTextColorId(R.color.CAM_X0110);
        this.gCf.bug();
        this.gCf.setOnClickListener(this.iRh);
        if (this.gEz == null) {
            this.gEz = (BdSwipeRefreshLayout) viewGroup.findViewById(R.id.tab_feed_pull_refresh_layout);
            this.gEz.setProgressView(this.mPullView);
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.gEz.getLayoutParams();
            marginLayoutParams.topMargin = UtilHelper.getStatusBarHeight() + l.getDimens(this.iPR.getPageContext().getPageActivity(), R.dimen.tbds219);
            this.gEz.setLayoutParams(marginLayoutParams);
        }
        this.iRa = new bb();
        this.iRb = new SmartBubbleAnimatedView(this.iPR.getContext());
        this.iRb.setLayoutParams(new FrameLayout.LayoutParams(-1, l.getDimens(this.iPR.getContext(), R.dimen.tbds83)));
        if (this.iRf == null) {
            this.iRf = new i(this.iPR.getPageContext(), this.iPS);
            this.iRf.Hr(1);
            this.iRf.setUniqueId(this.iPR.getUniqueId());
        }
        this.iRc = new b(this.iPR.getPageContext());
        this.iRc.setTabName(this.tabName);
    }

    public void b(com.baidu.tieba.enterForum.tabfeed.b.b bVar) {
        if (bVar != null) {
            this.hasMore = bVar.hasMore;
        }
        lU(false);
        if (bVar != null && this.iRg != null && this.iPS != null && this.gCf != null) {
            cxx();
            d(bVar);
            c(bVar);
            if (bVar.iQK > 0) {
                int firstVisiblePosition = this.iPS.getFirstVisiblePosition();
                View childAt = this.iPS.getChildAt(0);
                int top = childAt == null ? 0 : childAt.getTop();
                RecyclerView.LayoutManager layoutManager = this.iPS.getLayoutManager();
                int i = firstVisiblePosition - bVar.iQK;
                if (layoutManager instanceof LinearLayoutManager) {
                    this.iPS.qt();
                    ((LinearLayoutManager) layoutManager).scrollToPositionWithOffset(i, top);
                    this.iPS.qu();
                }
                bVar.iQK = 0;
            }
            this.iRg.setIsFromCDN(bVar.amh);
            this.iRg.setData(bVar.iQJ);
            this.iRg.notifyDataSetChanged();
            if (bVar.gec) {
                xR(bVar.refreshCount);
            }
            if (this.iRf != null) {
                this.iRf.b(this.iPS.getFirstVisiblePosition(), this.iPS.getLastVisiblePosition(), false, true);
            }
        }
    }

    private void cxx() {
        if (this.eIY == null) {
            this.eIY = new TextView(this.iPR.getContext());
            this.eIY.setPadding(l.getDimens(this.iPR.getContext(), R.dimen.tbds44), l.getDimens(this.iPR.getContext(), R.dimen.tbds60), 0, l.getDimens(this.iPR.getContext(), R.dimen.tbds24));
            this.eIY.setText(R.string.tab_feed_title);
            this.eIY.setTextSize(0, l.getDimens(this.iPR.getContext(), R.dimen.tbds46));
            this.eIY.setTypeface(Typeface.DEFAULT_BOLD);
            this.iPS.removeHeaderView(this.eIY);
            this.iPS.addHeaderView(this.eIY, 0);
            ap.setViewTextColor(this.eIY, R.color.CAM_X0105);
        }
    }

    private void c(com.baidu.tieba.enterForum.tabfeed.b.b bVar) {
        if (bVar != null && this.iPS != null && this.iPR != null && bVar.gec) {
            if (!((bVar.iQI == null || y.isEmpty(bVar.iQI.bmY())) ? false : true)) {
                if (this.iRe != null) {
                    this.iPS.removeHeaderView(this.iRe);
                    return;
                }
                return;
            }
            if (this.iRe == null) {
                this.iRe = new RecommendForumLayout(this.iPR.getPageContext());
                this.iRe.setShowMore(true);
                this.iRe.setSquareEntranceAtStart(true);
                this.iRe.setTabName(this.tabName);
                this.iRe.setFrom(1);
            }
            this.iRe.setOnClickRightArrowListener(this.iRi);
            this.iRe.setOnRullOkCallbackr(this.anr);
            this.iRe.setOnItemCoverListener(this.akI);
            this.iRe.b(bVar.iQI);
            this.iPS.removeHeaderView(this.iRe);
            this.iPS.addHeaderView(this.iRe, 0);
            ar arVar = new ar("c13641");
            arVar.v("uid", TbadkApplication.getCurrentAccountId());
            arVar.aq("obj_locate", 2);
            arVar.dR("resource_id", this.tabName);
            TiebaStatic.log(arVar);
        }
    }

    private void d(com.baidu.tieba.enterForum.tabfeed.b.b bVar) {
        if (bVar.iQL != null && bVar.iQL.hot_user != null && bVar.iQL.hot_user.size() > 0 && !TextUtils.isEmpty(bVar.iQL.module_name)) {
            this.iRc.a(bVar.iQL);
            if (this.iRc.getView().getParent() == null && !this.iRd) {
                this.iRd = true;
                this.iPS.addHeaderView(this.iRc.getView(), 0);
                ar arVar = new ar("c13656");
                arVar.v("uid", TbadkApplication.getCurrentAccountId());
                arVar.dR("resource_id", this.tabName);
                TiebaStatic.log(arVar);
                return;
            }
            return;
        }
        this.iRd = false;
        this.iPS.removeHeaderView(this.iRc.getView());
    }

    public void onChangeSkinType(int i) {
        if (this.mPullView != null) {
            this.mPullView.changeSkin(i);
        }
        if (this.gCf != null) {
            this.gCf.setTextColor(ap.getColor(R.color.CAM_X0107));
            this.gCf.changeSkin(i);
        }
        if (this.iRg != null) {
            this.iRg.notifyDataSetChanged();
        }
        if (this.eIY != null) {
            ap.setViewTextColor(this.eIY, R.color.CAM_X0105);
        }
        if (this.iRc != null) {
            this.iRc.onChangeSkinType();
        }
        if (this.iRe != null) {
            this.iRe.onChangeSkinType();
        }
        if (this.iRb != null) {
            this.iRb.onChangeSkinType(i);
        }
    }

    public void resume() {
        if (this.iRf != null) {
            this.iRf.tN(true);
            if (this.iPS != null) {
                this.iRf.b(this.iPS.getFirstVisiblePosition(), this.iPS.getLastVisiblePosition(), false, true);
            }
        }
    }

    public void pause() {
        if (this.iRf != null) {
            this.iRf.dcS();
            this.iRf.tN(false);
        }
    }

    public void cxy() {
        if (this.iPS != null) {
            this.iPS.scrollToPosition(0);
        }
    }

    public void lU(boolean z) {
        if (this.gEz != null) {
            this.gEz.setRefreshing(z);
        }
    }

    public void qc(boolean z) {
        if (this.gEz != null) {
            this.gEz.setVisibility(z ? 0 : 8);
        }
    }

    public boolean cxz() {
        return this.iPS == null || this.iPS.getChildCount() == 0 || this.iPS.getChildAt(0).getTop() == 0;
    }

    private void xR(int i) {
        String string;
        if (i >= 0) {
            this.iRa.cFd();
            if (i > 0) {
                string = String.format(TbadkCoreApplication.getInst().getString(R.string.recommend_frs_refresh_return), Integer.valueOf(i));
            } else {
                string = TbadkCoreApplication.getInst().getString(R.string.recommend_frs_refresh_nodata);
            }
            if (!TextUtils.isEmpty(string) && j.isNetWorkAvailable()) {
                this.iRb.fll = string;
                this.iRb.jng = 2000L;
                FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
                layoutParams.gravity = 49;
                layoutParams.topMargin = UtilHelper.getStatusBarHeight() + l.getDimens(this.iPR.getPageContext().getPageActivity(), R.dimen.tbds228);
                if (this.iQZ != null) {
                    this.iQZ.removeView(this.iRb);
                    this.iQZ.addView(this.iRb, layoutParams);
                    this.iRb.cFb();
                }
            }
        }
    }

    public void cj(int i, int i2) {
        if (this.iPS != null && i < i2) {
            this.iPS.p(i, i2);
        }
    }
}
