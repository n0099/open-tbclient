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
import com.baidu.tbadk.core.data.bh;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.core.view.PbListView;
import com.baidu.tbadk.core.view.UserPhotoLayout;
import com.baidu.tbadk.core.view.i;
import com.baidu.tieba.R;
import com.baidu.tieba.card.t;
import com.baidu.tieba.play.m;
import com.baidu.tieba.tbadkCore.FrsCommonImageLayout;
import com.baidu.tieba.tbadkCore.FrsViewData;
import com.baidu.tieba.tbadkCore.voice.PlayVoiceBnt;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes4.dex */
public class b {
    private PbListView dwJ;
    private BdSwipeRefreshLayout dyk;
    private FrsCommonTabFragment fCN;
    private a fDf;
    private d fDg;
    private m fxK;
    private boolean hasMore;
    private i mPullView;
    private BdTypeRecyclerView zj;
    private BdListView.e dJx = new BdListView.e() { // from class: com.baidu.tieba.frs.commontab.b.1
        @Override // com.baidu.adp.widget.ListView.BdListView.e
        public void onScrollToBottom() {
            if (b.this.zj != null) {
                b.this.zj.stopScroll();
            }
            if (b.this.dwJ != null && b.this.fCN != null) {
                if (j.isNetWorkAvailable()) {
                    b.this.zj.setNextPage(b.this.dwJ);
                    b.this.dwJ.showEmptyView(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
                    b.this.dwJ.setOnClickListener(null);
                    if (b.this.hasMore) {
                        b.this.dwJ.showLoading();
                        b.this.fCN.aYY();
                        return;
                    }
                    b.this.dwJ.setText(b.this.fCN.getResources().getString(R.string.list_has_no_more));
                    b.this.dwJ.endLoadData();
                    return;
                }
                b.this.zj.setNextPage(null);
            }
        }
    };
    private RecyclerView.OnScrollListener eFQ = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.frs.commontab.b.2
        private boolean fDi;

        @Override // android.support.v7.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i) {
            if (i == 0) {
                if (b.this.fxK != null) {
                    b.this.fxK.c(b.this.zj.getFirstVisiblePosition(), b.this.zj.getLastVisiblePosition(), this.fDi, true);
                }
                t.baw().iK(true);
            }
        }

        @Override // android.support.v7.widget.RecyclerView.OnScrollListener
        public void onScrolled(RecyclerView recyclerView, int i, int i2) {
            super.onScrolled(recyclerView, i, i2);
            if (i2 > 0) {
                this.fDi = false;
            } else {
                this.fDi = true;
            }
        }
    };

    public b(FrsCommonTabFragment frsCommonTabFragment, View view, FrsViewData frsViewData) {
        if (frsCommonTabFragment != null && view != null) {
            this.fCN = frsCommonTabFragment;
            this.zj = (BdTypeRecyclerView) view.findViewById(R.id.frs_common_tab_recycler_view);
            this.zj.setLayoutManager(new LinearLayoutManager(this.fCN.getContext()));
            this.zj.setFadingEdgeLength(0);
            this.zj.setOverScrollMode(2);
            this.zj.setOnSrollToBottomListener(this.dJx);
            this.zj.addOnScrollListener(this.eFQ);
            this.mPullView = new i(this.fCN.getPageContext());
            this.mPullView.setListPullRefreshListener(this.fCN);
            this.zj.setRecyclerListener(new RecyclerView.RecyclerListener() { // from class: com.baidu.tieba.frs.commontab.b.3
                @Override // android.support.v7.widget.RecyclerView.RecyclerListener
                public void onViewRecycled(RecyclerView.ViewHolder viewHolder) {
                    View view2 = viewHolder.itemView;
                    if (b.this.fxK != null) {
                        b.this.fxK.ck(view2);
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
            this.dwJ = new PbListView(this.fCN.getPageContext().getPageActivity());
            this.dwJ.getView();
            this.dwJ.setContainerBackgroundColorResId(R.color.cp_bg_line_e);
            this.dwJ.setHeight(l.getDimens(this.fCN.getActivity(), R.dimen.tbds182));
            this.dwJ.setLineGone();
            this.dwJ.setTextSize(R.dimen.tbfontsize33);
            this.dwJ.setTextColor(am.getColor(R.color.cp_cont_j));
            this.dwJ.setNoMoreTextColorId(R.color.cp_cont_e);
            this.dwJ.anL();
            if (this.dyk == null) {
                this.dyk = (BdSwipeRefreshLayout) view.findViewById(R.id.frs_common_tab_pull_refresh_layout);
                this.dyk.setProgressView(this.mPullView);
                am.setBackgroundColor(this.dyk, R.color.cp_bg_line_e);
            }
            this.fDf = new a(this.fCN, this.zj, frsViewData);
            fU(false);
            if (this.fxK == null) {
                this.fxK = new m(this.fCN.getPageContext(), this.zj);
            }
            this.fxK.setUniqueId(this.fCN.getUniqueId());
        }
    }

    public void fU(boolean z) {
        if (this.dyk != null) {
            this.dyk.setRefreshing(z);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mPullView != null) {
            this.mPullView.changeSkin(i);
        }
        if (this.fDf != null) {
            this.fDf.notifyDataSetChanged();
        }
        if (this.dwJ != null) {
            this.dwJ.setTextColor(am.getColor(R.color.cp_cont_j));
            this.dwJ.changeSkin(i);
        }
        am.setBackgroundColor(this.dyk, R.color.cp_bg_line_e);
    }

    public void a(d dVar) {
        if (dVar != null) {
            this.hasMore = dVar.hasMore;
            if (v.isEmpty(dVar.threadList)) {
                com.baidu.tieba.frs.m mVar = new com.baidu.tieba.frs.m();
                dVar.threadList = new ArrayList<>();
                dVar.threadList.add(mVar);
                dVar.hasMore = false;
            }
            this.fDg = dVar;
            this.dwJ.showEmptyView(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
            this.zj.setNextPage(this.dwJ);
            if (this.hasMore) {
                this.dwJ.showEndLoadData();
            } else {
                this.dwJ.setText(this.fCN.getResources().getString(R.string.list_has_no_more));
                this.dwJ.endLoadData();
            }
            this.fDf.setData(dVar.threadList);
            this.fDf.notifyDataSetChanged();
            if (this.fxK != null) {
                this.fxK.c(this.zj.getFirstVisiblePosition(), this.zj.getLastVisiblePosition(), false, true);
            }
        }
    }

    public void setSelection(int i) {
        if (this.zj != null) {
            this.zj.setSelection(i);
        }
    }

    public void onDestroy() {
        if (this.fxK != null) {
            this.fxK.destroy();
        }
        if (this.fDf != null) {
            this.fDf.onDestory();
        }
    }

    public void resume() {
        if (this.fxK != null) {
            this.fxK.bIX();
        }
    }

    public void pause() {
        if (this.fxK != null) {
            this.fxK.bIW();
        }
    }

    public void km(boolean z) {
        if (this.dyk != null) {
            this.dyk.setVisibility(z ? 0 : 8);
        }
    }

    public void vW(String str) {
        bh bhVar;
        if (!StringUtils.isNull(str) && this.fDg != null && !v.isEmpty(this.fDg.threadList)) {
            Iterator<com.baidu.adp.widget.ListView.m> it = this.fDg.threadList.iterator();
            while (true) {
                if (!it.hasNext()) {
                    bhVar = null;
                    break;
                }
                com.baidu.adp.widget.ListView.m next = it.next();
                if (next != null && (next instanceof bh) && TextUtils.equals(str, ((bh) next).getId())) {
                    bhVar = (bh) next;
                    break;
                }
            }
            if (bhVar != null) {
                this.fDg.threadList.remove(bhVar);
                if (v.isEmpty(this.fDg.threadList)) {
                    this.fDg.threadList.add(new com.baidu.tieba.frs.m());
                }
                this.fDf.setData(this.fDg.threadList);
                this.fDf.notifyDataSetChanged();
            }
        }
    }

    public void bjy() {
        this.zj.scrollToPosition(0);
    }

    public void refreshView() {
        this.fDf.notifyDataSetChanged();
    }

    public void aKh() {
        this.mPullView.pullToRefresh(false);
    }

    public void kl(boolean z) {
        if (this.fDf != null) {
            this.fDf.kl(z);
        }
    }

    public BdTypeRecyclerView bmE() {
        return this.zj;
    }

    public m bkJ() {
        return this.fxK;
    }
}
