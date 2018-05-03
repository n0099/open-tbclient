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
    private RelativeLayout bbY;
    private PbListView blb;
    private BdSwipeRefreshLayout bnR;
    private BdTypeRecyclerView cYN;
    private FrameLayout dcB;
    private a dcC;
    private FrsDynamicFragment dcd;
    private f mPullView;

    public c(FrsDynamicFragment frsDynamicFragment, View view2) {
        this.dcd = frsDynamicFragment;
        an(view2);
    }

    private void an(View view2) {
        this.bbY = (RelativeLayout) view2.findViewById(d.g.frs_dynamic_container);
        this.cYN = (BdTypeRecyclerView) view2.findViewById(d.g.frs_dynamic_lv_thread);
        this.cYN.setLayoutManager(new LinearLayoutManager(this.cYN.getContext()));
        this.cYN.setFadingEdgeLength(0);
        this.cYN.setOverScrollMode(2);
        this.mPullView = new f(this.dcd.getPageContext());
        this.cYN.setRecyclerListener(new RecyclerView.RecyclerListener() { // from class: com.baidu.tieba.frs.dynamic.c.1
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
        this.blb = new PbListView(this.dcd.getPageContext().getPageActivity());
        this.blb.kA();
        this.blb.du(d.C0126d.cp_bg_line_e);
        this.blb.setHeight(l.e(this.dcd.getActivity(), d.e.tbds182));
        this.blb.wO();
        this.blb.setTextSize(d.e.tbfontsize33);
        this.blb.setTextColor(ak.getColor(d.C0126d.cp_cont_j));
        this.blb.dt(d.C0126d.cp_cont_e);
        this.cYN.setOnSrollToBottomListener(this.dcd);
        if (this.bnR == null) {
            this.bnR = (BdSwipeRefreshLayout) view2.findViewById(d.g.frs_dynamic_pull_refresh_layout);
            this.bnR.setProgressView(this.mPullView);
            ak.j(this.bnR, d.C0126d.cp_bg_line_c);
        }
        this.dcB = (FrameLayout) view2.findViewById(d.g.frs_dynamic_list_content);
        this.dcC = new a(this.dcd, this.cYN);
        ch(false);
    }

    public void a(e.b bVar) {
        this.mPullView.a(bVar);
    }

    public void setOnAdapterItemClickListener(n nVar) {
        this.dcC.setOnAdapterItemClickListener(nVar);
    }

    public void ch(boolean z) {
        if (!z) {
            this.bnR.setRefreshing(false);
        }
    }

    public void showListView() {
        this.cYN.setVisibility(0);
    }

    public void K(ArrayList<h> arrayList) {
        if (v.w(arrayList)) {
            k kVar = new k();
            arrayList = new ArrayList<>();
            arrayList.add(kVar);
        }
        this.dcC.setData(arrayList);
    }

    public BdTypeRecyclerView getListView() {
        return this.cYN;
    }

    public void setListViewSelection(int i) {
        this.cYN.setSelection(i);
    }

    public a arl() {
        return this.dcC;
    }

    public RelativeLayout arm() {
        return this.bbY;
    }

    public View arn() {
        return this.bnR;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void Qo() {
        this.cYN.setNextPage(this.blb);
        this.blb.dw(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        this.blb.wR();
    }

    public void Qp() {
        this.cYN.setNextPage(this.blb);
        this.blb.dw(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        this.blb.wS();
        this.blb.setText(this.dcd.getResources().getString(d.k.list_no_more));
    }

    public void Qq() {
        this.cYN.setNextPage(null);
    }

    public void fI(boolean z) {
        this.dcB.setVisibility(z ? 0 : 8);
    }

    public void startPullRefresh() {
        this.bnR.setRefreshing(true);
    }

    public void aqk() {
        if (this.dcC != null) {
            this.dcC.notifyDataSetChanged();
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mPullView != null) {
            this.mPullView.dv(i);
        }
        if (this.dcC != null) {
            this.dcC.notifyDataSetChanged();
        }
        this.dcd.getBaseFragmentActivity().getLayoutMode().setNightMode(i == 1);
        this.dcd.getBaseFragmentActivity().getLayoutMode().u(this.bbY);
        if (this.blb != null) {
            this.blb.setTextColor(ak.getColor(d.C0126d.cp_cont_j));
            this.blb.dv(i);
        }
        ak.j(this.bnR, d.C0126d.cp_bg_line_c);
        ak.j(this.cYN, d.C0126d.cp_bg_line_e);
    }

    public void onDestroy() {
        this.dcC.onDestory();
        this.cYN.setOnSrollToBottomListener(null);
    }
}
