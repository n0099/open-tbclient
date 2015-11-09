package com.baidu.tbadk.util;

import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.util.w;
/* loaded from: classes.dex */
public class k extends Thread {
    private int ayy;
    private int ayz;
    private String type = null;

    public k(int i, int i2) {
        this.ayy = 0;
        this.ayz = 0;
        this.ayy = i;
        this.ayz = i2;
    }

    public void setType(String str) {
        this.type = str;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        super.run();
        w wVar = new w(String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.LOAD_REG_PV_ADDRESS);
        wVar.o("img_num", String.valueOf(this.ayy));
        wVar.o("img_total", String.valueOf(this.ayz));
        if (this.type != null) {
            wVar.o("img_type", this.type);
        }
        wVar.tG();
    }
}
