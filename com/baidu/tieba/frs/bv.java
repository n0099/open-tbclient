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
import com.baidu.tieba.frs.ci;
import com.baidu.tieba.i;
/* loaded from: classes.dex */
public class bv extends com.baidu.adp.widget.ListView.c {
    private final int aTw;
    private boolean aXE;
    private ci.a aXF;
    private View.OnClickListener aeB;
    private Context mContext;

    @Override // com.baidu.adp.widget.ListView.c
    public View nq() {
        View inflate = LayoutInflater.from(this.mContext).inflate(i.g.frs_item_control, (ViewGroup) null);
        this.aXF = new ci.a();
        this.aXF.aYe = (FrameLayout) inflate.findViewById(i.f.frs_list_control);
        this.aXF.aYf = (LinearLayout) inflate.findViewById(i.f.frs_list_control_in);
        this.aXF.aYh = (ProgressBar) inflate.findViewById(i.f.frs_list_control_progress);
        this.aXF.aYg = (TextView) inflate.findViewById(i.f.frs_list_control_tv);
        inflate.setTag(this.aXF);
        return inflate;
    }

    public void onChangeSkinType(int i) {
        if (this.aXF != null) {
            com.baidu.tbadk.core.util.al.i(this.aXF.aYf, i.e.frs_item_control_bg);
            com.baidu.tbadk.core.util.al.c(this.aXF.aYg, i);
        }
    }

    public void bY(boolean z) {
        this.aXE = z;
        this.aXF.aYe.setVisibility(0);
        this.aXF.aYe.setPadding(0, this.aTw, 0, this.aTw);
        if (this.aXE) {
            this.aXF.aYg.setText(i.C0057i.loading);
            this.aXF.aYh.setVisibility(0);
        } else {
            this.aXF.aYg.setText(i.C0057i.frs_next);
            this.aXF.aYh.setVisibility(8);
        }
        onChangeSkinType(TbadkCoreApplication.m411getInst().getSkinType());
    }

    public void m(View.OnClickListener onClickListener) {
        this.aeB = onClickListener;
    }

    @Override // com.baidu.adp.widget.ListView.c
    public void onClick() {
        if (this.aeB != null) {
            this.aeB.onClick(getView());
        }
    }
}
