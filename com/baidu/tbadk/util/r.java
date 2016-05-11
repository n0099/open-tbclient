package com.baidu.tbadk.util;

import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.util.ab;
/* loaded from: classes.dex */
public class r extends Thread {
    private int aAj;
    private int aAk;
    private String type = null;

    public r(int i, int i2) {
        this.aAj = 0;
        this.aAk = 0;
        this.aAj = i;
        this.aAk = i2;
    }

    public void setType(String str) {
        this.type = str;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        super.run();
        ab abVar = new ab(String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.LOAD_REG_PV_ADDRESS);
        abVar.n("img_num", String.valueOf(this.aAj));
        abVar.n("img_total", String.valueOf(this.aAk));
        if (this.type != null) {
            abVar.n("img_type", this.type);
        }
        abVar.tc();
    }
}
