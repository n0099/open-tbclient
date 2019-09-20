package com.baidu.tieba.group;

import com.baidu.tbadk.TbadkSettings;
/* loaded from: classes5.dex */
public class a {
    private static a gdq;
    private boolean gdp = false;

    public static a bvD() {
        if (gdq == null) {
            synchronized (a.class) {
                if (gdq == null) {
                    gdq = new a();
                }
            }
        }
        return gdq;
    }

    private a() {
        initConfig();
    }

    private void initConfig() {
        this.gdp = TbadkSettings.getInst().loadBoolean("has_showed_del_ga_tip", false);
    }

    public boolean bvE() {
        return this.gdp;
    }

    public void lh(boolean z) {
        this.gdp = z;
        TbadkSettings.getInst().saveBoolean("has_showed_del_ga_tip", z);
    }
}
