package com.baidu.tieba.im.chat;

import android.view.View;
/* loaded from: classes.dex */
class by implements View.OnClickListener {
    final /* synthetic */ MsgleftView aXQ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public by(MsgleftView msgleftView) {
        this.aXQ = msgleftView;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.aXQ.aXc.onItemViewClick(view, 2, this.aXQ.mPosition, 0L);
    }
}
