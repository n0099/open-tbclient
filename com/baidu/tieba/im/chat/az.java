package com.baidu.tieba.im.chat;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class az implements View.OnClickListener {
    final /* synthetic */ as bsa;

    /* JADX INFO: Access modifiers changed from: package-private */
    public az(as asVar) {
        this.bsa = asVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.bsa.brs.onItemViewClick(view, 4, this.bsa.anK, 0L);
    }
}
