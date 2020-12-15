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
    private PbListView grg;
    private BdTypeRecyclerView iVF;
    private FrsADFragment iYV;
    private a iZg;
    private RelativeLayout mContainer;

    public e(FrsADFragment frsADFragment, View view) {
        this.iYV = frsADFragment;
        cH(view);
    }

    public a cER() {
        return this.iZg;
    }

    private void cH(View view) {
        this.mContainer = (RelativeLayout) view.findViewById(R.id.frs_ad_container);
        this.iVF = (BdTypeRecyclerView) view.findViewById(R.id.frs_ad_listview);
        this.iVF.setLayoutManager(new LinearLayoutManager(this.iVF.getContext()));
        this.iVF.setFadingEdgeLength(0);
        this.iVF.setOverScrollMode(2);
        this.iVF.setRecyclerListener(new RecyclerView.RecyclerListener() { // from class: com.baidu.tieba.frs.ad.e.1
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
        this.iVF.setOnSrollToBottomListener(this.iYV);
        this.iZg = new a(this.iYV, this.iVF);
        this.grg = new PbListView(this.iYV.getPageContext().getPageActivity());
        this.grg.createView();
        this.grg.setContainerBackgroundColorResId(R.color.CAM_X0205);
        this.grg.setHeight(l.getDimens(this.iYV.getActivity(), R.dimen.tbds182));
        this.grg.setLineGone();
        this.grg.setTextSize(R.dimen.tbfontsize33);
        this.grg.setTextColor(ap.getColor(R.color.CAM_X0107));
        this.grg.setNoMoreTextColorId(R.color.CAM_X0110);
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

    public void cES() {
        u uVar = new u();
        uVar.tabId = 90;
        uVar.fVi = false;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921449, uVar));
    }

    public BdTypeRecyclerView getListView() {
        return this.iVF;
    }

    public RelativeLayout cno() {
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
        this.iVF.setNextPage(this.grg);
        this.grg.showEmptyView(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        this.grg.startLoadData();
    }

    public void Ya() {
        this.iVF.setNextPage(this.grg);
        this.grg.showEmptyView(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        this.grg.endLoadData();
        this.grg.setText(this.iYV.getResources().getString(R.string.list_no_more));
    }

    public void bTb() {
        this.iVF.setNextPage(null);
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

    public void cDs() {
        if (this.iZg != null) {
            this.iZg.notifyDataSetChanged();
        }
    }

    public void onChangeSkinType(int i) {
        this.iYV.getBaseFragmentActivity().getLayoutMode().setNightMode(i == 1);
        this.iYV.getBaseFragmentActivity().getLayoutMode().onModeChanged(this.mContainer);
        if (this.grg != null) {
            this.grg.setTextColor(ap.getColor(R.color.CAM_X0107));
            this.grg.changeSkin(i);
        }
        if (this.iZg != null) {
            this.iZg.notifyDataSetChanged();
        }
    }

    public void onDestroy() {
        this.iZg.onDestory();
        this.iVF.setOnSrollToBottomListener(null);
    }

    public void setOnScrollListener(RecyclerView.OnScrollListener onScrollListener) {
        this.iVF.setOnScrollListener(onScrollListener);
    }
}
