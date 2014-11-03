package com.baidu.tbadk.coreExtra.act;

import android.view.View;
import android.widget.EditText;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class y implements View.OnClickListener {
    final /* synthetic */ Login2Activity KU;

    /* JADX INFO: Access modifiers changed from: package-private */
    public y(Login2Activity login2Activity) {
        this.KU = login2Activity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EditText editText;
        EditText editText2;
        EditText editText3;
        Login2Activity login2Activity = this.KU;
        editText = this.KU.Kt;
        com.baidu.adp.lib.util.m.b(login2Activity, editText);
        Login2Activity login2Activity2 = this.KU;
        editText2 = this.KU.Ku;
        com.baidu.adp.lib.util.m.b(login2Activity2, editText2);
        Login2Activity login2Activity3 = this.KU;
        editText3 = this.KU.Kv;
        com.baidu.adp.lib.util.m.b(login2Activity3, editText3);
        this.KU.finish();
    }
}
