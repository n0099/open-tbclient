package com.baidu.tieba.group;

import com.baidu.tbadk.TbadkSettings;
/* loaded from: classes3.dex */
public class a {
    private static a dzr;
    private boolean dzq = false;

    public static a awO() {
        if (dzr == null) {
            synchronized (a.class) {
                if (dzr == null) {
                    dzr = new a();
                }
            }
        }
        return dzr;
    }

    private a() {
        initConfig();
    }

    private void initConfig() {
        this.dzq = TbadkSettings.getInst().loadBoolean("has_showed_del_ga_tip", false);
    }

    public boolean awP() {
        return this.dzq;
    }

    public void gm(boolean z) {
        this.dzq = z;
        TbadkSettings.getInst().saveBoolean("has_showed_del_ga_tip", z);
    }
}
