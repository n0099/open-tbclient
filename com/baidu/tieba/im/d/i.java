package com.baidu.tieba.im.d;

import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.util.ae;
/* loaded from: classes.dex */
public class i extends Thread {
    private String a;
    private String b;
    private String c;

    public i(String str, String str2, String str3) {
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
        ae aeVar = new ae(String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.LOAD_REG_PV_ADDRESS);
        aeVar.a("obj", this.a);
        aeVar.a("obj_tp", this.b);
        aeVar.a(com.baidu.tbadk.core.frameworkData.a.GROUP_ID, this.c);
        aeVar.h();
    }
}
