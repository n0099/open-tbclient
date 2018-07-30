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
    private RelativeLayout bmp;
    private PbListView bvA;
    private BdSwipeRefreshLayout byn;
    private BdTypeRecyclerView dod;
    private FrameLayout dqE;
    private FrsDynamicFragment dsB;
    private a dsV;
    private h mPullView;

    public c(FrsDynamicFragment frsDynamicFragment, View view) {
        this.dsB = frsDynamicFragment;
        as(view);
    }

    private void as(View view) {
        this.bmp = (RelativeLayout) view.findViewById(d.g.frs_dynamic_container);
        this.dod = (BdTypeRecyclerView) view.findViewById(d.g.frs_dynamic_lv_thread);
        this.dod.setLayoutManager(new LinearLayoutManager(this.dod.getContext()));
        this.dod.setFadingEdgeLength(0);
        this.dod.setOverScrollMode(2);
        this.mPullView = new h(this.dsB.getPageContext());
        this.dod.setRecyclerListener(new RecyclerView.RecyclerListener() { // from class: com.baidu.tieba.frs.dynamic.c.1
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
        this.bvA = new PbListView(this.dsB.getPageContext().getPageActivity());
        this.bvA.np();
        this.bvA.dB(d.C0140d.cp_bg_line_e);
        this.bvA.setHeight(l.f(this.dsB.getActivity(), d.e.tbds182));
        this.bvA.Au();
        this.bvA.setTextSize(d.e.tbfontsize33);
        this.bvA.setTextColor(am.getColor(d.C0140d.cp_cont_j));
        this.bvA.dA(d.C0140d.cp_cont_e);
        this.dod.setOnSrollToBottomListener(this.dsB);
        if (this.byn == null) {
            this.byn = (BdSwipeRefreshLayout) view.findViewById(d.g.frs_dynamic_pull_refresh_layout);
            this.byn.setProgressView(this.mPullView);
            am.j(this.byn, d.C0140d.cp_bg_line_e);
        }
        this.dqE = (FrameLayout) view.findViewById(d.g.frs_dynamic_list_content);
        this.dsV = new a(this.dsB, this.dod);
        cp(false);
    }

    public void a(g.b bVar) {
        this.mPullView.a(bVar);
    }

    public void setOnAdapterItemClickListener(n nVar) {
        this.dsV.setOnAdapterItemClickListener(nVar);
    }

    public void cp(boolean z) {
        if (!z) {
            this.byn.setRefreshing(false);
        }
    }

    public void agN() {
        this.dod.setVisibility(0);
    }

    public void P(ArrayList<com.baidu.adp.widget.ListView.h> arrayList) {
        if (w.z(arrayList)) {
            m mVar = new m();
            arrayList = new ArrayList<>();
            arrayList.add(mVar);
        }
        this.dsV.setData(arrayList);
    }

    public BdTypeRecyclerView getListView() {
        return this.dod;
    }

    public void setListViewSelection(int i) {
        this.dod.setSelection(i);
    }

    public a awy() {
        return this.dsV;
    }

    public RelativeLayout awc() {
        return this.bmp;
    }

    public View awd() {
        return this.byn;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void Ul() {
        this.dod.setNextPage(this.bvA);
        this.bvA.dD(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        this.bvA.Ax();
    }

    public void Um() {
        this.dod.setNextPage(this.bvA);
        this.bvA.dD(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        this.bvA.Ay();
        this.bvA.setText(this.dsB.getResources().getString(d.j.list_no_more));
    }

    public void Un() {
        this.dod.setNextPage(null);
    }

    public void fR(boolean z) {
        this.dqE.setVisibility(z ? 0 : 8);
    }

    public void startPullRefresh() {
        this.byn.setRefreshing(true);
    }

    public void avk() {
        if (this.dsV != null) {
            this.dsV.notifyDataSetChanged();
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mPullView != null) {
            this.mPullView.dC(i);
        }
        if (this.dsV != null) {
            this.dsV.notifyDataSetChanged();
        }
        this.dsB.getBaseFragmentActivity().getLayoutMode().setNightMode(i == 1);
        this.dsB.getBaseFragmentActivity().getLayoutMode().onModeChanged(this.bmp);
        if (this.bvA != null) {
            this.bvA.setTextColor(am.getColor(d.C0140d.cp_cont_j));
            this.bvA.dC(i);
        }
        am.j(this.byn, d.C0140d.cp_bg_line_e);
    }

    public void onDestroy() {
        this.dsV.onDestory();
        this.dod.setOnSrollToBottomListener(null);
    }
}
