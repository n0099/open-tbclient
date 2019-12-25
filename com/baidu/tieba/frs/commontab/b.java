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
/* loaded from: classes6.dex */
public class b {
    private BdTypeRecyclerView Bn;
    private PbListView egU;
    private BdSwipeRefreshLayout eiv;
    private BdListView.e ewT = new BdListView.e() { // from class: com.baidu.tieba.frs.commontab.b.1
        @Override // com.baidu.adp.widget.ListView.BdListView.e
        public void onScrollToBottom() {
            if (b.this.Bn != null) {
                b.this.Bn.stopScroll();
            }
            if (b.this.egU != null && b.this.gqi != null) {
                if (j.isNetWorkAvailable()) {
                    b.this.Bn.setNextPage(b.this.egU);
                    b.this.egU.showEmptyView(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
                    b.this.egU.setOnClickListener(null);
                    if (b.this.hasMore) {
                        b.this.egU.showLoading();
                        b.this.gqi.bra();
                        return;
                    }
                    b.this.egU.setText(b.this.gqi.getResources().getString(R.string.list_has_no_more));
                    b.this.egU.endLoadData();
                    return;
                }
                b.this.Bn.setNextPage(null);
            }
        }
    };
    private RecyclerView.OnScrollListener fwX = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.frs.commontab.b.2
        private boolean gqC;

        @Override // android.support.v7.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i) {
            if (i == 0) {
                if (b.this.glq != null) {
                    b.this.glq.a(b.this.Bn.getFirstVisiblePosition(), b.this.Bn.getLastVisiblePosition(), this.gqC, true);
                }
                r.bsy().kc(true);
            }
        }

        @Override // android.support.v7.widget.RecyclerView.OnScrollListener
        public void onScrolled(RecyclerView recyclerView, int i, int i2) {
            super.onScrolled(recyclerView, i, i2);
            if (i2 > 0) {
                this.gqC = false;
            } else {
                this.gqC = true;
            }
        }
    };
    private m glq;
    private d gqA;
    private FrsCommonTabFragment gqi;
    private a gqz;
    private boolean hasMore;
    private h mPullView;

    public b(FrsCommonTabFragment frsCommonTabFragment, View view, FrsViewData frsViewData) {
        if (frsCommonTabFragment != null && view != null) {
            this.gqi = frsCommonTabFragment;
            this.Bn = (BdTypeRecyclerView) view.findViewById(R.id.frs_common_tab_recycler_view);
            this.Bn.setLayoutManager(new LinearLayoutManager(this.gqi.getContext()));
            this.Bn.setFadingEdgeLength(0);
            this.Bn.setOverScrollMode(2);
            this.Bn.setOnSrollToBottomListener(this.ewT);
            this.Bn.addOnScrollListener(this.fwX);
            this.mPullView = new h(this.gqi.getPageContext());
            this.mPullView.setListPullRefreshListener(this.gqi);
            this.Bn.setRecyclerListener(new RecyclerView.RecyclerListener() { // from class: com.baidu.tieba.frs.commontab.b.3
                @Override // android.support.v7.widget.RecyclerView.RecyclerListener
                public void onViewRecycled(RecyclerView.ViewHolder viewHolder) {
                    View view2 = viewHolder.itemView;
                    if (b.this.glq != null) {
                        b.this.glq.cg(view2);
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
            this.egU = new PbListView(this.gqi.getPageContext().getPageActivity());
            this.egU.getView();
            this.egU.setContainerBackgroundColorResId(R.color.cp_bg_line_e);
            this.egU.setHeight(l.getDimens(this.gqi.getActivity(), R.dimen.tbds182));
            this.egU.setLineGone();
            this.egU.setTextSize(R.dimen.tbfontsize33);
            this.egU.setTextColor(am.getColor(R.color.cp_cont_j));
            this.egU.setNoMoreTextColorId(R.color.cp_cont_e);
            this.egU.aEZ();
            if (this.eiv == null) {
                this.eiv = (BdSwipeRefreshLayout) view.findViewById(R.id.frs_common_tab_pull_refresh_layout);
                this.eiv.setProgressView(this.mPullView);
                am.setBackgroundColor(this.eiv, R.color.cp_bg_line_e);
            }
            this.gqz = new a(this.gqi, this.Bn, frsViewData);
            hi(false);
            if (this.glq == null) {
                this.glq = new m(this.gqi.getPageContext(), this.Bn);
            }
            this.glq.setUniqueId(this.gqi.getUniqueId());
        }
    }

    public void hi(boolean z) {
        if (this.eiv != null) {
            this.eiv.setRefreshing(z);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mPullView != null) {
            this.mPullView.changeSkin(i);
        }
        if (this.gqz != null) {
            this.gqz.notifyDataSetChanged();
        }
        if (this.egU != null) {
            this.egU.setTextColor(am.getColor(R.color.cp_cont_j));
            this.egU.changeSkin(i);
        }
        am.setBackgroundColor(this.eiv, R.color.cp_bg_line_e);
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
            this.gqA = dVar;
            this.egU.showEmptyView(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
            this.Bn.setNextPage(this.egU);
            if (this.hasMore) {
                this.egU.showEndLoadData();
            } else {
                this.egU.setText(this.gqi.getResources().getString(R.string.list_has_no_more));
                this.egU.endLoadData();
            }
            this.gqz.setData(dVar.threadList);
            this.gqz.notifyDataSetChanged();
            if (this.glq != null) {
                this.glq.a(this.Bn.getFirstVisiblePosition(), this.Bn.getLastVisiblePosition(), false, true);
            }
        }
    }

    public void setSelection(int i) {
        if (this.Bn != null) {
            this.Bn.setSelection(i);
        }
    }

    public void onDestroy() {
        if (this.glq != null) {
            this.glq.destroy();
        }
        if (this.gqz != null) {
            this.gqz.onDestory();
        }
    }

    public void resume() {
        if (this.glq != null) {
            this.glq.cai();
        }
    }

    public void pause() {
        if (this.glq != null) {
            this.glq.cah();
        }
    }

    public void ly(boolean z) {
        if (this.eiv != null) {
            this.eiv.setVisibility(z ? 0 : 8);
        }
    }

    public void AL(String str) {
        bj bjVar;
        if (!StringUtils.isNull(str) && this.gqA != null && !v.isEmpty(this.gqA.threadList)) {
            Iterator<com.baidu.adp.widget.ListView.m> it = this.gqA.threadList.iterator();
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
                this.gqA.threadList.remove(bjVar);
                if (v.isEmpty(this.gqA.threadList)) {
                    this.gqA.threadList.add(new n());
                }
                this.gqz.setData(this.gqA.threadList);
                this.gqz.notifyDataSetChanged();
            }
        }
    }

    public void scrollToTop() {
        this.Bn.scrollToPosition(0);
    }

    public void refreshView() {
        this.gqz.notifyDataSetChanged();
    }

    public void baE() {
        this.mPullView.pullToRefresh(false);
    }

    public void lx(boolean z) {
        if (this.gqz != null) {
            this.gqz.lx(z);
        }
    }

    public BdTypeRecyclerView bDZ() {
        return this.Bn;
    }

    public m bCd() {
        return this.glq;
    }

    public void setOnScrollListener(RecyclerView.OnScrollListener onScrollListener) {
        this.Bn.setOnScrollListener(onScrollListener);
    }
}
