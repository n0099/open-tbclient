package com.baidu.tieba.frs.ad;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.l;
import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.view.PbListView;
import com.baidu.tbadk.core.view.UserPhotoLayout;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.ad;
import com.baidu.tieba.frs.v;
import com.baidu.tieba.tbadkCore.FrsCommonImageLayout;
import com.baidu.tieba.tbadkCore.voice.PlayVoiceBnt;
/* loaded from: classes16.dex */
public class e {
    private FrameLayout dBv;
    private PbListView fEa;
    private BdTypeRecyclerView hVD;
    private FrsADFragment hYV;
    private a hZg;
    private RelativeLayout mContainer;

    public e(FrsADFragment frsADFragment, View view) {
        this.hYV = frsADFragment;
        ca(view);
    }

    public a coE() {
        return this.hZg;
    }

    private void ca(View view) {
        this.mContainer = (RelativeLayout) view.findViewById(R.id.frs_ad_container);
        this.hVD = (BdTypeRecyclerView) view.findViewById(R.id.frs_ad_listview);
        this.hVD.setLayoutManager(new LinearLayoutManager(this.hVD.getContext()));
        this.hVD.setFadingEdgeLength(0);
        this.hVD.setOverScrollMode(2);
        this.hVD.setRecyclerListener(new RecyclerView.RecyclerListener() { // from class: com.baidu.tieba.frs.ad.e.1
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
        this.hVD.setOnSrollToBottomListener(this.hYV);
        this.hZg = new a(this.hYV, this.hVD);
        this.fEa = new PbListView(this.hYV.getPageContext().getPageActivity());
        this.fEa.createView();
        this.fEa.setContainerBackgroundColorResId(R.color.cp_bg_line_e);
        this.fEa.setHeight(l.getDimens(this.hYV.getActivity(), R.dimen.tbds182));
        this.fEa.setLineGone();
        this.fEa.setTextSize(R.dimen.tbfontsize33);
        this.fEa.setTextColor(ap.getColor(R.color.cp_cont_j));
        this.fEa.setNoMoreTextColorId(R.color.cp_cont_e);
        this.dBv = (FrameLayout) view.findViewById(R.id.frs_ad_list_content);
        kh(false);
    }

    public void kh(boolean z) {
        if (!z) {
            v vVar = new v();
            vVar.tabId = 90;
            vVar.fkC = false;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921449, vVar));
        }
    }

    public void coF() {
        v vVar = new v();
        vVar.tabId = 90;
        vVar.fkC = false;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921449, vVar));
    }

    public BdTypeRecyclerView getListView() {
        return this.hVD;
    }

    public RelativeLayout bZc() {
        return this.mContainer;
    }

    public void oE(boolean z) {
        ad adVar = new ad();
        adVar.tabId = 90;
        adVar.esz = z;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(9205410, adVar));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void bGS() {
        this.hVD.setNextPage(this.fEa);
        this.fEa.showEmptyView(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        this.fEa.startLoadData();
    }

    public void bGT() {
        this.hVD.setNextPage(this.fEa);
        this.fEa.showEmptyView(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        this.fEa.endLoadData();
        this.fEa.setText(this.hYV.getResources().getString(R.string.list_no_more));
    }

    public void bGU() {
        this.hVD.setNextPage(null);
    }

    public void oF(boolean z) {
        this.dBv.setVisibility(z ? 0 : 8);
    }

    public void startPullRefresh() {
        v vVar = new v();
        vVar.tabId = 90;
        vVar.fkC = true;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921449, vVar));
    }

    public void cnf() {
        if (this.hZg != null) {
            this.hZg.notifyDataSetChanged();
        }
    }

    public void onChangeSkinType(int i) {
        this.hYV.getBaseFragmentActivity().getLayoutMode().setNightMode(i == 1);
        this.hYV.getBaseFragmentActivity().getLayoutMode().onModeChanged(this.mContainer);
        if (this.fEa != null) {
            this.fEa.setTextColor(ap.getColor(R.color.cp_cont_j));
            this.fEa.changeSkin(i);
        }
        if (this.hZg != null) {
            this.hZg.notifyDataSetChanged();
        }
    }

    public void onDestroy() {
        this.hZg.onDestory();
        this.hVD.setOnSrollToBottomListener(null);
    }

    public void setOnScrollListener(RecyclerView.OnScrollListener onScrollListener) {
        this.hVD.setOnScrollListener(onScrollListener);
    }
}
