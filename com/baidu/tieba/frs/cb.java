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
    private final int aSG;
    private boolean aWT;
    private db.a aWU;
    private View.OnClickListener adX;
    private Context mContext;

    @Override // com.baidu.adp.widget.ListView.c
    public View no() {
        View inflate = LayoutInflater.from(this.mContext).inflate(i.g.frs_item_control, (ViewGroup) null);
        this.aWU = new db.a();
        this.aWU.aXV = (FrameLayout) inflate.findViewById(i.f.frs_list_control);
        this.aWU.aXW = (LinearLayout) inflate.findViewById(i.f.frs_list_control_in);
        this.aWU.aXY = (ProgressBar) inflate.findViewById(i.f.frs_list_control_progress);
        this.aWU.aXX = (TextView) inflate.findViewById(i.f.frs_list_control_tv);
        inflate.setTag(this.aWU);
        return inflate;
    }

    public void onChangeSkinType(int i) {
        if (this.aWU != null) {
            com.baidu.tbadk.core.util.am.i(this.aWU.aXW, i.e.frs_item_control_bg);
            com.baidu.tbadk.core.util.am.c(this.aWU.aXX, i);
        }
    }

    public void ca(boolean z) {
        this.aWT = z;
        this.aWU.aXV.setVisibility(0);
        this.aWU.aXV.setPadding(0, this.aSG, 0, this.aSG);
        if (this.aWT) {
            this.aWU.aXX.setText(i.h.loading);
            this.aWU.aXY.setVisibility(0);
        } else {
            this.aWU.aXX.setText(i.h.frs_next);
            this.aWU.aXY.setVisibility(8);
        }
        onChangeSkinType(TbadkCoreApplication.m411getInst().getSkinType());
    }

    public void m(View.OnClickListener onClickListener) {
        this.adX = onClickListener;
    }

    @Override // com.baidu.adp.widget.ListView.c
    public void onClick() {
        if (this.adX != null) {
            this.adX.onClick(getView());
        }
    }
}
