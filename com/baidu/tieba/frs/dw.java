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
public class dw extends com.baidu.adp.widget.ListView.c {
    private View.OnClickListener agz;
    private final int beB;
    private boolean bkW;
    private a bkb;
    private Context mContext;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class a {
        FrameLayout bkX;
        LinearLayout bkY;
        TextView bkZ;
        ProgressBar bla;
    }

    @Override // com.baidu.adp.widget.ListView.c
    public View ni() {
        View inflate = LayoutInflater.from(this.mContext).inflate(t.h.frs_item_control, (ViewGroup) null);
        this.bkb = new a();
        this.bkb.bkX = (FrameLayout) inflate.findViewById(t.g.frs_list_control);
        this.bkb.bkY = (LinearLayout) inflate.findViewById(t.g.frs_list_control_in);
        this.bkb.bla = (ProgressBar) inflate.findViewById(t.g.frs_list_control_progress);
        this.bkb.bkZ = (TextView) inflate.findViewById(t.g.frs_list_control_tv);
        inflate.setTag(this.bkb);
        onChangeSkinType(TbadkCoreApplication.m411getInst().getSkinType());
        return inflate;
    }

    public void onChangeSkinType(int i) {
        if (this.bkb != null) {
            com.baidu.tbadk.core.util.ar.k(this.bkb.bkY, t.f.frs_item_control_bg);
            com.baidu.tbadk.core.util.ar.c(this.bkb.bkZ, i);
        }
    }

    public void cr(boolean z) {
        this.bkW = z;
        if (this.bkb != null) {
            this.bkb.bkX.setVisibility(0);
            this.bkb.bkX.setPadding(0, this.beB, 0, 0);
            if (z) {
                this.bkb.bkZ.setText(t.j.loading);
                this.bkb.bla.setVisibility(0);
                return;
            }
            this.bkb.bkZ.setText(t.j.frs_pre);
            this.bkb.bla.setVisibility(8);
        }
    }

    public void o(View.OnClickListener onClickListener) {
        this.agz = onClickListener;
    }

    @Override // com.baidu.adp.widget.ListView.c
    public void onClick() {
        if (this.agz != null) {
            this.agz.onClick(getView());
        }
    }
}
