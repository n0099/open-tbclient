package com.baidu.tieba.frs;

import android.view.View;
/* loaded from: classes.dex */
class ad implements View.OnClickListener {
    final /* synthetic */ ab a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ad(ab abVar) {
        this.a = abVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        ((FrsActivity) this.a.a).h();
    }
}
