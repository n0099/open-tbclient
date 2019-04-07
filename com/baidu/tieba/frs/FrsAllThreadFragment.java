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
/* loaded from: classes4.dex */
public class FrsAllThreadFragment extends BaseFragment implements ag {
    private static final String TAG = FrsAllThreadFragment.class.getSimpleName();
    private BdSwipeRefreshLayout dcE;
    private View eXW;
    private RecyclerView eXX;

    @Override // android.support.v4.app.Fragment
    @Nullable
    public View onCreateView(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        if (this.eXW != null && this.eXW.getParent() != null) {
            ((ViewGroup) this.eXW.getParent()).removeView(this.eXW);
        }
        return this.eXW;
    }

    public void setView(View view) {
        this.eXW = view;
        this.eXX = (RecyclerView) this.eXW.findViewById(d.g.frs_lv_thread);
        this.dcE = (BdSwipeRefreshLayout) this.eXW.findViewById(d.g.frs_pull_refresh_layout);
    }

    @Override // com.baidu.tieba.frs.ag
    public void bcb() {
        if (this.eXX != null) {
            this.eXX.scrollToPosition(0);
        }
    }

    @Override // com.baidu.tieba.frs.ag
    public void aCq() {
        if (this.dcE != null) {
            bcb();
            this.dcE.setRefreshing(true);
        }
    }
}
