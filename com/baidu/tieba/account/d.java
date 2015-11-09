package com.baidu.tieba.account;

import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.an;
import com.baidu.tieba.i;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d implements View.OnClickListener {
    final /* synthetic */ AccountActivity aDq;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(AccountActivity accountActivity) {
        this.aDq = accountActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        TextView textView;
        TextView textView2;
        TextView textView3;
        TextView textView4;
        TextView textView5;
        if (!this.aDq.aDk.FO()) {
            this.aDq.aDk.setEditState(true);
            textView3 = this.aDq.aDm;
            textView3.setText(i.h.done);
            if (TbadkCoreApplication.m411getInst().getSkinType() == 2) {
                textView5 = this.aDq.aDm;
                an.b(textView5, i.c.navi_op_text, 1);
            } else {
                textView4 = this.aDq.aDm;
                an.b(textView4, i.c.cp_link_tip_a, 1);
            }
            this.aDq.aDk.notifyDataSetChanged();
            return;
        }
        this.aDq.aDk.setEditState(false);
        textView = this.aDq.aDm;
        textView.setText(i.h.edit);
        textView2 = this.aDq.aDm;
        an.b(textView2, i.c.navi_op_text, 1);
        this.aDq.aDk.notifyDataSetChanged();
    }
}
