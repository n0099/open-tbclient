package com.baidu.tbadk.coreExtra.view;

import android.view.View;
import android.widget.EditText;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class s implements View.OnClickListener {
    final /* synthetic */ p a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public s(p pVar) {
        this.a = pVar;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        EditText editText;
        com.baidu.tbadk.a aVar;
        v vVar;
        w wVar;
        w wVar2;
        w wVar3;
        v vVar2;
        editText = this.a.c;
        String editable = editText.getText().toString();
        if (editable != null && editable.length() > 0) {
            vVar = this.a.m;
            if (vVar != null) {
                vVar2 = this.a.m;
                vVar2.cancel();
            }
            wVar = this.a.l;
            if (wVar == null) {
                this.a.l = new w(this.a, String.valueOf(com.baidu.tbadk.core.data.n.a) + "c/s/filluname", editable);
                wVar2 = this.a.l;
                wVar2.setPriority(3);
                wVar3 = this.a.l;
                wVar3.execute(new String[0]);
                return;
            }
            return;
        }
        p pVar = this.a;
        aVar = this.a.j;
        pVar.b(aVar.getString(com.baidu.tbadk.l.input_name));
    }
}
