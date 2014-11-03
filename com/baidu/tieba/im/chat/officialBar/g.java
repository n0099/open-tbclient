package com.baidu.tieba.im.chat.officialBar;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class g implements View.OnLongClickListener {
    final /* synthetic */ f aRg;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(f fVar) {
        this.aRg = fVar;
    }

    @Override // android.view.View.OnLongClickListener
    public boolean onLongClick(View view) {
        com.baidu.adp.lib.c.b bVar;
        com.baidu.adp.lib.c.b bVar2;
        int i;
        bVar = this.aRg.aOZ;
        if (bVar != null) {
            bVar2 = this.aRg.aOZ;
            i = this.aRg.UC;
            bVar2.b(view, 9, i, 0L);
            return false;
        }
        return false;
    }
}
