package com.baidu.tieba.im.chat;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class aw implements View.OnLongClickListener {
    final /* synthetic */ MsgActivityView aRU;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aw(MsgActivityView msgActivityView) {
        this.aRU = msgActivityView;
    }

    @Override // android.view.View.OnLongClickListener
    public boolean onLongClick(View view) {
        com.baidu.adp.lib.c.b bVar;
        com.baidu.adp.lib.c.b bVar2;
        int i;
        bVar = this.aRU.mItemViewLongClickListener;
        if (bVar != null) {
            bVar2 = this.aRU.mItemViewLongClickListener;
            i = this.aRU.mPosition;
            bVar2.onItemViewLongClick(view, 8, i, 0L);
            return true;
        }
        return true;
    }
}
