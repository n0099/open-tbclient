package com.baidu.tbadk.coreExtra.view;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e implements View.OnClickListener {
    final /* synthetic */ c ako;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(c cVar) {
        this.ako = cVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.ako.G(view);
    }
}
