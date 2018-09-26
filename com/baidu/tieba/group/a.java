package com.baidu.tieba.group;

import com.baidu.tbadk.TbadkSettings;
/* loaded from: classes3.dex */
public class a {
    private static a dYV;
    private boolean dYU = false;

    public static a aFe() {
        if (dYV == null) {
            synchronized (a.class) {
                if (dYV == null) {
                    dYV = new a();
                }
            }
        }
        return dYV;
    }

    private a() {
        initConfig();
    }

    private void initConfig() {
        this.dYU = TbadkSettings.getInst().loadBoolean("has_showed_del_ga_tip", false);
    }

    public boolean aFf() {
        return this.dYU;
    }

    public void hd(boolean z) {
        this.dYU = z;
        TbadkSettings.getInst().saveBoolean("has_showed_del_ga_tip", z);
    }
}
