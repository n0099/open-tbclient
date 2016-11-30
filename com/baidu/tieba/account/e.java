package com.baidu.tieba.account;

import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.at;
import com.baidu.tieba.r;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e implements View.OnClickListener {
    final /* synthetic */ AccountActivity aUO;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(AccountActivity accountActivity) {
        this.aUO = accountActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        TextView textView;
        TextView textView2;
        TextView textView3;
        TextView textView4;
        TextView textView5;
        if (!this.aUO.aUG.MM()) {
            this.aUO.aUG.setEditState(true);
            textView3 = this.aUO.aUI;
            textView3.setText(r.j.done);
            if (TbadkCoreApplication.m9getInst().getSkinType() == 2) {
                textView5 = this.aUO.aUI;
                at.c(textView5, r.d.navi_op_text, 1);
            } else {
                textView4 = this.aUO.aUI;
                at.c(textView4, r.d.cp_link_tip_a, 1);
            }
            this.aUO.aUG.notifyDataSetChanged();
            return;
        }
        this.aUO.aUG.setEditState(false);
        textView = this.aUO.aUI;
        textView.setText(r.j.edit);
        textView2 = this.aUO.aUI;
        at.c(textView2, r.d.navi_op_text, 1);
        this.aUO.aUG.notifyDataSetChanged();
    }
}
