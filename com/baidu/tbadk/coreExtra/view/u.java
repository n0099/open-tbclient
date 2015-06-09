package com.baidu.tbadk.coreExtra.view;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class u implements View.OnClickListener {
    final /* synthetic */ t agi;

    /* JADX INFO: Access modifiers changed from: package-private */
    public u(t tVar) {
        this.agi = tVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.agi.xT();
        this.agi.xR();
    }
}
