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
    private FrameLayout cVI;
    private PbListView ePr;
    private BdTypeRecyclerView haA;
    private FrsADFragment hcX;
    private a hdi;
    private RelativeLayout mContainer;

    public e(FrsADFragment frsADFragment, View view) {
        this.hcX = frsADFragment;
        bP(view);
    }

    public a bQQ() {
        return this.hdi;
    }

    private void bP(View view) {
        this.mContainer = (RelativeLayout) view.findViewById(R.id.frs_ad_container);
        this.haA = (BdTypeRecyclerView) view.findViewById(R.id.frs_ad_listview);
        this.haA.setLayoutManager(new LinearLayoutManager(this.haA.getContext()));
        this.haA.setFadingEdgeLength(0);
        this.haA.setOverScrollMode(2);
        this.haA.setRecyclerListener(new RecyclerView.RecyclerListener() { // from class: com.baidu.tieba.frs.ad.e.1
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
        this.haA.setOnSrollToBottomListener(this.hcX);
        this.hdi = new a(this.hcX, this.haA);
        this.ePr = new PbListView(this.hcX.getPageContext().getPageActivity());
        this.ePr.createView();
        this.ePr.setContainerBackgroundColorResId(R.color.cp_bg_line_e);
        this.ePr.setHeight(l.getDimens(this.hcX.getActivity(), R.dimen.tbds182));
        this.ePr.setLineGone();
        this.ePr.setTextSize(R.dimen.tbfontsize33);
        this.ePr.setTextColor(am.getColor(R.color.cp_cont_j));
        this.ePr.setNoMoreTextColorId(R.color.cp_cont_e);
        this.cVI = (FrameLayout) view.findViewById(R.id.frs_ad_list_content);
        it(false);
    }

    public void it(boolean z) {
        if (!z) {
            s sVar = new s();
            sVar.tabId = 90;
            sVar.etP = false;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921449, sVar));
        }
    }

    public void bQR() {
        s sVar = new s();
        sVar.tabId = 90;
        sVar.etP = false;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921449, sVar));
    }

    public BdTypeRecyclerView getListView() {
        return this.haA;
    }

    public RelativeLayout bCr() {
        return this.mContainer;
    }

    public void mN(boolean z) {
        y yVar = new y();
        yVar.tabId = 90;
        yVar.dGR = z;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(9205410, yVar));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void bmm() {
        this.haA.setNextPage(this.ePr);
        this.ePr.showEmptyView(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        this.ePr.startLoadData();
    }

    public void bmn() {
        this.haA.setNextPage(this.ePr);
        this.ePr.showEmptyView(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        this.ePr.endLoadData();
        this.ePr.setText(this.hcX.getResources().getString(R.string.list_no_more));
    }

    public void bmo() {
        this.haA.setNextPage(null);
    }

    public void mO(boolean z) {
        this.cVI.setVisibility(z ? 0 : 8);
    }

    public void startPullRefresh() {
        s sVar = new s();
        sVar.tabId = 90;
        sVar.etP = true;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921449, sVar));
    }

    public void bPC() {
        if (this.hdi != null) {
            this.hdi.notifyDataSetChanged();
        }
    }

    public void onChangeSkinType(int i) {
        this.hcX.getBaseFragmentActivity().getLayoutMode().setNightMode(i == 1);
        this.hcX.getBaseFragmentActivity().getLayoutMode().onModeChanged(this.mContainer);
        if (this.ePr != null) {
            this.ePr.setTextColor(am.getColor(R.color.cp_cont_j));
            this.ePr.changeSkin(i);
        }
        if (this.hdi != null) {
            this.hdi.notifyDataSetChanged();
        }
    }

    public void onDestroy() {
        this.hdi.onDestory();
        this.haA.setOnSrollToBottomListener(null);
    }

    public void setOnScrollListener(RecyclerView.OnScrollListener onScrollListener) {
        this.haA.setOnScrollListener(onScrollListener);
    }
}
