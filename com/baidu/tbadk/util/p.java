package com.baidu.tbadk.util;

import com.baidu.tbadk.TbConfig;
/* loaded from: classes.dex */
public class p extends Thread {
    private int aMO;
    private int aMP;
    private String type = null;

    public p(int i, int i2) {
        this.aMO = 0;
        this.aMP = 0;
        this.aMO = i;
        this.aMP = i2;
    }

    public void setType(String str) {
        this.type = str;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        super.run();
        com.baidu.tbadk.core.util.w wVar = new com.baidu.tbadk.core.util.w(TbConfig.SERVER_ADDRESS + TbConfig.LOAD_REG_PV_ADDRESS);
        wVar.n("img_num", String.valueOf(this.aMO));
        wVar.n("img_total", String.valueOf(this.aMP));
        if (this.type != null) {
            wVar.n("img_type", this.type);
        }
        wVar.uP();
    }
}
