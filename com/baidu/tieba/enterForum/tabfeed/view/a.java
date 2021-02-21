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
    private PbListView gAw;
    private BdSwipeRefreshLayout gCQ;
    private boolean hasMore;
    private EnterForumTabFeedFragment iOi;
    private BdTypeRecyclerView iOj;
    private com.baidu.tieba.enterForum.tabfeed.b iPf;
    private ViewGroup iPq;
    private bb iPr;
    private SmartBubbleAnimatedView iPs;
    private b iPt;
    private boolean iPu;
    private RecommendForumLayout iPv;
    private i iPw;
    private com.baidu.tieba.enterForum.tabfeed.a iPx;
    private g mPullView;
    private String tabName;
    private BdListView.e gWf = new BdListView.e() { // from class: com.baidu.tieba.enterForum.tabfeed.view.a.1
        @Override // com.baidu.adp.widget.ListView.BdListView.e
        public void onScrollToBottom() {
            if (a.this.iOj != null) {
                a.this.iOj.stopScroll();
            }
            if (a.this.gAw != null && a.this.iPf != null) {
                if (j.isNetWorkAvailable()) {
                    a.this.iOj.setNextPage(a.this.gAw);
                    a.this.gAw.showEmptyView(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
                    a.this.gAw.setOnClickListener(null);
                    if (a.this.hasMore) {
                        a.this.gAw.showLoading();
                        a.this.iPf.cxf();
                        return;
                    }
                    a.this.gAw.setText(a.this.iOi.getResources().getString(R.string.list_has_no_more));
                    a.this.gAw.endLoadData();
                    return;
                }
                a.this.iOj.setNextPage(null);
            }
        }
    };
    private RecyclerView.OnScrollListener ipZ = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.enterForum.tabfeed.view.a.2
        private boolean fiZ;

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i) {
            if (i == 0) {
                if (a.this.iPw != null) {
                    a.this.iPw.b(a.this.iOj.getFirstVisiblePosition(), a.this.iOj.getLastVisiblePosition(), this.fiZ, true);
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001630, Boolean.valueOf(a.this.cxt() ? false : true)));
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
    private View.OnClickListener iPy = new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.tabfeed.view.a.3
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (a.this.iOj != null) {
                a.this.iOj.stopScroll();
            }
            if (a.this.gAw != null && a.this.iPf != null && j.isNetWorkAvailable()) {
                a.this.gAw.showEmptyView(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
                a.this.gAw.setOnClickListener(null);
                if (a.this.hasMore) {
                    a.this.gAw.showLoading();
                    a.this.iPf.cxf();
                }
            }
        }
    };
    private f ajq = new f<bn>() { // from class: com.baidu.tieba.enterForum.tabfeed.view.a.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tbadk.h.f
        public void a(View view, bn bnVar, int i, long j) {
            if (bnVar == null) {
                com.baidu.tieba.enterForum.b.d(a.this.iOi.getPageContext(), a.this.tabName);
                if (a.this.iPv != null) {
                    ar arVar = new ar("c13645");
                    arVar.v("uid", TbadkApplication.getCurrentAccountId());
                    arVar.ap("obj_locate", 1);
                    arVar.ap("obj_type", a.this.iPv.ajp ? 5 : 1);
                    arVar.ap("obj_source", 5);
                    TiebaStatic.log(arVar);
                }
            } else if (bnVar != null && a.this.iOi != null) {
                String forumName = bnVar.getForumName();
                if (au.isForumName(forumName)) {
                    a.this.iOi.sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(a.this.iOi.getFragmentActivity()).createNormalCfg(forumName, FrsActivityConfig.FRS_FROM_ENTERFORUM_RECOMMEND).setCallFrom(3)));
                    if (a.this.iPv != null) {
                        ar arVar2 = new ar("c13643");
                        arVar2.v("uid", TbadkApplication.getCurrentAccountId());
                        arVar2.v("fid", bnVar.getForumId());
                        if (a.this.iPv.mFrom != 0) {
                            if (a.this.iPv.mFrom == 1) {
                                arVar2.ap("obj_locate", 2);
                                arVar2.dR("resource_id", a.this.tabName);
                            }
                        } else {
                            arVar2.ap("obj_locate", 1);
                            arVar2.ap("obj_type", a.this.iPv.ajp ? 4 : 1);
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
                if (a.this.iPv.mFrom != 0) {
                    if (a.this.iPv.mFrom == 1) {
                        arVar.ap("obj_locate", 2);
                        arVar.dR("resource_id", a.this.tabName);
                    }
                } else {
                    arVar.ap("obj_locate", 1);
                    arVar.ap("obj_type", a.this.iPv.ajp ? 3 : 1);
                }
                TiebaStatic.log(arVar);
            }
        }
    };
    private View.OnClickListener iPz = new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.tabfeed.view.a.5
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            com.baidu.tieba.enterForum.b.d(a.this.iOi.getPageContext(), a.this.tabName);
            if (a.this.iPv != null) {
                ar arVar = new ar("c13645");
                arVar.v("uid", TbadkApplication.getCurrentAccountId());
                arVar.ap("obj_locate", 1);
                arVar.ap("obj_type", a.this.iPv.ajp ? 5 : 1);
                arVar.ap("obj_source", 2);
                TiebaStatic.log(arVar);
            }
        }
    };
    private PullLeftRefreshLayout.a alZ = new PullLeftRefreshLayout.a() { // from class: com.baidu.tieba.enterForum.tabfeed.view.a.6
        @Override // com.baidu.tbadk.widget.horizontalpullview.PullLeftRefreshLayout.a
        public void bGW() {
            com.baidu.tieba.enterForum.b.d(a.this.iOi.getPageContext(), a.this.tabName);
            ar arVar = new ar("c13645");
            arVar.v("uid", TbadkApplication.getCurrentAccountId());
            arVar.ap("obj_locate", 1);
            arVar.ap("obj_type", a.this.iPv.ajp ? 5 : 1);
            arVar.ap("obj_source", 4);
            TiebaStatic.log(arVar);
        }
    };

    public a(EnterForumTabFeedFragment enterForumTabFeedFragment, com.baidu.tieba.enterForum.tabfeed.b bVar, ViewGroup viewGroup, String str) {
        this.iOi = enterForumTabFeedFragment;
        this.iPf = bVar;
        this.tabName = str;
        bf(viewGroup);
        this.iPx = new com.baidu.tieba.enterForum.tabfeed.a(enterForumTabFeedFragment, this.iOj);
        lU(false);
    }

    private void bf(ViewGroup viewGroup) {
        this.iPq = viewGroup;
        this.iOj = (BdTypeRecyclerView) viewGroup.findViewById(R.id.tab_feed_recycler_view);
        this.iOj.setLayoutManager(new LinearLayoutManager(this.iOi.getContext()));
        this.iOj.setFadingEdgeLength(0);
        this.iOj.setOverScrollMode(2);
        this.iOj.setOnSrollToBottomListener(this.gWf);
        this.iOj.addOnScrollListener(this.ipZ);
        this.mPullView = new g(this.iOi.getPageContext());
        this.mPullView.setListPullRefreshListener(this.iPf);
        this.iOj.setRecyclerListener(new RecyclerView.RecyclerListener() { // from class: com.baidu.tieba.enterForum.tabfeed.view.a.7
            @Override // androidx.recyclerview.widget.RecyclerView.RecyclerListener
            public void onViewRecycled(RecyclerView.ViewHolder viewHolder) {
                View view = viewHolder.itemView;
                if (view != null && a.this.iPw != null) {
                    a.this.iPw.dt(view);
                }
            }
        });
        this.gAw = new PbListView(this.iOi.getPageContext().getPageActivity());
        this.gAw.getView();
        this.gAw.setContainerBackgroundColorResId(R.color.CAM_X0205);
        this.gAw.setHeight(l.getDimens(this.iOi.getPageContext().getPageActivity(), R.dimen.tbds182));
        this.gAw.setLineGone();
        this.gAw.setTextSize(R.dimen.tbfontsize33);
        this.gAw.setTextColor(ap.getColor(R.color.CAM_X0107));
        this.gAw.setNoMoreTextColorId(R.color.CAM_X0110);
        this.gAw.bud();
        this.gAw.setOnClickListener(this.iPy);
        if (this.gCQ == null) {
            this.gCQ = (BdSwipeRefreshLayout) viewGroup.findViewById(R.id.tab_feed_pull_refresh_layout);
            this.gCQ.setProgressView(this.mPullView);
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.gCQ.getLayoutParams();
            marginLayoutParams.topMargin = UtilHelper.getStatusBarHeight() + l.getDimens(this.iOi.getPageContext().getPageActivity(), R.dimen.tbds219);
            this.gCQ.setLayoutParams(marginLayoutParams);
        }
        this.iPr = new bb();
        this.iPs = new SmartBubbleAnimatedView(this.iOi.getContext());
        this.iPs.setLayoutParams(new FrameLayout.LayoutParams(-1, l.getDimens(this.iOi.getContext(), R.dimen.tbds83)));
        if (this.iPw == null) {
            this.iPw = new i(this.iOi.getPageContext(), this.iOj);
            this.iPw.Ho(1);
            this.iPw.setUniqueId(this.iOi.getUniqueId());
        }
        this.iPt = new b(this.iOi.getPageContext());
        this.iPt.setTabName(this.tabName);
    }

    public void b(com.baidu.tieba.enterForum.tabfeed.b.b bVar) {
        if (bVar != null) {
            this.hasMore = bVar.hasMore;
        }
        lU(false);
        if (bVar != null && this.iPx != null && this.iOj != null && this.gAw != null) {
            cxr();
            d(bVar);
            c(bVar);
            if (bVar.iPb > 0) {
                int firstVisiblePosition = this.iOj.getFirstVisiblePosition();
                View childAt = this.iOj.getChildAt(0);
                int top = childAt == null ? 0 : childAt.getTop();
                RecyclerView.LayoutManager layoutManager = this.iOj.getLayoutManager();
                int i = firstVisiblePosition - bVar.iPb;
                if (layoutManager instanceof LinearLayoutManager) {
                    this.iOj.qt();
                    ((LinearLayoutManager) layoutManager).scrollToPositionWithOffset(i, top);
                    this.iOj.qu();
                }
                bVar.iPb = 0;
            }
            this.iPx.setIsFromCDN(bVar.akO);
            this.iPx.setData(bVar.iPa);
            this.iPx.notifyDataSetChanged();
            if (bVar.gcC) {
                xQ(bVar.refreshCount);
            }
            if (this.iPw != null) {
                this.iPw.b(this.iOj.getFirstVisiblePosition(), this.iOj.getLastVisiblePosition(), false, true);
            }
        }
    }

    private void cxr() {
        if (this.eHx == null) {
            this.eHx = new TextView(this.iOi.getContext());
            this.eHx.setPadding(l.getDimens(this.iOi.getContext(), R.dimen.tbds44), l.getDimens(this.iOi.getContext(), R.dimen.tbds60), 0, l.getDimens(this.iOi.getContext(), R.dimen.tbds24));
            this.eHx.setText(R.string.tab_feed_title);
            this.eHx.setTextSize(0, l.getDimens(this.iOi.getContext(), R.dimen.tbds46));
            this.eHx.setTypeface(Typeface.DEFAULT_BOLD);
            this.iOj.removeHeaderView(this.eHx);
            this.iOj.addHeaderView(this.eHx, 0);
            ap.setViewTextColor(this.eHx, R.color.CAM_X0105);
        }
    }

    private void c(com.baidu.tieba.enterForum.tabfeed.b.b bVar) {
        if (bVar != null && this.iOj != null && this.iOi != null && bVar.gcC) {
            if (!((bVar.iOZ == null || y.isEmpty(bVar.iOZ.bmW())) ? false : true)) {
                if (this.iPv != null) {
                    this.iOj.removeHeaderView(this.iPv);
                    return;
                }
                return;
            }
            if (this.iPv == null) {
                this.iPv = new RecommendForumLayout(this.iOi.getPageContext());
                this.iPv.setShowMore(true);
                this.iPv.setSquareEntranceAtStart(true);
                this.iPv.setTabName(this.tabName);
                this.iPv.setFrom(1);
            }
            this.iPv.setOnClickRightArrowListener(this.iPz);
            this.iPv.setOnRullOkCallbackr(this.alZ);
            this.iPv.setOnItemCoverListener(this.ajq);
            this.iPv.b(bVar.iOZ);
            this.iOj.removeHeaderView(this.iPv);
            this.iOj.addHeaderView(this.iPv, 0);
            ar arVar = new ar("c13641");
            arVar.v("uid", TbadkApplication.getCurrentAccountId());
            arVar.ap("obj_locate", 2);
            arVar.dR("resource_id", this.tabName);
            TiebaStatic.log(arVar);
        }
    }

    private void d(com.baidu.tieba.enterForum.tabfeed.b.b bVar) {
        if (bVar.iPc != null && bVar.iPc.hot_user != null && bVar.iPc.hot_user.size() > 0 && !TextUtils.isEmpty(bVar.iPc.module_name)) {
            this.iPt.a(bVar.iPc);
            if (this.iPt.getView().getParent() == null && !this.iPu) {
                this.iPu = true;
                this.iOj.addHeaderView(this.iPt.getView(), 0);
                ar arVar = new ar("c13656");
                arVar.v("uid", TbadkApplication.getCurrentAccountId());
                arVar.dR("resource_id", this.tabName);
                TiebaStatic.log(arVar);
                return;
            }
            return;
        }
        this.iPu = false;
        this.iOj.removeHeaderView(this.iPt.getView());
    }

    public void onChangeSkinType(int i) {
        if (this.mPullView != null) {
            this.mPullView.changeSkin(i);
        }
        if (this.gAw != null) {
            this.gAw.setTextColor(ap.getColor(R.color.CAM_X0107));
            this.gAw.changeSkin(i);
        }
        if (this.iPx != null) {
            this.iPx.notifyDataSetChanged();
        }
        if (this.eHx != null) {
            ap.setViewTextColor(this.eHx, R.color.CAM_X0105);
        }
        if (this.iPt != null) {
            this.iPt.onChangeSkinType();
        }
        if (this.iPv != null) {
            this.iPv.onChangeSkinType();
        }
        if (this.iPs != null) {
            this.iPs.onChangeSkinType(i);
        }
    }

    public void resume() {
        if (this.iPw != null) {
            this.iPw.tN(true);
            if (this.iOj != null) {
                this.iPw.b(this.iOj.getFirstVisiblePosition(), this.iOj.getLastVisiblePosition(), false, true);
            }
        }
    }

    public void pause() {
        if (this.iPw != null) {
            this.iPw.dcJ();
            this.iPw.tN(false);
        }
    }

    public void cxs() {
        if (this.iOj != null) {
            this.iOj.scrollToPosition(0);
        }
    }

    public void lU(boolean z) {
        if (this.gCQ != null) {
            this.gCQ.setRefreshing(z);
        }
    }

    public void qc(boolean z) {
        if (this.gCQ != null) {
            this.gCQ.setVisibility(z ? 0 : 8);
        }
    }

    public boolean cxt() {
        return this.iOj == null || this.iOj.getChildCount() == 0 || this.iOj.getChildAt(0).getTop() == 0;
    }

    private void xQ(int i) {
        String string;
        if (i >= 0) {
            this.iPr.cEX();
            if (i > 0) {
                string = String.format(TbadkCoreApplication.getInst().getString(R.string.recommend_frs_refresh_return), Integer.valueOf(i));
            } else {
                string = TbadkCoreApplication.getInst().getString(R.string.recommend_frs_refresh_nodata);
            }
            if (!TextUtils.isEmpty(string) && j.isNetWorkAvailable()) {
                this.iPs.fjM = string;
                this.iPs.jlw = 2000L;
                FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
                layoutParams.gravity = 49;
                layoutParams.topMargin = UtilHelper.getStatusBarHeight() + l.getDimens(this.iOi.getPageContext().getPageActivity(), R.dimen.tbds228);
                if (this.iPq != null) {
                    this.iPq.removeView(this.iPs);
                    this.iPq.addView(this.iPs, layoutParams);
                    this.iPs.cEV();
                }
            }
        }
    }

    public void cj(int i, int i2) {
        if (this.iOj != null && i < i2) {
            this.iOj.p(i, i2);
        }
    }
}
