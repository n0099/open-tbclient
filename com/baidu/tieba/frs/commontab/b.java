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
    private PbListView eli;
    private BdSwipeRefreshLayout ens;
    private m gqA;
    private a gvJ;
    private d gvK;
    private FrsCommonTabFragment gvs;
    private boolean hasMore;
    private h mPullView;
    private BdListView.e eCo = new BdListView.e() { // from class: com.baidu.tieba.frs.commontab.b.1
        @Override // com.baidu.adp.widget.ListView.BdListView.e
        public void onScrollToBottom() {
            if (b.this.BK != null) {
                b.this.BK.stopScroll();
            }
            if (b.this.eli != null && b.this.gvs != null) {
                if (j.isNetWorkAvailable()) {
                    b.this.BK.setNextPage(b.this.eli);
                    b.this.eli.showEmptyView(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
                    b.this.eli.setOnClickListener(null);
                    if (b.this.hasMore) {
                        b.this.eli.showLoading();
                        b.this.gvs.btG();
                        return;
                    }
                    b.this.eli.setText(b.this.gvs.getResources().getString(R.string.list_has_no_more));
                    b.this.eli.endLoadData();
                    return;
                }
                b.this.BK.setNextPage(null);
            }
        }
    };
    private RecyclerView.OnScrollListener fCG = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.frs.commontab.b.2
        private boolean gvM;

        @Override // android.support.v7.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i) {
            if (i == 0) {
                if (b.this.gqA != null) {
                    b.this.gqA.a(b.this.BK.getFirstVisiblePosition(), b.this.BK.getLastVisiblePosition(), this.gvM, true);
                }
                r.bve().kp(true);
            }
        }

        @Override // android.support.v7.widget.RecyclerView.OnScrollListener
        public void onScrolled(RecyclerView recyclerView, int i, int i2) {
            super.onScrolled(recyclerView, i, i2);
            if (i2 > 0) {
                this.gvM = false;
            } else {
                this.gvM = true;
            }
        }
    };

    public b(FrsCommonTabFragment frsCommonTabFragment, View view, FrsViewData frsViewData) {
        if (frsCommonTabFragment != null && view != null) {
            this.gvs = frsCommonTabFragment;
            this.BK = (BdTypeRecyclerView) view.findViewById(R.id.frs_common_tab_recycler_view);
            this.BK.setLayoutManager(new LinearLayoutManager(this.gvs.getContext()));
            this.BK.setFadingEdgeLength(0);
            this.BK.setOverScrollMode(2);
            this.BK.setOnSrollToBottomListener(this.eCo);
            this.BK.addOnScrollListener(this.fCG);
            this.mPullView = new h(this.gvs.getPageContext());
            this.mPullView.setListPullRefreshListener(this.gvs);
            this.BK.setRecyclerListener(new RecyclerView.RecyclerListener() { // from class: com.baidu.tieba.frs.commontab.b.3
                @Override // android.support.v7.widget.RecyclerView.RecyclerListener
                public void onViewRecycled(RecyclerView.ViewHolder viewHolder) {
                    View view2 = viewHolder.itemView;
                    if (b.this.gqA != null) {
                        b.this.gqA.cl(view2);
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
            this.eli = new PbListView(this.gvs.getPageContext().getPageActivity());
            this.eli.getView();
            this.eli.setContainerBackgroundColorResId(R.color.cp_bg_line_e);
            this.eli.setHeight(l.getDimens(this.gvs.getActivity(), R.dimen.tbds182));
            this.eli.setLineGone();
            this.eli.setTextSize(R.dimen.tbfontsize33);
            this.eli.setTextColor(am.getColor(R.color.cp_cont_j));
            this.eli.setNoMoreTextColorId(R.color.cp_cont_e);
            this.eli.aHE();
            if (this.ens == null) {
                this.ens = (BdSwipeRefreshLayout) view.findViewById(R.id.frs_common_tab_pull_refresh_layout);
                this.ens.setProgressView(this.mPullView);
                am.setBackgroundColor(this.ens, R.color.cp_bg_line_e);
            }
            this.gvJ = new a(this.gvs, this.BK, frsViewData);
            hu(false);
            if (this.gqA == null) {
                this.gqA = new m(this.gvs.getPageContext(), this.BK);
            }
            this.gqA.Ar(1);
            this.gqA.setUniqueId(this.gvs.getUniqueId());
        }
    }

    public void hu(boolean z) {
        if (this.ens != null) {
            this.ens.setRefreshing(z);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mPullView != null) {
            this.mPullView.changeSkin(i);
        }
        if (this.gvJ != null) {
            this.gvJ.notifyDataSetChanged();
        }
        if (this.eli != null) {
            this.eli.setTextColor(am.getColor(R.color.cp_cont_j));
            this.eli.changeSkin(i);
        }
        am.setBackgroundColor(this.ens, R.color.cp_bg_line_e);
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
            this.gvK = dVar;
            this.eli.showEmptyView(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
            this.BK.setNextPage(this.eli);
            if (this.hasMore) {
                this.eli.showEndLoadData();
            } else {
                this.eli.setText(this.gvs.getResources().getString(R.string.list_has_no_more));
                this.eli.endLoadData();
            }
            this.gvJ.setData(dVar.threadList);
            this.gvJ.notifyDataSetChanged();
            if (this.gqA != null) {
                this.gqA.a(this.BK.getFirstVisiblePosition(), this.BK.getLastVisiblePosition(), false, true);
            }
        }
    }

    public void setSelection(int i) {
        if (this.BK != null) {
            this.BK.setSelection(i);
        }
    }

    public void onDestroy() {
        if (this.gqA != null) {
            this.gqA.destroy();
        }
        if (this.gvJ != null) {
            this.gvJ.onDestory();
        }
    }

    public void resume() {
        if (this.gqA != null) {
            this.gqA.ccS();
        }
    }

    public void pause() {
        if (this.gqA != null) {
            this.gqA.ccR();
        }
    }

    public void lM(boolean z) {
        if (this.ens != null) {
            this.ens.setVisibility(z ? 0 : 8);
        }
    }

    public void Bl(String str) {
        bj bjVar;
        if (!StringUtils.isNull(str) && this.gvK != null && !v.isEmpty(this.gvK.threadList)) {
            Iterator<com.baidu.adp.widget.ListView.m> it = this.gvK.threadList.iterator();
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
                this.gvK.threadList.remove(bjVar);
                if (v.isEmpty(this.gvK.threadList)) {
                    this.gvK.threadList.add(new n());
                }
                this.gvJ.setData(this.gvK.threadList);
                this.gvJ.notifyDataSetChanged();
            }
        }
    }

    public void scrollToTop() {
        this.BK.scrollToPosition(0);
    }

    public void refreshView() {
        this.gvJ.notifyDataSetChanged();
    }

    public void bdo() {
        this.mPullView.pullToRefresh(false);
    }

    public void lL(boolean z) {
        if (this.gvJ != null) {
            this.gvJ.lL(z);
        }
    }

    public BdTypeRecyclerView bGD() {
        return this.BK;
    }

    public m bEI() {
        return this.gqA;
    }

    public void setOnScrollListener(RecyclerView.OnScrollListener onScrollListener) {
        this.BK.setOnScrollListener(onScrollListener);
    }
}
