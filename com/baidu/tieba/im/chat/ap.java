package com.baidu.tieba.im.chat;

import android.view.View;
/* loaded from: classes.dex */
class ap implements View.OnLongClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ al f1416a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ap(al alVar) {
        this.f1416a = alVar;
    }

    @Override // android.view.View.OnLongClickListener
    public boolean onLongClick(View view) {
        this.f1416a.d.b(view, 3, this.f1416a.f, 0L);
        return true;
    }
}
