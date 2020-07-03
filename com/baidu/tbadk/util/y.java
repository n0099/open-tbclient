package com.baidu.tbadk.util;

import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes.dex */
public class y extends Thread {
    private int eEy;
    private int imageNum;
    private String type = null;

    public y(int i, int i2) {
        this.imageNum = 0;
        this.eEy = 0;
        this.imageNum = i;
        this.eEy = i2;
    }

    public void setType(String str) {
        this.type = str;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        super.run();
        if (!TbadkCoreApplication.getInst().checkInterrupt()) {
            com.baidu.tbadk.core.util.y yVar = new com.baidu.tbadk.core.util.y(TbConfig.SERVER_ADDRESS + TbConfig.LOAD_REG_PV_ADDRESS);
            yVar.addPostData("img_num", String.valueOf(this.imageNum));
            yVar.addPostData("img_total", String.valueOf(this.eEy));
            if (this.type != null) {
                yVar.addPostData("img_type", this.type);
            }
            yVar.postNetData();
        }
    }
}
