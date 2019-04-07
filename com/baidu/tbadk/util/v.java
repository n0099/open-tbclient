package com.baidu.tbadk.util;

import com.baidu.tbadk.TbConfig;
/* loaded from: classes.dex */
public class v extends Thread {
    private int ctE;
    private int imageNum;
    private String type = null;

    public v(int i, int i2) {
        this.imageNum = 0;
        this.ctE = 0;
        this.imageNum = i;
        this.ctE = i2;
    }

    public void setType(String str) {
        this.type = str;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        super.run();
        com.baidu.tbadk.core.util.x xVar = new com.baidu.tbadk.core.util.x(TbConfig.SERVER_ADDRESS + TbConfig.LOAD_REG_PV_ADDRESS);
        xVar.x("img_num", String.valueOf(this.imageNum));
        xVar.x("img_total", String.valueOf(this.ctE));
        if (this.type != null) {
            xVar.x("img_type", this.type);
        }
        xVar.acg();
    }
}
