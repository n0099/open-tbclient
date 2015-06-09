package com.baidu.tieba.account;

import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.core.util.ay;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e implements View.OnClickListener {
    final /* synthetic */ AccountActivity awg;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(AccountActivity accountActivity) {
        this.awg = accountActivity;
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
        mVar = this.awg.awa;
        if (!mVar.Fc()) {
            mVar4 = this.awg.awa;
            mVar4.setEditState(true);
            textView3 = this.awg.awc;
            textView3.setText(com.baidu.tieba.t.done);
            textView4 = this.awg.awc;
            ay.b(textView4, com.baidu.tieba.n.cp_link_tip_a, 1);
            mVar5 = this.awg.awa;
            mVar5.notifyDataSetChanged();
            return;
        }
        mVar2 = this.awg.awa;
        mVar2.setEditState(false);
        textView = this.awg.awc;
        textView.setText(com.baidu.tieba.t.edit);
        textView2 = this.awg.awc;
        ay.b(textView2, com.baidu.tieba.n.navi_op_text, 1);
        mVar3 = this.awg.awa;
        mVar3.notifyDataSetChanged();
    }
}
