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
/* loaded from: classes22.dex */
public class e {
    private FrameLayout dXU;
    private PbListView gdy;
    private BdTypeRecyclerView iEa;
    private a iHD;
    private FrsADFragment iHs;
    private RelativeLayout mContainer;

    public e(FrsADFragment frsADFragment, View view) {
        this.iHs = frsADFragment;
        cr(view);
    }

    public a cyw() {
        return this.iHD;
    }

    private void cr(View view) {
        this.mContainer = (RelativeLayout) view.findViewById(R.id.frs_ad_container);
        this.iEa = (BdTypeRecyclerView) view.findViewById(R.id.frs_ad_listview);
        this.iEa.setLayoutManager(new LinearLayoutManager(this.iEa.getContext()));
        this.iEa.setFadingEdgeLength(0);
        this.iEa.setOverScrollMode(2);
        this.iEa.setRecyclerListener(new RecyclerView.RecyclerListener() { // from class: com.baidu.tieba.frs.ad.e.1
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
        this.iEa.setOnSrollToBottomListener(this.iHs);
        this.iHD = new a(this.iHs, this.iEa);
        this.gdy = new PbListView(this.iHs.getPageContext().getPageActivity());
        this.gdy.createView();
        this.gdy.setContainerBackgroundColorResId(R.color.cp_bg_line_e);
        this.gdy.setHeight(l.getDimens(this.iHs.getActivity(), R.dimen.tbds182));
        this.gdy.setLineGone();
        this.gdy.setTextSize(R.dimen.tbfontsize33);
        this.gdy.setTextColor(ap.getColor(R.color.cp_cont_j));
        this.gdy.setNoMoreTextColorId(R.color.cp_cont_e);
        this.dXU = (FrameLayout) view.findViewById(R.id.frs_ad_list_content);
        kT(false);
    }

    public void kT(boolean z) {
        if (!z) {
            v vVar = new v();
            vVar.tabId = 90;
            vVar.fIe = false;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921449, vVar));
        }
    }

    public void cyx() {
        v vVar = new v();
        vVar.tabId = 90;
        vVar.fIe = false;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921449, vVar));
    }

    public BdTypeRecyclerView getListView() {
        return this.iEa;
    }

    public RelativeLayout chy() {
        return this.mContainer;
    }

    public void pH(boolean z) {
        ad adVar = new ad();
        adVar.tabId = 90;
        adVar.ePk = z;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(9205410, adVar));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void TI() {
        this.iEa.setNextPage(this.gdy);
        this.gdy.showEmptyView(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        this.gdy.startLoadData();
    }

    public void TJ() {
        this.iEa.setNextPage(this.gdy);
        this.gdy.showEmptyView(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        this.gdy.endLoadData();
        this.gdy.setText(this.iHs.getResources().getString(R.string.list_no_more));
    }

    public void bNw() {
        this.iEa.setNextPage(null);
    }

    public void pI(boolean z) {
        this.dXU.setVisibility(z ? 0 : 8);
    }

    public void startPullRefresh() {
        v vVar = new v();
        vVar.tabId = 90;
        vVar.fIe = true;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921449, vVar));
    }

    public void cwW() {
        if (this.iHD != null) {
            this.iHD.notifyDataSetChanged();
        }
    }

    public void onChangeSkinType(int i) {
        this.iHs.getBaseFragmentActivity().getLayoutMode().setNightMode(i == 1);
        this.iHs.getBaseFragmentActivity().getLayoutMode().onModeChanged(this.mContainer);
        if (this.gdy != null) {
            this.gdy.setTextColor(ap.getColor(R.color.cp_cont_j));
            this.gdy.changeSkin(i);
        }
        if (this.iHD != null) {
            this.iHD.notifyDataSetChanged();
        }
    }

    public void onDestroy() {
        this.iHD.onDestory();
        this.iEa.setOnSrollToBottomListener(null);
    }

    public void setOnScrollListener(RecyclerView.OnScrollListener onScrollListener) {
        this.iEa.setOnScrollListener(onScrollListener);
    }
}
