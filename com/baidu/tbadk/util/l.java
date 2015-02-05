package com.baidu.tbadk.util;

import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.util.ad;
/* loaded from: classes.dex */
public class l extends Thread {
    private int ahV;
    private int ahW;
    private String type = null;

    public l(int i, int i2) {
        this.ahV = 0;
        this.ahW = 0;
        this.ahV = i;
        this.ahW = i2;
    }

    public void setType(String str) {
        this.type = str;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        super.run();
        ad adVar = new ad(String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.LOAD_REG_PV_ADDRESS);
        adVar.o("img_num", String.valueOf(this.ahV));
        adVar.o("img_total", String.valueOf(this.ahW));
        if (this.type != null) {
            adVar.o("img_type", this.type);
        }
        adVar.or();
    }
}
