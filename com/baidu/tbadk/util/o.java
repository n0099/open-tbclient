package com.baidu.tbadk.util;

import com.baidu.tbadk.TbConfig;
/* loaded from: classes.dex */
public class o extends Thread {
    private int aLG;
    private int aLH;
    private String type = null;

    public o(int i, int i2) {
        this.aLG = 0;
        this.aLH = 0;
        this.aLG = i;
        this.aLH = i2;
    }

    public void setType(String str) {
        this.type = str;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        super.run();
        com.baidu.tbadk.core.util.x xVar = new com.baidu.tbadk.core.util.x(TbConfig.SERVER_ADDRESS + TbConfig.LOAD_REG_PV_ADDRESS);
        xVar.n("img_num", String.valueOf(this.aLG));
        xVar.n("img_total", String.valueOf(this.aLH));
        if (this.type != null) {
            xVar.n("img_type", this.type);
        }
        xVar.ui();
    }
}
