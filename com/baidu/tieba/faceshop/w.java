package com.baidu.tieba.faceshop;

import android.view.View;
/* loaded from: classes.dex */
class w implements View.OnClickListener {
    final /* synthetic */ v asZ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public w(v vVar) {
        this.asZ = vVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.asZ.dismiss();
    }
}
