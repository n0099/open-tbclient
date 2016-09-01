package com.baidu.tbadk.util;

import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.util.ab;
/* loaded from: classes.dex */
public class r extends Thread {
    private int aEY;
    private int aEZ;
    private String type = null;

    public r(int i, int i2) {
        this.aEY = 0;
        this.aEZ = 0;
        this.aEY = i;
        this.aEZ = i2;
    }

    public void setType(String str) {
        this.type = str;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        super.run();
        ab abVar = new ab(String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.LOAD_REG_PV_ADDRESS);
        abVar.n("img_num", String.valueOf(this.aEY));
        abVar.n("img_total", String.valueOf(this.aEZ));
        if (this.type != null) {
            abVar.n("img_type", this.type);
        }
        abVar.ue();
    }
}
