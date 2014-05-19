package com.baidu.tbadk.coreExtra.act;

import android.view.View;
import android.widget.EditText;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class y implements View.OnClickListener {
    final /* synthetic */ Login2Activity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public y(Login2Activity login2Activity) {
        this.a = login2Activity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EditText editText;
        EditText editText2;
        EditText editText3;
        Login2Activity login2Activity = this.a;
        editText = this.a.o;
        com.baidu.adp.lib.util.h.a(login2Activity, editText);
        Login2Activity login2Activity2 = this.a;
        editText2 = this.a.p;
        com.baidu.adp.lib.util.h.a(login2Activity2, editText2);
        Login2Activity login2Activity3 = this.a;
        editText3 = this.a.q;
        com.baidu.adp.lib.util.h.a(login2Activity3, editText3);
        this.a.finish();
    }
}
