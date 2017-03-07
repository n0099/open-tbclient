package com.baidu.tieba.im.chat;

import android.view.View;
/* loaded from: classes.dex */
class bm implements View.OnClickListener {
    final /* synthetic */ MsgrightView cPT;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bm(MsgrightView msgrightView) {
        this.cPT = msgrightView;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.cPT.cOV.a(view, 6, this.cPT.ath, 0L);
    }
}
