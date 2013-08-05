package com.baidu.tieba;

import android.os.Handler;
/* loaded from: classes.dex */
class aj implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ MainTabActivity f905a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aj(MainTabActivity mainTabActivity) {
        this.f905a = mainTabActivity;
    }

    @Override // java.lang.Runnable
    public void run() {
        com.baidu.tieba.recommend.z zVar;
        com.baidu.tieba.recommend.z zVar2;
        Handler handler;
        Handler handler2;
        zVar = this.f905a.F;
        if (zVar == null) {
            this.f905a.F = new com.baidu.tieba.recommend.z(this.f905a);
        }
        zVar2 = this.f905a.F;
        zVar2.a();
        handler = this.f905a.s;
        handler.removeCallbacks(this);
        handler2 = this.f905a.s;
        handler2.postDelayed(this, com.baidu.tieba.data.g.n.longValue());
    }
}
