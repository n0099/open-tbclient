package com.baidu.tbadk.util;

import com.baidu.tbadk.TbConfig;
/* loaded from: classes.dex */
public class p extends Thread {
    private int aLx;
    private int aLy;
    private String type = null;

    public p(int i, int i2) {
        this.aLx = 0;
        this.aLy = 0;
        this.aLx = i;
        this.aLy = i2;
    }

    public void setType(String str) {
        this.type = str;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        super.run();
        com.baidu.tbadk.core.util.w wVar = new com.baidu.tbadk.core.util.w(TbConfig.SERVER_ADDRESS + TbConfig.LOAD_REG_PV_ADDRESS);
        wVar.n("img_num", String.valueOf(this.aLx));
        wVar.n("img_total", String.valueOf(this.aLy));
        if (this.type != null) {
            wVar.n("img_type", this.type);
        }
        wVar.uE();
    }
}
