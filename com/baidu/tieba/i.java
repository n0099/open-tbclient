package com.baidu.tieba;

import android.view.View;
import android.view.inputmethod.InputMethodManager;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class i implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ g f1200a;
    private View b;

    public i(g gVar, View view) {
        this.f1200a = gVar;
        this.b = null;
        this.b = view;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (!this.f1200a.isFinishing()) {
            this.f1200a.b((InputMethodManager) this.f1200a.getSystemService("input_method"), this.b);
        }
    }
}
