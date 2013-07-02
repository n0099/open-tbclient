package com.baidu.tieba.account;

import android.view.View;
import android.widget.EditText;
import com.slidingmenu.lib.R;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class m implements View.OnClickListener {
    final /* synthetic */ j a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(j jVar) {
        this.a = jVar;
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
        editText = this.a.c;
        String editable = editText.getText().toString();
        if (editable != null && editable.length() > 0) {
            pVar = this.a.m;
            if (pVar != null) {
                pVar2 = this.a.m;
                pVar2.cancel();
            }
            qVar = this.a.l;
            if (qVar == null) {
                this.a.l = new q(this.a, String.valueOf(com.baidu.tieba.data.g.a) + "c/s/filluname", editable);
                qVar2 = this.a.l;
                qVar2.setPriority(3);
                qVar3 = this.a.l;
                qVar3.execute(new String[0]);
                return;
            }
            return;
        }
        j jVar = this.a;
        gVar = this.a.j;
        jVar.b(gVar.getString(R.string.input_name));
    }
}
