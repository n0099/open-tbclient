package com.baidu.tieba.account;

import android.view.View;
import android.widget.EditText;
import com.baidu.tieba.R;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class q implements View.OnClickListener {
    final /* synthetic */ o a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public q(o oVar) {
        this.a = oVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EditText editText;
        com.baidu.tieba.e eVar;
        v vVar;
        u uVar;
        u uVar2;
        editText = this.a.c;
        String editable = editText.getText().toString();
        if (editable == null || editable.length() <= 0) {
            o oVar = this.a;
            eVar = this.a.j;
            oVar.b(eVar.getString(R.string.input_name));
            return;
        }
        vVar = this.a.l;
        if (vVar == null) {
            uVar = this.a.m;
            if (uVar == null) {
                this.a.m = new u(this.a, "http://c.tieba.baidu.com/c/s/detectuname", editable);
                uVar2 = this.a.m;
                uVar2.execute(new String[0]);
            }
        }
    }
}
