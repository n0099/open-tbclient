package com.baidu.tieba.im.chat;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ay implements View.OnLongClickListener {
    final /* synthetic */ ar cKu;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ay(ar arVar) {
        this.cKu = arVar;
    }

    @Override // android.view.View.OnLongClickListener
    public boolean onLongClick(View view) {
        this.cKu.cJN.b(view, 17, this.cKu.atD, 0L);
        return true;
    }
}
