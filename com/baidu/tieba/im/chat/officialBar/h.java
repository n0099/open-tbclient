package com.baidu.tieba.im.chat.officialBar;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class h implements View.OnLongClickListener {
    final /* synthetic */ g aYE;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(g gVar) {
        this.aYE = gVar;
    }

    @Override // android.view.View.OnLongClickListener
    public boolean onLongClick(View view) {
        com.baidu.adp.lib.c.b bVar;
        com.baidu.adp.lib.c.b bVar2;
        int i;
        bVar = this.aYE.aXd;
        if (bVar != null) {
            bVar2 = this.aYE.aXd;
            i = this.aYE.mPosition;
            bVar2.onItemViewLongClick(view, 9, i, 0L);
            return false;
        }
        return false;
    }
}
