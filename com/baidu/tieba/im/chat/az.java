package com.baidu.tieba.im.chat;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class az implements View.OnClickListener {
    final /* synthetic */ as bsl;

    /* JADX INFO: Access modifiers changed from: package-private */
    public az(as asVar) {
        this.bsl = asVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.bsl.brD.onItemViewClick(view, 4, this.bsl.anL, 0L);
    }
}
