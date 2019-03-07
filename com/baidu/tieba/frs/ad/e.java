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
    private FrameLayout bhB;
    private RelativeLayout cMu;
    private PbListView dbr;
    private BdSwipeRefreshLayout dcE;
    private BdTypeRecyclerView faU;
    private FrsADFragment fdB;
    private a fdM;
    private i mPullView;

    public e(FrsADFragment frsADFragment, View view) {
        this.fdB = frsADFragment;
        bD(view);
    }

    public a beJ() {
        return this.fdM;
    }

    private void bD(View view) {
        this.cMu = (RelativeLayout) view.findViewById(d.g.frs_ad_container);
        this.faU = (BdTypeRecyclerView) view.findViewById(d.g.frs_ad_listview);
        this.faU.setLayoutManager(new LinearLayoutManager(this.faU.getContext()));
        this.faU.setFadingEdgeLength(0);
        this.faU.setOverScrollMode(2);
        this.faU.setRecyclerListener(new RecyclerView.RecyclerListener() { // from class: com.baidu.tieba.frs.ad.e.1
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
        this.faU.setOnSrollToBottomListener(this.fdB);
        this.fdM = new a(this.fdB, this.faU);
        this.dbr = new PbListView(this.fdB.getPageContext().getPageActivity());
        this.dbr.oM();
        this.dbr.ib(d.C0236d.cp_bg_line_e);
        this.dbr.setHeight(l.h(this.fdB.getActivity(), d.e.tbds182));
        this.dbr.aez();
        this.dbr.setTextSize(d.e.tbfontsize33);
        this.dbr.setTextColor(al.getColor(d.C0236d.cp_cont_j));
        this.dbr.ia(d.C0236d.cp_cont_e);
        this.mPullView = new i(this.fdB.getPageContext());
        if (this.dcE == null) {
            this.dcE = (BdSwipeRefreshLayout) view.findViewById(d.g.frs_ad_pull_refresh_layout);
            this.dcE.setProgressView(this.mPullView);
            al.l(this.dcE, d.C0236d.cp_bg_line_e);
        }
        this.bhB = (FrameLayout) view.findViewById(d.g.frs_ad_list_content);
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
        return this.faU;
    }

    public RelativeLayout bdL() {
        return this.cMu;
    }

    public View beK() {
        return this.dcE;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void aCu() {
        this.faU.setNextPage(this.dbr);
        this.dbr.id(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        this.dbr.aeC();
    }

    public void aCv() {
        this.faU.setNextPage(this.dbr);
        this.dbr.id(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        this.dbr.aeD();
        this.dbr.setText(this.fdB.getResources().getString(d.j.list_no_more));
    }

    public void aCw() {
        this.faU.setNextPage(null);
    }

    public void jv(boolean z) {
        this.bhB.setVisibility(z ? 0 : 8);
    }

    public void startPullRefresh() {
        this.dcE.setRefreshing(true);
    }

    public void bdx() {
        if (this.fdM != null) {
            this.fdM.notifyDataSetChanged();
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mPullView != null) {
            this.mPullView.ic(i);
        }
        this.fdB.getBaseFragmentActivity().getLayoutMode().setNightMode(i == 1);
        this.fdB.getBaseFragmentActivity().getLayoutMode().onModeChanged(this.cMu);
        if (this.dbr != null) {
            this.dbr.setTextColor(al.getColor(d.C0236d.cp_cont_j));
            this.dbr.ic(i);
        }
        al.l(this.dcE, d.C0236d.cp_bg_line_e);
        if (this.fdM != null) {
            this.fdM.notifyDataSetChanged();
        }
    }

    public void onDestroy() {
        this.fdM.onDestory();
        this.faU.setOnSrollToBottomListener(null);
    }
}
