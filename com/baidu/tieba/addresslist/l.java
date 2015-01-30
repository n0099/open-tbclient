package com.baidu.tieba.addresslist;

import android.app.Activity;
import android.view.View;
import android.widget.EditText;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class l implements View.OnClickListener {
    final /* synthetic */ QuickSearchActivity apk;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(QuickSearchActivity quickSearchActivity) {
        this.apk = quickSearchActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EditText editText;
        EditText editText2;
        editText = this.apk.ape;
        if (editText.hasFocus()) {
            Activity pageActivity = this.apk.getPageContext().getPageActivity();
            editText2 = this.apk.ape;
            com.baidu.adp.lib.util.l.c(pageActivity, editText2);
        }
        this.apk.closeActivity();
    }
}
