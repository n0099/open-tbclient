package com.baidu.tieba;

import android.view.View;
/* loaded from: classes.dex */
class am implements View.OnClickListener {
    final /* synthetic */ ak a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public am(ak akVar) {
        this.a = akVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        an anVar;
        anVar = this.a.h;
        anVar.a();
    }
}
