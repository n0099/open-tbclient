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
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.view.PbListView;
import com.baidu.tbadk.core.view.UserPhotoLayout;
import com.baidu.tbadk.core.view.h;
import com.baidu.tbadk.core.view.i;
import com.baidu.tieba.R;
import com.baidu.tieba.tbadkCore.FrsCommonImageLayout;
import com.baidu.tieba.tbadkCore.voice.PlayVoiceBnt;
/* loaded from: classes4.dex */
public class e {
    private FrameLayout boW;
    private RelativeLayout cXd;
    private PbListView dpz;
    private BdSwipeRefreshLayout dra;
    private FrsADFragment fAK;
    private a fAV;
    private BdTypeRecyclerView fyf;
    private i mPullView;

    public e(FrsADFragment frsADFragment, View view) {
        this.fAK = frsADFragment;
        bM(view);
    }

    public a boZ() {
        return this.fAV;
    }

    private void bM(View view) {
        this.cXd = (RelativeLayout) view.findViewById(R.id.frs_ad_container);
        this.fyf = (BdTypeRecyclerView) view.findViewById(R.id.frs_ad_listview);
        this.fyf.setLayoutManager(new LinearLayoutManager(this.fyf.getContext()));
        this.fyf.setFadingEdgeLength(0);
        this.fyf.setOverScrollMode(2);
        this.fyf.setRecyclerListener(new RecyclerView.RecyclerListener() { // from class: com.baidu.tieba.frs.ad.e.1
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
        this.fyf.setOnSrollToBottomListener(this.fAK);
        this.fAV = new a(this.fAK, this.fyf);
        this.dpz = new PbListView(this.fAK.getPageContext().getPageActivity());
        this.dpz.nZ();
        this.dpz.iX(R.color.cp_bg_line_e);
        this.dpz.setHeight(l.g(this.fAK.getActivity(), R.dimen.tbds182));
        this.dpz.akO();
        this.dpz.setTextSize(R.dimen.tbfontsize33);
        this.dpz.setTextColor(am.getColor(R.color.cp_cont_j));
        this.dpz.iW(R.color.cp_cont_e);
        this.mPullView = new i(this.fAK.getPageContext());
        if (this.dra == null) {
            this.dra = (BdSwipeRefreshLayout) view.findViewById(R.id.frs_ad_pull_refresh_layout);
            this.dra.setProgressView(this.mPullView);
            am.l(this.dra, R.color.cp_bg_line_e);
        }
        this.boW = (FrameLayout) view.findViewById(R.id.frs_ad_list_content);
        gf(false);
    }

    public void setListPullRefreshListener(h.c cVar) {
        this.mPullView.setListPullRefreshListener(cVar);
    }

    public void gf(boolean z) {
        if (!z) {
            this.dra.setRefreshing(false);
        }
    }

    public BdTypeRecyclerView getListView() {
        return this.fyf;
    }

    public RelativeLayout aYe() {
        return this.cXd;
    }

    public View bpa() {
        return this.dra;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void aKO() {
        this.fyf.setNextPage(this.dpz);
        this.dpz.iZ(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        this.dpz.akR();
    }

    public void aKP() {
        this.fyf.setNextPage(this.dpz);
        this.dpz.iZ(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        this.dpz.akS();
        this.dpz.setText(this.fAK.getResources().getString(R.string.list_no_more));
    }

    public void aKQ() {
        this.fyf.setNextPage(null);
    }

    public void ks(boolean z) {
        this.boW.setVisibility(z ? 0 : 8);
    }

    public void startPullRefresh() {
        this.dra.setRefreshing(true);
    }

    public void bnN() {
        if (this.fAV != null) {
            this.fAV.notifyDataSetChanged();
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mPullView != null) {
            this.mPullView.iY(i);
        }
        this.fAK.getBaseFragmentActivity().getLayoutMode().setNightMode(i == 1);
        this.fAK.getBaseFragmentActivity().getLayoutMode().onModeChanged(this.cXd);
        if (this.dpz != null) {
            this.dpz.setTextColor(am.getColor(R.color.cp_cont_j));
            this.dpz.iY(i);
        }
        am.l(this.dra, R.color.cp_bg_line_e);
        if (this.fAV != null) {
            this.fAV.notifyDataSetChanged();
        }
    }

    public void onDestroy() {
        this.fAV.onDestory();
        this.fyf.setOnSrollToBottomListener(null);
    }
}
