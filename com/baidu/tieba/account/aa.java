package com.baidu.tieba.account;

import android.view.View;
import android.widget.EditText;
import com.slidingmenu.lib.R;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class aa implements View.OnClickListener {
    final /* synthetic */ y a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aa(y yVar) {
        this.a = yVar;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        EditText editText;
        com.baidu.tieba.f fVar;
        af afVar;
        ae aeVar;
        ae aeVar2;
        ae aeVar3;
        editText = this.a.c;
        String editable = editText.getText().toString();
        if (editable != null && editable.length() > 0) {
            afVar = this.a.l;
            if (afVar == null) {
                aeVar = this.a.m;
                if (aeVar == null) {
                    this.a.m = new ae(this.a, String.valueOf(com.baidu.tieba.data.i.a) + "c/s/detectuname", editable);
                    aeVar2 = this.a.m;
                    aeVar2.setPriority(3);
                    aeVar3 = this.a.m;
                    aeVar3.execute(new String[0]);
                    return;
                }
                return;
            }
            return;
        }
        y yVar = this.a;
        fVar = this.a.j;
        yVar.b(fVar.getString(R.string.input_name));
    }
}
