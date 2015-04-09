package com.baidu.tieba.discover.a;

import android.view.View;
import com.baidu.tieba.discover.u;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c implements View.OnClickListener {
    final /* synthetic */ b aCk;
    private final /* synthetic */ com.baidu.tieba.discover.data.c aCl;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(b bVar, com.baidu.tieba.discover.data.c cVar) {
        this.aCk = bVar;
        this.aCl = cVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        u uVar;
        u uVar2;
        uVar = this.aCk.aCj;
        if (uVar != null) {
            uVar2 = this.aCk.aCj;
            uVar2.g(this.aCl);
        }
    }
}
