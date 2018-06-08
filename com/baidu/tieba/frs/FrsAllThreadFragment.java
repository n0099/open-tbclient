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
public class FrsAllThreadFragment extends BaseFragment implements ah {
    private static final String TAG = FrsAllThreadFragment.class.getSimpleName();
    private BdSwipeRefreshLayout bwm;
    private View dgZ;
    private RecyclerView dha;

    @Override // android.support.v4.app.Fragment
    @Nullable
    public View onCreateView(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        if (this.dgZ != null && this.dgZ.getParent() != null) {
            ((ViewGroup) this.dgZ.getParent()).removeView(this.dgZ);
        }
        return this.dgZ;
    }

    public void setView(View view) {
        this.dgZ = view;
        this.dha = (RecyclerView) this.dgZ.findViewById(d.g.frs_lv_thread);
        this.bwm = (BdSwipeRefreshLayout) this.dgZ.findViewById(d.g.frs_pull_refresh_layout);
    }

    @Override // com.baidu.tieba.frs.ah
    public void atd() {
        if (this.dha != null) {
            this.dha.scrollToPosition(0);
        }
    }

    @Override // com.baidu.tieba.frs.ah
    public void TG() {
        if (this.bwm != null) {
            atd();
            this.bwm.setRefreshing(true);
        }
    }
}
