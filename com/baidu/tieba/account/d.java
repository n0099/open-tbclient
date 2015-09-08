package com.baidu.tieba.account;

import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.core.util.al;
import com.baidu.tieba.i;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d implements View.OnClickListener {
    final /* synthetic */ AccountActivity aFg;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(AccountActivity accountActivity) {
        this.aFg = accountActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        TextView textView;
        TextView textView2;
        TextView textView3;
        TextView textView4;
        if (!this.aFg.aFa.Gb()) {
            this.aFg.aFa.setEditState(true);
            textView3 = this.aFg.aFc;
            textView3.setText(i.h.done);
            textView4 = this.aFg.aFc;
            al.b(textView4, i.c.cp_link_tip_a, 1);
            this.aFg.aFa.notifyDataSetChanged();
            return;
        }
        this.aFg.aFa.setEditState(false);
        textView = this.aFg.aFc;
        textView.setText(i.h.edit);
        textView2 = this.aFg.aFc;
        al.b(textView2, i.c.navi_op_text, 1);
        this.aFg.aFa.notifyDataSetChanged();
    }
}
