package com.baidu.tieba.im.chat;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class av implements View.OnClickListener {
    final /* synthetic */ ar cKu;

    /* JADX INFO: Access modifiers changed from: package-private */
    public av(ar arVar) {
        this.cKu = arVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.cKu.cJM.a(view, 11, this.cKu.atD, 0L);
    }
}
