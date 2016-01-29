package com.baidu.tieba.account;

import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tieba.t;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e implements View.OnClickListener {
    final /* synthetic */ AccountActivity aIQ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(AccountActivity accountActivity) {
        this.aIQ = accountActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        TextView textView;
        TextView textView2;
        TextView textView3;
        TextView textView4;
        TextView textView5;
        if (!this.aIQ.aIJ.Il()) {
            this.aIQ.aIJ.setEditState(true);
            textView3 = this.aIQ.aIL;
            textView3.setText(t.j.done);
            if (TbadkCoreApplication.m411getInst().getSkinType() == 2) {
                textView5 = this.aIQ.aIL;
                ar.b(textView5, t.d.navi_op_text, 1);
            } else {
                textView4 = this.aIQ.aIL;
                ar.b(textView4, t.d.cp_link_tip_a, 1);
            }
            this.aIQ.aIJ.notifyDataSetChanged();
            return;
        }
        this.aIQ.aIJ.setEditState(false);
        textView = this.aIQ.aIL;
        textView.setText(t.j.edit);
        textView2 = this.aIQ.aIL;
        ar.b(textView2, t.d.navi_op_text, 1);
        this.aIQ.aIJ.notifyDataSetChanged();
    }
}
