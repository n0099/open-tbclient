package com.baidu.tbadk.util;

import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.util.aa;
/* loaded from: classes.dex */
public class l extends Thread {
    private int aDb;
    private int aDc;
    private String type = null;

    public l(int i, int i2) {
        this.aDb = 0;
        this.aDc = 0;
        this.aDb = i;
        this.aDc = i2;
    }

    public void setType(String str) {
        this.type = str;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        super.run();
        aa aaVar = new aa(String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.LOAD_REG_PV_ADDRESS);
        aaVar.p("img_num", String.valueOf(this.aDb));
        aaVar.p("img_total", String.valueOf(this.aDc));
        if (this.type != null) {
            aaVar.p("img_type", this.type);
        }
        aaVar.uZ();
    }
}
