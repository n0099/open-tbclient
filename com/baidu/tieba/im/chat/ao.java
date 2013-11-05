package com.baidu.tieba.im.chat;

import android.view.View;
/* loaded from: classes.dex */
class ao implements View.OnLongClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ al f1415a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ao(al alVar) {
        this.f1415a = alVar;
    }

    @Override // android.view.View.OnLongClickListener
    public boolean onLongClick(View view) {
        this.f1415a.d.b(view, 4, this.f1415a.f, 0L);
        return true;
    }
}
