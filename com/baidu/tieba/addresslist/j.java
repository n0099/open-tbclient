package com.baidu.tieba.addresslist;

import android.app.Activity;
import android.view.View;
import android.widget.EditText;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class j implements View.OnClickListener {
    final /* synthetic */ QuickSearchActivity axA;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(QuickSearchActivity quickSearchActivity) {
        this.axA = quickSearchActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EditText editText;
        EditText editText2;
        editText = this.axA.axv;
        if (editText.hasFocus()) {
            Activity pageActivity = this.axA.getPageContext().getPageActivity();
            editText2 = this.axA.axv;
            com.baidu.adp.lib.util.n.c(pageActivity, editText2);
        }
        this.axA.closeActivity();
    }
}
