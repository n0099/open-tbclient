package com.baidu.tieba.im.chat;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class as implements View.OnLongClickListener {
    final /* synthetic */ ar cXO;

    /* JADX INFO: Access modifiers changed from: package-private */
    public as(ar arVar) {
        this.cXO = arVar;
    }

    @Override // android.view.View.OnLongClickListener
    public boolean onLongClick(View view) {
        this.cXO.cXh.b(view, 5, this.cXO.auq, 0L);
        return true;
    }
}
