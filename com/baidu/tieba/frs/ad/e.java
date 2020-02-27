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
    private FrameLayout cwu;
    private PbListView eli;
    private BdSwipeRefreshLayout ens;
    private BdTypeRecyclerView gqj;
    private FrsADFragment gsN;
    private a gsY;
    private RelativeLayout mContainer;
    private h mPullView;

    public e(FrsADFragment frsADFragment, View view) {
        this.gsN = frsADFragment;
        bJ(view);
    }

    public a bGc() {
        return this.gsY;
    }

    private void bJ(View view) {
        this.mContainer = (RelativeLayout) view.findViewById(R.id.frs_ad_container);
        this.gqj = (BdTypeRecyclerView) view.findViewById(R.id.frs_ad_listview);
        this.gqj.setLayoutManager(new LinearLayoutManager(this.gqj.getContext()));
        this.gqj.setFadingEdgeLength(0);
        this.gqj.setOverScrollMode(2);
        this.gqj.setRecyclerListener(new RecyclerView.RecyclerListener() { // from class: com.baidu.tieba.frs.ad.e.1
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
        this.gqj.setOnSrollToBottomListener(this.gsN);
        this.gsY = new a(this.gsN, this.gqj);
        this.eli = new PbListView(this.gsN.getPageContext().getPageActivity());
        this.eli.createView();
        this.eli.setContainerBackgroundColorResId(R.color.cp_bg_line_e);
        this.eli.setHeight(l.getDimens(this.gsN.getActivity(), R.dimen.tbds182));
        this.eli.setLineGone();
        this.eli.setTextSize(R.dimen.tbfontsize33);
        this.eli.setTextColor(am.getColor(R.color.cp_cont_j));
        this.eli.setNoMoreTextColorId(R.color.cp_cont_e);
        this.mPullView = new h(this.gsN.getPageContext());
        if (this.ens == null) {
            this.ens = (BdSwipeRefreshLayout) view.findViewById(R.id.frs_ad_pull_refresh_layout);
            this.ens.setProgressView(this.mPullView);
            am.setBackgroundColor(this.ens, R.color.cp_bg_line_e);
        }
        this.cwu = (FrameLayout) view.findViewById(R.id.frs_ad_list_content);
        hu(false);
    }

    public void setListPullRefreshListener(g.c cVar) {
        this.mPullView.setListPullRefreshListener(cVar);
    }

    public void hu(boolean z) {
        if (!z) {
            this.ens.setRefreshing(false);
        }
    }

    public BdTypeRecyclerView getListView() {
        return this.gqj;
    }

    public RelativeLayout bsC() {
        return this.mContainer;
    }

    public View bGd() {
        return this.ens;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void bdp() {
        this.gqj.setNextPage(this.eli);
        this.eli.showEmptyView(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        this.eli.startLoadData();
    }

    public void bdq() {
        this.gqj.setNextPage(this.eli);
        this.eli.showEmptyView(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        this.eli.endLoadData();
        this.eli.setText(this.gsN.getResources().getString(R.string.list_no_more));
    }

    public void bdr() {
        this.gqj.setNextPage(null);
    }

    public void lF(boolean z) {
        this.cwu.setVisibility(z ? 0 : 8);
    }

    public void startPullRefresh() {
        this.ens.setRefreshing(true);
    }

    public void bER() {
        if (this.gsY != null) {
            this.gsY.notifyDataSetChanged();
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mPullView != null) {
            this.mPullView.changeSkin(i);
        }
        this.gsN.getBaseFragmentActivity().getLayoutMode().setNightMode(i == 1);
        this.gsN.getBaseFragmentActivity().getLayoutMode().onModeChanged(this.mContainer);
        if (this.eli != null) {
            this.eli.setTextColor(am.getColor(R.color.cp_cont_j));
            this.eli.changeSkin(i);
        }
        am.setBackgroundColor(this.ens, R.color.cp_bg_line_e);
        if (this.gsY != null) {
            this.gsY.notifyDataSetChanged();
        }
    }

    public void onDestroy() {
        this.gsY.onDestory();
        this.gqj.setOnSrollToBottomListener(null);
    }

    public void setOnScrollListener(RecyclerView.OnScrollListener onScrollListener) {
        this.gqj.setOnScrollListener(onScrollListener);
    }
}
