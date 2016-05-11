package com.baidu.tieba.account;

import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.at;
import com.baidu.tieba.t;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e implements View.OnClickListener {
    final /* synthetic */ AccountActivity aHY;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(AccountActivity accountActivity) {
        this.aHY = accountActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        TextView textView;
        TextView textView2;
        TextView textView3;
        TextView textView4;
        TextView textView5;
        if (!this.aHY.aHQ.HY()) {
            this.aHY.aHQ.setEditState(true);
            textView3 = this.aHY.aHS;
            textView3.setText(t.j.done);
            if (TbadkCoreApplication.m11getInst().getSkinType() == 2) {
                textView5 = this.aHY.aHS;
                at.c(textView5, t.d.navi_op_text, 1);
            } else {
                textView4 = this.aHY.aHS;
                at.c(textView4, t.d.cp_link_tip_a, 1);
            }
            this.aHY.aHQ.notifyDataSetChanged();
            return;
        }
        this.aHY.aHQ.setEditState(false);
        textView = this.aHY.aHS;
        textView.setText(t.j.edit);
        textView2 = this.aHY.aHS;
        at.c(textView2, t.d.navi_op_text, 1);
        this.aHY.aHQ.notifyDataSetChanged();
    }
}
