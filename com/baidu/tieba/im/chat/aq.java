package com.baidu.tieba.im.chat;

import android.view.View;
/* loaded from: classes.dex */
class aq implements View.OnLongClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ an f1548a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aq(an anVar) {
        this.f1548a = anVar;
    }

    @Override // android.view.View.OnLongClickListener
    public boolean onLongClick(View view) {
        this.f1548a.d.b(view, 4, this.f1548a.f, 0L);
        return true;
    }
}
