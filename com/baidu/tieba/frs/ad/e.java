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
    private FrameLayout dBr;
    private PbListView fDW;
    private BdTypeRecyclerView hVx;
    private FrsADFragment hYP;
    private a hZa;
    private RelativeLayout mContainer;

    public e(FrsADFragment frsADFragment, View view) {
        this.hYP = frsADFragment;
        ca(view);
    }

    public a coD() {
        return this.hZa;
    }

    private void ca(View view) {
        this.mContainer = (RelativeLayout) view.findViewById(R.id.frs_ad_container);
        this.hVx = (BdTypeRecyclerView) view.findViewById(R.id.frs_ad_listview);
        this.hVx.setLayoutManager(new LinearLayoutManager(this.hVx.getContext()));
        this.hVx.setFadingEdgeLength(0);
        this.hVx.setOverScrollMode(2);
        this.hVx.setRecyclerListener(new RecyclerView.RecyclerListener() { // from class: com.baidu.tieba.frs.ad.e.1
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
        this.hVx.setOnSrollToBottomListener(this.hYP);
        this.hZa = new a(this.hYP, this.hVx);
        this.fDW = new PbListView(this.hYP.getPageContext().getPageActivity());
        this.fDW.createView();
        this.fDW.setContainerBackgroundColorResId(R.color.cp_bg_line_e);
        this.fDW.setHeight(l.getDimens(this.hYP.getActivity(), R.dimen.tbds182));
        this.fDW.setLineGone();
        this.fDW.setTextSize(R.dimen.tbfontsize33);
        this.fDW.setTextColor(ap.getColor(R.color.cp_cont_j));
        this.fDW.setNoMoreTextColorId(R.color.cp_cont_e);
        this.dBr = (FrameLayout) view.findViewById(R.id.frs_ad_list_content);
        kf(false);
    }

    public void kf(boolean z) {
        if (!z) {
            v vVar = new v();
            vVar.tabId = 90;
            vVar.fky = false;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921449, vVar));
        }
    }

    public void coE() {
        v vVar = new v();
        vVar.tabId = 90;
        vVar.fky = false;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921449, vVar));
    }

    public BdTypeRecyclerView getListView() {
        return this.hVx;
    }

    public RelativeLayout bZb() {
        return this.mContainer;
    }

    public void oC(boolean z) {
        ad adVar = new ad();
        adVar.tabId = 90;
        adVar.esv = z;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(9205410, adVar));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void bGR() {
        this.hVx.setNextPage(this.fDW);
        this.fDW.showEmptyView(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        this.fDW.startLoadData();
    }

    public void bGS() {
        this.hVx.setNextPage(this.fDW);
        this.fDW.showEmptyView(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        this.fDW.endLoadData();
        this.fDW.setText(this.hYP.getResources().getString(R.string.list_no_more));
    }

    public void bGT() {
        this.hVx.setNextPage(null);
    }

    public void oD(boolean z) {
        this.dBr.setVisibility(z ? 0 : 8);
    }

    public void startPullRefresh() {
        v vVar = new v();
        vVar.tabId = 90;
        vVar.fky = true;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921449, vVar));
    }

    public void cne() {
        if (this.hZa != null) {
            this.hZa.notifyDataSetChanged();
        }
    }

    public void onChangeSkinType(int i) {
        this.hYP.getBaseFragmentActivity().getLayoutMode().setNightMode(i == 1);
        this.hYP.getBaseFragmentActivity().getLayoutMode().onModeChanged(this.mContainer);
        if (this.fDW != null) {
            this.fDW.setTextColor(ap.getColor(R.color.cp_cont_j));
            this.fDW.changeSkin(i);
        }
        if (this.hZa != null) {
            this.hZa.notifyDataSetChanged();
        }
    }

    public void onDestroy() {
        this.hZa.onDestory();
        this.hVx.setOnSrollToBottomListener(null);
    }

    public void setOnScrollListener(RecyclerView.OnScrollListener onScrollListener) {
        this.hVx.setOnScrollListener(onScrollListener);
    }
}
