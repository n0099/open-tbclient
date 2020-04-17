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
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.view.PbListView;
import com.baidu.tbadk.core.view.UserPhotoLayout;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.s;
import com.baidu.tieba.frs.y;
import com.baidu.tieba.tbadkCore.FrsCommonImageLayout;
import com.baidu.tieba.tbadkCore.voice.PlayVoiceBnt;
/* loaded from: classes9.dex */
public class e {
    private FrameLayout cVD;
    private PbListView ePm;
    private BdTypeRecyclerView hau;
    private FrsADFragment hcR;
    private a hdc;
    private RelativeLayout mContainer;

    public e(FrsADFragment frsADFragment, View view) {
        this.hcR = frsADFragment;
        bP(view);
    }

    public a bQS() {
        return this.hdc;
    }

    private void bP(View view) {
        this.mContainer = (RelativeLayout) view.findViewById(R.id.frs_ad_container);
        this.hau = (BdTypeRecyclerView) view.findViewById(R.id.frs_ad_listview);
        this.hau.setLayoutManager(new LinearLayoutManager(this.hau.getContext()));
        this.hau.setFadingEdgeLength(0);
        this.hau.setOverScrollMode(2);
        this.hau.setRecyclerListener(new RecyclerView.RecyclerListener() { // from class: com.baidu.tieba.frs.ad.e.1
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
        this.hau.setOnSrollToBottomListener(this.hcR);
        this.hdc = new a(this.hcR, this.hau);
        this.ePm = new PbListView(this.hcR.getPageContext().getPageActivity());
        this.ePm.createView();
        this.ePm.setContainerBackgroundColorResId(R.color.cp_bg_line_e);
        this.ePm.setHeight(l.getDimens(this.hcR.getActivity(), R.dimen.tbds182));
        this.ePm.setLineGone();
        this.ePm.setTextSize(R.dimen.tbfontsize33);
        this.ePm.setTextColor(am.getColor(R.color.cp_cont_j));
        this.ePm.setNoMoreTextColorId(R.color.cp_cont_e);
        this.cVD = (FrameLayout) view.findViewById(R.id.frs_ad_list_content);
        it(false);
    }

    public void it(boolean z) {
        if (!z) {
            s sVar = new s();
            sVar.tabId = 90;
            sVar.etK = false;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921449, sVar));
        }
    }

    public void bQT() {
        s sVar = new s();
        sVar.tabId = 90;
        sVar.etK = false;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921449, sVar));
    }

    public BdTypeRecyclerView getListView() {
        return this.hau;
    }

    public RelativeLayout bCt() {
        return this.mContainer;
    }

    public void mN(boolean z) {
        y yVar = new y();
        yVar.tabId = 90;
        yVar.dGN = z;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(9205410, yVar));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void bmo() {
        this.hau.setNextPage(this.ePm);
        this.ePm.showEmptyView(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        this.ePm.startLoadData();
    }

    public void bmp() {
        this.hau.setNextPage(this.ePm);
        this.ePm.showEmptyView(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        this.ePm.endLoadData();
        this.ePm.setText(this.hcR.getResources().getString(R.string.list_no_more));
    }

    public void bmq() {
        this.hau.setNextPage(null);
    }

    public void mO(boolean z) {
        this.cVD.setVisibility(z ? 0 : 8);
    }

    public void startPullRefresh() {
        s sVar = new s();
        sVar.tabId = 90;
        sVar.etK = true;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921449, sVar));
    }

    public void bPE() {
        if (this.hdc != null) {
            this.hdc.notifyDataSetChanged();
        }
    }

    public void onChangeSkinType(int i) {
        this.hcR.getBaseFragmentActivity().getLayoutMode().setNightMode(i == 1);
        this.hcR.getBaseFragmentActivity().getLayoutMode().onModeChanged(this.mContainer);
        if (this.ePm != null) {
            this.ePm.setTextColor(am.getColor(R.color.cp_cont_j));
            this.ePm.changeSkin(i);
        }
        if (this.hdc != null) {
            this.hdc.notifyDataSetChanged();
        }
    }

    public void onDestroy() {
        this.hdc.onDestory();
        this.hau.setOnSrollToBottomListener(null);
    }

    public void setOnScrollListener(RecyclerView.OnScrollListener onScrollListener) {
        this.hau.setOnScrollListener(onScrollListener);
    }
}
