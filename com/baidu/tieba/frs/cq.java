package com.baidu.tieba.frs;

import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes.dex */
public class cq extends com.baidu.adp.widget.ListView.i {
    private View.OnClickListener Nr;
    private final int aBZ;
    private boolean aGF;
    private cr aGj;
    private Context mContext;

    public cq(FrsActivity frsActivity) {
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
        onChangeSkinType(TbadkCoreApplication.m255getInst().getSkinType());
        return inflate;
    }

    public void onChangeSkinType(int i) {
        if (this.aGj != null) {
            com.baidu.tbadk.core.util.bc.i(this.aGj.aGH, com.baidu.tieba.v.frs_item_control_bg);
            com.baidu.tbadk.core.util.bc.c(this.aGj.aGI, i);
        }
    }

    public boolean Gj() {
        return this.aGF;
    }

    public void bL(boolean z) {
        this.aGF = z;
        if (this.aGj != null) {
            this.aGj.aGG.setVisibility(0);
            this.aGj.aGG.setPadding(0, this.aBZ, 0, 0);
            if (z) {
                this.aGj.aGI.setText(com.baidu.tieba.z.loading);
                this.aGj.aGJ.setVisibility(0);
                return;
            }
            this.aGj.aGI.setText(com.baidu.tieba.z.frs_pre);
            this.aGj.aGJ.setVisibility(8);
        }
    }

    public void k(View.OnClickListener onClickListener) {
        this.Nr = onClickListener;
    }

    @Override // com.baidu.adp.widget.ListView.i
    public void onClick() {
        if (this.Nr != null) {
            this.Nr.onClick(getView());
        }
    }
}
