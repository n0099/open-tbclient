package com.baidu.tieba.im.chat.officialBar;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d implements View.OnLongClickListener {
    final /* synthetic */ c aTT;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(c cVar) {
        this.aTT = cVar;
    }

    @Override // android.view.View.OnLongClickListener
    public boolean onLongClick(View view) {
        com.baidu.adp.lib.c.b bVar;
        com.baidu.adp.lib.c.b bVar2;
        int i;
        bVar = this.aTT.mItemViewLongClickListener;
        if (bVar != null) {
            bVar2 = this.aTT.mItemViewLongClickListener;
            i = this.aTT.mPosition;
            bVar2.onItemViewLongClick(view, 9, i, 0L);
            return false;
        }
        return false;
    }
}
