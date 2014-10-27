package com.baidu.tieba.im.chat;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bv implements View.OnClickListener {
    final /* synthetic */ MsgActivityView aOM;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bv(MsgActivityView msgActivityView) {
        this.aOM = msgActivityView;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.baidu.adp.lib.c.a aVar;
        com.baidu.adp.lib.c.a aVar2;
        int i;
        aVar = this.aOM.aOK;
        if (aVar != null) {
            aVar2 = this.aOM.aOK;
            i = this.aOM.Uy;
            aVar2.a(view, 8, i, 0L);
        }
    }
}
