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
    private final int aKj;
    private boolean aOo;
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
        return inflate;
    }

    public void onChangeSkinType(int i) {
        if (this.aOp != null) {
            com.baidu.tbadk.core.util.ay.i(this.aOp.aOK, com.baidu.tieba.p.frs_item_control_bg);
            com.baidu.tbadk.core.util.ay.c(this.aOp.aOL, i);
        }
    }

    public void bV(boolean z) {
        this.aOo = z;
        this.aOp.aOJ.setVisibility(0);
        this.aOp.aOJ.setPadding(0, this.aKj, 0, this.aKj);
        if (this.aOo) {
            this.aOp.aOL.setText(com.baidu.tieba.t.loading);
            this.aOp.aOM.setVisibility(0);
        } else {
            this.aOp.aOL.setText(com.baidu.tieba.t.frs_next);
            this.aOp.aOM.setVisibility(8);
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
