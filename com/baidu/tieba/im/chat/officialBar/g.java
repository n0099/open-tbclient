package com.baidu.tieba.im.chat.officialBar;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class g implements View.OnLongClickListener {
    final /* synthetic */ f aTX;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(f fVar) {
        this.aTX = fVar;
    }

    @Override // android.view.View.OnLongClickListener
    public boolean onLongClick(View view) {
        com.baidu.adp.lib.c.b bVar;
        com.baidu.adp.lib.c.b bVar2;
        int i;
        bVar = this.aTX.mItemViewLongClickListener;
        if (bVar != null) {
            bVar2 = this.aTX.mItemViewLongClickListener;
            i = this.aTX.mPosition;
            bVar2.onItemViewLongClick(view, 9, i, 0L);
            return false;
        }
        return false;
    }
}
