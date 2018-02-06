package com.baidu.tieba.frs;

import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.widget.refresh.BdSwipeRefreshLayout;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tieba.d;
/* loaded from: classes2.dex */
public class d extends BaseFragment implements al {
    private static final String TAG = d.class.getSimpleName();
    private BdSwipeRefreshLayout ceb;
    private View dDV;
    private RecyclerView dDW;

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        if (this.dDV != null && this.dDV.getParent() != null) {
            ((ViewGroup) this.dDV.getParent()).removeView(this.dDV);
        }
        return this.dDV;
    }

    public void setView(View view) {
        this.dDV = view;
        this.dDW = (RecyclerView) this.dDV.findViewById(d.g.frs_lv_thread);
        this.ceb = (BdSwipeRefreshLayout) this.dDV.findViewById(d.g.frs_pull_refresh_layout);
    }

    @Override // com.baidu.tieba.frs.al
    public void auF() {
        if (this.dDW != null) {
            this.dDW.scrollToPosition(0);
        }
    }

    @Override // com.baidu.tieba.frs.al
    public void XL() {
        if (this.ceb != null) {
            auF();
            this.ceb.setRefreshing(true);
        }
    }
}
