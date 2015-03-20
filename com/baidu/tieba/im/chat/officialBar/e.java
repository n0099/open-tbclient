package com.baidu.tieba.im.chat.officialBar;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e implements View.OnLongClickListener {
    final /* synthetic */ d aYA;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(d dVar) {
        this.aYA = dVar;
    }

    @Override // android.view.View.OnLongClickListener
    public boolean onLongClick(View view) {
        com.baidu.adp.lib.c.b bVar;
        com.baidu.adp.lib.c.b bVar2;
        int i;
        bVar = this.aYA.aXd;
        if (bVar != null) {
            bVar2 = this.aYA.aXd;
            i = this.aYA.mPosition;
            bVar2.onItemViewLongClick(view, 9, i, 0L);
            return false;
        }
        return false;
    }
}
