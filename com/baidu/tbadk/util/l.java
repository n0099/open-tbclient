package com.baidu.tbadk.util;

import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.util.ab;
/* loaded from: classes.dex */
public class l extends Thread {
    private int aAE;
    private int aAF;
    private String type = null;

    public l(int i, int i2) {
        this.aAE = 0;
        this.aAF = 0;
        this.aAE = i;
        this.aAF = i2;
    }

    public void setType(String str) {
        this.type = str;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        super.run();
        ab abVar = new ab(String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.LOAD_REG_PV_ADDRESS);
        abVar.o("img_num", String.valueOf(this.aAE));
        abVar.o("img_total", String.valueOf(this.aAF));
        if (this.type != null) {
            abVar.o("img_type", this.type);
        }
        abVar.ul();
    }
}
