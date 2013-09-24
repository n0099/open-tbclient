package com.baidu.tieba.chat;

import android.os.Handler;
/* loaded from: classes.dex */
class g implements x {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ ChatActivity f963a;
    private boolean b = false;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(ChatActivity chatActivity) {
        this.f963a = chatActivity;
    }

    @Override // com.baidu.tieba.chat.x
    public void a() {
        this.b = false;
    }

    @Override // com.baidu.tieba.chat.x
    public void b() {
        ac acVar;
        acVar = this.f963a.f951a;
        this.b = acVar.j();
    }

    @Override // com.baidu.tieba.chat.x
    public void a(boolean z, String str, boolean z2, int i, com.baidu.tieba.data.a.c cVar, boolean z3) {
        ac acVar;
        Handler handler;
        Runnable runnable;
        Handler handler2;
        Runnable runnable2;
        Handler handler3;
        Runnable runnable3;
        ac acVar2;
        v vVar;
        v vVar2;
        ac acVar3;
        ac acVar4;
        ac acVar5;
        this.f963a.g = true;
        if (z) {
            acVar2 = this.f963a.f951a;
            vVar = this.f963a.b;
            String f = vVar.f();
            vVar2 = this.f963a.b;
            acVar2.a(f, vVar2.e());
            if (i > 0) {
                this.f963a.f = true;
            }
            acVar3 = this.f963a.f951a;
            acVar3.a(cVar);
            if (!z2) {
                if (i > 0) {
                    acVar5 = this.f963a.f951a;
                    acVar5.b(i);
                }
            } else if (this.b && i > 0) {
                acVar4 = this.f963a.f951a;
                acVar4.h();
            }
        } else {
            acVar = this.f963a.f951a;
            acVar.m();
        }
        handler = this.f963a.j;
        runnable = this.f963a.m;
        handler.removeCallbacks(runnable);
        if (z3) {
            handler3 = this.f963a.j;
            runnable3 = this.f963a.m;
            handler3.postDelayed(runnable3, 0L);
            return;
        }
        handler2 = this.f963a.j;
        runnable2 = this.f963a.m;
        handler2.postDelayed(runnable2, 30000L);
    }
}
