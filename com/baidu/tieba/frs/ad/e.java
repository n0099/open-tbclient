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
    private FrameLayout esi;
    private PbListView gCf;
    private BdTypeRecyclerView jhR;
    private FrsADFragment jli;
    private a jlt;
    private RelativeLayout mContainer;

    public e(FrsADFragment frsADFragment, View view) {
        this.jli = frsADFragment;
        cR(view);
    }

    public a cHM() {
        return this.jlt;
    }

    private void cR(View view) {
        this.mContainer = (RelativeLayout) view.findViewById(R.id.frs_ad_container);
        this.jhR = (BdTypeRecyclerView) view.findViewById(R.id.frs_ad_listview);
        this.jhR.setLayoutManager(new LinearLayoutManager(this.jhR.getContext()));
        this.jhR.setFadingEdgeLength(0);
        this.jhR.setOverScrollMode(2);
        this.jhR.setRecyclerListener(new RecyclerView.RecyclerListener() { // from class: com.baidu.tieba.frs.ad.e.1
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
        this.jhR.setOnSrollToBottomListener(this.jli);
        this.jlt = new a(this.jli, this.jhR);
        this.gCf = new PbListView(this.jli.getPageContext().getPageActivity());
        this.gCf.createView();
        this.gCf.setContainerBackgroundColorResId(R.color.CAM_X0205);
        this.gCf.setHeight(l.getDimens(this.jli.getActivity(), R.dimen.tbds182));
        this.gCf.setLineGone();
        this.gCf.setTextSize(R.dimen.tbfontsize33);
        this.gCf.setTextColor(ao.getColor(R.color.CAM_X0107));
        this.gCf.setNoMoreTextColorId(R.color.CAM_X0110);
        this.esi = (FrameLayout) view.findViewById(R.id.frs_ad_list_content);
        lU(false);
    }

    public void lU(boolean z) {
        if (!z) {
            t tVar = new t();
            tVar.tabId = 90;
            tVar.geO = false;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921449, tVar));
        }
    }

    public void cHN() {
        t tVar = new t();
        tVar.tabId = 90;
        tVar.geO = false;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921449, tVar));
    }

    public BdTypeRecyclerView getListView() {
        return this.jhR;
    }

    public RelativeLayout cqg() {
        return this.mContainer;
    }

    public void qO(boolean z) {
        z zVar = new z();
        zVar.tabId = 90;
        zVar.fln = z;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(9205410, zVar));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void Zg() {
        this.jhR.setNextPage(this.gCf);
        this.gCf.showEmptyView(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        this.gCf.startLoadData();
    }

    public void Zh() {
        this.jhR.setNextPage(this.gCf);
        this.gCf.showEmptyView(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        this.gCf.endLoadData();
        this.gCf.setText(this.jli.getResources().getString(R.string.list_no_more));
    }

    public void bVF() {
        this.jhR.setNextPage(null);
    }

    public void qP(boolean z) {
        this.esi.setVisibility(z ? 0 : 8);
    }

    public void startPullRefresh() {
        t tVar = new t();
        tVar.tabId = 90;
        tVar.geO = true;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921449, tVar));
    }

    public void cGm() {
        if (this.jlt != null) {
            this.jlt.notifyDataSetChanged();
        }
    }

    public void onChangeSkinType(int i) {
        this.jli.getBaseFragmentActivity().getLayoutMode().setNightMode(i == 1);
        this.jli.getBaseFragmentActivity().getLayoutMode().onModeChanged(this.mContainer);
        if (this.gCf != null) {
            this.gCf.setTextColor(ao.getColor(R.color.CAM_X0107));
            this.gCf.changeSkin(i);
        }
        if (this.jlt != null) {
            this.jlt.notifyDataSetChanged();
        }
    }

    public void onDestroy() {
        this.jlt.onDestory();
        this.jhR.setOnSrollToBottomListener(null);
    }

    public void setOnScrollListener(RecyclerView.OnScrollListener onScrollListener) {
        this.jhR.setOnScrollListener(onScrollListener);
    }
}
