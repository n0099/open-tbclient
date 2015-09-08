package com.baidu.tbadk.util;

import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.util.v;
/* loaded from: classes.dex */
public class j extends Thread {
    private int aAY;
    private int aAZ;
    private String type = null;

    public j(int i, int i2) {
        this.aAY = 0;
        this.aAZ = 0;
        this.aAY = i;
        this.aAZ = i2;
    }

    public void setType(String str) {
        this.type = str;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        super.run();
        v vVar = new v(String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.LOAD_REG_PV_ADDRESS);
        vVar.o("img_num", String.valueOf(this.aAY));
        vVar.o("img_total", String.valueOf(this.aAZ));
        if (this.type != null) {
            vVar.o("img_type", this.type);
        }
        vVar.tI();
    }
}
