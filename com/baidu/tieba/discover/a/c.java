package com.baidu.tieba.discover.a;

import android.view.View;
import com.baidu.tieba.discover.y;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c implements View.OnClickListener {
    final /* synthetic */ b aLM;
    private final /* synthetic */ com.baidu.tieba.discover.data.c aLN;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(b bVar, com.baidu.tieba.discover.data.c cVar) {
        this.aLM = bVar;
        this.aLN = cVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        y yVar;
        y yVar2;
        yVar = this.aLM.aLL;
        if (yVar != null) {
            yVar2 = this.aLM.aLL;
            yVar2.g(this.aLN);
        }
    }
}
