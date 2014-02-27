package com.baidu.tieba.faceshop;

import android.view.View;
/* loaded from: classes.dex */
final class i implements View.OnClickListener {
    final /* synthetic */ h a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(h hVar) {
        this.a = hVar;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        this.a.dismiss();
    }
}
