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
/* loaded from: classes7.dex */
public class e {
    private FrameLayout css;
    private PbListView ehe;
    private BdSwipeRefreshLayout ejj;
    private BdTypeRecyclerView goi;
    private FrsADFragment gqM;
    private a gqX;
    private RelativeLayout mContainer;
    private h mPullView;

    public e(FrsADFragment frsADFragment, View view) {
        this.gqM = frsADFragment;
        bJ(view);
    }

    public a bEA() {
        return this.gqX;
    }

    private void bJ(View view) {
        this.mContainer = (RelativeLayout) view.findViewById(R.id.frs_ad_container);
        this.goi = (BdTypeRecyclerView) view.findViewById(R.id.frs_ad_listview);
        this.goi.setLayoutManager(new LinearLayoutManager(this.goi.getContext()));
        this.goi.setFadingEdgeLength(0);
        this.goi.setOverScrollMode(2);
        this.goi.setRecyclerListener(new RecyclerView.RecyclerListener() { // from class: com.baidu.tieba.frs.ad.e.1
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
        this.goi.setOnSrollToBottomListener(this.gqM);
        this.gqX = new a(this.gqM, this.goi);
        this.ehe = new PbListView(this.gqM.getPageContext().getPageActivity());
        this.ehe.createView();
        this.ehe.setContainerBackgroundColorResId(R.color.cp_bg_line_e);
        this.ehe.setHeight(l.getDimens(this.gqM.getActivity(), R.dimen.tbds182));
        this.ehe.setLineGone();
        this.ehe.setTextSize(R.dimen.tbfontsize33);
        this.ehe.setTextColor(am.getColor(R.color.cp_cont_j));
        this.ehe.setNoMoreTextColorId(R.color.cp_cont_e);
        this.mPullView = new h(this.gqM.getPageContext());
        if (this.ejj == null) {
            this.ejj = (BdSwipeRefreshLayout) view.findViewById(R.id.frs_ad_pull_refresh_layout);
            this.ejj.setProgressView(this.mPullView);
            am.setBackgroundColor(this.ejj, R.color.cp_bg_line_e);
        }
        this.css = (FrameLayout) view.findViewById(R.id.frs_ad_list_content);
        hn(false);
    }

    public void setListPullRefreshListener(g.c cVar) {
        this.mPullView.setListPullRefreshListener(cVar);
    }

    public void hn(boolean z) {
        if (!z) {
            this.ejj.setRefreshing(false);
        }
    }

    public BdTypeRecyclerView getListView() {
        return this.goi;
    }

    public RelativeLayout bqY() {
        return this.mContainer;
    }

    public View bEB() {
        return this.ejj;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void bba() {
        this.goi.setNextPage(this.ehe);
        this.ehe.showEmptyView(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        this.ehe.startLoadData();
    }

    public void bbb() {
        this.goi.setNextPage(this.ehe);
        this.ehe.showEmptyView(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        this.ehe.endLoadData();
        this.ehe.setText(this.gqM.getResources().getString(R.string.list_no_more));
    }

    public void bbc() {
        this.goi.setNextPage(null);
    }

    public void lC(boolean z) {
        this.css.setVisibility(z ? 0 : 8);
    }

    public void startPullRefresh() {
        this.ejj.setRefreshing(true);
    }

    public void bDo() {
        if (this.gqX != null) {
            this.gqX.notifyDataSetChanged();
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mPullView != null) {
            this.mPullView.changeSkin(i);
        }
        this.gqM.getBaseFragmentActivity().getLayoutMode().setNightMode(i == 1);
        this.gqM.getBaseFragmentActivity().getLayoutMode().onModeChanged(this.mContainer);
        if (this.ehe != null) {
            this.ehe.setTextColor(am.getColor(R.color.cp_cont_j));
            this.ehe.changeSkin(i);
        }
        am.setBackgroundColor(this.ejj, R.color.cp_bg_line_e);
        if (this.gqX != null) {
            this.gqX.notifyDataSetChanged();
        }
    }

    public void onDestroy() {
        this.gqX.onDestory();
        this.goi.setOnSrollToBottomListener(null);
    }

    public void setOnScrollListener(RecyclerView.OnScrollListener onScrollListener) {
        this.goi.setOnScrollListener(onScrollListener);
    }
}
