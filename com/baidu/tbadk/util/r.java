package com.baidu.tbadk.util;

import com.baidu.tbadk.TbConfig;
/* loaded from: classes.dex */
public class r extends Thread {
    private int aJn;
    private int aJo;
    private String type = null;

    public r(int i, int i2) {
        this.aJn = 0;
        this.aJo = 0;
        this.aJn = i;
        this.aJo = i2;
    }

    public void setType(String str) {
        this.type = str;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        super.run();
        com.baidu.tbadk.core.util.z zVar = new com.baidu.tbadk.core.util.z(String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.LOAD_REG_PV_ADDRESS);
        zVar.n("img_num", String.valueOf(this.aJn));
        zVar.n("img_total", String.valueOf(this.aJo));
        if (this.type != null) {
            zVar.n("img_type", this.type);
        }
        zVar.ul();
    }
}
