package com.baidu.tbadk.util;

import com.baidu.tbadk.TbConfig;
/* loaded from: classes.dex */
public class q extends Thread {
    private int aJj;
    private int aJk;
    private String type = null;

    public q(int i, int i2) {
        this.aJj = 0;
        this.aJk = 0;
        this.aJj = i;
        this.aJk = i2;
    }

    public void setType(String str) {
        this.type = str;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        super.run();
        com.baidu.tbadk.core.util.z zVar = new com.baidu.tbadk.core.util.z(String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.LOAD_REG_PV_ADDRESS);
        zVar.n("img_num", String.valueOf(this.aJj));
        zVar.n("img_total", String.valueOf(this.aJk));
        if (this.type != null) {
            zVar.n("img_type", this.type);
        }
        zVar.uY();
    }
}
