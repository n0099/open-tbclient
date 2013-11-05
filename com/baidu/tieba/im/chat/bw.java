package com.baidu.tieba.im.chat;

import android.view.View;
/* loaded from: classes.dex */
class bw implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ MsgrightView f1449a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bw(MsgrightView msgrightView) {
        this.f1449a = msgrightView;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.f1449a.c.a(view, 6, this.f1449a.f, 0L);
    }
}
