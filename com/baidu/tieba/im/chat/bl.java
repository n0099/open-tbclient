package com.baidu.tieba.im.chat;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bl implements View.OnLongClickListener {
    final /* synthetic */ az aRi;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bl(az azVar) {
        this.aRi = azVar;
    }

    @Override // android.view.View.OnLongClickListener
    public boolean onLongClick(View view) {
        this.aRi.mItemViewLongClickListener.onItemViewLongClick(view, 10, this.aRi.mPosition, 0L);
        return true;
    }
}
