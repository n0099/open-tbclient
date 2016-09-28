package com.baidu.tbadk.util;

import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.util.ab;
/* loaded from: classes.dex */
public class r extends Thread {
    private int aEw;
    private int aEx;
    private String type = null;

    public r(int i, int i2) {
        this.aEw = 0;
        this.aEx = 0;
        this.aEw = i;
        this.aEx = i2;
    }

    public void setType(String str) {
        this.type = str;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        super.run();
        ab abVar = new ab(String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.LOAD_REG_PV_ADDRESS);
        abVar.n("img_num", String.valueOf(this.aEw));
        abVar.n("img_total", String.valueOf(this.aEx));
        if (this.type != null) {
            abVar.n("img_type", this.type);
        }
        abVar.uu();
    }
}
