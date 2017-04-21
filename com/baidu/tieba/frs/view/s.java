package com.baidu.tieba.frs.view;

import android.view.View;
import com.baidu.tieba.frs.view.q;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class s implements View.OnClickListener {
    final /* synthetic */ q cgL;
    private final /* synthetic */ q.b cgM;

    /* JADX INFO: Access modifiers changed from: package-private */
    public s(q qVar, q.b bVar) {
        this.cgL = qVar;
        this.cgM = bVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        q.a aVar;
        q.a aVar2;
        aVar = this.cgL.cgG;
        if (aVar != null) {
            aVar2 = this.cgL.cgG;
            aVar2.iJ(this.cgM.cgN);
        }
        this.cgL.dismiss();
    }
}
