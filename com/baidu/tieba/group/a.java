package com.baidu.tieba.group;

import com.baidu.tbadk.TbadkSettings;
/* loaded from: classes3.dex */
public class a {
    private static a epd;
    private boolean epc = false;

    public static a aJL() {
        if (epd == null) {
            synchronized (a.class) {
                if (epd == null) {
                    epd = new a();
                }
            }
        }
        return epd;
    }

    private a() {
        initConfig();
    }

    private void initConfig() {
        this.epc = TbadkSettings.getInst().loadBoolean("has_showed_del_ga_tip", false);
    }

    public boolean aJM() {
        return this.epc;
    }

    public void hH(boolean z) {
        this.epc = z;
        TbadkSettings.getInst().saveBoolean("has_showed_del_ga_tip", z);
    }
}
