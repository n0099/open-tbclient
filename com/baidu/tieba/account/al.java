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
        aVar = this.a.m;
        if (aVar != null) {
            aVar2 = this.a.m;
            if (aVar2.b() != null) {
                aVar3 = this.a.m;
                if (!aVar3.b().equals("BaiduUser")) {
                    ReLoginActivity reLoginActivity = this.a;
                    aVar4 = this.a.m;
                    reLoginActivity.a(aVar4);
                    return;
                }
            }
            this.a.m();
            return;
        }
        ReLoginActivity reLoginActivity2 = this.a;
        str = this.a.p;
        reLoginActivity2.a(1, str);
    }
}
