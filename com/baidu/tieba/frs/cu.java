package com.baidu.tieba.frs;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.frs.dr;
import com.baidu.tieba.n;
/* loaded from: classes.dex */
public class cu extends com.baidu.adp.widget.ListView.c {
    private View.OnClickListener afM;
    private final int bcm;
    private boolean bhl;
    private dr.a bhm;
    private Context mContext;

    @Override // com.baidu.adp.widget.ListView.c
    public View mT() {
        View inflate = LayoutInflater.from(this.mContext).inflate(n.h.frs_item_control, (ViewGroup) null);
        this.bhm = new dr.a();
        this.bhm.bih = (FrameLayout) inflate.findViewById(n.g.frs_list_control);
        this.bhm.bii = (LinearLayout) inflate.findViewById(n.g.frs_list_control_in);
        this.bhm.bik = (ProgressBar) inflate.findViewById(n.g.frs_list_control_progress);
        this.bhm.bij = (TextView) inflate.findViewById(n.g.frs_list_control_tv);
        inflate.setTag(this.bhm);
        return inflate;
    }

    public void onChangeSkinType(int i) {
        if (this.bhm != null) {
            com.baidu.tbadk.core.util.as.i(this.bhm.bii, n.f.frs_item_control_bg);
            com.baidu.tbadk.core.util.as.c(this.bhm.bij, i);
        }
    }

    public void cq(boolean z) {
        this.bhl = z;
        this.bhm.bih.setVisibility(0);
        this.bhm.bih.setPadding(0, this.bcm, 0, this.bcm);
        if (this.bhl) {
            this.bhm.bij.setText(n.j.loading);
            this.bhm.bik.setVisibility(0);
        } else {
            this.bhm.bij.setText(n.j.frs_next);
            this.bhm.bik.setVisibility(8);
        }
        onChangeSkinType(TbadkCoreApplication.m411getInst().getSkinType());
    }

    public void m(View.OnClickListener onClickListener) {
        this.afM = onClickListener;
    }

    @Override // com.baidu.adp.widget.ListView.c
    public void onClick() {
        if (this.afM != null) {
            this.afM.onClick(getView());
        }
    }
}
