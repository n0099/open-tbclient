package com.baidu.tieba.home;

import android.os.Handler;
/* loaded from: classes.dex */
class f implements com.baidu.tieba.model.l {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ EnterForumActivity f1149a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(EnterForumActivity enterForumActivity) {
        this.f1149a = enterForumActivity;
    }

    @Override // com.baidu.tieba.model.l
    public void a(boolean z, String str, com.baidu.tieba.data.q qVar) {
        n nVar;
        n nVar2;
        com.baidu.tieba.model.j jVar;
        Boolean bool;
        Handler handler;
        Runnable runnable;
        Handler handler2;
        Runnable runnable2;
        nVar = this.f1149a.f1105a;
        nVar.a(true, "");
        if (z) {
            nVar2 = this.f1149a.f1105a;
            jVar = this.f1149a.c;
            com.baidu.tieba.data.q a2 = jVar.a();
            bool = this.f1149a.d;
            nVar2.a(a2, bool.booleanValue());
            handler = this.f1149a.f;
            runnable = this.f1149a.g;
            handler.removeCallbacks(runnable);
            handler2 = this.f1149a.f;
            runnable2 = this.f1149a.g;
            handler2.postDelayed(runnable2, 0L);
            return;
        }
        this.f1149a.a(str);
    }
}
