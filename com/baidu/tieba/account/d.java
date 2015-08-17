package com.baidu.tieba.account;

import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.core.util.al;
import com.baidu.tieba.i;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d implements View.OnClickListener {
    final /* synthetic */ AccountActivity aDy;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(AccountActivity accountActivity) {
        this.aDy = accountActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        TextView textView;
        TextView textView2;
        TextView textView3;
        TextView textView4;
        if (!this.aDy.aDs.FR()) {
            this.aDy.aDs.setEditState(true);
            textView3 = this.aDy.aDu;
            textView3.setText(i.C0057i.done);
            textView4 = this.aDy.aDu;
            al.b(textView4, i.c.cp_link_tip_a, 1);
            this.aDy.aDs.notifyDataSetChanged();
            return;
        }
        this.aDy.aDs.setEditState(false);
        textView = this.aDy.aDu;
        textView.setText(i.C0057i.edit);
        textView2 = this.aDy.aDu;
        al.b(textView2, i.c.navi_op_text, 1);
        this.aDy.aDs.notifyDataSetChanged();
    }
}
