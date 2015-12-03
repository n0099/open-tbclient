package com.baidu.tieba.account;

import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.as;
import com.baidu.tieba.n;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d implements View.OnClickListener {
    final /* synthetic */ AccountActivity aGn;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(AccountActivity accountActivity) {
        this.aGn = accountActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        TextView textView;
        TextView textView2;
        TextView textView3;
        TextView textView4;
        TextView textView5;
        if (!this.aGn.aGh.GV()) {
            this.aGn.aGh.setEditState(true);
            textView3 = this.aGn.aGj;
            textView3.setText(n.i.done);
            if (TbadkCoreApplication.m411getInst().getSkinType() == 2) {
                textView5 = this.aGn.aGj;
                as.b(textView5, n.c.navi_op_text, 1);
            } else {
                textView4 = this.aGn.aGj;
                as.b(textView4, n.c.cp_link_tip_a, 1);
            }
            this.aGn.aGh.notifyDataSetChanged();
            return;
        }
        this.aGn.aGh.setEditState(false);
        textView = this.aGn.aGj;
        textView.setText(n.i.edit);
        textView2 = this.aGn.aGj;
        as.b(textView2, n.c.navi_op_text, 1);
        this.aGn.aGh.notifyDataSetChanged();
    }
}
