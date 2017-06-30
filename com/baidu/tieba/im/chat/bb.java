package com.baidu.tieba.im.chat;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bb implements View.OnClickListener {
    final /* synthetic */ ar cXO;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bb(ar arVar) {
        this.cXO = arVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.cXO.cXg.a(view, 13, this.cXO.auq, 0L);
    }
}
