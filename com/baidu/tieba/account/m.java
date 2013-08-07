package com.baidu.tieba.account;

import android.view.View;
import android.widget.EditText;
import com.slidingmenu.lib.R;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class m implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ k f884a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(k kVar) {
        this.f884a = kVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EditText editText;
        com.baidu.tieba.g gVar;
        r rVar;
        q qVar;
        q qVar2;
        q qVar3;
        editText = this.f884a.c;
        String editable = editText.getText().toString();
        if (editable != null && editable.length() > 0) {
            rVar = this.f884a.l;
            if (rVar == null) {
                qVar = this.f884a.m;
                if (qVar == null) {
                    this.f884a.m = new q(this.f884a, String.valueOf(com.baidu.tieba.data.g.f1011a) + "c/s/detectuname", editable);
                    qVar2 = this.f884a.m;
                    qVar2.setPriority(3);
                    qVar3 = this.f884a.m;
                    qVar3.execute(new String[0]);
                    return;
                }
                return;
            }
            return;
        }
        k kVar = this.f884a;
        gVar = this.f884a.j;
        kVar.b(gVar.getString(R.string.input_name));
    }
}
