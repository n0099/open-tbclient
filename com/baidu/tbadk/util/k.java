package com.baidu.tbadk.util;

import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.util.w;
/* loaded from: classes.dex */
public class k extends Thread {
    private int azK;
    private int azL;
    private String type = null;

    public k(int i, int i2) {
        this.azK = 0;
        this.azL = 0;
        this.azK = i;
        this.azL = i2;
    }

    public void setType(String str) {
        this.type = str;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        super.run();
        w wVar = new w(String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.LOAD_REG_PV_ADDRESS);
        wVar.o("img_num", String.valueOf(this.azK));
        wVar.o("img_total", String.valueOf(this.azL));
        if (this.type != null) {
            wVar.o("img_type", this.type);
        }
        wVar.tD();
    }
}
