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
import com.baidu.tbadk.core.data.bk;
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
import com.baidu.tieba.frs.be;
import com.baidu.tieba.play.i;
/* loaded from: classes22.dex */
public class a {
    private TextView eAz;
    private PbListView grg;
    private BdSwipeRefreshLayout gtA;
    private boolean hasMore;
    private EnterForumTabFeedFragment iAH;
    private BdTypeRecyclerView iAI;
    private com.baidu.tieba.enterForum.tabfeed.b iBE;
    private ViewGroup iBP;
    private be iBQ;
    private SmartBubbleAnimatedView iBR;
    private b iBS;
    private boolean iBT;
    private RecommendForumLayout iBU;
    private i iBV;
    private com.baidu.tieba.enterForum.tabfeed.a iBW;
    private g mPullView;
    private String tabName;
    private BdListView.e gMb = new BdListView.e() { // from class: com.baidu.tieba.enterForum.tabfeed.view.a.1
        @Override // com.baidu.adp.widget.ListView.BdListView.e
        public void onScrollToBottom() {
            if (a.this.iAI != null) {
                a.this.iAI.stopScroll();
            }
            if (a.this.grg != null && a.this.iBE != null) {
                if (j.isNetWorkAvailable()) {
                    a.this.iAI.setNextPage(a.this.grg);
                    a.this.grg.showEmptyView(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
                    a.this.grg.setOnClickListener(null);
                    if (a.this.hasMore) {
                        a.this.grg.showLoading();
                        a.this.iBE.cwK();
                        return;
                    }
                    a.this.grg.setText(a.this.iAH.getResources().getString(R.string.list_has_no_more));
                    a.this.grg.endLoadData();
                    return;
                }
                a.this.iAI.setNextPage(null);
            }
        }
    };
    private RecyclerView.OnScrollListener icm = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.enterForum.tabfeed.view.a.2
        private boolean fbI;

        @Override // android.support.v7.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i) {
            if (i == 0) {
                if (a.this.iBV != null) {
                    a.this.iBV.a(a.this.iAI.getFirstVisiblePosition(), a.this.iAI.getLastVisiblePosition(), this.fbI, true);
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001630, Boolean.valueOf(a.this.cwY() ? false : true)));
            }
        }

        @Override // android.support.v7.widget.RecyclerView.OnScrollListener
        public void onScrolled(RecyclerView recyclerView, int i, int i2) {
            super.onScrolled(recyclerView, i, i2);
            if (i2 > 0) {
                this.fbI = false;
            } else {
                this.fbI = true;
            }
        }
    };
    private View.OnClickListener iBX = new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.tabfeed.view.a.3
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (a.this.iAI != null) {
                a.this.iAI.stopScroll();
            }
            if (a.this.grg != null && a.this.iBE != null && j.isNetWorkAvailable()) {
                a.this.grg.showEmptyView(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
                a.this.grg.setOnClickListener(null);
                if (a.this.hasMore) {
                    a.this.grg.showLoading();
                    a.this.iBE.cwK();
                }
            }
        }
    };
    private f ajQ = new f<bk>() { // from class: com.baidu.tieba.enterForum.tabfeed.view.a.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tbadk.h.f
        public void a(View view, bk bkVar, int i, long j) {
            if (bkVar == null) {
                com.baidu.tieba.enterForum.b.d(a.this.iAH.getPageContext(), a.this.tabName);
                if (a.this.iBU != null) {
                    ar arVar = new ar("c13645");
                    arVar.w("uid", TbadkApplication.getCurrentAccountId());
                    arVar.al("obj_locate", 1);
                    arVar.al("obj_type", a.this.iBU.ajP ? 5 : 1);
                    arVar.al("obj_source", 5);
                    TiebaStatic.log(arVar);
                }
            } else if (bkVar != null && a.this.iAH != null) {
                String forumName = bkVar.getForumName();
                if (au.isForumName(forumName)) {
                    a.this.iAH.sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(a.this.iAH.getFragmentActivity()).createNormalCfg(forumName, FrsActivityConfig.FRS_FROM_ENTERFORUM_RECOMMEND).setCallFrom(3)));
                    if (a.this.iBU != null) {
                        ar arVar2 = new ar("c13643");
                        arVar2.w("uid", TbadkApplication.getCurrentAccountId());
                        arVar2.w("fid", bkVar.getForumId());
                        if (a.this.iBU.mFrom != 0) {
                            if (a.this.iBU.mFrom == 1) {
                                arVar2.al("obj_locate", 2);
                                arVar2.dY("resource_id", a.this.tabName);
                            }
                        } else {
                            arVar2.al("obj_locate", 1);
                            arVar2.al("obj_type", a.this.iBU.ajP ? 4 : 1);
                        }
                        TiebaStatic.log(arVar2);
                    }
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tbadk.h.f
        public void b(View view, bk bkVar, int i, long j) {
            if (bkVar != null) {
                ar arVar = new ar("c13642");
                arVar.w("uid", TbadkApplication.getCurrentAccountId());
                arVar.w("fid", bkVar.getForumId());
                if (a.this.iBU.mFrom != 0) {
                    if (a.this.iBU.mFrom == 1) {
                        arVar.al("obj_locate", 2);
                        arVar.dY("resource_id", a.this.tabName);
                    }
                } else {
                    arVar.al("obj_locate", 1);
                    arVar.al("obj_type", a.this.iBU.ajP ? 3 : 1);
                }
                TiebaStatic.log(arVar);
            }
        }
    };
    private View.OnClickListener iBY = new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.tabfeed.view.a.5
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            com.baidu.tieba.enterForum.b.d(a.this.iAH.getPageContext(), a.this.tabName);
            if (a.this.iBU != null) {
                ar arVar = new ar("c13645");
                arVar.w("uid", TbadkApplication.getCurrentAccountId());
                arVar.al("obj_locate", 1);
                arVar.al("obj_type", a.this.iBU.ajP ? 5 : 1);
                arVar.al("obj_source", 2);
                TiebaStatic.log(arVar);
            }
        }
    };
    private PullLeftRefreshLayout.a amx = new PullLeftRefreshLayout.a() { // from class: com.baidu.tieba.enterForum.tabfeed.view.a.6
        @Override // com.baidu.tbadk.widget.horizontalpullview.PullLeftRefreshLayout.a
        public void bHZ() {
            com.baidu.tieba.enterForum.b.d(a.this.iAH.getPageContext(), a.this.tabName);
            ar arVar = new ar("c13645");
            arVar.w("uid", TbadkApplication.getCurrentAccountId());
            arVar.al("obj_locate", 1);
            arVar.al("obj_type", a.this.iBU.ajP ? 5 : 1);
            arVar.al("obj_source", 4);
            TiebaStatic.log(arVar);
        }
    };

    public a(EnterForumTabFeedFragment enterForumTabFeedFragment, com.baidu.tieba.enterForum.tabfeed.b bVar, ViewGroup viewGroup, String str) {
        this.iAH = enterForumTabFeedFragment;
        this.iBE = bVar;
        this.tabName = str;
        aT(viewGroup);
        this.iBW = new com.baidu.tieba.enterForum.tabfeed.a(enterForumTabFeedFragment, this.iAI);
        lx(false);
    }

    private void aT(ViewGroup viewGroup) {
        this.iBP = viewGroup;
        this.iAI = (BdTypeRecyclerView) viewGroup.findViewById(R.id.tab_feed_recycler_view);
        this.iAI.setLayoutManager(new LinearLayoutManager(this.iAH.getContext()));
        this.iAI.setFadingEdgeLength(0);
        this.iAI.setOverScrollMode(2);
        this.iAI.setOnSrollToBottomListener(this.gMb);
        this.iAI.addOnScrollListener(this.icm);
        this.mPullView = new g(this.iAH.getPageContext());
        this.mPullView.setListPullRefreshListener(this.iBE);
        this.iAI.setRecyclerListener(new RecyclerView.RecyclerListener() { // from class: com.baidu.tieba.enterForum.tabfeed.view.a.7
            @Override // android.support.v7.widget.RecyclerView.RecyclerListener
            public void onViewRecycled(RecyclerView.ViewHolder viewHolder) {
                View view = viewHolder.itemView;
                if (view != null && a.this.iBV != null) {
                    a.this.iBV.dl(view);
                }
            }
        });
        this.grg = new PbListView(this.iAH.getPageContext().getPageActivity());
        this.grg.getView();
        this.grg.setContainerBackgroundColorResId(R.color.CAM_X0205);
        this.grg.setHeight(l.getDimens(this.iAH.getPageContext().getPageActivity(), R.dimen.tbds182));
        this.grg.setLineGone();
        this.grg.setTextSize(R.dimen.tbfontsize33);
        this.grg.setTextColor(ap.getColor(R.color.CAM_X0107));
        this.grg.setNoMoreTextColorId(R.color.CAM_X0110);
        this.grg.bvh();
        this.grg.setOnClickListener(this.iBX);
        if (this.gtA == null) {
            this.gtA = (BdSwipeRefreshLayout) viewGroup.findViewById(R.id.tab_feed_pull_refresh_layout);
            this.gtA.setProgressView(this.mPullView);
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.gtA.getLayoutParams();
            marginLayoutParams.topMargin = UtilHelper.getStatusBarHeight() + l.getDimens(this.iAH.getPageContext().getPageActivity(), R.dimen.tbds219);
            this.gtA.setLayoutParams(marginLayoutParams);
        }
        this.iBQ = new be();
        this.iBR = new SmartBubbleAnimatedView(this.iAH.getContext());
        this.iBR.setLayoutParams(new FrameLayout.LayoutParams(-1, l.getDimens(this.iAH.getContext(), R.dimen.tbds83)));
        if (this.iBV == null) {
            this.iBV = new i(this.iAH.getPageContext(), this.iAI);
            this.iBV.IJ(1);
            this.iBV.setUniqueId(this.iAH.getUniqueId());
        }
        this.iBS = new b(this.iAH.getPageContext());
        this.iBS.setTabName(this.tabName);
    }

    public void b(com.baidu.tieba.enterForum.tabfeed.b.b bVar) {
        if (bVar != null) {
            this.hasMore = bVar.hasMore;
        }
        lx(false);
        if (bVar != null && this.iBW != null && this.iAI != null && this.grg != null) {
            cwW();
            d(bVar);
            c(bVar);
            if (bVar.iBA > 0) {
                int firstVisiblePosition = this.iAI.getFirstVisiblePosition();
                View childAt = this.iAI.getChildAt(0);
                int top = childAt == null ? 0 : childAt.getTop();
                RecyclerView.LayoutManager layoutManager = this.iAI.getLayoutManager();
                int i = firstVisiblePosition - bVar.iBA;
                if (layoutManager instanceof LinearLayoutManager) {
                    this.iAI.qT();
                    ((LinearLayoutManager) layoutManager).scrollToPositionWithOffset(i, top);
                    this.iAI.qU();
                }
                bVar.iBA = 0;
            }
            this.iBW.setIsFromCDN(bVar.alo);
            this.iBW.setData(bVar.iBz);
            this.iBW.notifyDataSetChanged();
            if (bVar.fVi) {
                yZ(bVar.refreshCount);
            }
            if (this.iBV != null) {
                this.iBV.a(this.iAI.getFirstVisiblePosition(), this.iAI.getLastVisiblePosition(), false, true);
            }
        }
    }

    private void cwW() {
        if (this.eAz == null) {
            this.eAz = new TextView(this.iAH.getContext());
            this.eAz.setPadding(l.getDimens(this.iAH.getContext(), R.dimen.tbds44), l.getDimens(this.iAH.getContext(), R.dimen.tbds60), 0, l.getDimens(this.iAH.getContext(), R.dimen.tbds24));
            this.eAz.setText(R.string.tab_feed_title);
            this.eAz.setTextSize(0, l.getDimens(this.iAH.getContext(), R.dimen.tbds46));
            this.eAz.setTypeface(Typeface.DEFAULT_BOLD);
            this.iAI.removeHeaderView(this.eAz);
            this.iAI.addHeaderView(this.eAz, 0);
            ap.setViewTextColor(this.eAz, R.color.CAM_X0105);
        }
    }

    private void c(com.baidu.tieba.enterForum.tabfeed.b.b bVar) {
        if (bVar != null && this.iAI != null && this.iAH != null && bVar.fVi) {
            if (!((bVar.iBy == null || y.isEmpty(bVar.iBy.bnV())) ? false : true)) {
                if (this.iBU != null) {
                    this.iAI.removeHeaderView(this.iBU);
                    return;
                }
                return;
            }
            if (this.iBU == null) {
                this.iBU = new RecommendForumLayout(this.iAH.getPageContext());
                this.iBU.setShowMore(true);
                this.iBU.setSquareEntranceAtStart(true);
                this.iBU.setTabName(this.tabName);
                this.iBU.setFrom(1);
            }
            this.iBU.setOnClickRightArrowListener(this.iBY);
            this.iBU.setOnRullOkCallbackr(this.amx);
            this.iBU.setOnItemCoverListener(this.ajQ);
            this.iBU.b(bVar.iBy);
            this.iAI.removeHeaderView(this.iBU);
            this.iAI.addHeaderView(this.iBU, 0);
            ar arVar = new ar("c13641");
            arVar.w("uid", TbadkApplication.getCurrentAccountId());
            arVar.al("obj_locate", 2);
            arVar.dY("resource_id", this.tabName);
            TiebaStatic.log(arVar);
        }
    }

    private void d(com.baidu.tieba.enterForum.tabfeed.b.b bVar) {
        if (bVar.iBB != null && bVar.iBB.hot_user != null && bVar.iBB.hot_user.size() > 0 && !TextUtils.isEmpty(bVar.iBB.module_name)) {
            this.iBS.a(bVar.iBB);
            if (this.iBS.getView().getParent() == null && !this.iBT) {
                this.iBT = true;
                this.iAI.addHeaderView(this.iBS.getView(), 0);
                ar arVar = new ar("c13656");
                arVar.w("uid", TbadkApplication.getCurrentAccountId());
                arVar.dY("resource_id", this.tabName);
                TiebaStatic.log(arVar);
                return;
            }
            return;
        }
        this.iBT = false;
        this.iAI.removeHeaderView(this.iBS.getView());
    }

    public void onChangeSkinType(int i) {
        if (this.mPullView != null) {
            this.mPullView.changeSkin(i);
        }
        if (this.grg != null) {
            this.grg.setTextColor(ap.getColor(R.color.CAM_X0107));
            this.grg.changeSkin(i);
        }
        if (this.iBW != null) {
            this.iBW.notifyDataSetChanged();
        }
        if (this.eAz != null) {
            ap.setViewTextColor(this.eAz, R.color.CAM_X0105);
        }
        if (this.iBS != null) {
            this.iBS.onChangeSkinType();
        }
        if (this.iBU != null) {
            this.iBU.onChangeSkinType();
        }
        if (this.iBR != null) {
            this.iBR.onChangeSkinType(i);
        }
    }

    public void resume() {
        if (this.iBV != null) {
            this.iBV.tC(true);
            if (this.iAI != null) {
                this.iBV.a(this.iAI.getFirstVisiblePosition(), this.iAI.getLastVisiblePosition(), false, true);
            }
        }
    }

    public void pause() {
        if (this.iBV != null) {
            this.iBV.deK();
            this.iBV.tC(false);
        }
    }

    public void cwX() {
        if (this.iAI != null) {
            this.iAI.scrollToPosition(0);
        }
    }

    public void lx(boolean z) {
        if (this.gtA != null) {
            this.gtA.setRefreshing(z);
        }
    }

    public void pz(boolean z) {
        if (this.gtA != null) {
            this.gtA.setVisibility(z ? 0 : 8);
        }
    }

    public boolean cwY() {
        return this.iAI == null || this.iAI.getChildCount() == 0 || this.iAI.getChildAt(0).getTop() == 0;
    }

    private void yZ(int i) {
        String string;
        if (i >= 0) {
            this.iBQ.cEA();
            if (i > 0) {
                string = String.format(TbadkCoreApplication.getInst().getString(R.string.recommend_frs_refresh_return), Integer.valueOf(i));
            } else {
                string = TbadkCoreApplication.getInst().getString(R.string.recommend_frs_refresh_nodata);
            }
            if (!TextUtils.isEmpty(string) && j.isNetWorkAvailable()) {
                this.iBR.fcw = string;
                this.iBR.iXV = 2000L;
                FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
                layoutParams.gravity = 49;
                layoutParams.topMargin = UtilHelper.getStatusBarHeight() + l.getDimens(this.iAH.getPageContext().getPageActivity(), R.dimen.tbds228);
                if (this.iBP != null) {
                    this.iBP.removeView(this.iBR);
                    this.iBP.addView(this.iBR, layoutParams);
                    this.iBR.cEy();
                }
            }
        }
    }

    public void cm(int i, int i2) {
        if (this.iAI != null && i < i2) {
            this.iAI.p(i, i2);
        }
    }
}
