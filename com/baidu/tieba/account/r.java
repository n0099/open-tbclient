package com.baidu.tieba.account;

import android.view.View;
import android.widget.EditText;
import com.baidu.tieba.R;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class r implements View.OnClickListener {
    final /* synthetic */ o a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public r(o oVar) {
        this.a = oVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EditText editText;
        com.baidu.tieba.e eVar;
        u uVar;
        v vVar;
        v vVar2;
        u uVar2;
        editText = this.a.c;
        String editable = editText.getText().toString();
        if (editable != null && editable.length() > 0) {
            uVar = this.a.m;
            if (uVar != null) {
                uVar2 = this.a.m;
                uVar2.a();
            }
            vVar = this.a.l;
            if (vVar == null) {
                this.a.l = new v(this.a, "http://c.tieba.baidu.com/c/s/filluname", editable);
                vVar2 = this.a.l;
                vVar2.execute(new String[0]);
                return;
            }
            return;
        }
        o oVar = this.a;
        eVar = this.a.j;
        oVar.b(eVar.getString(R.string.input_name));
    }
}
