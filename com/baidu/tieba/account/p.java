package com.baidu.tieba.account;

import android.view.View;
import android.widget.EditText;
import com.slidingmenu.lib.R;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class p implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ m f1090a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(m mVar) {
        this.f1090a = mVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EditText editText;
        com.baidu.tieba.j jVar;
        s sVar;
        t tVar;
        t tVar2;
        t tVar3;
        s sVar2;
        editText = this.f1090a.c;
        String obj = editText.getText().toString();
        if (obj != null && obj.length() > 0) {
            sVar = this.f1090a.m;
            if (sVar != null) {
                sVar2 = this.f1090a.m;
                sVar2.cancel();
            }
            tVar = this.f1090a.l;
            if (tVar == null) {
                this.f1090a.l = new t(this.f1090a, com.baidu.tieba.data.h.f1201a + "c/s/filluname", obj);
                tVar2 = this.f1090a.l;
                tVar2.setPriority(3);
                tVar3 = this.f1090a.l;
                tVar3.execute(new String[0]);
                return;
            }
            return;
        }
        m mVar = this.f1090a;
        jVar = this.f1090a.j;
        mVar.b(jVar.getString(R.string.input_name));
    }
}
