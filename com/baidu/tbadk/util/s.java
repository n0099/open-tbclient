package com.baidu.tbadk.util;

import com.baidu.tbadk.TbConfig;
/* loaded from: classes.dex */
public class s extends Thread {
    private int aKp;
    private int aKq;
    private String type = null;

    public s(int i, int i2) {
        this.aKp = 0;
        this.aKq = 0;
        this.aKp = i;
        this.aKq = i2;
    }

    public void setType(String str) {
        this.type = str;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        super.run();
        com.baidu.tbadk.core.util.ab abVar = new com.baidu.tbadk.core.util.ab(String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.LOAD_REG_PV_ADDRESS);
        abVar.n("img_num", String.valueOf(this.aKp));
        abVar.n("img_total", String.valueOf(this.aKq));
        if (this.type != null) {
            abVar.n("img_type", this.type);
        }
        abVar.uy();
    }
}
