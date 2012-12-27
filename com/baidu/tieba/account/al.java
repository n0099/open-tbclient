package com.baidu.tieba.account;
/* loaded from: classes.dex */
class al implements Runnable {
    final /* synthetic */ ReLoginActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public al(ReLoginActivity reLoginActivity) {
        this.a = reLoginActivity;
    }

    @Override // java.lang.Runnable
    public void run() {
        com.baidu.tieba.a.a aVar;
        String str;
        com.baidu.tieba.a.a aVar2;
        com.baidu.tieba.a.a aVar3;
        com.baidu.tieba.a.a aVar4;
        aVar = this.a.j;
        if (aVar == null) {
            ReLoginActivity reLoginActivity = this.a;
            str = this.a.m;
            reLoginActivity.a(1, str);
            return;
        }
        aVar2 = this.a.j;
        if (aVar2.b() != null) {
            aVar3 = this.a.j;
            if (!aVar3.b().equals("BaiduUser")) {
                ReLoginActivity reLoginActivity2 = this.a;
                aVar4 = this.a.j;
                reLoginActivity2.a(aVar4);
                return;
            }
        }
        this.a.k();
    }
}
