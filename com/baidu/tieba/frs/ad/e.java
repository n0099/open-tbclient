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
    private FrameLayout edL;
    private PbListView gjo;
    private BdTypeRecyclerView iJX;
    private a iNA;
    private FrsADFragment iNp;
    private RelativeLayout mContainer;

    public e(FrsADFragment frsADFragment, View view) {
        this.iNp = frsADFragment;
        cw(view);
    }

    public a cAX() {
        return this.iNA;
    }

    private void cw(View view) {
        this.mContainer = (RelativeLayout) view.findViewById(R.id.frs_ad_container);
        this.iJX = (BdTypeRecyclerView) view.findViewById(R.id.frs_ad_listview);
        this.iJX.setLayoutManager(new LinearLayoutManager(this.iJX.getContext()));
        this.iJX.setFadingEdgeLength(0);
        this.iJX.setOverScrollMode(2);
        this.iJX.setRecyclerListener(new RecyclerView.RecyclerListener() { // from class: com.baidu.tieba.frs.ad.e.1
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
        this.iJX.setOnSrollToBottomListener(this.iNp);
        this.iNA = new a(this.iNp, this.iJX);
        this.gjo = new PbListView(this.iNp.getPageContext().getPageActivity());
        this.gjo.createView();
        this.gjo.setContainerBackgroundColorResId(R.color.cp_bg_line_e);
        this.gjo.setHeight(l.getDimens(this.iNp.getActivity(), R.dimen.tbds182));
        this.gjo.setLineGone();
        this.gjo.setTextSize(R.dimen.tbfontsize33);
        this.gjo.setTextColor(ap.getColor(R.color.cp_cont_j));
        this.gjo.setNoMoreTextColorId(R.color.cp_cont_e);
        this.edL = (FrameLayout) view.findViewById(R.id.frs_ad_list_content);
        lc(false);
    }

    public void lc(boolean z) {
        if (!z) {
            v vVar = new v();
            vVar.tabId = 90;
            vVar.fNU = false;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921449, vVar));
        }
    }

    public void cAY() {
        v vVar = new v();
        vVar.tabId = 90;
        vVar.fNU = false;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921449, vVar));
    }

    public BdTypeRecyclerView getListView() {
        return this.iJX;
    }

    public RelativeLayout cka() {
        return this.mContainer;
    }

    public void pQ(boolean z) {
        ad adVar = new ad();
        adVar.tabId = 90;
        adVar.eUZ = z;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(9205410, adVar));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void Wi() {
        this.iJX.setNextPage(this.gjo);
        this.gjo.showEmptyView(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        this.gjo.startLoadData();
    }

    public void Wj() {
        this.iJX.setNextPage(this.gjo);
        this.gjo.showEmptyView(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        this.gjo.endLoadData();
        this.gjo.setText(this.iNp.getResources().getString(R.string.list_no_more));
    }

    public void bPW() {
        this.iJX.setNextPage(null);
    }

    public void pR(boolean z) {
        this.edL.setVisibility(z ? 0 : 8);
    }

    public void startPullRefresh() {
        v vVar = new v();
        vVar.tabId = 90;
        vVar.fNU = true;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921449, vVar));
    }

    public void czx() {
        if (this.iNA != null) {
            this.iNA.notifyDataSetChanged();
        }
    }

    public void onChangeSkinType(int i) {
        this.iNp.getBaseFragmentActivity().getLayoutMode().setNightMode(i == 1);
        this.iNp.getBaseFragmentActivity().getLayoutMode().onModeChanged(this.mContainer);
        if (this.gjo != null) {
            this.gjo.setTextColor(ap.getColor(R.color.cp_cont_j));
            this.gjo.changeSkin(i);
        }
        if (this.iNA != null) {
            this.iNA.notifyDataSetChanged();
        }
    }

    public void onDestroy() {
        this.iNA.onDestory();
        this.iJX.setOnSrollToBottomListener(null);
    }

    public void setOnScrollListener(RecyclerView.OnScrollListener onScrollListener) {
        this.iJX.setOnScrollListener(onScrollListener);
    }
}
