package com.baidu.tieba.addresslist;

import android.view.View;
import android.widget.EditText;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class i implements View.OnClickListener {
    final /* synthetic */ QuickSearchActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(QuickSearchActivity quickSearchActivity) {
        this.a = quickSearchActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EditText editText;
        EditText editText2;
        editText = this.a.d;
        if (editText.hasFocus()) {
            QuickSearchActivity quickSearchActivity = this.a;
            editText2 = this.a.d;
            com.baidu.adp.lib.util.j.a(quickSearchActivity, editText2);
        }
        this.a.closeActivity();
    }
}
