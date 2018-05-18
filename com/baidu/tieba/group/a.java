package com.baidu.tieba.group;

import com.baidu.tbadk.TbadkSettings;
/* loaded from: classes3.dex */
public class a {
    private static a dAv;
    private boolean dAu = false;

    public static a awN() {
        if (dAv == null) {
            synchronized (a.class) {
                if (dAv == null) {
                    dAv = new a();
                }
            }
        }
        return dAv;
    }

    private a() {
        initConfig();
    }

    private void initConfig() {
        this.dAu = TbadkSettings.getInst().loadBoolean("has_showed_del_ga_tip", false);
    }

    public boolean awO() {
        return this.dAu;
    }

    public void gn(boolean z) {
        this.dAu = z;
        TbadkSettings.getInst().saveBoolean("has_showed_del_ga_tip", z);
    }
}
