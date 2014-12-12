package com.baidu.tieba.frs;

import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes.dex */
public class cp extends com.baidu.adp.widget.ListView.i {
    private View.OnClickListener MY;
    private final int aBb;
    private cq aFj;
    private boolean aFy;
    private Context mContext;

    public cp(FrsActivity frsActivity) {
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
        onChangeSkinType(TbadkCoreApplication.m255getInst().getSkinType());
        return inflate;
    }

    public void onChangeSkinType(int i) {
        if (this.aFj != null) {
            com.baidu.tbadk.core.util.ax.i(this.aFj.aFA, com.baidu.tieba.v.frs_item_control_bg);
            com.baidu.tbadk.core.util.ax.c(this.aFj.aFB, i);
        }
    }

    public boolean FS() {
        return this.aFy;
    }

    public void bI(boolean z) {
        this.aFy = z;
        if (this.aFj != null) {
            this.aFj.aFz.setVisibility(0);
            this.aFj.aFz.setPadding(0, this.aBb, 0, 0);
            if (z) {
                this.aFj.aFB.setText(com.baidu.tieba.z.loading);
                this.aFj.aFC.setVisibility(0);
                return;
            }
            this.aFj.aFB.setText(com.baidu.tieba.z.frs_pre);
            this.aFj.aFC.setVisibility(8);
        }
    }

    public void j(View.OnClickListener onClickListener) {
        this.MY = onClickListener;
    }

    @Override // com.baidu.adp.widget.ListView.i
    public void onClick() {
        if (this.MY != null) {
            this.MY.onClick(getView());
        }
    }
}
