package com.baidu.tieba.home;

import android.os.Handler;
/* loaded from: classes.dex */
class f implements com.baidu.tieba.model.l {
    final /* synthetic */ EnterForumActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(EnterForumActivity enterForumActivity) {
        this.a = enterForumActivity;
    }

    @Override // com.baidu.tieba.model.l
    public void a(boolean z, String str, com.baidu.tieba.data.m mVar) {
        n nVar;
        n nVar2;
        com.baidu.tieba.model.j jVar;
        Boolean bool;
        Handler handler;
        Runnable runnable;
        Handler handler2;
        Runnable runnable2;
        nVar = this.a.a;
        nVar.a(true, "");
        if (z) {
            nVar2 = this.a.a;
            jVar = this.a.c;
            com.baidu.tieba.data.m a = jVar.a();
            bool = this.a.d;
            nVar2.a(a, bool.booleanValue());
            handler = this.a.f;
            runnable = this.a.g;
            handler.removeCallbacks(runnable);
            handler2 = this.a.f;
            runnable2 = this.a.g;
            handler2.postDelayed(runnable2, 0L);
            return;
        }
        this.a.a(str);
    }
}
