package com.baidu.tbadk.coreExtra.view;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class s implements View.OnClickListener {
    final /* synthetic */ r OC;

    /* JADX INFO: Access modifiers changed from: package-private */
    public s(r rVar) {
        this.OC = rVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.OC.qc();
        this.OC.qa();
    }
}
