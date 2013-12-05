package com.baidu.tieba.im.chat;

import android.view.View;
/* loaded from: classes.dex */
class as implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ MsgleftView f1550a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public as(MsgleftView msgleftView) {
        this.f1550a = msgleftView;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.f1550a.c.a(view, 2, this.f1550a.f, 0L);
    }
}
