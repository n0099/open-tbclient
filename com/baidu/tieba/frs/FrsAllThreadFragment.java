package com.baidu.tieba.frs;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.widget.refresh.BdSwipeRefreshLayout;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tieba.f;
/* loaded from: classes2.dex */
public class FrsAllThreadFragment extends BaseFragment implements aj {
    private static final String TAG = FrsAllThreadFragment.class.getSimpleName();
    private BdSwipeRefreshLayout byp;
    private View dlK;
    private RecyclerView dlL;

    @Override // android.support.v4.app.Fragment
    @Nullable
    public View onCreateView(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        if (this.dlK != null && this.dlK.getParent() != null) {
            ((ViewGroup) this.dlK.getParent()).removeView(this.dlK);
        }
        return this.dlK;
    }

    public void setView(View view) {
        this.dlK = view;
        this.dlL = (RecyclerView) this.dlK.findViewById(f.g.frs_lv_thread);
        this.byp = (BdSwipeRefreshLayout) this.dlK.findViewById(f.g.frs_pull_refresh_layout);
    }

    @Override // com.baidu.tieba.frs.aj
    public void atX() {
        if (this.dlL != null) {
            this.dlL.scrollToPosition(0);
        }
    }

    @Override // com.baidu.tieba.frs.aj
    public void Ul() {
        if (this.byp != null) {
            atX();
            this.byp.setRefreshing(true);
        }
    }
}
