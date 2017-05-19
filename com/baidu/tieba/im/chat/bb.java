package com.baidu.tieba.im.chat;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bb implements View.OnClickListener {
    final /* synthetic */ ar cKu;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bb(ar arVar) {
        this.cKu = arVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.cKu.cJM.a(view, 13, this.cKu.atD, 0L);
    }
}
