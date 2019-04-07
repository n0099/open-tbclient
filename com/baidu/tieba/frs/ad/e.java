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
    private FrameLayout bhF;
    private RelativeLayout cMt;
    private PbListView dbr;
    private BdSwipeRefreshLayout dcE;
    private BdTypeRecyclerView faG;
    private FrsADFragment fdn;
    private a fdy;
    private i mPullView;

    public e(FrsADFragment frsADFragment, View view) {
        this.fdn = frsADFragment;
        bD(view);
    }

    public a beH() {
        return this.fdy;
    }

    private void bD(View view) {
        this.cMt = (RelativeLayout) view.findViewById(d.g.frs_ad_container);
        this.faG = (BdTypeRecyclerView) view.findViewById(d.g.frs_ad_listview);
        this.faG.setLayoutManager(new LinearLayoutManager(this.faG.getContext()));
        this.faG.setFadingEdgeLength(0);
        this.faG.setOverScrollMode(2);
        this.faG.setRecyclerListener(new RecyclerView.RecyclerListener() { // from class: com.baidu.tieba.frs.ad.e.1
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
        this.faG.setOnSrollToBottomListener(this.fdn);
        this.fdy = new a(this.fdn, this.faG);
        this.dbr = new PbListView(this.fdn.getPageContext().getPageActivity());
        this.dbr.oM();
        this.dbr.ia(d.C0277d.cp_bg_line_e);
        this.dbr.setHeight(l.h(this.fdn.getActivity(), d.e.tbds182));
        this.dbr.aew();
        this.dbr.setTextSize(d.e.tbfontsize33);
        this.dbr.setTextColor(al.getColor(d.C0277d.cp_cont_j));
        this.dbr.hZ(d.C0277d.cp_cont_e);
        this.mPullView = new i(this.fdn.getPageContext());
        if (this.dcE == null) {
            this.dcE = (BdSwipeRefreshLayout) view.findViewById(d.g.frs_ad_pull_refresh_layout);
            this.dcE.setProgressView(this.mPullView);
            al.l(this.dcE, d.C0277d.cp_bg_line_e);
        }
        this.bhF = (FrameLayout) view.findViewById(d.g.frs_ad_list_content);
        fB(false);
    }

    public void setListPullRefreshListener(h.c cVar) {
        this.mPullView.setListPullRefreshListener(cVar);
    }

    public void fB(boolean z) {
        if (!z) {
            this.dcE.setRefreshing(false);
        }
    }

    public BdTypeRecyclerView getListView() {
        return this.faG;
    }

    public RelativeLayout bdJ() {
        return this.cMt;
    }

    public View beI() {
        return this.dcE;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void aCr() {
        this.faG.setNextPage(this.dbr);
        this.dbr.ic(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        this.dbr.aez();
    }

    public void aCs() {
        this.faG.setNextPage(this.dbr);
        this.dbr.ic(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        this.dbr.aeA();
        this.dbr.setText(this.fdn.getResources().getString(d.j.list_no_more));
    }

    public void aCt() {
        this.faG.setNextPage(null);
    }

    public void jv(boolean z) {
        this.bhF.setVisibility(z ? 0 : 8);
    }

    public void startPullRefresh() {
        this.dcE.setRefreshing(true);
    }

    public void bdv() {
        if (this.fdy != null) {
            this.fdy.notifyDataSetChanged();
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mPullView != null) {
            this.mPullView.ib(i);
        }
        this.fdn.getBaseFragmentActivity().getLayoutMode().setNightMode(i == 1);
        this.fdn.getBaseFragmentActivity().getLayoutMode().onModeChanged(this.cMt);
        if (this.dbr != null) {
            this.dbr.setTextColor(al.getColor(d.C0277d.cp_cont_j));
            this.dbr.ib(i);
        }
        al.l(this.dcE, d.C0277d.cp_bg_line_e);
        if (this.fdy != null) {
            this.fdy.notifyDataSetChanged();
        }
    }

    public void onDestroy() {
        this.fdy.onDestory();
        this.faG.setOnSrollToBottomListener(null);
    }
}
