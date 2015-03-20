package com.baidu.tieba.discover.a;

import android.view.View;
import com.baidu.tieba.discover.u;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c implements View.OnClickListener {
    final /* synthetic */ b aCc;
    private final /* synthetic */ com.baidu.tieba.discover.data.c aCd;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(b bVar, com.baidu.tieba.discover.data.c cVar) {
        this.aCc = bVar;
        this.aCd = cVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        u uVar;
        u uVar2;
        uVar = this.aCc.aCb;
        if (uVar != null) {
            uVar2 = this.aCc.aCb;
            uVar2.g(this.aCd);
        }
    }
}
