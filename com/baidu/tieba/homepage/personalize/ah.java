package com.baidu.tieba.homepage.personalize;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ah implements View.OnClickListener {
    final /* synthetic */ z ctN;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ah(z zVar) {
        this.ctN = zVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        b bVar;
        b bVar2;
        bVar = this.ctN.ctI;
        if (bVar != null) {
            bVar2 = this.ctN.ctI;
            bVar2.update();
        }
    }
}
