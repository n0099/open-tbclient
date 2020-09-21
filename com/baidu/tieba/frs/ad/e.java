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
/* loaded from: classes21.dex */
public class e {
    private FrameLayout dDw;
    private PbListView fHm;
    private BdTypeRecyclerView icD;
    private FrsADFragment ifZ;
    private a igk;
    private RelativeLayout mContainer;

    public e(FrsADFragment frsADFragment, View view) {
        this.ifZ = frsADFragment;
        cj(view);
    }

    public a crR() {
        return this.igk;
    }

    private void cj(View view) {
        this.mContainer = (RelativeLayout) view.findViewById(R.id.frs_ad_container);
        this.icD = (BdTypeRecyclerView) view.findViewById(R.id.frs_ad_listview);
        this.icD.setLayoutManager(new LinearLayoutManager(this.icD.getContext()));
        this.icD.setFadingEdgeLength(0);
        this.icD.setOverScrollMode(2);
        this.icD.setRecyclerListener(new RecyclerView.RecyclerListener() { // from class: com.baidu.tieba.frs.ad.e.1
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
        this.icD.setOnSrollToBottomListener(this.ifZ);
        this.igk = new a(this.ifZ, this.icD);
        this.fHm = new PbListView(this.ifZ.getPageContext().getPageActivity());
        this.fHm.createView();
        this.fHm.setContainerBackgroundColorResId(R.color.cp_bg_line_e);
        this.fHm.setHeight(l.getDimens(this.ifZ.getActivity(), R.dimen.tbds182));
        this.fHm.setLineGone();
        this.fHm.setTextSize(R.dimen.tbfontsize33);
        this.fHm.setTextColor(ap.getColor(R.color.cp_cont_j));
        this.fHm.setNoMoreTextColorId(R.color.cp_cont_e);
        this.dDw = (FrameLayout) view.findViewById(R.id.frs_ad_list_content);
        ki(false);
    }

    public void ki(boolean z) {
        if (!z) {
            v vVar = new v();
            vVar.tabId = 90;
            vVar.fnv = false;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921449, vVar));
        }
    }

    public void crS() {
        v vVar = new v();
        vVar.tabId = 90;
        vVar.fnv = false;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921449, vVar));
    }

    public BdTypeRecyclerView getListView() {
        return this.icD;
    }

    public RelativeLayout caY() {
        return this.mContainer;
    }

    public void oK(boolean z) {
        ad adVar = new ad();
        adVar.tabId = 90;
        adVar.euE = z;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(9205410, adVar));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void bIi() {
        this.icD.setNextPage(this.fHm);
        this.fHm.showEmptyView(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        this.fHm.startLoadData();
    }

    public void bIj() {
        this.icD.setNextPage(this.fHm);
        this.fHm.showEmptyView(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        this.fHm.endLoadData();
        this.fHm.setText(this.ifZ.getResources().getString(R.string.list_no_more));
    }

    public void bIk() {
        this.icD.setNextPage(null);
    }

    public void oL(boolean z) {
        this.dDw.setVisibility(z ? 0 : 8);
    }

    public void startPullRefresh() {
        v vVar = new v();
        vVar.tabId = 90;
        vVar.fnv = true;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921449, vVar));
    }

    public void cqr() {
        if (this.igk != null) {
            this.igk.notifyDataSetChanged();
        }
    }

    public void onChangeSkinType(int i) {
        this.ifZ.getBaseFragmentActivity().getLayoutMode().setNightMode(i == 1);
        this.ifZ.getBaseFragmentActivity().getLayoutMode().onModeChanged(this.mContainer);
        if (this.fHm != null) {
            this.fHm.setTextColor(ap.getColor(R.color.cp_cont_j));
            this.fHm.changeSkin(i);
        }
        if (this.igk != null) {
            this.igk.notifyDataSetChanged();
        }
    }

    public void onDestroy() {
        this.igk.onDestory();
        this.icD.setOnSrollToBottomListener(null);
    }

    public void setOnScrollListener(RecyclerView.OnScrollListener onScrollListener) {
        this.icD.setOnScrollListener(onScrollListener);
    }
}
