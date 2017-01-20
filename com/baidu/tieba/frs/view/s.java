package com.baidu.tieba.frs.view;

import android.view.View;
import com.baidu.tieba.frs.view.q;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class s implements View.OnClickListener {
    final /* synthetic */ q bYy;
    private final /* synthetic */ q.b bYz;

    /* JADX INFO: Access modifiers changed from: package-private */
    public s(q qVar, q.b bVar) {
        this.bYy = qVar;
        this.bYz = bVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        q.a aVar;
        q.a aVar2;
        aVar = this.bYy.bYt;
        if (aVar != null) {
            aVar2 = this.bYy.bYt;
            aVar2.iG(this.bYz.bYA);
        }
        this.bYy.dismiss();
    }
}
