package com.baidu.tbadk.util;

import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.util.ab;
/* loaded from: classes.dex */
public class r extends Thread {
    private int aBb;
    private int aBc;
    private String type = null;

    public r(int i, int i2) {
        this.aBb = 0;
        this.aBc = 0;
        this.aBb = i;
        this.aBc = i2;
    }

    public void setType(String str) {
        this.type = str;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        super.run();
        ab abVar = new ab(String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.LOAD_REG_PV_ADDRESS);
        abVar.n("img_num", String.valueOf(this.aBb));
        abVar.n("img_total", String.valueOf(this.aBc));
        if (this.type != null) {
            abVar.n("img_type", this.type);
        }
        abVar.ta();
    }
}
