package com.baidu.tieba.account;

import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.av;
import com.baidu.tieba.u;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e implements View.OnClickListener {
    final /* synthetic */ AccountActivity aLu;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(AccountActivity accountActivity) {
        this.aLu = accountActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        TextView textView;
        TextView textView2;
        TextView textView3;
        TextView textView4;
        TextView textView5;
        if (!this.aLu.aLm.IZ()) {
            this.aLu.aLm.setEditState(true);
            textView3 = this.aLu.aLo;
            textView3.setText(u.j.done);
            if (TbadkCoreApplication.m9getInst().getSkinType() == 2) {
                textView5 = this.aLu.aLo;
                av.c(textView5, u.d.navi_op_text, 1);
            } else {
                textView4 = this.aLu.aLo;
                av.c(textView4, u.d.cp_link_tip_a, 1);
            }
            this.aLu.aLm.notifyDataSetChanged();
            return;
        }
        this.aLu.aLm.setEditState(false);
        textView = this.aLu.aLo;
        textView.setText(u.j.edit);
        textView2 = this.aLu.aLo;
        av.c(textView2, u.d.navi_op_text, 1);
        this.aLu.aLm.notifyDataSetChanged();
    }
}
