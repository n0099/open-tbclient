package com.baidu.tbadk.util;

import com.baidu.tbadk.TbConfig;
/* loaded from: classes.dex */
public class q extends Thread {
    private int aNg;
    private int aNh;
    private String type = null;

    public q(int i, int i2) {
        this.aNg = 0;
        this.aNh = 0;
        this.aNg = i;
        this.aNh = i2;
    }

    public void setType(String str) {
        this.type = str;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        super.run();
        com.baidu.tbadk.core.util.x xVar = new com.baidu.tbadk.core.util.x(TbConfig.SERVER_ADDRESS + TbConfig.LOAD_REG_PV_ADDRESS);
        xVar.n("img_num", String.valueOf(this.aNg));
        xVar.n("img_total", String.valueOf(this.aNh));
        if (this.type != null) {
            xVar.n("img_type", this.type);
        }
        xVar.up();
    }
}
