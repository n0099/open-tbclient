package com.baidu.tieba.im.chat.officialBar;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bb implements View.OnLongClickListener {
    final /* synthetic */ ba aSj;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bb(ba baVar) {
        this.aSj = baVar;
    }

    @Override // android.view.View.OnLongClickListener
    public boolean onLongClick(View view) {
        com.baidu.adp.lib.c.b bVar;
        com.baidu.adp.lib.c.b bVar2;
        int i;
        bVar = this.aSj.aOL;
        if (bVar != null) {
            bVar2 = this.aSj.aOL;
            i = this.aSj.Uy;
            bVar2.b(view, 9, i, 0L);
            return false;
        }
        return false;
    }
}
