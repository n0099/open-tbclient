package com.baidu.tbadk.util;

import com.baidu.tbadk.TbConfig;
/* loaded from: classes.dex */
public class q extends Thread {
    private int aDw;
    private int aDx;
    private String type = null;

    public q(int i, int i2) {
        this.aDw = 0;
        this.aDx = 0;
        this.aDw = i;
        this.aDx = i2;
    }

    public void setType(String str) {
        this.type = str;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        super.run();
        com.baidu.tbadk.core.util.y yVar = new com.baidu.tbadk.core.util.y(String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.LOAD_REG_PV_ADDRESS);
        yVar.n("img_num", String.valueOf(this.aDw));
        yVar.n("img_total", String.valueOf(this.aDx));
        if (this.type != null) {
            yVar.n("img_type", this.type);
        }
        yVar.ud();
    }
}
