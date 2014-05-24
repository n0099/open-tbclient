package com.baidu.tieba.im.live.room;

import android.view.View;
/* loaded from: classes.dex */
class bp implements View.OnFocusChangeListener {
    final /* synthetic */ bo a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bp(bo boVar) {
        this.a = boVar;
    }

    @Override // android.view.View.OnFocusChangeListener
    public void onFocusChange(View view, boolean z) {
        if (!z) {
            com.baidu.adp.lib.util.k.a(this.a.b, this.a.e);
        } else {
            com.baidu.adp.lib.util.k.b(this.a.b, this.a.e);
        }
    }
}
