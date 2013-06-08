package com.baidu.tieba.chat;

import android.os.Handler;
/* loaded from: classes.dex */
class e implements ac {
    final /* synthetic */ ChatActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(ChatActivity chatActivity) {
        this.a = chatActivity;
    }

    @Override // com.baidu.tieba.chat.ac
    public void a() {
        ad adVar;
        adVar = this.a.c;
        adVar.k();
    }

    @Override // com.baidu.tieba.chat.ac
    public void a(boolean z, String str, com.baidu.tieba.a.a.c cVar) {
        ad adVar;
        w wVar;
        ad adVar2;
        aa aaVar;
        Handler handler;
        Runnable runnable;
        Handler handler2;
        Runnable runnable2;
        adVar = this.a.c;
        adVar.l();
        if (z) {
            wVar = this.a.d;
            wVar.d().a(cVar);
            adVar2 = this.a.c;
            adVar2.f();
            new Handler().post(new f(this));
            if (cVar.c()) {
                handler = this.a.j;
                runnable = this.a.m;
                handler.removeCallbacks(runnable);
                handler2 = this.a.j;
                runnable2 = this.a.m;
                handler2.post(runnable2);
            }
            aaVar = this.a.e;
            aaVar.a((com.baidu.tieba.a.a.e) null);
            return;
        }
        this.a.a(str);
    }
}
