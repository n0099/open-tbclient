package com.baidu.tieba.im.chat;

import android.widget.EditText;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bw implements Runnable {
    final /* synthetic */ bs a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bw(bs bsVar) {
        this.a = bsVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        EditText editText;
        EditText editText2;
        EditText editText3;
        editText = this.a.z;
        editText.requestFocus();
        editText2 = this.a.z;
        int length = editText2.getText().toString().length();
        editText3 = this.a.z;
        editText3.setSelection(length);
    }
}
