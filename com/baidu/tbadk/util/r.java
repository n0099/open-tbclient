package com.baidu.tbadk.util;

import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.util.ab;
/* loaded from: classes.dex */
public class r extends Thread {
    private int aBR;
    private int aBS;
    private String type = null;

    public r(int i, int i2) {
        this.aBR = 0;
        this.aBS = 0;
        this.aBR = i;
        this.aBS = i2;
    }

    public void setType(String str) {
        this.type = str;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        super.run();
        ab abVar = new ab(String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.LOAD_REG_PV_ADDRESS);
        abVar.n("img_num", String.valueOf(this.aBR));
        abVar.n("img_total", String.valueOf(this.aBS));
        if (this.type != null) {
            abVar.n("img_type", this.type);
        }
        abVar.sZ();
    }
}
