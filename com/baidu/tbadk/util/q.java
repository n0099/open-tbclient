package com.baidu.tbadk.util;

import com.baidu.tbadk.TbConfig;
/* loaded from: classes.dex */
public class q extends Thread {
    private int aJl;
    private int aJm;
    private String type = null;

    public q(int i, int i2) {
        this.aJl = 0;
        this.aJm = 0;
        this.aJl = i;
        this.aJm = i2;
    }

    public void setType(String str) {
        this.type = str;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        super.run();
        com.baidu.tbadk.core.util.z zVar = new com.baidu.tbadk.core.util.z(String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.LOAD_REG_PV_ADDRESS);
        zVar.n("img_num", String.valueOf(this.aJl));
        zVar.n("img_total", String.valueOf(this.aJm));
        if (this.type != null) {
            zVar.n("img_type", this.type);
        }
        zVar.uY();
    }
}
