package com.baidu.tbadk.util;

import com.baidu.tbadk.TbConfig;
/* loaded from: classes.dex */
public class q extends Thread {
    private int aEG;
    private int aEH;
    private String type = null;

    public q(int i, int i2) {
        this.aEG = 0;
        this.aEH = 0;
        this.aEG = i;
        this.aEH = i2;
    }

    public void setType(String str) {
        this.type = str;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        super.run();
        com.baidu.tbadk.core.util.z zVar = new com.baidu.tbadk.core.util.z(String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.LOAD_REG_PV_ADDRESS);
        zVar.n("img_num", String.valueOf(this.aEG));
        zVar.n("img_total", String.valueOf(this.aEH));
        if (this.type != null) {
            zVar.n("img_type", this.type);
        }
        zVar.uk();
    }
}
