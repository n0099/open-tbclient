package com.baidu.tbadk.coreExtra.view;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class l implements View.OnClickListener {
    final /* synthetic */ k akD;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(k kVar) {
        this.akD = kVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.akD.yR();
        this.akD.yP();
    }
}
