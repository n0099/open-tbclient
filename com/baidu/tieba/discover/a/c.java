package com.baidu.tieba.discover.a;

import android.view.View;
import com.baidu.tieba.discover.x;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c implements View.OnClickListener {
    final /* synthetic */ b aSp;
    private final /* synthetic */ com.baidu.tieba.discover.data.c aSq;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(b bVar, com.baidu.tieba.discover.data.c cVar) {
        this.aSp = bVar;
        this.aSq = cVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        x xVar;
        x xVar2;
        xVar = this.aSp.aSo;
        if (xVar != null) {
            xVar2 = this.aSp.aSo;
            xVar2.g(this.aSq);
        }
    }
}
