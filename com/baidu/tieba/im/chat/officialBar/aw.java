package com.baidu.tieba.im.chat.officialBar;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class aw implements View.OnLongClickListener {
    final /* synthetic */ av aZS;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aw(av avVar) {
        this.aZS = avVar;
    }

    @Override // android.view.View.OnLongClickListener
    public boolean onLongClick(View view) {
        com.baidu.adp.lib.c.b bVar;
        com.baidu.adp.lib.c.b bVar2;
        int i;
        bVar = this.aZS.aXd;
        if (bVar != null) {
            bVar2 = this.aZS.aXd;
            i = this.aZS.mPosition;
            bVar2.onItemViewLongClick(view, 9, i, 0L);
            return false;
        }
        return false;
    }
}
