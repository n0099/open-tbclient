package com.baidu.tieba.im.chat;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class av implements View.OnLongClickListener {
    final /* synthetic */ as cFx;

    /* JADX INFO: Access modifiers changed from: package-private */
    public av(as asVar) {
        this.cFx = asVar;
    }

    @Override // android.view.View.OnLongClickListener
    public boolean onLongClick(View view) {
        this.cFx.cEQ.b(view, 15, this.cFx.akG, 0L);
        return true;
    }
}
