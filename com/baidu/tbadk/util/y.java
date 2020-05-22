package com.baidu.tbadk.util;

import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes.dex */
public class y extends Thread {
    private int evs;
    private int imageNum;
    private String type = null;

    public y(int i, int i2) {
        this.imageNum = 0;
        this.evs = 0;
        this.imageNum = i;
        this.evs = i2;
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
            xVar.addPostData("img_total", String.valueOf(this.evs));
            if (this.type != null) {
                xVar.addPostData("img_type", this.type);
            }
            xVar.postNetData();
        }
    }
}
