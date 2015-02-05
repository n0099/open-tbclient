package com.baidu.tieba.account;

import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.bc;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e implements View.OnClickListener {
    final /* synthetic */ AccountActivity amF;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(AccountActivity accountActivity) {
        this.amF = accountActivity;
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
        mVar = this.amF.amA;
        if (!mVar.AT()) {
            mVar4 = this.amF.amA;
            mVar4.setEditState(true);
            textView3 = this.amF.amB;
            textView3.setText(com.baidu.tieba.z.done);
            textView4 = this.amF.amB;
            bc.g(textView4, TbadkCoreApplication.m255getInst().getSkinType());
            mVar5 = this.amF.amA;
            mVar5.notifyDataSetChanged();
            return;
        }
        mVar2 = this.amF.amA;
        mVar2.setEditState(false);
        textView = this.amF.amB;
        textView.setText(com.baidu.tieba.z.edit);
        textView2 = this.amF.amB;
        bc.i(textView2, TbadkCoreApplication.m255getInst().getSkinType());
        mVar3 = this.amF.amA;
        mVar3.notifyDataSetChanged();
    }
}
