package com.baidu.tieba.frs;

import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes.dex */
public class br extends com.baidu.adp.widget.ListView.e {
    private View.OnClickListener YA;
    private final int aHT;
    private boolean aLT;
    private ca aLU;
    private Context mContext;

    public br(FrsActivity frsActivity) {
        this.mContext = frsActivity.getPageContext().getPageActivity();
        this.aHT = this.mContext.getResources().getDimensionPixelSize(com.baidu.tieba.t.listview_item_margin);
    }

    @Override // com.baidu.adp.widget.ListView.e
    public View mN() {
        View inflate = com.baidu.adp.lib.g.b.hH().inflate(this.mContext, com.baidu.tieba.w.frs_item_control, null);
        this.aLU = new ca();
        this.aLU.aMo = (FrameLayout) inflate.findViewById(com.baidu.tieba.v.frs_list_control);
        this.aLU.aMp = (LinearLayout) inflate.findViewById(com.baidu.tieba.v.frs_list_control_in);
        this.aLU.aMr = (ProgressBar) inflate.findViewById(com.baidu.tieba.v.frs_list_control_progress);
        this.aLU.aMq = (TextView) inflate.findViewById(com.baidu.tieba.v.frs_list_control_tv);
        inflate.setTag(this.aLU);
        return inflate;
    }

    public void onChangeSkinType(int i) {
        if (this.aLU != null) {
            com.baidu.tbadk.core.util.ba.i(this.aLU.aMp, com.baidu.tieba.u.frs_item_control_bg);
            com.baidu.tbadk.core.util.ba.c(this.aLU.aMq, i);
        }
    }

    public void bM(boolean z) {
        this.aLT = z;
        this.aLU.aMo.setVisibility(0);
        this.aLU.aMo.setPadding(0, this.aHT, 0, this.aHT);
        if (this.aLT) {
            this.aLU.aMq.setText(com.baidu.tieba.y.loading);
            this.aLU.aMr.setVisibility(0);
        } else {
            this.aLU.aMq.setText(com.baidu.tieba.y.frs_next);
            this.aLU.aMr.setVisibility(8);
        }
        onChangeSkinType(TbadkCoreApplication.m411getInst().getSkinType());
    }

    public void m(View.OnClickListener onClickListener) {
        this.YA = onClickListener;
    }

    @Override // com.baidu.adp.widget.ListView.e
    public void onClick() {
        if (this.YA != null) {
            this.YA.onClick(getView());
        }
    }
}
