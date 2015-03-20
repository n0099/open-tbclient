package com.baidu.tieba.im.chat;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class az implements View.OnLongClickListener {
    final /* synthetic */ MsgActivityView aXe;

    /* JADX INFO: Access modifiers changed from: package-private */
    public az(MsgActivityView msgActivityView) {
        this.aXe = msgActivityView;
    }

    @Override // android.view.View.OnLongClickListener
    public boolean onLongClick(View view) {
        com.baidu.adp.lib.c.b bVar;
        com.baidu.adp.lib.c.b bVar2;
        int i;
        bVar = this.aXe.aXd;
        if (bVar != null) {
            bVar2 = this.aXe.aXd;
            i = this.aXe.mPosition;
            bVar2.onItemViewLongClick(view, 8, i, 0L);
            return true;
        }
        return true;
    }
}
