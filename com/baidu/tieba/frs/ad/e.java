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
    private RelativeLayout cUF;
    private PbListView dlX;
    private BdSwipeRefreshLayout dnh;
    private BdTypeRecyclerView fqU;
    private FrsADFragment ftB;
    private a ftM;
    private i mPullView;

    public e(FrsADFragment frsADFragment, View view) {
        this.ftB = frsADFragment;
        bK(view);
    }

    public a blZ() {
        return this.ftM;
    }

    private void bK(View view) {
        this.cUF = (RelativeLayout) view.findViewById(R.id.frs_ad_container);
        this.fqU = (BdTypeRecyclerView) view.findViewById(R.id.frs_ad_listview);
        this.fqU.setLayoutManager(new LinearLayoutManager(this.fqU.getContext()));
        this.fqU.setFadingEdgeLength(0);
        this.fqU.setOverScrollMode(2);
        this.fqU.setRecyclerListener(new RecyclerView.RecyclerListener() { // from class: com.baidu.tieba.frs.ad.e.1
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
        this.fqU.setOnSrollToBottomListener(this.ftB);
        this.ftM = new a(this.ftB, this.fqU);
        this.dlX = new PbListView(this.ftB.getPageContext().getPageActivity());
        this.dlX.nG();
        this.dlX.iO(R.color.cp_bg_line_e);
        this.dlX.setHeight(l.g(this.ftB.getActivity(), R.dimen.tbds182));
        this.dlX.ajv();
        this.dlX.setTextSize(R.dimen.tbfontsize33);
        this.dlX.setTextColor(al.getColor(R.color.cp_cont_j));
        this.dlX.iN(R.color.cp_cont_e);
        this.mPullView = new i(this.ftB.getPageContext());
        if (this.dnh == null) {
            this.dnh = (BdSwipeRefreshLayout) view.findViewById(R.id.frs_ad_pull_refresh_layout);
            this.dnh.setProgressView(this.mPullView);
            al.l(this.dnh, R.color.cp_bg_line_e);
        }
        this.bnL = (FrameLayout) view.findViewById(R.id.frs_ad_list_content);
        fY(false);
    }

    public void setListPullRefreshListener(h.c cVar) {
        this.mPullView.setListPullRefreshListener(cVar);
    }

    public void fY(boolean z) {
        if (!z) {
            this.dnh.setRefreshing(false);
        }
    }

    public BdTypeRecyclerView getListView() {
        return this.fqU;
    }

    public RelativeLayout bla() {
        return this.cUF;
    }

    public View bma() {
        return this.dnh;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void aIE() {
        this.fqU.setNextPage(this.dlX);
        this.dlX.iQ(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        this.dlX.ajy();
    }

    public void aIF() {
        this.fqU.setNextPage(this.dlX);
        this.dlX.iQ(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        this.dlX.ajz();
        this.dlX.setText(this.ftB.getResources().getString(R.string.list_no_more));
    }

    public void aIG() {
        this.fqU.setNextPage(null);
    }

    public void kf(boolean z) {
        this.bnL.setVisibility(z ? 0 : 8);
    }

    public void startPullRefresh() {
        this.dnh.setRefreshing(true);
    }

    public void bkN() {
        if (this.ftM != null) {
            this.ftM.notifyDataSetChanged();
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mPullView != null) {
            this.mPullView.iP(i);
        }
        this.ftB.getBaseFragmentActivity().getLayoutMode().setNightMode(i == 1);
        this.ftB.getBaseFragmentActivity().getLayoutMode().onModeChanged(this.cUF);
        if (this.dlX != null) {
            this.dlX.setTextColor(al.getColor(R.color.cp_cont_j));
            this.dlX.iP(i);
        }
        al.l(this.dnh, R.color.cp_bg_line_e);
        if (this.ftM != null) {
            this.ftM.notifyDataSetChanged();
        }
    }

    public void onDestroy() {
        this.ftM.onDestory();
        this.fqU.setOnSrollToBottomListener(null);
    }
}
