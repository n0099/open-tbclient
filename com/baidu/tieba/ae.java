package com.baidu.tieba;

import android.view.View;
/* loaded from: classes.dex */
class ae implements View.OnClickListener {
    final /* synthetic */ ac ado;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ae(ac acVar) {
        this.ado = acVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        ah ahVar;
        boolean z;
        ahVar = this.ado.adl;
        z = this.ado.acT;
        ahVar.aM(z);
    }
}
