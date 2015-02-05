package com.baidu.tbadk.coreExtra.act;

import android.app.Activity;
import android.view.View;
import android.widget.EditText;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class y implements View.OnClickListener {
    final /* synthetic */ Login2Activity QD;

    /* JADX INFO: Access modifiers changed from: package-private */
    public y(Login2Activity login2Activity) {
        this.QD = login2Activity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EditText editText;
        EditText editText2;
        EditText editText3;
        Activity pageActivity = this.QD.getPageContext().getPageActivity();
        editText = this.QD.Qb;
        com.baidu.adp.lib.util.l.c(pageActivity, editText);
        Activity pageActivity2 = this.QD.getPageContext().getPageActivity();
        editText2 = this.QD.Qc;
        com.baidu.adp.lib.util.l.c(pageActivity2, editText2);
        Activity pageActivity3 = this.QD.getPageContext().getPageActivity();
        editText3 = this.QD.Qd;
        com.baidu.adp.lib.util.l.c(pageActivity3, editText3);
        this.QD.finish();
    }
}
