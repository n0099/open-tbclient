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
public class cr extends com.baidu.adp.widget.ListView.c {
    private final int aYn;
    private View.OnClickListener afa;
    private boolean bdl;
    private dr.a bdm;
    private Context mContext;

    @Override // com.baidu.adp.widget.ListView.c
    public View nv() {
        View inflate = LayoutInflater.from(this.mContext).inflate(n.g.frs_item_control, (ViewGroup) null);
        this.bdm = new dr.a();
        this.bdm.bem = (FrameLayout) inflate.findViewById(n.f.frs_list_control);
        this.bdm.ben = (LinearLayout) inflate.findViewById(n.f.frs_list_control_in);
        this.bdm.bep = (ProgressBar) inflate.findViewById(n.f.frs_list_control_progress);
        this.bdm.beo = (TextView) inflate.findViewById(n.f.frs_list_control_tv);
        inflate.setTag(this.bdm);
        return inflate;
    }

    public void onChangeSkinType(int i) {
        if (this.bdm != null) {
            com.baidu.tbadk.core.util.as.i(this.bdm.ben, n.e.frs_item_control_bg);
            com.baidu.tbadk.core.util.as.c(this.bdm.beo, i);
        }
    }

    public void cp(boolean z) {
        this.bdl = z;
        this.bdm.bem.setVisibility(0);
        this.bdm.bem.setPadding(0, this.aYn, 0, this.aYn);
        if (this.bdl) {
            this.bdm.beo.setText(n.i.loading);
            this.bdm.bep.setVisibility(0);
        } else {
            this.bdm.beo.setText(n.i.frs_next);
            this.bdm.bep.setVisibility(8);
        }
        onChangeSkinType(TbadkCoreApplication.m411getInst().getSkinType());
    }

    public void m(View.OnClickListener onClickListener) {
        this.afa = onClickListener;
    }

    @Override // com.baidu.adp.widget.ListView.c
    public void onClick() {
        if (this.afa != null) {
            this.afa.onClick(getView());
        }
    }
}
