package com.baidu.tieba.im.chat;

import android.view.View;
/* loaded from: classes.dex */
class bj implements View.OnClickListener {
    final /* synthetic */ MsgleftView cIs;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bj(MsgleftView msgleftView) {
        this.cIs = msgleftView;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.cIs.cHE.a(view, 2, this.cIs.alw, 0L);
    }
}
