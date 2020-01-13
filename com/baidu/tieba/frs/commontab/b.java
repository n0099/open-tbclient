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
/* loaded from: classes7.dex */
public class b {
    private BdTypeRecyclerView Bs;
    private PbListView ehe;
    private BdSwipeRefreshLayout ejj;
    private BdListView.e eyg = new BdListView.e() { // from class: com.baidu.tieba.frs.commontab.b.1
        @Override // com.baidu.adp.widget.ListView.BdListView.e
        public void onScrollToBottom() {
            if (b.this.Bs != null) {
                b.this.Bs.stopScroll();
            }
            if (b.this.ehe != null && b.this.gtr != null) {
                if (j.isNetWorkAvailable()) {
                    b.this.Bs.setNextPage(b.this.ehe);
                    b.this.ehe.showEmptyView(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
                    b.this.ehe.setOnClickListener(null);
                    if (b.this.hasMore) {
                        b.this.ehe.showLoading();
                        b.this.gtr.bsc();
                        return;
                    }
                    b.this.ehe.setText(b.this.gtr.getResources().getString(R.string.list_has_no_more));
                    b.this.ehe.endLoadData();
                    return;
                }
                b.this.Bs.setNextPage(null);
            }
        }
    };
    private RecyclerView.OnScrollListener fAi = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.frs.commontab.b.2
        private boolean gtL;

        @Override // android.support.v7.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i) {
            if (i == 0) {
                if (b.this.goz != null) {
                    b.this.goz.a(b.this.Bs.getFirstVisiblePosition(), b.this.Bs.getLastVisiblePosition(), this.gtL, true);
                }
                r.btA().kn(true);
            }
        }

        @Override // android.support.v7.widget.RecyclerView.OnScrollListener
        public void onScrolled(RecyclerView recyclerView, int i, int i2) {
            super.onScrolled(recyclerView, i, i2);
            if (i2 > 0) {
                this.gtL = false;
            } else {
                this.gtL = true;
            }
        }
    };
    private m goz;
    private a gtI;
    private d gtJ;
    private FrsCommonTabFragment gtr;
    private boolean hasMore;
    private h mPullView;

    public b(FrsCommonTabFragment frsCommonTabFragment, View view, FrsViewData frsViewData) {
        if (frsCommonTabFragment != null && view != null) {
            this.gtr = frsCommonTabFragment;
            this.Bs = (BdTypeRecyclerView) view.findViewById(R.id.frs_common_tab_recycler_view);
            this.Bs.setLayoutManager(new LinearLayoutManager(this.gtr.getContext()));
            this.Bs.setFadingEdgeLength(0);
            this.Bs.setOverScrollMode(2);
            this.Bs.setOnSrollToBottomListener(this.eyg);
            this.Bs.addOnScrollListener(this.fAi);
            this.mPullView = new h(this.gtr.getPageContext());
            this.mPullView.setListPullRefreshListener(this.gtr);
            this.Bs.setRecyclerListener(new RecyclerView.RecyclerListener() { // from class: com.baidu.tieba.frs.commontab.b.3
                @Override // android.support.v7.widget.RecyclerView.RecyclerListener
                public void onViewRecycled(RecyclerView.ViewHolder viewHolder) {
                    View view2 = viewHolder.itemView;
                    if (b.this.goz != null) {
                        b.this.goz.cl(view2);
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
            this.ehe = new PbListView(this.gtr.getPageContext().getPageActivity());
            this.ehe.getView();
            this.ehe.setContainerBackgroundColorResId(R.color.cp_bg_line_e);
            this.ehe.setHeight(l.getDimens(this.gtr.getActivity(), R.dimen.tbds182));
            this.ehe.setLineGone();
            this.ehe.setTextSize(R.dimen.tbfontsize33);
            this.ehe.setTextColor(am.getColor(R.color.cp_cont_j));
            this.ehe.setNoMoreTextColorId(R.color.cp_cont_e);
            this.ehe.aFs();
            if (this.ejj == null) {
                this.ejj = (BdSwipeRefreshLayout) view.findViewById(R.id.frs_common_tab_pull_refresh_layout);
                this.ejj.setProgressView(this.mPullView);
                am.setBackgroundColor(this.ejj, R.color.cp_bg_line_e);
            }
            this.gtI = new a(this.gtr, this.Bs, frsViewData);
            hn(false);
            if (this.goz == null) {
                this.goz = new m(this.gtr.getPageContext(), this.Bs);
            }
            this.goz.setUniqueId(this.gtr.getUniqueId());
        }
    }

    public void hn(boolean z) {
        if (this.ejj != null) {
            this.ejj.setRefreshing(z);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mPullView != null) {
            this.mPullView.changeSkin(i);
        }
        if (this.gtI != null) {
            this.gtI.notifyDataSetChanged();
        }
        if (this.ehe != null) {
            this.ehe.setTextColor(am.getColor(R.color.cp_cont_j));
            this.ehe.changeSkin(i);
        }
        am.setBackgroundColor(this.ejj, R.color.cp_bg_line_e);
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
            this.gtJ = dVar;
            this.ehe.showEmptyView(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
            this.Bs.setNextPage(this.ehe);
            if (this.hasMore) {
                this.ehe.showEndLoadData();
            } else {
                this.ehe.setText(this.gtr.getResources().getString(R.string.list_has_no_more));
                this.ehe.endLoadData();
            }
            this.gtI.setData(dVar.threadList);
            this.gtI.notifyDataSetChanged();
            if (this.goz != null) {
                this.goz.a(this.Bs.getFirstVisiblePosition(), this.Bs.getLastVisiblePosition(), false, true);
            }
        }
    }

    public void setSelection(int i) {
        if (this.Bs != null) {
            this.Bs.setSelection(i);
        }
    }

    public void onDestroy() {
        if (this.goz != null) {
            this.goz.destroy();
        }
        if (this.gtI != null) {
            this.gtI.onDestory();
        }
    }

    public void resume() {
        if (this.goz != null) {
            this.goz.cbr();
        }
    }

    public void pause() {
        if (this.goz != null) {
            this.goz.cbq();
        }
    }

    public void lJ(boolean z) {
        if (this.ejj != null) {
            this.ejj.setVisibility(z ? 0 : 8);
        }
    }

    public void AV(String str) {
        bj bjVar;
        if (!StringUtils.isNull(str) && this.gtJ != null && !v.isEmpty(this.gtJ.threadList)) {
            Iterator<com.baidu.adp.widget.ListView.m> it = this.gtJ.threadList.iterator();
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
                this.gtJ.threadList.remove(bjVar);
                if (v.isEmpty(this.gtJ.threadList)) {
                    this.gtJ.threadList.add(new n());
                }
                this.gtI.setData(this.gtJ.threadList);
                this.gtI.notifyDataSetChanged();
            }
        }
    }

    public void scrollToTop() {
        this.Bs.scrollToPosition(0);
    }

    public void refreshView() {
        this.gtI.notifyDataSetChanged();
    }

    public void baZ() {
        this.mPullView.pullToRefresh(false);
    }

    public void lI(boolean z) {
        if (this.gtI != null) {
            this.gtI.lI(z);
        }
    }

    public BdTypeRecyclerView bFb() {
        return this.Bs;
    }

    public m bDf() {
        return this.goz;
    }

    public void setOnScrollListener(RecyclerView.OnScrollListener onScrollListener) {
        this.Bs.setOnScrollListener(onScrollListener);
    }
}
