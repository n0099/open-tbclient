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
    private BdSwipeRefreshLayout bNu;
    private View dAV;
    private RecyclerView dAW;

    @Override // android.support.v4.app.Fragment
    @Nullable
    public View onCreateView(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        if (this.dAV != null && this.dAV.getParent() != null) {
            ((ViewGroup) this.dAV.getParent()).removeView(this.dAV);
        }
        return this.dAV;
    }

    public void setView(View view) {
        this.dAV = view;
        this.dAW = (RecyclerView) this.dAV.findViewById(e.g.frs_lv_thread);
        this.bNu = (BdSwipeRefreshLayout) this.dAV.findViewById(e.g.frs_pull_refresh_layout);
    }

    @Override // com.baidu.tieba.frs.aj
    public void ayI() {
        if (this.dAW != null) {
            this.dAW.scrollToPosition(0);
        }
    }

    @Override // com.baidu.tieba.frs.aj
    public void ZQ() {
        if (this.bNu != null) {
            ayI();
            this.bNu.setRefreshing(true);
        }
    }
}
