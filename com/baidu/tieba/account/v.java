package com.baidu.tieba.account;

import android.os.Build;
/* loaded from: classes.dex */
public class v extends Thread {
    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        super.run();
        com.baidu.tieba.util.ax axVar = new com.baidu.tieba.util.ax(com.baidu.tieba.data.h.a + "c/s/inpv");
        axVar.a("st_type", "enter_fore");
        axVar.a("os_version", Build.VERSION.RELEASE);
        axVar.a("subapp_type", "im");
        axVar.m();
    }
}
