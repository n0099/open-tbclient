package com.baidu.tieba.im.chat;

import android.view.View;
/* loaded from: classes.dex */
class ao implements View.OnLongClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ ak f1499a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ao(ak akVar) {
        this.f1499a = akVar;
    }

    @Override // android.view.View.OnLongClickListener
    public boolean onLongClick(View view) {
        this.f1499a.d.b(view, 3, this.f1499a.f, 0L);
        return true;
    }
}
