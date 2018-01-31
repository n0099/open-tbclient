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
    private View dBc;
    private RecyclerView dBd;

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        if (this.dBc != null && this.dBc.getParent() != null) {
            ((ViewGroup) this.dBc.getParent()).removeView(this.dBc);
        }
        return this.dBc;
    }

    public void setView(View view) {
        this.dBc = view;
        this.dBd = (RecyclerView) this.dBc.findViewById(d.g.frs_lv_thread);
    }

    @Override // com.baidu.tieba.frs.al
    public void atP() {
        if (this.dBd != null) {
            this.dBd.scrollToPosition(0);
        }
    }
}
