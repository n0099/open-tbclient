package com.baidu.tbadk.coreExtra.act;

import android.app.Activity;
import android.view.View;
import android.widget.EditText;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class y implements View.OnClickListener {
    final /* synthetic */ Login2Activity QG;

    /* JADX INFO: Access modifiers changed from: package-private */
    public y(Login2Activity login2Activity) {
        this.QG = login2Activity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EditText editText;
        EditText editText2;
        EditText editText3;
        Activity pageActivity = this.QG.getPageContext().getPageActivity();
        editText = this.QG.Qe;
        com.baidu.adp.lib.util.l.c(pageActivity, editText);
        Activity pageActivity2 = this.QG.getPageContext().getPageActivity();
        editText2 = this.QG.Qf;
        com.baidu.adp.lib.util.l.c(pageActivity2, editText2);
        Activity pageActivity3 = this.QG.getPageContext().getPageActivity();
        editText3 = this.QG.Qg;
        com.baidu.adp.lib.util.l.c(pageActivity3, editText3);
        this.QG.finish();
    }
}
