package com.baidu.tieba.im.chat;

import android.view.View;
/* loaded from: classes.dex */
class bk implements View.OnClickListener {
    final /* synthetic */ MsgrightView bpq;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bk(MsgrightView msgrightView) {
        this.bpq = msgrightView;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.bpq.bot.onItemViewClick(view, 6, this.bpq.apk, 0L);
    }
}
