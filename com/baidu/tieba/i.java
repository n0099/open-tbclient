package com.baidu.tieba;

import android.view.View;
import android.view.inputmethod.InputMethodManager;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class i implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ g f946a;
    private View b;

    public i(g gVar, View view) {
        this.f946a = gVar;
        this.b = null;
        this.b = view;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (!this.f946a.isFinishing()) {
            this.f946a.b((InputMethodManager) this.f946a.getSystemService("input_method"), this.b);
        }
    }
}
