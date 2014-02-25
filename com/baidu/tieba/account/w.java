package com.baidu.tieba.account;

import android.os.Build;
/* loaded from: classes.dex */
public class w extends Thread {
    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        super.run();
        com.baidu.tieba.util.ba baVar = new com.baidu.tieba.util.ba(String.valueOf(com.baidu.tieba.data.i.a) + "c/s/inpv");
        baVar.a("st_type", "enter_fore");
        baVar.a("os_version", Build.VERSION.RELEASE);
        baVar.a("subapp_type", "im");
        baVar.m();
    }
}
