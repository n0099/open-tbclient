package com.baidu.tieba.account;
/* loaded from: classes.dex */
public class af extends Thread {

    /* renamed from: a  reason: collision with root package name */
    private String f643a;
    private String b;

    public af(String str) {
        this.f643a = null;
        this.b = null;
        this.f643a = str;
    }

    public af(String str, String str2) {
        this.f643a = null;
        this.b = null;
        this.f643a = str;
        this.b = str2;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        super.run();
        com.baidu.tieba.util.r rVar = new com.baidu.tieba.util.r(String.valueOf(com.baidu.tieba.data.g.f787a) + "c/s/pv");
        rVar.a("st_type", this.f643a);
        if (this.b != null) {
            rVar.a("st_param", this.b);
        }
        rVar.j();
    }
}
