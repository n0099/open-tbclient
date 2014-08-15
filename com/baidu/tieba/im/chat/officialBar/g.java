package com.baidu.tieba.im.chat.officialBar;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class g implements View.OnLongClickListener {
    final /* synthetic */ f a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(f fVar) {
        this.a = fVar;
    }

    @Override // android.view.View.OnLongClickListener
    public boolean onLongClick(View view) {
        com.baidu.adp.lib.b.b bVar;
        com.baidu.adp.lib.b.b bVar2;
        int i;
        bVar = this.a.e;
        if (bVar != null) {
            bVar2 = this.a.e;
            i = this.a.f;
            bVar2.b(view, 9, i, 0L);
            return false;
        }
        return false;
    }
}
