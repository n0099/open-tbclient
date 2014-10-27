package com.baidu.tieba.im.chat;

import android.view.View;
/* loaded from: classes.dex */
class cq implements View.OnClickListener {
    final /* synthetic */ MsgleftView aPq;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cq(MsgleftView msgleftView) {
        this.aPq = msgleftView;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.aPq.aOK.a(view, 2, this.aPq.Uy, 0L);
    }
}
