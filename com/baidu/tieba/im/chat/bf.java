package com.baidu.tieba.im.chat;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bf implements View.OnClickListener {
    final /* synthetic */ ar cPS;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bf(ar arVar) {
        this.cPS = arVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.cPS.cPk.a(view, 10, this.cPS.atn, 0L);
    }
}
