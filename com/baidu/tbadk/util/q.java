package com.baidu.tbadk.util;

import com.baidu.tbadk.TbConfig;
/* loaded from: classes.dex */
public class q extends Thread {
    private int aWA;
    private int aWz;
    private String type = null;

    public q(int i, int i2) {
        this.aWz = 0;
        this.aWA = 0;
        this.aWz = i;
        this.aWA = i2;
    }

    public void setType(String str) {
        this.type = str;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        super.run();
        com.baidu.tbadk.core.util.y yVar = new com.baidu.tbadk.core.util.y(TbConfig.SERVER_ADDRESS + TbConfig.LOAD_REG_PV_ADDRESS);
        yVar.o("img_num", String.valueOf(this.aWz));
        yVar.o("img_total", String.valueOf(this.aWA));
        if (this.type != null) {
            yVar.o("img_type", this.type);
        }
        yVar.yo();
    }
}
