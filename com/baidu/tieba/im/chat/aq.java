package com.baidu.tieba.im.chat;

import android.view.View;
/* loaded from: classes.dex */
class aq implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ MsgleftView f1417a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aq(MsgleftView msgleftView) {
        this.f1417a = msgleftView;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.f1417a.c.a(view, 2, this.f1417a.f, 0L);
    }
}
