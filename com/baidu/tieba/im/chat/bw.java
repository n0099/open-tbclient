package com.baidu.tieba.im.chat;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bw implements View.OnLongClickListener {
    final /* synthetic */ MsgActivityView aPa;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bw(MsgActivityView msgActivityView) {
        this.aPa = msgActivityView;
    }

    @Override // android.view.View.OnLongClickListener
    public boolean onLongClick(View view) {
        com.baidu.adp.lib.c.b bVar;
        com.baidu.adp.lib.c.b bVar2;
        int i;
        bVar = this.aPa.aOZ;
        if (bVar != null) {
            bVar2 = this.aPa.aOZ;
            i = this.aPa.UC;
            bVar2.b(view, 8, i, 0L);
            return true;
        }
        return true;
    }
}
