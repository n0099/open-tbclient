package com.baidu.tieba.account;
/* loaded from: classes.dex */
public class az extends Thread {

    /* renamed from: a  reason: collision with root package name */
    private String f872a;

    public az(String str) {
        this.f872a = str;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        super.run();
        com.baidu.tieba.util.u uVar = new com.baidu.tieba.util.u(String.valueOf(com.baidu.tieba.data.g.f1011a) + "/c/s/pv");
        uVar.a("share_channel", this.f872a);
        uVar.k();
    }
}
