package com.baidu.tieba.im.chat;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class at implements View.OnLongClickListener {
    final /* synthetic */ MsgActivityView aQL;

    /* JADX INFO: Access modifiers changed from: package-private */
    public at(MsgActivityView msgActivityView) {
        this.aQL = msgActivityView;
    }

    @Override // android.view.View.OnLongClickListener
    public boolean onLongClick(View view) {
        com.baidu.adp.lib.c.b bVar;
        com.baidu.adp.lib.c.b bVar2;
        int i;
        bVar = this.aQL.mItemViewLongClickListener;
        if (bVar != null) {
            bVar2 = this.aQL.mItemViewLongClickListener;
            i = this.aQL.mPosition;
            bVar2.onItemViewLongClick(view, 8, i, 0L);
            return true;
        }
        return true;
    }
}
