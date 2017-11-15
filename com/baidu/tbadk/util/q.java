package com.baidu.tbadk.util;

import com.baidu.tbadk.TbConfig;
/* loaded from: classes.dex */
public class q extends Thread {
    private int aMC;
    private int aMD;
    private String type = null;

    public q(int i, int i2) {
        this.aMC = 0;
        this.aMD = 0;
        this.aMC = i;
        this.aMD = i2;
    }

    public void setType(String str) {
        this.type = str;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        super.run();
        com.baidu.tbadk.core.util.x xVar = new com.baidu.tbadk.core.util.x(TbConfig.SERVER_ADDRESS + TbConfig.LOAD_REG_PV_ADDRESS);
        xVar.n("img_num", String.valueOf(this.aMC));
        xVar.n("img_total", String.valueOf(this.aMD));
        if (this.type != null) {
            xVar.n("img_type", this.type);
        }
        xVar.up();
    }
}
