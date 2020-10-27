package com.baidu.tbadk.util;

import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes.dex */
public class z extends Thread {
    private int ftf;
    private int imageNum;
    private String type = null;

    public z(int i, int i2) {
        this.imageNum = 0;
        this.ftf = 0;
        this.imageNum = i;
        this.ftf = i2;
    }

    public void setType(String str) {
        this.type = str;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        super.run();
        if (!TbadkCoreApplication.getInst().checkInterrupt()) {
            com.baidu.tbadk.core.util.aa aaVar = new com.baidu.tbadk.core.util.aa(TbConfig.SERVER_ADDRESS + TbConfig.LOAD_REG_PV_ADDRESS);
            aaVar.addPostData("img_num", String.valueOf(this.imageNum));
            aaVar.addPostData("img_total", String.valueOf(this.ftf));
            if (this.type != null) {
                aaVar.addPostData("img_type", this.type);
            }
            aaVar.postNetData();
        }
    }
}
