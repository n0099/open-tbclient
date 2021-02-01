package com.baidu.tieba.frs.ad;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.l;
import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.view.PbListView;
import com.baidu.tbadk.core.view.UserPhotoLayout;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.t;
import com.baidu.tieba.frs.z;
import com.baidu.tieba.tbadkCore.FrsCommonImageLayout;
import com.baidu.tieba.tbadkCore.voice.PlayVoiceBnt;
/* loaded from: classes2.dex */
public class e {
    private FrameLayout epC;
    private PbListView gAi;
    private BdTypeRecyclerView jiR;
    private FrsADFragment jmi;
    private a jmu;
    private RelativeLayout mContainer;

    public e(FrsADFragment frsADFragment, View view) {
        this.jmi = frsADFragment;
        cP(view);
    }

    public a cFh() {
        return this.jmu;
    }

    private void cP(View view) {
        this.mContainer = (RelativeLayout) view.findViewById(R.id.frs_ad_container);
        this.jiR = (BdTypeRecyclerView) view.findViewById(R.id.frs_ad_listview);
        this.jiR.setLayoutManager(new LinearLayoutManager(this.jiR.getContext()));
        this.jiR.setFadingEdgeLength(0);
        this.jiR.setOverScrollMode(2);
        this.jiR.setRecyclerListener(new RecyclerView.RecyclerListener() { // from class: com.baidu.tieba.frs.ad.e.1
            @Override // androidx.recyclerview.widget.RecyclerView.RecyclerListener
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
        this.jiR.setOnSrollToBottomListener(this.jmi);
        this.jmu = new a(this.jmi, this.jiR);
        this.gAi = new PbListView(this.jmi.getPageContext().getPageActivity());
        this.gAi.createView();
        this.gAi.setContainerBackgroundColorResId(R.color.CAM_X0205);
        this.gAi.setHeight(l.getDimens(this.jmi.getActivity(), R.dimen.tbds182));
        this.gAi.setLineGone();
        this.gAi.setTextSize(R.dimen.tbfontsize33);
        this.gAi.setTextColor(ap.getColor(R.color.CAM_X0107));
        this.gAi.setNoMoreTextColorId(R.color.CAM_X0110);
        this.epC = (FrameLayout) view.findViewById(R.id.frs_ad_list_content);
        lU(false);
    }

    public void lU(boolean z) {
        if (!z) {
            t tVar = new t();
            tVar.tabId = 90;
            tVar.gcx = false;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921449, tVar));
        }
    }

    public void cFi() {
        t tVar = new t();
        tVar.tabId = 90;
        tVar.gcx = false;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921449, tVar));
    }

    public BdTypeRecyclerView getListView() {
        return this.jiR;
    }

    public RelativeLayout cnn() {
        return this.mContainer;
    }

    public void qU(boolean z) {
        z zVar = new z();
        zVar.tabId = 90;
        zVar.fiV = z;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(9205410, zVar));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void WX() {
        this.jiR.setNextPage(this.gAi);
        this.gAi.showEmptyView(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        this.gAi.startLoadData();
    }

    public void WY() {
        this.jiR.setNextPage(this.gAi);
        this.gAi.showEmptyView(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        this.gAi.endLoadData();
        this.gAi.setText(this.jmi.getResources().getString(R.string.list_no_more));
    }

    public void bSr() {
        this.jiR.setNextPage(null);
    }

    public void qV(boolean z) {
        this.epC.setVisibility(z ? 0 : 8);
    }

    public void startPullRefresh() {
        t tVar = new t();
        tVar.tabId = 90;
        tVar.gcx = true;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921449, tVar));
    }

    public void cDH() {
        if (this.jmu != null) {
            this.jmu.notifyDataSetChanged();
        }
    }

    public void onChangeSkinType(int i) {
        this.jmi.getBaseFragmentActivity().getLayoutMode().setNightMode(i == 1);
        this.jmi.getBaseFragmentActivity().getLayoutMode().onModeChanged(this.mContainer);
        if (this.gAi != null) {
            this.gAi.setTextColor(ap.getColor(R.color.CAM_X0107));
            this.gAi.changeSkin(i);
        }
        if (this.jmu != null) {
            this.jmu.notifyDataSetChanged();
        }
    }

    public void onDestroy() {
        this.jmu.onDestory();
        this.jiR.setOnSrollToBottomListener(null);
    }

    public void setOnScrollListener(RecyclerView.OnScrollListener onScrollListener) {
        this.jiR.setOnScrollListener(onScrollListener);
    }
}
