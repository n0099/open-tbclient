package com.baidu.tieba.im.chat;

import android.widget.EditText;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class by implements Runnable {
    final /* synthetic */ bu a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public by(bu buVar) {
        this.a = buVar;
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
