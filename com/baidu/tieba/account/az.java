package com.baidu.tieba.account;
/* loaded from: classes.dex */
public class az extends Thread {

    /* renamed from: a  reason: collision with root package name */
    private String f893a;

    public az(String str) {
        this.f893a = str;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        super.run();
        com.baidu.tieba.util.v vVar = new com.baidu.tieba.util.v(String.valueOf(com.baidu.tieba.data.g.f1014a) + "/c/s/pv");
        vVar.a("share_channel", this.f893a);
        vVar.j();
    }
}
