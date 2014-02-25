package com.baidu.tieba.im.groupActivity;

import android.view.View;
import android.widget.EditText;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class k implements View.OnClickListener {
    final /* synthetic */ e a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(e eVar) {
        this.a = eVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EditText editText;
        editText = this.a.i;
        editText.setText("");
    }
}
