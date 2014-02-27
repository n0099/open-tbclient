package com.baidu.tieba;

import android.view.View;
import android.view.inputmethod.InputMethodManager;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class h implements Runnable {
    final /* synthetic */ f a;
    private View b;

    public h(f fVar, View view) {
        this.a = fVar;
        this.b = null;
        this.b = view;
    }

    @Override // java.lang.Runnable
    public final void run() {
        if (!this.a.isFinishing()) {
            this.a.ShowSoftKeyPad((InputMethodManager) this.a.getSystemService("input_method"), this.b);
        }
    }
}
