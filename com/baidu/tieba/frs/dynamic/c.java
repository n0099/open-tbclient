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
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.core.view.PbListView;
import com.baidu.tbadk.core.view.UserPhotoLayout;
import com.baidu.tbadk.core.view.j;
import com.baidu.tbadk.core.view.k;
import com.baidu.tieba.e;
import com.baidu.tieba.frs.m;
import com.baidu.tieba.tbadkCore.FrsCommonImageLayout;
import com.baidu.tieba.tbadkCore.voice.PlayVoiceBnt;
import java.util.ArrayList;
/* loaded from: classes6.dex */
public class c {
    private PbListView bJY;
    private BdSwipeRefreshLayout bMJ;
    private RelativeLayout bwo;
    private BdTypeRecyclerView dBZ;
    private FrameLayout dER;
    private FrsDynamicFragment dHg;
    private a dHy;
    private k mPullView;

    public c(FrsDynamicFragment frsDynamicFragment, View view) {
        this.dHg = frsDynamicFragment;
        aG(view);
    }

    private void aG(View view) {
        this.bwo = (RelativeLayout) view.findViewById(e.g.frs_dynamic_container);
        this.dBZ = (BdTypeRecyclerView) view.findViewById(e.g.frs_dynamic_lv_thread);
        this.dBZ.setLayoutManager(new LinearLayoutManager(this.dBZ.getContext()));
        this.dBZ.setFadingEdgeLength(0);
        this.dBZ.setOverScrollMode(2);
        this.mPullView = new k(this.dHg.getPageContext());
        this.dBZ.setRecyclerListener(new RecyclerView.RecyclerListener() { // from class: com.baidu.tieba.frs.dynamic.c.1
            @Override // android.support.v7.widget.RecyclerView.RecyclerListener
            public void onViewRecycled(RecyclerView.ViewHolder viewHolder) {
                View view2 = viewHolder.itemView;
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
        this.bJY = new PbListView(this.dHg.getPageContext().getPageActivity());
        this.bJY.oG();
        this.bJY.dV(e.d.cp_bg_line_e);
        this.bJY.setHeight(l.h(this.dHg.getActivity(), e.C0175e.tbds182));
        this.bJY.DL();
        this.bJY.setTextSize(e.C0175e.tbfontsize33);
        this.bJY.setTextColor(al.getColor(e.d.cp_cont_j));
        this.bJY.dU(e.d.cp_cont_e);
        this.dBZ.setOnSrollToBottomListener(this.dHg);
        if (this.bMJ == null) {
            this.bMJ = (BdSwipeRefreshLayout) view.findViewById(e.g.frs_dynamic_pull_refresh_layout);
            this.bMJ.setProgressView(this.mPullView);
            al.j(this.bMJ, e.d.cp_bg_line_e);
        }
        this.dER = (FrameLayout) view.findViewById(e.g.frs_dynamic_list_content);
        this.dHy = new a(this.dHg, this.dBZ);
        cQ(false);
    }

    public void a(j.b bVar) {
        this.mPullView.a(bVar);
    }

    public void setOnAdapterItemClickListener(n nVar) {
        this.dHy.setOnAdapterItemClickListener(nVar);
    }

    public void cQ(boolean z) {
        if (!z) {
            this.bMJ.setRefreshing(false);
        }
    }

    public void amh() {
        this.dBZ.setVisibility(0);
    }

    public void P(ArrayList<h> arrayList) {
        if (v.J(arrayList)) {
            m mVar = new m();
            arrayList = new ArrayList<>();
            arrayList.add(mVar);
        }
        this.dHy.setData(arrayList);
    }

    public BdTypeRecyclerView getListView() {
        return this.dBZ;
    }

    public void setListViewSelection(int i) {
        this.dBZ.setSelection(i);
    }

    public a aCf() {
        return this.dHy;
    }

    public RelativeLayout aAJ() {
        return this.bwo;
    }

    public View aBI() {
        return this.bMJ;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void ZJ() {
        this.dBZ.setNextPage(this.bJY);
        this.bJY.dX(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        this.bJY.DO();
    }

    public void ZK() {
        this.dBZ.setNextPage(this.bJY);
        this.bJY.dX(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        this.bJY.DP();
        this.bJY.setText(this.dHg.getResources().getString(e.j.list_no_more));
    }

    public void ZL() {
        this.dBZ.setNextPage(null);
    }

    public void gG(boolean z) {
        this.dER.setVisibility(z ? 0 : 8);
    }

    public void startPullRefresh() {
        this.bMJ.setRefreshing(true);
    }

    public void aAy() {
        if (this.dHy != null) {
            this.dHy.notifyDataSetChanged();
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mPullView != null) {
            this.mPullView.dW(i);
        }
        if (this.dHy != null) {
            this.dHy.notifyDataSetChanged();
        }
        this.dHg.getBaseFragmentActivity().getLayoutMode().setNightMode(i == 1);
        this.dHg.getBaseFragmentActivity().getLayoutMode().onModeChanged(this.bwo);
        if (this.bJY != null) {
            this.bJY.setTextColor(al.getColor(e.d.cp_cont_j));
            this.bJY.dW(i);
        }
        al.j(this.bMJ, e.d.cp_bg_line_e);
    }

    public void onDestroy() {
        this.dHy.onDestory();
        this.dBZ.setOnSrollToBottomListener(null);
    }
}
