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
import com.baidu.tieba.t;
/* loaded from: classes.dex */
public class ed extends com.baidu.adp.widget.ListView.c {
    private View.OnClickListener afZ;
    private final int bjn;
    private a bpk;
    private boolean bqm;
    private Context mContext;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class a {
        FrameLayout bqn;
        LinearLayout bqo;
        TextView bqp;
        ProgressBar bqq;
    }

    @Override // com.baidu.adp.widget.ListView.c
    public View mZ() {
        View inflate = LayoutInflater.from(this.mContext).inflate(t.h.frs_item_control, (ViewGroup) null);
        this.bpk = new a();
        this.bpk.bqn = (FrameLayout) inflate.findViewById(t.g.frs_list_control);
        this.bpk.bqo = (LinearLayout) inflate.findViewById(t.g.frs_list_control_in);
        this.bpk.bqq = (ProgressBar) inflate.findViewById(t.g.frs_list_control_progress);
        this.bpk.bqp = (TextView) inflate.findViewById(t.g.frs_list_control_tv);
        inflate.setTag(this.bpk);
        onChangeSkinType(TbadkCoreApplication.m411getInst().getSkinType());
        return inflate;
    }

    public void onChangeSkinType(int i) {
        if (this.bpk != null) {
            com.baidu.tbadk.core.util.at.k(this.bpk.bqo, t.f.frs_item_control_bg);
            com.baidu.tbadk.core.util.at.c(this.bpk.bqp, i);
        }
    }

    public void cD(boolean z) {
        this.bqm = z;
        if (this.bpk != null) {
            this.bpk.bqn.setVisibility(0);
            this.bpk.bqn.setPadding(0, this.bjn, 0, 0);
            if (z) {
                this.bpk.bqp.setText(t.j.loading);
                this.bpk.bqq.setVisibility(0);
                return;
            }
            this.bpk.bqp.setText(t.j.frs_pre);
            this.bpk.bqq.setVisibility(8);
        }
    }

    public void o(View.OnClickListener onClickListener) {
        this.afZ = onClickListener;
    }

    @Override // com.baidu.adp.widget.ListView.c
    public void onClick() {
        if (this.afZ != null) {
            this.afZ.onClick(getView());
        }
    }
}
