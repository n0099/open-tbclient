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
    private View eYl;
    private RecyclerView eYm;

    @Override // android.support.v4.app.Fragment
    @Nullable
    public View onCreateView(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        if (this.eYl != null && this.eYl.getParent() != null) {
            ((ViewGroup) this.eYl.getParent()).removeView(this.eYl);
        }
        return this.eYl;
    }

    public void setView(View view) {
        this.eYl = view;
        this.eYm = (RecyclerView) this.eYl.findViewById(d.g.frs_lv_thread);
        this.dcE = (BdSwipeRefreshLayout) this.eYl.findViewById(d.g.frs_pull_refresh_layout);
    }

    @Override // com.baidu.tieba.frs.ag
    public void bce() {
        if (this.eYm != null) {
            this.eYm.scrollToPosition(0);
        }
    }

    @Override // com.baidu.tieba.frs.ag
    public void aCu() {
        if (this.dcE != null) {
            bce();
            this.dcE.setRefreshing(true);
        }
    }
}
