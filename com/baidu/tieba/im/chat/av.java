package com.baidu.tieba.im.chat;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class av implements View.OnClickListener {
    final /* synthetic */ ar cNp;

    /* JADX INFO: Access modifiers changed from: package-private */
    public av(ar arVar) {
        this.cNp = arVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.cNp.cMG.a(view, 11, this.cNp.anM, 0L);
    }
}
