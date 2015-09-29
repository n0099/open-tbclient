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
    private final int aSG;
    private a aWU;
    private boolean aXU;
    private View.OnClickListener adX;
    private Context mContext;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class a {
        FrameLayout aXV;
        LinearLayout aXW;
        TextView aXX;
        ProgressBar aXY;
    }

    @Override // com.baidu.adp.widget.ListView.c
    public View no() {
        View inflate = LayoutInflater.from(this.mContext).inflate(i.g.frs_item_control, (ViewGroup) null);
        this.aWU = new a();
        this.aWU.aXV = (FrameLayout) inflate.findViewById(i.f.frs_list_control);
        this.aWU.aXW = (LinearLayout) inflate.findViewById(i.f.frs_list_control_in);
        this.aWU.aXY = (ProgressBar) inflate.findViewById(i.f.frs_list_control_progress);
        this.aWU.aXX = (TextView) inflate.findViewById(i.f.frs_list_control_tv);
        inflate.setTag(this.aWU);
        onChangeSkinType(TbadkCoreApplication.m411getInst().getSkinType());
        return inflate;
    }

    public void onChangeSkinType(int i) {
        if (this.aWU != null) {
            com.baidu.tbadk.core.util.am.i(this.aWU.aXW, i.e.frs_item_control_bg);
            com.baidu.tbadk.core.util.am.c(this.aWU.aXX, i);
        }
    }

    public void cb(boolean z) {
        this.aXU = z;
        if (this.aWU != null) {
            this.aWU.aXV.setVisibility(0);
            this.aWU.aXV.setPadding(0, this.aSG, 0, 0);
            if (z) {
                this.aWU.aXX.setText(i.h.loading);
                this.aWU.aXY.setVisibility(0);
                return;
            }
            this.aWU.aXX.setText(i.h.frs_pre);
            this.aWU.aXY.setVisibility(8);
        }
    }

    public void j(View.OnClickListener onClickListener) {
        this.adX = onClickListener;
    }

    @Override // com.baidu.adp.widget.ListView.c
    public void onClick() {
        if (this.adX != null) {
            this.adX.onClick(getView());
        }
    }
}
