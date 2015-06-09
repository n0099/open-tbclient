package com.baidu.tieba.account.login;

import android.app.Activity;
import android.view.View;
import android.widget.EditText;
import com.baidu.adp.lib.util.n;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class a implements View.OnClickListener {
    final /* synthetic */ Login2Activity ayN;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(Login2Activity login2Activity) {
        this.ayN = login2Activity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EditText editText;
        EditText editText2;
        EditText editText3;
        Activity pageActivity = this.ayN.getPageContext().getPageActivity();
        editText = this.ayN.ays;
        n.c(pageActivity, editText);
        Activity pageActivity2 = this.ayN.getPageContext().getPageActivity();
        editText2 = this.ayN.ayt;
        n.c(pageActivity2, editText2);
        Activity pageActivity3 = this.ayN.getPageContext().getPageActivity();
        editText3 = this.ayN.axy;
        n.c(pageActivity3, editText3);
        this.ayN.finish();
    }
}
