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
/* loaded from: classes2.dex */
public class b {
    private View adA;
    private PbListView bBr;
    private BdTypeRecyclerView bEd;
    private BdSwipeRefreshLayout bEe;
    private m dur;
    private FrsCommonTabFragment dyO;
    private a dyX;
    private boolean hasMore;
    private k mPullView;
    private BdListView.e bIp = new BdListView.e() { // from class: com.baidu.tieba.frs.commontab.b.1
        @Override // com.baidu.adp.widget.ListView.BdListView.e
        public void onScrollToBottom() {
            if (b.this.bEd != null) {
                b.this.bEd.stopScroll();
            }
            if (b.this.bBr != null && b.this.dyO != null) {
                if (j.kK()) {
                    b.this.bEd.setNextPage(b.this.bBr);
                    b.this.bBr.dN(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
                    b.this.bBr.setOnClickListener(null);
                    if (b.this.hasMore) {
                        b.this.bBr.showLoading();
                        b.this.dyO.ayH();
                        return;
                    }
                    b.this.bBr.setText(b.this.dyO.getResources().getString(e.j.list_has_no_more));
                    b.this.bBr.BJ();
                    return;
                }
                b.this.bEd.setNextPage(null);
            }
        }
    };
    private RecyclerView.OnScrollListener dyY = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.frs.commontab.b.2
        private boolean dza;

        @Override // android.support.v7.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i) {
            if (i == 0) {
                if (b.this.dur != null) {
                    b.this.dur.b(b.this.bEd.getFirstVisiblePosition(), b.this.bEd.getLastVisiblePosition(), this.dza, true);
                }
                v.akM().eP(true);
            }
        }

        @Override // android.support.v7.widget.RecyclerView.OnScrollListener
        public void onScrolled(RecyclerView recyclerView, int i, int i2) {
            super.onScrolled(recyclerView, i, i2);
            if (i2 > 0) {
                this.dza = false;
            } else {
                this.dza = true;
            }
        }
    };

    public b(FrsCommonTabFragment frsCommonTabFragment, View view) {
        if (frsCommonTabFragment != null && view != null) {
            this.dyO = frsCommonTabFragment;
            this.adA = view;
            this.bEd = (BdTypeRecyclerView) view.findViewById(e.g.frs_common_tab_recycler_view);
            this.bEd.setLayoutManager(new LinearLayoutManager(this.dyO.getContext()));
            this.bEd.setFadingEdgeLength(0);
            this.bEd.setOverScrollMode(2);
            this.bEd.setOnSrollToBottomListener(this.bIp);
            this.bEd.addOnScrollListener(this.dyY);
            this.mPullView = new k(this.dyO.getPageContext());
            this.mPullView.a(this.dyO);
            this.bEd.setRecyclerListener(new RecyclerView.RecyclerListener() { // from class: com.baidu.tieba.frs.commontab.b.3
                @Override // android.support.v7.widget.RecyclerView.RecyclerListener
                public void onViewRecycled(RecyclerView.ViewHolder viewHolder) {
                    View view2 = viewHolder.itemView;
                    if (b.this.dur != null) {
                        b.this.dur.bh(view2);
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
            this.bBr = new PbListView(this.dyO.getPageContext().getPageActivity());
            this.bBr.ov();
            this.bBr.dL(e.d.cp_bg_line_e);
            this.bBr.setHeight(l.h(this.dyO.getActivity(), e.C0141e.tbds182));
            this.bBr.BF();
            this.bBr.setTextSize(e.C0141e.tbfontsize33);
            this.bBr.setTextColor(al.getColor(e.d.cp_cont_j));
            this.bBr.dK(e.d.cp_cont_e);
            if (this.bEe == null) {
                this.bEe = (BdSwipeRefreshLayout) view.findViewById(e.g.frs_common_tab_pull_refresh_layout);
                this.bEe.setProgressView(this.mPullView);
                al.j(this.bEe, e.d.cp_bg_line_e);
            }
            this.dyX = new a(this.dyO, this.bEd);
            cH(false);
            if (this.dur == null) {
                this.dur = new m(this.dyO.getPageContext(), this.bEd);
            }
            this.dur.setUniqueId(this.dyO.getUniqueId());
        }
    }

    public void cH(boolean z) {
        if (this.bEe != null) {
            this.bEe.setRefreshing(z);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mPullView != null) {
            this.mPullView.dM(i);
        }
        if (this.dyX != null) {
            this.dyX.notifyDataSetChanged();
        }
        if (this.bBr != null) {
            this.bBr.setTextColor(al.getColor(e.d.cp_cont_j));
            this.bBr.dM(i);
        }
        al.j(this.bEe, e.d.cp_bg_line_e);
    }

    public void a(d dVar) {
        if (dVar != null) {
            this.hasMore = dVar.hasMore;
            if (com.baidu.tbadk.core.util.v.z(dVar.threadList)) {
                com.baidu.tieba.frs.m mVar = new com.baidu.tieba.frs.m();
                dVar.threadList = new ArrayList<>();
                dVar.threadList.add(mVar);
                dVar.hasMore = false;
            }
            this.bBr.dN(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
            this.bEd.setNextPage(this.bBr);
            if (this.hasMore) {
                this.bBr.BL();
            } else {
                this.bBr.setText(this.dyO.getResources().getString(e.j.list_has_no_more));
                this.bBr.BJ();
            }
            this.dyX.setData(dVar.threadList);
            this.dyX.notifyDataSetChanged();
            if (this.dur != null) {
                this.dur.b(this.bEd.getFirstVisiblePosition(), this.bEd.getLastVisiblePosition(), false, true);
            }
        }
    }

    public void setSelection(int i) {
        if (this.bEd != null) {
            this.bEd.setSelection(i);
        }
    }

    public void onDestroy() {
        if (this.dur != null) {
            this.dur.destroy();
        }
        if (this.dyX != null) {
            this.dyX.onDestory();
        }
    }

    public void resume() {
        if (this.dur != null) {
            this.dur.aUC();
        }
    }

    public void pause() {
        if (this.dur != null) {
            this.dur.aUB();
        }
    }

    public void gv(boolean z) {
        if (this.bEe != null) {
            this.bEe.setVisibility(z ? 0 : 8);
        }
    }
}
