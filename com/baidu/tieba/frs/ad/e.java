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
    private PbListView gAw;
    private BdTypeRecyclerView jjf;
    private a jmI;
    private FrsADFragment jmx;
    private RelativeLayout mContainer;

    public e(FrsADFragment frsADFragment, View view) {
        this.jmx = frsADFragment;
        cP(view);
    }

    public a cFo() {
        return this.jmI;
    }

    private void cP(View view) {
        this.mContainer = (RelativeLayout) view.findViewById(R.id.frs_ad_container);
        this.jjf = (BdTypeRecyclerView) view.findViewById(R.id.frs_ad_listview);
        this.jjf.setLayoutManager(new LinearLayoutManager(this.jjf.getContext()));
        this.jjf.setFadingEdgeLength(0);
        this.jjf.setOverScrollMode(2);
        this.jjf.setRecyclerListener(new RecyclerView.RecyclerListener() { // from class: com.baidu.tieba.frs.ad.e.1
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
        this.jjf.setOnSrollToBottomListener(this.jmx);
        this.jmI = new a(this.jmx, this.jjf);
        this.gAw = new PbListView(this.jmx.getPageContext().getPageActivity());
        this.gAw.createView();
        this.gAw.setContainerBackgroundColorResId(R.color.CAM_X0205);
        this.gAw.setHeight(l.getDimens(this.jmx.getActivity(), R.dimen.tbds182));
        this.gAw.setLineGone();
        this.gAw.setTextSize(R.dimen.tbfontsize33);
        this.gAw.setTextColor(ap.getColor(R.color.CAM_X0107));
        this.gAw.setNoMoreTextColorId(R.color.CAM_X0110);
        this.epC = (FrameLayout) view.findViewById(R.id.frs_ad_list_content);
        lU(false);
    }

    public void lU(boolean z) {
        if (!z) {
            t tVar = new t();
            tVar.tabId = 90;
            tVar.gcC = false;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921449, tVar));
        }
    }

    public void cFp() {
        t tVar = new t();
        tVar.tabId = 90;
        tVar.gcC = false;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921449, tVar));
    }

    public BdTypeRecyclerView getListView() {
        return this.jjf;
    }

    public RelativeLayout cnu() {
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
        this.jjf.setNextPage(this.gAw);
        this.gAw.showEmptyView(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        this.gAw.startLoadData();
    }

    public void WY() {
        this.jjf.setNextPage(this.gAw);
        this.gAw.showEmptyView(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        this.gAw.endLoadData();
        this.gAw.setText(this.jmx.getResources().getString(R.string.list_no_more));
    }

    public void bSy() {
        this.jjf.setNextPage(null);
    }

    public void qV(boolean z) {
        this.epC.setVisibility(z ? 0 : 8);
    }

    public void startPullRefresh() {
        t tVar = new t();
        tVar.tabId = 90;
        tVar.gcC = true;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921449, tVar));
    }

    public void cDO() {
        if (this.jmI != null) {
            this.jmI.notifyDataSetChanged();
        }
    }

    public void onChangeSkinType(int i) {
        this.jmx.getBaseFragmentActivity().getLayoutMode().setNightMode(i == 1);
        this.jmx.getBaseFragmentActivity().getLayoutMode().onModeChanged(this.mContainer);
        if (this.gAw != null) {
            this.gAw.setTextColor(ap.getColor(R.color.CAM_X0107));
            this.gAw.changeSkin(i);
        }
        if (this.jmI != null) {
            this.jmI.notifyDataSetChanged();
        }
    }

    public void onDestroy() {
        this.jmI.onDestory();
        this.jjf.setOnSrollToBottomListener(null);
    }

    public void setOnScrollListener(RecyclerView.OnScrollListener onScrollListener) {
        this.jjf.setOnScrollListener(onScrollListener);
    }
}
