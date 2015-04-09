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
    private View.OnClickListener YC;
    private final int aIb;
    private boolean aMe;
    private ca aMf;
    private Context mContext;

    @Override // com.baidu.adp.widget.ListView.e
    public View mN() {
        View inflate = com.baidu.adp.lib.g.b.hH().inflate(this.mContext, com.baidu.tieba.w.frs_item_control, null);
        this.aMf = new ca();
        this.aMf.aMz = (FrameLayout) inflate.findViewById(com.baidu.tieba.v.frs_list_control);
        this.aMf.aMA = (LinearLayout) inflate.findViewById(com.baidu.tieba.v.frs_list_control_in);
        this.aMf.aMC = (ProgressBar) inflate.findViewById(com.baidu.tieba.v.frs_list_control_progress);
        this.aMf.aMB = (TextView) inflate.findViewById(com.baidu.tieba.v.frs_list_control_tv);
        inflate.setTag(this.aMf);
        return inflate;
    }

    public void onChangeSkinType(int i) {
        if (this.aMf != null) {
            com.baidu.tbadk.core.util.ba.i(this.aMf.aMA, com.baidu.tieba.u.frs_item_control_bg);
            com.baidu.tbadk.core.util.ba.c(this.aMf.aMB, i);
        }
    }

    public void bM(boolean z) {
        this.aMe = z;
        this.aMf.aMz.setVisibility(0);
        this.aMf.aMz.setPadding(0, this.aIb, 0, this.aIb);
        if (this.aMe) {
            this.aMf.aMB.setText(com.baidu.tieba.y.loading);
            this.aMf.aMC.setVisibility(0);
        } else {
            this.aMf.aMB.setText(com.baidu.tieba.y.frs_next);
            this.aMf.aMC.setVisibility(8);
        }
        onChangeSkinType(TbadkCoreApplication.m411getInst().getSkinType());
    }

    public void m(View.OnClickListener onClickListener) {
        this.YC = onClickListener;
    }

    @Override // com.baidu.adp.widget.ListView.e
    public void onClick() {
        if (this.YC != null) {
            this.YC.onClick(getView());
        }
    }
}
