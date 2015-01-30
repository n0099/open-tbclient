package com.baidu.tieba.im.chat;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class av implements View.OnClickListener {
    final /* synthetic */ MsgActivityView aRU;

    /* JADX INFO: Access modifiers changed from: package-private */
    public av(MsgActivityView msgActivityView) {
        this.aRU = msgActivityView;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.baidu.adp.lib.c.a aVar;
        com.baidu.adp.lib.c.a aVar2;
        int i;
        aVar = this.aRU.mItemViewClickListener;
        if (aVar != null) {
            aVar2 = this.aRU.mItemViewClickListener;
            i = this.aRU.mPosition;
            aVar2.onItemViewClick(view, 8, i, 0L);
        }
    }
}
