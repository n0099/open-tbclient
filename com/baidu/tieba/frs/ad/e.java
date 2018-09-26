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
/* loaded from: classes2.dex */
public class e {
    private PbListView bBr;
    private BdSwipeRefreshLayout bEe;
    private RelativeLayout bsh;
    private BdTypeRecyclerView dtY;
    private a dwD;
    private FrameLayout dwQ;
    private FrsADFragment dws;
    private k mPullView;

    public e(FrsADFragment frsADFragment, View view) {
        this.dws = frsADFragment;
        aG(view);
    }

    public a ayl() {
        return this.dwD;
    }

    private void aG(View view) {
        this.bsh = (RelativeLayout) view.findViewById(e.g.frs_ad_container);
        this.dtY = (BdTypeRecyclerView) view.findViewById(e.g.frs_ad_listview);
        this.dtY.setLayoutManager(new LinearLayoutManager(this.dtY.getContext()));
        this.dtY.setFadingEdgeLength(0);
        this.dtY.setOverScrollMode(2);
        this.dtY.setRecyclerListener(new RecyclerView.RecyclerListener() { // from class: com.baidu.tieba.frs.ad.e.1
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
        this.dtY.setOnSrollToBottomListener(this.dws);
        this.dwD = new a(this.dws, this.dtY);
        this.bBr = new PbListView(this.dws.getPageContext().getPageActivity());
        this.bBr.ov();
        this.bBr.dL(e.d.cp_bg_line_e);
        this.bBr.setHeight(l.h(this.dws.getActivity(), e.C0141e.tbds182));
        this.bBr.BF();
        this.bBr.setTextSize(e.C0141e.tbfontsize33);
        this.bBr.setTextColor(al.getColor(e.d.cp_cont_j));
        this.bBr.dK(e.d.cp_cont_e);
        this.mPullView = new k(this.dws.getPageContext());
        if (this.bEe == null) {
            this.bEe = (BdSwipeRefreshLayout) view.findViewById(e.g.frs_ad_pull_refresh_layout);
            this.bEe.setProgressView(this.mPullView);
            al.j(this.bEe, e.d.cp_bg_line_e);
        }
        this.dwQ = (FrameLayout) view.findViewById(e.g.frs_ad_list_content);
        cH(false);
    }

    public void a(j.b bVar) {
        this.mPullView.a(bVar);
    }

    public void cH(boolean z) {
        if (!z) {
            this.bEe.setRefreshing(false);
        }
    }

    public BdTypeRecyclerView getListView() {
        return this.dtY;
    }

    public RelativeLayout axn() {
        return this.bsh;
    }

    public View aym() {
        return this.bEe;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void Wb() {
        this.dtY.setNextPage(this.bBr);
        this.bBr.dN(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        this.bBr.BI();
    }

    public void Wc() {
        this.dtY.setNextPage(this.bBr);
        this.bBr.dN(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        this.bBr.BJ();
        this.bBr.setText(this.dws.getResources().getString(e.j.list_no_more));
    }

    public void Wd() {
        this.dtY.setNextPage(null);
    }

    public void go(boolean z) {
        this.dwQ.setVisibility(z ? 0 : 8);
    }

    public void startPullRefresh() {
        this.bEe.setRefreshing(true);
    }

    public void axc() {
        if (this.dwD != null) {
            this.dwD.notifyDataSetChanged();
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mPullView != null) {
            this.mPullView.dM(i);
        }
        this.dws.getBaseFragmentActivity().getLayoutMode().setNightMode(i == 1);
        this.dws.getBaseFragmentActivity().getLayoutMode().onModeChanged(this.bsh);
        if (this.bBr != null) {
            this.bBr.setTextColor(al.getColor(e.d.cp_cont_j));
            this.bBr.dM(i);
        }
        al.j(this.bEe, e.d.cp_bg_line_e);
        if (this.dwD != null) {
            this.dwD.notifyDataSetChanged();
        }
    }

    public void onDestroy() {
        this.dwD.onDestory();
        this.dtY.setOnSrollToBottomListener(null);
    }
}
