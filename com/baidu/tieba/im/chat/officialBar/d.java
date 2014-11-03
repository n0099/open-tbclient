package com.baidu.tieba.im.chat.officialBar;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d implements View.OnLongClickListener {
    final /* synthetic */ c aRe;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(c cVar) {
        this.aRe = cVar;
    }

    @Override // android.view.View.OnLongClickListener
    public boolean onLongClick(View view) {
        com.baidu.adp.lib.c.b bVar;
        com.baidu.adp.lib.c.b bVar2;
        int i;
        bVar = this.aRe.aOZ;
        if (bVar != null) {
            bVar2 = this.aRe.aOZ;
            i = this.aRe.UC;
            bVar2.b(view, 9, i, 0L);
            return false;
        }
        return false;
    }
}
