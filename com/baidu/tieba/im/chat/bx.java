package com.baidu.tieba.im.chat;

import android.view.View;
/* loaded from: classes.dex */
class bx implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ MsgrightView f1534a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bx(MsgrightView msgrightView) {
        this.f1534a = msgrightView;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.f1534a.c.a(view, 1, this.f1534a.f, 0L);
    }
}
