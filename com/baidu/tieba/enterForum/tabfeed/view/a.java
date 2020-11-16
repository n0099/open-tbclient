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
import com.baidu.tbadk.core.data.bj;
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
/* loaded from: classes21.dex */
public class a {
    private TextView etx;
    private PbListView giV;
    private BdSwipeRefreshLayout glp;
    private boolean hasMore;
    private EnterForumTabFeedFragment ipN;
    private BdTypeRecyclerView ipO;
    private com.baidu.tieba.enterForum.tabfeed.b iqK;
    private ViewGroup iqV;
    private be iqW;
    private SmartBubbleAnimatedView iqX;
    private b iqY;
    private boolean iqZ;
    private RecommendForumLayout ira;
    private i irb;
    private com.baidu.tieba.enterForum.tabfeed.a irc;
    private g mPullView;
    private String tabName;
    private BdListView.e gDc = new BdListView.e() { // from class: com.baidu.tieba.enterForum.tabfeed.view.a.1
        @Override // com.baidu.adp.widget.ListView.BdListView.e
        public void onScrollToBottom() {
            if (a.this.ipO != null) {
                a.this.ipO.stopScroll();
            }
            if (a.this.giV != null && a.this.iqK != null) {
                if (j.isNetWorkAvailable()) {
                    a.this.ipO.setNextPage(a.this.giV);
                    a.this.giV.showEmptyView(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
                    a.this.giV.setOnClickListener(null);
                    if (a.this.hasMore) {
                        a.this.giV.showLoading();
                        a.this.iqK.csu();
                        return;
                    }
                    a.this.giV.setText(a.this.ipN.getResources().getString(R.string.list_has_no_more));
                    a.this.giV.endLoadData();
                    return;
                }
                a.this.ipO.setNextPage(null);
            }
        }
    };
    private RecyclerView.OnScrollListener hRq = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.enterForum.tabfeed.view.a.2
        private boolean eUl;

        @Override // android.support.v7.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i) {
            if (i == 0) {
                if (a.this.irb != null) {
                    a.this.irb.a(a.this.ipO.getFirstVisiblePosition(), a.this.ipO.getLastVisiblePosition(), this.eUl, true);
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001630, Boolean.valueOf(a.this.csI() ? false : true)));
            }
        }

        @Override // android.support.v7.widget.RecyclerView.OnScrollListener
        public void onScrolled(RecyclerView recyclerView, int i, int i2) {
            super.onScrolled(recyclerView, i, i2);
            if (i2 > 0) {
                this.eUl = false;
            } else {
                this.eUl = true;
            }
        }
    };
    private View.OnClickListener ird = new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.tabfeed.view.a.3
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (a.this.ipO != null) {
                a.this.ipO.stopScroll();
            }
            if (a.this.giV != null && a.this.iqK != null && j.isNetWorkAvailable()) {
                a.this.giV.showEmptyView(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
                a.this.giV.setOnClickListener(null);
                if (a.this.hasMore) {
                    a.this.giV.showLoading();
                    a.this.iqK.csu();
                }
            }
        }
    };
    private f aiR = new f<bj>() { // from class: com.baidu.tieba.enterForum.tabfeed.view.a.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tbadk.h.f
        public void a(View view, bj bjVar, int i, long j) {
            if (bjVar == null) {
                com.baidu.tieba.enterForum.b.d(a.this.ipN.getPageContext(), a.this.tabName);
                if (a.this.ira != null) {
                    ar arVar = new ar("c13645");
                    arVar.w("uid", TbadkApplication.getCurrentAccountId());
                    arVar.ak("obj_locate", 1);
                    arVar.ak("obj_type", a.this.ira.aiQ ? 5 : 1);
                    arVar.ak("obj_source", 5);
                    TiebaStatic.log(arVar);
                }
            } else if (bjVar != null && a.this.ipN != null) {
                String forumName = bjVar.getForumName();
                if (au.isForumName(forumName)) {
                    a.this.ipN.sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(a.this.ipN.getFragmentActivity()).createNormalCfg(forumName, FrsActivityConfig.FRS_FROM_ENTERFORUM_RECOMMEND).setCallFrom(3)));
                    if (a.this.ira != null) {
                        ar arVar2 = new ar("c13643");
                        arVar2.w("uid", TbadkApplication.getCurrentAccountId());
                        arVar2.w("fid", bjVar.getForumId());
                        if (a.this.ira.mFrom != 0) {
                            if (a.this.ira.mFrom == 1) {
                                arVar2.ak("obj_locate", 2);
                                arVar2.dR("resource_id", a.this.tabName);
                            }
                        } else {
                            arVar2.ak("obj_locate", 1);
                            arVar2.ak("obj_type", a.this.ira.aiQ ? 4 : 1);
                        }
                        TiebaStatic.log(arVar2);
                    }
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tbadk.h.f
        public void b(View view, bj bjVar, int i, long j) {
            if (bjVar != null) {
                ar arVar = new ar("c13642");
                arVar.w("uid", TbadkApplication.getCurrentAccountId());
                arVar.w("fid", bjVar.getForumId());
                if (a.this.ira.mFrom != 0) {
                    if (a.this.ira.mFrom == 1) {
                        arVar.ak("obj_locate", 2);
                        arVar.dR("resource_id", a.this.tabName);
                    }
                } else {
                    arVar.ak("obj_locate", 1);
                    arVar.ak("obj_type", a.this.ira.aiQ ? 3 : 1);
                }
                TiebaStatic.log(arVar);
            }
        }
    };
    private View.OnClickListener ire = new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.tabfeed.view.a.5
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            com.baidu.tieba.enterForum.b.d(a.this.ipN.getPageContext(), a.this.tabName);
            if (a.this.ira != null) {
                ar arVar = new ar("c13645");
                arVar.w("uid", TbadkApplication.getCurrentAccountId());
                arVar.ak("obj_locate", 1);
                arVar.ak("obj_type", a.this.ira.aiQ ? 5 : 1);
                arVar.ak("obj_source", 2);
                TiebaStatic.log(arVar);
            }
        }
    };
    private PullLeftRefreshLayout.a alx = new PullLeftRefreshLayout.a() { // from class: com.baidu.tieba.enterForum.tabfeed.view.a.6
        @Override // com.baidu.tbadk.widget.horizontalpullview.PullLeftRefreshLayout.a
        public void bEy() {
            com.baidu.tieba.enterForum.b.d(a.this.ipN.getPageContext(), a.this.tabName);
            ar arVar = new ar("c13645");
            arVar.w("uid", TbadkApplication.getCurrentAccountId());
            arVar.ak("obj_locate", 1);
            arVar.ak("obj_type", a.this.ira.aiQ ? 5 : 1);
            arVar.ak("obj_source", 4);
            TiebaStatic.log(arVar);
        }
    };

    public a(EnterForumTabFeedFragment enterForumTabFeedFragment, com.baidu.tieba.enterForum.tabfeed.b bVar, ViewGroup viewGroup, String str) {
        this.ipN = enterForumTabFeedFragment;
        this.iqK = bVar;
        this.tabName = str;
        aT(viewGroup);
        this.irc = new com.baidu.tieba.enterForum.tabfeed.a(enterForumTabFeedFragment, this.ipO);
        ld(false);
    }

    private void aT(ViewGroup viewGroup) {
        this.iqV = viewGroup;
        this.ipO = (BdTypeRecyclerView) viewGroup.findViewById(R.id.tab_feed_recycler_view);
        this.ipO.setLayoutManager(new LinearLayoutManager(this.ipN.getContext()));
        this.ipO.setFadingEdgeLength(0);
        this.ipO.setOverScrollMode(2);
        this.ipO.setOnSrollToBottomListener(this.gDc);
        this.ipO.addOnScrollListener(this.hRq);
        this.mPullView = new g(this.ipN.getPageContext());
        this.mPullView.setListPullRefreshListener(this.iqK);
        this.ipO.setRecyclerListener(new RecyclerView.RecyclerListener() { // from class: com.baidu.tieba.enterForum.tabfeed.view.a.7
            @Override // android.support.v7.widget.RecyclerView.RecyclerListener
            public void onViewRecycled(RecyclerView.ViewHolder viewHolder) {
                View view = viewHolder.itemView;
                if (view != null && a.this.irb != null) {
                    a.this.irb.de(view);
                }
            }
        });
        this.giV = new PbListView(this.ipN.getPageContext().getPageActivity());
        this.giV.getView();
        this.giV.setContainerBackgroundColorResId(R.color.CAM_X0205);
        this.giV.setHeight(l.getDimens(this.ipN.getPageContext().getPageActivity(), R.dimen.tbds182));
        this.giV.setLineGone();
        this.giV.setTextSize(R.dimen.tbfontsize33);
        this.giV.setTextColor(ap.getColor(R.color.CAM_X0107));
        this.giV.setNoMoreTextColorId(R.color.CAM_X0110);
        this.giV.brI();
        this.giV.setOnClickListener(this.ird);
        if (this.glp == null) {
            this.glp = (BdSwipeRefreshLayout) viewGroup.findViewById(R.id.tab_feed_pull_refresh_layout);
            this.glp.setProgressView(this.mPullView);
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.glp.getLayoutParams();
            marginLayoutParams.topMargin = UtilHelper.getStatusBarHeight() + l.getDimens(this.ipN.getPageContext().getPageActivity(), R.dimen.tbds219);
            this.glp.setLayoutParams(marginLayoutParams);
        }
        this.iqW = new be();
        this.iqX = new SmartBubbleAnimatedView(this.ipN.getContext());
        this.iqX.setLayoutParams(new FrameLayout.LayoutParams(-1, l.getDimens(this.ipN.getContext(), R.dimen.tbds83)));
        if (this.irb == null) {
            this.irb = new i(this.ipN.getPageContext(), this.ipO);
            this.irb.HS(1);
            this.irb.setUniqueId(this.ipN.getUniqueId());
        }
        this.iqY = new b(this.ipN.getPageContext());
        this.iqY.setTabName(this.tabName);
    }

    public void b(com.baidu.tieba.enterForum.tabfeed.b.b bVar) {
        if (bVar != null) {
            this.hasMore = bVar.hasMore;
        }
        ld(false);
        if (bVar != null && this.irc != null && this.ipO != null && this.giV != null) {
            csG();
            d(bVar);
            c(bVar);
            if (bVar.iqG > 0) {
                int firstVisiblePosition = this.ipO.getFirstVisiblePosition();
                View childAt = this.ipO.getChildAt(0);
                int top = childAt == null ? 0 : childAt.getTop();
                RecyclerView.LayoutManager layoutManager = this.ipO.getLayoutManager();
                int i = firstVisiblePosition - bVar.iqG;
                if (layoutManager instanceof LinearLayoutManager) {
                    this.ipO.qR();
                    ((LinearLayoutManager) layoutManager).scrollToPositionWithOffset(i, top);
                    this.ipO.qS();
                }
                bVar.iqG = 0;
            }
            this.irc.setIsFromCDN(bVar.akn);
            this.irc.setData(bVar.iqF);
            this.irc.notifyDataSetChanged();
            if (bVar.fNx) {
                yu(bVar.refreshCount);
            }
            if (this.irb != null) {
                this.irb.a(this.ipO.getFirstVisiblePosition(), this.ipO.getLastVisiblePosition(), false, true);
            }
        }
    }

    private void csG() {
        if (this.etx == null) {
            this.etx = new TextView(this.ipN.getContext());
            this.etx.setPadding(l.getDimens(this.ipN.getContext(), R.dimen.tbds44), l.getDimens(this.ipN.getContext(), R.dimen.tbds60), 0, l.getDimens(this.ipN.getContext(), R.dimen.tbds24));
            this.etx.setText(R.string.tab_feed_title);
            this.etx.setTextSize(0, l.getDimens(this.ipN.getContext(), R.dimen.tbds46));
            this.etx.setTypeface(Typeface.DEFAULT_BOLD);
            this.ipO.removeHeaderView(this.etx);
            this.ipO.addHeaderView(this.etx, 0);
            ap.setViewTextColor(this.etx, R.color.CAM_X0105);
        }
    }

    private void c(com.baidu.tieba.enterForum.tabfeed.b.b bVar) {
        if (bVar != null && this.ipO != null && this.ipN != null && bVar.fNx) {
            if (!((bVar.iqE == null || y.isEmpty(bVar.iqE.bkI())) ? false : true)) {
                if (this.ira != null) {
                    this.ipO.removeHeaderView(this.ira);
                    return;
                }
                return;
            }
            if (this.ira == null) {
                this.ira = new RecommendForumLayout(this.ipN.getPageContext());
                this.ira.setShowMore(true);
                this.ira.setSquareEntranceAtStart(true);
                this.ira.setTabName(this.tabName);
                this.ira.setFrom(1);
            }
            this.ira.setOnClickRightArrowListener(this.ire);
            this.ira.setOnRullOkCallbackr(this.alx);
            this.ira.setOnItemCoverListener(this.aiR);
            this.ira.b(bVar.iqE);
            this.ipO.removeHeaderView(this.ira);
            this.ipO.addHeaderView(this.ira, 0);
            ar arVar = new ar("c13641");
            arVar.w("uid", TbadkApplication.getCurrentAccountId());
            arVar.ak("obj_locate", 2);
            arVar.dR("resource_id", this.tabName);
            TiebaStatic.log(arVar);
        }
    }

    private void d(com.baidu.tieba.enterForum.tabfeed.b.b bVar) {
        if (bVar.iqH != null && bVar.iqH.hot_user != null && bVar.iqH.hot_user.size() > 0 && !TextUtils.isEmpty(bVar.iqH.module_name)) {
            this.iqY.a(bVar.iqH);
            if (this.iqY.getView().getParent() == null && !this.iqZ) {
                this.iqZ = true;
                this.ipO.addHeaderView(this.iqY.getView(), 0);
                ar arVar = new ar("c13656");
                arVar.w("uid", TbadkApplication.getCurrentAccountId());
                arVar.dR("resource_id", this.tabName);
                TiebaStatic.log(arVar);
                return;
            }
            return;
        }
        this.iqZ = false;
        this.ipO.removeHeaderView(this.iqY.getView());
    }

    public void onChangeSkinType(int i) {
        if (this.mPullView != null) {
            this.mPullView.changeSkin(i);
        }
        if (this.giV != null) {
            this.giV.setTextColor(ap.getColor(R.color.CAM_X0107));
            this.giV.changeSkin(i);
        }
        if (this.irc != null) {
            this.irc.notifyDataSetChanged();
        }
        if (this.etx != null) {
            ap.setViewTextColor(this.etx, R.color.CAM_X0105);
        }
        if (this.iqY != null) {
            this.iqY.onChangeSkinType();
        }
        if (this.ira != null) {
            this.ira.onChangeSkinType();
        }
        if (this.iqX != null) {
            this.iqX.onChangeSkinType(i);
        }
    }

    public void resume() {
        if (this.irb != null) {
            this.irb.ta(true);
            if (this.ipO != null) {
                this.irb.a(this.ipO.getFirstVisiblePosition(), this.ipO.getLastVisiblePosition(), false, true);
            }
        }
    }

    public void pause() {
        if (this.irb != null) {
            this.irb.cZy();
            this.irb.ta(false);
        }
    }

    public void csH() {
        if (this.ipO != null) {
            this.ipO.scrollToPosition(0);
        }
    }

    public void ld(boolean z) {
        if (this.glp != null) {
            this.glp.setRefreshing(z);
        }
    }

    public void pd(boolean z) {
        if (this.glp != null) {
            this.glp.setVisibility(z ? 0 : 8);
        }
    }

    public boolean csI() {
        return this.ipO == null || this.ipO.getChildCount() == 0 || this.ipO.getChildAt(0).getTop() == 0;
    }

    private void yu(int i) {
        String string;
        if (i >= 0) {
            this.iqW.cAj();
            if (i > 0) {
                string = String.format(TbadkCoreApplication.getInst().getString(R.string.recommend_frs_refresh_return), Integer.valueOf(i));
            } else {
                string = TbadkCoreApplication.getInst().getString(R.string.recommend_frs_refresh_nodata);
            }
            if (!TextUtils.isEmpty(string) && j.isNetWorkAvailable()) {
                this.iqX.eUZ = string;
                this.iqX.iNc = 2000L;
                FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
                layoutParams.gravity = 49;
                layoutParams.topMargin = UtilHelper.getStatusBarHeight() + l.getDimens(this.ipN.getPageContext().getPageActivity(), R.dimen.tbds228);
                if (this.iqV != null) {
                    this.iqV.removeView(this.iqX);
                    this.iqV.addView(this.iqX, layoutParams);
                    this.iqX.cAh();
                }
            }
        }
    }

    public void ci(int i, int i2) {
        if (this.ipO != null && i < i2) {
            this.ipO.o(i, i2);
        }
    }
}
