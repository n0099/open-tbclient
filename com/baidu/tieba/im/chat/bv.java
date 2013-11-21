package com.baidu.tieba.im.chat;

import android.view.View;
/* loaded from: classes.dex */
class bv implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ MsgrightView f1532a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bv(MsgrightView msgrightView) {
        this.f1532a = msgrightView;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.f1532a.c.a(view, 6, this.f1532a.f, 0L);
    }
}
