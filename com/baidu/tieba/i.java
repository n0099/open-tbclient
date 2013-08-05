package com.baidu.tieba;

import android.view.View;
import android.view.inputmethod.InputMethodManager;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class i implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ g f1170a;
    private View b;

    public i(g gVar, View view) {
        this.f1170a = gVar;
        this.b = null;
        this.b = view;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (!this.f1170a.isFinishing()) {
            this.f1170a.b((InputMethodManager) this.f1170a.getSystemService("input_method"), this.b);
        }
    }
}
