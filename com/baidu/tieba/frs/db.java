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
import com.baidu.tieba.frs.dw;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
public class db extends com.baidu.adp.widget.ListView.c {
    private View.OnClickListener agz;
    private final int beB;
    private boolean bka;
    private dw.a bkb;
    private Context mContext;

    @Override // com.baidu.adp.widget.ListView.c
    public View ni() {
        View inflate = LayoutInflater.from(this.mContext).inflate(t.h.frs_item_control, (ViewGroup) null);
        this.bkb = new dw.a();
        this.bkb.bkX = (FrameLayout) inflate.findViewById(t.g.frs_list_control);
        this.bkb.bkY = (LinearLayout) inflate.findViewById(t.g.frs_list_control_in);
        this.bkb.bla = (ProgressBar) inflate.findViewById(t.g.frs_list_control_progress);
        this.bkb.bkZ = (TextView) inflate.findViewById(t.g.frs_list_control_tv);
        inflate.setTag(this.bkb);
        return inflate;
    }

    public void onChangeSkinType(int i) {
        if (this.bkb != null) {
            com.baidu.tbadk.core.util.ar.k(this.bkb.bkY, t.f.frs_item_control_bg);
            com.baidu.tbadk.core.util.ar.c(this.bkb.bkZ, i);
        }
    }

    public void cq(boolean z) {
        this.bka = z;
        this.bkb.bkX.setVisibility(0);
        this.bkb.bkX.setPadding(0, this.beB, 0, this.beB);
        if (this.bka) {
            this.bkb.bkZ.setText(t.j.loading);
            this.bkb.bla.setVisibility(0);
        } else {
            this.bkb.bkZ.setText(t.j.frs_next);
            this.bkb.bla.setVisibility(8);
        }
        onChangeSkinType(TbadkCoreApplication.m411getInst().getSkinType());
    }

    public void r(View.OnClickListener onClickListener) {
        this.agz = onClickListener;
    }

    @Override // com.baidu.adp.widget.ListView.c
    public void onClick() {
        if (this.agz != null) {
            this.agz.onClick(getView());
        }
    }
}
