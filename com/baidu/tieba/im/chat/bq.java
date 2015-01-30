package com.baidu.tieba.im.chat;

import android.view.View;
/* loaded from: classes.dex */
class bq implements View.OnClickListener {
    final /* synthetic */ MsgleftView aSx;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bq(MsgleftView msgleftView) {
        this.aSx = msgleftView;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.aSx.mItemViewClickListener.onItemViewClick(view, 2, this.aSx.mPosition, 0L);
    }
}
