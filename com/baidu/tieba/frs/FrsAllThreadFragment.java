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
    private BdSwipeRefreshLayout bMJ;
    private View dzE;
    private RecyclerView dzF;

    @Override // android.support.v4.app.Fragment
    @Nullable
    public View onCreateView(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        if (this.dzE != null && this.dzE.getParent() != null) {
            ((ViewGroup) this.dzE.getParent()).removeView(this.dzE);
        }
        return this.dzE;
    }

    public void setView(View view) {
        this.dzE = view;
        this.dzF = (RecyclerView) this.dzE.findViewById(e.g.frs_lv_thread);
        this.bMJ = (BdSwipeRefreshLayout) this.dzE.findViewById(e.g.frs_pull_refresh_layout);
    }

    @Override // com.baidu.tieba.frs.aj
    public void azk() {
        if (this.dzF != null) {
            this.dzF.scrollToPosition(0);
        }
    }

    @Override // com.baidu.tieba.frs.aj
    public void ZF() {
        if (this.bMJ != null) {
            azk();
            this.bMJ.setRefreshing(true);
        }
    }
}
