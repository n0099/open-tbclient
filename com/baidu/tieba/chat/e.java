package com.baidu.tieba.chat;

import android.os.Handler;
/* loaded from: classes.dex */
class e implements ac {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ ChatActivity f944a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(ChatActivity chatActivity) {
        this.f944a = chatActivity;
    }

    @Override // com.baidu.tieba.chat.ac
    public void a() {
        ad adVar;
        adVar = this.f944a.f933a;
        adVar.l();
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
        adVar = this.f944a.f933a;
        adVar.m();
        if (z) {
            wVar = this.f944a.b;
            wVar.a().a(cVar);
            adVar2 = this.f944a.f933a;
            adVar2.g();
            new Handler().post(new f(this));
            if (cVar.c()) {
                handler = this.f944a.j;
                runnable = this.f944a.m;
                handler.removeCallbacks(runnable);
                handler2 = this.f944a.j;
                runnable2 = this.f944a.m;
                handler2.post(runnable2);
            }
            aaVar = this.f944a.c;
            aaVar.a((com.baidu.tieba.data.a.e) null);
            return;
        }
        this.f944a.a(str);
    }
}
