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
import com.baidu.tbadk.core.view.h;
import com.baidu.tbadk.core.view.i;
import com.baidu.tieba.R;
import com.baidu.tieba.tbadkCore.FrsCommonImageLayout;
import com.baidu.tieba.tbadkCore.voice.PlayVoiceBnt;
/* loaded from: classes4.dex */
public class e {
    private FrameLayout boy;
    private RelativeLayout cWk;
    private PbListView dnN;
    private BdSwipeRefreshLayout dpp;
    private BdTypeRecyclerView fws;
    private FrsADFragment fyX;
    private a fzi;
    private i mPullView;

    public e(FrsADFragment frsADFragment, View view) {
        this.fyX = frsADFragment;
        bN(view);
    }

    public a boo() {
        return this.fzi;
    }

    private void bN(View view) {
        this.cWk = (RelativeLayout) view.findViewById(R.id.frs_ad_container);
        this.fws = (BdTypeRecyclerView) view.findViewById(R.id.frs_ad_listview);
        this.fws.setLayoutManager(new LinearLayoutManager(this.fws.getContext()));
        this.fws.setFadingEdgeLength(0);
        this.fws.setOverScrollMode(2);
        this.fws.setRecyclerListener(new RecyclerView.RecyclerListener() { // from class: com.baidu.tieba.frs.ad.e.1
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
        this.fws.setOnSrollToBottomListener(this.fyX);
        this.fzi = new a(this.fyX, this.fws);
        this.dnN = new PbListView(this.fyX.getPageContext().getPageActivity());
        this.dnN.nZ();
        this.dnN.iU(R.color.cp_bg_line_e);
        this.dnN.setHeight(l.g(this.fyX.getActivity(), R.dimen.tbds182));
        this.dnN.akC();
        this.dnN.setTextSize(R.dimen.tbfontsize33);
        this.dnN.setTextColor(am.getColor(R.color.cp_cont_j));
        this.dnN.iT(R.color.cp_cont_e);
        this.mPullView = new i(this.fyX.getPageContext());
        if (this.dpp == null) {
            this.dpp = (BdSwipeRefreshLayout) view.findViewById(R.id.frs_ad_pull_refresh_layout);
            this.dpp.setProgressView(this.mPullView);
            am.l(this.dpp, R.color.cp_bg_line_e);
        }
        this.boy = (FrameLayout) view.findViewById(R.id.frs_ad_list_content);
        gc(false);
    }

    public void setListPullRefreshListener(h.c cVar) {
        this.mPullView.setListPullRefreshListener(cVar);
    }

    public void gc(boolean z) {
        if (!z) {
            this.dpp.setRefreshing(false);
        }
    }

    public BdTypeRecyclerView getListView() {
        return this.fws;
    }

    public RelativeLayout aXA() {
        return this.cWk;
    }

    public View bop() {
        return this.dpp;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void aKk() {
        this.fws.setNextPage(this.dnN);
        this.dnN.iW(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        this.dnN.akF();
    }

    public void aKl() {
        this.fws.setNextPage(this.dnN);
        this.dnN.iW(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        this.dnN.akG();
        this.dnN.setText(this.fyX.getResources().getString(R.string.list_no_more));
    }

    public void aKm() {
        this.fws.setNextPage(null);
    }

    public void kp(boolean z) {
        this.boy.setVisibility(z ? 0 : 8);
    }

    public void startPullRefresh() {
        this.dpp.setRefreshing(true);
    }

    public void bnc() {
        if (this.fzi != null) {
            this.fzi.notifyDataSetChanged();
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mPullView != null) {
            this.mPullView.iV(i);
        }
        this.fyX.getBaseFragmentActivity().getLayoutMode().setNightMode(i == 1);
        this.fyX.getBaseFragmentActivity().getLayoutMode().onModeChanged(this.cWk);
        if (this.dnN != null) {
            this.dnN.setTextColor(am.getColor(R.color.cp_cont_j));
            this.dnN.iV(i);
        }
        am.l(this.dpp, R.color.cp_bg_line_e);
        if (this.fzi != null) {
            this.fzi.notifyDataSetChanged();
        }
    }

    public void onDestroy() {
        this.fzi.onDestory();
        this.fws.setOnSrollToBottomListener(null);
    }
}
