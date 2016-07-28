package com.baidu.tieba.account;

import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.av;
import com.baidu.tieba.u;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e implements View.OnClickListener {
    final /* synthetic */ AccountActivity aMo;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(AccountActivity accountActivity) {
        this.aMo = accountActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        TextView textView;
        TextView textView2;
        TextView textView3;
        TextView textView4;
        TextView textView5;
        if (!this.aMo.aMg.IY()) {
            this.aMo.aMg.setEditState(true);
            textView3 = this.aMo.aMi;
            textView3.setText(u.j.done);
            if (TbadkCoreApplication.m10getInst().getSkinType() == 2) {
                textView5 = this.aMo.aMi;
                av.c(textView5, u.d.navi_op_text, 1);
            } else {
                textView4 = this.aMo.aMi;
                av.c(textView4, u.d.cp_link_tip_a, 1);
            }
            this.aMo.aMg.notifyDataSetChanged();
            return;
        }
        this.aMo.aMg.setEditState(false);
        textView = this.aMo.aMi;
        textView.setText(u.j.edit);
        textView2 = this.aMo.aMi;
        av.c(textView2, u.d.navi_op_text, 1);
        this.aMo.aMg.notifyDataSetChanged();
    }
}
