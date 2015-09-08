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
public class cm extends com.baidu.adp.widget.ListView.c {
    private final int aTK;
    private a aXA;
    private boolean aYs;
    private View.OnClickListener aeL;
    private Context mContext;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class a {
        FrameLayout aYt;
        LinearLayout aYu;
        TextView aYv;
        ProgressBar aYw;
    }

    @Override // com.baidu.adp.widget.ListView.c
    public View nn() {
        View inflate = LayoutInflater.from(this.mContext).inflate(i.g.frs_item_control, (ViewGroup) null);
        this.aXA = new a();
        this.aXA.aYt = (FrameLayout) inflate.findViewById(i.f.frs_list_control);
        this.aXA.aYu = (LinearLayout) inflate.findViewById(i.f.frs_list_control_in);
        this.aXA.aYw = (ProgressBar) inflate.findViewById(i.f.frs_list_control_progress);
        this.aXA.aYv = (TextView) inflate.findViewById(i.f.frs_list_control_tv);
        inflate.setTag(this.aXA);
        onChangeSkinType(TbadkCoreApplication.m411getInst().getSkinType());
        return inflate;
    }

    public void onChangeSkinType(int i) {
        if (this.aXA != null) {
            com.baidu.tbadk.core.util.al.h(this.aXA.aYu, i.e.frs_item_control_bg);
            com.baidu.tbadk.core.util.al.c(this.aXA.aYv, i);
        }
    }

    public void ce(boolean z) {
        this.aYs = z;
        if (this.aXA != null) {
            this.aXA.aYt.setVisibility(0);
            this.aXA.aYt.setPadding(0, this.aTK, 0, 0);
            if (z) {
                this.aXA.aYv.setText(i.h.loading);
                this.aXA.aYw.setVisibility(0);
                return;
            }
            this.aXA.aYv.setText(i.h.frs_pre);
            this.aXA.aYw.setVisibility(8);
        }
    }

    public void j(View.OnClickListener onClickListener) {
        this.aeL = onClickListener;
    }

    @Override // com.baidu.adp.widget.ListView.c
    public void onClick() {
        if (this.aeL != null) {
            this.aeL.onClick(getView());
        }
    }
}
