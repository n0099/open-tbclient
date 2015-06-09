package com.baidu.tieba.addresslist;

import android.app.Activity;
import android.view.View;
import android.widget.EditText;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class o implements View.OnClickListener {
    final /* synthetic */ QuickSearchActivity azv;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(QuickSearchActivity quickSearchActivity) {
        this.azv = quickSearchActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EditText editText;
        EditText editText2;
        editText = this.azv.azq;
        if (editText.hasFocus()) {
            Activity pageActivity = this.azv.getPageContext().getPageActivity();
            editText2 = this.azv.azq;
            com.baidu.adp.lib.util.n.c(pageActivity, editText2);
        }
        this.azv.closeActivity();
    }
}
