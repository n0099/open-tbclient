package com.baidu.tbadk.util;

import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.util.ab;
/* loaded from: classes.dex */
public class o extends Thread {
    private int aDZ;
    private int aEa;
    private String type = null;

    public o(int i, int i2) {
        this.aDZ = 0;
        this.aEa = 0;
        this.aDZ = i;
        this.aEa = i2;
    }

    public void setType(String str) {
        this.type = str;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        super.run();
        ab abVar = new ab(String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.LOAD_REG_PV_ADDRESS);
        abVar.p("img_num", String.valueOf(this.aDZ));
        abVar.p("img_total", String.valueOf(this.aEa));
        if (this.type != null) {
            abVar.p("img_type", this.type);
        }
        abVar.vw();
    }
}
