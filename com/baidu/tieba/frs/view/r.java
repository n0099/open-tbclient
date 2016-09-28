package com.baidu.tieba.frs.view;

import android.view.View;
import com.baidu.tieba.frs.view.p;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class r implements View.OnClickListener {
    final /* synthetic */ p chB;
    private final /* synthetic */ p.b chC;

    /* JADX INFO: Access modifiers changed from: package-private */
    public r(p pVar, p.b bVar) {
        this.chB = pVar;
        this.chC = bVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        p.a aVar;
        p.a aVar2;
        aVar = this.chB.chx;
        if (aVar != null) {
            aVar2 = this.chB.chx;
            aVar2.iD(this.chC.chD);
        }
        this.chB.dismiss();
    }
}
