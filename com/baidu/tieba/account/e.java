package com.baidu.tieba.account;

import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.av;
import com.baidu.tieba.r;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e implements View.OnClickListener {
    final /* synthetic */ AccountActivity aSN;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(AccountActivity accountActivity) {
        this.aSN = accountActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        TextView textView;
        TextView textView2;
        TextView textView3;
        TextView textView4;
        TextView textView5;
        if (!this.aSN.aSF.Mg()) {
            this.aSN.aSF.setEditState(true);
            textView3 = this.aSN.aSH;
            textView3.setText(r.j.done);
            if (TbadkCoreApplication.m9getInst().getSkinType() == 2) {
                textView5 = this.aSN.aSH;
                av.c(textView5, r.d.navi_op_text, 1);
            } else {
                textView4 = this.aSN.aSH;
                av.c(textView4, r.d.cp_link_tip_a, 1);
            }
            this.aSN.aSF.notifyDataSetChanged();
            return;
        }
        this.aSN.aSF.setEditState(false);
        textView = this.aSN.aSH;
        textView.setText(r.j.edit);
        textView2 = this.aSN.aSH;
        av.c(textView2, r.d.navi_op_text, 1);
        this.aSN.aSF.notifyDataSetChanged();
    }
}
