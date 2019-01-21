package com.baidu.tbadk.util;

import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes.dex */
public class t extends Thread {
    private int bjy;
    private int imageNum;
    private String type = null;

    public t(int i, int i2) {
        this.imageNum = 0;
        this.bjy = 0;
        this.imageNum = i;
        this.bjy = i2;
    }

    public void setType(String str) {
        this.type = str;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        super.run();
        if (!TbadkCoreApplication.getInst().checkInterrupt()) {
            com.baidu.tbadk.core.util.x xVar = new com.baidu.tbadk.core.util.x(TbConfig.SERVER_ADDRESS + TbConfig.LOAD_REG_PV_ADDRESS);
            xVar.x("img_num", String.valueOf(this.imageNum));
            xVar.x("img_total", String.valueOf(this.bjy));
            if (this.type != null) {
                xVar.x("img_type", this.type);
            }
            xVar.CY();
        }
    }
}
