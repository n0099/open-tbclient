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
    private FrameLayout bGR;
    private PbListView dvS;
    private BdSwipeRefreshLayout dxt;
    private BdTypeRecyclerView fwC;
    private FrsADFragment fzh;
    private a fzs;
    private RelativeLayout mContainer;
    private i mPullView;

    public e(FrsADFragment frsADFragment, View view) {
        this.fzh = frsADFragment;
        bJ(view);
    }

    public a bmb() {
        return this.fzs;
    }

    private void bJ(View view) {
        this.mContainer = (RelativeLayout) view.findViewById(R.id.frs_ad_container);
        this.fwC = (BdTypeRecyclerView) view.findViewById(R.id.frs_ad_listview);
        this.fwC.setLayoutManager(new LinearLayoutManager(this.fwC.getContext()));
        this.fwC.setFadingEdgeLength(0);
        this.fwC.setOverScrollMode(2);
        this.fwC.setRecyclerListener(new RecyclerView.RecyclerListener() { // from class: com.baidu.tieba.frs.ad.e.1
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
        this.fwC.setOnSrollToBottomListener(this.fzh);
        this.fzs = new a(this.fzh, this.fwC);
        this.dvS = new PbListView(this.fzh.getPageContext().getPageActivity());
        this.dvS.createView();
        this.dvS.setContainerBackgroundColorResId(R.color.cp_bg_line_e);
        this.dvS.setHeight(l.getDimens(this.fzh.getActivity(), R.dimen.tbds182));
        this.dvS.setLineGone();
        this.dvS.setTextSize(R.dimen.tbfontsize33);
        this.dvS.setTextColor(am.getColor(R.color.cp_cont_j));
        this.dvS.setNoMoreTextColorId(R.color.cp_cont_e);
        this.mPullView = new i(this.fzh.getPageContext());
        if (this.dxt == null) {
            this.dxt = (BdSwipeRefreshLayout) view.findViewById(R.id.frs_ad_pull_refresh_layout);
            this.dxt.setProgressView(this.mPullView);
            am.setBackgroundColor(this.dxt, R.color.cp_bg_line_e);
        }
        this.bGR = (FrameLayout) view.findViewById(R.id.frs_ad_list_content);
        fU(false);
    }

    public void setListPullRefreshListener(h.c cVar) {
        this.mPullView.setListPullRefreshListener(cVar);
    }

    public void fU(boolean z) {
        if (!z) {
            this.dxt.setRefreshing(false);
        }
    }

    public BdTypeRecyclerView getListView() {
        return this.fwC;
    }

    public RelativeLayout aYb() {
        return this.mContainer;
    }

    public View bmc() {
        return this.dxt;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void aKg() {
        this.fwC.setNextPage(this.dvS);
        this.dvS.showEmptyView(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        this.dvS.startLoadData();
    }

    public void aKh() {
        this.fwC.setNextPage(this.dvS);
        this.dvS.showEmptyView(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        this.dvS.endLoadData();
        this.dvS.setText(this.fzh.getResources().getString(R.string.list_no_more));
    }

    public void aKi() {
        this.fwC.setNextPage(null);
    }

    public void kf(boolean z) {
        this.bGR.setVisibility(z ? 0 : 8);
    }

    public void startPullRefresh() {
        this.dxt.setRefreshing(true);
    }

    public void bkQ() {
        if (this.fzs != null) {
            this.fzs.notifyDataSetChanged();
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mPullView != null) {
            this.mPullView.changeSkin(i);
        }
        this.fzh.getBaseFragmentActivity().getLayoutMode().setNightMode(i == 1);
        this.fzh.getBaseFragmentActivity().getLayoutMode().onModeChanged(this.mContainer);
        if (this.dvS != null) {
            this.dvS.setTextColor(am.getColor(R.color.cp_cont_j));
            this.dvS.changeSkin(i);
        }
        am.setBackgroundColor(this.dxt, R.color.cp_bg_line_e);
        if (this.fzs != null) {
            this.fzs.notifyDataSetChanged();
        }
    }

    public void onDestroy() {
        this.fzs.onDestory();
        this.fwC.setOnSrollToBottomListener(null);
    }
}
