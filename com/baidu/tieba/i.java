package com.baidu.tieba;

import android.view.View;
import android.view.inputmethod.InputMethodManager;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class i implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ g f1168a;
    private View b;

    public i(g gVar, View view) {
        this.f1168a = gVar;
        this.b = null;
        this.b = view;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (!this.f1168a.isFinishing()) {
            this.f1168a.b((InputMethodManager) this.f1168a.getSystemService("input_method"), this.b);
        }
    }
}
