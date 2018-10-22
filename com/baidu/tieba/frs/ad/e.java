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
    private PbListView bJY;
    private BdSwipeRefreshLayout bMJ;
    private RelativeLayout bwo;
    private BdTypeRecyclerView dBZ;
    private a dEE;
    private FrameLayout dER;
    private FrsADFragment dEt;
    private k mPullView;

    public e(FrsADFragment frsADFragment, View view) {
        this.dEt = frsADFragment;
        aG(view);
    }

    public a aBH() {
        return this.dEE;
    }

    private void aG(View view) {
        this.bwo = (RelativeLayout) view.findViewById(e.g.frs_ad_container);
        this.dBZ = (BdTypeRecyclerView) view.findViewById(e.g.frs_ad_listview);
        this.dBZ.setLayoutManager(new LinearLayoutManager(this.dBZ.getContext()));
        this.dBZ.setFadingEdgeLength(0);
        this.dBZ.setOverScrollMode(2);
        this.dBZ.setRecyclerListener(new RecyclerView.RecyclerListener() { // from class: com.baidu.tieba.frs.ad.e.1
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
        this.dBZ.setOnSrollToBottomListener(this.dEt);
        this.dEE = new a(this.dEt, this.dBZ);
        this.bJY = new PbListView(this.dEt.getPageContext().getPageActivity());
        this.bJY.oG();
        this.bJY.dV(e.d.cp_bg_line_e);
        this.bJY.setHeight(l.h(this.dEt.getActivity(), e.C0175e.tbds182));
        this.bJY.DL();
        this.bJY.setTextSize(e.C0175e.tbfontsize33);
        this.bJY.setTextColor(al.getColor(e.d.cp_cont_j));
        this.bJY.dU(e.d.cp_cont_e);
        this.mPullView = new k(this.dEt.getPageContext());
        if (this.bMJ == null) {
            this.bMJ = (BdSwipeRefreshLayout) view.findViewById(e.g.frs_ad_pull_refresh_layout);
            this.bMJ.setProgressView(this.mPullView);
            al.j(this.bMJ, e.d.cp_bg_line_e);
        }
        this.dER = (FrameLayout) view.findViewById(e.g.frs_ad_list_content);
        cQ(false);
    }

    public void a(j.b bVar) {
        this.mPullView.a(bVar);
    }

    public void cQ(boolean z) {
        if (!z) {
            this.bMJ.setRefreshing(false);
        }
    }

    public BdTypeRecyclerView getListView() {
        return this.dBZ;
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
        this.bJY.setText(this.dEt.getResources().getString(e.j.list_no_more));
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
        if (this.dEE != null) {
            this.dEE.notifyDataSetChanged();
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mPullView != null) {
            this.mPullView.dW(i);
        }
        this.dEt.getBaseFragmentActivity().getLayoutMode().setNightMode(i == 1);
        this.dEt.getBaseFragmentActivity().getLayoutMode().onModeChanged(this.bwo);
        if (this.bJY != null) {
            this.bJY.setTextColor(al.getColor(e.d.cp_cont_j));
            this.bJY.dW(i);
        }
        al.j(this.bMJ, e.d.cp_bg_line_e);
        if (this.dEE != null) {
            this.dEE.notifyDataSetChanged();
        }
    }

    public void onDestroy() {
        this.dEE.onDestory();
        this.dBZ.setOnSrollToBottomListener(null);
    }
}
