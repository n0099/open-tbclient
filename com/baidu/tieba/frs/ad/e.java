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
    private RelativeLayout bmp;
    private PbListView bvA;
    private BdSwipeRefreshLayout byn;
    private BdTypeRecyclerView dod;
    private FrameLayout dqE;
    private FrsADFragment dqg;
    private a dqr;
    private h mPullView;

    public e(FrsADFragment frsADFragment, View view) {
        this.dqg = frsADFragment;
        as(view);
    }

    public a awb() {
        return this.dqr;
    }

    private void as(View view) {
        this.bmp = (RelativeLayout) view.findViewById(d.g.frs_ad_container);
        this.dod = (BdTypeRecyclerView) view.findViewById(d.g.frs_ad_listview);
        this.dod.setLayoutManager(new LinearLayoutManager(this.dod.getContext()));
        this.dod.setFadingEdgeLength(0);
        this.dod.setOverScrollMode(2);
        this.dod.setRecyclerListener(new RecyclerView.RecyclerListener() { // from class: com.baidu.tieba.frs.ad.e.1
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
        this.dod.setOnSrollToBottomListener(this.dqg);
        this.dqr = new a(this.dqg, this.dod);
        this.bvA = new PbListView(this.dqg.getPageContext().getPageActivity());
        this.bvA.np();
        this.bvA.dB(d.C0140d.cp_bg_line_e);
        this.bvA.setHeight(l.f(this.dqg.getActivity(), d.e.tbds182));
        this.bvA.Au();
        this.bvA.setTextSize(d.e.tbfontsize33);
        this.bvA.setTextColor(am.getColor(d.C0140d.cp_cont_j));
        this.bvA.dA(d.C0140d.cp_cont_e);
        this.mPullView = new h(this.dqg.getPageContext());
        if (this.byn == null) {
            this.byn = (BdSwipeRefreshLayout) view.findViewById(d.g.frs_ad_pull_refresh_layout);
            this.byn.setProgressView(this.mPullView);
            am.j(this.byn, d.C0140d.cp_bg_line_e);
        }
        this.dqE = (FrameLayout) view.findViewById(d.g.frs_ad_list_content);
        cp(false);
    }

    public void a(g.b bVar) {
        this.mPullView.a(bVar);
    }

    public void cp(boolean z) {
        if (!z) {
            this.byn.setRefreshing(false);
        }
    }

    public BdTypeRecyclerView getListView() {
        return this.dod;
    }

    public RelativeLayout awc() {
        return this.bmp;
    }

    public View awd() {
        return this.byn;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void Ul() {
        this.dod.setNextPage(this.bvA);
        this.bvA.dD(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        this.bvA.Ax();
    }

    public void Um() {
        this.dod.setNextPage(this.bvA);
        this.bvA.dD(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        this.bvA.Ay();
        this.bvA.setText(this.dqg.getResources().getString(d.j.list_no_more));
    }

    public void Un() {
        this.dod.setNextPage(null);
    }

    public void fR(boolean z) {
        this.dqE.setVisibility(z ? 0 : 8);
    }

    public void startPullRefresh() {
        this.byn.setRefreshing(true);
    }

    public void avk() {
        if (this.dqr != null) {
            this.dqr.notifyDataSetChanged();
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mPullView != null) {
            this.mPullView.dC(i);
        }
        this.dqg.getBaseFragmentActivity().getLayoutMode().setNightMode(i == 1);
        this.dqg.getBaseFragmentActivity().getLayoutMode().onModeChanged(this.bmp);
        if (this.bvA != null) {
            this.bvA.setTextColor(am.getColor(d.C0140d.cp_cont_j));
            this.bvA.dC(i);
        }
        am.j(this.byn, d.C0140d.cp_bg_line_e);
        if (this.dqr != null) {
            this.dqr.notifyDataSetChanged();
        }
    }

    public void onDestroy() {
        this.dqr.onDestory();
        this.dod.setOnSrollToBottomListener(null);
    }
}
