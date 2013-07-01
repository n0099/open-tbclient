package com.baidu.tieba.chat;

import android.os.Handler;
/* loaded from: classes.dex */
class h implements com.baidu.tieba.view.ae {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ ChatActivity f725a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(ChatActivity chatActivity) {
        this.f725a = chatActivity;
    }

    @Override // com.baidu.tieba.view.ae
    public void a(int i) {
        ad adVar;
        if (i != 0) {
            adVar = this.f725a.f711a;
            adVar.h();
            return;
        }
        new Handler().post(new i(this));
    }
}
