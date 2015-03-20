package com.baidu.tieba.im.chat;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ay implements View.OnClickListener {
    final /* synthetic */ MsgActivityView aXe;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ay(MsgActivityView msgActivityView) {
        this.aXe = msgActivityView;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.baidu.adp.lib.c.a aVar;
        com.baidu.adp.lib.c.a aVar2;
        int i;
        aVar = this.aXe.aXc;
        if (aVar != null) {
            aVar2 = this.aXe.aXc;
            i = this.aXe.mPosition;
            aVar2.onItemViewClick(view, 8, i, 0L);
        }
    }
}
