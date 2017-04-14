package com.baidu.tieba.homepage.personalize;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c implements View.OnClickListener {
    final /* synthetic */ a cxa;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(a aVar) {
        this.cxa = aVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        n nVar;
        n nVar2;
        nVar = this.cxa.cwS;
        if (nVar != null) {
            nVar2 = this.cxa.cwS;
            nVar2.update();
        }
    }
}
