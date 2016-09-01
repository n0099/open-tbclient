package com.baidu.tieba.frs.view;

import android.view.View;
import com.baidu.tieba.frs.view.p;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class r implements View.OnClickListener {
    final /* synthetic */ p chD;
    private final /* synthetic */ p.b chE;

    /* JADX INFO: Access modifiers changed from: package-private */
    public r(p pVar, p.b bVar) {
        this.chD = pVar;
        this.chE = bVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        p.a aVar;
        p.a aVar2;
        aVar = this.chD.chz;
        if (aVar != null) {
            aVar2 = this.chD.chz;
            aVar2.iy(this.chE.chF);
        }
        this.chD.dismiss();
    }
}
