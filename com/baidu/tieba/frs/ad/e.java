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
    private PbListView fcj;
    private BdTypeRecyclerView hpz;
    private FrsADFragment hrW;
    private a hsh;
    private RelativeLayout mContainer;

    public e(FrsADFragment frsADFragment, View view) {
        this.hrW = frsADFragment;
        bP(view);
    }

    public a bXp() {
        return this.hsh;
    }

    private void bP(View view) {
        this.mContainer = (RelativeLayout) view.findViewById(R.id.frs_ad_container);
        this.hpz = (BdTypeRecyclerView) view.findViewById(R.id.frs_ad_listview);
        this.hpz.setLayoutManager(new LinearLayoutManager(this.hpz.getContext()));
        this.hpz.setFadingEdgeLength(0);
        this.hpz.setOverScrollMode(2);
        this.hpz.setRecyclerListener(new RecyclerView.RecyclerListener() { // from class: com.baidu.tieba.frs.ad.e.1
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
        this.hpz.setOnSrollToBottomListener(this.hrW);
        this.hsh = new a(this.hrW, this.hpz);
        this.fcj = new PbListView(this.hrW.getPageContext().getPageActivity());
        this.fcj.createView();
        this.fcj.setContainerBackgroundColorResId(R.color.cp_bg_line_e);
        this.fcj.setHeight(l.getDimens(this.hrW.getActivity(), R.dimen.tbds182));
        this.fcj.setLineGone();
        this.fcj.setTextSize(R.dimen.tbfontsize33);
        this.fcj.setTextColor(am.getColor(R.color.cp_cont_j));
        this.fcj.setNoMoreTextColorId(R.color.cp_cont_e);
        this.dgJ = (FrameLayout) view.findViewById(R.id.frs_ad_list_content);
        iQ(false);
    }

    public void iQ(boolean z) {
        if (!z) {
            s sVar = new s();
            sVar.tabId = 90;
            sVar.eIz = false;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921449, sVar));
        }
    }

    public void bXq() {
        s sVar = new s();
        sVar.tabId = 90;
        sVar.eIz = false;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921449, sVar));
    }

    public BdTypeRecyclerView getListView() {
        return this.hpz;
    }

    public RelativeLayout bIN() {
        return this.mContainer;
    }

    public void ni(boolean z) {
        y yVar = new y();
        yVar.tabId = 90;
        yVar.dVd = z;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(9205410, yVar));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void brM() {
        this.hpz.setNextPage(this.fcj);
        this.fcj.showEmptyView(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        this.fcj.startLoadData();
    }

    public void brN() {
        this.hpz.setNextPage(this.fcj);
        this.fcj.showEmptyView(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        this.fcj.endLoadData();
        this.fcj.setText(this.hrW.getResources().getString(R.string.list_no_more));
    }

    public void brO() {
        this.hpz.setNextPage(null);
    }

    public void nj(boolean z) {
        this.dgJ.setVisibility(z ? 0 : 8);
    }

    public void startPullRefresh() {
        s sVar = new s();
        sVar.tabId = 90;
        sVar.eIz = true;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921449, sVar));
    }

    public void bWb() {
        if (this.hsh != null) {
            this.hsh.notifyDataSetChanged();
        }
    }

    public void onChangeSkinType(int i) {
        this.hrW.getBaseFragmentActivity().getLayoutMode().setNightMode(i == 1);
        this.hrW.getBaseFragmentActivity().getLayoutMode().onModeChanged(this.mContainer);
        if (this.fcj != null) {
            this.fcj.setTextColor(am.getColor(R.color.cp_cont_j));
            this.fcj.changeSkin(i);
        }
        if (this.hsh != null) {
            this.hsh.notifyDataSetChanged();
        }
    }

    public void onDestroy() {
        this.hsh.onDestory();
        this.hpz.setOnSrollToBottomListener(null);
    }

    public void setOnScrollListener(RecyclerView.OnScrollListener onScrollListener) {
        this.hpz.setOnScrollListener(onScrollListener);
    }
}
