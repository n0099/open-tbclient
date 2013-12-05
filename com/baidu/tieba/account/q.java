package com.baidu.tieba.account;

import android.view.View;
import android.widget.EditText;
import com.slidingmenu.lib.R;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class q implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ n f1101a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public q(n nVar) {
        this.f1101a = nVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EditText editText;
        com.baidu.tieba.j jVar;
        t tVar;
        u uVar;
        u uVar2;
        u uVar3;
        t tVar2;
        editText = this.f1101a.c;
        String obj = editText.getText().toString();
        if (obj != null && obj.length() > 0) {
            tVar = this.f1101a.m;
            if (tVar != null) {
                tVar2 = this.f1101a.m;
                tVar2.cancel();
            }
            uVar = this.f1101a.l;
            if (uVar == null) {
                this.f1101a.l = new u(this.f1101a, com.baidu.tieba.data.h.f1248a + "c/s/filluname", obj);
                uVar2 = this.f1101a.l;
                uVar2.setPriority(3);
                uVar3 = this.f1101a.l;
                uVar3.execute(new String[0]);
                return;
            }
            return;
        }
        n nVar = this.f1101a;
        jVar = this.f1101a.j;
        nVar.b(jVar.getString(R.string.input_name));
    }
}
