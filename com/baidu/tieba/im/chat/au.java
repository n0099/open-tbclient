package com.baidu.tieba.im.chat;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class au implements View.OnLongClickListener {
    final /* synthetic */ ar cQs;

    /* JADX INFO: Access modifiers changed from: package-private */
    public au(ar arVar) {
        this.cQs = arVar;
    }

    @Override // android.view.View.OnLongClickListener
    public boolean onLongClick(View view) {
        this.cQs.cPK.b(view, 15, this.cQs.atz, 0L);
        return true;
    }
}
