package com.baidu.tieba.im.chat;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ba implements View.OnLongClickListener {
    final /* synthetic */ as bZI;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ba(as asVar) {
        this.bZI = asVar;
    }

    @Override // android.view.View.OnLongClickListener
    public boolean onLongClick(View view) {
        this.bZI.bZb.b(view, 4, this.bZI.aom, 0L);
        return true;
    }
}
