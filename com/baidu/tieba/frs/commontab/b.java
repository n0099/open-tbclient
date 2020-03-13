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
    private PbListView elw;
    private BdSwipeRefreshLayout enH;
    private m gqP;
    private FrsCommonTabFragment gvG;
    private a gvX;
    private d gvY;
    private boolean hasMore;
    private h mPullView;
    private BdListView.e eCC = new BdListView.e() { // from class: com.baidu.tieba.frs.commontab.b.1
        @Override // com.baidu.adp.widget.ListView.BdListView.e
        public void onScrollToBottom() {
            if (b.this.BK != null) {
                b.this.BK.stopScroll();
            }
            if (b.this.elw != null && b.this.gvG != null) {
                if (j.isNetWorkAvailable()) {
                    b.this.BK.setNextPage(b.this.elw);
                    b.this.elw.showEmptyView(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
                    b.this.elw.setOnClickListener(null);
                    if (b.this.hasMore) {
                        b.this.elw.showLoading();
                        b.this.gvG.btJ();
                        return;
                    }
                    b.this.elw.setText(b.this.gvG.getResources().getString(R.string.list_has_no_more));
                    b.this.elw.endLoadData();
                    return;
                }
                b.this.BK.setNextPage(null);
            }
        }
    };
    private RecyclerView.OnScrollListener fCV = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.frs.commontab.b.2
        private boolean gwa;

        @Override // android.support.v7.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i) {
            if (i == 0) {
                if (b.this.gqP != null) {
                    b.this.gqP.a(b.this.BK.getFirstVisiblePosition(), b.this.BK.getLastVisiblePosition(), this.gwa, true);
                }
                r.bvh().kp(true);
            }
        }

        @Override // android.support.v7.widget.RecyclerView.OnScrollListener
        public void onScrolled(RecyclerView recyclerView, int i, int i2) {
            super.onScrolled(recyclerView, i, i2);
            if (i2 > 0) {
                this.gwa = false;
            } else {
                this.gwa = true;
            }
        }
    };

    public b(FrsCommonTabFragment frsCommonTabFragment, View view, FrsViewData frsViewData) {
        if (frsCommonTabFragment != null && view != null) {
            this.gvG = frsCommonTabFragment;
            this.BK = (BdTypeRecyclerView) view.findViewById(R.id.frs_common_tab_recycler_view);
            this.BK.setLayoutManager(new LinearLayoutManager(this.gvG.getContext()));
            this.BK.setFadingEdgeLength(0);
            this.BK.setOverScrollMode(2);
            this.BK.setOnSrollToBottomListener(this.eCC);
            this.BK.addOnScrollListener(this.fCV);
            this.mPullView = new h(this.gvG.getPageContext());
            this.mPullView.setListPullRefreshListener(this.gvG);
            this.BK.setRecyclerListener(new RecyclerView.RecyclerListener() { // from class: com.baidu.tieba.frs.commontab.b.3
                @Override // android.support.v7.widget.RecyclerView.RecyclerListener
                public void onViewRecycled(RecyclerView.ViewHolder viewHolder) {
                    View view2 = viewHolder.itemView;
                    if (b.this.gqP != null) {
                        b.this.gqP.cl(view2);
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
            this.elw = new PbListView(this.gvG.getPageContext().getPageActivity());
            this.elw.getView();
            this.elw.setContainerBackgroundColorResId(R.color.cp_bg_line_e);
            this.elw.setHeight(l.getDimens(this.gvG.getActivity(), R.dimen.tbds182));
            this.elw.setLineGone();
            this.elw.setTextSize(R.dimen.tbfontsize33);
            this.elw.setTextColor(am.getColor(R.color.cp_cont_j));
            this.elw.setNoMoreTextColorId(R.color.cp_cont_e);
            this.elw.aHH();
            if (this.enH == null) {
                this.enH = (BdSwipeRefreshLayout) view.findViewById(R.id.frs_common_tab_pull_refresh_layout);
                this.enH.setProgressView(this.mPullView);
                am.setBackgroundColor(this.enH, R.color.cp_bg_line_e);
            }
            this.gvX = new a(this.gvG, this.BK, frsViewData);
            hu(false);
            if (this.gqP == null) {
                this.gqP = new m(this.gvG.getPageContext(), this.BK);
            }
            this.gqP.Ar(1);
            this.gqP.setUniqueId(this.gvG.getUniqueId());
        }
    }

    public void hu(boolean z) {
        if (this.enH != null) {
            this.enH.setRefreshing(z);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mPullView != null) {
            this.mPullView.changeSkin(i);
        }
        if (this.gvX != null) {
            this.gvX.notifyDataSetChanged();
        }
        if (this.elw != null) {
            this.elw.setTextColor(am.getColor(R.color.cp_cont_j));
            this.elw.changeSkin(i);
        }
        am.setBackgroundColor(this.enH, R.color.cp_bg_line_e);
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
            this.gvY = dVar;
            this.elw.showEmptyView(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
            this.BK.setNextPage(this.elw);
            if (this.hasMore) {
                this.elw.showEndLoadData();
            } else {
                this.elw.setText(this.gvG.getResources().getString(R.string.list_has_no_more));
                this.elw.endLoadData();
            }
            this.gvX.setData(dVar.threadList);
            this.gvX.notifyDataSetChanged();
            if (this.gqP != null) {
                this.gqP.a(this.BK.getFirstVisiblePosition(), this.BK.getLastVisiblePosition(), false, true);
            }
        }
    }

    public void setSelection(int i) {
        if (this.BK != null) {
            this.BK.setSelection(i);
        }
    }

    public void onDestroy() {
        if (this.gqP != null) {
            this.gqP.destroy();
        }
        if (this.gvX != null) {
            this.gvX.onDestory();
        }
    }

    public void resume() {
        if (this.gqP != null) {
            this.gqP.ccV();
        }
    }

    public void pause() {
        if (this.gqP != null) {
            this.gqP.ccU();
        }
    }

    public void lM(boolean z) {
        if (this.enH != null) {
            this.enH.setVisibility(z ? 0 : 8);
        }
    }

    public void Bm(String str) {
        bj bjVar;
        if (!StringUtils.isNull(str) && this.gvY != null && !v.isEmpty(this.gvY.threadList)) {
            Iterator<com.baidu.adp.widget.ListView.m> it = this.gvY.threadList.iterator();
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
                this.gvY.threadList.remove(bjVar);
                if (v.isEmpty(this.gvY.threadList)) {
                    this.gvY.threadList.add(new n());
                }
                this.gvX.setData(this.gvY.threadList);
                this.gvX.notifyDataSetChanged();
            }
        }
    }

    public void scrollToTop() {
        this.BK.scrollToPosition(0);
    }

    public void refreshView() {
        this.gvX.notifyDataSetChanged();
    }

    public void bdr() {
        this.mPullView.pullToRefresh(false);
    }

    public void lL(boolean z) {
        if (this.gvX != null) {
            this.gvX.lL(z);
        }
    }

    public BdTypeRecyclerView bGG() {
        return this.BK;
    }

    public m bEL() {
        return this.gqP;
    }

    public void setOnScrollListener(RecyclerView.OnScrollListener onScrollListener) {
        this.BK.setOnScrollListener(onScrollListener);
    }
}
