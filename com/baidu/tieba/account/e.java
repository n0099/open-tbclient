package com.baidu.tieba.account;

import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.bc;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e implements View.OnClickListener {
    final /* synthetic */ AccountActivity amI;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(AccountActivity accountActivity) {
        this.amI = accountActivity;
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
        mVar = this.amI.amD;
        if (!mVar.AZ()) {
            mVar4 = this.amI.amD;
            mVar4.setEditState(true);
            textView3 = this.amI.amE;
            textView3.setText(com.baidu.tieba.z.done);
            textView4 = this.amI.amE;
            bc.g(textView4, TbadkCoreApplication.m255getInst().getSkinType());
            mVar5 = this.amI.amD;
            mVar5.notifyDataSetChanged();
            return;
        }
        mVar2 = this.amI.amD;
        mVar2.setEditState(false);
        textView = this.amI.amE;
        textView.setText(com.baidu.tieba.z.edit);
        textView2 = this.amI.amE;
        bc.i(textView2, TbadkCoreApplication.m255getInst().getSkinType());
        mVar3 = this.amI.amD;
        mVar3.notifyDataSetChanged();
    }
}
