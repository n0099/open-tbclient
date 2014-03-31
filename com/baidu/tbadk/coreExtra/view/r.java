package com.baidu.tbadk.coreExtra.view;

import android.view.View;
import android.widget.EditText;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class r implements View.OnClickListener {
    final /* synthetic */ p a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public r(p pVar) {
        this.a = pVar;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        EditText editText;
        com.baidu.tbadk.a aVar;
        w wVar;
        v vVar;
        v vVar2;
        v vVar3;
        editText = this.a.c;
        String editable = editText.getText().toString();
        if (editable != null && editable.length() > 0) {
            wVar = this.a.l;
            if (wVar == null) {
                vVar = this.a.m;
                if (vVar == null) {
                    this.a.m = new v(this.a, String.valueOf(com.baidu.tbadk.core.data.n.a) + "c/s/detectuname", editable);
                    vVar2 = this.a.m;
                    vVar2.setPriority(3);
                    vVar3 = this.a.m;
                    vVar3.execute(new String[0]);
                    return;
                }
                return;
            }
            return;
        }
        p pVar = this.a;
        aVar = this.a.j;
        pVar.b(aVar.getString(com.baidu.tbadk.l.input_name));
    }
}
