package com.baidu.tbadk.util;

import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.util.ac;
/* loaded from: classes.dex */
public class h extends Thread {
    private int ZL;
    private int ZM;
    private String type = null;

    public h(int i, int i2) {
        this.ZL = 0;
        this.ZM = 0;
        this.ZL = i;
        this.ZM = i2;
    }

    public void setType(String str) {
        this.type = str;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        super.run();
        ac acVar = new ac(String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.LOAD_REG_PV_ADDRESS);
        acVar.k("img_num", String.valueOf(this.ZL));
        acVar.k("img_total", String.valueOf(this.ZM));
        if (this.type != null) {
            acVar.k("img_type", this.type);
        }
        acVar.lA();
    }
}
