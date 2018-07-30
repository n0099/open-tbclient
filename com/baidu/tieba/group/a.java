package com.baidu.tieba.group;

import com.baidu.tbadk.TbadkSettings;
/* loaded from: classes3.dex */
public class a {
    private static a dRJ;
    private boolean dRI = false;

    public static a aCU() {
        if (dRJ == null) {
            synchronized (a.class) {
                if (dRJ == null) {
                    dRJ = new a();
                }
            }
        }
        return dRJ;
    }

    private a() {
        initConfig();
    }

    private void initConfig() {
        this.dRI = TbadkSettings.getInst().loadBoolean("has_showed_del_ga_tip", false);
    }

    public boolean aCV() {
        return this.dRI;
    }

    public void gF(boolean z) {
        this.dRI = z;
        TbadkSettings.getInst().saveBoolean("has_showed_del_ga_tip", z);
    }
}
