package com.baidu.tieba.im.chat;

import android.view.View;
/* loaded from: classes.dex */
class ar implements View.OnLongClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ an f1549a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ar(an anVar) {
        this.f1549a = anVar;
    }

    @Override // android.view.View.OnLongClickListener
    public boolean onLongClick(View view) {
        this.f1549a.d.b(view, 3, this.f1549a.f, 0L);
        return true;
    }
}
