package com.baidu.tieba.account;

import android.os.Build;
/* loaded from: classes.dex */
public class v extends Thread {
    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        super.run();
        com.baidu.tieba.util.an anVar = new com.baidu.tieba.util.an(com.baidu.tieba.data.h.a + "c/s/inpv");
        anVar.a("st_type", "enter_fore");
        anVar.a("os_version", Build.VERSION.RELEASE);
        anVar.a("subapp_type", "im");
        anVar.l();
    }
}
