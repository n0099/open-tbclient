package com.baidu.tieba.account;

import android.view.View;
import android.widget.EditText;
import com.slidingmenu.lib.R;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class l implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ j f672a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(j jVar) {
        this.f672a = jVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EditText editText;
        com.baidu.tieba.g gVar;
        q qVar;
        p pVar;
        p pVar2;
        p pVar3;
        editText = this.f672a.c;
        String editable = editText.getText().toString();
        if (editable != null && editable.length() > 0) {
            qVar = this.f672a.l;
            if (qVar == null) {
                pVar = this.f672a.m;
                if (pVar == null) {
                    this.f672a.m = new p(this.f672a, String.valueOf(com.baidu.tieba.data.g.f787a) + "c/s/detectuname", editable);
                    pVar2 = this.f672a.m;
                    pVar2.setPriority(3);
                    pVar3 = this.f672a.m;
                    pVar3.execute(new String[0]);
                    return;
                }
                return;
            }
            return;
        }
        j jVar = this.f672a;
        gVar = this.f672a.j;
        jVar.b(gVar.getString(R.string.input_name));
    }
}
