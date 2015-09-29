package com.baidu.tieba.account;

import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.am;
import com.baidu.tieba.i;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d implements View.OnClickListener {
    final /* synthetic */ AccountActivity aEl;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(AccountActivity accountActivity) {
        this.aEl = accountActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        TextView textView;
        TextView textView2;
        TextView textView3;
        TextView textView4;
        TextView textView5;
        if (!this.aEl.aEf.FV()) {
            this.aEl.aEf.setEditState(true);
            textView3 = this.aEl.aEh;
            textView3.setText(i.h.done);
            if (TbadkCoreApplication.m411getInst().getSkinType() == 2) {
                textView5 = this.aEl.aEh;
                am.b(textView5, i.c.navi_op_text, 1);
            } else {
                textView4 = this.aEl.aEh;
                am.b(textView4, i.c.cp_link_tip_a, 1);
            }
            this.aEl.aEf.notifyDataSetChanged();
            return;
        }
        this.aEl.aEf.setEditState(false);
        textView = this.aEl.aEh;
        textView.setText(i.h.edit);
        textView2 = this.aEl.aEh;
        am.b(textView2, i.c.navi_op_text, 1);
        this.aEl.aEf.notifyDataSetChanged();
    }
}
