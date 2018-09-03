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
import com.baidu.tieba.f;
import com.baidu.tieba.frs.m;
import com.baidu.tieba.tbadkCore.FrsCommonImageLayout;
import com.baidu.tieba.tbadkCore.voice.PlayVoiceBnt;
import java.util.ArrayList;
/* loaded from: classes2.dex */
public class c {
    private RelativeLayout bmt;
    private PbListView bvC;
    private BdSwipeRefreshLayout byp;
    private BdTypeRecyclerView doa;
    private FrameLayout dqC;
    private a dsS;
    private FrsDynamicFragment dsy;
    private h mPullView;

    public c(FrsDynamicFragment frsDynamicFragment, View view) {
        this.dsy = frsDynamicFragment;
        as(view);
    }

    private void as(View view) {
        this.bmt = (RelativeLayout) view.findViewById(f.g.frs_dynamic_container);
        this.doa = (BdTypeRecyclerView) view.findViewById(f.g.frs_dynamic_lv_thread);
        this.doa.setLayoutManager(new LinearLayoutManager(this.doa.getContext()));
        this.doa.setFadingEdgeLength(0);
        this.doa.setOverScrollMode(2);
        this.mPullView = new h(this.dsy.getPageContext());
        this.doa.setRecyclerListener(new RecyclerView.RecyclerListener() { // from class: com.baidu.tieba.frs.dynamic.c.1
            @Override // android.support.v7.widget.RecyclerView.RecyclerListener
            public void onViewRecycled(RecyclerView.ViewHolder viewHolder) {
                View view2 = viewHolder.itemView;
                if (view2 != null) {
                    PlayVoiceBnt playVoiceBnt = (PlayVoiceBnt) view2.findViewById(f.g.abstract_voice);
                    if (playVoiceBnt != null) {
                        playVoiceBnt.reset();
                    }
                    FrsCommonImageLayout frsCommonImageLayout = (FrsCommonImageLayout) view2.findViewById(f.g.abstract_img_layout);
                    if (frsCommonImageLayout != null) {
                        frsCommonImageLayout.reset();
                    }
                    if (view2 instanceof UserPhotoLayout) {
                        ((UserPhotoLayout) view2).reset();
                    }
                }
            }
        });
        this.bvC = new PbListView(this.dsy.getPageContext().getPageActivity());
        this.bvC.np();
        this.bvC.dA(f.d.cp_bg_line_e);
        this.bvC.setHeight(l.f(this.dsy.getActivity(), f.e.tbds182));
        this.bvC.As();
        this.bvC.setTextSize(f.e.tbfontsize33);
        this.bvC.setTextColor(am.getColor(f.d.cp_cont_j));
        this.bvC.dz(f.d.cp_cont_e);
        this.doa.setOnSrollToBottomListener(this.dsy);
        if (this.byp == null) {
            this.byp = (BdSwipeRefreshLayout) view.findViewById(f.g.frs_dynamic_pull_refresh_layout);
            this.byp.setProgressView(this.mPullView);
            am.j(this.byp, f.d.cp_bg_line_e);
        }
        this.dqC = (FrameLayout) view.findViewById(f.g.frs_dynamic_list_content);
        this.dsS = new a(this.dsy, this.doa);
        cq(false);
    }

    public void a(g.b bVar) {
        this.mPullView.a(bVar);
    }

    public void setOnAdapterItemClickListener(n nVar) {
        this.dsS.setOnAdapterItemClickListener(nVar);
    }

    public void cq(boolean z) {
        if (!z) {
            this.byp.setRefreshing(false);
        }
    }

    public void agP() {
        this.doa.setVisibility(0);
    }

    public void P(ArrayList<com.baidu.adp.widget.ListView.h> arrayList) {
        if (w.z(arrayList)) {
            m mVar = new m();
            arrayList = new ArrayList<>();
            arrayList.add(mVar);
        }
        this.dsS.setData(arrayList);
    }

    public BdTypeRecyclerView getListView() {
        return this.doa;
    }

    public void setListViewSelection(int i) {
        this.doa.setSelection(i);
    }

    public a awx() {
        return this.dsS;
    }

    public RelativeLayout awb() {
        return this.bmt;
    }

    public View awc() {
        return this.byp;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void Uo() {
        this.doa.setNextPage(this.bvC);
        this.bvC.dC(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        this.bvC.Av();
    }

    public void Up() {
        this.doa.setNextPage(this.bvC);
        this.bvC.dC(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        this.bvC.Aw();
        this.bvC.setText(this.dsy.getResources().getString(f.j.list_no_more));
    }

    public void Uq() {
        this.doa.setNextPage(null);
    }

    public void fR(boolean z) {
        this.dqC.setVisibility(z ? 0 : 8);
    }

    public void startPullRefresh() {
        this.byp.setRefreshing(true);
    }

    public void avj() {
        if (this.dsS != null) {
            this.dsS.notifyDataSetChanged();
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mPullView != null) {
            this.mPullView.dB(i);
        }
        if (this.dsS != null) {
            this.dsS.notifyDataSetChanged();
        }
        this.dsy.getBaseFragmentActivity().getLayoutMode().setNightMode(i == 1);
        this.dsy.getBaseFragmentActivity().getLayoutMode().onModeChanged(this.bmt);
        if (this.bvC != null) {
            this.bvC.setTextColor(am.getColor(f.d.cp_cont_j));
            this.bvC.dB(i);
        }
        am.j(this.byp, f.d.cp_bg_line_e);
    }

    public void onDestroy() {
        this.dsS.onDestory();
        this.doa.setOnSrollToBottomListener(null);
    }
}
