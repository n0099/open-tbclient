package com.baidu.tbadk.util;

import com.baidu.tbadk.TbConfig;
/* loaded from: classes.dex */
public class q extends Thread {
    private int bDe;
    private int bDf;
    private String type = null;

    public q(int i, int i2) {
        this.bDe = 0;
        this.bDf = 0;
        this.bDe = i;
        this.bDf = i2;
    }

    public void setType(String str) {
        this.type = str;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        super.run();
        com.baidu.tbadk.core.util.x xVar = new com.baidu.tbadk.core.util.x(TbConfig.SERVER_ADDRESS + TbConfig.LOAD_REG_PV_ADDRESS);
        xVar.n("img_num", String.valueOf(this.bDe));
        xVar.n("img_total", String.valueOf(this.bDf));
        if (this.type != null) {
            xVar.n("img_type", this.type);
        }
        xVar.Ca();
    }
}
