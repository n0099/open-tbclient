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
    private PbListView bPn;
    private BdTypeRecyclerView bRZ;
    private BdSwipeRefreshLayout bSa;
    private m dNG;
    private FrsCommonTabFragment dSa;
    private a dSp;
    private d dSq;
    private boolean hasMore;
    private k mPullView;
    private BdListView.e bWi = new BdListView.e() { // from class: com.baidu.tieba.frs.commontab.b.1
        @Override // com.baidu.adp.widget.ListView.BdListView.e
        public void onScrollToBottom() {
            if (b.this.bRZ != null) {
                b.this.bRZ.stopScroll();
            }
            if (b.this.bPn != null && b.this.dSa != null) {
                if (j.kV()) {
                    b.this.bRZ.setNextPage(b.this.bPn);
                    b.this.bPn.ez(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
                    b.this.bPn.setOnClickListener(null);
                    if (b.this.hasMore) {
                        b.this.bPn.showLoading();
                        b.this.dSa.aEu();
                        return;
                    }
                    b.this.bPn.setText(b.this.dSa.getResources().getString(e.j.list_has_no_more));
                    b.this.bPn.Fq();
                    return;
                }
                b.this.bRZ.setNextPage(null);
            }
        }
    };
    private RecyclerView.OnScrollListener dSr = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.frs.commontab.b.2
        private boolean dSt;

        @Override // android.support.v7.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i) {
            if (i == 0) {
                if (b.this.dNG != null) {
                    b.this.dNG.b(b.this.bRZ.getFirstVisiblePosition(), b.this.bRZ.getLastVisiblePosition(), this.dSt, true);
                }
                v.aqP().fy(true);
            }
        }

        @Override // android.support.v7.widget.RecyclerView.OnScrollListener
        public void onScrolled(RecyclerView recyclerView, int i, int i2) {
            super.onScrolled(recyclerView, i, i2);
            if (i2 > 0) {
                this.dSt = false;
            } else {
                this.dSt = true;
            }
        }
    };

    public b(FrsCommonTabFragment frsCommonTabFragment, View view) {
        if (frsCommonTabFragment != null && view != null) {
            this.dSa = frsCommonTabFragment;
            this.bRZ = (BdTypeRecyclerView) view.findViewById(e.g.frs_common_tab_recycler_view);
            this.bRZ.setLayoutManager(new LinearLayoutManager(this.dSa.getContext()));
            this.bRZ.setFadingEdgeLength(0);
            this.bRZ.setOverScrollMode(2);
            this.bRZ.setOnSrollToBottomListener(this.bWi);
            this.bRZ.addOnScrollListener(this.dSr);
            this.mPullView = new k(this.dSa.getPageContext());
            this.mPullView.a(this.dSa);
            this.bRZ.setRecyclerListener(new RecyclerView.RecyclerListener() { // from class: com.baidu.tieba.frs.commontab.b.3
                @Override // android.support.v7.widget.RecyclerView.RecyclerListener
                public void onViewRecycled(RecyclerView.ViewHolder viewHolder) {
                    View view2 = viewHolder.itemView;
                    if (b.this.dNG != null) {
                        b.this.dNG.bm(view2);
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
            this.bPn = new PbListView(this.dSa.getPageContext().getPageActivity());
            this.bPn.oH();
            this.bPn.ex(e.d.cp_bg_line_e);
            this.bPn.setHeight(l.h(this.dSa.getActivity(), e.C0210e.tbds182));
            this.bPn.Fm();
            this.bPn.setTextSize(e.C0210e.tbfontsize33);
            this.bPn.setTextColor(al.getColor(e.d.cp_cont_j));
            this.bPn.ew(e.d.cp_cont_e);
            if (this.bSa == null) {
                this.bSa = (BdSwipeRefreshLayout) view.findViewById(e.g.frs_common_tab_pull_refresh_layout);
                this.bSa.setProgressView(this.mPullView);
                al.j(this.bSa, e.d.cp_bg_line_e);
            }
            this.dSp = new a(this.dSa, this.bRZ);
            dl(false);
            if (this.dNG == null) {
                this.dNG = new m(this.dSa.getPageContext(), this.bRZ);
            }
            this.dNG.setUniqueId(this.dSa.getUniqueId());
        }
    }

    public void dl(boolean z) {
        if (this.bSa != null) {
            this.bSa.setRefreshing(z);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mPullView != null) {
            this.mPullView.ey(i);
        }
        if (this.dSp != null) {
            this.dSp.notifyDataSetChanged();
        }
        if (this.bPn != null) {
            this.bPn.setTextColor(al.getColor(e.d.cp_cont_j));
            this.bPn.ey(i);
        }
        al.j(this.bSa, e.d.cp_bg_line_e);
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
            this.dSq = dVar;
            this.bPn.ez(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
            this.bRZ.setNextPage(this.bPn);
            if (this.hasMore) {
                this.bPn.Fs();
            } else {
                this.bPn.setText(this.dSa.getResources().getString(e.j.list_has_no_more));
                this.bPn.Fq();
            }
            this.dSp.setData(dVar.threadList);
            this.dSp.notifyDataSetChanged();
            if (this.dNG != null) {
                this.dNG.b(this.bRZ.getFirstVisiblePosition(), this.bRZ.getLastVisiblePosition(), false, true);
            }
        }
    }

    public void setSelection(int i) {
        if (this.bRZ != null) {
            this.bRZ.setSelection(i);
        }
    }

    public void onDestroy() {
        if (this.dNG != null) {
            this.dNG.destroy();
        }
        if (this.dSp != null) {
            this.dSp.onDestory();
        }
    }

    public void resume() {
        if (this.dNG != null) {
            this.dNG.bar();
        }
    }

    public void pause() {
        if (this.dNG != null) {
            this.dNG.baq();
        }
    }

    public void he(boolean z) {
        if (this.bSa != null) {
            this.bSa.setVisibility(z ? 0 : 8);
        }
    }

    public void oE(String str) {
        bb bbVar;
        if (!StringUtils.isNull(str) && this.dSq != null && !com.baidu.tbadk.core.util.v.I(this.dSq.threadList)) {
            Iterator<h> it = this.dSq.threadList.iterator();
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
                this.dSq.threadList.remove(bbVar);
                if (com.baidu.tbadk.core.util.v.I(this.dSq.threadList)) {
                    this.dSq.threadList.add(new com.baidu.tieba.frs.m());
                }
                this.dSp.notifyDataSetChanged();
            }
        }
    }
}
