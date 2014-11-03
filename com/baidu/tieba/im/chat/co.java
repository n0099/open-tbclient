package com.baidu.tieba.im.chat;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class co implements View.OnLongClickListener {
    final /* synthetic */ cc aPy;

    /* JADX INFO: Access modifiers changed from: package-private */
    public co(cc ccVar) {
        this.aPy = ccVar;
    }

    @Override // android.view.View.OnLongClickListener
    public boolean onLongClick(View view) {
        this.aPy.aOZ.b(view, 10, this.aPy.UC, 0L);
        return true;
    }
}
