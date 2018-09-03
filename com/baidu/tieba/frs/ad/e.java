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
import com.baidu.tieba.f;
import com.baidu.tieba.tbadkCore.FrsCommonImageLayout;
import com.baidu.tieba.tbadkCore.voice.PlayVoiceBnt;
/* loaded from: classes2.dex */
public class e {
    private RelativeLayout bmt;
    private PbListView bvC;
    private BdSwipeRefreshLayout byp;
    private BdTypeRecyclerView doa;
    private FrameLayout dqC;
    private FrsADFragment dqe;
    private a dqp;
    private h mPullView;

    public e(FrsADFragment frsADFragment, View view) {
        this.dqe = frsADFragment;
        as(view);
    }

    public a awa() {
        return this.dqp;
    }

    private void as(View view) {
        this.bmt = (RelativeLayout) view.findViewById(f.g.frs_ad_container);
        this.doa = (BdTypeRecyclerView) view.findViewById(f.g.frs_ad_listview);
        this.doa.setLayoutManager(new LinearLayoutManager(this.doa.getContext()));
        this.doa.setFadingEdgeLength(0);
        this.doa.setOverScrollMode(2);
        this.doa.setRecyclerListener(new RecyclerView.RecyclerListener() { // from class: com.baidu.tieba.frs.ad.e.1
            @Override // android.support.v7.widget.RecyclerView.RecyclerListener
            public void onViewRecycled(RecyclerView.ViewHolder viewHolder) {
                View view2 = viewHolder.itemView;
                if (view2 != null) {
                    PlayVoiceBnt playVoiceBnt = (PlayVoiceBnt) view2.findViewById(f.g.abstract_voice);
                    if (playVoiceBnt != null) {
                        playVoiceBnt.reset();
                    }
                    FrsCommonImageLayout frsCommonImageLayout = (FrsCommonImageLayout) view2.findViewById(f.g.abstract_img_layout);
                    if (frsCommonImageLayout != null) {
                        frsCommonImageLayout.reset();
                    }
                    if (view2 instanceof UserPhotoLayout) {
                        ((UserPhotoLayout) view2).reset();
                    }
                }
            }
        });
        this.doa.setOnSrollToBottomListener(this.dqe);
        this.dqp = new a(this.dqe, this.doa);
        this.bvC = new PbListView(this.dqe.getPageContext().getPageActivity());
        this.bvC.np();
        this.bvC.dA(f.d.cp_bg_line_e);
        this.bvC.setHeight(l.f(this.dqe.getActivity(), f.e.tbds182));
        this.bvC.As();
        this.bvC.setTextSize(f.e.tbfontsize33);
        this.bvC.setTextColor(am.getColor(f.d.cp_cont_j));
        this.bvC.dz(f.d.cp_cont_e);
        this.mPullView = new h(this.dqe.getPageContext());
        if (this.byp == null) {
            this.byp = (BdSwipeRefreshLayout) view.findViewById(f.g.frs_ad_pull_refresh_layout);
            this.byp.setProgressView(this.mPullView);
            am.j(this.byp, f.d.cp_bg_line_e);
        }
        this.dqC = (FrameLayout) view.findViewById(f.g.frs_ad_list_content);
        cq(false);
    }

    public void a(g.b bVar) {
        this.mPullView.a(bVar);
    }

    public void cq(boolean z) {
        if (!z) {
            this.byp.setRefreshing(false);
        }
    }

    public BdTypeRecyclerView getListView() {
        return this.doa;
    }

    public RelativeLayout awb() {
        return this.bmt;
    }

    public View awc() {
        return this.byp;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void Uo() {
        this.doa.setNextPage(this.bvC);
        this.bvC.dC(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        this.bvC.Av();
    }

    public void Up() {
        this.doa.setNextPage(this.bvC);
        this.bvC.dC(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        this.bvC.Aw();
        this.bvC.setText(this.dqe.getResources().getString(f.j.list_no_more));
    }

    public void Uq() {
        this.doa.setNextPage(null);
    }

    public void fR(boolean z) {
        this.dqC.setVisibility(z ? 0 : 8);
    }

    public void startPullRefresh() {
        this.byp.setRefreshing(true);
    }

    public void avj() {
        if (this.dqp != null) {
            this.dqp.notifyDataSetChanged();
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mPullView != null) {
            this.mPullView.dB(i);
        }
        this.dqe.getBaseFragmentActivity().getLayoutMode().setNightMode(i == 1);
        this.dqe.getBaseFragmentActivity().getLayoutMode().onModeChanged(this.bmt);
        if (this.bvC != null) {
            this.bvC.setTextColor(am.getColor(f.d.cp_cont_j));
            this.bvC.dB(i);
        }
        am.j(this.byp, f.d.cp_bg_line_e);
        if (this.dqp != null) {
            this.dqp.notifyDataSetChanged();
        }
    }

    public void onDestroy() {
        this.dqp.onDestory();
        this.doa.setOnSrollToBottomListener(null);
    }
}
