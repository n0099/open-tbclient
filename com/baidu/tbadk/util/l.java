package com.baidu.tbadk.util;

import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.util.ad;
/* loaded from: classes.dex */
public class l extends Thread {
    private int ahY;
    private int ahZ;
    private String type = null;

    public l(int i, int i2) {
        this.ahY = 0;
        this.ahZ = 0;
        this.ahY = i;
        this.ahZ = i2;
    }

    public void setType(String str) {
        this.type = str;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        super.run();
        ad adVar = new ad(String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.LOAD_REG_PV_ADDRESS);
        adVar.o("img_num", String.valueOf(this.ahY));
        adVar.o("img_total", String.valueOf(this.ahZ));
        if (this.type != null) {
            adVar.o("img_type", this.type);
        }
        adVar.oy();
    }
}
