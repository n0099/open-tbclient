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
    private final int aYn;
    private View.OnClickListener afa;
    private a bdm;
    private boolean bel;
    private Context mContext;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class a {
        FrameLayout bem;
        LinearLayout ben;
        TextView beo;
        ProgressBar bep;
    }

    @Override // com.baidu.adp.widget.ListView.c
    public View nv() {
        View inflate = LayoutInflater.from(this.mContext).inflate(n.g.frs_item_control, (ViewGroup) null);
        this.bdm = new a();
        this.bdm.bem = (FrameLayout) inflate.findViewById(n.f.frs_list_control);
        this.bdm.ben = (LinearLayout) inflate.findViewById(n.f.frs_list_control_in);
        this.bdm.bep = (ProgressBar) inflate.findViewById(n.f.frs_list_control_progress);
        this.bdm.beo = (TextView) inflate.findViewById(n.f.frs_list_control_tv);
        inflate.setTag(this.bdm);
        onChangeSkinType(TbadkCoreApplication.m411getInst().getSkinType());
        return inflate;
    }

    public void onChangeSkinType(int i) {
        if (this.bdm != null) {
            com.baidu.tbadk.core.util.as.i(this.bdm.ben, n.e.frs_item_control_bg);
            com.baidu.tbadk.core.util.as.c(this.bdm.beo, i);
        }
    }

    public void cq(boolean z) {
        this.bel = z;
        if (this.bdm != null) {
            this.bdm.bem.setVisibility(0);
            this.bdm.bem.setPadding(0, this.aYn, 0, 0);
            if (z) {
                this.bdm.beo.setText(n.i.loading);
                this.bdm.bep.setVisibility(0);
                return;
            }
            this.bdm.beo.setText(n.i.frs_pre);
            this.bdm.bep.setVisibility(8);
        }
    }

    public void j(View.OnClickListener onClickListener) {
        this.afa = onClickListener;
    }

    @Override // com.baidu.adp.widget.ListView.c
    public void onClick() {
        if (this.afa != null) {
            this.afa.onClick(getView());
        }
    }
}
