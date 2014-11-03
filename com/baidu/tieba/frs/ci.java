package com.baidu.tieba.frs;

import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.baidu.tbadk.TbadkApplication;
/* loaded from: classes.dex */
public class ci extends com.baidu.adp.widget.ListView.h {
    private View.OnClickListener If;
    private boolean aDH;
    private cs aDI;
    private final int aza;
    private Context mContext;

    public ci(FrsActivity frsActivity) {
        this.mContext = frsActivity;
        this.aza = this.mContext.getResources().getDimensionPixelSize(com.baidu.tieba.t.listview_item_margin);
    }

    @Override // com.baidu.adp.widget.ListView.h
    public View hA() {
        View inflate = com.baidu.adp.lib.g.b.ek().inflate(this.mContext, com.baidu.tieba.w.frs_item_control, null);
        this.aDI = new cs();
        this.aDI.aDU = (FrameLayout) inflate.findViewById(com.baidu.tieba.v.frs_list_control);
        this.aDI.aDV = (LinearLayout) inflate.findViewById(com.baidu.tieba.v.frs_list_control_in);
        this.aDI.aDX = (ProgressBar) inflate.findViewById(com.baidu.tieba.v.frs_list_control_progress);
        this.aDI.aDW = (TextView) inflate.findViewById(com.baidu.tieba.v.frs_list_control_tv);
        inflate.setTag(this.aDI);
        return inflate;
    }

    public void onChangeSkinType(int i) {
        if (this.aDI != null) {
            com.baidu.tbadk.core.util.aw.h(this.aDI.aDV, com.baidu.tieba.u.frs_item_control_bg);
            com.baidu.tbadk.core.util.aw.b(this.aDI.aDW, i);
        }
    }

    public void bW(boolean z) {
        this.aDH = z;
        this.aDI.aDU.setVisibility(0);
        this.aDI.aDU.setPadding(0, this.aza, 0, this.aza);
        if (this.aDH) {
            this.aDI.aDW.setText(com.baidu.tieba.y.loading);
            this.aDI.aDX.setVisibility(0);
        } else {
            this.aDI.aDW.setText(com.baidu.tieba.y.frs_next);
            this.aDI.aDX.setVisibility(8);
        }
        onChangeSkinType(TbadkApplication.m251getInst().getSkinType());
    }

    public void n(View.OnClickListener onClickListener) {
        this.If = onClickListener;
    }

    public boolean FM() {
        return this.aDH;
    }

    @Override // com.baidu.adp.widget.ListView.h
    public void onClick() {
        if (this.If != null) {
            this.If.onClick(getView());
        }
    }
}
