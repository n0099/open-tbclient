package com.baidu.tieba.im.chat;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class au implements View.OnClickListener {
    final /* synthetic */ as bpa;

    /* JADX INFO: Access modifiers changed from: package-private */
    public au(as asVar) {
        this.bpa = asVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.bpa.bot.onItemViewClick(view, 11, this.bpa.apk, 0L);
    }
}
