package com.baidu.tieba.im.chat;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class at implements View.OnClickListener {
    final /* synthetic */ ar cXO;

    /* JADX INFO: Access modifiers changed from: package-private */
    public at(ar arVar) {
        this.cXO = arVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.cXO.cXg.a(view, 15, this.cXO.auq, 0L);
    }
}
