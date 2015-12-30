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
import com.baidu.tieba.n;
/* loaded from: classes.dex */
public class dr extends com.baidu.adp.widget.ListView.c {
    private View.OnClickListener afM;
    private final int bcm;
    private a bhm;
    private boolean bif;
    private Context mContext;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class a {
        FrameLayout bih;
        LinearLayout bii;
        TextView bij;
        ProgressBar bik;
    }

    @Override // com.baidu.adp.widget.ListView.c
    public View mT() {
        View inflate = LayoutInflater.from(this.mContext).inflate(n.h.frs_item_control, (ViewGroup) null);
        this.bhm = new a();
        this.bhm.bih = (FrameLayout) inflate.findViewById(n.g.frs_list_control);
        this.bhm.bii = (LinearLayout) inflate.findViewById(n.g.frs_list_control_in);
        this.bhm.bik = (ProgressBar) inflate.findViewById(n.g.frs_list_control_progress);
        this.bhm.bij = (TextView) inflate.findViewById(n.g.frs_list_control_tv);
        inflate.setTag(this.bhm);
        onChangeSkinType(TbadkCoreApplication.m411getInst().getSkinType());
        return inflate;
    }

    public void onChangeSkinType(int i) {
        if (this.bhm != null) {
            com.baidu.tbadk.core.util.as.i(this.bhm.bii, n.f.frs_item_control_bg);
            com.baidu.tbadk.core.util.as.c(this.bhm.bij, i);
        }
    }

    public void cr(boolean z) {
        this.bif = z;
        if (this.bhm != null) {
            this.bhm.bih.setVisibility(0);
            this.bhm.bih.setPadding(0, this.bcm, 0, 0);
            if (z) {
                this.bhm.bij.setText(n.j.loading);
                this.bhm.bik.setVisibility(0);
                return;
            }
            this.bhm.bij.setText(n.j.frs_pre);
            this.bhm.bik.setVisibility(8);
        }
    }

    public void j(View.OnClickListener onClickListener) {
        this.afM = onClickListener;
    }

    @Override // com.baidu.adp.widget.ListView.c
    public void onClick() {
        if (this.afM != null) {
            this.afM.onClick(getView());
        }
    }
}
