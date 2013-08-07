package com.baidu.tieba.chat;

import android.os.Handler;
/* loaded from: classes.dex */
class e implements ac {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ ChatActivity f934a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(ChatActivity chatActivity) {
        this.f934a = chatActivity;
    }

    @Override // com.baidu.tieba.chat.ac
    public void a() {
        ad adVar;
        adVar = this.f934a.f923a;
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
        adVar = this.f934a.f923a;
        adVar.m();
        if (z) {
            wVar = this.f934a.b;
            wVar.a().a(cVar);
            adVar2 = this.f934a.f923a;
            adVar2.g();
            new Handler().post(new f(this));
            if (cVar.c()) {
                handler = this.f934a.j;
                runnable = this.f934a.m;
                handler.removeCallbacks(runnable);
                handler2 = this.f934a.j;
                runnable2 = this.f934a.m;
                handler2.post(runnable2);
            }
            aaVar = this.f934a.c;
            aaVar.a((com.baidu.tieba.data.a.e) null);
            return;
        }
        this.f934a.a(str);
    }
}
