package com.baidu.tieba.im.chat;

import android.view.View;
/* loaded from: classes.dex */
class bl implements View.OnClickListener {
    final /* synthetic */ MsgrightView bpq;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bl(MsgrightView msgrightView) {
        this.bpq = msgrightView;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.bpq.bot.onItemViewClick(view, 1, this.bpq.apk, 0L);
    }
}
