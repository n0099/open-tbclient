package com.baidu.tieba.frs.view;

import android.view.View;
import com.baidu.tieba.frs.view.p;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class r implements View.OnClickListener {
    final /* synthetic */ p bWt;
    private final /* synthetic */ p.b bWu;

    /* JADX INFO: Access modifiers changed from: package-private */
    public r(p pVar, p.b bVar) {
        this.bWt = pVar;
        this.bWu = bVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        p.a aVar;
        p.a aVar2;
        aVar = this.bWt.bWp;
        if (aVar != null) {
            aVar2 = this.bWt.bWp;
            aVar2.hV(this.bWu.bWv);
        }
        this.bWt.dismiss();
    }
}
