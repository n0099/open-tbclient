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
    private BdSwipeRefreshLayout byn;
    private View dlM;
    private RecyclerView dlN;

    @Override // android.support.v4.app.Fragment
    @Nullable
    public View onCreateView(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        if (this.dlM != null && this.dlM.getParent() != null) {
            ((ViewGroup) this.dlM.getParent()).removeView(this.dlM);
        }
        return this.dlM;
    }

    public void setView(View view) {
        this.dlM = view;
        this.dlN = (RecyclerView) this.dlM.findViewById(d.g.frs_lv_thread);
        this.byn = (BdSwipeRefreshLayout) this.dlM.findViewById(d.g.frs_pull_refresh_layout);
    }

    @Override // com.baidu.tieba.frs.aj
    public void atY() {
        if (this.dlN != null) {
            this.dlN.scrollToPosition(0);
        }
    }

    @Override // com.baidu.tieba.frs.aj
    public void Ui() {
        if (this.byn != null) {
            atY();
            this.byn.setRefreshing(true);
        }
    }
}
