package com.baidu.tieba;

import android.view.View;
/* loaded from: classes.dex */
class ae implements View.OnClickListener {
    final /* synthetic */ ac a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ae(ac acVar) {
        this.a = acVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        ah ahVar;
        boolean z;
        ahVar = this.a.x;
        z = this.a.e;
        ahVar.b(z);
    }
}
