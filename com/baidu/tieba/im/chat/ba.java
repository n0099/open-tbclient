package com.baidu.tieba.im.chat;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ba implements View.OnLongClickListener {
    final /* synthetic */ ar cPE;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ba(ar arVar) {
        this.cPE = arVar;
    }

    @Override // android.view.View.OnLongClickListener
    public boolean onLongClick(View view) {
        this.cPE.cOW.b(view, 4, this.cPE.ath, 0L);
        return true;
    }
}
