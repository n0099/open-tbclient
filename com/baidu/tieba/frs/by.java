package com.baidu.tieba.frs;

import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes.dex */
public class by extends com.baidu.adp.widget.ListView.e {
    private View.OnClickListener ZA;
    private final int aKj;
    private boolean aOI;
    private bz aOp;
    private Context mContext;

    @Override // com.baidu.adp.widget.ListView.e
    public View ng() {
        View inflate = com.baidu.adp.lib.g.b.hr().inflate(this.mContext, com.baidu.tieba.r.frs_item_control, null);
        this.aOp = new bz();
        this.aOp.aOJ = (FrameLayout) inflate.findViewById(com.baidu.tieba.q.frs_list_control);
        this.aOp.aOK = (LinearLayout) inflate.findViewById(com.baidu.tieba.q.frs_list_control_in);
        this.aOp.aOM = (ProgressBar) inflate.findViewById(com.baidu.tieba.q.frs_list_control_progress);
        this.aOp.aOL = (TextView) inflate.findViewById(com.baidu.tieba.q.frs_list_control_tv);
        inflate.setTag(this.aOp);
        onChangeSkinType(TbadkCoreApplication.m411getInst().getSkinType());
        return inflate;
    }

    public void onChangeSkinType(int i) {
        if (this.aOp != null) {
            com.baidu.tbadk.core.util.ay.i(this.aOp.aOK, com.baidu.tieba.p.frs_item_control_bg);
            com.baidu.tbadk.core.util.ay.c(this.aOp.aOL, i);
        }
    }

    public void bW(boolean z) {
        this.aOI = z;
        if (this.aOp != null) {
            this.aOp.aOJ.setVisibility(0);
            this.aOp.aOJ.setPadding(0, this.aKj, 0, 0);
            if (z) {
                this.aOp.aOL.setText(com.baidu.tieba.t.loading);
                this.aOp.aOM.setVisibility(0);
                return;
            }
            this.aOp.aOL.setText(com.baidu.tieba.t.frs_pre);
            this.aOp.aOM.setVisibility(8);
        }
    }

    public void j(View.OnClickListener onClickListener) {
        this.ZA = onClickListener;
    }

    @Override // com.baidu.adp.widget.ListView.e
    public void onClick() {
        if (this.ZA != null) {
            this.ZA.onClick(getView());
        }
    }
}
