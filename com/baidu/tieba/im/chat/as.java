package com.baidu.tieba.im.chat;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class as implements View.OnClickListener {
    final /* synthetic */ MsgActivityView aQL;

    /* JADX INFO: Access modifiers changed from: package-private */
    public as(MsgActivityView msgActivityView) {
        this.aQL = msgActivityView;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.baidu.adp.lib.c.a aVar;
        com.baidu.adp.lib.c.a aVar2;
        int i;
        aVar = this.aQL.mItemViewClickListener;
        if (aVar != null) {
            aVar2 = this.aQL.mItemViewClickListener;
            i = this.aQL.mPosition;
            aVar2.onItemViewClick(view, 8, i, 0L);
        }
    }
}
