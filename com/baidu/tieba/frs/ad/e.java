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
    private FrameLayout bHI;
    private PbListView dwJ;
    private BdSwipeRefreshLayout dyk;
    private a fAj;
    private BdTypeRecyclerView fxt;
    private FrsADFragment fzY;
    private RelativeLayout mContainer;
    private i mPullView;

    public e(FrsADFragment frsADFragment, View view) {
        this.fzY = frsADFragment;
        bJ(view);
    }

    public a bmd() {
        return this.fAj;
    }

    private void bJ(View view) {
        this.mContainer = (RelativeLayout) view.findViewById(R.id.frs_ad_container);
        this.fxt = (BdTypeRecyclerView) view.findViewById(R.id.frs_ad_listview);
        this.fxt.setLayoutManager(new LinearLayoutManager(this.fxt.getContext()));
        this.fxt.setFadingEdgeLength(0);
        this.fxt.setOverScrollMode(2);
        this.fxt.setRecyclerListener(new RecyclerView.RecyclerListener() { // from class: com.baidu.tieba.frs.ad.e.1
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
        this.fxt.setOnSrollToBottomListener(this.fzY);
        this.fAj = new a(this.fzY, this.fxt);
        this.dwJ = new PbListView(this.fzY.getPageContext().getPageActivity());
        this.dwJ.createView();
        this.dwJ.setContainerBackgroundColorResId(R.color.cp_bg_line_e);
        this.dwJ.setHeight(l.getDimens(this.fzY.getActivity(), R.dimen.tbds182));
        this.dwJ.setLineGone();
        this.dwJ.setTextSize(R.dimen.tbfontsize33);
        this.dwJ.setTextColor(am.getColor(R.color.cp_cont_j));
        this.dwJ.setNoMoreTextColorId(R.color.cp_cont_e);
        this.mPullView = new i(this.fzY.getPageContext());
        if (this.dyk == null) {
            this.dyk = (BdSwipeRefreshLayout) view.findViewById(R.id.frs_ad_pull_refresh_layout);
            this.dyk.setProgressView(this.mPullView);
            am.setBackgroundColor(this.dyk, R.color.cp_bg_line_e);
        }
        this.bHI = (FrameLayout) view.findViewById(R.id.frs_ad_list_content);
        fU(false);
    }

    public void setListPullRefreshListener(h.c cVar) {
        this.mPullView.setListPullRefreshListener(cVar);
    }

    public void fU(boolean z) {
        if (!z) {
            this.dyk.setRefreshing(false);
        }
    }

    public BdTypeRecyclerView getListView() {
        return this.fxt;
    }

    public RelativeLayout aYd() {
        return this.mContainer;
    }

    public View bme() {
        return this.dyk;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void aKi() {
        this.fxt.setNextPage(this.dwJ);
        this.dwJ.showEmptyView(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        this.dwJ.startLoadData();
    }

    public void aKj() {
        this.fxt.setNextPage(this.dwJ);
        this.dwJ.showEmptyView(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        this.dwJ.endLoadData();
        this.dwJ.setText(this.fzY.getResources().getString(R.string.list_no_more));
    }

    public void aKk() {
        this.fxt.setNextPage(null);
    }

    public void kf(boolean z) {
        this.bHI.setVisibility(z ? 0 : 8);
    }

    public void startPullRefresh() {
        this.dyk.setRefreshing(true);
    }

    public void bkS() {
        if (this.fAj != null) {
            this.fAj.notifyDataSetChanged();
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mPullView != null) {
            this.mPullView.changeSkin(i);
        }
        this.fzY.getBaseFragmentActivity().getLayoutMode().setNightMode(i == 1);
        this.fzY.getBaseFragmentActivity().getLayoutMode().onModeChanged(this.mContainer);
        if (this.dwJ != null) {
            this.dwJ.setTextColor(am.getColor(R.color.cp_cont_j));
            this.dwJ.changeSkin(i);
        }
        am.setBackgroundColor(this.dyk, R.color.cp_bg_line_e);
        if (this.fAj != null) {
            this.fAj.notifyDataSetChanged();
        }
    }

    public void onDestroy() {
        this.fAj.onDestory();
        this.fxt.setOnSrollToBottomListener(null);
    }
}
