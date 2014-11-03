package com.baidu.tieba;

import android.view.View;
/* loaded from: classes.dex */
class ae implements View.OnClickListener {
    final /* synthetic */ ac adt;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ae(ac acVar) {
        this.adt = acVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        ah ahVar;
        boolean z;
        ahVar = this.adt.adq;
        z = this.adt.acY;
        ahVar.aM(z);
    }
}
