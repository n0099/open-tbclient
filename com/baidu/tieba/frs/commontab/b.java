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
    private PbListView dbs;
    private BdSwipeRefreshLayout dcF;
    private m faX;
    private FrsCommonTabFragment ffL;
    private a fgd;
    private d fge;
    private boolean hasMore;
    private i mPullView;
    private BdListView.e dlk = new BdListView.e() { // from class: com.baidu.tieba.frs.commontab.b.1
        @Override // com.baidu.adp.widget.ListView.BdListView.e
        public void onScrollToBottom() {
            if (b.this.Qr != null) {
                b.this.Qr.stopScroll();
            }
            if (b.this.dbs != null && b.this.ffL != null) {
                if (j.kY()) {
                    b.this.Qr.setNextPage(b.this.dbs);
                    b.this.dbs.ic(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
                    b.this.dbs.setOnClickListener(null);
                    if (b.this.hasMore) {
                        b.this.dbs.showLoading();
                        b.this.ffL.bfb();
                        return;
                    }
                    b.this.dbs.setText(b.this.ffL.getResources().getString(d.j.list_has_no_more));
                    b.this.dbs.aeA();
                    return;
                }
                b.this.Qr.setNextPage(null);
            }
        }
    };
    private RecyclerView.OnScrollListener fgf = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.frs.commontab.b.2
        private boolean fgh;

        @Override // android.support.v7.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i) {
            if (i == 0) {
                if (b.this.faX != null) {
                    b.this.faX.c(b.this.Qr.getFirstVisiblePosition(), b.this.Qr.getLastVisiblePosition(), this.fgh, true);
                }
                t.aQD().hQ(true);
            }
        }

        @Override // android.support.v7.widget.RecyclerView.OnScrollListener
        public void onScrolled(RecyclerView recyclerView, int i, int i2) {
            super.onScrolled(recyclerView, i, i2);
            if (i2 > 0) {
                this.fgh = false;
            } else {
                this.fgh = true;
            }
        }
    };

    public b(FrsCommonTabFragment frsCommonTabFragment, View view, FrsViewData frsViewData) {
        if (frsCommonTabFragment != null && view != null) {
            this.ffL = frsCommonTabFragment;
            this.Qr = (BdTypeRecyclerView) view.findViewById(d.g.frs_common_tab_recycler_view);
            this.Qr.setLayoutManager(new LinearLayoutManager(this.ffL.getContext()));
            this.Qr.setFadingEdgeLength(0);
            this.Qr.setOverScrollMode(2);
            this.Qr.setOnSrollToBottomListener(this.dlk);
            this.Qr.addOnScrollListener(this.fgf);
            this.mPullView = new i(this.ffL.getPageContext());
            this.mPullView.setListPullRefreshListener(this.ffL);
            this.Qr.setRecyclerListener(new RecyclerView.RecyclerListener() { // from class: com.baidu.tieba.frs.commontab.b.3
                @Override // android.support.v7.widget.RecyclerView.RecyclerListener
                public void onViewRecycled(RecyclerView.ViewHolder viewHolder) {
                    View view2 = viewHolder.itemView;
                    if (b.this.faX != null) {
                        b.this.faX.cb(view2);
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
            this.dbs = new PbListView(this.ffL.getPageContext().getPageActivity());
            this.dbs.getView();
            this.dbs.ia(d.C0277d.cp_bg_line_e);
            this.dbs.setHeight(l.h(this.ffL.getActivity(), d.e.tbds182));
            this.dbs.aew();
            this.dbs.setTextSize(d.e.tbfontsize33);
            this.dbs.setTextColor(al.getColor(d.C0277d.cp_cont_j));
            this.dbs.hZ(d.C0277d.cp_cont_e);
            this.dbs.aeD();
            if (this.dcF == null) {
                this.dcF = (BdSwipeRefreshLayout) view.findViewById(d.g.frs_common_tab_pull_refresh_layout);
                this.dcF.setProgressView(this.mPullView);
                al.l(this.dcF, d.C0277d.cp_bg_line_e);
            }
            this.fgd = new a(this.ffL, this.Qr, frsViewData);
            fB(false);
            if (this.faX == null) {
                this.faX = new m(this.ffL.getPageContext(), this.Qr);
            }
            this.faX.setUniqueId(this.ffL.getUniqueId());
        }
    }

    public void fB(boolean z) {
        if (this.dcF != null) {
            this.dcF.setRefreshing(z);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mPullView != null) {
            this.mPullView.ib(i);
        }
        if (this.fgd != null) {
            this.fgd.notifyDataSetChanged();
        }
        if (this.dbs != null) {
            this.dbs.setTextColor(al.getColor(d.C0277d.cp_cont_j));
            this.dbs.ib(i);
        }
        al.l(this.dcF, d.C0277d.cp_bg_line_e);
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
            this.fge = dVar;
            this.dbs.ic(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
            if (this.hasMore) {
                this.Qr.setNextPage(this.dbs);
                this.dbs.aeC();
            } else {
                this.Qr.setNextPage(null);
                this.dbs.setText(this.ffL.getResources().getString(d.j.list_has_no_more));
                this.dbs.aeA();
            }
            this.fgd.setData(dVar.threadList);
            this.fgd.notifyDataSetChanged();
            if (this.faX != null) {
                this.faX.c(this.Qr.getFirstVisiblePosition(), this.Qr.getLastVisiblePosition(), false, true);
            }
        }
    }

    public void setSelection(int i) {
        if (this.Qr != null) {
            this.Qr.setSelection(i);
        }
    }

    public void onDestroy() {
        if (this.faX != null) {
            this.faX.destroy();
        }
        if (this.fgd != null) {
            this.fgd.onDestory();
        }
    }

    public void resume() {
        if (this.faX != null) {
            this.faX.bAS();
        }
    }

    public void pause() {
        if (this.faX != null) {
            this.faX.bAR();
        }
    }

    public void jB(boolean z) {
        if (this.dcF != null) {
            this.dcF.setVisibility(z ? 0 : 8);
        }
    }

    public void vg(String str) {
        bg bgVar;
        if (!StringUtils.isNull(str) && this.fge != null && !v.T(this.fge.threadList)) {
            Iterator<com.baidu.adp.widget.ListView.m> it = this.fge.threadList.iterator();
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
                this.fge.threadList.remove(bgVar);
                if (v.T(this.fge.threadList)) {
                    this.fge.threadList.add(new com.baidu.tieba.frs.m());
                }
                this.fgd.setData(this.fge.threadList);
                this.fgd.notifyDataSetChanged();
            }
        }
    }

    public void bcb() {
        this.Qr.scrollToPosition(0);
    }

    public void refreshView() {
        this.fgd.notifyDataSetChanged();
    }

    public void aCq() {
        this.mPullView.aw(false);
    }
}
