package com.baidu.tieba.account;

import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.an;
import com.baidu.tieba.i;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d implements View.OnClickListener {
    final /* synthetic */ AccountActivity aEw;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(AccountActivity accountActivity) {
        this.aEw = accountActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        TextView textView;
        TextView textView2;
        TextView textView3;
        TextView textView4;
        TextView textView5;
        if (!this.aEw.aEq.FV()) {
            this.aEw.aEq.setEditState(true);
            textView3 = this.aEw.aEs;
            textView3.setText(i.h.done);
            if (TbadkCoreApplication.m411getInst().getSkinType() == 2) {
                textView5 = this.aEw.aEs;
                an.b(textView5, i.c.navi_op_text, 1);
            } else {
                textView4 = this.aEw.aEs;
                an.b(textView4, i.c.cp_link_tip_a, 1);
            }
            this.aEw.aEq.notifyDataSetChanged();
            return;
        }
        this.aEw.aEq.setEditState(false);
        textView = this.aEw.aEs;
        textView.setText(i.h.edit);
        textView2 = this.aEw.aEs;
        an.b(textView2, i.c.navi_op_text, 1);
        this.aEw.aEq.notifyDataSetChanged();
    }
}
