package com.baidu.tieba.im.chat;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ao implements View.OnLongClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ ak f1508a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ao(ak akVar) {
        this.f1508a = akVar;
    }

    @Override // android.view.View.OnLongClickListener
    public boolean onLongClick(View view) {
        this.f1508a.d.b(view, 3, this.f1508a.f, 0L);
        return true;
    }
}
