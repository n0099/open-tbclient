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
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.view.PbListView;
import com.baidu.tbadk.core.view.UserPhotoLayout;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.ab;
import com.baidu.tieba.frs.u;
import com.baidu.tieba.tbadkCore.FrsCommonImageLayout;
import com.baidu.tieba.tbadkCore.voice.PlayVoiceBnt;
/* loaded from: classes16.dex */
public class e {
    private FrameLayout drp;
    private PbListView fsC;
    private BdTypeRecyclerView hIh;
    private FrsADFragment hKK;
    private a hKV;
    private RelativeLayout mContainer;

    public e(FrsADFragment frsADFragment, View view) {
        this.hKK = frsADFragment;
        bY(view);
    }

    public a cdZ() {
        return this.hKV;
    }

    private void bY(View view) {
        this.mContainer = (RelativeLayout) view.findViewById(R.id.frs_ad_container);
        this.hIh = (BdTypeRecyclerView) view.findViewById(R.id.frs_ad_listview);
        this.hIh.setLayoutManager(new LinearLayoutManager(this.hIh.getContext()));
        this.hIh.setFadingEdgeLength(0);
        this.hIh.setOverScrollMode(2);
        this.hIh.setRecyclerListener(new RecyclerView.RecyclerListener() { // from class: com.baidu.tieba.frs.ad.e.1
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
        this.hIh.setOnSrollToBottomListener(this.hKK);
        this.hKV = new a(this.hKK, this.hIh);
        this.fsC = new PbListView(this.hKK.getPageContext().getPageActivity());
        this.fsC.createView();
        this.fsC.setContainerBackgroundColorResId(R.color.cp_bg_line_e);
        this.fsC.setHeight(l.getDimens(this.hKK.getActivity(), R.dimen.tbds182));
        this.fsC.setLineGone();
        this.fsC.setTextSize(R.dimen.tbfontsize33);
        this.fsC.setTextColor(ao.getColor(R.color.cp_cont_j));
        this.fsC.setNoMoreTextColorId(R.color.cp_cont_e);
        this.drp = (FrameLayout) view.findViewById(R.id.frs_ad_list_content);
        jH(false);
    }

    public void jH(boolean z) {
        if (!z) {
            u uVar = new u();
            uVar.tabId = 90;
            uVar.eZg = false;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921449, uVar));
        }
    }

    public void cea() {
        u uVar = new u();
        uVar.tabId = 90;
        uVar.eZg = false;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921449, uVar));
    }

    public BdTypeRecyclerView getListView() {
        return this.hIh;
    }

    public RelativeLayout bPb() {
        return this.mContainer;
    }

    public void nY(boolean z) {
        ab abVar = new ab();
        abVar.tabId = 90;
        abVar.eiE = z;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(9205410, abVar));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void bxS() {
        this.hIh.setNextPage(this.fsC);
        this.fsC.showEmptyView(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        this.fsC.startLoadData();
    }

    public void bxT() {
        this.hIh.setNextPage(this.fsC);
        this.fsC.showEmptyView(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        this.fsC.endLoadData();
        this.fsC.setText(this.hKK.getResources().getString(R.string.list_no_more));
    }

    public void bxU() {
        this.hIh.setNextPage(null);
    }

    public void nZ(boolean z) {
        this.drp.setVisibility(z ? 0 : 8);
    }

    public void startPullRefresh() {
        u uVar = new u();
        uVar.tabId = 90;
        uVar.eZg = true;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921449, uVar));
    }

    public void ccH() {
        if (this.hKV != null) {
            this.hKV.notifyDataSetChanged();
        }
    }

    public void onChangeSkinType(int i) {
        this.hKK.getBaseFragmentActivity().getLayoutMode().setNightMode(i == 1);
        this.hKK.getBaseFragmentActivity().getLayoutMode().onModeChanged(this.mContainer);
        if (this.fsC != null) {
            this.fsC.setTextColor(ao.getColor(R.color.cp_cont_j));
            this.fsC.changeSkin(i);
        }
        if (this.hKV != null) {
            this.hKV.notifyDataSetChanged();
        }
    }

    public void onDestroy() {
        this.hKV.onDestory();
        this.hIh.setOnSrollToBottomListener(null);
    }

    public void setOnScrollListener(RecyclerView.OnScrollListener onScrollListener) {
        this.hIh.setOnScrollListener(onScrollListener);
    }
}
