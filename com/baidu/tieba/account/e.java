package com.baidu.tieba.account;

import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.at;
import com.baidu.tieba.t;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e implements View.OnClickListener {
    final /* synthetic */ AccountActivity aLN;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(AccountActivity accountActivity) {
        this.aLN = accountActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        TextView textView;
        TextView textView2;
        TextView textView3;
        TextView textView4;
        TextView textView5;
        if (!this.aLN.aLF.JH()) {
            this.aLN.aLF.setEditState(true);
            textView3 = this.aLN.aLH;
            textView3.setText(t.j.done);
            if (TbadkCoreApplication.m411getInst().getSkinType() == 2) {
                textView5 = this.aLN.aLH;
                at.b(textView5, t.d.navi_op_text, 1);
            } else {
                textView4 = this.aLN.aLH;
                at.b(textView4, t.d.cp_link_tip_a, 1);
            }
            this.aLN.aLF.notifyDataSetChanged();
            return;
        }
        this.aLN.aLF.setEditState(false);
        textView = this.aLN.aLH;
        textView.setText(t.j.edit);
        textView2 = this.aLN.aLH;
        at.b(textView2, t.d.navi_op_text, 1);
        this.aLN.aLF.notifyDataSetChanged();
    }
}
