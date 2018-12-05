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
    private RelativeLayout bAw;
    private PbListView bOy;
    private BdSwipeRefreshLayout bRl;
    private BdTypeRecyclerView dJP;
    private FrsADFragment dMi;
    private a dMt;
    private FrameLayout mListContainer;
    private k mPullView;

    public e(FrsADFragment frsADFragment, View view) {
        this.dMi = frsADFragment;
        aI(view);
    }

    public a aCO() {
        return this.dMt;
    }

    private void aI(View view) {
        this.bAw = (RelativeLayout) view.findViewById(e.g.frs_ad_container);
        this.dJP = (BdTypeRecyclerView) view.findViewById(e.g.frs_ad_listview);
        this.dJP.setLayoutManager(new LinearLayoutManager(this.dJP.getContext()));
        this.dJP.setFadingEdgeLength(0);
        this.dJP.setOverScrollMode(2);
        this.dJP.setRecyclerListener(new RecyclerView.RecyclerListener() { // from class: com.baidu.tieba.frs.ad.e.1
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
        this.dJP.setOnSrollToBottomListener(this.dMi);
        this.dMt = new a(this.dMi, this.dJP);
        this.bOy = new PbListView(this.dMi.getPageContext().getPageActivity());
        this.bOy.oD();
        this.bOy.ex(e.d.cp_bg_line_e);
        this.bOy.setHeight(l.h(this.dMi.getActivity(), e.C0210e.tbds182));
        this.bOy.EZ();
        this.bOy.setTextSize(e.C0210e.tbfontsize33);
        this.bOy.setTextColor(al.getColor(e.d.cp_cont_j));
        this.bOy.ew(e.d.cp_cont_e);
        this.mPullView = new k(this.dMi.getPageContext());
        if (this.bRl == null) {
            this.bRl = (BdSwipeRefreshLayout) view.findViewById(e.g.frs_ad_pull_refresh_layout);
            this.bRl.setProgressView(this.mPullView);
            al.j(this.bRl, e.d.cp_bg_line_e);
        }
        this.mListContainer = (FrameLayout) view.findViewById(e.g.frs_ad_list_content);
        di(false);
    }

    public void a(j.b bVar) {
        this.mPullView.a(bVar);
    }

    public void di(boolean z) {
        if (!z) {
            this.bRl.setRefreshing(false);
        }
    }

    public BdTypeRecyclerView getListView() {
        return this.dJP;
    }

    public RelativeLayout aBQ() {
        return this.bAw;
    }

    public View aCP() {
        return this.bRl;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void aaZ() {
        this.dJP.setNextPage(this.bOy);
        this.bOy.ez(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        this.bOy.Fc();
    }

    public void aba() {
        this.dJP.setNextPage(this.bOy);
        this.bOy.ez(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        this.bOy.Fd();
        this.bOy.setText(this.dMi.getResources().getString(e.j.list_no_more));
    }

    public void abb() {
        this.dJP.setNextPage(null);
    }

    public void gR(boolean z) {
        this.mListContainer.setVisibility(z ? 0 : 8);
    }

    public void startPullRefresh() {
        this.bRl.setRefreshing(true);
    }

    public void aBF() {
        if (this.dMt != null) {
            this.dMt.notifyDataSetChanged();
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mPullView != null) {
            this.mPullView.ey(i);
        }
        this.dMi.getBaseFragmentActivity().getLayoutMode().setNightMode(i == 1);
        this.dMi.getBaseFragmentActivity().getLayoutMode().onModeChanged(this.bAw);
        if (this.bOy != null) {
            this.bOy.setTextColor(al.getColor(e.d.cp_cont_j));
            this.bOy.ey(i);
        }
        al.j(this.bRl, e.d.cp_bg_line_e);
        if (this.dMt != null) {
            this.dMt.notifyDataSetChanged();
        }
    }

    public void onDestroy() {
        this.dMt.onDestory();
        this.dJP.setOnSrollToBottomListener(null);
    }
}
