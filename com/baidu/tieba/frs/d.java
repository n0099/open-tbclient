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
    private BdSwipeRefreshLayout cdP;
    private View dDJ;
    private RecyclerView dDK;

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        if (this.dDJ != null && this.dDJ.getParent() != null) {
            ((ViewGroup) this.dDJ.getParent()).removeView(this.dDJ);
        }
        return this.dDJ;
    }

    public void setView(View view) {
        this.dDJ = view;
        this.dDK = (RecyclerView) this.dDJ.findViewById(d.g.frs_lv_thread);
        this.cdP = (BdSwipeRefreshLayout) this.dDJ.findViewById(d.g.frs_pull_refresh_layout);
    }

    @Override // com.baidu.tieba.frs.al
    public void auE() {
        if (this.dDK != null) {
            this.dDK.scrollToPosition(0);
        }
    }

    @Override // com.baidu.tieba.frs.al
    public void XK() {
        if (this.cdP != null) {
            auE();
            this.cdP.setRefreshing(true);
        }
    }
}
