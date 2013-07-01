package com.baidu.tieba.chat;

import android.os.Handler;
/* loaded from: classes.dex */
class g implements y {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ ChatActivity f724a;
    private boolean b = false;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(ChatActivity chatActivity) {
        this.f724a = chatActivity;
    }

    @Override // com.baidu.tieba.chat.y
    public void a() {
        this.b = false;
    }

    @Override // com.baidu.tieba.chat.y
    public void b() {
        ad adVar;
        adVar = this.f724a.f711a;
        this.b = adVar.i();
    }

    @Override // com.baidu.tieba.chat.y
    public void a(boolean z, String str, boolean z2, int i, com.baidu.tieba.data.a.c cVar, boolean z3) {
        Handler handler;
        Runnable runnable;
        Handler handler2;
        Runnable runnable2;
        Handler handler3;
        Runnable runnable3;
        ad adVar;
        w wVar;
        w wVar2;
        ad adVar2;
        ad adVar3;
        ad adVar4;
        this.f724a.g = true;
        if (z) {
            adVar = this.f724a.f711a;
            wVar = this.f724a.b;
            String f = wVar.f();
            wVar2 = this.f724a.b;
            adVar.a(f, wVar2.e());
            if (i > 0) {
                this.f724a.f = true;
            }
            adVar2 = this.f724a.f711a;
            adVar2.a(cVar);
            if (!z2) {
                if (i > 0) {
                    adVar4 = this.f724a.f711a;
                    adVar4.b(i);
                }
            } else if (this.b && i > 0) {
                adVar3 = this.f724a.f711a;
                adVar3.g();
            }
        }
        handler = this.f724a.j;
        runnable = this.f724a.m;
        handler.removeCallbacks(runnable);
        if (z3) {
            handler3 = this.f724a.j;
            runnable3 = this.f724a.m;
            handler3.postDelayed(runnable3, 0L);
            return;
        }
        handler2 = this.f724a.j;
        runnable2 = this.f724a.m;
        handler2.postDelayed(runnable2, 30000L);
    }
}
