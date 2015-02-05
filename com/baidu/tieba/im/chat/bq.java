package com.baidu.tieba.im.chat;

import android.view.View;
/* loaded from: classes.dex */
class bq implements View.OnClickListener {
    final /* synthetic */ MsgleftView aSw;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bq(MsgleftView msgleftView) {
        this.aSw = msgleftView;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.aSw.mItemViewClickListener.onItemViewClick(view, 2, this.aSw.mPosition, 0L);
    }
}
