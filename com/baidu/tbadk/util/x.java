package com.baidu.tbadk.util;

import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes.dex */
public class x extends Thread {
    private int dGJ;
    private int imageNum;
    private String type = null;

    public x(int i, int i2) {
        this.imageNum = 0;
        this.dGJ = 0;
        this.imageNum = i;
        this.dGJ = i2;
    }

    public void setType(String str) {
        this.type = str;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        super.run();
        if (!TbadkCoreApplication.getInst().checkInterrupt()) {
            com.baidu.tbadk.core.util.x xVar = new com.baidu.tbadk.core.util.x(TbConfig.SERVER_ADDRESS + TbConfig.LOAD_REG_PV_ADDRESS);
            xVar.addPostData("img_num", String.valueOf(this.imageNum));
            xVar.addPostData("img_total", String.valueOf(this.dGJ));
            if (this.type != null) {
                xVar.addPostData("img_type", this.type);
            }
            xVar.postNetData();
        }
    }
}
