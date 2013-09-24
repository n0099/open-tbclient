package com.baidu.tieba.account;

import android.view.View;
import android.widget.EditText;
import com.slidingmenu.lib.R;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class n implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ k f922a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(k kVar) {
        this.f922a = kVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EditText editText;
        com.baidu.tieba.j jVar;
        q qVar;
        r rVar;
        r rVar2;
        r rVar3;
        q qVar2;
        editText = this.f922a.c;
        String editable = editText.getText().toString();
        if (editable != null && editable.length() > 0) {
            qVar = this.f922a.m;
            if (qVar != null) {
                qVar2 = this.f922a.m;
                qVar2.cancel();
            }
            rVar = this.f922a.l;
            if (rVar == null) {
                this.f922a.l = new r(this.f922a, String.valueOf(com.baidu.tieba.data.g.f1032a) + "c/s/filluname", editable);
                rVar2 = this.f922a.l;
                rVar2.setPriority(3);
                rVar3 = this.f922a.l;
                rVar3.execute(new String[0]);
                return;
            }
            return;
        }
        k kVar = this.f922a;
        jVar = this.f922a.j;
        kVar.b(jVar.getString(R.string.input_name));
    }
}
