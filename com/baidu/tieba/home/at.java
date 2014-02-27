package com.baidu.tieba.home;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class at implements View.OnClickListener {
    final /* synthetic */ as a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public at(as asVar) {
        this.a = asVar;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        com.baidu.tieba.f fVar;
        fVar = this.a.c;
        fVar.finish();
    }
}
