package com.baidu.tieba.frs.dynamic;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import com.baidu.adp.lib.util.l;
import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.adp.widget.ListView.h;
import com.baidu.adp.widget.ListView.n;
import com.baidu.adp.widget.refresh.BdSwipeRefreshLayout;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.core.view.PbListView;
import com.baidu.tbadk.core.view.UserPhotoLayout;
import com.baidu.tbadk.core.view.e;
import com.baidu.tbadk.core.view.f;
import com.baidu.tieba.d;
import com.baidu.tieba.frs.k;
import com.baidu.tieba.tbadkCore.FrsCommonImageLayout;
import com.baidu.tieba.tbadkCore.voice.PlayVoiceBnt;
import java.util.ArrayList;
/* loaded from: classes2.dex */
public class c {
    private RelativeLayout bbZ;
    private PbListView blq;
    private BdSwipeRefreshLayout bog;
    private BdTypeRecyclerView cZU;
    private FrameLayout ddJ;
    private a ddK;
    private FrsDynamicFragment ddl;
    private f mPullView;

    public c(FrsDynamicFragment frsDynamicFragment, View view2) {
        this.ddl = frsDynamicFragment;
        an(view2);
    }

    private void an(View view2) {
        this.bbZ = (RelativeLayout) view2.findViewById(d.g.frs_dynamic_container);
        this.cZU = (BdTypeRecyclerView) view2.findViewById(d.g.frs_dynamic_lv_thread);
        this.cZU.setLayoutManager(new LinearLayoutManager(this.cZU.getContext()));
        this.cZU.setFadingEdgeLength(0);
        this.cZU.setOverScrollMode(2);
        this.mPullView = new f(this.ddl.getPageContext());
        this.cZU.setRecyclerListener(new RecyclerView.RecyclerListener() { // from class: com.baidu.tieba.frs.dynamic.c.1
            @Override // android.support.v7.widget.RecyclerView.RecyclerListener
            public void onViewRecycled(RecyclerView.ViewHolder viewHolder) {
                View view3 = viewHolder.itemView;
                if (view3 != null) {
                    PlayVoiceBnt playVoiceBnt = (PlayVoiceBnt) view3.findViewById(d.g.abstract_voice);
                    if (playVoiceBnt != null) {
                        playVoiceBnt.reset();
                    }
                    FrsCommonImageLayout frsCommonImageLayout = (FrsCommonImageLayout) view3.findViewById(d.g.abstract_img_layout);
                    if (frsCommonImageLayout != null) {
                        frsCommonImageLayout.reset();
                    }
                    if (view3 instanceof UserPhotoLayout) {
                        ((UserPhotoLayout) view3).reset();
                    }
                }
            }
        });
        this.blq = new PbListView(this.ddl.getPageContext().getPageActivity());
        this.blq.kz();
        this.blq.dv(d.C0126d.cp_bg_line_e);
        this.blq.setHeight(l.e(this.ddl.getActivity(), d.e.tbds182));
        this.blq.wN();
        this.blq.setTextSize(d.e.tbfontsize33);
        this.blq.setTextColor(ak.getColor(d.C0126d.cp_cont_j));
        this.blq.du(d.C0126d.cp_cont_e);
        this.cZU.setOnSrollToBottomListener(this.ddl);
        if (this.bog == null) {
            this.bog = (BdSwipeRefreshLayout) view2.findViewById(d.g.frs_dynamic_pull_refresh_layout);
            this.bog.setProgressView(this.mPullView);
            ak.j(this.bog, d.C0126d.cp_bg_line_c);
        }
        this.ddJ = (FrameLayout) view2.findViewById(d.g.frs_dynamic_list_content);
        this.ddK = new a(this.ddl, this.cZU);
        ch(false);
    }

    public void a(e.b bVar) {
        this.mPullView.a(bVar);
    }

    public void setOnAdapterItemClickListener(n nVar) {
        this.ddK.setOnAdapterItemClickListener(nVar);
    }

    public void ch(boolean z) {
        if (!z) {
            this.bog.setRefreshing(false);
        }
    }

    public void showListView() {
        this.cZU.setVisibility(0);
    }

    public void K(ArrayList<h> arrayList) {
        if (v.w(arrayList)) {
            k kVar = new k();
            arrayList = new ArrayList<>();
            arrayList.add(kVar);
        }
        this.ddK.setData(arrayList);
    }

    public BdTypeRecyclerView getListView() {
        return this.cZU;
    }

    public void setListViewSelection(int i) {
        this.cZU.setSelection(i);
    }

    public a ark() {
        return this.ddK;
    }

    public RelativeLayout arl() {
        return this.bbZ;
    }

    public View arm() {
        return this.bog;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void Ql() {
        this.cZU.setNextPage(this.blq);
        this.blq.dx(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        this.blq.wQ();
    }

    public void Qm() {
        this.cZU.setNextPage(this.blq);
        this.blq.dx(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        this.blq.wR();
        this.blq.setText(this.ddl.getResources().getString(d.k.list_no_more));
    }

    public void Qn() {
        this.cZU.setNextPage(null);
    }

    public void fJ(boolean z) {
        this.ddJ.setVisibility(z ? 0 : 8);
    }

    public void startPullRefresh() {
        this.bog.setRefreshing(true);
    }

    public void aqj() {
        if (this.ddK != null) {
            this.ddK.notifyDataSetChanged();
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mPullView != null) {
            this.mPullView.dw(i);
        }
        if (this.ddK != null) {
            this.ddK.notifyDataSetChanged();
        }
        this.ddl.getBaseFragmentActivity().getLayoutMode().setNightMode(i == 1);
        this.ddl.getBaseFragmentActivity().getLayoutMode().u(this.bbZ);
        if (this.blq != null) {
            this.blq.setTextColor(ak.getColor(d.C0126d.cp_cont_j));
            this.blq.dw(i);
        }
        ak.j(this.bog, d.C0126d.cp_bg_line_c);
        ak.j(this.cZU, d.C0126d.cp_bg_line_e);
    }

    public void onDestroy() {
        this.ddK.onDestory();
        this.cZU.setOnSrollToBottomListener(null);
    }
}
