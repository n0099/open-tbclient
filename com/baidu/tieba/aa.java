package com.baidu.tieba;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class aa implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ FragmentTabWidget f1027a;
    private final int b;

    private aa(FragmentTabWidget fragmentTabWidget, int i) {
        this.f1027a = fragmentTabWidget;
        this.b = i;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        z zVar;
        zVar = this.f1027a.b;
        zVar.a(this.b, true);
    }
}
