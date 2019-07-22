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
    private FrameLayout boy;
    private RelativeLayout cWd;
    private PbListView dnG;
    private BdSwipeRefreshLayout dpi;
    private BdTypeRecyclerView fvT;
    private a fyJ;
    private FrsADFragment fyy;
    private i mPullView;

    public e(FrsADFragment frsADFragment, View view) {
        this.fyy = frsADFragment;
        bM(view);
    }

    public a bod() {
        return this.fyJ;
    }

    private void bM(View view) {
        this.cWd = (RelativeLayout) view.findViewById(R.id.frs_ad_container);
        this.fvT = (BdTypeRecyclerView) view.findViewById(R.id.frs_ad_listview);
        this.fvT.setLayoutManager(new LinearLayoutManager(this.fvT.getContext()));
        this.fvT.setFadingEdgeLength(0);
        this.fvT.setOverScrollMode(2);
        this.fvT.setRecyclerListener(new RecyclerView.RecyclerListener() { // from class: com.baidu.tieba.frs.ad.e.1
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
        this.fvT.setOnSrollToBottomListener(this.fyy);
        this.fyJ = new a(this.fyy, this.fvT);
        this.dnG = new PbListView(this.fyy.getPageContext().getPageActivity());
        this.dnG.nZ();
        this.dnG.iU(R.color.cp_bg_line_e);
        this.dnG.setHeight(l.g(this.fyy.getActivity(), R.dimen.tbds182));
        this.dnG.akA();
        this.dnG.setTextSize(R.dimen.tbfontsize33);
        this.dnG.setTextColor(am.getColor(R.color.cp_cont_j));
        this.dnG.iT(R.color.cp_cont_e);
        this.mPullView = new i(this.fyy.getPageContext());
        if (this.dpi == null) {
            this.dpi = (BdSwipeRefreshLayout) view.findViewById(R.id.frs_ad_pull_refresh_layout);
            this.dpi.setProgressView(this.mPullView);
            am.l(this.dpi, R.color.cp_bg_line_e);
        }
        this.boy = (FrameLayout) view.findViewById(R.id.frs_ad_list_content);
        gc(false);
    }

    public void setListPullRefreshListener(h.c cVar) {
        this.mPullView.setListPullRefreshListener(cVar);
    }

    public void gc(boolean z) {
        if (!z) {
            this.dpi.setRefreshing(false);
        }
    }

    public BdTypeRecyclerView getListView() {
        return this.fvT;
    }

    public RelativeLayout aXy() {
        return this.cWd;
    }

    public View boe() {
        return this.dpi;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void aKi() {
        this.fvT.setNextPage(this.dnG);
        this.dnG.iW(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        this.dnG.akD();
    }

    public void aKj() {
        this.fvT.setNextPage(this.dnG);
        this.dnG.iW(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        this.dnG.akE();
        this.dnG.setText(this.fyy.getResources().getString(R.string.list_no_more));
    }

    public void aKk() {
        this.fvT.setNextPage(null);
    }

    public void kp(boolean z) {
        this.boy.setVisibility(z ? 0 : 8);
    }

    public void startPullRefresh() {
        this.dpi.setRefreshing(true);
    }

    public void bmS() {
        if (this.fyJ != null) {
            this.fyJ.notifyDataSetChanged();
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mPullView != null) {
            this.mPullView.iV(i);
        }
        this.fyy.getBaseFragmentActivity().getLayoutMode().setNightMode(i == 1);
        this.fyy.getBaseFragmentActivity().getLayoutMode().onModeChanged(this.cWd);
        if (this.dnG != null) {
            this.dnG.setTextColor(am.getColor(R.color.cp_cont_j));
            this.dnG.iV(i);
        }
        am.l(this.dpi, R.color.cp_bg_line_e);
        if (this.fyJ != null) {
            this.fyJ.notifyDataSetChanged();
        }
    }

    public void onDestroy() {
        this.fyJ.onDestory();
        this.fvT.setOnSrollToBottomListener(null);
    }
}
