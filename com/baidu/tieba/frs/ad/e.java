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
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.view.PbListView;
import com.baidu.tbadk.core.view.UserPhotoLayout;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.ab;
import com.baidu.tieba.frs.u;
import com.baidu.tieba.tbadkCore.FrsCommonImageLayout;
import com.baidu.tieba.tbadkCore.voice.PlayVoiceBnt;
/* loaded from: classes9.dex */
public class e {
    private FrameLayout dlv;
    private PbListView fnt;
    private BdTypeRecyclerView hCj;
    private FrsADFragment hEM;
    private a hEX;
    private RelativeLayout mContainer;

    public e(FrsADFragment frsADFragment, View view) {
        this.hEM = frsADFragment;
        bS(view);
    }

    public a caB() {
        return this.hEX;
    }

    private void bS(View view) {
        this.mContainer = (RelativeLayout) view.findViewById(R.id.frs_ad_container);
        this.hCj = (BdTypeRecyclerView) view.findViewById(R.id.frs_ad_listview);
        this.hCj.setLayoutManager(new LinearLayoutManager(this.hCj.getContext()));
        this.hCj.setFadingEdgeLength(0);
        this.hCj.setOverScrollMode(2);
        this.hCj.setRecyclerListener(new RecyclerView.RecyclerListener() { // from class: com.baidu.tieba.frs.ad.e.1
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
        this.hCj.setOnSrollToBottomListener(this.hEM);
        this.hEX = new a(this.hEM, this.hCj);
        this.fnt = new PbListView(this.hEM.getPageContext().getPageActivity());
        this.fnt.createView();
        this.fnt.setContainerBackgroundColorResId(R.color.cp_bg_line_e);
        this.fnt.setHeight(l.getDimens(this.hEM.getActivity(), R.dimen.tbds182));
        this.fnt.setLineGone();
        this.fnt.setTextSize(R.dimen.tbfontsize33);
        this.fnt.setTextColor(an.getColor(R.color.cp_cont_j));
        this.fnt.setNoMoreTextColorId(R.color.cp_cont_e);
        this.dlv = (FrameLayout) view.findViewById(R.id.frs_ad_list_content);
        jc(false);
    }

    public void jc(boolean z) {
        if (!z) {
            u uVar = new u();
            uVar.tabId = 90;
            uVar.eSL = false;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921449, uVar));
        }
    }

    public void caC() {
        u uVar = new u();
        uVar.tabId = 90;
        uVar.eSL = false;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921449, uVar));
    }

    public BdTypeRecyclerView getListView() {
        return this.hCj;
    }

    public RelativeLayout bLT() {
        return this.mContainer;
    }

    public void nt(boolean z) {
        ab abVar = new ab();
        abVar.tabId = 90;
        abVar.ecu = z;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(9205410, abVar));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void buJ() {
        this.hCj.setNextPage(this.fnt);
        this.fnt.showEmptyView(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        this.fnt.startLoadData();
    }

    public void buK() {
        this.hCj.setNextPage(this.fnt);
        this.fnt.showEmptyView(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        this.fnt.endLoadData();
        this.fnt.setText(this.hEM.getResources().getString(R.string.list_no_more));
    }

    public void buL() {
        this.hCj.setNextPage(null);
    }

    public void nu(boolean z) {
        this.dlv.setVisibility(z ? 0 : 8);
    }

    public void startPullRefresh() {
        u uVar = new u();
        uVar.tabId = 90;
        uVar.eSL = true;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921449, uVar));
    }

    public void bZk() {
        if (this.hEX != null) {
            this.hEX.notifyDataSetChanged();
        }
    }

    public void onChangeSkinType(int i) {
        this.hEM.getBaseFragmentActivity().getLayoutMode().setNightMode(i == 1);
        this.hEM.getBaseFragmentActivity().getLayoutMode().onModeChanged(this.mContainer);
        if (this.fnt != null) {
            this.fnt.setTextColor(an.getColor(R.color.cp_cont_j));
            this.fnt.changeSkin(i);
        }
        if (this.hEX != null) {
            this.hEX.notifyDataSetChanged();
        }
    }

    public void onDestroy() {
        this.hEX.onDestory();
        this.hCj.setOnSrollToBottomListener(null);
    }

    public void setOnScrollListener(RecyclerView.OnScrollListener onScrollListener) {
        this.hCj.setOnScrollListener(onScrollListener);
    }
}
