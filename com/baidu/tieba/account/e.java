package com.baidu.tieba.account;

import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tieba.r;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e implements View.OnClickListener {
    final /* synthetic */ AccountActivity aUf;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(AccountActivity accountActivity) {
        this.aUf = accountActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        TextView textView;
        TextView textView2;
        TextView textView3;
        TextView textView4;
        TextView textView5;
        if (!this.aUf.aTX.Mf()) {
            this.aUf.aTX.setEditState(true);
            textView3 = this.aUf.aTZ;
            textView3.setText(r.j.done);
            if (TbadkCoreApplication.m9getInst().getSkinType() == 2) {
                textView5 = this.aUf.aTZ;
                ar.c(textView5, r.d.navi_op_text, 1);
            } else {
                textView4 = this.aUf.aTZ;
                ar.c(textView4, r.d.cp_link_tip_a, 1);
            }
            this.aUf.aTX.notifyDataSetChanged();
            return;
        }
        this.aUf.aTX.setEditState(false);
        textView = this.aUf.aTZ;
        textView.setText(r.j.edit);
        textView2 = this.aUf.aTZ;
        ar.c(textView2, r.d.navi_op_text, 1);
        this.aUf.aTX.notifyDataSetChanged();
    }
}
