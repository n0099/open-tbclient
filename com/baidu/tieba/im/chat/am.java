package com.baidu.tieba.im.chat;

import android.view.View;
/* loaded from: classes.dex */
class am implements View.OnLongClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ al f1413a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public am(al alVar) {
        this.f1413a = alVar;
    }

    @Override // android.view.View.OnLongClickListener
    public boolean onLongClick(View view) {
        this.f1413a.d.b(view, 5, this.f1413a.f, 0L);
        return true;
    }
}
