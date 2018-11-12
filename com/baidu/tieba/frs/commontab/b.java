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
import com.baidu.adp.widget.ListView.h;
import com.baidu.adp.widget.refresh.BdSwipeRefreshLayout;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.bb;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.view.PbListView;
import com.baidu.tbadk.core.view.UserPhotoLayout;
import com.baidu.tbadk.core.view.k;
import com.baidu.tieba.card.v;
import com.baidu.tieba.e;
import com.baidu.tieba.play.m;
import com.baidu.tieba.tbadkCore.FrsCommonImageLayout;
import com.baidu.tieba.tbadkCore.voice.PlayVoiceBnt;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes6.dex */
public class b {
    private PbListView bKJ;
    private BdTypeRecyclerView bNt;
    private BdSwipeRefreshLayout bNu;
    private m dDJ;
    private FrsCommonTabFragment dId;
    private a dIs;
    private d dIt;
    private boolean hasMore;
    private k mPullView;
    private BdListView.e bRC = new BdListView.e() { // from class: com.baidu.tieba.frs.commontab.b.1
        @Override // com.baidu.adp.widget.ListView.BdListView.e
        public void onScrollToBottom() {
            if (b.this.bNt != null) {
                b.this.bNt.stopScroll();
            }
            if (b.this.bKJ != null && b.this.dId != null) {
                if (j.kV()) {
                    b.this.bNt.setNextPage(b.this.bKJ);
                    b.this.bKJ.el(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
                    b.this.bKJ.setOnClickListener(null);
                    if (b.this.hasMore) {
                        b.this.bKJ.showLoading();
                        b.this.dId.aBy();
                        return;
                    }
                    b.this.bKJ.setText(b.this.dId.getResources().getString(e.j.list_has_no_more));
                    b.this.bKJ.DZ();
                    return;
                }
                b.this.bNt.setNextPage(null);
            }
        }
    };
    private RecyclerView.OnScrollListener dIu = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.frs.commontab.b.2
        private boolean dIw;

        @Override // android.support.v7.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i) {
            if (i == 0) {
                if (b.this.dDJ != null) {
                    b.this.dDJ.b(b.this.bNt.getFirstVisiblePosition(), b.this.bNt.getLastVisiblePosition(), this.dIw, true);
                }
                v.anQ().fs(true);
            }
        }

        @Override // android.support.v7.widget.RecyclerView.OnScrollListener
        public void onScrolled(RecyclerView recyclerView, int i, int i2) {
            super.onScrolled(recyclerView, i, i2);
            if (i2 > 0) {
                this.dIw = false;
            } else {
                this.dIw = true;
            }
        }
    };

    public b(FrsCommonTabFragment frsCommonTabFragment, View view) {
        if (frsCommonTabFragment != null && view != null) {
            this.dId = frsCommonTabFragment;
            this.bNt = (BdTypeRecyclerView) view.findViewById(e.g.frs_common_tab_recycler_view);
            this.bNt.setLayoutManager(new LinearLayoutManager(this.dId.getContext()));
            this.bNt.setFadingEdgeLength(0);
            this.bNt.setOverScrollMode(2);
            this.bNt.setOnSrollToBottomListener(this.bRC);
            this.bNt.addOnScrollListener(this.dIu);
            this.mPullView = new k(this.dId.getPageContext());
            this.mPullView.a(this.dId);
            this.bNt.setRecyclerListener(new RecyclerView.RecyclerListener() { // from class: com.baidu.tieba.frs.commontab.b.3
                @Override // android.support.v7.widget.RecyclerView.RecyclerListener
                public void onViewRecycled(RecyclerView.ViewHolder viewHolder) {
                    View view2 = viewHolder.itemView;
                    if (b.this.dDJ != null) {
                        b.this.dDJ.bj(view2);
                    }
                    if (view2 != null) {
                        PlayVoiceBnt playVoiceBnt = (PlayVoiceBnt) view2.findViewById(e.g.abstract_voice);
                        if (playVoiceBnt != null) {
                            playVoiceBnt.reset();
                        }
                        FrsCommonImageLayout frsCommonImageLayout = (FrsCommonImageLayout) view2.findViewById(e.g.abstract_img_layout);
                        if (frsCommonImageLayout != null) {
                            frsCommonImageLayout.reset();
                        }
                        if (view2 instanceof UserPhotoLayout) {
                            ((UserPhotoLayout) view2).reset();
                        }
                    }
                }
            });
            this.bKJ = new PbListView(this.dId.getPageContext().getPageActivity());
            this.bKJ.oE();
            this.bKJ.ej(e.d.cp_bg_line_e);
            this.bKJ.setHeight(l.h(this.dId.getActivity(), e.C0200e.tbds182));
            this.bKJ.DV();
            this.bKJ.setTextSize(e.C0200e.tbfontsize33);
            this.bKJ.setTextColor(al.getColor(e.d.cp_cont_j));
            this.bKJ.ei(e.d.cp_cont_e);
            if (this.bNu == null) {
                this.bNu = (BdSwipeRefreshLayout) view.findViewById(e.g.frs_common_tab_pull_refresh_layout);
                this.bNu.setProgressView(this.mPullView);
                al.j(this.bNu, e.d.cp_bg_line_e);
            }
            this.dIs = new a(this.dId, this.bNt);
            dh(false);
            if (this.dDJ == null) {
                this.dDJ = new m(this.dId.getPageContext(), this.bNt);
            }
            this.dDJ.setUniqueId(this.dId.getUniqueId());
        }
    }

    public void dh(boolean z) {
        if (this.bNu != null) {
            this.bNu.setRefreshing(z);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mPullView != null) {
            this.mPullView.ek(i);
        }
        if (this.dIs != null) {
            this.dIs.notifyDataSetChanged();
        }
        if (this.bKJ != null) {
            this.bKJ.setTextColor(al.getColor(e.d.cp_cont_j));
            this.bKJ.ek(i);
        }
        al.j(this.bNu, e.d.cp_bg_line_e);
    }

    public void a(d dVar) {
        if (dVar != null) {
            this.hasMore = dVar.hasMore;
            if (com.baidu.tbadk.core.util.v.I(dVar.threadList)) {
                com.baidu.tieba.frs.m mVar = new com.baidu.tieba.frs.m();
                dVar.threadList = new ArrayList<>();
                dVar.threadList.add(mVar);
                dVar.hasMore = false;
            }
            this.dIt = dVar;
            this.bKJ.el(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
            this.bNt.setNextPage(this.bKJ);
            if (this.hasMore) {
                this.bKJ.Eb();
            } else {
                this.bKJ.setText(this.dId.getResources().getString(e.j.list_has_no_more));
                this.bKJ.DZ();
            }
            this.dIs.setData(dVar.threadList);
            this.dIs.notifyDataSetChanged();
            if (this.dDJ != null) {
                this.dDJ.b(this.bNt.getFirstVisiblePosition(), this.bNt.getLastVisiblePosition(), false, true);
            }
        }
    }

    public void setSelection(int i) {
        if (this.bNt != null) {
            this.bNt.setSelection(i);
        }
    }

    public void onDestroy() {
        if (this.dDJ != null) {
            this.dDJ.destroy();
        }
        if (this.dIs != null) {
            this.dIs.onDestory();
        }
    }

    public void resume() {
        if (this.dDJ != null) {
            this.dDJ.aXm();
        }
    }

    public void pause() {
        if (this.dDJ != null) {
            this.dDJ.aXl();
        }
    }

    public void gX(boolean z) {
        if (this.bNu != null) {
            this.bNu.setVisibility(z ? 0 : 8);
        }
    }

    public void nK(String str) {
        bb bbVar;
        if (!StringUtils.isNull(str) && this.dIt != null && !com.baidu.tbadk.core.util.v.I(this.dIt.threadList)) {
            Iterator<h> it = this.dIt.threadList.iterator();
            while (true) {
                if (!it.hasNext()) {
                    bbVar = null;
                    break;
                }
                h next = it.next();
                if (next != null && (next instanceof bb) && TextUtils.equals(str, ((bb) next).getId())) {
                    bbVar = (bb) next;
                    break;
                }
            }
            if (bbVar != null) {
                this.dIt.threadList.remove(bbVar);
                if (com.baidu.tbadk.core.util.v.I(this.dIt.threadList)) {
                    this.dIt.threadList.add(new com.baidu.tieba.frs.m());
                }
                this.dIs.notifyDataSetChanged();
            }
        }
    }
}
