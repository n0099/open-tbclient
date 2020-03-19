package com.baidu.tieba.frs.commontab;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.j;
import com.baidu.adp.lib.util.l;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.adp.widget.refresh.BdSwipeRefreshLayout;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.bj;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.core.view.PbListView;
import com.baidu.tbadk.core.view.UserPhotoLayout;
import com.baidu.tbadk.core.view.h;
import com.baidu.tieba.R;
import com.baidu.tieba.card.r;
import com.baidu.tieba.frs.o;
import com.baidu.tieba.play.m;
import com.baidu.tieba.tbadkCore.FrsCommonImageLayout;
import com.baidu.tieba.tbadkCore.FrsViewData;
import com.baidu.tieba.tbadkCore.voice.PlayVoiceBnt;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import tbclient.FrsTabInfo;
/* loaded from: classes9.dex */
public class b {
    private BdTypeRecyclerView BK;
    private PbListView elM;
    private BdSwipeRefreshLayout enY;
    private m grz;
    private a gwE;
    private d gwF;
    private RelativeLayout gwG;
    private com.baidu.tieba.frs.entelechy.tabView.frsTabFollowPost.a gwH;
    private FrsCommonTabFragment gwk;
    private boolean hasMore;
    private h mPullView;
    private BdListView.e eCY = new BdListView.e() { // from class: com.baidu.tieba.frs.commontab.b.1
        @Override // com.baidu.adp.widget.ListView.BdListView.e
        public void onScrollToBottom() {
            if (b.this.BK != null) {
                b.this.BK.stopScroll();
            }
            if (b.this.elM != null && b.this.gwk != null) {
                if (j.isNetWorkAvailable()) {
                    b.this.BK.setNextPage(b.this.elM);
                    b.this.elM.showEmptyView(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
                    b.this.elM.setOnClickListener(null);
                    if (b.this.hasMore) {
                        b.this.elM.showLoading();
                        b.this.gwk.btO();
                        return;
                    }
                    b.this.elM.setText(b.this.gwk.getResources().getString(R.string.list_has_no_more));
                    b.this.elM.endLoadData();
                    return;
                }
                b.this.BK.setNextPage(null);
            }
        }
    };
    private RecyclerView.OnScrollListener fDD = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.frs.commontab.b.2
        private boolean gwJ;

        @Override // android.support.v7.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i) {
            if (i == 0) {
                if (b.this.grz != null) {
                    b.this.grz.a(b.this.BK.getFirstVisiblePosition(), b.this.BK.getLastVisiblePosition(), this.gwJ, true);
                }
                r.bvm().ku(true);
            }
        }

        @Override // android.support.v7.widget.RecyclerView.OnScrollListener
        public void onScrolled(RecyclerView recyclerView, int i, int i2) {
            super.onScrolled(recyclerView, i, i2);
            if (i2 > 0) {
                this.gwJ = false;
            } else {
                this.gwJ = true;
            }
        }
    };

    public b(FrsCommonTabFragment frsCommonTabFragment, View view, FrsViewData frsViewData) {
        if (frsCommonTabFragment != null && view != null) {
            this.gwk = frsCommonTabFragment;
            this.BK = (BdTypeRecyclerView) view.findViewById(R.id.frs_common_tab_recycler_view);
            this.BK.setLayoutManager(new LinearLayoutManager(this.gwk.getContext()));
            this.BK.setFadingEdgeLength(0);
            this.BK.setOverScrollMode(2);
            this.BK.setOnSrollToBottomListener(this.eCY);
            this.BK.addOnScrollListener(this.fDD);
            this.mPullView = new h(this.gwk.getPageContext());
            this.mPullView.setListPullRefreshListener(this.gwk);
            this.BK.setRecyclerListener(new RecyclerView.RecyclerListener() { // from class: com.baidu.tieba.frs.commontab.b.3
                @Override // android.support.v7.widget.RecyclerView.RecyclerListener
                public void onViewRecycled(RecyclerView.ViewHolder viewHolder) {
                    View view2 = viewHolder.itemView;
                    if (b.this.grz != null) {
                        b.this.grz.cl(view2);
                    }
                    if (view2 != null) {
                        PlayVoiceBnt playVoiceBnt = (PlayVoiceBnt) view2.findViewById(R.id.abstract_voice);
                        if (playVoiceBnt != null) {
                            playVoiceBnt.reset();
                        }
                        FrsCommonImageLayout frsCommonImageLayout = (FrsCommonImageLayout) view2.findViewById(R.id.abstract_img_layout);
                        if (frsCommonImageLayout != null) {
                            frsCommonImageLayout.reset();
                        }
                        if (view2 instanceof UserPhotoLayout) {
                            ((UserPhotoLayout) view2).reset();
                        }
                    }
                }
            });
            this.elM = new PbListView(this.gwk.getPageContext().getPageActivity());
            this.elM.getView();
            this.elM.setContainerBackgroundColorResId(R.color.cp_bg_line_e);
            this.elM.setHeight(l.getDimens(this.gwk.getActivity(), R.dimen.tbds182));
            this.elM.setLineGone();
            this.elM.setTextSize(R.dimen.tbfontsize33);
            this.elM.setTextColor(am.getColor(R.color.cp_cont_j));
            this.elM.setNoMoreTextColorId(R.color.cp_cont_e);
            this.elM.aHL();
            if (this.enY == null) {
                this.enY = (BdSwipeRefreshLayout) view.findViewById(R.id.frs_common_tab_pull_refresh_layout);
                this.enY.setProgressView(this.mPullView);
                am.setBackgroundColor(this.enY, R.color.cp_bg_line_e);
            }
            this.gwE = new a(this.gwk, this.BK, frsViewData);
            hv(false);
            if (this.grz == null) {
                this.grz = new m(this.gwk.getPageContext(), this.BK);
            }
            this.grz.Az(1);
            this.grz.setUniqueId(this.gwk.getUniqueId());
            if (this.gwk.isGeneralTab == 1) {
                this.gwG = new RelativeLayout(this.gwk.getContext());
                this.gwG.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
                this.gwH = new com.baidu.tieba.frs.entelechy.tabView.frsTabFollowPost.a(this.gwk, this.gwG);
                this.BK.addHeaderView(this.gwG, 0);
                this.gwH.setData(bGU());
            }
        }
    }

    public void hv(boolean z) {
        if (this.enY != null) {
            this.enY.setRefreshing(z);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mPullView != null) {
            this.mPullView.changeSkin(i);
        }
        if (this.gwE != null) {
            this.gwE.notifyDataSetChanged();
        }
        if (this.elM != null) {
            this.elM.setTextColor(am.getColor(R.color.cp_cont_j));
            this.elM.changeSkin(i);
        }
        if (this.gwH != null) {
            this.gwH.onChangeSkinType();
        }
        am.setBackgroundColor(this.enY, R.color.cp_bg_line_e);
    }

    public void a(d dVar) {
        if (dVar != null) {
            this.hasMore = dVar.hasMore;
            if (v.isEmpty(dVar.threadList)) {
                o oVar = new o();
                dVar.threadList = new ArrayList<>();
                dVar.threadList.add(oVar);
                dVar.hasMore = false;
            }
            this.gwF = dVar;
            this.elM.showEmptyView(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
            this.BK.setNextPage(this.elM);
            if (this.hasMore) {
                this.elM.showEndLoadData();
            } else {
                this.elM.setText(this.gwk.getResources().getString(R.string.list_has_no_more));
                this.elM.endLoadData();
            }
            this.gwE.setData(dVar.threadList);
            this.gwE.notifyDataSetChanged();
            if (this.grz != null) {
                this.grz.a(this.BK.getFirstVisiblePosition(), this.BK.getLastVisiblePosition(), false, true);
            }
            if (this.gwk.isGeneralTab == 1 && this.gwH != null) {
                this.gwH.changeState(this.gwk.getSortType());
                this.gwH.setFid(this.gwk.forumId);
            }
        }
    }

    private List<FrsTabInfo> bGU() {
        ArrayList arrayList = new ArrayList();
        FrsTabInfo.Builder builder = new FrsTabInfo.Builder();
        builder.tab_id = 2;
        FrsTabInfo build = builder.build(true);
        FrsTabInfo.Builder builder2 = new FrsTabInfo.Builder();
        builder2.tab_id = 3;
        FrsTabInfo build2 = builder2.build(true);
        arrayList.add(build);
        arrayList.add(build2);
        return arrayList;
    }

    public void setSelection(int i) {
        if (this.BK != null) {
            this.BK.setSelection(i);
        }
    }

    public void onDestroy() {
        if (this.grz != null) {
            this.grz.destroy();
        }
        if (this.gwE != null) {
            this.gwE.onDestory();
        }
    }

    public void resume() {
        if (this.grz != null) {
            this.grz.cdo();
        }
    }

    public void pause() {
        if (this.grz != null) {
            this.grz.cdn();
        }
    }

    public void lR(boolean z) {
        if (this.enY != null) {
            this.enY.setVisibility(z ? 0 : 8);
        }
    }

    public void bGr() {
        if (this.enY != null) {
            this.enY.interruptRefresh();
        }
    }

    public void Bn(String str) {
        bj bjVar;
        if (!StringUtils.isNull(str) && this.gwF != null && !v.isEmpty(this.gwF.threadList)) {
            Iterator<com.baidu.adp.widget.ListView.m> it = this.gwF.threadList.iterator();
            while (true) {
                if (!it.hasNext()) {
                    bjVar = null;
                    break;
                }
                com.baidu.adp.widget.ListView.m next = it.next();
                if (next != null && (next instanceof bj) && TextUtils.equals(str, ((bj) next).getId())) {
                    bjVar = (bj) next;
                    break;
                }
            }
            if (bjVar != null) {
                this.gwF.threadList.remove(bjVar);
                if (v.isEmpty(this.gwF.threadList)) {
                    this.gwF.threadList.add(new o());
                }
                this.gwE.setData(this.gwF.threadList);
                this.gwE.notifyDataSetChanged();
            }
        }
    }

    public void scrollToTop() {
        this.BK.scrollToPosition(0);
    }

    public void refreshView() {
        this.gwE.notifyDataSetChanged();
    }

    public void bdw() {
        this.mPullView.pullToRefresh(false);
    }

    public void lQ(boolean z) {
        if (this.gwE != null) {
            this.gwE.lQ(z);
        }
    }

    public BdTypeRecyclerView bGV() {
        return this.BK;
    }

    public m bEV() {
        return this.grz;
    }

    public void setOnScrollListener(RecyclerView.OnScrollListener onScrollListener) {
        this.BK.setOnScrollListener(onScrollListener);
    }
}
