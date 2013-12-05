package com.baidu.tieba.account;

import android.view.View;
import android.widget.EditText;
import com.slidingmenu.lib.R;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class p implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ n f1100a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(n nVar) {
        this.f1100a = nVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EditText editText;
        com.baidu.tieba.j jVar;
        u uVar;
        t tVar;
        t tVar2;
        t tVar3;
        editText = this.f1100a.c;
        String obj = editText.getText().toString();
        if (obj != null && obj.length() > 0) {
            uVar = this.f1100a.l;
            if (uVar == null) {
                tVar = this.f1100a.m;
                if (tVar == null) {
                    this.f1100a.m = new t(this.f1100a, com.baidu.tieba.data.h.f1248a + "c/s/detectuname", obj);
                    tVar2 = this.f1100a.m;
                    tVar2.setPriority(3);
                    tVar3 = this.f1100a.m;
                    tVar3.execute(new String[0]);
                    return;
                }
                return;
            }
            return;
        }
        n nVar = this.f1100a;
        jVar = this.f1100a.j;
        nVar.b(jVar.getString(R.string.input_name));
    }
}
