package com.baidu.tieba.im.chat;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class be implements View.OnLongClickListener {
    final /* synthetic */ ar cNp;

    /* JADX INFO: Access modifiers changed from: package-private */
    public be(ar arVar) {
        this.cNp = arVar;
    }

    @Override // android.view.View.OnLongClickListener
    public boolean onLongClick(View view) {
        this.cNp.cMH.b(view, 7, this.cNp.anM, 0L);
        return true;
    }
}
