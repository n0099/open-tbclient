package com.baidu.tieba.frs.ad;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import com.baidu.adp.lib.util.l;
import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.adp.widget.refresh.BdSwipeRefreshLayout;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.view.PbListView;
import com.baidu.tbadk.core.view.UserPhotoLayout;
import com.baidu.tbadk.core.view.j;
import com.baidu.tbadk.core.view.k;
import com.baidu.tieba.e;
import com.baidu.tieba.tbadkCore.FrsCommonImageLayout;
import com.baidu.tieba.tbadkCore.voice.PlayVoiceBnt;
/* loaded from: classes6.dex */
public class e {
    private RelativeLayout bAz;
    private PbListView bOB;
    private BdSwipeRefreshLayout bRo;
    private BdTypeRecyclerView dMD;
    private FrsADFragment dOW;
    private a dPh;
    private FrameLayout mListContainer;
    private k mPullView;

    public e(FrsADFragment frsADFragment, View view) {
        this.dOW = frsADFragment;
        aL(view);
    }

    public a aDD() {
        return this.dPh;
    }

    private void aL(View view) {
        this.bAz = (RelativeLayout) view.findViewById(e.g.frs_ad_container);
        this.dMD = (BdTypeRecyclerView) view.findViewById(e.g.frs_ad_listview);
        this.dMD.setLayoutManager(new LinearLayoutManager(this.dMD.getContext()));
        this.dMD.setFadingEdgeLength(0);
        this.dMD.setOverScrollMode(2);
        this.dMD.setRecyclerListener(new RecyclerView.RecyclerListener() { // from class: com.baidu.tieba.frs.ad.e.1
            @Override // android.support.v7.widget.RecyclerView.RecyclerListener
            public void onViewRecycled(RecyclerView.ViewHolder viewHolder) {
                View view2 = viewHolder.itemView;
                if (view2 != null) {
                    PlayVoiceBnt playVoiceBnt = (PlayVoiceBnt) view2.findViewById(e.g.abstract_voice);
                    if (playVoiceBnt != null) {
                        playVoiceBnt.reset();
                    }
                    FrsCommonImageLayout frsCommonImageLayout = (FrsCommonImageLayout) view2.findViewById(e.g.abstract_img_layout);
                    if (frsCommonImageLayout != null) {
                        frsCommonImageLayout.reset();
                    }
                    if (view2 instanceof UserPhotoLayout) {
                        ((UserPhotoLayout) view2).reset();
                    }
                }
            }
        });
        this.dMD.setOnSrollToBottomListener(this.dOW);
        this.dPh = new a(this.dOW, this.dMD);
        this.bOB = new PbListView(this.dOW.getPageContext().getPageActivity());
        this.bOB.oD();
        this.bOB.ex(e.d.cp_bg_line_e);
        this.bOB.setHeight(l.h(this.dOW.getActivity(), e.C0210e.tbds182));
        this.bOB.EZ();
        this.bOB.setTextSize(e.C0210e.tbfontsize33);
        this.bOB.setTextColor(al.getColor(e.d.cp_cont_j));
        this.bOB.ew(e.d.cp_cont_e);
        this.mPullView = new k(this.dOW.getPageContext());
        if (this.bRo == null) {
            this.bRo = (BdSwipeRefreshLayout) view.findViewById(e.g.frs_ad_pull_refresh_layout);
            this.bRo.setProgressView(this.mPullView);
            al.j(this.bRo, e.d.cp_bg_line_e);
        }
        this.mListContainer = (FrameLayout) view.findViewById(e.g.frs_ad_list_content);
        di(false);
    }

    public void a(j.b bVar) {
        this.mPullView.a(bVar);
    }

    public void di(boolean z) {
        if (!z) {
            this.bRo.setRefreshing(false);
        }
    }

    public BdTypeRecyclerView getListView() {
        return this.dMD;
    }

    public RelativeLayout aCF() {
        return this.bAz;
    }

    public View aDE() {
        return this.bRo;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void abb() {
        this.dMD.setNextPage(this.bOB);
        this.bOB.ez(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        this.bOB.Fc();
    }

    public void abc() {
        this.dMD.setNextPage(this.bOB);
        this.bOB.ez(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        this.bOB.Fd();
        this.bOB.setText(this.dOW.getResources().getString(e.j.list_no_more));
    }

    public void abd() {
        this.dMD.setNextPage(null);
    }

    public void gU(boolean z) {
        this.mListContainer.setVisibility(z ? 0 : 8);
    }

    public void startPullRefresh() {
        this.bRo.setRefreshing(true);
    }

    public void aCu() {
        if (this.dPh != null) {
            this.dPh.notifyDataSetChanged();
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mPullView != null) {
            this.mPullView.ey(i);
        }
        this.dOW.getBaseFragmentActivity().getLayoutMode().setNightMode(i == 1);
        this.dOW.getBaseFragmentActivity().getLayoutMode().onModeChanged(this.bAz);
        if (this.bOB != null) {
            this.bOB.setTextColor(al.getColor(e.d.cp_cont_j));
            this.bOB.ey(i);
        }
        al.j(this.bRo, e.d.cp_bg_line_e);
        if (this.dPh != null) {
            this.dPh.notifyDataSetChanged();
        }
    }

    public void onDestroy() {
        this.dPh.onDestory();
        this.dMD.setOnSrollToBottomListener(null);
    }
}
