package com.baidu.tieba.frs.commontab;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.View;
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
import com.baidu.tieba.frs.n;
import com.baidu.tieba.play.m;
import com.baidu.tieba.tbadkCore.FrsCommonImageLayout;
import com.baidu.tieba.tbadkCore.FrsViewData;
import com.baidu.tieba.tbadkCore.voice.PlayVoiceBnt;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes9.dex */
public class b {
    private BdTypeRecyclerView BK;
    private PbListView elj;
    private BdSwipeRefreshLayout ent;
    private m gqC;
    private a gvL;
    private d gvM;
    private FrsCommonTabFragment gvu;
    private boolean hasMore;
    private h mPullView;
    private BdListView.e eCp = new BdListView.e() { // from class: com.baidu.tieba.frs.commontab.b.1
        @Override // com.baidu.adp.widget.ListView.BdListView.e
        public void onScrollToBottom() {
            if (b.this.BK != null) {
                b.this.BK.stopScroll();
            }
            if (b.this.elj != null && b.this.gvu != null) {
                if (j.isNetWorkAvailable()) {
                    b.this.BK.setNextPage(b.this.elj);
                    b.this.elj.showEmptyView(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
                    b.this.elj.setOnClickListener(null);
                    if (b.this.hasMore) {
                        b.this.elj.showLoading();
                        b.this.gvu.btI();
                        return;
                    }
                    b.this.elj.setText(b.this.gvu.getResources().getString(R.string.list_has_no_more));
                    b.this.elj.endLoadData();
                    return;
                }
                b.this.BK.setNextPage(null);
            }
        }
    };
    private RecyclerView.OnScrollListener fCI = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.frs.commontab.b.2
        private boolean gvO;

        @Override // android.support.v7.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i) {
            if (i == 0) {
                if (b.this.gqC != null) {
                    b.this.gqC.a(b.this.BK.getFirstVisiblePosition(), b.this.BK.getLastVisiblePosition(), this.gvO, true);
                }
                r.bvg().kp(true);
            }
        }

        @Override // android.support.v7.widget.RecyclerView.OnScrollListener
        public void onScrolled(RecyclerView recyclerView, int i, int i2) {
            super.onScrolled(recyclerView, i, i2);
            if (i2 > 0) {
                this.gvO = false;
            } else {
                this.gvO = true;
            }
        }
    };

    public b(FrsCommonTabFragment frsCommonTabFragment, View view, FrsViewData frsViewData) {
        if (frsCommonTabFragment != null && view != null) {
            this.gvu = frsCommonTabFragment;
            this.BK = (BdTypeRecyclerView) view.findViewById(R.id.frs_common_tab_recycler_view);
            this.BK.setLayoutManager(new LinearLayoutManager(this.gvu.getContext()));
            this.BK.setFadingEdgeLength(0);
            this.BK.setOverScrollMode(2);
            this.BK.setOnSrollToBottomListener(this.eCp);
            this.BK.addOnScrollListener(this.fCI);
            this.mPullView = new h(this.gvu.getPageContext());
            this.mPullView.setListPullRefreshListener(this.gvu);
            this.BK.setRecyclerListener(new RecyclerView.RecyclerListener() { // from class: com.baidu.tieba.frs.commontab.b.3
                @Override // android.support.v7.widget.RecyclerView.RecyclerListener
                public void onViewRecycled(RecyclerView.ViewHolder viewHolder) {
                    View view2 = viewHolder.itemView;
                    if (b.this.gqC != null) {
                        b.this.gqC.cl(view2);
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
            this.elj = new PbListView(this.gvu.getPageContext().getPageActivity());
            this.elj.getView();
            this.elj.setContainerBackgroundColorResId(R.color.cp_bg_line_e);
            this.elj.setHeight(l.getDimens(this.gvu.getActivity(), R.dimen.tbds182));
            this.elj.setLineGone();
            this.elj.setTextSize(R.dimen.tbfontsize33);
            this.elj.setTextColor(am.getColor(R.color.cp_cont_j));
            this.elj.setNoMoreTextColorId(R.color.cp_cont_e);
            this.elj.aHG();
            if (this.ent == null) {
                this.ent = (BdSwipeRefreshLayout) view.findViewById(R.id.frs_common_tab_pull_refresh_layout);
                this.ent.setProgressView(this.mPullView);
                am.setBackgroundColor(this.ent, R.color.cp_bg_line_e);
            }
            this.gvL = new a(this.gvu, this.BK, frsViewData);
            hu(false);
            if (this.gqC == null) {
                this.gqC = new m(this.gvu.getPageContext(), this.BK);
            }
            this.gqC.Ar(1);
            this.gqC.setUniqueId(this.gvu.getUniqueId());
        }
    }

    public void hu(boolean z) {
        if (this.ent != null) {
            this.ent.setRefreshing(z);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mPullView != null) {
            this.mPullView.changeSkin(i);
        }
        if (this.gvL != null) {
            this.gvL.notifyDataSetChanged();
        }
        if (this.elj != null) {
            this.elj.setTextColor(am.getColor(R.color.cp_cont_j));
            this.elj.changeSkin(i);
        }
        am.setBackgroundColor(this.ent, R.color.cp_bg_line_e);
    }

    public void a(d dVar) {
        if (dVar != null) {
            this.hasMore = dVar.hasMore;
            if (v.isEmpty(dVar.threadList)) {
                n nVar = new n();
                dVar.threadList = new ArrayList<>();
                dVar.threadList.add(nVar);
                dVar.hasMore = false;
            }
            this.gvM = dVar;
            this.elj.showEmptyView(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
            this.BK.setNextPage(this.elj);
            if (this.hasMore) {
                this.elj.showEndLoadData();
            } else {
                this.elj.setText(this.gvu.getResources().getString(R.string.list_has_no_more));
                this.elj.endLoadData();
            }
            this.gvL.setData(dVar.threadList);
            this.gvL.notifyDataSetChanged();
            if (this.gqC != null) {
                this.gqC.a(this.BK.getFirstVisiblePosition(), this.BK.getLastVisiblePosition(), false, true);
            }
        }
    }

    public void setSelection(int i) {
        if (this.BK != null) {
            this.BK.setSelection(i);
        }
    }

    public void onDestroy() {
        if (this.gqC != null) {
            this.gqC.destroy();
        }
        if (this.gvL != null) {
            this.gvL.onDestory();
        }
    }

    public void resume() {
        if (this.gqC != null) {
            this.gqC.ccU();
        }
    }

    public void pause() {
        if (this.gqC != null) {
            this.gqC.ccT();
        }
    }

    public void lM(boolean z) {
        if (this.ent != null) {
            this.ent.setVisibility(z ? 0 : 8);
        }
    }

    public void Bl(String str) {
        bj bjVar;
        if (!StringUtils.isNull(str) && this.gvM != null && !v.isEmpty(this.gvM.threadList)) {
            Iterator<com.baidu.adp.widget.ListView.m> it = this.gvM.threadList.iterator();
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
                this.gvM.threadList.remove(bjVar);
                if (v.isEmpty(this.gvM.threadList)) {
                    this.gvM.threadList.add(new n());
                }
                this.gvL.setData(this.gvM.threadList);
                this.gvL.notifyDataSetChanged();
            }
        }
    }

    public void scrollToTop() {
        this.BK.scrollToPosition(0);
    }

    public void refreshView() {
        this.gvL.notifyDataSetChanged();
    }

    public void bdq() {
        this.mPullView.pullToRefresh(false);
    }

    public void lL(boolean z) {
        if (this.gvL != null) {
            this.gvL.lL(z);
        }
    }

    public BdTypeRecyclerView bGF() {
        return this.BK;
    }

    public m bEK() {
        return this.gqC;
    }

    public void setOnScrollListener(RecyclerView.OnScrollListener onScrollListener) {
        this.BK.setOnScrollListener(onScrollListener);
    }
}
