package com.baidu.tieba.home;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bt implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ bs f1483a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bt(bs bsVar) {
        this.f1483a = bsVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.baidu.tieba.j jVar;
        jVar = this.f1483a.c;
        jVar.finish();
    }
}
