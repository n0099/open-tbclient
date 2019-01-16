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
    private RelativeLayout bBm;
    private PbListView bPm;
    private BdSwipeRefreshLayout bRZ;
    private BdTypeRecyclerView dNm;
    private FrsADFragment dPF;
    private a dPQ;
    private FrameLayout mListContainer;
    private k mPullView;

    public e(FrsADFragment frsADFragment, View view) {
        this.dPF = frsADFragment;
        aL(view);
    }

    public a aEa() {
        return this.dPQ;
    }

    private void aL(View view) {
        this.bBm = (RelativeLayout) view.findViewById(e.g.frs_ad_container);
        this.dNm = (BdTypeRecyclerView) view.findViewById(e.g.frs_ad_listview);
        this.dNm.setLayoutManager(new LinearLayoutManager(this.dNm.getContext()));
        this.dNm.setFadingEdgeLength(0);
        this.dNm.setOverScrollMode(2);
        this.dNm.setRecyclerListener(new RecyclerView.RecyclerListener() { // from class: com.baidu.tieba.frs.ad.e.1
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
        this.dNm.setOnSrollToBottomListener(this.dPF);
        this.dPQ = new a(this.dPF, this.dNm);
        this.bPm = new PbListView(this.dPF.getPageContext().getPageActivity());
        this.bPm.oH();
        this.bPm.ex(e.d.cp_bg_line_e);
        this.bPm.setHeight(l.h(this.dPF.getActivity(), e.C0210e.tbds182));
        this.bPm.Fm();
        this.bPm.setTextSize(e.C0210e.tbfontsize33);
        this.bPm.setTextColor(al.getColor(e.d.cp_cont_j));
        this.bPm.ew(e.d.cp_cont_e);
        this.mPullView = new k(this.dPF.getPageContext());
        if (this.bRZ == null) {
            this.bRZ = (BdSwipeRefreshLayout) view.findViewById(e.g.frs_ad_pull_refresh_layout);
            this.bRZ.setProgressView(this.mPullView);
            al.j(this.bRZ, e.d.cp_bg_line_e);
        }
        this.mListContainer = (FrameLayout) view.findViewById(e.g.frs_ad_list_content);
        dl(false);
    }

    public void a(j.b bVar) {
        this.mPullView.a(bVar);
    }

    public void dl(boolean z) {
        if (!z) {
            this.bRZ.setRefreshing(false);
        }
    }

    public BdTypeRecyclerView getListView() {
        return this.dNm;
    }

    public RelativeLayout aDc() {
        return this.bBm;
    }

    public View aEb() {
        return this.bRZ;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void aby() {
        this.dNm.setNextPage(this.bPm);
        this.bPm.ez(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        this.bPm.Fp();
    }

    public void abz() {
        this.dNm.setNextPage(this.bPm);
        this.bPm.ez(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        this.bPm.Fq();
        this.bPm.setText(this.dPF.getResources().getString(e.j.list_no_more));
    }

    public void abA() {
        this.dNm.setNextPage(null);
    }

    public void gX(boolean z) {
        this.mListContainer.setVisibility(z ? 0 : 8);
    }

    public void startPullRefresh() {
        this.bRZ.setRefreshing(true);
    }

    public void aCR() {
        if (this.dPQ != null) {
            this.dPQ.notifyDataSetChanged();
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mPullView != null) {
            this.mPullView.ey(i);
        }
        this.dPF.getBaseFragmentActivity().getLayoutMode().setNightMode(i == 1);
        this.dPF.getBaseFragmentActivity().getLayoutMode().onModeChanged(this.bBm);
        if (this.bPm != null) {
            this.bPm.setTextColor(al.getColor(e.d.cp_cont_j));
            this.bPm.ey(i);
        }
        al.j(this.bRZ, e.d.cp_bg_line_e);
        if (this.dPQ != null) {
            this.dPQ.notifyDataSetChanged();
        }
    }

    public void onDestroy() {
        this.dPQ.onDestory();
        this.dNm.setOnSrollToBottomListener(null);
    }
}
