package com.baidu.tieba.chat;

import android.os.Handler;
/* loaded from: classes.dex */
class e implements ac {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ ChatActivity f722a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(ChatActivity chatActivity) {
        this.f722a = chatActivity;
    }

    @Override // com.baidu.tieba.chat.ac
    public void a() {
        ad adVar;
        adVar = this.f722a.f711a;
        adVar.k();
    }

    @Override // com.baidu.tieba.chat.ac
    public void a(boolean z, String str, com.baidu.tieba.data.a.c cVar) {
        ad adVar;
        w wVar;
        ad adVar2;
        aa aaVar;
        Handler handler;
        Runnable runnable;
        Handler handler2;
        Runnable runnable2;
        adVar = this.f722a.f711a;
        adVar.l();
        if (z) {
            wVar = this.f722a.b;
            wVar.a().a(cVar);
            adVar2 = this.f722a.f711a;
            adVar2.f();
            new Handler().post(new f(this));
            if (cVar.c()) {
                handler = this.f722a.j;
                runnable = this.f722a.m;
                handler.removeCallbacks(runnable);
                handler2 = this.f722a.j;
                runnable2 = this.f722a.m;
                handler2.post(runnable2);
            }
            aaVar = this.f722a.c;
            aaVar.a((com.baidu.tieba.data.a.e) null);
            return;
        }
        this.f722a.a(str);
    }
}
