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
    private BdSwipeRefreshLayout bRl;
    private View dHu;
    private RecyclerView dHv;

    @Override // android.support.v4.app.Fragment
    @Nullable
    public View onCreateView(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        if (this.dHu != null && this.dHu.getParent() != null) {
            ((ViewGroup) this.dHu.getParent()).removeView(this.dHu);
        }
        return this.dHu;
    }

    public void setView(View view) {
        this.dHu = view;
        this.dHv = (RecyclerView) this.dHu.findViewById(e.g.frs_lv_thread);
        this.bRl = (BdSwipeRefreshLayout) this.dHu.findViewById(e.g.frs_pull_refresh_layout);
    }

    @Override // com.baidu.tieba.frs.aj
    public void aAs() {
        if (this.dHv != null) {
            this.dHv.scrollToPosition(0);
        }
    }

    @Override // com.baidu.tieba.frs.aj
    public void aaW() {
        if (this.bRl != null) {
            aAs();
            this.bRl.setRefreshing(true);
        }
    }
}
