package com.baidu.tieba.account;

import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.as;
import com.baidu.tieba.n;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e implements View.OnClickListener {
    final /* synthetic */ AccountActivity aHO;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(AccountActivity accountActivity) {
        this.aHO = accountActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        TextView textView;
        TextView textView2;
        TextView textView3;
        TextView textView4;
        TextView textView5;
        if (!this.aHO.aHH.GK()) {
            this.aHO.aHH.setEditState(true);
            textView3 = this.aHO.aHJ;
            textView3.setText(n.j.done);
            if (TbadkCoreApplication.m411getInst().getSkinType() == 2) {
                textView5 = this.aHO.aHJ;
                as.b(textView5, n.d.navi_op_text, 1);
            } else {
                textView4 = this.aHO.aHJ;
                as.b(textView4, n.d.cp_link_tip_a, 1);
            }
            this.aHO.aHH.notifyDataSetChanged();
            return;
        }
        this.aHO.aHH.setEditState(false);
        textView = this.aHO.aHJ;
        textView.setText(n.j.edit);
        textView2 = this.aHO.aHJ;
        as.b(textView2, n.d.navi_op_text, 1);
        this.aHO.aHH.notifyDataSetChanged();
    }
}
