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
    private FrameLayout dgJ;
    private PbListView fbY;
    private BdTypeRecyclerView hpo;
    private FrsADFragment hrL;
    private a hrW;
    private RelativeLayout mContainer;

    public e(FrsADFragment frsADFragment, View view) {
        this.hrL = frsADFragment;
        bP(view);
    }

    public a bXn() {
        return this.hrW;
    }

    private void bP(View view) {
        this.mContainer = (RelativeLayout) view.findViewById(R.id.frs_ad_container);
        this.hpo = (BdTypeRecyclerView) view.findViewById(R.id.frs_ad_listview);
        this.hpo.setLayoutManager(new LinearLayoutManager(this.hpo.getContext()));
        this.hpo.setFadingEdgeLength(0);
        this.hpo.setOverScrollMode(2);
        this.hpo.setRecyclerListener(new RecyclerView.RecyclerListener() { // from class: com.baidu.tieba.frs.ad.e.1
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
        this.hpo.setOnSrollToBottomListener(this.hrL);
        this.hrW = new a(this.hrL, this.hpo);
        this.fbY = new PbListView(this.hrL.getPageContext().getPageActivity());
        this.fbY.createView();
        this.fbY.setContainerBackgroundColorResId(R.color.cp_bg_line_e);
        this.fbY.setHeight(l.getDimens(this.hrL.getActivity(), R.dimen.tbds182));
        this.fbY.setLineGone();
        this.fbY.setTextSize(R.dimen.tbfontsize33);
        this.fbY.setTextColor(am.getColor(R.color.cp_cont_j));
        this.fbY.setNoMoreTextColorId(R.color.cp_cont_e);
        this.dgJ = (FrameLayout) view.findViewById(R.id.frs_ad_list_content);
        iQ(false);
    }

    public void iQ(boolean z) {
        if (!z) {
            s sVar = new s();
            sVar.tabId = 90;
            sVar.eIo = false;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921449, sVar));
        }
    }

    public void bXo() {
        s sVar = new s();
        sVar.tabId = 90;
        sVar.eIo = false;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921449, sVar));
    }

    public BdTypeRecyclerView getListView() {
        return this.hpo;
    }

    public RelativeLayout bIL() {
        return this.mContainer;
    }

    public void ni(boolean z) {
        y yVar = new y();
        yVar.tabId = 90;
        yVar.dVd = z;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(9205410, yVar));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void brK() {
        this.hpo.setNextPage(this.fbY);
        this.fbY.showEmptyView(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        this.fbY.startLoadData();
    }

    public void brL() {
        this.hpo.setNextPage(this.fbY);
        this.fbY.showEmptyView(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        this.fbY.endLoadData();
        this.fbY.setText(this.hrL.getResources().getString(R.string.list_no_more));
    }

    public void brM() {
        this.hpo.setNextPage(null);
    }

    public void nj(boolean z) {
        this.dgJ.setVisibility(z ? 0 : 8);
    }

    public void startPullRefresh() {
        s sVar = new s();
        sVar.tabId = 90;
        sVar.eIo = true;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921449, sVar));
    }

    public void bVZ() {
        if (this.hrW != null) {
            this.hrW.notifyDataSetChanged();
        }
    }

    public void onChangeSkinType(int i) {
        this.hrL.getBaseFragmentActivity().getLayoutMode().setNightMode(i == 1);
        this.hrL.getBaseFragmentActivity().getLayoutMode().onModeChanged(this.mContainer);
        if (this.fbY != null) {
            this.fbY.setTextColor(am.getColor(R.color.cp_cont_j));
            this.fbY.changeSkin(i);
        }
        if (this.hrW != null) {
            this.hrW.notifyDataSetChanged();
        }
    }

    public void onDestroy() {
        this.hrW.onDestory();
        this.hpo.setOnSrollToBottomListener(null);
    }

    public void setOnScrollListener(RecyclerView.OnScrollListener onScrollListener) {
        this.hpo.setOnScrollListener(onScrollListener);
    }
}
