package com.baidu.tbadk.coreExtra.view;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class k implements View.OnClickListener {
    final /* synthetic */ j apD;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(j jVar) {
        this.apD = jVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.apD.AV();
        this.apD.AT();
    }
}
