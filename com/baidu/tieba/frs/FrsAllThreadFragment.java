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
    private BdSwipeRefreshLayout bnR;
    private View cWF;
    private RecyclerView cWG;

    @Override // android.support.v4.app.Fragment
    @Nullable
    public View onCreateView(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        if (this.cWF != null && this.cWF.getParent() != null) {
            ((ViewGroup) this.cWF.getParent()).removeView(this.cWF);
        }
        return this.cWF;
    }

    public void setView(View view2) {
        this.cWF = view2;
        this.cWG = (RecyclerView) this.cWF.findViewById(d.g.frs_lv_thread);
        this.bnR = (BdSwipeRefreshLayout) this.cWF.findViewById(d.g.frs_pull_refresh_layout);
    }

    @Override // com.baidu.tieba.frs.ah
    public void aoY() {
        if (this.cWG != null) {
            this.cWG.scrollToPosition(0);
        }
    }

    @Override // com.baidu.tieba.frs.ah
    public void Ql() {
        if (this.bnR != null) {
            aoY();
            this.bnR.setRefreshing(true);
        }
    }
}
