package com.baidu.tieba.addresslist;

import android.app.Activity;
import android.view.View;
import android.widget.EditText;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class k implements View.OnClickListener {
    final /* synthetic */ QuickSearchActivity aHY;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(QuickSearchActivity quickSearchActivity) {
        this.aHY = quickSearchActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EditText editText;
        EditText editText2;
        editText = this.aHY.aHT;
        if (editText.hasFocus()) {
            Activity pageActivity = this.aHY.getPageContext().getPageActivity();
            editText2 = this.aHY.aHT;
            com.baidu.adp.lib.util.k.c(pageActivity, editText2);
        }
        this.aHY.closeActivity();
    }
}
