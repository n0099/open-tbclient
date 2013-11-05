package com.baidu.tieba.im.chat;

import android.view.View;
/* loaded from: classes.dex */
class by implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ MsgrightView f1451a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public by(MsgrightView msgrightView) {
        this.f1451a = msgrightView;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.f1451a.c.a(view, 1, this.f1451a.f, 0L);
    }
}
