package com.baidu.tieba.group;

import com.baidu.tbadk.TbadkSettings;
/* loaded from: classes3.dex */
public class a {
    private static a dRE;
    private boolean dRD = false;

    public static a aCR() {
        if (dRE == null) {
            synchronized (a.class) {
                if (dRE == null) {
                    dRE = new a();
                }
            }
        }
        return dRE;
    }

    private a() {
        initConfig();
    }

    private void initConfig() {
        this.dRD = TbadkSettings.getInst().loadBoolean("has_showed_del_ga_tip", false);
    }

    public boolean aCS() {
        return this.dRD;
    }

    public void gF(boolean z) {
        this.dRD = z;
        TbadkSettings.getInst().saveBoolean("has_showed_del_ga_tip", z);
    }
}
