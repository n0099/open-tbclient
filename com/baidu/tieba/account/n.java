package com.baidu.tieba.account;

import android.view.View;
import android.widget.EditText;
import com.slidingmenu.lib.R;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class n implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ l f1085a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(l lVar) {
        this.f1085a = lVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EditText editText;
        com.baidu.tieba.j jVar;
        s sVar;
        r rVar;
        r rVar2;
        r rVar3;
        editText = this.f1085a.c;
        String obj = editText.getText().toString();
        if (obj != null && obj.length() > 0) {
            sVar = this.f1085a.l;
            if (sVar == null) {
                rVar = this.f1085a.m;
                if (rVar == null) {
                    this.f1085a.m = new r(this.f1085a, com.baidu.tieba.data.h.f1196a + "c/s/detectuname", obj);
                    rVar2 = this.f1085a.m;
                    rVar2.setPriority(3);
                    rVar3 = this.f1085a.m;
                    rVar3.execute(new String[0]);
                    return;
                }
                return;
            }
            return;
        }
        l lVar = this.f1085a;
        jVar = this.f1085a.j;
        lVar.b(jVar.getString(R.string.input_name));
    }
}
