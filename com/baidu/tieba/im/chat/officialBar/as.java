package com.baidu.tieba.im.chat.officialBar;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class as implements View.OnLongClickListener {
    final /* synthetic */ ar aTM;

    /* JADX INFO: Access modifiers changed from: package-private */
    public as(ar arVar) {
        this.aTM = arVar;
    }

    @Override // android.view.View.OnLongClickListener
    public boolean onLongClick(View view) {
        com.baidu.adp.lib.c.b bVar;
        com.baidu.adp.lib.c.b bVar2;
        int i;
        bVar = this.aTM.mItemViewLongClickListener;
        if (bVar != null) {
            bVar2 = this.aTM.mItemViewLongClickListener;
            i = this.aTM.mPosition;
            bVar2.onItemViewLongClick(view, 9, i, 0L);
            return false;
        }
        return false;
    }
}
