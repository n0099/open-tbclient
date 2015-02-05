package com.baidu.tieba.im.chat;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class aw implements View.OnLongClickListener {
    final /* synthetic */ MsgActivityView aRT;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aw(MsgActivityView msgActivityView) {
        this.aRT = msgActivityView;
    }

    @Override // android.view.View.OnLongClickListener
    public boolean onLongClick(View view) {
        com.baidu.adp.lib.c.b bVar;
        com.baidu.adp.lib.c.b bVar2;
        int i;
        bVar = this.aRT.mItemViewLongClickListener;
        if (bVar != null) {
            bVar2 = this.aRT.mItemViewLongClickListener;
            i = this.aRT.mPosition;
            bVar2.onItemViewLongClick(view, 8, i, 0L);
            return true;
        }
        return true;
    }
}
