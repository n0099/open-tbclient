package com.baidu.tbadk.util;

import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.util.ad;
/* loaded from: classes.dex */
public class i extends Thread {
    private int ahw;
    private int ahx;
    private String type = null;

    public i(int i, int i2) {
        this.ahw = 0;
        this.ahx = 0;
        this.ahw = i;
        this.ahx = i2;
    }

    public void setType(String str) {
        this.type = str;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        super.run();
        ad adVar = new ad(String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.LOAD_REG_PV_ADDRESS);
        adVar.o("img_num", String.valueOf(this.ahw));
        adVar.o("img_total", String.valueOf(this.ahx));
        if (this.type != null) {
            adVar.o("img_type", this.type);
        }
        adVar.ov();
    }
}
