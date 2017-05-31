package com.baidu.tbadk.util;

import com.baidu.tbadk.TbConfig;
/* loaded from: classes.dex */
public class r extends Thread {
    private int aJa;
    private int aJb;
    private String type = null;

    public r(int i, int i2) {
        this.aJa = 0;
        this.aJb = 0;
        this.aJa = i;
        this.aJb = i2;
    }

    public void setType(String str) {
        this.type = str;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        super.run();
        com.baidu.tbadk.core.util.z zVar = new com.baidu.tbadk.core.util.z(String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.LOAD_REG_PV_ADDRESS);
        zVar.n("img_num", String.valueOf(this.aJa));
        zVar.n("img_total", String.valueOf(this.aJb));
        if (this.type != null) {
            zVar.n("img_type", this.type);
        }
        zVar.ug();
    }
}
