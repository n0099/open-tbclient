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
    private BdSwipeRefreshLayout dcA;
    private View eYk;
    private RecyclerView eYl;

    @Override // android.support.v4.app.Fragment
    @Nullable
    public View onCreateView(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        if (this.eYk != null && this.eYk.getParent() != null) {
            ((ViewGroup) this.eYk.getParent()).removeView(this.eYk);
        }
        return this.eYk;
    }

    public void setView(View view) {
        this.eYk = view;
        this.eYl = (RecyclerView) this.eYk.findViewById(d.g.frs_lv_thread);
        this.dcA = (BdSwipeRefreshLayout) this.eYk.findViewById(d.g.frs_pull_refresh_layout);
    }

    @Override // com.baidu.tieba.frs.ag
    public void bcd() {
        if (this.eYl != null) {
            this.eYl.scrollToPosition(0);
        }
    }

    @Override // com.baidu.tieba.frs.ag
    public void aCt() {
        if (this.dcA != null) {
            bcd();
            this.dcA.setRefreshing(true);
        }
    }
}
