package com.baidu.tieba.account;

import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.util.aw;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d implements View.OnClickListener {
    final /* synthetic */ AccountActivity aeo;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(AccountActivity accountActivity) {
        this.aeo = accountActivity;
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
        lVar = this.aeo.aej;
        if (!lVar.xd()) {
            lVar4 = this.aeo.aej;
            lVar4.setEditState(true);
            textView3 = this.aeo.aek;
            textView3.setText(com.baidu.tieba.y.done);
            textView4 = this.aeo.aek;
            aw.f(textView4, TbadkApplication.m251getInst().getSkinType());
            lVar5 = this.aeo.aej;
            lVar5.notifyDataSetChanged();
            return;
        }
        lVar2 = this.aeo.aej;
        lVar2.setEditState(false);
        textView = this.aeo.aek;
        textView.setText(com.baidu.tieba.y.edit);
        textView2 = this.aeo.aek;
        aw.h(textView2, TbadkApplication.m251getInst().getSkinType());
        lVar3 = this.aeo.aej;
        lVar3.notifyDataSetChanged();
    }
}
