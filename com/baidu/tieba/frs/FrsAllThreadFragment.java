package com.baidu.tieba.frs;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.widget.refresh.BdSwipeRefreshLayout;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tieba.e;
/* loaded from: classes6.dex */
public class FrsAllThreadFragment extends BaseFragment implements aj {
    private static final String TAG = FrsAllThreadFragment.class.getSimpleName();
    private BdSwipeRefreshLayout bSa;
    private View dKS;
    private RecyclerView dKT;

    @Override // android.support.v4.app.Fragment
    @Nullable
    public View onCreateView(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        if (this.dKS != null && this.dKS.getParent() != null) {
            ((ViewGroup) this.dKS.getParent()).removeView(this.dKS);
        }
        return this.dKS;
    }

    public void setView(View view) {
        this.dKS = view;
        this.dKT = (RecyclerView) this.dKS.findViewById(e.g.frs_lv_thread);
        this.bSa = (BdSwipeRefreshLayout) this.dKS.findViewById(e.g.frs_pull_refresh_layout);
    }

    @Override // com.baidu.tieba.frs.aj
    public void aBE() {
        if (this.dKT != null) {
            this.dKT.scrollToPosition(0);
        }
    }

    @Override // com.baidu.tieba.frs.aj
    public void abv() {
        if (this.bSa != null) {
            aBE();
            this.bSa.setRefreshing(true);
        }
    }
}
