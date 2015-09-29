package com.baidu.tieba.discover.a;

import android.view.View;
import com.baidu.tieba.discover.y;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c implements View.OnClickListener {
    final /* synthetic */ b aKR;
    private final /* synthetic */ com.baidu.tieba.discover.data.c aKS;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(b bVar, com.baidu.tieba.discover.data.c cVar) {
        this.aKR = bVar;
        this.aKS = cVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        y yVar;
        y yVar2;
        yVar = this.aKR.aKQ;
        if (yVar != null) {
            yVar2 = this.aKR.aKQ;
            yVar2.g(this.aKS);
        }
    }
}
