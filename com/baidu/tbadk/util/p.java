package com.baidu.tbadk.util;

import com.baidu.tbadk.TbConfig;
/* loaded from: classes.dex */
public class p extends Thread {
    private int aMr;
    private int aMs;
    private String type = null;

    public p(int i, int i2) {
        this.aMr = 0;
        this.aMs = 0;
        this.aMr = i;
        this.aMs = i2;
    }

    public void setType(String str) {
        this.type = str;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        super.run();
        com.baidu.tbadk.core.util.x xVar = new com.baidu.tbadk.core.util.x(TbConfig.SERVER_ADDRESS + TbConfig.LOAD_REG_PV_ADDRESS);
        xVar.n("img_num", String.valueOf(this.aMr));
        xVar.n("img_total", String.valueOf(this.aMs));
        if (this.type != null) {
            xVar.n("img_type", this.type);
        }
        xVar.uM();
    }
}
