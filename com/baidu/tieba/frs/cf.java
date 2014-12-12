package com.baidu.tieba.frs;

import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes.dex */
public class cf extends com.baidu.adp.widget.ListView.i {
    private View.OnClickListener MY;
    private final int aBb;
    private boolean aFi;
    private cq aFj;
    private Context mContext;

    public cf(FrsActivity frsActivity) {
        this.mContext = frsActivity.getPageContext().getPageActivity();
        this.aBb = this.mContext.getResources().getDimensionPixelSize(com.baidu.tieba.u.listview_item_margin);
    }

    @Override // com.baidu.adp.widget.ListView.i
    public View jx() {
        View inflate = com.baidu.adp.lib.g.b.ek().inflate(this.mContext, com.baidu.tieba.x.frs_item_control, null);
        this.aFj = new cq();
        this.aFj.aFz = (FrameLayout) inflate.findViewById(com.baidu.tieba.w.frs_list_control);
        this.aFj.aFA = (LinearLayout) inflate.findViewById(com.baidu.tieba.w.frs_list_control_in);
        this.aFj.aFC = (ProgressBar) inflate.findViewById(com.baidu.tieba.w.frs_list_control_progress);
        this.aFj.aFB = (TextView) inflate.findViewById(com.baidu.tieba.w.frs_list_control_tv);
        inflate.setTag(this.aFj);
        return inflate;
    }

    public void onChangeSkinType(int i) {
        if (this.aFj != null) {
            com.baidu.tbadk.core.util.ax.i(this.aFj.aFA, com.baidu.tieba.v.frs_item_control_bg);
            com.baidu.tbadk.core.util.ax.c(this.aFj.aFB, i);
        }
    }

    public void bH(boolean z) {
        this.aFi = z;
        this.aFj.aFz.setVisibility(0);
        this.aFj.aFz.setPadding(0, this.aBb, 0, this.aBb);
        if (this.aFi) {
            this.aFj.aFB.setText(com.baidu.tieba.z.loading);
            this.aFj.aFC.setVisibility(0);
        } else {
            this.aFj.aFB.setText(com.baidu.tieba.z.frs_next);
            this.aFj.aFC.setVisibility(8);
        }
        onChangeSkinType(TbadkCoreApplication.m255getInst().getSkinType());
    }

    public void m(View.OnClickListener onClickListener) {
        this.MY = onClickListener;
    }

    public boolean FR() {
        return this.aFi;
    }

    @Override // com.baidu.adp.widget.ListView.i
    public void onClick() {
        if (this.MY != null) {
            this.MY.onClick(getView());
        }
    }
}
