package com.baidu.tieba.frs.view;

import android.view.View;
import com.baidu.tieba.frs.view.q;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class s implements View.OnClickListener {
    final /* synthetic */ q cmI;
    private final /* synthetic */ q.b cmJ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public s(q qVar, q.b bVar) {
        this.cmI = qVar;
        this.cmJ = bVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        q.a aVar;
        q.a aVar2;
        aVar = this.cmI.cmE;
        if (aVar != null) {
            aVar2 = this.cmI.cmE;
            aVar2.iJ(this.cmJ.cmK);
        }
        this.cmI.dismiss();
    }
}
