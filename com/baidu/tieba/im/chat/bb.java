package com.baidu.tieba.im.chat;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bb implements View.OnLongClickListener {
    final /* synthetic */ as cVl;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bb(as asVar) {
        this.cVl = asVar;
    }

    @Override // android.view.View.OnLongClickListener
    public boolean onLongClick(View view) {
        this.cVl.cUF.b(view, 4, this.cVl.aok, 0L);
        return true;
    }
}
