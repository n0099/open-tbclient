package com.baidu.tieba.homepage.personalize;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c implements View.OnClickListener {
    final /* synthetic */ a cKG;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(a aVar) {
        this.cKG = aVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        n nVar;
        n nVar2;
        nVar = this.cKG.cKz;
        if (nVar != null) {
            nVar2 = this.cKG.cKz;
            nVar2.update();
        }
    }
}
