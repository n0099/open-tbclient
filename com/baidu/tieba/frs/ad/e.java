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
import com.baidu.tbadk.core.view.j;
import com.baidu.tbadk.core.view.k;
import com.baidu.tieba.e;
import com.baidu.tieba.tbadkCore.FrsCommonImageLayout;
import com.baidu.tieba.tbadkCore.voice.PlayVoiceBnt;
/* loaded from: classes6.dex */
public class e {
    private PbListView bKJ;
    private BdSwipeRefreshLayout bNu;
    private RelativeLayout bwZ;
    private BdTypeRecyclerView dDq;
    private FrsADFragment dFJ;
    private a dFU;
    private FrameLayout mListContainer;
    private k mPullView;

    public e(FrsADFragment frsADFragment, View view) {
        this.dFJ = frsADFragment;
        aI(view);
    }

    public a aBe() {
        return this.dFU;
    }

    private void aI(View view) {
        this.bwZ = (RelativeLayout) view.findViewById(e.g.frs_ad_container);
        this.dDq = (BdTypeRecyclerView) view.findViewById(e.g.frs_ad_listview);
        this.dDq.setLayoutManager(new LinearLayoutManager(this.dDq.getContext()));
        this.dDq.setFadingEdgeLength(0);
        this.dDq.setOverScrollMode(2);
        this.dDq.setRecyclerListener(new RecyclerView.RecyclerListener() { // from class: com.baidu.tieba.frs.ad.e.1
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
        this.dDq.setOnSrollToBottomListener(this.dFJ);
        this.dFU = new a(this.dFJ, this.dDq);
        this.bKJ = new PbListView(this.dFJ.getPageContext().getPageActivity());
        this.bKJ.oE();
        this.bKJ.ej(e.d.cp_bg_line_e);
        this.bKJ.setHeight(l.h(this.dFJ.getActivity(), e.C0200e.tbds182));
        this.bKJ.DV();
        this.bKJ.setTextSize(e.C0200e.tbfontsize33);
        this.bKJ.setTextColor(al.getColor(e.d.cp_cont_j));
        this.bKJ.ei(e.d.cp_cont_e);
        this.mPullView = new k(this.dFJ.getPageContext());
        if (this.bNu == null) {
            this.bNu = (BdSwipeRefreshLayout) view.findViewById(e.g.frs_ad_pull_refresh_layout);
            this.bNu.setProgressView(this.mPullView);
            al.j(this.bNu, e.d.cp_bg_line_e);
        }
        this.mListContainer = (FrameLayout) view.findViewById(e.g.frs_ad_list_content);
        dh(false);
    }

    public void a(j.b bVar) {
        this.mPullView.a(bVar);
    }

    public void dh(boolean z) {
        if (!z) {
            this.bNu.setRefreshing(false);
        }
    }

    public BdTypeRecyclerView getListView() {
        return this.dDq;
    }

    public RelativeLayout aAg() {
        return this.bwZ;
    }

    public View aBf() {
        return this.bNu;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void ZT() {
        this.dDq.setNextPage(this.bKJ);
        this.bKJ.el(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        this.bKJ.DY();
    }

    public void ZU() {
        this.dDq.setNextPage(this.bKJ);
        this.bKJ.el(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        this.bKJ.DZ();
        this.bKJ.setText(this.dFJ.getResources().getString(e.j.list_no_more));
    }

    public void ZV() {
        this.dDq.setNextPage(null);
    }

    public void gQ(boolean z) {
        this.mListContainer.setVisibility(z ? 0 : 8);
    }

    public void startPullRefresh() {
        this.bNu.setRefreshing(true);
    }

    public void azV() {
        if (this.dFU != null) {
            this.dFU.notifyDataSetChanged();
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mPullView != null) {
            this.mPullView.ek(i);
        }
        this.dFJ.getBaseFragmentActivity().getLayoutMode().setNightMode(i == 1);
        this.dFJ.getBaseFragmentActivity().getLayoutMode().onModeChanged(this.bwZ);
        if (this.bKJ != null) {
            this.bKJ.setTextColor(al.getColor(e.d.cp_cont_j));
            this.bKJ.ek(i);
        }
        al.j(this.bNu, e.d.cp_bg_line_e);
        if (this.dFU != null) {
            this.dFU.notifyDataSetChanged();
        }
    }

    public void onDestroy() {
        this.dFU.onDestory();
        this.dDq.setOnSrollToBottomListener(null);
    }
}
