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
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.view.PbListView;
import com.baidu.tbadk.core.view.UserPhotoLayout;
import com.baidu.tbadk.core.view.g;
import com.baidu.tbadk.core.view.h;
import com.baidu.tieba.d;
import com.baidu.tieba.tbadkCore.FrsCommonImageLayout;
import com.baidu.tieba.tbadkCore.voice.PlayVoiceBnt;
/* loaded from: classes2.dex */
public class e {
    private RelativeLayout blJ;
    private PbListView buU;
    private BdSwipeRefreshLayout bxI;
    private BdTypeRecyclerView dll;
    private FrameLayout dnL;
    private FrsADFragment dnm;
    private a dny;
    private h mPullView;

    public e(FrsADFragment frsADFragment, View view) {
        this.dnm = frsADFragment;
        ap(view);
    }

    public a avw() {
        return this.dny;
    }

    private void ap(View view) {
        this.blJ = (RelativeLayout) view.findViewById(d.g.frs_ad_container);
        this.dll = (BdTypeRecyclerView) view.findViewById(d.g.frs_ad_listview);
        this.dll.setLayoutManager(new LinearLayoutManager(this.dll.getContext()));
        this.dll.setFadingEdgeLength(0);
        this.dll.setOverScrollMode(2);
        this.dll.setRecyclerListener(new RecyclerView.RecyclerListener() { // from class: com.baidu.tieba.frs.ad.e.1
            @Override // android.support.v7.widget.RecyclerView.RecyclerListener
            public void onViewRecycled(RecyclerView.ViewHolder viewHolder) {
                View view2 = viewHolder.itemView;
                if (view2 != null) {
                    PlayVoiceBnt playVoiceBnt = (PlayVoiceBnt) view2.findViewById(d.g.abstract_voice);
                    if (playVoiceBnt != null) {
                        playVoiceBnt.reset();
                    }
                    FrsCommonImageLayout frsCommonImageLayout = (FrsCommonImageLayout) view2.findViewById(d.g.abstract_img_layout);
                    if (frsCommonImageLayout != null) {
                        frsCommonImageLayout.reset();
                    }
                    if (view2 instanceof UserPhotoLayout) {
                        ((UserPhotoLayout) view2).reset();
                    }
                }
            }
        });
        this.dll.setOnSrollToBottomListener(this.dnm);
        this.dny = new a(this.dnm, this.dll);
        this.buU = new PbListView(this.dnm.getPageContext().getPageActivity());
        this.buU.nn();
        this.buU.dy(d.C0142d.cp_bg_line_e);
        this.buU.setHeight(l.e(this.dnm.getActivity(), d.e.tbds182));
        this.buU.AE();
        this.buU.setTextSize(d.e.tbfontsize33);
        this.buU.setTextColor(am.getColor(d.C0142d.cp_cont_j));
        this.buU.dx(d.C0142d.cp_cont_e);
        this.mPullView = new h(this.dnm.getPageContext());
        if (this.bxI == null) {
            this.bxI = (BdSwipeRefreshLayout) view.findViewById(d.g.frs_ad_pull_refresh_layout);
            this.bxI.setProgressView(this.mPullView);
            am.j(this.bxI, d.C0142d.cp_bg_line_e);
        }
        this.dnL = (FrameLayout) view.findViewById(d.g.frs_ad_list_content);
        cp(false);
    }

    public void a(g.b bVar) {
        this.mPullView.a(bVar);
    }

    public void cp(boolean z) {
        if (!z) {
            this.bxI.setRefreshing(false);
        }
    }

    public BdTypeRecyclerView getListView() {
        return this.dll;
    }

    public RelativeLayout avx() {
        return this.blJ;
    }

    public View avy() {
        return this.bxI;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void Ud() {
        this.dll.setNextPage(this.buU);
        this.buU.dA(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        this.buU.AH();
    }

    public void Ue() {
        this.dll.setNextPage(this.buU);
        this.buU.dA(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        this.buU.AI();
        this.buU.setText(this.dnm.getResources().getString(d.k.list_no_more));
    }

    public void Uf() {
        this.dll.setNextPage(null);
    }

    public void fP(boolean z) {
        this.dnL.setVisibility(z ? 0 : 8);
    }

    public void startPullRefresh() {
        this.bxI.setRefreshing(true);
    }

    public void auG() {
        if (this.dny != null) {
            this.dny.notifyDataSetChanged();
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mPullView != null) {
            this.mPullView.dz(i);
        }
        this.dnm.getBaseFragmentActivity().getLayoutMode().setNightMode(i == 1);
        this.dnm.getBaseFragmentActivity().getLayoutMode().onModeChanged(this.blJ);
        if (this.buU != null) {
            this.buU.setTextColor(am.getColor(d.C0142d.cp_cont_j));
            this.buU.dz(i);
        }
        am.j(this.bxI, d.C0142d.cp_bg_line_e);
        if (this.dny != null) {
            this.dny.notifyDataSetChanged();
        }
    }

    public void onDestroy() {
        this.dny.onDestory();
        this.dll.setOnSrollToBottomListener(null);
    }
}
