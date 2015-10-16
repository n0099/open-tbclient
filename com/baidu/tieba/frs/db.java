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
    private final int aSR;
    private a aXf;
    private boolean aYf;
    private View.OnClickListener adY;
    private Context mContext;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class a {
        FrameLayout aYg;
        LinearLayout aYh;
        TextView aYi;
        ProgressBar aYj;
    }

    @Override // com.baidu.adp.widget.ListView.c
    public View no() {
        View inflate = LayoutInflater.from(this.mContext).inflate(i.g.frs_item_control, (ViewGroup) null);
        this.aXf = new a();
        this.aXf.aYg = (FrameLayout) inflate.findViewById(i.f.frs_list_control);
        this.aXf.aYh = (LinearLayout) inflate.findViewById(i.f.frs_list_control_in);
        this.aXf.aYj = (ProgressBar) inflate.findViewById(i.f.frs_list_control_progress);
        this.aXf.aYi = (TextView) inflate.findViewById(i.f.frs_list_control_tv);
        inflate.setTag(this.aXf);
        onChangeSkinType(TbadkCoreApplication.m411getInst().getSkinType());
        return inflate;
    }

    public void onChangeSkinType(int i) {
        if (this.aXf != null) {
            com.baidu.tbadk.core.util.an.i(this.aXf.aYh, i.e.frs_item_control_bg);
            com.baidu.tbadk.core.util.an.c(this.aXf.aYi, i);
        }
    }

    public void cb(boolean z) {
        this.aYf = z;
        if (this.aXf != null) {
            this.aXf.aYg.setVisibility(0);
            this.aXf.aYg.setPadding(0, this.aSR, 0, 0);
            if (z) {
                this.aXf.aYi.setText(i.h.loading);
                this.aXf.aYj.setVisibility(0);
                return;
            }
            this.aXf.aYi.setText(i.h.frs_pre);
            this.aXf.aYj.setVisibility(8);
        }
    }

    public void j(View.OnClickListener onClickListener) {
        this.adY = onClickListener;
    }

    @Override // com.baidu.adp.widget.ListView.c
    public void onClick() {
        if (this.adY != null) {
            this.adY.onClick(getView());
        }
    }
}
