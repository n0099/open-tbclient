package com.baidu.tieba.im.chat;

import android.view.View;
/* loaded from: classes.dex */
class cd implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ MsgrightView f1588a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cd(MsgrightView msgrightView) {
        this.f1588a = msgrightView;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.f1588a.c.a(view, 1, this.f1588a.f, 0L);
    }
}
