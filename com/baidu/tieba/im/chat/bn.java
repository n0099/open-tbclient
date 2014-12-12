package com.baidu.tieba.im.chat;

import android.view.View;
/* loaded from: classes.dex */
class bn implements View.OnClickListener {
    final /* synthetic */ MsgleftView aRo;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bn(MsgleftView msgleftView) {
        this.aRo = msgleftView;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.aRo.mItemViewClickListener.onItemViewClick(view, 2, this.aRo.mPosition, 0L);
    }
}
