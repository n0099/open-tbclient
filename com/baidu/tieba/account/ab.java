package com.baidu.tieba.account;

import android.view.View;
import android.widget.EditText;
import com.slidingmenu.lib.R;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class ab implements View.OnClickListener {
    final /* synthetic */ y a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ab(y yVar) {
        this.a = yVar;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        EditText editText;
        com.baidu.tieba.f fVar;
        ae aeVar;
        af afVar;
        af afVar2;
        af afVar3;
        ae aeVar2;
        editText = this.a.c;
        String editable = editText.getText().toString();
        if (editable != null && editable.length() > 0) {
            aeVar = this.a.m;
            if (aeVar != null) {
                aeVar2 = this.a.m;
                aeVar2.cancel();
            }
            afVar = this.a.l;
            if (afVar == null) {
                this.a.l = new af(this.a, String.valueOf(com.baidu.tieba.data.i.a) + "c/s/filluname", editable);
                afVar2 = this.a.l;
                afVar2.setPriority(3);
                afVar3 = this.a.l;
                afVar3.execute(new String[0]);
                return;
            }
            return;
        }
        y yVar = this.a;
        fVar = this.a.j;
        yVar.b(fVar.getString(R.string.input_name));
    }
}
