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
    private FrameLayout bhG;
    private RelativeLayout cMu;
    private PbListView dbs;
    private BdSwipeRefreshLayout dcF;
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
        this.cMu = (RelativeLayout) view.findViewById(d.g.frs_ad_container);
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
        this.dbs = new PbListView(this.fdn.getPageContext().getPageActivity());
        this.dbs.oM();
        this.dbs.ia(d.C0277d.cp_bg_line_e);
        this.dbs.setHeight(l.h(this.fdn.getActivity(), d.e.tbds182));
        this.dbs.aew();
        this.dbs.setTextSize(d.e.tbfontsize33);
        this.dbs.setTextColor(al.getColor(d.C0277d.cp_cont_j));
        this.dbs.hZ(d.C0277d.cp_cont_e);
        this.mPullView = new i(this.fdn.getPageContext());
        if (this.dcF == null) {
            this.dcF = (BdSwipeRefreshLayout) view.findViewById(d.g.frs_ad_pull_refresh_layout);
            this.dcF.setProgressView(this.mPullView);
            al.l(this.dcF, d.C0277d.cp_bg_line_e);
        }
        this.bhG = (FrameLayout) view.findViewById(d.g.frs_ad_list_content);
        fB(false);
    }

    public void setListPullRefreshListener(h.c cVar) {
        this.mPullView.setListPullRefreshListener(cVar);
    }

    public void fB(boolean z) {
        if (!z) {
            this.dcF.setRefreshing(false);
        }
    }

    public BdTypeRecyclerView getListView() {
        return this.faG;
    }

    public RelativeLayout bdJ() {
        return this.cMu;
    }

    public View beI() {
        return this.dcF;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void aCr() {
        this.faG.setNextPage(this.dbs);
        this.dbs.ic(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        this.dbs.aez();
    }

    public void aCs() {
        this.faG.setNextPage(this.dbs);
        this.dbs.ic(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        this.dbs.aeA();
        this.dbs.setText(this.fdn.getResources().getString(d.j.list_no_more));
    }

    public void aCt() {
        this.faG.setNextPage(null);
    }

    public void jv(boolean z) {
        this.bhG.setVisibility(z ? 0 : 8);
    }

    public void startPullRefresh() {
        this.dcF.setRefreshing(true);
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
        this.fdn.getBaseFragmentActivity().getLayoutMode().onModeChanged(this.cMu);
        if (this.dbs != null) {
            this.dbs.setTextColor(al.getColor(d.C0277d.cp_cont_j));
            this.dbs.ib(i);
        }
        al.l(this.dcF, d.C0277d.cp_bg_line_e);
        if (this.fdy != null) {
            this.fdy.notifyDataSetChanged();
        }
    }

    public void onDestroy() {
        this.fdy.onDestory();
        this.faG.setOnSrollToBottomListener(null);
    }
}
