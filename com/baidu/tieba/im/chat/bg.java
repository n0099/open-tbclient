package com.baidu.tieba.im.chat;

import android.view.View;
/* loaded from: classes.dex */
class bg implements View.OnClickListener {
    final /* synthetic */ MsgleftView bpg;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bg(MsgleftView msgleftView) {
        this.bpg = msgleftView;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.bpg.bot.onItemViewClick(view, 2, this.bpg.apk, 0L);
    }
}
