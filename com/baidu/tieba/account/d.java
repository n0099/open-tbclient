package com.baidu.tieba.account;

import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.util.bc;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d implements View.OnClickListener {
    final /* synthetic */ AccountActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(AccountActivity accountActivity) {
        this.a = accountActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        l lVar;
        l lVar2;
        TextView textView;
        TextView textView2;
        l lVar3;
        l lVar4;
        TextView textView3;
        TextView textView4;
        l lVar5;
        lVar = this.a.b;
        if (!lVar.a()) {
            lVar4 = this.a.b;
            lVar4.a(true);
            textView3 = this.a.f;
            textView3.setText(com.baidu.tieba.u.done);
            textView4 = this.a.f;
            bc.g(textView4, TbadkApplication.m252getInst().getSkinType());
            lVar5 = this.a.b;
            lVar5.notifyDataSetChanged();
            return;
        }
        lVar2 = this.a.b;
        lVar2.a(false);
        textView = this.a.f;
        textView.setText(com.baidu.tieba.u.edit);
        textView2 = this.a.f;
        bc.i(textView2, TbadkApplication.m252getInst().getSkinType());
        lVar3 = this.a.b;
        lVar3.notifyDataSetChanged();
    }
}
