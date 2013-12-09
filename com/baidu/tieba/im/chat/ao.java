package com.baidu.tieba.im.chat;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ao implements View.OnLongClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ an f1546a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ao(an anVar) {
        this.f1546a = anVar;
    }

    @Override // android.view.View.OnLongClickListener
    public boolean onLongClick(View view) {
        this.f1546a.d.b(view, 5, this.f1546a.f, 0L);
        return true;
    }
}
