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
    private View.OnClickListener Ie;
    private boolean aDx;
    private cs aDy;
    private final int ayR;
    private Context mContext;

    public ci(FrsActivity frsActivity) {
        this.mContext = frsActivity;
        this.ayR = this.mContext.getResources().getDimensionPixelSize(com.baidu.tieba.t.listview_item_margin);
    }

    @Override // com.baidu.adp.widget.ListView.h
    public View hA() {
        View inflate = com.baidu.adp.lib.g.b.ek().inflate(this.mContext, com.baidu.tieba.w.frs_item_control, null);
        this.aDy = new cs();
        this.aDy.aDK = (FrameLayout) inflate.findViewById(com.baidu.tieba.v.frs_list_control);
        this.aDy.aDL = (LinearLayout) inflate.findViewById(com.baidu.tieba.v.frs_list_control_in);
        this.aDy.aDN = (ProgressBar) inflate.findViewById(com.baidu.tieba.v.frs_list_control_progress);
        this.aDy.aDM = (TextView) inflate.findViewById(com.baidu.tieba.v.frs_list_control_tv);
        inflate.setTag(this.aDy);
        return inflate;
    }

    public void onChangeSkinType(int i) {
        if (this.aDy != null) {
            com.baidu.tbadk.core.util.aw.h(this.aDy.aDL, com.baidu.tieba.u.frs_item_control_bg);
            com.baidu.tbadk.core.util.aw.b(this.aDy.aDM, i);
        }
    }

    public void bW(boolean z) {
        this.aDx = z;
        this.aDy.aDK.setVisibility(0);
        this.aDy.aDK.setPadding(0, this.ayR, 0, this.ayR);
        if (this.aDx) {
            this.aDy.aDM.setText(com.baidu.tieba.y.loading);
            this.aDy.aDN.setVisibility(0);
        } else {
            this.aDy.aDM.setText(com.baidu.tieba.y.frs_next);
            this.aDy.aDN.setVisibility(8);
        }
        onChangeSkinType(TbadkApplication.m251getInst().getSkinType());
    }

    public void n(View.OnClickListener onClickListener) {
        this.Ie = onClickListener;
    }

    public boolean FK() {
        return this.aDx;
    }

    @Override // com.baidu.adp.widget.ListView.h
    public void onClick() {
        if (this.Ie != null) {
            this.Ie.onClick(getView());
        }
    }
}
