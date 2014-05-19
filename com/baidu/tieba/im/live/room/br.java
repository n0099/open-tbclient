package com.baidu.tieba.im.live.room;

import android.view.View;
/* loaded from: classes.dex */
class br implements View.OnClickListener {
    final /* synthetic */ bo a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public br(bo boVar) {
        this.a = boVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.baidu.adp.lib.util.h.a(this.a.b, this.a.e);
        this.a.dismiss();
    }
}
