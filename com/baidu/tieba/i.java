package com.baidu.tieba;

import android.view.View;
import android.view.inputmethod.InputMethodManager;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class i implements Runnable {
    final /* synthetic */ g a;
    private View b;

    public i(g gVar, View view) {
        this.a = gVar;
        this.b = null;
        this.b = view;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (!this.a.isFinishing()) {
            this.a.b((InputMethodManager) this.a.getSystemService("input_method"), this.b);
        }
    }
}
