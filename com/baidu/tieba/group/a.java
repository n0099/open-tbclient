package com.baidu.tieba.group;

import com.baidu.tbadk.TbadkSettings;
/* loaded from: classes3.dex */
public class a {
    private static a dzo;
    private boolean dzn = false;

    public static a awO() {
        if (dzo == null) {
            synchronized (a.class) {
                if (dzo == null) {
                    dzo = new a();
                }
            }
        }
        return dzo;
    }

    private a() {
        initConfig();
    }

    private void initConfig() {
        this.dzn = TbadkSettings.getInst().loadBoolean("has_showed_del_ga_tip", false);
    }

    public boolean awP() {
        return this.dzn;
    }

    public void gm(boolean z) {
        this.dzn = z;
        TbadkSettings.getInst().saveBoolean("has_showed_del_ga_tip", z);
    }
}
