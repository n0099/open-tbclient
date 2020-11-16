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
/* loaded from: classes21.dex */
public class e {
    private FrameLayout ecd;
    private PbListView giV;
    private BdTypeRecyclerView iKK;
    private FrsADFragment iOc;
    private a iOn;
    private RelativeLayout mContainer;

    public e(FrsADFragment frsADFragment, View view) {
        this.iOc = frsADFragment;
        cA(view);
    }

    public a cAA() {
        return this.iOn;
    }

    private void cA(View view) {
        this.mContainer = (RelativeLayout) view.findViewById(R.id.frs_ad_container);
        this.iKK = (BdTypeRecyclerView) view.findViewById(R.id.frs_ad_listview);
        this.iKK.setLayoutManager(new LinearLayoutManager(this.iKK.getContext()));
        this.iKK.setFadingEdgeLength(0);
        this.iKK.setOverScrollMode(2);
        this.iKK.setRecyclerListener(new RecyclerView.RecyclerListener() { // from class: com.baidu.tieba.frs.ad.e.1
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
        this.iKK.setOnSrollToBottomListener(this.iOc);
        this.iOn = new a(this.iOc, this.iKK);
        this.giV = new PbListView(this.iOc.getPageContext().getPageActivity());
        this.giV.createView();
        this.giV.setContainerBackgroundColorResId(R.color.CAM_X0205);
        this.giV.setHeight(l.getDimens(this.iOc.getActivity(), R.dimen.tbds182));
        this.giV.setLineGone();
        this.giV.setTextSize(R.dimen.tbfontsize33);
        this.giV.setTextColor(ap.getColor(R.color.CAM_X0107));
        this.giV.setNoMoreTextColorId(R.color.CAM_X0110);
        this.ecd = (FrameLayout) view.findViewById(R.id.frs_ad_list_content);
        ld(false);
    }

    public void ld(boolean z) {
        if (!z) {
            v vVar = new v();
            vVar.tabId = 90;
            vVar.fNx = false;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921449, vVar));
        }
    }

    public void cAB() {
        v vVar = new v();
        vVar.tabId = 90;
        vVar.fNx = false;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921449, vVar));
    }

    public BdTypeRecyclerView getListView() {
        return this.iKK;
    }

    public RelativeLayout cjt() {
        return this.mContainer;
    }

    public void pT(boolean z) {
        ad adVar = new ad();
        adVar.tabId = 90;
        adVar.eUh = z;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(9205410, adVar));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void Vz() {
        this.iKK.setNextPage(this.giV);
        this.giV.showEmptyView(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        this.giV.startLoadData();
    }

    public void VA() {
        this.iKK.setNextPage(this.giV);
        this.giV.showEmptyView(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        this.giV.endLoadData();
        this.giV.setText(this.iOc.getResources().getString(R.string.list_no_more));
    }

    public void bPp() {
        this.iKK.setNextPage(null);
    }

    public void pU(boolean z) {
        this.ecd.setVisibility(z ? 0 : 8);
    }

    public void startPullRefresh() {
        v vVar = new v();
        vVar.tabId = 90;
        vVar.fNx = true;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921449, vVar));
    }

    public void cza() {
        if (this.iOn != null) {
            this.iOn.notifyDataSetChanged();
        }
    }

    public void onChangeSkinType(int i) {
        this.iOc.getBaseFragmentActivity().getLayoutMode().setNightMode(i == 1);
        this.iOc.getBaseFragmentActivity().getLayoutMode().onModeChanged(this.mContainer);
        if (this.giV != null) {
            this.giV.setTextColor(ap.getColor(R.color.CAM_X0107));
            this.giV.changeSkin(i);
        }
        if (this.iOn != null) {
            this.iOn.notifyDataSetChanged();
        }
    }

    public void onDestroy() {
        this.iOn.onDestory();
        this.iKK.setOnSrollToBottomListener(null);
    }

    public void setOnScrollListener(RecyclerView.OnScrollListener onScrollListener) {
        this.iKK.setOnScrollListener(onScrollListener);
    }
}
