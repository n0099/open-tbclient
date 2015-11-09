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
import com.baidu.tieba.i;
/* loaded from: classes.dex */
public class db extends com.baidu.adp.widget.ListView.c {
    private final int aSZ;
    private a aXo;
    private boolean aYo;
    private View.OnClickListener aed;
    private Context mContext;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class a {
        FrameLayout aYp;
        LinearLayout aYq;
        TextView aYr;
        ProgressBar aYs;
    }

    @Override // com.baidu.adp.widget.ListView.c
    public View np() {
        View inflate = LayoutInflater.from(this.mContext).inflate(i.g.frs_item_control, (ViewGroup) null);
        this.aXo = new a();
        this.aXo.aYp = (FrameLayout) inflate.findViewById(i.f.frs_list_control);
        this.aXo.aYq = (LinearLayout) inflate.findViewById(i.f.frs_list_control_in);
        this.aXo.aYs = (ProgressBar) inflate.findViewById(i.f.frs_list_control_progress);
        this.aXo.aYr = (TextView) inflate.findViewById(i.f.frs_list_control_tv);
        inflate.setTag(this.aXo);
        onChangeSkinType(TbadkCoreApplication.m411getInst().getSkinType());
        return inflate;
    }

    public void onChangeSkinType(int i) {
        if (this.aXo != null) {
            com.baidu.tbadk.core.util.an.i(this.aXo.aYq, i.e.frs_item_control_bg);
            com.baidu.tbadk.core.util.an.c(this.aXo.aYr, i);
        }
    }

    public void cd(boolean z) {
        this.aYo = z;
        if (this.aXo != null) {
            this.aXo.aYp.setVisibility(0);
            this.aXo.aYp.setPadding(0, this.aSZ, 0, 0);
            if (z) {
                this.aXo.aYr.setText(i.h.loading);
                this.aXo.aYs.setVisibility(0);
                return;
            }
            this.aXo.aYr.setText(i.h.frs_pre);
            this.aXo.aYs.setVisibility(8);
        }
    }

    public void j(View.OnClickListener onClickListener) {
        this.aed = onClickListener;
    }

    @Override // com.baidu.adp.widget.ListView.c
    public void onClick() {
        if (this.aed != null) {
            this.aed.onClick(getView());
        }
    }
}
