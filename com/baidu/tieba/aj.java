package com.baidu.tieba;

import android.os.Handler;
/* loaded from: classes.dex */
class aj implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ MainTabActivity f903a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aj(MainTabActivity mainTabActivity) {
        this.f903a = mainTabActivity;
    }

    @Override // java.lang.Runnable
    public void run() {
        com.baidu.tieba.recommend.z zVar;
        com.baidu.tieba.recommend.z zVar2;
        Handler handler;
        Handler handler2;
        zVar = this.f903a.F;
        if (zVar == null) {
            this.f903a.F = new com.baidu.tieba.recommend.z(this.f903a);
        }
        zVar2 = this.f903a.F;
        zVar2.a();
        handler = this.f903a.s;
        handler.removeCallbacks(this);
        handler2 = this.f903a.s;
        handler2.postDelayed(this, com.baidu.tieba.data.g.n.longValue());
    }
}
