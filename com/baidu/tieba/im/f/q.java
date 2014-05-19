package com.baidu.tieba.im.f;

import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.util.al;
/* loaded from: classes.dex */
public class q extends Thread {
    private String a;
    private String b;
    private String c;

    public q(String str, String str2, String str3) {
        this.a = null;
        this.b = null;
        this.c = null;
        this.a = str;
        this.b = str2;
        this.c = str3;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        super.run();
        al alVar = new al(String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.LOAD_REG_PV_ADDRESS);
        alVar.a("obj", this.a);
        alVar.a("obj_tp", this.b);
        alVar.a(com.baidu.tbadk.core.frameworkData.a.GROUP_ID, this.c);
        alVar.i();
    }
}
