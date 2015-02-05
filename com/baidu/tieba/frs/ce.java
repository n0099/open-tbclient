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
    private View.OnClickListener Nr;
    private final int aBZ;
    private boolean aGi;
    private cr aGj;
    private Context mContext;

    public ce(FrsActivity frsActivity) {
        this.mContext = frsActivity.getPageContext().getPageActivity();
        this.aBZ = this.mContext.getResources().getDimensionPixelSize(com.baidu.tieba.u.listview_item_margin);
    }

    @Override // com.baidu.adp.widget.ListView.i
    public View jr() {
        View inflate = com.baidu.adp.lib.g.b.ei().inflate(this.mContext, com.baidu.tieba.x.frs_item_control, null);
        this.aGj = new cr();
        this.aGj.aGG = (FrameLayout) inflate.findViewById(com.baidu.tieba.w.frs_list_control);
        this.aGj.aGH = (LinearLayout) inflate.findViewById(com.baidu.tieba.w.frs_list_control_in);
        this.aGj.aGJ = (ProgressBar) inflate.findViewById(com.baidu.tieba.w.frs_list_control_progress);
        this.aGj.aGI = (TextView) inflate.findViewById(com.baidu.tieba.w.frs_list_control_tv);
        inflate.setTag(this.aGj);
        return inflate;
    }

    public void onChangeSkinType(int i) {
        if (this.aGj != null) {
            com.baidu.tbadk.core.util.bc.i(this.aGj.aGH, com.baidu.tieba.v.frs_item_control_bg);
            com.baidu.tbadk.core.util.bc.c(this.aGj.aGI, i);
        }
    }

    public void bK(boolean z) {
        this.aGi = z;
        this.aGj.aGG.setVisibility(0);
        this.aGj.aGG.setPadding(0, this.aBZ, 0, this.aBZ);
        if (this.aGi) {
            this.aGj.aGI.setText(com.baidu.tieba.z.loading);
            this.aGj.aGJ.setVisibility(0);
        } else {
            this.aGj.aGI.setText(com.baidu.tieba.z.frs_next);
            this.aGj.aGJ.setVisibility(8);
        }
        onChangeSkinType(TbadkCoreApplication.m255getInst().getSkinType());
    }

    public void n(View.OnClickListener onClickListener) {
        this.Nr = onClickListener;
    }

    public boolean Gi() {
        return this.aGi;
    }

    @Override // com.baidu.adp.widget.ListView.i
    public void onClick() {
        if (this.Nr != null) {
            this.Nr.onClick(getView());
        }
    }
}
