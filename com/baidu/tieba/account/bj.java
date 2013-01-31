package com.baidu.tieba.account;

import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import java.util.TimerTask;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bj extends TimerTask {
    final /* synthetic */ RegisterActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bj(RegisterActivity registerActivity) {
        this.a = registerActivity;
    }

    @Override // java.util.TimerTask, java.lang.Runnable
    public void run() {
        EditText editText;
        editText = this.a.d;
        ((InputMethodManager) this.a.getSystemService("input_method")).showSoftInput(editText, 0);
    }
}
