package com.baidu.tbadk.util;

import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.util.aa;
/* loaded from: classes.dex */
public class k extends Thread {
    private int ask;
    private int asl;
    private String type = null;

    public k(int i, int i2) {
        this.ask = 0;
        this.asl = 0;
        this.ask = i;
        this.asl = i2;
    }

    public void setType(String str) {
        this.type = str;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        super.run();
        aa aaVar = new aa(String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.LOAD_REG_PV_ADDRESS);
        aaVar.o("img_num", String.valueOf(this.ask));
        aaVar.o("img_total", String.valueOf(this.asl));
        if (this.type != null) {
            aaVar.o("img_type", this.type);
        }
        aaVar.sw();
    }
}
