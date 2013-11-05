package com.baidu.tieba.account;

import android.view.View;
import android.widget.EditText;
import com.slidingmenu.lib.R;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class n implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ l f1051a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(l lVar) {
        this.f1051a = lVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EditText editText;
        com.baidu.tieba.j jVar;
        s sVar;
        r rVar;
        r rVar2;
        r rVar3;
        editText = this.f1051a.c;
        String obj = editText.getText().toString();
        if (obj != null && obj.length() > 0) {
            sVar = this.f1051a.l;
            if (sVar == null) {
                rVar = this.f1051a.m;
                if (rVar == null) {
                    this.f1051a.m = new r(this.f1051a, com.baidu.tieba.data.h.f1165a + "c/s/detectuname", obj);
                    rVar2 = this.f1051a.m;
                    rVar2.setPriority(3);
                    rVar3 = this.f1051a.m;
                    rVar3.execute(new String[0]);
                    return;
                }
                return;
            }
            return;
        }
        l lVar = this.f1051a;
        jVar = this.f1051a.j;
        lVar.b(jVar.getString(R.string.input_name));
    }
}
