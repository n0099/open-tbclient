package com.baidu.tbadk.util;

import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes.dex */
public class y extends Thread {
    private int eKU;
    private int imageNum;
    private String type = null;

    public y(int i, int i2) {
        this.imageNum = 0;
        this.eKU = 0;
        this.imageNum = i;
        this.eKU = i2;
    }

    public void setType(String str) {
        this.type = str;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        super.run();
        if (!TbadkCoreApplication.getInst().checkInterrupt()) {
            com.baidu.tbadk.core.util.z zVar = new com.baidu.tbadk.core.util.z(TbConfig.SERVER_ADDRESS + TbConfig.LOAD_REG_PV_ADDRESS);
            zVar.addPostData("img_num", String.valueOf(this.imageNum));
            zVar.addPostData("img_total", String.valueOf(this.eKU));
            if (this.type != null) {
                zVar.addPostData("img_type", this.type);
            }
            zVar.postNetData();
        }
    }
}
