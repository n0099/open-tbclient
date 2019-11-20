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
    private PbListView dvS;
    private BdSwipeRefreshLayout dxt;
    private FrsCommonTabFragment fBW;
    private a fCo;
    private d fCp;
    private m fwT;
    private boolean hasMore;
    private i mPullView;
    private BdTypeRecyclerView yJ;
    private BdListView.e dIG = new BdListView.e() { // from class: com.baidu.tieba.frs.commontab.b.1
        @Override // com.baidu.adp.widget.ListView.BdListView.e
        public void onScrollToBottom() {
            if (b.this.yJ != null) {
                b.this.yJ.stopScroll();
            }
            if (b.this.dvS != null && b.this.fBW != null) {
                if (j.isNetWorkAvailable()) {
                    b.this.yJ.setNextPage(b.this.dvS);
                    b.this.dvS.showEmptyView(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
                    b.this.dvS.setOnClickListener(null);
                    if (b.this.hasMore) {
                        b.this.dvS.showLoading();
                        b.this.fBW.aYW();
                        return;
                    }
                    b.this.dvS.setText(b.this.fBW.getResources().getString(R.string.list_has_no_more));
                    b.this.dvS.endLoadData();
                    return;
                }
                b.this.yJ.setNextPage(null);
            }
        }
    };
    private RecyclerView.OnScrollListener eEZ = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.frs.commontab.b.2
        private boolean fCr;

        @Override // android.support.v7.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i) {
            if (i == 0) {
                if (b.this.fwT != null) {
                    b.this.fwT.c(b.this.yJ.getFirstVisiblePosition(), b.this.yJ.getLastVisiblePosition(), this.fCr, true);
                }
                t.bau().iK(true);
            }
        }

        @Override // android.support.v7.widget.RecyclerView.OnScrollListener
        public void onScrolled(RecyclerView recyclerView, int i, int i2) {
            super.onScrolled(recyclerView, i, i2);
            if (i2 > 0) {
                this.fCr = false;
            } else {
                this.fCr = true;
            }
        }
    };

    public b(FrsCommonTabFragment frsCommonTabFragment, View view, FrsViewData frsViewData) {
        if (frsCommonTabFragment != null && view != null) {
            this.fBW = frsCommonTabFragment;
            this.yJ = (BdTypeRecyclerView) view.findViewById(R.id.frs_common_tab_recycler_view);
            this.yJ.setLayoutManager(new LinearLayoutManager(this.fBW.getContext()));
            this.yJ.setFadingEdgeLength(0);
            this.yJ.setOverScrollMode(2);
            this.yJ.setOnSrollToBottomListener(this.dIG);
            this.yJ.addOnScrollListener(this.eEZ);
            this.mPullView = new i(this.fBW.getPageContext());
            this.mPullView.setListPullRefreshListener(this.fBW);
            this.yJ.setRecyclerListener(new RecyclerView.RecyclerListener() { // from class: com.baidu.tieba.frs.commontab.b.3
                @Override // android.support.v7.widget.RecyclerView.RecyclerListener
                public void onViewRecycled(RecyclerView.ViewHolder viewHolder) {
                    View view2 = viewHolder.itemView;
                    if (b.this.fwT != null) {
                        b.this.fwT.ck(view2);
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
            this.dvS = new PbListView(this.fBW.getPageContext().getPageActivity());
            this.dvS.getView();
            this.dvS.setContainerBackgroundColorResId(R.color.cp_bg_line_e);
            this.dvS.setHeight(l.getDimens(this.fBW.getActivity(), R.dimen.tbds182));
            this.dvS.setLineGone();
            this.dvS.setTextSize(R.dimen.tbfontsize33);
            this.dvS.setTextColor(am.getColor(R.color.cp_cont_j));
            this.dvS.setNoMoreTextColorId(R.color.cp_cont_e);
            this.dvS.anJ();
            if (this.dxt == null) {
                this.dxt = (BdSwipeRefreshLayout) view.findViewById(R.id.frs_common_tab_pull_refresh_layout);
                this.dxt.setProgressView(this.mPullView);
                am.setBackgroundColor(this.dxt, R.color.cp_bg_line_e);
            }
            this.fCo = new a(this.fBW, this.yJ, frsViewData);
            fU(false);
            if (this.fwT == null) {
                this.fwT = new m(this.fBW.getPageContext(), this.yJ);
            }
            this.fwT.setUniqueId(this.fBW.getUniqueId());
        }
    }

    public void fU(boolean z) {
        if (this.dxt != null) {
            this.dxt.setRefreshing(z);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mPullView != null) {
            this.mPullView.changeSkin(i);
        }
        if (this.fCo != null) {
            this.fCo.notifyDataSetChanged();
        }
        if (this.dvS != null) {
            this.dvS.setTextColor(am.getColor(R.color.cp_cont_j));
            this.dvS.changeSkin(i);
        }
        am.setBackgroundColor(this.dxt, R.color.cp_bg_line_e);
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
            this.fCp = dVar;
            this.dvS.showEmptyView(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
            this.yJ.setNextPage(this.dvS);
            if (this.hasMore) {
                this.dvS.showEndLoadData();
            } else {
                this.dvS.setText(this.fBW.getResources().getString(R.string.list_has_no_more));
                this.dvS.endLoadData();
            }
            this.fCo.setData(dVar.threadList);
            this.fCo.notifyDataSetChanged();
            if (this.fwT != null) {
                this.fwT.c(this.yJ.getFirstVisiblePosition(), this.yJ.getLastVisiblePosition(), false, true);
            }
        }
    }

    public void setSelection(int i) {
        if (this.yJ != null) {
            this.yJ.setSelection(i);
        }
    }

    public void onDestroy() {
        if (this.fwT != null) {
            this.fwT.destroy();
        }
        if (this.fCo != null) {
            this.fCo.onDestory();
        }
    }

    public void resume() {
        if (this.fwT != null) {
            this.fwT.bIV();
        }
    }

    public void pause() {
        if (this.fwT != null) {
            this.fwT.bIU();
        }
    }

    public void km(boolean z) {
        if (this.dxt != null) {
            this.dxt.setVisibility(z ? 0 : 8);
        }
    }

    public void vW(String str) {
        bh bhVar;
        if (!StringUtils.isNull(str) && this.fCp != null && !v.isEmpty(this.fCp.threadList)) {
            Iterator<com.baidu.adp.widget.ListView.m> it = this.fCp.threadList.iterator();
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
                this.fCp.threadList.remove(bhVar);
                if (v.isEmpty(this.fCp.threadList)) {
                    this.fCp.threadList.add(new com.baidu.tieba.frs.m());
                }
                this.fCo.setData(this.fCp.threadList);
                this.fCo.notifyDataSetChanged();
            }
        }
    }

    public void bjw() {
        this.yJ.scrollToPosition(0);
    }

    public void refreshView() {
        this.fCo.notifyDataSetChanged();
    }

    public void aKf() {
        this.mPullView.pullToRefresh(false);
    }

    public void kl(boolean z) {
        if (this.fCo != null) {
            this.fCo.kl(z);
        }
    }

    public BdTypeRecyclerView bmC() {
        return this.yJ;
    }

    public m bkH() {
        return this.fwT;
    }
}
