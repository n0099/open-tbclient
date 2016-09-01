package com.baidu.tieba.account;

import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.av;
import com.baidu.tieba.t;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e implements View.OnClickListener {
    final /* synthetic */ AccountActivity aRI;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(AccountActivity accountActivity) {
        this.aRI = accountActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        TextView textView;
        TextView textView2;
        TextView textView3;
        TextView textView4;
        TextView textView5;
        if (!this.aRI.aRA.LA()) {
            this.aRI.aRA.setEditState(true);
            textView3 = this.aRI.aRC;
            textView3.setText(t.j.done);
            if (TbadkCoreApplication.m9getInst().getSkinType() == 2) {
                textView5 = this.aRI.aRC;
                av.c(textView5, t.d.navi_op_text, 1);
            } else {
                textView4 = this.aRI.aRC;
                av.c(textView4, t.d.cp_link_tip_a, 1);
            }
            this.aRI.aRA.notifyDataSetChanged();
            return;
        }
        this.aRI.aRA.setEditState(false);
        textView = this.aRI.aRC;
        textView.setText(t.j.edit);
        textView2 = this.aRI.aRC;
        av.c(textView2, t.d.navi_op_text, 1);
        this.aRI.aRA.notifyDataSetChanged();
    }
}
