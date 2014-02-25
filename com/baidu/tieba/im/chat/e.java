package com.baidu.tieba.im.chat;

import android.widget.EditText;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e implements Runnable {
    final /* synthetic */ a a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(a aVar) {
        this.a = aVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        EditText editText;
        EditText editText2;
        EditText editText3;
        editText = this.a.G;
        editText.requestFocus();
        editText2 = this.a.G;
        int length = editText2.getText().toString().length();
        editText3 = this.a.G;
        editText3.setSelection(length);
    }
}
