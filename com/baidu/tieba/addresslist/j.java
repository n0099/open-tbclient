package com.baidu.tieba.addresslist;

import android.app.Activity;
import android.view.View;
import android.widget.EditText;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class j implements View.OnClickListener {
    final /* synthetic */ QuickSearchActivity axI;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(QuickSearchActivity quickSearchActivity) {
        this.axI = quickSearchActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EditText editText;
        EditText editText2;
        editText = this.axI.axD;
        if (editText.hasFocus()) {
            Activity pageActivity = this.axI.getPageContext().getPageActivity();
            editText2 = this.axI.axD;
            com.baidu.adp.lib.util.n.c(pageActivity, editText2);
        }
        this.axI.closeActivity();
    }
}
