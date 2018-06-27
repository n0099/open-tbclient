package com.baidu.tieba.frs;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.widget.refresh.BdSwipeRefreshLayout;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tieba.d;
/* loaded from: classes2.dex */
public class FrsAllThreadFragment extends BaseFragment implements aj {
    private static final String TAG = FrsAllThreadFragment.class.getSimpleName();
    private BdSwipeRefreshLayout bxI;
    private View diW;
    private RecyclerView diX;

    @Override // android.support.v4.app.Fragment
    @Nullable
    public View onCreateView(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        if (this.diW != null && this.diW.getParent() != null) {
            ((ViewGroup) this.diW.getParent()).removeView(this.diW);
        }
        return this.diW;
    }

    public void setView(View view) {
        this.diW = view;
        this.diX = (RecyclerView) this.diW.findViewById(d.g.frs_lv_thread);
        this.bxI = (BdSwipeRefreshLayout) this.diW.findViewById(d.g.frs_pull_refresh_layout);
    }

    @Override // com.baidu.tieba.frs.aj
    public void atu() {
        if (this.diX != null) {
            this.diX.scrollToPosition(0);
        }
    }

    @Override // com.baidu.tieba.frs.aj
    public void Ua() {
        if (this.bxI != null) {
            atu();
            this.bxI.setRefreshing(true);
        }
    }
}
