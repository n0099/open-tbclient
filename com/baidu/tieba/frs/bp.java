package com.baidu.tieba.frs;

import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes.dex */
public class bp extends com.baidu.adp.widget.ListView.e {
    private View.OnClickListener ZA;
    private final int aKk;
    private boolean aOp;
    private bz aOq;
    private Context mContext;

    @Override // com.baidu.adp.widget.ListView.e
    public View ng() {
        View inflate = com.baidu.adp.lib.g.b.hr().inflate(this.mContext, com.baidu.tieba.r.frs_item_control, null);
        this.aOq = new bz();
        this.aOq.aOK = (FrameLayout) inflate.findViewById(com.baidu.tieba.q.frs_list_control);
        this.aOq.aOL = (LinearLayout) inflate.findViewById(com.baidu.tieba.q.frs_list_control_in);
        this.aOq.aON = (ProgressBar) inflate.findViewById(com.baidu.tieba.q.frs_list_control_progress);
        this.aOq.aOM = (TextView) inflate.findViewById(com.baidu.tieba.q.frs_list_control_tv);
        inflate.setTag(this.aOq);
        return inflate;
    }

    public void onChangeSkinType(int i) {
        if (this.aOq != null) {
            com.baidu.tbadk.core.util.ay.i(this.aOq.aOL, com.baidu.tieba.p.frs_item_control_bg);
            com.baidu.tbadk.core.util.ay.c(this.aOq.aOM, i);
        }
    }

    public void bV(boolean z) {
        this.aOp = z;
        this.aOq.aOK.setVisibility(0);
        this.aOq.aOK.setPadding(0, this.aKk, 0, this.aKk);
        if (this.aOp) {
            this.aOq.aOM.setText(com.baidu.tieba.t.loading);
            this.aOq.aON.setVisibility(0);
        } else {
            this.aOq.aOM.setText(com.baidu.tieba.t.frs_next);
            this.aOq.aON.setVisibility(8);
        }
        onChangeSkinType(TbadkCoreApplication.m411getInst().getSkinType());
    }

    public void m(View.OnClickListener onClickListener) {
        this.ZA = onClickListener;
    }

    @Override // com.baidu.adp.widget.ListView.e
    public void onClick() {
        if (this.ZA != null) {
            this.ZA.onClick(getView());
        }
    }
}
