package com.baidu.tieba.frs.commontab;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import com.baidu.adp.lib.util.j;
import com.baidu.adp.lib.util.l;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.adp.widget.refresh.BdSwipeRefreshLayout;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.view.PbListView;
import com.baidu.tbadk.core.view.UserPhotoLayout;
import com.baidu.tbadk.core.view.k;
import com.baidu.tieba.card.v;
import com.baidu.tieba.e;
import com.baidu.tieba.play.m;
import com.baidu.tieba.tbadkCore.FrsCommonImageLayout;
import java.util.ArrayList;
/* loaded from: classes6.dex */
public class b {
    private View aix;
    private PbListView bJY;
    private BdTypeRecyclerView bMI;
    private BdSwipeRefreshLayout bMJ;
    private m dCs;
    private FrsCommonTabFragment dGO;
    private a dGX;
    private boolean hasMore;
    private k mPullView;
    private BdListView.e bQS = new BdListView.e() { // from class: com.baidu.tieba.frs.commontab.b.1
        @Override // com.baidu.adp.widget.ListView.BdListView.e
        public void onScrollToBottom() {
            if (b.this.bMI != null) {
                b.this.bMI.stopScroll();
            }
            if (b.this.bJY != null && b.this.dGO != null) {
                if (j.kX()) {
                    b.this.bMI.setNextPage(b.this.bJY);
                    b.this.bJY.dX(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
                    b.this.bJY.setOnClickListener(null);
                    if (b.this.hasMore) {
                        b.this.bJY.showLoading();
                        b.this.dGO.aCa();
                        return;
                    }
                    b.this.bJY.setText(b.this.dGO.getResources().getString(e.j.list_has_no_more));
                    b.this.bJY.DP();
                    return;
                }
                b.this.bMI.setNextPage(null);
            }
        }
    };
    private RecyclerView.OnScrollListener dGY = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.frs.commontab.b.2
        private boolean dHa;

        @Override // android.support.v7.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i) {
            if (i == 0) {
                if (b.this.dCs != null) {
                    b.this.dCs.b(b.this.bMI.getFirstVisiblePosition(), b.this.bMI.getLastVisiblePosition(), this.dHa, true);
                }
                v.aoo().fh(true);
            }
        }

        @Override // android.support.v7.widget.RecyclerView.OnScrollListener
        public void onScrolled(RecyclerView recyclerView, int i, int i2) {
            super.onScrolled(recyclerView, i, i2);
            if (i2 > 0) {
                this.dHa = false;
            } else {
                this.dHa = true;
            }
        }
    };

    public b(FrsCommonTabFragment frsCommonTabFragment, View view) {
        if (frsCommonTabFragment != null && view != null) {
            this.dGO = frsCommonTabFragment;
            this.aix = view;
            this.bMI = (BdTypeRecyclerView) view.findViewById(e.g.frs_common_tab_recycler_view);
            this.bMI.setLayoutManager(new LinearLayoutManager(this.dGO.getContext()));
            this.bMI.setFadingEdgeLength(0);
            this.bMI.setOverScrollMode(2);
            this.bMI.setOnSrollToBottomListener(this.bQS);
            this.bMI.addOnScrollListener(this.dGY);
            this.mPullView = new k(this.dGO.getPageContext());
            this.mPullView.a(this.dGO);
            this.bMI.setRecyclerListener(new RecyclerView.RecyclerListener() { // from class: com.baidu.tieba.frs.commontab.b.3
                @Override // android.support.v7.widget.RecyclerView.RecyclerListener
                public void onViewRecycled(RecyclerView.ViewHolder viewHolder) {
                    View view2 = viewHolder.itemView;
                    if (b.this.dCs != null) {
                        b.this.dCs.bh(view2);
                    }
                    if (view2 != null) {
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
            this.bJY = new PbListView(this.dGO.getPageContext().getPageActivity());
            this.bJY.oG();
            this.bJY.dV(e.d.cp_bg_line_e);
            this.bJY.setHeight(l.h(this.dGO.getActivity(), e.C0175e.tbds182));
            this.bJY.DL();
            this.bJY.setTextSize(e.C0175e.tbfontsize33);
            this.bJY.setTextColor(al.getColor(e.d.cp_cont_j));
            this.bJY.dU(e.d.cp_cont_e);
            if (this.bMJ == null) {
                this.bMJ = (BdSwipeRefreshLayout) view.findViewById(e.g.frs_common_tab_pull_refresh_layout);
                this.bMJ.setProgressView(this.mPullView);
                al.j(this.bMJ, e.d.cp_bg_line_e);
            }
            this.dGX = new a(this.dGO, this.bMI);
            cQ(false);
            if (this.dCs == null) {
                this.dCs = new m(this.dGO.getPageContext(), this.bMI);
            }
            this.dCs.setUniqueId(this.dGO.getUniqueId());
        }
    }

    public void cQ(boolean z) {
        if (this.bMJ != null) {
            this.bMJ.setRefreshing(z);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mPullView != null) {
            this.mPullView.dW(i);
        }
        if (this.dGX != null) {
            this.dGX.notifyDataSetChanged();
        }
        if (this.bJY != null) {
            this.bJY.setTextColor(al.getColor(e.d.cp_cont_j));
            this.bJY.dW(i);
        }
        al.j(this.bMJ, e.d.cp_bg_line_e);
    }

    public void a(d dVar) {
        if (dVar != null) {
            this.hasMore = dVar.hasMore;
            if (com.baidu.tbadk.core.util.v.J(dVar.threadList)) {
                com.baidu.tieba.frs.m mVar = new com.baidu.tieba.frs.m();
                dVar.threadList = new ArrayList<>();
                dVar.threadList.add(mVar);
                dVar.hasMore = false;
            }
            this.bJY.dX(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
            this.bMI.setNextPage(this.bJY);
            if (this.hasMore) {
                this.bJY.DR();
            } else {
                this.bJY.setText(this.dGO.getResources().getString(e.j.list_has_no_more));
                this.bJY.DP();
            }
            this.dGX.setData(dVar.threadList);
            this.dGX.notifyDataSetChanged();
            if (this.dCs != null) {
                this.dCs.b(this.bMI.getFirstVisiblePosition(), this.bMI.getLastVisiblePosition(), false, true);
            }
        }
    }

    public void setSelection(int i) {
        if (this.bMI != null) {
            this.bMI.setSelection(i);
        }
    }

    public void onDestroy() {
        if (this.dCs != null) {
            this.dCs.destroy();
        }
        if (this.dGX != null) {
            this.dGX.onDestory();
        }
    }

    public void resume() {
        if (this.dCs != null) {
            this.dCs.aXP();
        }
    }

    public void pause() {
        if (this.dCs != null) {
            this.dCs.aXO();
        }
    }

    public void gN(boolean z) {
        if (this.bMJ != null) {
            this.bMJ.setVisibility(z ? 0 : 8);
        }
    }
}
