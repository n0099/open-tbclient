package com.baidu.tieba.home;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class by implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ bx f1433a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public by(bx bxVar) {
        this.f1433a = bxVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.baidu.tieba.j jVar;
        jVar = this.f1433a.c;
        jVar.finish();
    }
}
