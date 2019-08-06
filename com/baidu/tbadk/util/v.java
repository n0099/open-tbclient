package com.baidu.tbadk.util;

import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes.dex */
public class v extends Thread {
    private int cDn;
    private int imageNum;
    private String type = null;

    public v(int i, int i2) {
        this.imageNum = 0;
        this.cDn = 0;
        this.imageNum = i;
        this.cDn = i2;
    }

    public void setType(String str) {
        this.type = str;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        super.run();
        if (!TbadkCoreApplication.getInst().checkInterrupt()) {
            com.baidu.tbadk.core.util.x xVar = new com.baidu.tbadk.core.util.x(TbConfig.SERVER_ADDRESS + TbConfig.LOAD_REG_PV_ADDRESS);
            xVar.o("img_num", String.valueOf(this.imageNum));
            xVar.o("img_total", String.valueOf(this.cDn));
            if (this.type != null) {
                xVar.o("img_type", this.type);
            }
            xVar.aii();
        }
    }
}
