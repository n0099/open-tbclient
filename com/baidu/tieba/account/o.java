package com.baidu.tieba.account;

import android.view.View;
import android.widget.EditText;
import com.slidingmenu.lib.R;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class o implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ l f1052a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(l lVar) {
        this.f1052a = lVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EditText editText;
        com.baidu.tieba.j jVar;
        r rVar;
        s sVar;
        s sVar2;
        s sVar3;
        r rVar2;
        editText = this.f1052a.c;
        String obj = editText.getText().toString();
        if (obj != null && obj.length() > 0) {
            rVar = this.f1052a.m;
            if (rVar != null) {
                rVar2 = this.f1052a.m;
                rVar2.cancel();
            }
            sVar = this.f1052a.l;
            if (sVar == null) {
                this.f1052a.l = new s(this.f1052a, com.baidu.tieba.data.h.f1165a + "c/s/filluname", obj);
                sVar2 = this.f1052a.l;
                sVar2.setPriority(3);
                sVar3 = this.f1052a.l;
                sVar3.execute(new String[0]);
                return;
            }
            return;
        }
        l lVar = this.f1052a;
        jVar = this.f1052a.j;
        lVar.b(jVar.getString(R.string.input_name));
    }
}
