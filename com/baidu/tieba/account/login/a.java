package com.baidu.tieba.account.login;

import android.app.Activity;
import android.view.View;
import android.widget.EditText;
import com.baidu.adp.lib.util.n;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class a implements View.OnClickListener {
    final /* synthetic */ Login2Activity awY;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(Login2Activity login2Activity) {
        this.awY = login2Activity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EditText editText;
        EditText editText2;
        EditText editText3;
        Activity pageActivity = this.awY.getPageContext().getPageActivity();
        editText = this.awY.awD;
        n.c(pageActivity, editText);
        Activity pageActivity2 = this.awY.getPageContext().getPageActivity();
        editText2 = this.awY.awE;
        n.c(pageActivity2, editText2);
        Activity pageActivity3 = this.awY.getPageContext().getPageActivity();
        editText3 = this.awY.avK;
        n.c(pageActivity3, editText3);
        this.awY.finish();
    }
}
