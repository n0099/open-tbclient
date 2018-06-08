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
import com.baidu.tbadk.core.util.w;
import com.baidu.tbadk.core.view.PbListView;
import com.baidu.tbadk.core.view.UserPhotoLayout;
import com.baidu.tbadk.core.view.f;
import com.baidu.tbadk.core.view.g;
import com.baidu.tieba.d;
import com.baidu.tieba.frs.k;
import com.baidu.tieba.tbadkCore.FrsCommonImageLayout;
import com.baidu.tieba.tbadkCore.voice.PlayVoiceBnt;
import java.util.ArrayList;
/* loaded from: classes2.dex */
public class c {
    private RelativeLayout bkk;
    private PbListView btv;
    private BdSwipeRefreshLayout bwm;
    private BdTypeRecyclerView djk;
    private FrsDynamicFragment dmA;
    private FrameLayout dmX;
    private a dmY;
    private g mPullView;

    public c(FrsDynamicFragment frsDynamicFragment, View view) {
        this.dmA = frsDynamicFragment;
        an(view);
    }

    private void an(View view) {
        this.bkk = (RelativeLayout) view.findViewById(d.g.frs_dynamic_container);
        this.djk = (BdTypeRecyclerView) view.findViewById(d.g.frs_dynamic_lv_thread);
        this.djk.setLayoutManager(new LinearLayoutManager(this.djk.getContext()));
        this.djk.setFadingEdgeLength(0);
        this.djk.setOverScrollMode(2);
        this.mPullView = new g(this.dmA.getPageContext());
        this.djk.setRecyclerListener(new RecyclerView.RecyclerListener() { // from class: com.baidu.tieba.frs.dynamic.c.1
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
        this.btv = new PbListView(this.dmA.getPageContext().getPageActivity());
        this.btv.nn();
        this.btv.dx(d.C0141d.cp_bg_line_e);
        this.btv.setHeight(l.e(this.dmA.getActivity(), d.e.tbds182));
        this.btv.Ao();
        this.btv.setTextSize(d.e.tbfontsize33);
        this.btv.setTextColor(al.getColor(d.C0141d.cp_cont_j));
        this.btv.dw(d.C0141d.cp_cont_e);
        this.djk.setOnSrollToBottomListener(this.dmA);
        if (this.bwm == null) {
            this.bwm = (BdSwipeRefreshLayout) view.findViewById(d.g.frs_dynamic_pull_refresh_layout);
            this.bwm.setProgressView(this.mPullView);
            al.j(this.bwm, d.C0141d.cp_bg_line_c);
        }
        this.dmX = (FrameLayout) view.findViewById(d.g.frs_dynamic_list_content);
        this.dmY = new a(this.dmA, this.djk);
        cm(false);
    }

    public void a(f.b bVar) {
        this.mPullView.a(bVar);
    }

    public void setOnAdapterItemClickListener(n nVar) {
        this.dmY.setOnAdapterItemClickListener(nVar);
    }

    public void cm(boolean z) {
        if (!z) {
            this.bwm.setRefreshing(false);
        }
    }

    public void showListView() {
        this.djk.setVisibility(0);
    }

    public void J(ArrayList<h> arrayList) {
        if (w.z(arrayList)) {
            k kVar = new k();
            arrayList = new ArrayList<>();
            arrayList.add(kVar);
        }
        this.dmY.setData(arrayList);
    }

    public BdTypeRecyclerView getListView() {
        return this.djk;
    }

    public void setListViewSelection(int i) {
        this.djk.setSelection(i);
    }

    public a avp() {
        return this.dmY;
    }

    public RelativeLayout avq() {
        return this.bkk;
    }

    public View avr() {
        return this.bwm;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void TJ() {
        this.djk.setNextPage(this.btv);
        this.btv.dz(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        this.btv.Ar();
    }

    public void TK() {
        this.djk.setNextPage(this.btv);
        this.btv.dz(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        this.btv.As();
        this.btv.setText(this.dmA.getResources().getString(d.k.list_no_more));
    }

    public void TL() {
        this.djk.setNextPage(null);
    }

    public void fO(boolean z) {
        this.dmX.setVisibility(z ? 0 : 8);
    }

    public void startPullRefresh() {
        this.bwm.setRefreshing(true);
    }

    public void auo() {
        if (this.dmY != null) {
            this.dmY.notifyDataSetChanged();
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mPullView != null) {
            this.mPullView.dy(i);
        }
        if (this.dmY != null) {
            this.dmY.notifyDataSetChanged();
        }
        this.dmA.getBaseFragmentActivity().getLayoutMode().setNightMode(i == 1);
        this.dmA.getBaseFragmentActivity().getLayoutMode().onModeChanged(this.bkk);
        if (this.btv != null) {
            this.btv.setTextColor(al.getColor(d.C0141d.cp_cont_j));
            this.btv.dy(i);
        }
        al.j(this.bwm, d.C0141d.cp_bg_line_c);
        al.j(this.djk, d.C0141d.cp_bg_line_e);
    }

    public void onDestroy() {
        this.dmY.onDestory();
        this.djk.setOnSrollToBottomListener(null);
    }
}
