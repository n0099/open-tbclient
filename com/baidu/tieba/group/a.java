package com.baidu.tieba.group;

import com.baidu.tbadk.TbadkSettings;
/* loaded from: classes3.dex */
public class a {
    private static a dLF;
    private boolean dLE = false;

    public static a aBF() {
        if (dLF == null) {
            synchronized (a.class) {
                if (dLF == null) {
                    dLF = new a();
                }
            }
        }
        return dLF;
    }

    private a() {
        initConfig();
    }

    private void initConfig() {
        this.dLE = TbadkSettings.getInst().loadBoolean("has_showed_del_ga_tip", false);
    }

    public boolean aBG() {
        return this.dLE;
    }

    public void gt(boolean z) {
        this.dLE = z;
        TbadkSettings.getInst().saveBoolean("has_showed_del_ga_tip", z);
    }
}
