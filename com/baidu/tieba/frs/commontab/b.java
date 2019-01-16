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
    private PbListView bPm;
    private BdTypeRecyclerView bRY;
    private BdSwipeRefreshLayout bRZ;
    private m dNF;
    private FrsCommonTabFragment dRZ;
    private a dSo;
    private d dSp;
    private boolean hasMore;
    private k mPullView;
    private BdListView.e bWh = new BdListView.e() { // from class: com.baidu.tieba.frs.commontab.b.1
        @Override // com.baidu.adp.widget.ListView.BdListView.e
        public void onScrollToBottom() {
            if (b.this.bRY != null) {
                b.this.bRY.stopScroll();
            }
            if (b.this.bPm != null && b.this.dRZ != null) {
                if (j.kV()) {
                    b.this.bRY.setNextPage(b.this.bPm);
                    b.this.bPm.ez(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
                    b.this.bPm.setOnClickListener(null);
                    if (b.this.hasMore) {
                        b.this.bPm.showLoading();
                        b.this.dRZ.aEu();
                        return;
                    }
                    b.this.bPm.setText(b.this.dRZ.getResources().getString(e.j.list_has_no_more));
                    b.this.bPm.Fq();
                    return;
                }
                b.this.bRY.setNextPage(null);
            }
        }
    };
    private RecyclerView.OnScrollListener dSq = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.frs.commontab.b.2
        private boolean dSs;

        @Override // android.support.v7.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i) {
            if (i == 0) {
                if (b.this.dNF != null) {
                    b.this.dNF.b(b.this.bRY.getFirstVisiblePosition(), b.this.bRY.getLastVisiblePosition(), this.dSs, true);
                }
                v.aqP().fy(true);
            }
        }

        @Override // android.support.v7.widget.RecyclerView.OnScrollListener
        public void onScrolled(RecyclerView recyclerView, int i, int i2) {
            super.onScrolled(recyclerView, i, i2);
            if (i2 > 0) {
                this.dSs = false;
            } else {
                this.dSs = true;
            }
        }
    };

    public b(FrsCommonTabFragment frsCommonTabFragment, View view) {
        if (frsCommonTabFragment != null && view != null) {
            this.dRZ = frsCommonTabFragment;
            this.bRY = (BdTypeRecyclerView) view.findViewById(e.g.frs_common_tab_recycler_view);
            this.bRY.setLayoutManager(new LinearLayoutManager(this.dRZ.getContext()));
            this.bRY.setFadingEdgeLength(0);
            this.bRY.setOverScrollMode(2);
            this.bRY.setOnSrollToBottomListener(this.bWh);
            this.bRY.addOnScrollListener(this.dSq);
            this.mPullView = new k(this.dRZ.getPageContext());
            this.mPullView.a(this.dRZ);
            this.bRY.setRecyclerListener(new RecyclerView.RecyclerListener() { // from class: com.baidu.tieba.frs.commontab.b.3
                @Override // android.support.v7.widget.RecyclerView.RecyclerListener
                public void onViewRecycled(RecyclerView.ViewHolder viewHolder) {
                    View view2 = viewHolder.itemView;
                    if (b.this.dNF != null) {
                        b.this.dNF.bm(view2);
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
            this.bPm = new PbListView(this.dRZ.getPageContext().getPageActivity());
            this.bPm.oH();
            this.bPm.ex(e.d.cp_bg_line_e);
            this.bPm.setHeight(l.h(this.dRZ.getActivity(), e.C0210e.tbds182));
            this.bPm.Fm();
            this.bPm.setTextSize(e.C0210e.tbfontsize33);
            this.bPm.setTextColor(al.getColor(e.d.cp_cont_j));
            this.bPm.ew(e.d.cp_cont_e);
            if (this.bRZ == null) {
                this.bRZ = (BdSwipeRefreshLayout) view.findViewById(e.g.frs_common_tab_pull_refresh_layout);
                this.bRZ.setProgressView(this.mPullView);
                al.j(this.bRZ, e.d.cp_bg_line_e);
            }
            this.dSo = new a(this.dRZ, this.bRY);
            dl(false);
            if (this.dNF == null) {
                this.dNF = new m(this.dRZ.getPageContext(), this.bRY);
            }
            this.dNF.setUniqueId(this.dRZ.getUniqueId());
        }
    }

    public void dl(boolean z) {
        if (this.bRZ != null) {
            this.bRZ.setRefreshing(z);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mPullView != null) {
            this.mPullView.ey(i);
        }
        if (this.dSo != null) {
            this.dSo.notifyDataSetChanged();
        }
        if (this.bPm != null) {
            this.bPm.setTextColor(al.getColor(e.d.cp_cont_j));
            this.bPm.ey(i);
        }
        al.j(this.bRZ, e.d.cp_bg_line_e);
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
            this.dSp = dVar;
            this.bPm.ez(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
            this.bRY.setNextPage(this.bPm);
            if (this.hasMore) {
                this.bPm.Fs();
            } else {
                this.bPm.setText(this.dRZ.getResources().getString(e.j.list_has_no_more));
                this.bPm.Fq();
            }
            this.dSo.setData(dVar.threadList);
            this.dSo.notifyDataSetChanged();
            if (this.dNF != null) {
                this.dNF.b(this.bRY.getFirstVisiblePosition(), this.bRY.getLastVisiblePosition(), false, true);
            }
        }
    }

    public void setSelection(int i) {
        if (this.bRY != null) {
            this.bRY.setSelection(i);
        }
    }

    public void onDestroy() {
        if (this.dNF != null) {
            this.dNF.destroy();
        }
        if (this.dSo != null) {
            this.dSo.onDestory();
        }
    }

    public void resume() {
        if (this.dNF != null) {
            this.dNF.bar();
        }
    }

    public void pause() {
        if (this.dNF != null) {
            this.dNF.baq();
        }
    }

    public void he(boolean z) {
        if (this.bRZ != null) {
            this.bRZ.setVisibility(z ? 0 : 8);
        }
    }

    public void oE(String str) {
        bb bbVar;
        if (!StringUtils.isNull(str) && this.dSp != null && !com.baidu.tbadk.core.util.v.I(this.dSp.threadList)) {
            Iterator<h> it = this.dSp.threadList.iterator();
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
                this.dSp.threadList.remove(bbVar);
                if (com.baidu.tbadk.core.util.v.I(this.dSp.threadList)) {
                    this.dSp.threadList.add(new com.baidu.tieba.frs.m());
                }
                this.dSo.notifyDataSetChanged();
            }
        }
    }
}
