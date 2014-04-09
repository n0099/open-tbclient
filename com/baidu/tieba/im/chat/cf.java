package com.baidu.tieba.im.chat;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class cf implements View.OnClickListener {
    final /* synthetic */ cd a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cf(cd cdVar) {
        this.a = cdVar;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        this.a.c.a(view, 4, this.a.f, 0L);
    }
}
