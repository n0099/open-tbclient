package com.baidu.tieba.im.chat;

import android.view.View;
/* loaded from: classes.dex */
class bj implements View.OnClickListener {
    final /* synthetic */ MsgleftView cTX;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bj(MsgleftView msgleftView) {
        this.cTX = msgleftView;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.cTX.cTk.a(view, 2, this.cTX.aoC, 0L);
    }
}
