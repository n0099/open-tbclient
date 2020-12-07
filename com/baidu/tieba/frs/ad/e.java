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
import com.baidu.tieba.frs.ac;
import com.baidu.tieba.frs.u;
import com.baidu.tieba.tbadkCore.FrsCommonImageLayout;
import com.baidu.tieba.tbadkCore.voice.PlayVoiceBnt;
/* loaded from: classes22.dex */
public class e {
    private FrameLayout eje;
    private PbListView gre;
    private BdTypeRecyclerView iVD;
    private FrsADFragment iYT;
    private a iZe;
    private RelativeLayout mContainer;

    public e(FrsADFragment frsADFragment, View view) {
        this.iYT = frsADFragment;
        cH(view);
    }

    public a cEQ() {
        return this.iZe;
    }

    private void cH(View view) {
        this.mContainer = (RelativeLayout) view.findViewById(R.id.frs_ad_container);
        this.iVD = (BdTypeRecyclerView) view.findViewById(R.id.frs_ad_listview);
        this.iVD.setLayoutManager(new LinearLayoutManager(this.iVD.getContext()));
        this.iVD.setFadingEdgeLength(0);
        this.iVD.setOverScrollMode(2);
        this.iVD.setRecyclerListener(new RecyclerView.RecyclerListener() { // from class: com.baidu.tieba.frs.ad.e.1
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
        this.iVD.setOnSrollToBottomListener(this.iYT);
        this.iZe = new a(this.iYT, this.iVD);
        this.gre = new PbListView(this.iYT.getPageContext().getPageActivity());
        this.gre.createView();
        this.gre.setContainerBackgroundColorResId(R.color.CAM_X0205);
        this.gre.setHeight(l.getDimens(this.iYT.getActivity(), R.dimen.tbds182));
        this.gre.setLineGone();
        this.gre.setTextSize(R.dimen.tbfontsize33);
        this.gre.setTextColor(ap.getColor(R.color.CAM_X0107));
        this.gre.setNoMoreTextColorId(R.color.CAM_X0110);
        this.eje = (FrameLayout) view.findViewById(R.id.frs_ad_list_content);
        lx(false);
    }

    public void lx(boolean z) {
        if (!z) {
            u uVar = new u();
            uVar.tabId = 90;
            uVar.fVi = false;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921449, uVar));
        }
    }

    public void cER() {
        u uVar = new u();
        uVar.tabId = 90;
        uVar.fVi = false;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921449, uVar));
    }

    public BdTypeRecyclerView getListView() {
        return this.iVD;
    }

    public RelativeLayout cnn() {
        return this.mContainer;
    }

    public void qq(boolean z) {
        ac acVar = new ac();
        acVar.tabId = 90;
        acVar.fbE = z;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(9205410, acVar));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void XZ() {
        this.iVD.setNextPage(this.gre);
        this.gre.showEmptyView(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        this.gre.startLoadData();
    }

    public void Ya() {
        this.iVD.setNextPage(this.gre);
        this.gre.showEmptyView(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        this.gre.endLoadData();
        this.gre.setText(this.iYT.getResources().getString(R.string.list_no_more));
    }

    public void bTa() {
        this.iVD.setNextPage(null);
    }

    public void qr(boolean z) {
        this.eje.setVisibility(z ? 0 : 8);
    }

    public void startPullRefresh() {
        u uVar = new u();
        uVar.tabId = 90;
        uVar.fVi = true;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921449, uVar));
    }

    public void cDr() {
        if (this.iZe != null) {
            this.iZe.notifyDataSetChanged();
        }
    }

    public void onChangeSkinType(int i) {
        this.iYT.getBaseFragmentActivity().getLayoutMode().setNightMode(i == 1);
        this.iYT.getBaseFragmentActivity().getLayoutMode().onModeChanged(this.mContainer);
        if (this.gre != null) {
            this.gre.setTextColor(ap.getColor(R.color.CAM_X0107));
            this.gre.changeSkin(i);
        }
        if (this.iZe != null) {
            this.iZe.notifyDataSetChanged();
        }
    }

    public void onDestroy() {
        this.iZe.onDestory();
        this.iVD.setOnSrollToBottomListener(null);
    }

    public void setOnScrollListener(RecyclerView.OnScrollListener onScrollListener) {
        this.iVD.setOnScrollListener(onScrollListener);
    }
}
