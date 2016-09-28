package com.baidu.tieba.im.chat;

import android.view.View;
/* loaded from: classes.dex */
class bj implements View.OnClickListener {
    final /* synthetic */ MsgleftView cVr;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bj(MsgleftView msgleftView) {
        this.cVr = msgleftView;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.cVr.cUE.a(view, 2, this.cVr.aok, 0L);
    }
}
