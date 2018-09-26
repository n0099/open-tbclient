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
/* loaded from: classes2.dex */
public class FrsAllThreadFragment extends BaseFragment implements aj {
    private static final String TAG = FrsAllThreadFragment.class.getSimpleName();
    private BdSwipeRefreshLayout bEe;
    private View drD;
    private RecyclerView drE;

    @Override // android.support.v4.app.Fragment
    @Nullable
    public View onCreateView(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        if (this.drD != null && this.drD.getParent() != null) {
            ((ViewGroup) this.drD.getParent()).removeView(this.drD);
        }
        return this.drD;
    }

    public void setView(View view) {
        this.drD = view;
        this.drE = (RecyclerView) this.drD.findViewById(e.g.frs_lv_thread);
        this.bEe = (BdSwipeRefreshLayout) this.drD.findViewById(e.g.frs_pull_refresh_layout);
    }

    @Override // com.baidu.tieba.frs.aj
    public void avO() {
        if (this.drE != null) {
            this.drE.scrollToPosition(0);
        }
    }

    @Override // com.baidu.tieba.frs.aj
    public void VY() {
        if (this.bEe != null) {
            avO();
            this.bEe.setRefreshing(true);
        }
    }
}
