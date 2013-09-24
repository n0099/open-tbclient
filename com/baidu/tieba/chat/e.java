package com.baidu.tieba.chat;

import android.os.Handler;
/* loaded from: classes.dex */
class e implements ab {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ ChatActivity f961a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(ChatActivity chatActivity) {
        this.f961a = chatActivity;
    }

    @Override // com.baidu.tieba.chat.ab
    public void a() {
        ac acVar;
        acVar = this.f961a.f951a;
        acVar.l();
    }

    @Override // com.baidu.tieba.chat.ab
    public void a(boolean z, String str, com.baidu.tieba.data.a.c cVar) {
        ac acVar;
        v vVar;
        ac acVar2;
        z zVar;
        Handler handler;
        Runnable runnable;
        Handler handler2;
        Runnable runnable2;
        acVar = this.f961a.f951a;
        acVar.m();
        if (z) {
            vVar = this.f961a.b;
            vVar.a().a(cVar);
            acVar2 = this.f961a.f951a;
            acVar2.g();
            new Handler().post(new f(this));
            if (cVar.c()) {
                handler = this.f961a.j;
                runnable = this.f961a.m;
                handler.removeCallbacks(runnable);
                handler2 = this.f961a.j;
                runnable2 = this.f961a.m;
                handler2.post(runnable2);
            }
            zVar = this.f961a.c;
            zVar.a((com.baidu.tieba.data.a.e) null);
            return;
        }
        this.f961a.a(str);
    }
}
