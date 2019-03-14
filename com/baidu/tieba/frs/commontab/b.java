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
import com.baidu.tbadk.core.data.bg;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.core.view.PbListView;
import com.baidu.tbadk.core.view.UserPhotoLayout;
import com.baidu.tbadk.core.view.i;
import com.baidu.tieba.card.t;
import com.baidu.tieba.d;
import com.baidu.tieba.play.m;
import com.baidu.tieba.tbadkCore.FrsCommonImageLayout;
import com.baidu.tieba.tbadkCore.FrsViewData;
import com.baidu.tieba.tbadkCore.voice.PlayVoiceBnt;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes4.dex */
public class b {
    private BdTypeRecyclerView Qr;
    private PbListView dbn;
    private BdSwipeRefreshLayout dcA;
    private m fbk;
    private FrsCommonTabFragment ffY;
    private a fgq;
    private d fgr;
    private boolean hasMore;
    private i mPullView;
    private BdListView.e dlg = new BdListView.e() { // from class: com.baidu.tieba.frs.commontab.b.1
        @Override // com.baidu.adp.widget.ListView.BdListView.e
        public void onScrollToBottom() {
            if (b.this.Qr != null) {
                b.this.Qr.stopScroll();
            }
            if (b.this.dbn != null && b.this.ffY != null) {
                if (j.kY()) {
                    b.this.Qr.setNextPage(b.this.dbn);
                    b.this.dbn.id(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
                    b.this.dbn.setOnClickListener(null);
                    if (b.this.hasMore) {
                        b.this.dbn.showLoading();
                        b.this.ffY.bfd();
                        return;
                    }
                    b.this.dbn.setText(b.this.ffY.getResources().getString(d.j.list_has_no_more));
                    b.this.dbn.aeD();
                    return;
                }
                b.this.Qr.setNextPage(null);
            }
        }
    };
    private RecyclerView.OnScrollListener fgs = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.frs.commontab.b.2
        private boolean fgu;

        @Override // android.support.v7.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i) {
            if (i == 0) {
                if (b.this.fbk != null) {
                    b.this.fbk.c(b.this.Qr.getFirstVisiblePosition(), b.this.Qr.getLastVisiblePosition(), this.fgu, true);
                }
                t.aQF().hQ(true);
            }
        }

        @Override // android.support.v7.widget.RecyclerView.OnScrollListener
        public void onScrolled(RecyclerView recyclerView, int i, int i2) {
            super.onScrolled(recyclerView, i, i2);
            if (i2 > 0) {
                this.fgu = false;
            } else {
                this.fgu = true;
            }
        }
    };

    public b(FrsCommonTabFragment frsCommonTabFragment, View view, FrsViewData frsViewData) {
        if (frsCommonTabFragment != null && view != null) {
            this.ffY = frsCommonTabFragment;
            this.Qr = (BdTypeRecyclerView) view.findViewById(d.g.frs_common_tab_recycler_view);
            this.Qr.setLayoutManager(new LinearLayoutManager(this.ffY.getContext()));
            this.Qr.setFadingEdgeLength(0);
            this.Qr.setOverScrollMode(2);
            this.Qr.setOnSrollToBottomListener(this.dlg);
            this.Qr.addOnScrollListener(this.fgs);
            this.mPullView = new i(this.ffY.getPageContext());
            this.mPullView.setListPullRefreshListener(this.ffY);
            this.Qr.setRecyclerListener(new RecyclerView.RecyclerListener() { // from class: com.baidu.tieba.frs.commontab.b.3
                @Override // android.support.v7.widget.RecyclerView.RecyclerListener
                public void onViewRecycled(RecyclerView.ViewHolder viewHolder) {
                    View view2 = viewHolder.itemView;
                    if (b.this.fbk != null) {
                        b.this.fbk.cb(view2);
                    }
                    if (view2 != null) {
                        PlayVoiceBnt playVoiceBnt = (PlayVoiceBnt) view2.findViewById(d.g.abstract_voice);
                        if (playVoiceBnt != null) {
                            playVoiceBnt.reset();
                        }
                        FrsCommonImageLayout frsCommonImageLayout = (FrsCommonImageLayout) view2.findViewById(d.g.abstract_img_layout);
                        if (frsCommonImageLayout != null) {
                            frsCommonImageLayout.reset();
                        }
                        if (view2 instanceof UserPhotoLayout) {
                            ((UserPhotoLayout) view2).reset();
                        }
                    }
                }
            });
            this.dbn = new PbListView(this.ffY.getPageContext().getPageActivity());
            this.dbn.getView();
            this.dbn.ib(d.C0277d.cp_bg_line_e);
            this.dbn.setHeight(l.h(this.ffY.getActivity(), d.e.tbds182));
            this.dbn.aez();
            this.dbn.setTextSize(d.e.tbfontsize33);
            this.dbn.setTextColor(al.getColor(d.C0277d.cp_cont_j));
            this.dbn.ia(d.C0277d.cp_cont_e);
            this.dbn.aeG();
            if (this.dcA == null) {
                this.dcA = (BdSwipeRefreshLayout) view.findViewById(d.g.frs_common_tab_pull_refresh_layout);
                this.dcA.setProgressView(this.mPullView);
                al.l(this.dcA, d.C0277d.cp_bg_line_e);
            }
            this.fgq = new a(this.ffY, this.Qr, frsViewData);
            fB(false);
            if (this.fbk == null) {
                this.fbk = new m(this.ffY.getPageContext(), this.Qr);
            }
            this.fbk.setUniqueId(this.ffY.getUniqueId());
        }
    }

    public void fB(boolean z) {
        if (this.dcA != null) {
            this.dcA.setRefreshing(z);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mPullView != null) {
            this.mPullView.ic(i);
        }
        if (this.fgq != null) {
            this.fgq.notifyDataSetChanged();
        }
        if (this.dbn != null) {
            this.dbn.setTextColor(al.getColor(d.C0277d.cp_cont_j));
            this.dbn.ic(i);
        }
        al.l(this.dcA, d.C0277d.cp_bg_line_e);
    }

    public void a(d dVar) {
        if (dVar != null) {
            this.hasMore = dVar.hasMore;
            if (v.T(dVar.threadList)) {
                com.baidu.tieba.frs.m mVar = new com.baidu.tieba.frs.m();
                dVar.threadList = new ArrayList<>();
                dVar.threadList.add(mVar);
                dVar.hasMore = false;
            }
            this.fgr = dVar;
            this.dbn.id(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
            if (this.hasMore) {
                this.Qr.setNextPage(this.dbn);
                this.dbn.aeF();
            } else {
                this.Qr.setNextPage(null);
                this.dbn.setText(this.ffY.getResources().getString(d.j.list_has_no_more));
                this.dbn.aeD();
            }
            this.fgq.setData(dVar.threadList);
            this.fgq.notifyDataSetChanged();
            if (this.fbk != null) {
                this.fbk.c(this.Qr.getFirstVisiblePosition(), this.Qr.getLastVisiblePosition(), false, true);
            }
        }
    }

    public void setSelection(int i) {
        if (this.Qr != null) {
            this.Qr.setSelection(i);
        }
    }

    public void onDestroy() {
        if (this.fbk != null) {
            this.fbk.destroy();
        }
        if (this.fgq != null) {
            this.fgq.onDestory();
        }
    }

    public void resume() {
        if (this.fbk != null) {
            this.fbk.bAV();
        }
    }

    public void pause() {
        if (this.fbk != null) {
            this.fbk.bAU();
        }
    }

    public void jB(boolean z) {
        if (this.dcA != null) {
            this.dcA.setVisibility(z ? 0 : 8);
        }
    }

    public void vh(String str) {
        bg bgVar;
        if (!StringUtils.isNull(str) && this.fgr != null && !v.T(this.fgr.threadList)) {
            Iterator<com.baidu.adp.widget.ListView.m> it = this.fgr.threadList.iterator();
            while (true) {
                if (!it.hasNext()) {
                    bgVar = null;
                    break;
                }
                com.baidu.adp.widget.ListView.m next = it.next();
                if (next != null && (next instanceof bg) && TextUtils.equals(str, ((bg) next).getId())) {
                    bgVar = (bg) next;
                    break;
                }
            }
            if (bgVar != null) {
                this.fgr.threadList.remove(bgVar);
                if (v.T(this.fgr.threadList)) {
                    this.fgr.threadList.add(new com.baidu.tieba.frs.m());
                }
                this.fgq.setData(this.fgr.threadList);
                this.fgq.notifyDataSetChanged();
            }
        }
    }

    public void bcd() {
        this.Qr.scrollToPosition(0);
    }

    public void refreshView() {
        this.fgq.notifyDataSetChanged();
    }

    public void aCt() {
        this.mPullView.aw(false);
    }
}
