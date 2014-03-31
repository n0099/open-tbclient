package com.baidu.tieba.im.f;

import com.baidu.tbadk.core.util.ak;
/* loaded from: classes.dex */
public final class p extends Thread {
    private String a;
    private String b;
    private String c;

    public p(String str, String str2, String str3) {
        this.a = null;
        this.b = null;
        this.c = null;
        this.a = str;
        this.b = str2;
        this.c = str3;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public final void run() {
        super.run();
        ak akVar = new ak(String.valueOf(com.baidu.tbadk.core.data.n.a) + "c/s/pv");
        akVar.a("obj", this.a);
        akVar.a("obj_tp", this.b);
        akVar.a("group_id", this.c);
        akVar.i();
    }
}
