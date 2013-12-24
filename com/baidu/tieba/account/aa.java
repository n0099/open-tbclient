package com.baidu.tieba.account;

import android.view.View;
import android.widget.EditText;
import com.slidingmenu.lib.R;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class aa implements View.OnClickListener {
    final /* synthetic */ x a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aa(x xVar) {
        this.a = xVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EditText editText;
        com.baidu.tieba.j jVar;
        ad adVar;
        ae aeVar;
        ae aeVar2;
        ae aeVar3;
        ad adVar2;
        editText = this.a.c;
        String obj = editText.getText().toString();
        if (obj != null && obj.length() > 0) {
            adVar = this.a.m;
            if (adVar != null) {
                adVar2 = this.a.m;
                adVar2.cancel();
            }
            aeVar = this.a.l;
            if (aeVar == null) {
                this.a.l = new ae(this.a, com.baidu.tieba.data.h.a + "c/s/filluname", obj);
                aeVar2 = this.a.l;
                aeVar2.setPriority(3);
                aeVar3 = this.a.l;
                aeVar3.execute(new String[0]);
                return;
            }
            return;
        }
        x xVar = this.a;
        jVar = this.a.j;
        xVar.b(jVar.getString(R.string.input_name));
    }
}
