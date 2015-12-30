package com.baidu.tieba.im.chat;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class az implements View.OnClickListener {
    final /* synthetic */ as bLC;

    /* JADX INFO: Access modifiers changed from: package-private */
    public az(as asVar) {
        this.bLC = asVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.bLC.bKU.onItemViewClick(view, 4, this.bLC.anc, 0L);
    }
}
