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
import com.baidu.tbadk.core.view.g;
import com.baidu.tbadk.core.view.h;
import com.baidu.tieba.R;
import com.baidu.tieba.tbadkCore.FrsCommonImageLayout;
import com.baidu.tieba.tbadkCore.voice.PlayVoiceBnt;
/* loaded from: classes9.dex */
public class e {
    private FrameLayout cwH;
    private PbListView elM;
    private BdSwipeRefreshLayout enY;
    private BdTypeRecyclerView gri;
    private FrsADFragment gtG;
    private a gtR;
    private RelativeLayout mContainer;
    private h mPullView;

    public e(FrsADFragment frsADFragment, View view) {
        this.gtG = frsADFragment;
        bJ(view);
    }

    public a bGq() {
        return this.gtR;
    }

    private void bJ(View view) {
        this.mContainer = (RelativeLayout) view.findViewById(R.id.frs_ad_container);
        this.gri = (BdTypeRecyclerView) view.findViewById(R.id.frs_ad_listview);
        this.gri.setLayoutManager(new LinearLayoutManager(this.gri.getContext()));
        this.gri.setFadingEdgeLength(0);
        this.gri.setOverScrollMode(2);
        this.gri.setRecyclerListener(new RecyclerView.RecyclerListener() { // from class: com.baidu.tieba.frs.ad.e.1
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
        this.gri.setOnSrollToBottomListener(this.gtG);
        this.gtR = new a(this.gtG, this.gri);
        this.elM = new PbListView(this.gtG.getPageContext().getPageActivity());
        this.elM.createView();
        this.elM.setContainerBackgroundColorResId(R.color.cp_bg_line_e);
        this.elM.setHeight(l.getDimens(this.gtG.getActivity(), R.dimen.tbds182));
        this.elM.setLineGone();
        this.elM.setTextSize(R.dimen.tbfontsize33);
        this.elM.setTextColor(am.getColor(R.color.cp_cont_j));
        this.elM.setNoMoreTextColorId(R.color.cp_cont_e);
        this.mPullView = new h(this.gtG.getPageContext());
        if (this.enY == null) {
            this.enY = (BdSwipeRefreshLayout) view.findViewById(R.id.frs_ad_pull_refresh_layout);
            this.enY.setProgressView(this.mPullView);
            am.setBackgroundColor(this.enY, R.color.cp_bg_line_e);
        }
        this.cwH = (FrameLayout) view.findViewById(R.id.frs_ad_list_content);
        hv(false);
    }

    public void setListPullRefreshListener(g.c cVar) {
        this.mPullView.setListPullRefreshListener(cVar);
    }

    public void hv(boolean z) {
        if (!z) {
            this.enY.setRefreshing(false);
        }
    }

    public void bGr() {
        if (this.enY != null) {
            this.enY.interruptRefresh();
        }
    }

    public BdTypeRecyclerView getListView() {
        return this.gri;
    }

    public RelativeLayout bsL() {
        return this.mContainer;
    }

    public View bGs() {
        return this.enY;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void bdx() {
        this.gri.setNextPage(this.elM);
        this.elM.showEmptyView(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        this.elM.startLoadData();
    }

    public void bdy() {
        this.gri.setNextPage(this.elM);
        this.elM.showEmptyView(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        this.elM.endLoadData();
        this.elM.setText(this.gtG.getResources().getString(R.string.list_no_more));
    }

    public void bdz() {
        this.gri.setNextPage(null);
    }

    public void lK(boolean z) {
        this.cwH.setVisibility(z ? 0 : 8);
    }

    public void startPullRefresh() {
        this.enY.setRefreshing(true);
    }

    public void bFe() {
        if (this.gtR != null) {
            this.gtR.notifyDataSetChanged();
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mPullView != null) {
            this.mPullView.changeSkin(i);
        }
        this.gtG.getBaseFragmentActivity().getLayoutMode().setNightMode(i == 1);
        this.gtG.getBaseFragmentActivity().getLayoutMode().onModeChanged(this.mContainer);
        if (this.elM != null) {
            this.elM.setTextColor(am.getColor(R.color.cp_cont_j));
            this.elM.changeSkin(i);
        }
        am.setBackgroundColor(this.enY, R.color.cp_bg_line_e);
        if (this.gtR != null) {
            this.gtR.notifyDataSetChanged();
        }
    }

    public void onDestroy() {
        this.gtR.onDestory();
        this.gri.setOnSrollToBottomListener(null);
    }

    public void setOnScrollListener(RecyclerView.OnScrollListener onScrollListener) {
        this.gri.setOnScrollListener(onScrollListener);
    }
}
