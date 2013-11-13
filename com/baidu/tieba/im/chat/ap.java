package com.baidu.tieba.im.chat;

import android.view.View;
/* loaded from: classes.dex */
class ap implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ MsgleftView f1509a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ap(MsgleftView msgleftView) {
        this.f1509a = msgleftView;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.f1509a.c.a(view, 2, this.f1509a.f, 0L);
    }
}
