package com.baidu.tieba.account;

import android.view.View;
import android.widget.EditText;
import com.slidingmenu.lib.R;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class m implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ k f921a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(k kVar) {
        this.f921a = kVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EditText editText;
        com.baidu.tieba.j jVar;
        r rVar;
        q qVar;
        q qVar2;
        q qVar3;
        editText = this.f921a.c;
        String editable = editText.getText().toString();
        if (editable != null && editable.length() > 0) {
            rVar = this.f921a.l;
            if (rVar == null) {
                qVar = this.f921a.m;
                if (qVar == null) {
                    this.f921a.m = new q(this.f921a, String.valueOf(com.baidu.tieba.data.g.f1032a) + "c/s/detectuname", editable);
                    qVar2 = this.f921a.m;
                    qVar2.setPriority(3);
                    qVar3 = this.f921a.m;
                    qVar3.execute(new String[0]);
                    return;
                }
                return;
            }
            return;
        }
        k kVar = this.f921a;
        jVar = this.f921a.j;
        kVar.b(jVar.getString(R.string.input_name));
    }
}
