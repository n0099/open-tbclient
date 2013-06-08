package com.baidu.tieba.chat;

import android.os.Handler;
/* loaded from: classes.dex */
class g implements y {
    final /* synthetic */ ChatActivity a;
    private boolean b = false;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(ChatActivity chatActivity) {
        this.a = chatActivity;
    }

    @Override // com.baidu.tieba.chat.y
    public void a() {
        this.b = false;
    }

    @Override // com.baidu.tieba.chat.y
    public void b() {
        ad adVar;
        adVar = this.a.c;
        this.b = adVar.i();
    }

    @Override // com.baidu.tieba.chat.y
    public void a(boolean z, String str, boolean z2, int i, com.baidu.tieba.a.a.c cVar, boolean z3) {
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
        this.a.i = true;
        if (z) {
            adVar = this.a.c;
            wVar = this.a.d;
            String i2 = wVar.i();
            wVar2 = this.a.d;
            adVar.a(i2, wVar2.h());
            if (i > 0) {
                this.a.h = true;
            }
            adVar2 = this.a.c;
            adVar2.a(cVar);
            if (!z2) {
                if (i > 0) {
                    adVar4 = this.a.c;
                    adVar4.b(i);
                }
            } else if (this.b && i > 0) {
                adVar3 = this.a.c;
                adVar3.g();
            }
        }
        handler = this.a.j;
        runnable = this.a.m;
        handler.removeCallbacks(runnable);
        if (z3) {
            handler3 = this.a.j;
            runnable3 = this.a.m;
            handler3.postDelayed(runnable3, 0L);
            return;
        }
        handler2 = this.a.j;
        runnable2 = this.a.m;
        handler2.postDelayed(runnable2, 30000L);
    }
}
