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
import com.baidu.tieba.R;
import com.baidu.tieba.tbadkCore.FrsCommonImageLayout;
import com.baidu.tieba.tbadkCore.voice.PlayVoiceBnt;
/* loaded from: classes4.dex */
public class e {
    private FrameLayout bnL;
    private RelativeLayout cUH;
    private PbListView dlY;
    private BdSwipeRefreshLayout dni;
    private BdTypeRecyclerView fqV;
    private FrsADFragment ftC;
    private a ftN;
    private i mPullView;

    public e(FrsADFragment frsADFragment, View view) {
        this.ftC = frsADFragment;
        bK(view);
    }

    public a bmc() {
        return this.ftN;
    }

    private void bK(View view) {
        this.cUH = (RelativeLayout) view.findViewById(R.id.frs_ad_container);
        this.fqV = (BdTypeRecyclerView) view.findViewById(R.id.frs_ad_listview);
        this.fqV.setLayoutManager(new LinearLayoutManager(this.fqV.getContext()));
        this.fqV.setFadingEdgeLength(0);
        this.fqV.setOverScrollMode(2);
        this.fqV.setRecyclerListener(new RecyclerView.RecyclerListener() { // from class: com.baidu.tieba.frs.ad.e.1
            @Override // android.support.v7.widget.RecyclerView.RecyclerListener
            public void onViewRecycled(RecyclerView.ViewHolder viewHolder) {
                View view2 = viewHolder.itemView;
                if (view2 != null) {
                    PlayVoiceBnt playVoiceBnt = (PlayVoiceBnt) view2.findViewById(R.id.abstract_voice);
                    if (playVoiceBnt != null) {
                        playVoiceBnt.reset();
                    }
                    FrsCommonImageLayout frsCommonImageLayout = (FrsCommonImageLayout) view2.findViewById(R.id.abstract_img_layout);
                    if (frsCommonImageLayout != null) {
                        frsCommonImageLayout.reset();
                    }
                    if (view2 instanceof UserPhotoLayout) {
                        ((UserPhotoLayout) view2).reset();
                    }
                }
            }
        });
        this.fqV.setOnSrollToBottomListener(this.ftC);
        this.ftN = new a(this.ftC, this.fqV);
        this.dlY = new PbListView(this.ftC.getPageContext().getPageActivity());
        this.dlY.nG();
        this.dlY.iO(R.color.cp_bg_line_e);
        this.dlY.setHeight(l.g(this.ftC.getActivity(), R.dimen.tbds182));
        this.dlY.ajv();
        this.dlY.setTextSize(R.dimen.tbfontsize33);
        this.dlY.setTextColor(al.getColor(R.color.cp_cont_j));
        this.dlY.iN(R.color.cp_cont_e);
        this.mPullView = new i(this.ftC.getPageContext());
        if (this.dni == null) {
            this.dni = (BdSwipeRefreshLayout) view.findViewById(R.id.frs_ad_pull_refresh_layout);
            this.dni.setProgressView(this.mPullView);
            al.l(this.dni, R.color.cp_bg_line_e);
        }
        this.bnL = (FrameLayout) view.findViewById(R.id.frs_ad_list_content);
        fY(false);
    }

    public void setListPullRefreshListener(h.c cVar) {
        this.mPullView.setListPullRefreshListener(cVar);
    }

    public void fY(boolean z) {
        if (!z) {
            this.dni.setRefreshing(false);
        }
    }

    public BdTypeRecyclerView getListView() {
        return this.fqV;
    }

    public RelativeLayout bld() {
        return this.cUH;
    }

    public View bmd() {
        return this.dni;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void aIH() {
        this.fqV.setNextPage(this.dlY);
        this.dlY.iQ(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        this.dlY.ajy();
    }

    public void aII() {
        this.fqV.setNextPage(this.dlY);
        this.dlY.iQ(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        this.dlY.ajz();
        this.dlY.setText(this.ftC.getResources().getString(R.string.list_no_more));
    }

    public void aIJ() {
        this.fqV.setNextPage(null);
    }

    public void kf(boolean z) {
        this.bnL.setVisibility(z ? 0 : 8);
    }

    public void startPullRefresh() {
        this.dni.setRefreshing(true);
    }

    public void bkQ() {
        if (this.ftN != null) {
            this.ftN.notifyDataSetChanged();
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mPullView != null) {
            this.mPullView.iP(i);
        }
        this.ftC.getBaseFragmentActivity().getLayoutMode().setNightMode(i == 1);
        this.ftC.getBaseFragmentActivity().getLayoutMode().onModeChanged(this.cUH);
        if (this.dlY != null) {
            this.dlY.setTextColor(al.getColor(R.color.cp_cont_j));
            this.dlY.iP(i);
        }
        al.l(this.dni, R.color.cp_bg_line_e);
        if (this.ftN != null) {
            this.ftN.notifyDataSetChanged();
        }
    }

    public void onDestroy() {
        this.ftN.onDestory();
        this.fqV.setOnSrollToBottomListener(null);
    }
}
