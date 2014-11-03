package com.baidu.tieba.im.chat;

import android.view.View;
/* loaded from: classes.dex */
class cq implements View.OnClickListener {
    final /* synthetic */ MsgleftView aPE;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cq(MsgleftView msgleftView) {
        this.aPE = msgleftView;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.aPE.aOY.a(view, 2, this.aPE.UC, 0L);
    }
}
