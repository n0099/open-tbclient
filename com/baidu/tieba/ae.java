package com.baidu.tieba;

import android.view.View;
/* loaded from: classes.dex */
class ae implements View.OnClickListener {
    final /* synthetic */ ab auc;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ae(ab abVar) {
        this.auc = abVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        ag agVar;
        agVar = this.auc.atZ;
        agVar.DX();
    }
}
