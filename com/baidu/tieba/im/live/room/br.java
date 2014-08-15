package com.baidu.tieba.im.live.room;

import android.view.View;
/* loaded from: classes.dex */
class br implements View.OnFocusChangeListener {
    final /* synthetic */ bq a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public br(bq bqVar) {
        this.a = bqVar;
    }

    @Override // android.view.View.OnFocusChangeListener
    public void onFocusChange(View view, boolean z) {
        if (!z) {
            com.baidu.adp.lib.util.j.a(this.a.b, this.a.e);
        } else {
            com.baidu.adp.lib.util.j.b(this.a.b, this.a.e);
        }
    }
}
