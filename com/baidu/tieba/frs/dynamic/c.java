package com.baidu.tieba.frs.dynamic;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import com.baidu.adp.lib.util.l;
import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.adp.widget.ListView.n;
import com.baidu.adp.widget.refresh.BdSwipeRefreshLayout;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.w;
import com.baidu.tbadk.core.view.PbListView;
import com.baidu.tbadk.core.view.UserPhotoLayout;
import com.baidu.tbadk.core.view.g;
import com.baidu.tbadk.core.view.h;
import com.baidu.tieba.d;
import com.baidu.tieba.frs.m;
import com.baidu.tieba.tbadkCore.FrsCommonImageLayout;
import com.baidu.tieba.tbadkCore.voice.PlayVoiceBnt;
import java.util.ArrayList;
/* loaded from: classes2.dex */
public class c {
    private RelativeLayout blJ;
    private PbListView buU;
    private BdSwipeRefreshLayout bxI;
    private BdTypeRecyclerView dll;
    private FrameLayout dnL;
    private FrsDynamicFragment dpO;
    private a dqi;
    private h mPullView;

    public c(FrsDynamicFragment frsDynamicFragment, View view) {
        this.dpO = frsDynamicFragment;
        ap(view);
    }

    private void ap(View view) {
        this.blJ = (RelativeLayout) view.findViewById(d.g.frs_dynamic_container);
        this.dll = (BdTypeRecyclerView) view.findViewById(d.g.frs_dynamic_lv_thread);
        this.dll.setLayoutManager(new LinearLayoutManager(this.dll.getContext()));
        this.dll.setFadingEdgeLength(0);
        this.dll.setOverScrollMode(2);
        this.mPullView = new h(this.dpO.getPageContext());
        this.dll.setRecyclerListener(new RecyclerView.RecyclerListener() { // from class: com.baidu.tieba.frs.dynamic.c.1
            @Override // android.support.v7.widget.RecyclerView.RecyclerListener
            public void onViewRecycled(RecyclerView.ViewHolder viewHolder) {
                View view2 = viewHolder.itemView;
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
        this.buU = new PbListView(this.dpO.getPageContext().getPageActivity());
        this.buU.nn();
        this.buU.dy(d.C0142d.cp_bg_line_e);
        this.buU.setHeight(l.e(this.dpO.getActivity(), d.e.tbds182));
        this.buU.AE();
        this.buU.setTextSize(d.e.tbfontsize33);
        this.buU.setTextColor(am.getColor(d.C0142d.cp_cont_j));
        this.buU.dx(d.C0142d.cp_cont_e);
        this.dll.setOnSrollToBottomListener(this.dpO);
        if (this.bxI == null) {
            this.bxI = (BdSwipeRefreshLayout) view.findViewById(d.g.frs_dynamic_pull_refresh_layout);
            this.bxI.setProgressView(this.mPullView);
            am.j(this.bxI, d.C0142d.cp_bg_line_e);
        }
        this.dnL = (FrameLayout) view.findViewById(d.g.frs_dynamic_list_content);
        this.dqi = new a(this.dpO, this.dll);
        cp(false);
    }

    public void a(g.b bVar) {
        this.mPullView.a(bVar);
    }

    public void setOnAdapterItemClickListener(n nVar) {
        this.dqi.setOnAdapterItemClickListener(nVar);
    }

    public void cp(boolean z) {
        if (!z) {
            this.bxI.setRefreshing(false);
        }
    }

    public void showListView() {
        this.dll.setVisibility(0);
    }

    public void P(ArrayList<com.baidu.adp.widget.ListView.h> arrayList) {
        if (w.A(arrayList)) {
            m mVar = new m();
            arrayList = new ArrayList<>();
            arrayList.add(mVar);
        }
        this.dqi.setData(arrayList);
    }

    public BdTypeRecyclerView getListView() {
        return this.dll;
    }

    public void setListViewSelection(int i) {
        this.dll.setSelection(i);
    }

    public a avT() {
        return this.dqi;
    }

    public RelativeLayout avx() {
        return this.blJ;
    }

    public View avy() {
        return this.bxI;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void Ud() {
        this.dll.setNextPage(this.buU);
        this.buU.dA(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        this.buU.AH();
    }

    public void Ue() {
        this.dll.setNextPage(this.buU);
        this.buU.dA(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        this.buU.AI();
        this.buU.setText(this.dpO.getResources().getString(d.k.list_no_more));
    }

    public void Uf() {
        this.dll.setNextPage(null);
    }

    public void fP(boolean z) {
        this.dnL.setVisibility(z ? 0 : 8);
    }

    public void startPullRefresh() {
        this.bxI.setRefreshing(true);
    }

    public void auG() {
        if (this.dqi != null) {
            this.dqi.notifyDataSetChanged();
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mPullView != null) {
            this.mPullView.dz(i);
        }
        if (this.dqi != null) {
            this.dqi.notifyDataSetChanged();
        }
        this.dpO.getBaseFragmentActivity().getLayoutMode().setNightMode(i == 1);
        this.dpO.getBaseFragmentActivity().getLayoutMode().onModeChanged(this.blJ);
        if (this.buU != null) {
            this.buU.setTextColor(am.getColor(d.C0142d.cp_cont_j));
            this.buU.dz(i);
        }
        am.j(this.bxI, d.C0142d.cp_bg_line_e);
    }

    public void onDestroy() {
        this.dqi.onDestory();
        this.dll.setOnSrollToBottomListener(null);
    }
}
