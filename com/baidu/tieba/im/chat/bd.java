package com.baidu.tieba.im.chat;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bd implements View.OnClickListener {
    final /* synthetic */ as boC;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bd(as asVar) {
        this.boC = asVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.boC.bnV.onItemViewClick(view, 10, this.boC.anz, 0L);
    }
}
