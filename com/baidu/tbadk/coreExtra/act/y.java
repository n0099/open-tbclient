package com.baidu.tbadk.coreExtra.act;

import android.view.View;
import android.widget.EditText;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class y implements View.OnClickListener {
    final /* synthetic */ Login2Activity KT;

    /* JADX INFO: Access modifiers changed from: package-private */
    public y(Login2Activity login2Activity) {
        this.KT = login2Activity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EditText editText;
        EditText editText2;
        EditText editText3;
        Login2Activity login2Activity = this.KT;
        editText = this.KT.Ks;
        com.baidu.adp.lib.util.m.b(login2Activity, editText);
        Login2Activity login2Activity2 = this.KT;
        editText2 = this.KT.Kt;
        com.baidu.adp.lib.util.m.b(login2Activity2, editText2);
        Login2Activity login2Activity3 = this.KT;
        editText3 = this.KT.Ku;
        com.baidu.adp.lib.util.m.b(login2Activity3, editText3);
        this.KT.finish();
    }
}
