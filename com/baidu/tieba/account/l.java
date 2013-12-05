package com.baidu.tieba.account;

import android.os.Build;
/* loaded from: classes.dex */
public class l extends Thread {
    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        super.run();
        com.baidu.tieba.util.am amVar = new com.baidu.tieba.util.am(com.baidu.tieba.data.h.f1248a + "c/s/inpv");
        amVar.a("st_type", "enter_fore");
        amVar.a("os_version", Build.VERSION.RELEASE);
        amVar.a("subapp_type", "im");
        amVar.l();
    }
}
