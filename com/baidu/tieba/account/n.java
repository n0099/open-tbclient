package com.baidu.tieba.account;

import android.view.View;
import android.widget.EditText;
import com.slidingmenu.lib.R;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class n implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ k f906a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(k kVar) {
        this.f906a = kVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EditText editText;
        com.baidu.tieba.g gVar;
        q qVar;
        r rVar;
        r rVar2;
        r rVar3;
        q qVar2;
        editText = this.f906a.c;
        String editable = editText.getText().toString();
        if (editable != null && editable.length() > 0) {
            qVar = this.f906a.m;
            if (qVar != null) {
                qVar2 = this.f906a.m;
                qVar2.cancel();
            }
            rVar = this.f906a.l;
            if (rVar == null) {
                this.f906a.l = new r(this.f906a, String.valueOf(com.baidu.tieba.data.g.f1014a) + "c/s/filluname", editable);
                rVar2 = this.f906a.l;
                rVar2.setPriority(3);
                rVar3 = this.f906a.l;
                rVar3.execute(new String[0]);
                return;
            }
            return;
        }
        k kVar = this.f906a;
        gVar = this.f906a.j;
        kVar.b(gVar.getString(R.string.input_name));
    }
}
