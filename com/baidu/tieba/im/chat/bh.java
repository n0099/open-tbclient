package com.baidu.tieba.im.chat;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bh implements View.OnLongClickListener {
    final /* synthetic */ MsgActivityView a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bh(MsgActivityView msgActivityView) {
        this.a = msgActivityView;
    }

    @Override // android.view.View.OnLongClickListener
    public boolean onLongClick(View view) {
        com.baidu.adp.lib.b.b bVar;
        com.baidu.adp.lib.b.b bVar2;
        int i;
        bVar = this.a.w;
        if (bVar != null) {
            bVar2 = this.a.w;
            i = this.a.t;
            bVar2.b(view, 8, i, 0L);
            return true;
        }
        return true;
    }
}
