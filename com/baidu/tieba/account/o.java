package com.baidu.tieba.account;

import android.view.View;
import android.widget.EditText;
import com.slidingmenu.lib.R;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class o implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ m f1089a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(m mVar) {
        this.f1089a = mVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EditText editText;
        com.baidu.tieba.j jVar;
        t tVar;
        s sVar;
        s sVar2;
        s sVar3;
        editText = this.f1089a.c;
        String obj = editText.getText().toString();
        if (obj != null && obj.length() > 0) {
            tVar = this.f1089a.l;
            if (tVar == null) {
                sVar = this.f1089a.m;
                if (sVar == null) {
                    this.f1089a.m = new s(this.f1089a, com.baidu.tieba.data.h.f1201a + "c/s/detectuname", obj);
                    sVar2 = this.f1089a.m;
                    sVar2.setPriority(3);
                    sVar3 = this.f1089a.m;
                    sVar3.execute(new String[0]);
                    return;
                }
                return;
            }
            return;
        }
        m mVar = this.f1089a;
        jVar = this.f1089a.j;
        mVar.b(jVar.getString(R.string.input_name));
    }
}
