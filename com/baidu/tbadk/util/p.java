package com.baidu.tbadk.util;

import com.baidu.tbadk.TbConfig;
/* loaded from: classes.dex */
public class p extends Thread {
    private int aMu;
    private int aMv;
    private String type = null;

    public p(int i, int i2) {
        this.aMu = 0;
        this.aMv = 0;
        this.aMu = i;
        this.aMv = i2;
    }

    public void setType(String str) {
        this.type = str;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        super.run();
        com.baidu.tbadk.core.util.x xVar = new com.baidu.tbadk.core.util.x(TbConfig.SERVER_ADDRESS + TbConfig.LOAD_REG_PV_ADDRESS);
        xVar.n("img_num", String.valueOf(this.aMu));
        xVar.n("img_total", String.valueOf(this.aMv));
        if (this.type != null) {
            xVar.n("img_type", this.type);
        }
        xVar.uM();
    }
}
