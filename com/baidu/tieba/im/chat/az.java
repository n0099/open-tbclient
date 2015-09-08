package com.baidu.tieba.im.chat;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class az implements View.OnClickListener {
    final /* synthetic */ as bpa;

    /* JADX INFO: Access modifiers changed from: package-private */
    public az(as asVar) {
        this.bpa = asVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.bpa.bot.onItemViewClick(view, 13, this.bpa.apk, 0L);
    }
}
