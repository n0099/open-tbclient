package com.baidu.tieba.account;

import android.view.View;
import android.widget.EditText;
import com.slidingmenu.lib.R;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class m implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ k f905a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(k kVar) {
        this.f905a = kVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EditText editText;
        com.baidu.tieba.g gVar;
        r rVar;
        q qVar;
        q qVar2;
        q qVar3;
        editText = this.f905a.c;
        String editable = editText.getText().toString();
        if (editable != null && editable.length() > 0) {
            rVar = this.f905a.l;
            if (rVar == null) {
                qVar = this.f905a.m;
                if (qVar == null) {
                    this.f905a.m = new q(this.f905a, String.valueOf(com.baidu.tieba.data.g.f1014a) + "c/s/detectuname", editable);
                    qVar2 = this.f905a.m;
                    qVar2.setPriority(3);
                    qVar3 = this.f905a.m;
                    qVar3.execute(new String[0]);
                    return;
                }
                return;
            }
            return;
        }
        k kVar = this.f905a;
        gVar = this.f905a.j;
        kVar.b(gVar.getString(R.string.input_name));
    }
}
