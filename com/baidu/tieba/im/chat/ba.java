package com.baidu.tieba.im.chat;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ba implements View.OnLongClickListener {
    final /* synthetic */ as can;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ba(as asVar) {
        this.can = asVar;
    }

    @Override // android.view.View.OnLongClickListener
    public boolean onLongClick(View view) {
        this.can.bZG.b(view, 4, this.can.aka, 0L);
        return true;
    }
}
