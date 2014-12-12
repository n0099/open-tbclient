package com.baidu.tbadk.coreExtra.act;

import android.app.Activity;
import android.view.View;
import android.widget.EditText;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class y implements View.OnClickListener {
    final /* synthetic */ Login2Activity Qf;

    /* JADX INFO: Access modifiers changed from: package-private */
    public y(Login2Activity login2Activity) {
        this.Qf = login2Activity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EditText editText;
        EditText editText2;
        EditText editText3;
        Activity pageActivity = this.Qf.getPageContext().getPageActivity();
        editText = this.Qf.PC;
        com.baidu.adp.lib.util.l.c(pageActivity, editText);
        Activity pageActivity2 = this.Qf.getPageContext().getPageActivity();
        editText2 = this.Qf.PD;
        com.baidu.adp.lib.util.l.c(pageActivity2, editText2);
        Activity pageActivity3 = this.Qf.getPageContext().getPageActivity();
        editText3 = this.Qf.PE;
        com.baidu.adp.lib.util.l.c(pageActivity3, editText3);
        this.Qf.finish();
    }
}
