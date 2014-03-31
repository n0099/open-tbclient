package com.baidu.tieba.im.chat.officialBar;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class bh implements View.OnLongClickListener {
    final /* synthetic */ bg a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bh(bg bgVar) {
        this.a = bgVar;
    }

    @Override // android.view.View.OnLongClickListener
    public final boolean onLongClick(View view) {
        com.baidu.adp.lib.b.b bVar;
        com.baidu.adp.lib.b.b bVar2;
        int i;
        bVar = this.a.i;
        if (bVar != null) {
            bVar2 = this.a.i;
            i = this.a.j;
            bVar2.b(view, 9, i, 0L);
            return false;
        }
        return false;
    }
}
