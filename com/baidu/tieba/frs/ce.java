package com.baidu.tieba.frs;

import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes.dex */
public class ce extends com.baidu.adp.widget.ListView.i {
    private View.OnClickListener Nu;
    private final int aCc;
    private boolean aGl;
    private cr aGm;
    private Context mContext;

    public ce(FrsActivity frsActivity) {
        this.mContext = frsActivity.getPageContext().getPageActivity();
        this.aCc = this.mContext.getResources().getDimensionPixelSize(com.baidu.tieba.u.listview_item_margin);
    }

    @Override // com.baidu.adp.widget.ListView.i
    public View jy() {
        View inflate = com.baidu.adp.lib.g.b.ei().inflate(this.mContext, com.baidu.tieba.x.frs_item_control, null);
        this.aGm = new cr();
        this.aGm.aGJ = (FrameLayout) inflate.findViewById(com.baidu.tieba.w.frs_list_control);
        this.aGm.aGK = (LinearLayout) inflate.findViewById(com.baidu.tieba.w.frs_list_control_in);
        this.aGm.aGM = (ProgressBar) inflate.findViewById(com.baidu.tieba.w.frs_list_control_progress);
        this.aGm.aGL = (TextView) inflate.findViewById(com.baidu.tieba.w.frs_list_control_tv);
        inflate.setTag(this.aGm);
        return inflate;
    }

    public void onChangeSkinType(int i) {
        if (this.aGm != null) {
            com.baidu.tbadk.core.util.bc.i(this.aGm.aGK, com.baidu.tieba.v.frs_item_control_bg);
            com.baidu.tbadk.core.util.bc.c(this.aGm.aGL, i);
        }
    }

    public void bK(boolean z) {
        this.aGl = z;
        this.aGm.aGJ.setVisibility(0);
        this.aGm.aGJ.setPadding(0, this.aCc, 0, this.aCc);
        if (this.aGl) {
            this.aGm.aGL.setText(com.baidu.tieba.z.loading);
            this.aGm.aGM.setVisibility(0);
        } else {
            this.aGm.aGL.setText(com.baidu.tieba.z.frs_next);
            this.aGm.aGM.setVisibility(8);
        }
        onChangeSkinType(TbadkCoreApplication.m255getInst().getSkinType());
    }

    public void n(View.OnClickListener onClickListener) {
        this.Nu = onClickListener;
    }

    public boolean Go() {
        return this.aGl;
    }

    @Override // com.baidu.adp.widget.ListView.i
    public void onClick() {
        if (this.Nu != null) {
            this.Nu.onClick(getView());
        }
    }
}
