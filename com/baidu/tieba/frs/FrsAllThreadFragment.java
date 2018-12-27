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
/* loaded from: classes6.dex */
public class FrsAllThreadFragment extends BaseFragment implements aj {
    private static final String TAG = FrsAllThreadFragment.class.getSimpleName();
    private BdSwipeRefreshLayout bRo;
    private View dKi;
    private RecyclerView dKj;

    @Override // android.support.v4.app.Fragment
    @Nullable
    public View onCreateView(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        if (this.dKi != null && this.dKi.getParent() != null) {
            ((ViewGroup) this.dKi.getParent()).removeView(this.dKi);
        }
        return this.dKi;
    }

    public void setView(View view) {
        this.dKi = view;
        this.dKj = (RecyclerView) this.dKi.findViewById(e.g.frs_lv_thread);
        this.bRo = (BdSwipeRefreshLayout) this.dKi.findViewById(e.g.frs_pull_refresh_layout);
    }

    @Override // com.baidu.tieba.frs.aj
    public void aBh() {
        if (this.dKj != null) {
            this.dKj.scrollToPosition(0);
        }
    }

    @Override // com.baidu.tieba.frs.aj
    public void aaY() {
        if (this.bRo != null) {
            aBh();
            this.bRo.setRefreshing(true);
        }
    }
}
