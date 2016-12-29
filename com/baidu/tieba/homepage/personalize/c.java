package com.baidu.tieba.homepage.personalize;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c implements View.OnClickListener {
    final /* synthetic */ a cqb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(a aVar) {
        this.cqb = aVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        n nVar;
        n nVar2;
        nVar = this.cqb.cpU;
        if (nVar != null) {
            nVar2 = this.cqb.cpU;
            nVar2.update();
        }
    }
}
