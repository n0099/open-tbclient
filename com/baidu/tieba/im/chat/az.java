package com.baidu.tieba.im.chat;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class az implements View.OnLongClickListener {
    final /* synthetic */ as cGg;

    /* JADX INFO: Access modifiers changed from: package-private */
    public az(as asVar) {
        this.cGg = asVar;
    }

    @Override // android.view.View.OnLongClickListener
    public boolean onLongClick(View view) {
        this.cGg.cFz.b(view, 17, this.cGg.aoG, 0L);
        return true;
    }
}
