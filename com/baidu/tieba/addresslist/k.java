package com.baidu.tieba.addresslist;

import android.view.View;
import android.widget.EditText;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class k implements View.OnClickListener {
    final /* synthetic */ QuickSearchActivity agP;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(QuickSearchActivity quickSearchActivity) {
        this.agP = quickSearchActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EditText editText;
        EditText editText2;
        editText = this.agP.agK;
        if (editText.hasFocus()) {
            QuickSearchActivity quickSearchActivity = this.agP;
            editText2 = this.agP.agK;
            com.baidu.adp.lib.util.m.b(quickSearchActivity, editText2);
        }
        this.agP.closeActivity();
    }
}
