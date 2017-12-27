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
    private View dwg;
    private RecyclerView dwh;

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        if (this.dwg != null && this.dwg.getParent() != null) {
            ((ViewGroup) this.dwg.getParent()).removeView(this.dwg);
        }
        return this.dwg;
    }

    public void setView(View view) {
        this.dwg = view;
        this.dwh = (RecyclerView) this.dwg.findViewById(d.g.frs_lv_thread);
    }

    @Override // com.baidu.tieba.frs.al
    public void asH() {
        if (this.dwh != null) {
            this.dwh.scrollToPosition(0);
        }
    }
}
