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
    private BdTypeRecyclerView Qq;
    private PbListView dbr;
    private BdSwipeRefreshLayout dcE;
    private m fbl;
    private FrsCommonTabFragment ffZ;
    private a fgr;
    private d fgs;
    private boolean hasMore;
    private i mPullView;
    private BdListView.e dlk = new BdListView.e() { // from class: com.baidu.tieba.frs.commontab.b.1
        @Override // com.baidu.adp.widget.ListView.BdListView.e
        public void onScrollToBottom() {
            if (b.this.Qq != null) {
                b.this.Qq.stopScroll();
            }
            if (b.this.dbr != null && b.this.ffZ != null) {
                if (j.kY()) {
                    b.this.Qq.setNextPage(b.this.dbr);
                    b.this.dbr.id(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
                    b.this.dbr.setOnClickListener(null);
                    if (b.this.hasMore) {
                        b.this.dbr.showLoading();
                        b.this.ffZ.bfd();
                        return;
                    }
                    b.this.dbr.setText(b.this.ffZ.getResources().getString(d.j.list_has_no_more));
                    b.this.dbr.aeD();
                    return;
                }
                b.this.Qq.setNextPage(null);
            }
        }
    };
    private RecyclerView.OnScrollListener fgt = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.frs.commontab.b.2
        private boolean fgv;

        @Override // android.support.v7.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i) {
            if (i == 0) {
                if (b.this.fbl != null) {
                    b.this.fbl.c(b.this.Qq.getFirstVisiblePosition(), b.this.Qq.getLastVisiblePosition(), this.fgv, true);
                }
                t.aQF().hQ(true);
            }
        }

        @Override // android.support.v7.widget.RecyclerView.OnScrollListener
        public void onScrolled(RecyclerView recyclerView, int i, int i2) {
            super.onScrolled(recyclerView, i, i2);
            if (i2 > 0) {
                this.fgv = false;
            } else {
                this.fgv = true;
            }
        }
    };

    public b(FrsCommonTabFragment frsCommonTabFragment, View view, FrsViewData frsViewData) {
        if (frsCommonTabFragment != null && view != null) {
            this.ffZ = frsCommonTabFragment;
            this.Qq = (BdTypeRecyclerView) view.findViewById(d.g.frs_common_tab_recycler_view);
            this.Qq.setLayoutManager(new LinearLayoutManager(this.ffZ.getContext()));
            this.Qq.setFadingEdgeLength(0);
            this.Qq.setOverScrollMode(2);
            this.Qq.setOnSrollToBottomListener(this.dlk);
            this.Qq.addOnScrollListener(this.fgt);
            this.mPullView = new i(this.ffZ.getPageContext());
            this.mPullView.setListPullRefreshListener(this.ffZ);
            this.Qq.setRecyclerListener(new RecyclerView.RecyclerListener() { // from class: com.baidu.tieba.frs.commontab.b.3
                @Override // android.support.v7.widget.RecyclerView.RecyclerListener
                public void onViewRecycled(RecyclerView.ViewHolder viewHolder) {
                    View view2 = viewHolder.itemView;
                    if (b.this.fbl != null) {
                        b.this.fbl.cb(view2);
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
            this.dbr = new PbListView(this.ffZ.getPageContext().getPageActivity());
            this.dbr.getView();
            this.dbr.ib(d.C0236d.cp_bg_line_e);
            this.dbr.setHeight(l.h(this.ffZ.getActivity(), d.e.tbds182));
            this.dbr.aez();
            this.dbr.setTextSize(d.e.tbfontsize33);
            this.dbr.setTextColor(al.getColor(d.C0236d.cp_cont_j));
            this.dbr.ia(d.C0236d.cp_cont_e);
            this.dbr.aeG();
            if (this.dcE == null) {
                this.dcE = (BdSwipeRefreshLayout) view.findViewById(d.g.frs_common_tab_pull_refresh_layout);
                this.dcE.setProgressView(this.mPullView);
                al.l(this.dcE, d.C0236d.cp_bg_line_e);
            }
            this.fgr = new a(this.ffZ, this.Qq, frsViewData);
            fB(false);
            if (this.fbl == null) {
                this.fbl = new m(this.ffZ.getPageContext(), this.Qq);
            }
            this.fbl.setUniqueId(this.ffZ.getUniqueId());
        }
    }

    public void fB(boolean z) {
        if (this.dcE != null) {
            this.dcE.setRefreshing(z);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mPullView != null) {
            this.mPullView.ic(i);
        }
        if (this.fgr != null) {
            this.fgr.notifyDataSetChanged();
        }
        if (this.dbr != null) {
            this.dbr.setTextColor(al.getColor(d.C0236d.cp_cont_j));
            this.dbr.ic(i);
        }
        al.l(this.dcE, d.C0236d.cp_bg_line_e);
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
            this.fgs = dVar;
            this.dbr.id(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
            if (this.hasMore) {
                this.Qq.setNextPage(this.dbr);
                this.dbr.aeF();
            } else {
                this.Qq.setNextPage(null);
                this.dbr.setText(this.ffZ.getResources().getString(d.j.list_has_no_more));
                this.dbr.aeD();
            }
            this.fgr.setData(dVar.threadList);
            this.fgr.notifyDataSetChanged();
            if (this.fbl != null) {
                this.fbl.c(this.Qq.getFirstVisiblePosition(), this.Qq.getLastVisiblePosition(), false, true);
            }
        }
    }

    public void setSelection(int i) {
        if (this.Qq != null) {
            this.Qq.setSelection(i);
        }
    }

    public void onDestroy() {
        if (this.fbl != null) {
            this.fbl.destroy();
        }
        if (this.fgr != null) {
            this.fgr.onDestory();
        }
    }

    public void resume() {
        if (this.fbl != null) {
            this.fbl.bAV();
        }
    }

    public void pause() {
        if (this.fbl != null) {
            this.fbl.bAU();
        }
    }

    public void jB(boolean z) {
        if (this.dcE != null) {
            this.dcE.setVisibility(z ? 0 : 8);
        }
    }

    public void vi(String str) {
        bg bgVar;
        if (!StringUtils.isNull(str) && this.fgs != null && !v.T(this.fgs.threadList)) {
            Iterator<com.baidu.adp.widget.ListView.m> it = this.fgs.threadList.iterator();
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
                this.fgs.threadList.remove(bgVar);
                if (v.T(this.fgs.threadList)) {
                    this.fgs.threadList.add(new com.baidu.tieba.frs.m());
                }
                this.fgr.setData(this.fgs.threadList);
                this.fgr.notifyDataSetChanged();
            }
        }
    }

    public void bcd() {
        this.Qq.scrollToPosition(0);
    }

    public void refreshView() {
        this.fgr.notifyDataSetChanged();
    }

    public void aCt() {
        this.mPullView.aw(false);
    }
}
