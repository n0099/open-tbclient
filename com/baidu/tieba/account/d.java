package com.baidu.tieba.account;

import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.core.util.ba;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d implements View.OnClickListener {
    final /* synthetic */ AccountActivity auC;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(AccountActivity accountActivity) {
        this.auC = accountActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        m mVar;
        m mVar2;
        TextView textView;
        TextView textView2;
        m mVar3;
        m mVar4;
        TextView textView3;
        TextView textView4;
        m mVar5;
        mVar = this.auC.auw;
        if (!mVar.Eo()) {
            mVar4 = this.auC.auw;
            mVar4.setEditState(true);
            textView3 = this.auC.auy;
            textView3.setText(com.baidu.tieba.y.done);
            textView4 = this.auC.auy;
            ba.b(textView4, com.baidu.tieba.s.cp_link_tip_a, 1);
            mVar5 = this.auC.auw;
            mVar5.notifyDataSetChanged();
            return;
        }
        mVar2 = this.auC.auw;
        mVar2.setEditState(false);
        textView = this.auC.auy;
        textView.setText(com.baidu.tieba.y.edit);
        textView2 = this.auC.auy;
        ba.b(textView2, com.baidu.tieba.s.navi_op_text, 1);
        mVar3 = this.auC.auw;
        mVar3.notifyDataSetChanged();
    }
}
