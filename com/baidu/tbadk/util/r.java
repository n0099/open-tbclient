package com.baidu.tbadk.util;

import com.baidu.tbadk.TbConfig;
/* loaded from: classes.dex */
public class r extends Thread {
    private int aVC;
    private int aVD;
    private String type = null;

    public r(int i, int i2) {
        this.aVC = 0;
        this.aVD = 0;
        this.aVC = i;
        this.aVD = i2;
    }

    public void setType(String str) {
        this.type = str;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        super.run();
        com.baidu.tbadk.core.util.y yVar = new com.baidu.tbadk.core.util.y(TbConfig.SERVER_ADDRESS + TbConfig.LOAD_REG_PV_ADDRESS);
        yVar.o("img_num", String.valueOf(this.aVC));
        yVar.o("img_total", String.valueOf(this.aVD));
        if (this.type != null) {
            yVar.o("img_type", this.type);
        }
        yVar.yl();
    }
}
