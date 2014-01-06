package com.baidu.tieba.im.chat;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class at implements View.OnLongClickListener {
    final /* synthetic */ ap a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public at(ap apVar) {
        this.a = apVar;
    }

    @Override // android.view.View.OnLongClickListener
    public boolean onLongClick(View view) {
        this.a.d.b(view, 3, this.a.f, 0L);
        return true;
    }
}
