package com.baidu.tieba.im.chat;

import android.view.View;
/* loaded from: classes.dex */
class bq implements View.OnClickListener {
    final /* synthetic */ MsgrightView aRt;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bq(MsgrightView msgrightView) {
        this.aRt = msgrightView;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.aRt.mItemViewClickListener.onItemViewClick(view, 6, this.aRt.mPosition, 0L);
    }
}
