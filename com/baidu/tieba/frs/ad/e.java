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
    private FrameLayout cww;
    private PbListView elw;
    private BdSwipeRefreshLayout enH;
    private BdTypeRecyclerView gqy;
    private FrsADFragment gtc;
    private a gtn;
    private RelativeLayout mContainer;
    private h mPullView;

    public e(FrsADFragment frsADFragment, View view) {
        this.gtc = frsADFragment;
        bJ(view);
    }

    public a bGf() {
        return this.gtn;
    }

    private void bJ(View view) {
        this.mContainer = (RelativeLayout) view.findViewById(R.id.frs_ad_container);
        this.gqy = (BdTypeRecyclerView) view.findViewById(R.id.frs_ad_listview);
        this.gqy.setLayoutManager(new LinearLayoutManager(this.gqy.getContext()));
        this.gqy.setFadingEdgeLength(0);
        this.gqy.setOverScrollMode(2);
        this.gqy.setRecyclerListener(new RecyclerView.RecyclerListener() { // from class: com.baidu.tieba.frs.ad.e.1
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
        this.gqy.setOnSrollToBottomListener(this.gtc);
        this.gtn = new a(this.gtc, this.gqy);
        this.elw = new PbListView(this.gtc.getPageContext().getPageActivity());
        this.elw.createView();
        this.elw.setContainerBackgroundColorResId(R.color.cp_bg_line_e);
        this.elw.setHeight(l.getDimens(this.gtc.getActivity(), R.dimen.tbds182));
        this.elw.setLineGone();
        this.elw.setTextSize(R.dimen.tbfontsize33);
        this.elw.setTextColor(am.getColor(R.color.cp_cont_j));
        this.elw.setNoMoreTextColorId(R.color.cp_cont_e);
        this.mPullView = new h(this.gtc.getPageContext());
        if (this.enH == null) {
            this.enH = (BdSwipeRefreshLayout) view.findViewById(R.id.frs_ad_pull_refresh_layout);
            this.enH.setProgressView(this.mPullView);
            am.setBackgroundColor(this.enH, R.color.cp_bg_line_e);
        }
        this.cww = (FrameLayout) view.findViewById(R.id.frs_ad_list_content);
        hu(false);
    }

    public void setListPullRefreshListener(g.c cVar) {
        this.mPullView.setListPullRefreshListener(cVar);
    }

    public void hu(boolean z) {
        if (!z) {
            this.enH.setRefreshing(false);
        }
    }

    public BdTypeRecyclerView getListView() {
        return this.gqy;
    }

    public RelativeLayout bsF() {
        return this.mContainer;
    }

    public View bGg() {
        return this.enH;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void bds() {
        this.gqy.setNextPage(this.elw);
        this.elw.showEmptyView(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        this.elw.startLoadData();
    }

    public void bdt() {
        this.gqy.setNextPage(this.elw);
        this.elw.showEmptyView(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        this.elw.endLoadData();
        this.elw.setText(this.gtc.getResources().getString(R.string.list_no_more));
    }

    public void bdu() {
        this.gqy.setNextPage(null);
    }

    public void lF(boolean z) {
        this.cww.setVisibility(z ? 0 : 8);
    }

    public void startPullRefresh() {
        this.enH.setRefreshing(true);
    }

    public void bEU() {
        if (this.gtn != null) {
            this.gtn.notifyDataSetChanged();
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mPullView != null) {
            this.mPullView.changeSkin(i);
        }
        this.gtc.getBaseFragmentActivity().getLayoutMode().setNightMode(i == 1);
        this.gtc.getBaseFragmentActivity().getLayoutMode().onModeChanged(this.mContainer);
        if (this.elw != null) {
            this.elw.setTextColor(am.getColor(R.color.cp_cont_j));
            this.elw.changeSkin(i);
        }
        am.setBackgroundColor(this.enH, R.color.cp_bg_line_e);
        if (this.gtn != null) {
            this.gtn.notifyDataSetChanged();
        }
    }

    public void onDestroy() {
        this.gtn.onDestory();
        this.gqy.setOnSrollToBottomListener(null);
    }

    public void setOnScrollListener(RecyclerView.OnScrollListener onScrollListener) {
        this.gqy.setOnScrollListener(onScrollListener);
    }
}
