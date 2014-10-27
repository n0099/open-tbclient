package com.baidu.tieba.im.chat;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bw implements View.OnLongClickListener {
    final /* synthetic */ MsgActivityView aOM;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bw(MsgActivityView msgActivityView) {
        this.aOM = msgActivityView;
    }

    @Override // android.view.View.OnLongClickListener
    public boolean onLongClick(View view) {
        com.baidu.adp.lib.c.b bVar;
        com.baidu.adp.lib.c.b bVar2;
        int i;
        bVar = this.aOM.aOL;
        if (bVar != null) {
            bVar2 = this.aOM.aOL;
            i = this.aOM.Uy;
            bVar2.b(view, 8, i, 0L);
            return true;
        }
        return true;
    }
}
