package com.baidu.tieba.account;

import android.os.Build;
/* loaded from: classes.dex */
public class v extends Thread {
    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        super.run();
        com.baidu.tieba.util.at atVar = new com.baidu.tieba.util.at(com.baidu.tieba.data.h.a + "c/s/inpv");
        atVar.a("st_type", "enter_fore");
        atVar.a("os_version", Build.VERSION.RELEASE);
        atVar.a("subapp_type", "im");
        atVar.l();
    }
}
