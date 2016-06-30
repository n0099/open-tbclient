package com.baidu.tieba.frs.view;

import android.view.View;
import com.baidu.tieba.frs.view.p;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class r implements View.OnClickListener {
    final /* synthetic */ p bUt;
    private final /* synthetic */ p.b bUu;

    /* JADX INFO: Access modifiers changed from: package-private */
    public r(p pVar, p.b bVar) {
        this.bUt = pVar;
        this.bUu = bVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        p.a aVar;
        p.a aVar2;
        aVar = this.bUt.bUp;
        if (aVar != null) {
            aVar2 = this.bUt.bUp;
            aVar2.hU(this.bUu.bUv);
        }
        this.bUt.dismiss();
    }
}
