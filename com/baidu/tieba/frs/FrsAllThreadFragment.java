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
    private BdSwipeRefreshLayout bRZ;
    private View dKR;
    private RecyclerView dKS;

    @Override // android.support.v4.app.Fragment
    @Nullable
    public View onCreateView(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        if (this.dKR != null && this.dKR.getParent() != null) {
            ((ViewGroup) this.dKR.getParent()).removeView(this.dKR);
        }
        return this.dKR;
    }

    public void setView(View view) {
        this.dKR = view;
        this.dKS = (RecyclerView) this.dKR.findViewById(e.g.frs_lv_thread);
        this.bRZ = (BdSwipeRefreshLayout) this.dKR.findViewById(e.g.frs_pull_refresh_layout);
    }

    @Override // com.baidu.tieba.frs.aj
    public void aBE() {
        if (this.dKS != null) {
            this.dKS.scrollToPosition(0);
        }
    }

    @Override // com.baidu.tieba.frs.aj
    public void abv() {
        if (this.bRZ != null) {
            aBE();
            this.bRZ.setRefreshing(true);
        }
    }
}
