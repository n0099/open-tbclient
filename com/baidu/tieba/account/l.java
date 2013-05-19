package com.baidu.tieba.account;

import android.view.View;
import android.widget.EditText;
import com.slidingmenu.lib.R;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class l implements View.OnClickListener {
    final /* synthetic */ j a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(j jVar) {
        this.a = jVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EditText editText;
        com.baidu.tieba.e eVar;
        q qVar;
        p pVar;
        p pVar2;
        p pVar3;
        editText = this.a.c;
        String editable = editText.getText().toString();
        if (editable != null && editable.length() > 0) {
            qVar = this.a.l;
            if (qVar == null) {
                pVar = this.a.m;
                if (pVar == null) {
                    this.a.m = new p(this.a, String.valueOf(com.baidu.tieba.a.i.e) + "c/s/detectuname", editable);
                    pVar2 = this.a.m;
                    pVar2.setPriority(3);
                    pVar3 = this.a.m;
                    pVar3.execute(new String[0]);
                    return;
                }
                return;
            }
            return;
        }
        j jVar = this.a;
        eVar = this.a.j;
        jVar.b(eVar.getString(R.string.input_name));
    }
}
