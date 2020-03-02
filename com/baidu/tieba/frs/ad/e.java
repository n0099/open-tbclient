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
    private FrameLayout cwv;
    private PbListView elj;
    private BdSwipeRefreshLayout ent;
    private BdTypeRecyclerView gql;
    private FrsADFragment gsP;
    private a gta;
    private RelativeLayout mContainer;
    private h mPullView;

    public e(FrsADFragment frsADFragment, View view) {
        this.gsP = frsADFragment;
        bJ(view);
    }

    public a bGe() {
        return this.gta;
    }

    private void bJ(View view) {
        this.mContainer = (RelativeLayout) view.findViewById(R.id.frs_ad_container);
        this.gql = (BdTypeRecyclerView) view.findViewById(R.id.frs_ad_listview);
        this.gql.setLayoutManager(new LinearLayoutManager(this.gql.getContext()));
        this.gql.setFadingEdgeLength(0);
        this.gql.setOverScrollMode(2);
        this.gql.setRecyclerListener(new RecyclerView.RecyclerListener() { // from class: com.baidu.tieba.frs.ad.e.1
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
        this.gql.setOnSrollToBottomListener(this.gsP);
        this.gta = new a(this.gsP, this.gql);
        this.elj = new PbListView(this.gsP.getPageContext().getPageActivity());
        this.elj.createView();
        this.elj.setContainerBackgroundColorResId(R.color.cp_bg_line_e);
        this.elj.setHeight(l.getDimens(this.gsP.getActivity(), R.dimen.tbds182));
        this.elj.setLineGone();
        this.elj.setTextSize(R.dimen.tbfontsize33);
        this.elj.setTextColor(am.getColor(R.color.cp_cont_j));
        this.elj.setNoMoreTextColorId(R.color.cp_cont_e);
        this.mPullView = new h(this.gsP.getPageContext());
        if (this.ent == null) {
            this.ent = (BdSwipeRefreshLayout) view.findViewById(R.id.frs_ad_pull_refresh_layout);
            this.ent.setProgressView(this.mPullView);
            am.setBackgroundColor(this.ent, R.color.cp_bg_line_e);
        }
        this.cwv = (FrameLayout) view.findViewById(R.id.frs_ad_list_content);
        hu(false);
    }

    public void setListPullRefreshListener(g.c cVar) {
        this.mPullView.setListPullRefreshListener(cVar);
    }

    public void hu(boolean z) {
        if (!z) {
            this.ent.setRefreshing(false);
        }
    }

    public BdTypeRecyclerView getListView() {
        return this.gql;
    }

    public RelativeLayout bsE() {
        return this.mContainer;
    }

    public View bGf() {
        return this.ent;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void bdr() {
        this.gql.setNextPage(this.elj);
        this.elj.showEmptyView(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        this.elj.startLoadData();
    }

    public void bds() {
        this.gql.setNextPage(this.elj);
        this.elj.showEmptyView(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        this.elj.endLoadData();
        this.elj.setText(this.gsP.getResources().getString(R.string.list_no_more));
    }

    public void bdt() {
        this.gql.setNextPage(null);
    }

    public void lF(boolean z) {
        this.cwv.setVisibility(z ? 0 : 8);
    }

    public void startPullRefresh() {
        this.ent.setRefreshing(true);
    }

    public void bET() {
        if (this.gta != null) {
            this.gta.notifyDataSetChanged();
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mPullView != null) {
            this.mPullView.changeSkin(i);
        }
        this.gsP.getBaseFragmentActivity().getLayoutMode().setNightMode(i == 1);
        this.gsP.getBaseFragmentActivity().getLayoutMode().onModeChanged(this.mContainer);
        if (this.elj != null) {
            this.elj.setTextColor(am.getColor(R.color.cp_cont_j));
            this.elj.changeSkin(i);
        }
        am.setBackgroundColor(this.ent, R.color.cp_bg_line_e);
        if (this.gta != null) {
            this.gta.notifyDataSetChanged();
        }
    }

    public void onDestroy() {
        this.gta.onDestory();
        this.gql.setOnSrollToBottomListener(null);
    }

    public void setOnScrollListener(RecyclerView.OnScrollListener onScrollListener) {
        this.gql.setOnScrollListener(onScrollListener);
    }
}
