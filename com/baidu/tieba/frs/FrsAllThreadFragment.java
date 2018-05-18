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
    private BdSwipeRefreshLayout bog;
    private View cXM;
    private RecyclerView cXN;

    @Override // android.support.v4.app.Fragment
    @Nullable
    public View onCreateView(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        if (this.cXM != null && this.cXM.getParent() != null) {
            ((ViewGroup) this.cXM.getParent()).removeView(this.cXM);
        }
        return this.cXM;
    }

    public void setView(View view2) {
        this.cXM = view2;
        this.cXN = (RecyclerView) this.cXM.findViewById(d.g.frs_lv_thread);
        this.bog = (BdSwipeRefreshLayout) this.cXM.findViewById(d.g.frs_pull_refresh_layout);
    }

    @Override // com.baidu.tieba.frs.ah
    public void aoX() {
        if (this.cXN != null) {
            this.cXN.scrollToPosition(0);
        }
    }

    @Override // com.baidu.tieba.frs.ah
    public void Qi() {
        if (this.bog != null) {
            aoX();
            this.bog.setRefreshing(true);
        }
    }
}
