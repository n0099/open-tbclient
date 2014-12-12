package com.baidu.tieba.im.chat;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bd implements View.OnLongClickListener {
    final /* synthetic */ az aRi;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bd(az azVar) {
        this.aRi = azVar;
    }

    @Override // android.view.View.OnLongClickListener
    public boolean onLongClick(View view) {
        this.aRi.mItemViewLongClickListener.onItemViewLongClick(view, 11, this.aRi.mPosition, 0L);
        return true;
    }
}
