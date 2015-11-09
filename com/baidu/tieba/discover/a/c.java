package com.baidu.tieba.discover.a;

import android.view.View;
import com.baidu.tieba.discover.y;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c implements View.OnClickListener {
    final /* synthetic */ b aJW;
    private final /* synthetic */ com.baidu.tieba.discover.data.c aJX;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(b bVar, com.baidu.tieba.discover.data.c cVar) {
        this.aJW = bVar;
        this.aJX = cVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        y yVar;
        y yVar2;
        yVar = this.aJW.aJV;
        if (yVar != null) {
            yVar2 = this.aJW.aJV;
            yVar2.g(this.aJX);
        }
    }
}
