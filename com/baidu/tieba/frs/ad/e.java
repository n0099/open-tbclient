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
    private RelativeLayout bBn;
    private PbListView bPn;
    private BdSwipeRefreshLayout bSa;
    private BdTypeRecyclerView dNn;
    private FrsADFragment dPG;
    private a dPR;
    private FrameLayout mListContainer;
    private k mPullView;

    public e(FrsADFragment frsADFragment, View view) {
        this.dPG = frsADFragment;
        aL(view);
    }

    public a aEa() {
        return this.dPR;
    }

    private void aL(View view) {
        this.bBn = (RelativeLayout) view.findViewById(e.g.frs_ad_container);
        this.dNn = (BdTypeRecyclerView) view.findViewById(e.g.frs_ad_listview);
        this.dNn.setLayoutManager(new LinearLayoutManager(this.dNn.getContext()));
        this.dNn.setFadingEdgeLength(0);
        this.dNn.setOverScrollMode(2);
        this.dNn.setRecyclerListener(new RecyclerView.RecyclerListener() { // from class: com.baidu.tieba.frs.ad.e.1
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
        this.dNn.setOnSrollToBottomListener(this.dPG);
        this.dPR = new a(this.dPG, this.dNn);
        this.bPn = new PbListView(this.dPG.getPageContext().getPageActivity());
        this.bPn.oH();
        this.bPn.ex(e.d.cp_bg_line_e);
        this.bPn.setHeight(l.h(this.dPG.getActivity(), e.C0210e.tbds182));
        this.bPn.Fm();
        this.bPn.setTextSize(e.C0210e.tbfontsize33);
        this.bPn.setTextColor(al.getColor(e.d.cp_cont_j));
        this.bPn.ew(e.d.cp_cont_e);
        this.mPullView = new k(this.dPG.getPageContext());
        if (this.bSa == null) {
            this.bSa = (BdSwipeRefreshLayout) view.findViewById(e.g.frs_ad_pull_refresh_layout);
            this.bSa.setProgressView(this.mPullView);
            al.j(this.bSa, e.d.cp_bg_line_e);
        }
        this.mListContainer = (FrameLayout) view.findViewById(e.g.frs_ad_list_content);
        dl(false);
    }

    public void a(j.b bVar) {
        this.mPullView.a(bVar);
    }

    public void dl(boolean z) {
        if (!z) {
            this.bSa.setRefreshing(false);
        }
    }

    public BdTypeRecyclerView getListView() {
        return this.dNn;
    }

    public RelativeLayout aDc() {
        return this.bBn;
    }

    public View aEb() {
        return this.bSa;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void aby() {
        this.dNn.setNextPage(this.bPn);
        this.bPn.ez(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        this.bPn.Fp();
    }

    public void abz() {
        this.dNn.setNextPage(this.bPn);
        this.bPn.ez(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        this.bPn.Fq();
        this.bPn.setText(this.dPG.getResources().getString(e.j.list_no_more));
    }

    public void abA() {
        this.dNn.setNextPage(null);
    }

    public void gX(boolean z) {
        this.mListContainer.setVisibility(z ? 0 : 8);
    }

    public void startPullRefresh() {
        this.bSa.setRefreshing(true);
    }

    public void aCR() {
        if (this.dPR != null) {
            this.dPR.notifyDataSetChanged();
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mPullView != null) {
            this.mPullView.ey(i);
        }
        this.dPG.getBaseFragmentActivity().getLayoutMode().setNightMode(i == 1);
        this.dPG.getBaseFragmentActivity().getLayoutMode().onModeChanged(this.bBn);
        if (this.bPn != null) {
            this.bPn.setTextColor(al.getColor(e.d.cp_cont_j));
            this.bPn.ey(i);
        }
        al.j(this.bSa, e.d.cp_bg_line_e);
        if (this.dPR != null) {
            this.dPR.notifyDataSetChanged();
        }
    }

    public void onDestroy() {
        this.dPR.onDestory();
        this.dNn.setOnSrollToBottomListener(null);
    }
}
