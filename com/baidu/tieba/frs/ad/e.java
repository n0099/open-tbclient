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
    private FrameLayout erd;
    private PbListView gCf;
    private BdTypeRecyclerView jkO;
    private FrsADFragment jog;
    private a jor;
    private RelativeLayout mContainer;

    public e(FrsADFragment frsADFragment, View view) {
        this.jog = frsADFragment;
        cP(view);
    }

    public a cFu() {
        return this.jor;
    }

    private void cP(View view) {
        this.mContainer = (RelativeLayout) view.findViewById(R.id.frs_ad_container);
        this.jkO = (BdTypeRecyclerView) view.findViewById(R.id.frs_ad_listview);
        this.jkO.setLayoutManager(new LinearLayoutManager(this.jkO.getContext()));
        this.jkO.setFadingEdgeLength(0);
        this.jkO.setOverScrollMode(2);
        this.jkO.setRecyclerListener(new RecyclerView.RecyclerListener() { // from class: com.baidu.tieba.frs.ad.e.1
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
        this.jkO.setOnSrollToBottomListener(this.jog);
        this.jor = new a(this.jog, this.jkO);
        this.gCf = new PbListView(this.jog.getPageContext().getPageActivity());
        this.gCf.createView();
        this.gCf.setContainerBackgroundColorResId(R.color.CAM_X0205);
        this.gCf.setHeight(l.getDimens(this.jog.getActivity(), R.dimen.tbds182));
        this.gCf.setLineGone();
        this.gCf.setTextSize(R.dimen.tbfontsize33);
        this.gCf.setTextColor(ap.getColor(R.color.CAM_X0107));
        this.gCf.setNoMoreTextColorId(R.color.CAM_X0110);
        this.erd = (FrameLayout) view.findViewById(R.id.frs_ad_list_content);
        lU(false);
    }

    public void lU(boolean z) {
        if (!z) {
            t tVar = new t();
            tVar.tabId = 90;
            tVar.gec = false;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921449, tVar));
        }
    }

    public void cFv() {
        t tVar = new t();
        tVar.tabId = 90;
        tVar.gec = false;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921449, tVar));
    }

    public BdTypeRecyclerView getListView() {
        return this.jkO;
    }

    public RelativeLayout cnA() {
        return this.mContainer;
    }

    public void qU(boolean z) {
        z zVar = new z();
        zVar.tabId = 90;
        zVar.fku = z;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(9205410, zVar));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void Xa() {
        this.jkO.setNextPage(this.gCf);
        this.gCf.showEmptyView(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        this.gCf.startLoadData();
    }

    public void Xb() {
        this.jkO.setNextPage(this.gCf);
        this.gCf.showEmptyView(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        this.gCf.endLoadData();
        this.gCf.setText(this.jog.getResources().getString(R.string.list_no_more));
    }

    public void bSE() {
        this.jkO.setNextPage(null);
    }

    public void qV(boolean z) {
        this.erd.setVisibility(z ? 0 : 8);
    }

    public void startPullRefresh() {
        t tVar = new t();
        tVar.tabId = 90;
        tVar.gec = true;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921449, tVar));
    }

    public void cDU() {
        if (this.jor != null) {
            this.jor.notifyDataSetChanged();
        }
    }

    public void onChangeSkinType(int i) {
        this.jog.getBaseFragmentActivity().getLayoutMode().setNightMode(i == 1);
        this.jog.getBaseFragmentActivity().getLayoutMode().onModeChanged(this.mContainer);
        if (this.gCf != null) {
            this.gCf.setTextColor(ap.getColor(R.color.CAM_X0107));
            this.gCf.changeSkin(i);
        }
        if (this.jor != null) {
            this.jor.notifyDataSetChanged();
        }
    }

    public void onDestroy() {
        this.jor.onDestory();
        this.jkO.setOnSrollToBottomListener(null);
    }

    public void setOnScrollListener(RecyclerView.OnScrollListener onScrollListener) {
        this.jkO.setOnScrollListener(onScrollListener);
    }
}
