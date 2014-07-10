package com.baidu.tieba.im.chat;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ce implements View.OnLongClickListener {
    final /* synthetic */ cd a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ce(cd cdVar) {
        this.a = cdVar;
    }

    @Override // android.view.View.OnLongClickListener
    public boolean onLongClick(View view) {
        this.a.c.b(view, 5, this.a.e, 0L);
        return true;
    }
}
