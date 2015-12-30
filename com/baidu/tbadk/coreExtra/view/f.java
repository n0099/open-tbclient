package com.baidu.tbadk.coreExtra.view;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f implements View.OnClickListener {
    final /* synthetic */ d amK;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(d dVar) {
        this.amK = dVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.amK.s(view);
    }
}
