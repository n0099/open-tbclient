package com.baidu.tieba.account;

import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tieba.r;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e implements View.OnClickListener {
    final /* synthetic */ AccountActivity aPx;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(AccountActivity accountActivity) {
        this.aPx = accountActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        TextView textView;
        TextView textView2;
        TextView textView3;
        TextView textView4;
        TextView textView5;
        if (!this.aPx.aPp.KU()) {
            this.aPx.aPp.setEditState(true);
            textView3 = this.aPx.aPr;
            textView3.setText(r.l.done);
            if (TbadkCoreApplication.m9getInst().getSkinType() == 2) {
                textView5 = this.aPx.aPr;
                ap.c(textView5, r.e.navi_op_text, 1);
            } else {
                textView4 = this.aPx.aPr;
                ap.c(textView4, r.e.cp_link_tip_a, 1);
            }
            this.aPx.aPp.notifyDataSetChanged();
            return;
        }
        this.aPx.aPp.setEditState(false);
        textView = this.aPx.aPr;
        textView.setText(r.l.edit);
        textView2 = this.aPx.aPr;
        ap.c(textView2, r.e.navi_op_text, 1);
        this.aPx.aPp.notifyDataSetChanged();
    }
}
