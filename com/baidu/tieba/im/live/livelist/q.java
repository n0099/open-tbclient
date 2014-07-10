package com.baidu.tieba.im.live.livelist;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class q implements View.OnClickListener {
    final /* synthetic */ p a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public q(p pVar) {
        this.a = pVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        s sVar;
        s sVar2;
        sVar = this.a.g;
        if (sVar != null) {
            sVar2 = this.a.g;
            sVar2.a(view);
        }
    }
}
