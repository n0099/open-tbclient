package com.baidu.tieba.frs.h;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class m implements View.OnClickListener {
    final /* synthetic */ i bPb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(i iVar) {
        this.bPb = iVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.bPb.abM()) {
            return;
        }
        this.bPb.abI();
    }
}
