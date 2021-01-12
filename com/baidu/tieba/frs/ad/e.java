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
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.view.PbListView;
import com.baidu.tbadk.core.view.UserPhotoLayout;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.t;
import com.baidu.tieba.frs.z;
import com.baidu.tieba.tbadkCore.FrsCommonImageLayout;
import com.baidu.tieba.tbadkCore.voice.PlayVoiceBnt;
/* loaded from: classes2.dex */
public class e {
    private FrameLayout ent;
    private PbListView gxy;
    private BdTypeRecyclerView jdk;
    private FrsADFragment jgB;
    private a jgM;
    private RelativeLayout mContainer;

    public e(FrsADFragment frsADFragment, View view) {
        this.jgB = frsADFragment;
        cR(view);
    }

    public a cDV() {
        return this.jgM;
    }

    private void cR(View view) {
        this.mContainer = (RelativeLayout) view.findViewById(R.id.frs_ad_container);
        this.jdk = (BdTypeRecyclerView) view.findViewById(R.id.frs_ad_listview);
        this.jdk.setLayoutManager(new LinearLayoutManager(this.jdk.getContext()));
        this.jdk.setFadingEdgeLength(0);
        this.jdk.setOverScrollMode(2);
        this.jdk.setRecyclerListener(new RecyclerView.RecyclerListener() { // from class: com.baidu.tieba.frs.ad.e.1
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
        this.jdk.setOnSrollToBottomListener(this.jgB);
        this.jgM = new a(this.jgB, this.jdk);
        this.gxy = new PbListView(this.jgB.getPageContext().getPageActivity());
        this.gxy.createView();
        this.gxy.setContainerBackgroundColorResId(R.color.CAM_X0205);
        this.gxy.setHeight(l.getDimens(this.jgB.getActivity(), R.dimen.tbds182));
        this.gxy.setLineGone();
        this.gxy.setTextSize(R.dimen.tbfontsize33);
        this.gxy.setTextColor(ao.getColor(R.color.CAM_X0107));
        this.gxy.setNoMoreTextColorId(R.color.CAM_X0110);
        this.ent = (FrameLayout) view.findViewById(R.id.frs_ad_list_content);
        lQ(false);
    }

    public void lQ(boolean z) {
        if (!z) {
            t tVar = new t();
            tVar.tabId = 90;
            tVar.gae = false;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921449, tVar));
        }
    }

    public void cDW() {
        t tVar = new t();
        tVar.tabId = 90;
        tVar.gae = false;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921449, tVar));
    }

    public BdTypeRecyclerView getListView() {
        return this.jdk;
    }

    public RelativeLayout cmp() {
        return this.mContainer;
    }

    public void qK(boolean z) {
        z zVar = new z();
        zVar.tabId = 90;
        zVar.fgC = z;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(9205410, zVar));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void Vo() {
        this.jdk.setNextPage(this.gxy);
        this.gxy.showEmptyView(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        this.gxy.startLoadData();
    }

    public void Vp() {
        this.jdk.setNextPage(this.gxy);
        this.gxy.showEmptyView(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        this.gxy.endLoadData();
        this.gxy.setText(this.jgB.getResources().getString(R.string.list_no_more));
    }

    public void bRO() {
        this.jdk.setNextPage(null);
    }

    public void qL(boolean z) {
        this.ent.setVisibility(z ? 0 : 8);
    }

    public void startPullRefresh() {
        t tVar = new t();
        tVar.tabId = 90;
        tVar.gae = true;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921449, tVar));
    }

    public void cCv() {
        if (this.jgM != null) {
            this.jgM.notifyDataSetChanged();
        }
    }

    public void onChangeSkinType(int i) {
        this.jgB.getBaseFragmentActivity().getLayoutMode().setNightMode(i == 1);
        this.jgB.getBaseFragmentActivity().getLayoutMode().onModeChanged(this.mContainer);
        if (this.gxy != null) {
            this.gxy.setTextColor(ao.getColor(R.color.CAM_X0107));
            this.gxy.changeSkin(i);
        }
        if (this.jgM != null) {
            this.jgM.notifyDataSetChanged();
        }
    }

    public void onDestroy() {
        this.jgM.onDestory();
        this.jdk.setOnSrollToBottomListener(null);
    }

    public void setOnScrollListener(RecyclerView.OnScrollListener onScrollListener) {
        this.jdk.setOnScrollListener(onScrollListener);
    }
}
