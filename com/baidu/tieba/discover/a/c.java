package com.baidu.tieba.discover.a;

import android.view.View;
import com.baidu.tieba.discover.y;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c implements View.OnClickListener {
    final /* synthetic */ b aLc;
    private final /* synthetic */ com.baidu.tieba.discover.data.c aLd;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(b bVar, com.baidu.tieba.discover.data.c cVar) {
        this.aLc = bVar;
        this.aLd = cVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        y yVar;
        y yVar2;
        yVar = this.aLc.aLb;
        if (yVar != null) {
            yVar2 = this.aLc.aLb;
            yVar2.g(this.aLd);
        }
    }
}
