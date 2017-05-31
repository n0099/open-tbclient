package com.baidu.tieba.im.chat;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ay implements View.OnLongClickListener {
    final /* synthetic */ ar cPS;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ay(ar arVar) {
        this.cPS = arVar;
    }

    @Override // android.view.View.OnLongClickListener
    public boolean onLongClick(View view) {
        this.cPS.cPl.b(view, 17, this.cPS.atn, 0L);
        return true;
    }
}
