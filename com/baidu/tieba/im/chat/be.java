package com.baidu.tieba.im.chat;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class be implements View.OnClickListener {
    final /* synthetic */ az aRi;

    /* JADX INFO: Access modifiers changed from: package-private */
    public be(az azVar) {
        this.aRi = azVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.aRi.mItemViewClickListener.onItemViewClick(view, 4, this.aRi.mPosition, 0L);
    }
}
