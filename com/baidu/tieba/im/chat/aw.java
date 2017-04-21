package com.baidu.tieba.im.chat;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class aw implements View.OnClickListener {
    final /* synthetic */ ar cQs;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aw(ar arVar) {
        this.cQs = arVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.cQs.cPJ.a(view, 12, this.cQs.atz, 0L);
    }
}
