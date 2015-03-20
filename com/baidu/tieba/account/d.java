package com.baidu.tieba.account;

import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.core.util.ba;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d implements View.OnClickListener {
    final /* synthetic */ AccountActivity auu;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(AccountActivity accountActivity) {
        this.auu = accountActivity;
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
        mVar = this.auu.auo;
        if (!mVar.Ei()) {
            mVar4 = this.auu.auo;
            mVar4.setEditState(true);
            textView3 = this.auu.auq;
            textView3.setText(com.baidu.tieba.y.done);
            textView4 = this.auu.auq;
            ba.b(textView4, com.baidu.tieba.s.cp_link_tip_a, 1);
            mVar5 = this.auu.auo;
            mVar5.notifyDataSetChanged();
            return;
        }
        mVar2 = this.auu.auo;
        mVar2.setEditState(false);
        textView = this.auu.auq;
        textView.setText(com.baidu.tieba.y.edit);
        textView2 = this.auu.auq;
        ba.b(textView2, com.baidu.tieba.s.navi_op_text, 1);
        mVar3 = this.auu.auo;
        mVar3.notifyDataSetChanged();
    }
}
