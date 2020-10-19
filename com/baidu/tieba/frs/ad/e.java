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
/* loaded from: classes22.dex */
public class e {
    private FrameLayout dPx;
    private PbListView fTv;
    private BdTypeRecyclerView irE;
    private FrsADFragment iuW;
    private a ivh;
    private RelativeLayout mContainer;

    public e(FrsADFragment frsADFragment, View view) {
        this.iuW = frsADFragment;
        cn(view);
    }

    public a cvp() {
        return this.ivh;
    }

    private void cn(View view) {
        this.mContainer = (RelativeLayout) view.findViewById(R.id.frs_ad_container);
        this.irE = (BdTypeRecyclerView) view.findViewById(R.id.frs_ad_listview);
        this.irE.setLayoutManager(new LinearLayoutManager(this.irE.getContext()));
        this.irE.setFadingEdgeLength(0);
        this.irE.setOverScrollMode(2);
        this.irE.setRecyclerListener(new RecyclerView.RecyclerListener() { // from class: com.baidu.tieba.frs.ad.e.1
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
        this.irE.setOnSrollToBottomListener(this.iuW);
        this.ivh = new a(this.iuW, this.irE);
        this.fTv = new PbListView(this.iuW.getPageContext().getPageActivity());
        this.fTv.createView();
        this.fTv.setContainerBackgroundColorResId(R.color.cp_bg_line_e);
        this.fTv.setHeight(l.getDimens(this.iuW.getActivity(), R.dimen.tbds182));
        this.fTv.setLineGone();
        this.fTv.setTextSize(R.dimen.tbfontsize33);
        this.fTv.setTextColor(ap.getColor(R.color.cp_cont_j));
        this.fTv.setNoMoreTextColorId(R.color.cp_cont_e);
        this.dPx = (FrameLayout) view.findViewById(R.id.frs_ad_list_content);
        kG(false);
    }

    public void kG(boolean z) {
        if (!z) {
            v vVar = new v();
            vVar.tabId = 90;
            vVar.fzJ = false;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921449, vVar));
        }
    }

    public void cvq() {
        v vVar = new v();
        vVar.tabId = 90;
        vVar.fzJ = false;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921449, vVar));
    }

    public BdTypeRecyclerView getListView() {
        return this.irE;
    }

    public RelativeLayout cew() {
        return this.mContainer;
    }

    public void pp(boolean z) {
        ad adVar = new ad();
        adVar.tabId = 90;
        adVar.eGO = z;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(9205410, adVar));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void SI() {
        this.irE.setNextPage(this.fTv);
        this.fTv.showEmptyView(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        this.fTv.startLoadData();
    }

    public void SJ() {
        this.irE.setNextPage(this.fTv);
        this.fTv.showEmptyView(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        this.fTv.endLoadData();
        this.fTv.setText(this.iuW.getResources().getString(R.string.list_no_more));
    }

    public void bKU() {
        this.irE.setNextPage(null);
    }

    public void pq(boolean z) {
        this.dPx.setVisibility(z ? 0 : 8);
    }

    public void startPullRefresh() {
        v vVar = new v();
        vVar.tabId = 90;
        vVar.fzJ = true;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921449, vVar));
    }

    public void ctP() {
        if (this.ivh != null) {
            this.ivh.notifyDataSetChanged();
        }
    }

    public void onChangeSkinType(int i) {
        this.iuW.getBaseFragmentActivity().getLayoutMode().setNightMode(i == 1);
        this.iuW.getBaseFragmentActivity().getLayoutMode().onModeChanged(this.mContainer);
        if (this.fTv != null) {
            this.fTv.setTextColor(ap.getColor(R.color.cp_cont_j));
            this.fTv.changeSkin(i);
        }
        if (this.ivh != null) {
            this.ivh.notifyDataSetChanged();
        }
    }

    public void onDestroy() {
        this.ivh.onDestory();
        this.irE.setOnSrollToBottomListener(null);
    }

    public void setOnScrollListener(RecyclerView.OnScrollListener onScrollListener) {
        this.irE.setOnScrollListener(onScrollListener);
    }
}
