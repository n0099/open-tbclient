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
import com.baidu.tieba.frs.db;
import com.baidu.tieba.i;
/* loaded from: classes.dex */
public class cb extends com.baidu.adp.widget.ListView.c {
    private final int aSR;
    private boolean aXe;
    private db.a aXf;
    private View.OnClickListener adY;
    private Context mContext;

    @Override // com.baidu.adp.widget.ListView.c
    public View no() {
        View inflate = LayoutInflater.from(this.mContext).inflate(i.g.frs_item_control, (ViewGroup) null);
        this.aXf = new db.a();
        this.aXf.aYg = (FrameLayout) inflate.findViewById(i.f.frs_list_control);
        this.aXf.aYh = (LinearLayout) inflate.findViewById(i.f.frs_list_control_in);
        this.aXf.aYj = (ProgressBar) inflate.findViewById(i.f.frs_list_control_progress);
        this.aXf.aYi = (TextView) inflate.findViewById(i.f.frs_list_control_tv);
        inflate.setTag(this.aXf);
        return inflate;
    }

    public void onChangeSkinType(int i) {
        if (this.aXf != null) {
            com.baidu.tbadk.core.util.an.i(this.aXf.aYh, i.e.frs_item_control_bg);
            com.baidu.tbadk.core.util.an.c(this.aXf.aYi, i);
        }
    }

    public void ca(boolean z) {
        this.aXe = z;
        this.aXf.aYg.setVisibility(0);
        this.aXf.aYg.setPadding(0, this.aSR, 0, this.aSR);
        if (this.aXe) {
            this.aXf.aYi.setText(i.h.loading);
            this.aXf.aYj.setVisibility(0);
        } else {
            this.aXf.aYi.setText(i.h.frs_next);
            this.aXf.aYj.setVisibility(8);
        }
        onChangeSkinType(TbadkCoreApplication.m411getInst().getSkinType());
    }

    public void m(View.OnClickListener onClickListener) {
        this.adY = onClickListener;
    }

    @Override // com.baidu.adp.widget.ListView.c
    public void onClick() {
        if (this.adY != null) {
            this.adY.onClick(getView());
        }
    }
}
