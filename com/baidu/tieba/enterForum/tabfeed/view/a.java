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
    private PbListView gre;
    private BdSwipeRefreshLayout gty;
    private boolean hasMore;
    private EnterForumTabFeedFragment iAF;
    private BdTypeRecyclerView iAG;
    private com.baidu.tieba.enterForum.tabfeed.b iBC;
    private ViewGroup iBN;
    private be iBO;
    private SmartBubbleAnimatedView iBP;
    private b iBQ;
    private boolean iBR;
    private RecommendForumLayout iBS;
    private i iBT;
    private com.baidu.tieba.enterForum.tabfeed.a iBU;
    private g mPullView;
    private String tabName;
    private BdListView.e gLZ = new BdListView.e() { // from class: com.baidu.tieba.enterForum.tabfeed.view.a.1
        @Override // com.baidu.adp.widget.ListView.BdListView.e
        public void onScrollToBottom() {
            if (a.this.iAG != null) {
                a.this.iAG.stopScroll();
            }
            if (a.this.gre != null && a.this.iBC != null) {
                if (j.isNetWorkAvailable()) {
                    a.this.iAG.setNextPage(a.this.gre);
                    a.this.gre.showEmptyView(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
                    a.this.gre.setOnClickListener(null);
                    if (a.this.hasMore) {
                        a.this.gre.showLoading();
                        a.this.iBC.cwJ();
                        return;
                    }
                    a.this.gre.setText(a.this.iAF.getResources().getString(R.string.list_has_no_more));
                    a.this.gre.endLoadData();
                    return;
                }
                a.this.iAG.setNextPage(null);
            }
        }
    };
    private RecyclerView.OnScrollListener ick = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.enterForum.tabfeed.view.a.2
        private boolean fbI;

        @Override // android.support.v7.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i) {
            if (i == 0) {
                if (a.this.iBT != null) {
                    a.this.iBT.a(a.this.iAG.getFirstVisiblePosition(), a.this.iAG.getLastVisiblePosition(), this.fbI, true);
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001630, Boolean.valueOf(a.this.cwX() ? false : true)));
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
    private View.OnClickListener iBV = new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.tabfeed.view.a.3
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (a.this.iAG != null) {
                a.this.iAG.stopScroll();
            }
            if (a.this.gre != null && a.this.iBC != null && j.isNetWorkAvailable()) {
                a.this.gre.showEmptyView(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
                a.this.gre.setOnClickListener(null);
                if (a.this.hasMore) {
                    a.this.gre.showLoading();
                    a.this.iBC.cwJ();
                }
            }
        }
    };
    private f ajQ = new f<bk>() { // from class: com.baidu.tieba.enterForum.tabfeed.view.a.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tbadk.h.f
        public void a(View view, bk bkVar, int i, long j) {
            if (bkVar == null) {
                com.baidu.tieba.enterForum.b.d(a.this.iAF.getPageContext(), a.this.tabName);
                if (a.this.iBS != null) {
                    ar arVar = new ar("c13645");
                    arVar.w("uid", TbadkApplication.getCurrentAccountId());
                    arVar.al("obj_locate", 1);
                    arVar.al("obj_type", a.this.iBS.ajP ? 5 : 1);
                    arVar.al("obj_source", 5);
                    TiebaStatic.log(arVar);
                }
            } else if (bkVar != null && a.this.iAF != null) {
                String forumName = bkVar.getForumName();
                if (au.isForumName(forumName)) {
                    a.this.iAF.sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(a.this.iAF.getFragmentActivity()).createNormalCfg(forumName, FrsActivityConfig.FRS_FROM_ENTERFORUM_RECOMMEND).setCallFrom(3)));
                    if (a.this.iBS != null) {
                        ar arVar2 = new ar("c13643");
                        arVar2.w("uid", TbadkApplication.getCurrentAccountId());
                        arVar2.w("fid", bkVar.getForumId());
                        if (a.this.iBS.mFrom != 0) {
                            if (a.this.iBS.mFrom == 1) {
                                arVar2.al("obj_locate", 2);
                                arVar2.dY("resource_id", a.this.tabName);
                            }
                        } else {
                            arVar2.al("obj_locate", 1);
                            arVar2.al("obj_type", a.this.iBS.ajP ? 4 : 1);
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
                if (a.this.iBS.mFrom != 0) {
                    if (a.this.iBS.mFrom == 1) {
                        arVar.al("obj_locate", 2);
                        arVar.dY("resource_id", a.this.tabName);
                    }
                } else {
                    arVar.al("obj_locate", 1);
                    arVar.al("obj_type", a.this.iBS.ajP ? 3 : 1);
                }
                TiebaStatic.log(arVar);
            }
        }
    };
    private View.OnClickListener iBW = new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.tabfeed.view.a.5
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            com.baidu.tieba.enterForum.b.d(a.this.iAF.getPageContext(), a.this.tabName);
            if (a.this.iBS != null) {
                ar arVar = new ar("c13645");
                arVar.w("uid", TbadkApplication.getCurrentAccountId());
                arVar.al("obj_locate", 1);
                arVar.al("obj_type", a.this.iBS.ajP ? 5 : 1);
                arVar.al("obj_source", 2);
                TiebaStatic.log(arVar);
            }
        }
    };
    private PullLeftRefreshLayout.a amx = new PullLeftRefreshLayout.a() { // from class: com.baidu.tieba.enterForum.tabfeed.view.a.6
        @Override // com.baidu.tbadk.widget.horizontalpullview.PullLeftRefreshLayout.a
        public void bHZ() {
            com.baidu.tieba.enterForum.b.d(a.this.iAF.getPageContext(), a.this.tabName);
            ar arVar = new ar("c13645");
            arVar.w("uid", TbadkApplication.getCurrentAccountId());
            arVar.al("obj_locate", 1);
            arVar.al("obj_type", a.this.iBS.ajP ? 5 : 1);
            arVar.al("obj_source", 4);
            TiebaStatic.log(arVar);
        }
    };

    public a(EnterForumTabFeedFragment enterForumTabFeedFragment, com.baidu.tieba.enterForum.tabfeed.b bVar, ViewGroup viewGroup, String str) {
        this.iAF = enterForumTabFeedFragment;
        this.iBC = bVar;
        this.tabName = str;
        aT(viewGroup);
        this.iBU = new com.baidu.tieba.enterForum.tabfeed.a(enterForumTabFeedFragment, this.iAG);
        lx(false);
    }

    private void aT(ViewGroup viewGroup) {
        this.iBN = viewGroup;
        this.iAG = (BdTypeRecyclerView) viewGroup.findViewById(R.id.tab_feed_recycler_view);
        this.iAG.setLayoutManager(new LinearLayoutManager(this.iAF.getContext()));
        this.iAG.setFadingEdgeLength(0);
        this.iAG.setOverScrollMode(2);
        this.iAG.setOnSrollToBottomListener(this.gLZ);
        this.iAG.addOnScrollListener(this.ick);
        this.mPullView = new g(this.iAF.getPageContext());
        this.mPullView.setListPullRefreshListener(this.iBC);
        this.iAG.setRecyclerListener(new RecyclerView.RecyclerListener() { // from class: com.baidu.tieba.enterForum.tabfeed.view.a.7
            @Override // android.support.v7.widget.RecyclerView.RecyclerListener
            public void onViewRecycled(RecyclerView.ViewHolder viewHolder) {
                View view = viewHolder.itemView;
                if (view != null && a.this.iBT != null) {
                    a.this.iBT.dl(view);
                }
            }
        });
        this.gre = new PbListView(this.iAF.getPageContext().getPageActivity());
        this.gre.getView();
        this.gre.setContainerBackgroundColorResId(R.color.CAM_X0205);
        this.gre.setHeight(l.getDimens(this.iAF.getPageContext().getPageActivity(), R.dimen.tbds182));
        this.gre.setLineGone();
        this.gre.setTextSize(R.dimen.tbfontsize33);
        this.gre.setTextColor(ap.getColor(R.color.CAM_X0107));
        this.gre.setNoMoreTextColorId(R.color.CAM_X0110);
        this.gre.bvh();
        this.gre.setOnClickListener(this.iBV);
        if (this.gty == null) {
            this.gty = (BdSwipeRefreshLayout) viewGroup.findViewById(R.id.tab_feed_pull_refresh_layout);
            this.gty.setProgressView(this.mPullView);
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.gty.getLayoutParams();
            marginLayoutParams.topMargin = UtilHelper.getStatusBarHeight() + l.getDimens(this.iAF.getPageContext().getPageActivity(), R.dimen.tbds219);
            this.gty.setLayoutParams(marginLayoutParams);
        }
        this.iBO = new be();
        this.iBP = new SmartBubbleAnimatedView(this.iAF.getContext());
        this.iBP.setLayoutParams(new FrameLayout.LayoutParams(-1, l.getDimens(this.iAF.getContext(), R.dimen.tbds83)));
        if (this.iBT == null) {
            this.iBT = new i(this.iAF.getPageContext(), this.iAG);
            this.iBT.IJ(1);
            this.iBT.setUniqueId(this.iAF.getUniqueId());
        }
        this.iBQ = new b(this.iAF.getPageContext());
        this.iBQ.setTabName(this.tabName);
    }

    public void b(com.baidu.tieba.enterForum.tabfeed.b.b bVar) {
        if (bVar != null) {
            this.hasMore = bVar.hasMore;
        }
        lx(false);
        if (bVar != null && this.iBU != null && this.iAG != null && this.gre != null) {
            cwV();
            d(bVar);
            c(bVar);
            if (bVar.iBy > 0) {
                int firstVisiblePosition = this.iAG.getFirstVisiblePosition();
                View childAt = this.iAG.getChildAt(0);
                int top = childAt == null ? 0 : childAt.getTop();
                RecyclerView.LayoutManager layoutManager = this.iAG.getLayoutManager();
                int i = firstVisiblePosition - bVar.iBy;
                if (layoutManager instanceof LinearLayoutManager) {
                    this.iAG.qT();
                    ((LinearLayoutManager) layoutManager).scrollToPositionWithOffset(i, top);
                    this.iAG.qU();
                }
                bVar.iBy = 0;
            }
            this.iBU.setIsFromCDN(bVar.alo);
            this.iBU.setData(bVar.iBx);
            this.iBU.notifyDataSetChanged();
            if (bVar.fVi) {
                yZ(bVar.refreshCount);
            }
            if (this.iBT != null) {
                this.iBT.a(this.iAG.getFirstVisiblePosition(), this.iAG.getLastVisiblePosition(), false, true);
            }
        }
    }

    private void cwV() {
        if (this.eAz == null) {
            this.eAz = new TextView(this.iAF.getContext());
            this.eAz.setPadding(l.getDimens(this.iAF.getContext(), R.dimen.tbds44), l.getDimens(this.iAF.getContext(), R.dimen.tbds60), 0, l.getDimens(this.iAF.getContext(), R.dimen.tbds24));
            this.eAz.setText(R.string.tab_feed_title);
            this.eAz.setTextSize(0, l.getDimens(this.iAF.getContext(), R.dimen.tbds46));
            this.eAz.setTypeface(Typeface.DEFAULT_BOLD);
            this.iAG.removeHeaderView(this.eAz);
            this.iAG.addHeaderView(this.eAz, 0);
            ap.setViewTextColor(this.eAz, R.color.CAM_X0105);
        }
    }

    private void c(com.baidu.tieba.enterForum.tabfeed.b.b bVar) {
        if (bVar != null && this.iAG != null && this.iAF != null && bVar.fVi) {
            if (!((bVar.iBw == null || y.isEmpty(bVar.iBw.bnV())) ? false : true)) {
                if (this.iBS != null) {
                    this.iAG.removeHeaderView(this.iBS);
                    return;
                }
                return;
            }
            if (this.iBS == null) {
                this.iBS = new RecommendForumLayout(this.iAF.getPageContext());
                this.iBS.setShowMore(true);
                this.iBS.setSquareEntranceAtStart(true);
                this.iBS.setTabName(this.tabName);
                this.iBS.setFrom(1);
            }
            this.iBS.setOnClickRightArrowListener(this.iBW);
            this.iBS.setOnRullOkCallbackr(this.amx);
            this.iBS.setOnItemCoverListener(this.ajQ);
            this.iBS.b(bVar.iBw);
            this.iAG.removeHeaderView(this.iBS);
            this.iAG.addHeaderView(this.iBS, 0);
            ar arVar = new ar("c13641");
            arVar.w("uid", TbadkApplication.getCurrentAccountId());
            arVar.al("obj_locate", 2);
            arVar.dY("resource_id", this.tabName);
            TiebaStatic.log(arVar);
        }
    }

    private void d(com.baidu.tieba.enterForum.tabfeed.b.b bVar) {
        if (bVar.iBz != null && bVar.iBz.hot_user != null && bVar.iBz.hot_user.size() > 0 && !TextUtils.isEmpty(bVar.iBz.module_name)) {
            this.iBQ.a(bVar.iBz);
            if (this.iBQ.getView().getParent() == null && !this.iBR) {
                this.iBR = true;
                this.iAG.addHeaderView(this.iBQ.getView(), 0);
                ar arVar = new ar("c13656");
                arVar.w("uid", TbadkApplication.getCurrentAccountId());
                arVar.dY("resource_id", this.tabName);
                TiebaStatic.log(arVar);
                return;
            }
            return;
        }
        this.iBR = false;
        this.iAG.removeHeaderView(this.iBQ.getView());
    }

    public void onChangeSkinType(int i) {
        if (this.mPullView != null) {
            this.mPullView.changeSkin(i);
        }
        if (this.gre != null) {
            this.gre.setTextColor(ap.getColor(R.color.CAM_X0107));
            this.gre.changeSkin(i);
        }
        if (this.iBU != null) {
            this.iBU.notifyDataSetChanged();
        }
        if (this.eAz != null) {
            ap.setViewTextColor(this.eAz, R.color.CAM_X0105);
        }
        if (this.iBQ != null) {
            this.iBQ.onChangeSkinType();
        }
        if (this.iBS != null) {
            this.iBS.onChangeSkinType();
        }
        if (this.iBP != null) {
            this.iBP.onChangeSkinType(i);
        }
    }

    public void resume() {
        if (this.iBT != null) {
            this.iBT.tC(true);
            if (this.iAG != null) {
                this.iBT.a(this.iAG.getFirstVisiblePosition(), this.iAG.getLastVisiblePosition(), false, true);
            }
        }
    }

    public void pause() {
        if (this.iBT != null) {
            this.iBT.deJ();
            this.iBT.tC(false);
        }
    }

    public void cwW() {
        if (this.iAG != null) {
            this.iAG.scrollToPosition(0);
        }
    }

    public void lx(boolean z) {
        if (this.gty != null) {
            this.gty.setRefreshing(z);
        }
    }

    public void pz(boolean z) {
        if (this.gty != null) {
            this.gty.setVisibility(z ? 0 : 8);
        }
    }

    public boolean cwX() {
        return this.iAG == null || this.iAG.getChildCount() == 0 || this.iAG.getChildAt(0).getTop() == 0;
    }

    private void yZ(int i) {
        String string;
        if (i >= 0) {
            this.iBO.cEz();
            if (i > 0) {
                string = String.format(TbadkCoreApplication.getInst().getString(R.string.recommend_frs_refresh_return), Integer.valueOf(i));
            } else {
                string = TbadkCoreApplication.getInst().getString(R.string.recommend_frs_refresh_nodata);
            }
            if (!TextUtils.isEmpty(string) && j.isNetWorkAvailable()) {
                this.iBP.fcw = string;
                this.iBP.iXT = 2000L;
                FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
                layoutParams.gravity = 49;
                layoutParams.topMargin = UtilHelper.getStatusBarHeight() + l.getDimens(this.iAF.getPageContext().getPageActivity(), R.dimen.tbds228);
                if (this.iBN != null) {
                    this.iBN.removeView(this.iBP);
                    this.iBN.addView(this.iBP, layoutParams);
                    this.iBP.cEx();
                }
            }
        }
    }

    public void cm(int i, int i2) {
        if (this.iAG != null && i < i2) {
            this.iAG.p(i, i2);
        }
    }
}
