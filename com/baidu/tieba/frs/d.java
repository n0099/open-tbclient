package com.baidu.tieba.frs;

import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tieba.d;
/* loaded from: classes2.dex */
public class d extends BaseFragment implements al {
    private static final String TAG = d.class.getSimpleName();
    private View dAH;
    private RecyclerView dAI;

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        if (this.dAH != null && this.dAH.getParent() != null) {
            ((ViewGroup) this.dAH.getParent()).removeView(this.dAH);
        }
        return this.dAH;
    }

    public void setView(View view) {
        this.dAH = view;
        this.dAI = (RecyclerView) this.dAH.findViewById(d.g.frs_lv_thread);
    }

    @Override // com.baidu.tieba.frs.al
    public void atK() {
        if (this.dAI != null) {
            this.dAI.scrollToPosition(0);
        }
    }
}
