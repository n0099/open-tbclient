package com.baidu.tieba.im.live.room;

import android.view.View;
/* loaded from: classes.dex */
class bs implements View.OnClickListener {
    final /* synthetic */ bp a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bs(bp bpVar) {
        this.a = bpVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.baidu.adp.lib.util.j.a(this.a.b, this.a.e);
        this.a.dismiss();
    }
}
