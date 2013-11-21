package com.baidu.tieba.im.chat;

import android.view.View;
/* loaded from: classes.dex */
class al implements View.OnLongClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ ak f1496a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public al(ak akVar) {
        this.f1496a = akVar;
    }

    @Override // android.view.View.OnLongClickListener
    public boolean onLongClick(View view) {
        this.f1496a.d.b(view, 5, this.f1496a.f, 0L);
        return true;
    }
}
