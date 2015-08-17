package com.baidu.tieba.im.chat;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class az implements View.OnClickListener {
    final /* synthetic */ as boC;

    /* JADX INFO: Access modifiers changed from: package-private */
    public az(as asVar) {
        this.boC = asVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.boC.bnV.onItemViewClick(view, 13, this.boC.anz, 0L);
    }
}
