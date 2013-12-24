package com.baidu.tieba.account;

import android.view.View;
import android.widget.EditText;
import com.slidingmenu.lib.R;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class z implements View.OnClickListener {
    final /* synthetic */ x a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public z(x xVar) {
        this.a = xVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EditText editText;
        com.baidu.tieba.j jVar;
        ae aeVar;
        ad adVar;
        ad adVar2;
        ad adVar3;
        editText = this.a.c;
        String obj = editText.getText().toString();
        if (obj != null && obj.length() > 0) {
            aeVar = this.a.l;
            if (aeVar == null) {
                adVar = this.a.m;
                if (adVar == null) {
                    this.a.m = new ad(this.a, com.baidu.tieba.data.h.a + "c/s/detectuname", obj);
                    adVar2 = this.a.m;
                    adVar2.setPriority(3);
                    adVar3 = this.a.m;
                    adVar3.execute(new String[0]);
                    return;
                }
                return;
            }
            return;
        }
        x xVar = this.a;
        jVar = this.a.j;
        xVar.b(jVar.getString(R.string.input_name));
    }
}
