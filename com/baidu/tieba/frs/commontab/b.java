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
    private BdTypeRecyclerView Op;
    private PbListView dnN;
    private BdSwipeRefreshLayout dpp;
    private BdListView.e dyY = new BdListView.e() { // from class: com.baidu.tieba.frs.commontab.b.1
        @Override // com.baidu.adp.widget.ListView.BdListView.e
        public void onScrollToBottom() {
            if (b.this.Op != null) {
                b.this.Op.stopScroll();
            }
            if (b.this.dnN != null && b.this.fBJ != null) {
                if (j.kc()) {
                    b.this.Op.setNextPage(b.this.dnN);
                    b.this.dnN.iW(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
                    b.this.dnN.setOnClickListener(null);
                    if (b.this.hasMore) {
                        b.this.dnN.showLoading();
                        b.this.fBJ.aYq();
                        return;
                    }
                    b.this.dnN.setText(b.this.fBJ.getResources().getString(R.string.list_has_no_more));
                    b.this.dnN.akG();
                    return;
                }
                b.this.Op.setNextPage(null);
            }
        }
    };
    private RecyclerView.OnScrollListener evw = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.frs.commontab.b.2
        private boolean fCe;

        @Override // android.support.v7.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i) {
            if (i == 0) {
                if (b.this.fwJ != null) {
                    b.this.fwJ.c(b.this.Op.getFirstVisiblePosition(), b.this.Op.getLastVisiblePosition(), this.fCe, true);
                }
                t.aZP().iE(true);
            }
        }

        @Override // android.support.v7.widget.RecyclerView.OnScrollListener
        public void onScrolled(RecyclerView recyclerView, int i, int i2) {
            super.onScrolled(recyclerView, i, i2);
            if (i2 > 0) {
                this.fCe = false;
            } else {
                this.fCe = true;
            }
        }
    };
    private FrsCommonTabFragment fBJ;
    private a fCb;
    private d fCc;
    private m fwJ;
    private boolean hasMore;
    private i mPullView;

    public b(FrsCommonTabFragment frsCommonTabFragment, View view, FrsViewData frsViewData) {
        if (frsCommonTabFragment != null && view != null) {
            this.fBJ = frsCommonTabFragment;
            this.Op = (BdTypeRecyclerView) view.findViewById(R.id.frs_common_tab_recycler_view);
            this.Op.setLayoutManager(new LinearLayoutManager(this.fBJ.getContext()));
            this.Op.setFadingEdgeLength(0);
            this.Op.setOverScrollMode(2);
            this.Op.setOnSrollToBottomListener(this.dyY);
            this.Op.addOnScrollListener(this.evw);
            this.mPullView = new i(this.fBJ.getPageContext());
            this.mPullView.setListPullRefreshListener(this.fBJ);
            this.Op.setRecyclerListener(new RecyclerView.RecyclerListener() { // from class: com.baidu.tieba.frs.commontab.b.3
                @Override // android.support.v7.widget.RecyclerView.RecyclerListener
                public void onViewRecycled(RecyclerView.ViewHolder viewHolder) {
                    View view2 = viewHolder.itemView;
                    if (b.this.fwJ != null) {
                        b.this.fwJ.cn(view2);
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
            this.dnN = new PbListView(this.fBJ.getPageContext().getPageActivity());
            this.dnN.getView();
            this.dnN.iU(R.color.cp_bg_line_e);
            this.dnN.setHeight(l.g(this.fBJ.getActivity(), R.dimen.tbds182));
            this.dnN.akC();
            this.dnN.setTextSize(R.dimen.tbfontsize33);
            this.dnN.setTextColor(am.getColor(R.color.cp_cont_j));
            this.dnN.iT(R.color.cp_cont_e);
            this.dnN.akJ();
            if (this.dpp == null) {
                this.dpp = (BdSwipeRefreshLayout) view.findViewById(R.id.frs_common_tab_pull_refresh_layout);
                this.dpp.setProgressView(this.mPullView);
                am.l(this.dpp, R.color.cp_bg_line_e);
            }
            this.fCb = new a(this.fBJ, this.Op, frsViewData);
            gc(false);
            if (this.fwJ == null) {
                this.fwJ = new m(this.fBJ.getPageContext(), this.Op);
            }
            this.fwJ.setUniqueId(this.fBJ.getUniqueId());
        }
    }

    public void gc(boolean z) {
        if (this.dpp != null) {
            this.dpp.setRefreshing(z);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mPullView != null) {
            this.mPullView.iV(i);
        }
        if (this.fCb != null) {
            this.fCb.notifyDataSetChanged();
        }
        if (this.dnN != null) {
            this.dnN.setTextColor(am.getColor(R.color.cp_cont_j));
            this.dnN.iV(i);
        }
        am.l(this.dpp, R.color.cp_bg_line_e);
    }

    public void a(d dVar) {
        if (dVar != null) {
            this.hasMore = dVar.hasMore;
            if (v.aa(dVar.threadList)) {
                com.baidu.tieba.frs.m mVar = new com.baidu.tieba.frs.m();
                dVar.threadList = new ArrayList<>();
                dVar.threadList.add(mVar);
                dVar.hasMore = false;
            }
            this.fCc = dVar;
            this.dnN.iW(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
            this.Op.setNextPage(this.dnN);
            if (this.hasMore) {
                this.dnN.akI();
            } else {
                this.dnN.setText(this.fBJ.getResources().getString(R.string.list_has_no_more));
                this.dnN.akG();
            }
            this.fCb.setData(dVar.threadList);
            this.fCb.notifyDataSetChanged();
            if (this.fwJ != null) {
                this.fwJ.c(this.Op.getFirstVisiblePosition(), this.Op.getLastVisiblePosition(), false, true);
            }
        }
    }

    public void setSelection(int i) {
        if (this.Op != null) {
            this.Op.setSelection(i);
        }
    }

    public void onDestroy() {
        if (this.fwJ != null) {
            this.fwJ.destroy();
        }
        if (this.fCb != null) {
            this.fCb.onDestory();
        }
    }

    public void resume() {
        if (this.fwJ != null) {
            this.fwJ.bLB();
        }
    }

    public void pause() {
        if (this.fwJ != null) {
            this.fwJ.bLA();
        }
    }

    public void kw(boolean z) {
        if (this.dpp != null) {
            this.dpp.setVisibility(z ? 0 : 8);
        }
    }

    public void xf(String str) {
        bh bhVar;
        if (!StringUtils.isNull(str) && this.fCc != null && !v.aa(this.fCc.threadList)) {
            Iterator<com.baidu.adp.widget.ListView.m> it = this.fCc.threadList.iterator();
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
                this.fCc.threadList.remove(bhVar);
                if (v.aa(this.fCc.threadList)) {
                    this.fCc.threadList.add(new com.baidu.tieba.frs.m());
                }
                this.fCb.setData(this.fCc.threadList);
                this.fCb.notifyDataSetChanged();
            }
        }
    }

    public void blH() {
        this.Op.scrollToPosition(0);
    }

    public void refreshView() {
        this.fCb.notifyDataSetChanged();
    }

    public void aKj() {
        this.mPullView.ar(false);
    }

    public void kv(boolean z) {
        if (this.fCb != null) {
            this.fCb.kv(z);
        }
    }

    public BdTypeRecyclerView boO() {
        return this.Op;
    }

    public m bmT() {
        return this.fwJ;
    }
}
