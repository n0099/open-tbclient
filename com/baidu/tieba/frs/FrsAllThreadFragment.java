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
    private BdSwipeRefreshLayout dcF;
    private View eXX;
    private RecyclerView eXY;

    @Override // android.support.v4.app.Fragment
    @Nullable
    public View onCreateView(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        if (this.eXX != null && this.eXX.getParent() != null) {
            ((ViewGroup) this.eXX.getParent()).removeView(this.eXX);
        }
        return this.eXX;
    }

    public void setView(View view) {
        this.eXX = view;
        this.eXY = (RecyclerView) this.eXX.findViewById(d.g.frs_lv_thread);
        this.dcF = (BdSwipeRefreshLayout) this.eXX.findViewById(d.g.frs_pull_refresh_layout);
    }

    @Override // com.baidu.tieba.frs.ag
    public void bcb() {
        if (this.eXY != null) {
            this.eXY.scrollToPosition(0);
        }
    }

    @Override // com.baidu.tieba.frs.ag
    public void aCq() {
        if (this.dcF != null) {
            bcb();
            this.dcF.setRefreshing(true);
        }
    }
}
