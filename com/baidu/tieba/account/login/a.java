package com.baidu.tieba.account.login;

import android.app.Activity;
import android.view.View;
import android.widget.EditText;
import com.baidu.adp.lib.util.k;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class a implements View.OnClickListener {
    final /* synthetic */ Login2Activity aGf;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(Login2Activity login2Activity) {
        this.aGf = login2Activity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EditText editText;
        k.c(this.aGf.getPageContext().getPageActivity(), this.aGf.aFJ);
        k.c(this.aGf.getPageContext().getPageActivity(), this.aGf.aFK);
        Activity pageActivity = this.aGf.getPageContext().getPageActivity();
        editText = this.aGf.aEP;
        k.c(pageActivity, editText);
        this.aGf.finish();
    }
}
