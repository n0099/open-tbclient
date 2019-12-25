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
/* loaded from: classes6.dex */
public class e {
    private FrameLayout csh;
    private PbListView egU;
    private BdSwipeRefreshLayout eiv;
    private BdTypeRecyclerView gkZ;
    private FrsADFragment gnD;
    private a gnO;
    private RelativeLayout mContainer;
    private h mPullView;

    public e(FrsADFragment frsADFragment, View view) {
        this.gnD = frsADFragment;
        bE(view);
    }

    public a bDy() {
        return this.gnO;
    }

    private void bE(View view) {
        this.mContainer = (RelativeLayout) view.findViewById(R.id.frs_ad_container);
        this.gkZ = (BdTypeRecyclerView) view.findViewById(R.id.frs_ad_listview);
        this.gkZ.setLayoutManager(new LinearLayoutManager(this.gkZ.getContext()));
        this.gkZ.setFadingEdgeLength(0);
        this.gkZ.setOverScrollMode(2);
        this.gkZ.setRecyclerListener(new RecyclerView.RecyclerListener() { // from class: com.baidu.tieba.frs.ad.e.1
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
        this.gkZ.setOnSrollToBottomListener(this.gnD);
        this.gnO = new a(this.gnD, this.gkZ);
        this.egU = new PbListView(this.gnD.getPageContext().getPageActivity());
        this.egU.createView();
        this.egU.setContainerBackgroundColorResId(R.color.cp_bg_line_e);
        this.egU.setHeight(l.getDimens(this.gnD.getActivity(), R.dimen.tbds182));
        this.egU.setLineGone();
        this.egU.setTextSize(R.dimen.tbfontsize33);
        this.egU.setTextColor(am.getColor(R.color.cp_cont_j));
        this.egU.setNoMoreTextColorId(R.color.cp_cont_e);
        this.mPullView = new h(this.gnD.getPageContext());
        if (this.eiv == null) {
            this.eiv = (BdSwipeRefreshLayout) view.findViewById(R.id.frs_ad_pull_refresh_layout);
            this.eiv.setProgressView(this.mPullView);
            am.setBackgroundColor(this.eiv, R.color.cp_bg_line_e);
        }
        this.csh = (FrameLayout) view.findViewById(R.id.frs_ad_list_content);
        hi(false);
    }

    public void setListPullRefreshListener(g.c cVar) {
        this.mPullView.setListPullRefreshListener(cVar);
    }

    public void hi(boolean z) {
        if (!z) {
            this.eiv.setRefreshing(false);
        }
    }

    public BdTypeRecyclerView getListView() {
        return this.gkZ;
    }

    public RelativeLayout bpX() {
        return this.mContainer;
    }

    public View bDz() {
        return this.eiv;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void baF() {
        this.gkZ.setNextPage(this.egU);
        this.egU.showEmptyView(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        this.egU.startLoadData();
    }

    public void baG() {
        this.gkZ.setNextPage(this.egU);
        this.egU.showEmptyView(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        this.egU.endLoadData();
        this.egU.setText(this.gnD.getResources().getString(R.string.list_no_more));
    }

    public void baH() {
        this.gkZ.setNextPage(null);
    }

    public void lr(boolean z) {
        this.csh.setVisibility(z ? 0 : 8);
    }

    public void startPullRefresh() {
        this.eiv.setRefreshing(true);
    }

    public void bCm() {
        if (this.gnO != null) {
            this.gnO.notifyDataSetChanged();
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mPullView != null) {
            this.mPullView.changeSkin(i);
        }
        this.gnD.getBaseFragmentActivity().getLayoutMode().setNightMode(i == 1);
        this.gnD.getBaseFragmentActivity().getLayoutMode().onModeChanged(this.mContainer);
        if (this.egU != null) {
            this.egU.setTextColor(am.getColor(R.color.cp_cont_j));
            this.egU.changeSkin(i);
        }
        am.setBackgroundColor(this.eiv, R.color.cp_bg_line_e);
        if (this.gnO != null) {
            this.gnO.notifyDataSetChanged();
        }
    }

    public void onDestroy() {
        this.gnO.onDestory();
        this.gkZ.setOnSrollToBottomListener(null);
    }

    public void setOnScrollListener(RecyclerView.OnScrollListener onScrollListener) {
        this.gkZ.setOnScrollListener(onScrollListener);
    }
}
