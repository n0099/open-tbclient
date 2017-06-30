package com.baidu.tieba.account;

import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.as;
import com.baidu.tieba.w;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e implements View.OnClickListener {
    final /* synthetic */ AccountActivity aUP;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(AccountActivity accountActivity) {
        this.aUP = accountActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        TextView textView;
        TextView textView2;
        TextView textView3;
        TextView textView4;
        TextView textView5;
        if (!this.aUP.aUH.KH()) {
            this.aUP.aUH.setEditState(true);
            textView3 = this.aUP.aUJ;
            textView3.setText(w.l.done);
            if (TbadkCoreApplication.m9getInst().getSkinType() == 2) {
                textView5 = this.aUP.aUJ;
                as.c(textView5, w.e.navi_op_text, 1);
            } else {
                textView4 = this.aUP.aUJ;
                as.c(textView4, w.e.cp_link_tip_a, 1);
            }
            this.aUP.aUH.notifyDataSetChanged();
            return;
        }
        this.aUP.aUH.setEditState(false);
        textView = this.aUP.aUJ;
        textView.setText(w.l.edit);
        textView2 = this.aUP.aUJ;
        as.c(textView2, w.e.navi_op_text, 1);
        this.aUP.aUH.notifyDataSetChanged();
    }
}
