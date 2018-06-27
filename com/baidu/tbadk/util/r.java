package com.baidu.tbadk.util;

import com.baidu.tbadk.TbConfig;
/* loaded from: classes.dex */
public class r extends Thread {
    private int aWx;
    private int aWy;
    private String type = null;

    public r(int i, int i2) {
        this.aWx = 0;
        this.aWy = 0;
        this.aWx = i;
        this.aWy = i2;
    }

    public void setType(String str) {
        this.type = str;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        super.run();
        com.baidu.tbadk.core.util.y yVar = new com.baidu.tbadk.core.util.y(TbConfig.SERVER_ADDRESS + TbConfig.LOAD_REG_PV_ADDRESS);
        yVar.o("img_num", String.valueOf(this.aWx));
        yVar.o("img_total", String.valueOf(this.aWy));
        if (this.type != null) {
            yVar.o("img_type", this.type);
        }
        yVar.yz();
    }
}
