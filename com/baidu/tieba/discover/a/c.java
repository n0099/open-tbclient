package com.baidu.tieba.discover.a;

import android.view.View;
import com.baidu.tieba.discover.z;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c implements View.OnClickListener {
    final /* synthetic */ b aEn;
    private final /* synthetic */ com.baidu.tieba.discover.data.c aEo;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(b bVar, com.baidu.tieba.discover.data.c cVar) {
        this.aEn = bVar;
        this.aEo = cVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        z zVar;
        z zVar2;
        zVar = this.aEn.aEm;
        if (zVar != null) {
            zVar2 = this.aEn.aEm;
            zVar2.g(this.aEo);
        }
    }
}
