package com.baidu.tieba.frs;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.frs.ed;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
public class dg extends com.baidu.adp.widget.ListView.c {
    private View.OnClickListener afZ;
    private final int bjn;
    private boolean bpj;
    private ed.a bpk;
    private Context mContext;

    @Override // com.baidu.adp.widget.ListView.c
    public View mZ() {
        View inflate = LayoutInflater.from(this.mContext).inflate(t.h.frs_item_control, (ViewGroup) null);
        this.bpk = new ed.a();
        this.bpk.bqn = (FrameLayout) inflate.findViewById(t.g.frs_list_control);
        this.bpk.bqo = (LinearLayout) inflate.findViewById(t.g.frs_list_control_in);
        this.bpk.bqq = (ProgressBar) inflate.findViewById(t.g.frs_list_control_progress);
        this.bpk.bqp = (TextView) inflate.findViewById(t.g.frs_list_control_tv);
        inflate.setTag(this.bpk);
        return inflate;
    }

    public void onChangeSkinType(int i) {
        if (this.bpk != null) {
            com.baidu.tbadk.core.util.at.k(this.bpk.bqo, t.f.frs_item_control_bg);
            com.baidu.tbadk.core.util.at.c(this.bpk.bqp, i);
        }
    }

    public void cC(boolean z) {
        this.bpj = z;
        this.bpk.bqn.setVisibility(0);
        this.bpk.bqn.setPadding(0, this.bjn, 0, this.bjn);
        if (this.bpj) {
            this.bpk.bqp.setText(t.j.loading);
            this.bpk.bqq.setVisibility(0);
        } else {
            this.bpk.bqp.setText(t.j.frs_next);
            this.bpk.bqq.setVisibility(8);
        }
        onChangeSkinType(TbadkCoreApplication.m411getInst().getSkinType());
    }

    public void r(View.OnClickListener onClickListener) {
        this.afZ = onClickListener;
    }

    @Override // com.baidu.adp.widget.ListView.c
    public void onClick() {
        if (this.afZ != null) {
            this.afZ.onClick(getView());
        }
    }
}
