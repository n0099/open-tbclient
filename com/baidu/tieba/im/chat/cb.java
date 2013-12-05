package com.baidu.tieba.im.chat;

import android.view.View;
/* loaded from: classes.dex */
class cb implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ MsgrightView f1586a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cb(MsgrightView msgrightView) {
        this.f1586a = msgrightView;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.f1586a.c.a(view, 6, this.f1586a.f, 0L);
    }
}
