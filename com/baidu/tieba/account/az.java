package com.baidu.tieba.account;
/* loaded from: classes.dex */
public class az extends Thread {

    /* renamed from: a  reason: collision with root package name */
    private String f909a;

    public az(String str) {
        this.f909a = str;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        super.run();
        com.baidu.tieba.util.z zVar = new com.baidu.tieba.util.z(String.valueOf(com.baidu.tieba.data.g.f1032a) + "/c/s/pv");
        zVar.a("share_channel", this.f909a);
        zVar.j();
    }
}
