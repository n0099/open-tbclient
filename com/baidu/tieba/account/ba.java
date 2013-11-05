package com.baidu.tieba.account;
/* loaded from: classes.dex */
public class ba extends Thread {

    /* renamed from: a  reason: collision with root package name */
    private String f1039a;

    public ba(String str) {
        this.f1039a = str;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        super.run();
        com.baidu.tieba.util.ag agVar = new com.baidu.tieba.util.ag(com.baidu.tieba.data.h.f1165a + "/c/s/pv");
        agVar.a("share_channel", this.f1039a);
        agVar.j();
    }
}
