package com.baidu.tieba.account;

import android.view.View;
import android.widget.EditText;
import com.slidingmenu.lib.R;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class m implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ j f673a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(j jVar) {
        this.f673a = jVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EditText editText;
        com.baidu.tieba.g gVar;
        p pVar;
        q qVar;
        q qVar2;
        q qVar3;
        p pVar2;
        editText = this.f673a.c;
        String editable = editText.getText().toString();
        if (editable != null && editable.length() > 0) {
            pVar = this.f673a.m;
            if (pVar != null) {
                pVar2 = this.f673a.m;
                pVar2.cancel();
            }
            qVar = this.f673a.l;
            if (qVar == null) {
                this.f673a.l = new q(this.f673a, String.valueOf(com.baidu.tieba.data.g.f787a) + "c/s/filluname", editable);
                qVar2 = this.f673a.l;
                qVar2.setPriority(3);
                qVar3 = this.f673a.l;
                qVar3.execute(new String[0]);
                return;
            }
            return;
        }
        j jVar = this.f673a;
        gVar = this.f673a.j;
        jVar.b(gVar.getString(R.string.input_name));
    }
}
