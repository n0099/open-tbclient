package com.baidu.tieba.frs.ad;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import com.baidu.adp.lib.util.l;
import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.adp.widget.refresh.BdSwipeRefreshLayout;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.view.PbListView;
import com.baidu.tbadk.core.view.UserPhotoLayout;
import com.baidu.tbadk.core.view.h;
import com.baidu.tbadk.core.view.i;
import com.baidu.tieba.d;
import com.baidu.tieba.tbadkCore.FrsCommonImageLayout;
import com.baidu.tieba.tbadkCore.voice.PlayVoiceBnt;
/* loaded from: classes4.dex */
public class e {
    private FrameLayout bhC;
    private RelativeLayout cMr;
    private PbListView dbn;
    private BdSwipeRefreshLayout dcA;
    private BdTypeRecyclerView faT;
    private FrsADFragment fdA;
    private a fdL;
    private i mPullView;

    public e(FrsADFragment frsADFragment, View view) {
        this.fdA = frsADFragment;
        bD(view);
    }

    public a beJ() {
        return this.fdL;
    }

    private void bD(View view) {
        this.cMr = (RelativeLayout) view.findViewById(d.g.frs_ad_container);
        this.faT = (BdTypeRecyclerView) view.findViewById(d.g.frs_ad_listview);
        this.faT.setLayoutManager(new LinearLayoutManager(this.faT.getContext()));
        this.faT.setFadingEdgeLength(0);
        this.faT.setOverScrollMode(2);
        this.faT.setRecyclerListener(new RecyclerView.RecyclerListener() { // from class: com.baidu.tieba.frs.ad.e.1
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
        this.faT.setOnSrollToBottomListener(this.fdA);
        this.fdL = new a(this.fdA, this.faT);
        this.dbn = new PbListView(this.fdA.getPageContext().getPageActivity());
        this.dbn.oM();
        this.dbn.ib(d.C0277d.cp_bg_line_e);
        this.dbn.setHeight(l.h(this.fdA.getActivity(), d.e.tbds182));
        this.dbn.aez();
        this.dbn.setTextSize(d.e.tbfontsize33);
        this.dbn.setTextColor(al.getColor(d.C0277d.cp_cont_j));
        this.dbn.ia(d.C0277d.cp_cont_e);
        this.mPullView = new i(this.fdA.getPageContext());
        if (this.dcA == null) {
            this.dcA = (BdSwipeRefreshLayout) view.findViewById(d.g.frs_ad_pull_refresh_layout);
            this.dcA.setProgressView(this.mPullView);
            al.l(this.dcA, d.C0277d.cp_bg_line_e);
        }
        this.bhC = (FrameLayout) view.findViewById(d.g.frs_ad_list_content);
        fB(false);
    }

    public void setListPullRefreshListener(h.c cVar) {
        this.mPullView.setListPullRefreshListener(cVar);
    }

    public void fB(boolean z) {
        if (!z) {
            this.dcA.setRefreshing(false);
        }
    }

    public BdTypeRecyclerView getListView() {
        return this.faT;
    }

    public RelativeLayout bdL() {
        return this.cMr;
    }

    public View beK() {
        return this.dcA;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void aCu() {
        this.faT.setNextPage(this.dbn);
        this.dbn.id(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        this.dbn.aeC();
    }

    public void aCv() {
        this.faT.setNextPage(this.dbn);
        this.dbn.id(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        this.dbn.aeD();
        this.dbn.setText(this.fdA.getResources().getString(d.j.list_no_more));
    }

    public void aCw() {
        this.faT.setNextPage(null);
    }

    public void jv(boolean z) {
        this.bhC.setVisibility(z ? 0 : 8);
    }

    public void startPullRefresh() {
        this.dcA.setRefreshing(true);
    }

    public void bdx() {
        if (this.fdL != null) {
            this.fdL.notifyDataSetChanged();
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mPullView != null) {
            this.mPullView.ic(i);
        }
        this.fdA.getBaseFragmentActivity().getLayoutMode().setNightMode(i == 1);
        this.fdA.getBaseFragmentActivity().getLayoutMode().onModeChanged(this.cMr);
        if (this.dbn != null) {
            this.dbn.setTextColor(al.getColor(d.C0277d.cp_cont_j));
            this.dbn.ic(i);
        }
        al.l(this.dcA, d.C0277d.cp_bg_line_e);
        if (this.fdL != null) {
            this.fdL.notifyDataSetChanged();
        }
    }

    public void onDestroy() {
        this.fdL.onDestory();
        this.faT.setOnSrollToBottomListener(null);
    }
}
