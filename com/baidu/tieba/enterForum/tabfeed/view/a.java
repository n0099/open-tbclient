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
    private TextView eHx;
    private PbListView gAi;
    private BdSwipeRefreshLayout gCC;
    private boolean hasMore;
    private EnterForumTabFeedFragment iNU;
    private BdTypeRecyclerView iNV;
    private com.baidu.tieba.enterForum.tabfeed.b iOR;
    private ViewGroup iPc;
    private bb iPd;
    private SmartBubbleAnimatedView iPe;
    private b iPf;
    private boolean iPg;
    private RecommendForumLayout iPh;
    private i iPi;
    private com.baidu.tieba.enterForum.tabfeed.a iPj;
    private g mPullView;
    private String tabName;
    private BdListView.e gVR = new BdListView.e() { // from class: com.baidu.tieba.enterForum.tabfeed.view.a.1
        @Override // com.baidu.adp.widget.ListView.BdListView.e
        public void onScrollToBottom() {
            if (a.this.iNV != null) {
                a.this.iNV.stopScroll();
            }
            if (a.this.gAi != null && a.this.iOR != null) {
                if (j.isNetWorkAvailable()) {
                    a.this.iNV.setNextPage(a.this.gAi);
                    a.this.gAi.showEmptyView(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
                    a.this.gAi.setOnClickListener(null);
                    if (a.this.hasMore) {
                        a.this.gAi.showLoading();
                        a.this.iOR.cwY();
                        return;
                    }
                    a.this.gAi.setText(a.this.iNU.getResources().getString(R.string.list_has_no_more));
                    a.this.gAi.endLoadData();
                    return;
                }
                a.this.iNV.setNextPage(null);
            }
        }
    };
    private RecyclerView.OnScrollListener ipL = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.enterForum.tabfeed.view.a.2
        private boolean fiZ;

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i) {
            if (i == 0) {
                if (a.this.iPi != null) {
                    a.this.iPi.b(a.this.iNV.getFirstVisiblePosition(), a.this.iNV.getLastVisiblePosition(), this.fiZ, true);
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001630, Boolean.valueOf(a.this.cxm() ? false : true)));
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrolled(RecyclerView recyclerView, int i, int i2) {
            super.onScrolled(recyclerView, i, i2);
            if (i2 > 0) {
                this.fiZ = false;
            } else {
                this.fiZ = true;
            }
        }
    };
    private View.OnClickListener iPk = new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.tabfeed.view.a.3
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (a.this.iNV != null) {
                a.this.iNV.stopScroll();
            }
            if (a.this.gAi != null && a.this.iOR != null && j.isNetWorkAvailable()) {
                a.this.gAi.showEmptyView(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
                a.this.gAi.setOnClickListener(null);
                if (a.this.hasMore) {
                    a.this.gAi.showLoading();
                    a.this.iOR.cwY();
                }
            }
        }
    };
    private f ajq = new f<bn>() { // from class: com.baidu.tieba.enterForum.tabfeed.view.a.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tbadk.h.f
        public void a(View view, bn bnVar, int i, long j) {
            if (bnVar == null) {
                com.baidu.tieba.enterForum.b.d(a.this.iNU.getPageContext(), a.this.tabName);
                if (a.this.iPh != null) {
                    ar arVar = new ar("c13645");
                    arVar.v("uid", TbadkApplication.getCurrentAccountId());
                    arVar.ap("obj_locate", 1);
                    arVar.ap("obj_type", a.this.iPh.ajp ? 5 : 1);
                    arVar.ap("obj_source", 5);
                    TiebaStatic.log(arVar);
                }
            } else if (bnVar != null && a.this.iNU != null) {
                String forumName = bnVar.getForumName();
                if (au.isForumName(forumName)) {
                    a.this.iNU.sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(a.this.iNU.getFragmentActivity()).createNormalCfg(forumName, FrsActivityConfig.FRS_FROM_ENTERFORUM_RECOMMEND).setCallFrom(3)));
                    if (a.this.iPh != null) {
                        ar arVar2 = new ar("c13643");
                        arVar2.v("uid", TbadkApplication.getCurrentAccountId());
                        arVar2.v("fid", bnVar.getForumId());
                        if (a.this.iPh.mFrom != 0) {
                            if (a.this.iPh.mFrom == 1) {
                                arVar2.ap("obj_locate", 2);
                                arVar2.dR("resource_id", a.this.tabName);
                            }
                        } else {
                            arVar2.ap("obj_locate", 1);
                            arVar2.ap("obj_type", a.this.iPh.ajp ? 4 : 1);
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
                if (a.this.iPh.mFrom != 0) {
                    if (a.this.iPh.mFrom == 1) {
                        arVar.ap("obj_locate", 2);
                        arVar.dR("resource_id", a.this.tabName);
                    }
                } else {
                    arVar.ap("obj_locate", 1);
                    arVar.ap("obj_type", a.this.iPh.ajp ? 3 : 1);
                }
                TiebaStatic.log(arVar);
            }
        }
    };
    private View.OnClickListener iPl = new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.tabfeed.view.a.5
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            com.baidu.tieba.enterForum.b.d(a.this.iNU.getPageContext(), a.this.tabName);
            if (a.this.iPh != null) {
                ar arVar = new ar("c13645");
                arVar.v("uid", TbadkApplication.getCurrentAccountId());
                arVar.ap("obj_locate", 1);
                arVar.ap("obj_type", a.this.iPh.ajp ? 5 : 1);
                arVar.ap("obj_source", 2);
                TiebaStatic.log(arVar);
            }
        }
    };
    private PullLeftRefreshLayout.a alZ = new PullLeftRefreshLayout.a() { // from class: com.baidu.tieba.enterForum.tabfeed.view.a.6
        @Override // com.baidu.tbadk.widget.horizontalpullview.PullLeftRefreshLayout.a
        public void bGW() {
            com.baidu.tieba.enterForum.b.d(a.this.iNU.getPageContext(), a.this.tabName);
            ar arVar = new ar("c13645");
            arVar.v("uid", TbadkApplication.getCurrentAccountId());
            arVar.ap("obj_locate", 1);
            arVar.ap("obj_type", a.this.iPh.ajp ? 5 : 1);
            arVar.ap("obj_source", 4);
            TiebaStatic.log(arVar);
        }
    };

    public a(EnterForumTabFeedFragment enterForumTabFeedFragment, com.baidu.tieba.enterForum.tabfeed.b bVar, ViewGroup viewGroup, String str) {
        this.iNU = enterForumTabFeedFragment;
        this.iOR = bVar;
        this.tabName = str;
        bf(viewGroup);
        this.iPj = new com.baidu.tieba.enterForum.tabfeed.a(enterForumTabFeedFragment, this.iNV);
        lU(false);
    }

    private void bf(ViewGroup viewGroup) {
        this.iPc = viewGroup;
        this.iNV = (BdTypeRecyclerView) viewGroup.findViewById(R.id.tab_feed_recycler_view);
        this.iNV.setLayoutManager(new LinearLayoutManager(this.iNU.getContext()));
        this.iNV.setFadingEdgeLength(0);
        this.iNV.setOverScrollMode(2);
        this.iNV.setOnSrollToBottomListener(this.gVR);
        this.iNV.addOnScrollListener(this.ipL);
        this.mPullView = new g(this.iNU.getPageContext());
        this.mPullView.setListPullRefreshListener(this.iOR);
        this.iNV.setRecyclerListener(new RecyclerView.RecyclerListener() { // from class: com.baidu.tieba.enterForum.tabfeed.view.a.7
            @Override // androidx.recyclerview.widget.RecyclerView.RecyclerListener
            public void onViewRecycled(RecyclerView.ViewHolder viewHolder) {
                View view = viewHolder.itemView;
                if (view != null && a.this.iPi != null) {
                    a.this.iPi.dt(view);
                }
            }
        });
        this.gAi = new PbListView(this.iNU.getPageContext().getPageActivity());
        this.gAi.getView();
        this.gAi.setContainerBackgroundColorResId(R.color.CAM_X0205);
        this.gAi.setHeight(l.getDimens(this.iNU.getPageContext().getPageActivity(), R.dimen.tbds182));
        this.gAi.setLineGone();
        this.gAi.setTextSize(R.dimen.tbfontsize33);
        this.gAi.setTextColor(ap.getColor(R.color.CAM_X0107));
        this.gAi.setNoMoreTextColorId(R.color.CAM_X0110);
        this.gAi.bud();
        this.gAi.setOnClickListener(this.iPk);
        if (this.gCC == null) {
            this.gCC = (BdSwipeRefreshLayout) viewGroup.findViewById(R.id.tab_feed_pull_refresh_layout);
            this.gCC.setProgressView(this.mPullView);
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.gCC.getLayoutParams();
            marginLayoutParams.topMargin = UtilHelper.getStatusBarHeight() + l.getDimens(this.iNU.getPageContext().getPageActivity(), R.dimen.tbds219);
            this.gCC.setLayoutParams(marginLayoutParams);
        }
        this.iPd = new bb();
        this.iPe = new SmartBubbleAnimatedView(this.iNU.getContext());
        this.iPe.setLayoutParams(new FrameLayout.LayoutParams(-1, l.getDimens(this.iNU.getContext(), R.dimen.tbds83)));
        if (this.iPi == null) {
            this.iPi = new i(this.iNU.getPageContext(), this.iNV);
            this.iPi.Ho(1);
            this.iPi.setUniqueId(this.iNU.getUniqueId());
        }
        this.iPf = new b(this.iNU.getPageContext());
        this.iPf.setTabName(this.tabName);
    }

    public void b(com.baidu.tieba.enterForum.tabfeed.b.b bVar) {
        if (bVar != null) {
            this.hasMore = bVar.hasMore;
        }
        lU(false);
        if (bVar != null && this.iPj != null && this.iNV != null && this.gAi != null) {
            cxk();
            d(bVar);
            c(bVar);
            if (bVar.iON > 0) {
                int firstVisiblePosition = this.iNV.getFirstVisiblePosition();
                View childAt = this.iNV.getChildAt(0);
                int top = childAt == null ? 0 : childAt.getTop();
                RecyclerView.LayoutManager layoutManager = this.iNV.getLayoutManager();
                int i = firstVisiblePosition - bVar.iON;
                if (layoutManager instanceof LinearLayoutManager) {
                    this.iNV.qt();
                    ((LinearLayoutManager) layoutManager).scrollToPositionWithOffset(i, top);
                    this.iNV.qu();
                }
                bVar.iON = 0;
            }
            this.iPj.setIsFromCDN(bVar.akO);
            this.iPj.setData(bVar.iOM);
            this.iPj.notifyDataSetChanged();
            if (bVar.gcx) {
                xQ(bVar.refreshCount);
            }
            if (this.iPi != null) {
                this.iPi.b(this.iNV.getFirstVisiblePosition(), this.iNV.getLastVisiblePosition(), false, true);
            }
        }
    }

    private void cxk() {
        if (this.eHx == null) {
            this.eHx = new TextView(this.iNU.getContext());
            this.eHx.setPadding(l.getDimens(this.iNU.getContext(), R.dimen.tbds44), l.getDimens(this.iNU.getContext(), R.dimen.tbds60), 0, l.getDimens(this.iNU.getContext(), R.dimen.tbds24));
            this.eHx.setText(R.string.tab_feed_title);
            this.eHx.setTextSize(0, l.getDimens(this.iNU.getContext(), R.dimen.tbds46));
            this.eHx.setTypeface(Typeface.DEFAULT_BOLD);
            this.iNV.removeHeaderView(this.eHx);
            this.iNV.addHeaderView(this.eHx, 0);
            ap.setViewTextColor(this.eHx, R.color.CAM_X0105);
        }
    }

    private void c(com.baidu.tieba.enterForum.tabfeed.b.b bVar) {
        if (bVar != null && this.iNV != null && this.iNU != null && bVar.gcx) {
            if (!((bVar.iOL == null || y.isEmpty(bVar.iOL.bmW())) ? false : true)) {
                if (this.iPh != null) {
                    this.iNV.removeHeaderView(this.iPh);
                    return;
                }
                return;
            }
            if (this.iPh == null) {
                this.iPh = new RecommendForumLayout(this.iNU.getPageContext());
                this.iPh.setShowMore(true);
                this.iPh.setSquareEntranceAtStart(true);
                this.iPh.setTabName(this.tabName);
                this.iPh.setFrom(1);
            }
            this.iPh.setOnClickRightArrowListener(this.iPl);
            this.iPh.setOnRullOkCallbackr(this.alZ);
            this.iPh.setOnItemCoverListener(this.ajq);
            this.iPh.b(bVar.iOL);
            this.iNV.removeHeaderView(this.iPh);
            this.iNV.addHeaderView(this.iPh, 0);
            ar arVar = new ar("c13641");
            arVar.v("uid", TbadkApplication.getCurrentAccountId());
            arVar.ap("obj_locate", 2);
            arVar.dR("resource_id", this.tabName);
            TiebaStatic.log(arVar);
        }
    }

    private void d(com.baidu.tieba.enterForum.tabfeed.b.b bVar) {
        if (bVar.iOO != null && bVar.iOO.hot_user != null && bVar.iOO.hot_user.size() > 0 && !TextUtils.isEmpty(bVar.iOO.module_name)) {
            this.iPf.a(bVar.iOO);
            if (this.iPf.getView().getParent() == null && !this.iPg) {
                this.iPg = true;
                this.iNV.addHeaderView(this.iPf.getView(), 0);
                ar arVar = new ar("c13656");
                arVar.v("uid", TbadkApplication.getCurrentAccountId());
                arVar.dR("resource_id", this.tabName);
                TiebaStatic.log(arVar);
                return;
            }
            return;
        }
        this.iPg = false;
        this.iNV.removeHeaderView(this.iPf.getView());
    }

    public void onChangeSkinType(int i) {
        if (this.mPullView != null) {
            this.mPullView.changeSkin(i);
        }
        if (this.gAi != null) {
            this.gAi.setTextColor(ap.getColor(R.color.CAM_X0107));
            this.gAi.changeSkin(i);
        }
        if (this.iPj != null) {
            this.iPj.notifyDataSetChanged();
        }
        if (this.eHx != null) {
            ap.setViewTextColor(this.eHx, R.color.CAM_X0105);
        }
        if (this.iPf != null) {
            this.iPf.onChangeSkinType();
        }
        if (this.iPh != null) {
            this.iPh.onChangeSkinType();
        }
        if (this.iPe != null) {
            this.iPe.onChangeSkinType(i);
        }
    }

    public void resume() {
        if (this.iPi != null) {
            this.iPi.tN(true);
            if (this.iNV != null) {
                this.iPi.b(this.iNV.getFirstVisiblePosition(), this.iNV.getLastVisiblePosition(), false, true);
            }
        }
    }

    public void pause() {
        if (this.iPi != null) {
            this.iPi.dcC();
            this.iPi.tN(false);
        }
    }

    public void cxl() {
        if (this.iNV != null) {
            this.iNV.scrollToPosition(0);
        }
    }

    public void lU(boolean z) {
        if (this.gCC != null) {
            this.gCC.setRefreshing(z);
        }
    }

    public void qc(boolean z) {
        if (this.gCC != null) {
            this.gCC.setVisibility(z ? 0 : 8);
        }
    }

    public boolean cxm() {
        return this.iNV == null || this.iNV.getChildCount() == 0 || this.iNV.getChildAt(0).getTop() == 0;
    }

    private void xQ(int i) {
        String string;
        if (i >= 0) {
            this.iPd.cEQ();
            if (i > 0) {
                string = String.format(TbadkCoreApplication.getInst().getString(R.string.recommend_frs_refresh_return), Integer.valueOf(i));
            } else {
                string = TbadkCoreApplication.getInst().getString(R.string.recommend_frs_refresh_nodata);
            }
            if (!TextUtils.isEmpty(string) && j.isNetWorkAvailable()) {
                this.iPe.fjM = string;
                this.iPe.jli = 2000L;
                FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
                layoutParams.gravity = 49;
                layoutParams.topMargin = UtilHelper.getStatusBarHeight() + l.getDimens(this.iNU.getPageContext().getPageActivity(), R.dimen.tbds228);
                if (this.iPc != null) {
                    this.iPc.removeView(this.iPe);
                    this.iPc.addView(this.iPe, layoutParams);
                    this.iPe.cEO();
                }
            }
        }
    }

    public void ci(int i, int i2) {
        if (this.iNV != null && i < i2) {
            this.iNV.p(i, i2);
        }
    }
}
