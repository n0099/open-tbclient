package com.baidu.tieba.im.chat;

import android.widget.EditText;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class l implements Runnable {
    final /* synthetic */ h a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(h hVar) {
        this.a = hVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        EditText editText;
        EditText editText2;
        EditText editText3;
        editText = this.a.H;
        editText.requestFocus();
        editText2 = this.a.H;
        int length = editText2.getText().toString().length();
        editText3 = this.a.H;
        editText3.setSelection(length);
    }
}
