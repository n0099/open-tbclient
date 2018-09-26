package com.baidu.tieba.frs.dynamic;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import com.baidu.adp.lib.util.l;
import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.adp.widget.ListView.h;
import com.baidu.adp.widget.ListView.n;
import com.baidu.adp.widget.refresh.BdSwipeRefreshLayout;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.core.view.PbListView;
import com.baidu.tbadk.core.view.UserPhotoLayout;
import com.baidu.tbadk.core.view.j;
import com.baidu.tbadk.core.view.k;
import com.baidu.tieba.e;
import com.baidu.tieba.frs.m;
import com.baidu.tieba.tbadkCore.FrsCommonImageLayout;
import com.baidu.tieba.tbadkCore.voice.PlayVoiceBnt;
import java.util.ArrayList;
/* loaded from: classes2.dex */
public class c {
    private PbListView bBr;
    private BdSwipeRefreshLayout bEe;
    private RelativeLayout bsh;
    private BdTypeRecyclerView dtY;
    private FrameLayout dwQ;
    private FrsDynamicFragment dzg;
    private a dzy;
    private k mPullView;

    public c(FrsDynamicFragment frsDynamicFragment, View view) {
        this.dzg = frsDynamicFragment;
        aG(view);
    }

    private void aG(View view) {
        this.bsh = (RelativeLayout) view.findViewById(e.g.frs_dynamic_container);
        this.dtY = (BdTypeRecyclerView) view.findViewById(e.g.frs_dynamic_lv_thread);
        this.dtY.setLayoutManager(new LinearLayoutManager(this.dtY.getContext()));
        this.dtY.setFadingEdgeLength(0);
        this.dtY.setOverScrollMode(2);
        this.mPullView = new k(this.dzg.getPageContext());
        this.dtY.setRecyclerListener(new RecyclerView.RecyclerListener() { // from class: com.baidu.tieba.frs.dynamic.c.1
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
        this.bBr = new PbListView(this.dzg.getPageContext().getPageActivity());
        this.bBr.ov();
        this.bBr.dL(e.d.cp_bg_line_e);
        this.bBr.setHeight(l.h(this.dzg.getActivity(), e.C0141e.tbds182));
        this.bBr.BF();
        this.bBr.setTextSize(e.C0141e.tbfontsize33);
        this.bBr.setTextColor(al.getColor(e.d.cp_cont_j));
        this.bBr.dK(e.d.cp_cont_e);
        this.dtY.setOnSrollToBottomListener(this.dzg);
        if (this.bEe == null) {
            this.bEe = (BdSwipeRefreshLayout) view.findViewById(e.g.frs_dynamic_pull_refresh_layout);
            this.bEe.setProgressView(this.mPullView);
            al.j(this.bEe, e.d.cp_bg_line_e);
        }
        this.dwQ = (FrameLayout) view.findViewById(e.g.frs_dynamic_list_content);
        this.dzy = new a(this.dzg, this.dtY);
        cH(false);
    }

    public void a(j.b bVar) {
        this.mPullView.a(bVar);
    }

    public void setOnAdapterItemClickListener(n nVar) {
        this.dzy.setOnAdapterItemClickListener(nVar);
    }

    public void cH(boolean z) {
        if (!z) {
            this.bEe.setRefreshing(false);
        }
    }

    public void aiB() {
        this.dtY.setVisibility(0);
    }

    public void P(ArrayList<h> arrayList) {
        if (v.z(arrayList)) {
            m mVar = new m();
            arrayList = new ArrayList<>();
            arrayList.add(mVar);
        }
        this.dzy.setData(arrayList);
    }

    public BdTypeRecyclerView getListView() {
        return this.dtY;
    }

    public void setListViewSelection(int i) {
        this.dtY.setSelection(i);
    }

    public a ayL() {
        return this.dzy;
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
        this.bBr.setText(this.dzg.getResources().getString(e.j.list_no_more));
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
        if (this.dzy != null) {
            this.dzy.notifyDataSetChanged();
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mPullView != null) {
            this.mPullView.dM(i);
        }
        if (this.dzy != null) {
            this.dzy.notifyDataSetChanged();
        }
        this.dzg.getBaseFragmentActivity().getLayoutMode().setNightMode(i == 1);
        this.dzg.getBaseFragmentActivity().getLayoutMode().onModeChanged(this.bsh);
        if (this.bBr != null) {
            this.bBr.setTextColor(al.getColor(e.d.cp_cont_j));
            this.bBr.dM(i);
        }
        al.j(this.bEe, e.d.cp_bg_line_e);
    }

    public void onDestroy() {
        this.dzy.onDestory();
        this.dtY.setOnSrollToBottomListener(null);
    }
}
