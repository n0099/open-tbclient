package com.baidu.tieba.account;

import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tieba.w;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e implements View.OnClickListener {
    final /* synthetic */ AccountActivity aVj;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(AccountActivity accountActivity) {
        this.aVj = accountActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        TextView textView;
        TextView textView2;
        TextView textView3;
        TextView textView4;
        TextView textView5;
        if (!this.aVj.aVb.Lz()) {
            this.aVj.aVb.setEditState(true);
            textView3 = this.aVj.aVd;
            textView3.setText(w.l.done);
            if (TbadkCoreApplication.m9getInst().getSkinType() == 2) {
                textView5 = this.aVj.aVd;
                aq.c(textView5, w.e.navi_op_text, 1);
            } else {
                textView4 = this.aVj.aVd;
                aq.c(textView4, w.e.cp_link_tip_a, 1);
            }
            this.aVj.aVb.notifyDataSetChanged();
            return;
        }
        this.aVj.aVb.setEditState(false);
        textView = this.aVj.aVd;
        textView.setText(w.l.edit);
        textView2 = this.aVj.aVd;
        aq.c(textView2, w.e.navi_op_text, 1);
        this.aVj.aVb.notifyDataSetChanged();
    }
}
