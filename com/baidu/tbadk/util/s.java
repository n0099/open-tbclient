package com.baidu.tbadk.util;

import com.baidu.tbadk.TbConfig;
/* loaded from: classes.dex */
public class s extends Thread {
    private int aZR;
    private int aZS;
    private String type = null;

    public s(int i, int i2) {
        this.aZR = 0;
        this.aZS = 0;
        this.aZR = i;
        this.aZS = i2;
    }

    public void setType(String str) {
        this.type = str;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        super.run();
        com.baidu.tbadk.core.util.x xVar = new com.baidu.tbadk.core.util.x(TbConfig.SERVER_ADDRESS + TbConfig.LOAD_REG_PV_ADDRESS);
        xVar.u("img_num", String.valueOf(this.aZR));
        xVar.u("img_total", String.valueOf(this.aZS));
        if (this.type != null) {
            xVar.u("img_type", this.type);
        }
        xVar.zt();
    }
}
