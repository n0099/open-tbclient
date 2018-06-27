package com.baidu.tieba.group;

import com.baidu.tbadk.TbadkSettings;
/* loaded from: classes3.dex */
public class a {
    private static a dOW;
    private boolean dOV = false;

    public static a aCl() {
        if (dOW == null) {
            synchronized (a.class) {
                if (dOW == null) {
                    dOW = new a();
                }
            }
        }
        return dOW;
    }

    private a() {
        initConfig();
    }

    private void initConfig() {
        this.dOV = TbadkSettings.getInst().loadBoolean("has_showed_del_ga_tip", false);
    }

    public boolean aCm() {
        return this.dOV;
    }

    public void gD(boolean z) {
        this.dOV = z;
        TbadkSettings.getInst().saveBoolean("has_showed_del_ga_tip", z);
    }
}
