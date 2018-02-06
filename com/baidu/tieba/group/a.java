package com.baidu.tieba.group;

import com.baidu.tbadk.TbadkSettings;
/* loaded from: classes3.dex */
public class a {
    private static a eeH;
    private boolean eeG = false;

    public static a aBS() {
        if (eeH == null) {
            synchronized (a.class) {
                if (eeH == null) {
                    eeH = new a();
                }
            }
        }
        return eeH;
    }

    private a() {
        initConfig();
    }

    private void initConfig() {
        this.eeG = TbadkSettings.getInst().loadBoolean("has_showed_del_ga_tip", false);
    }

    public boolean aBT() {
        return this.eeG;
    }

    public void gH(boolean z) {
        this.eeG = z;
        TbadkSettings.getInst().saveBoolean("has_showed_del_ga_tip", z);
    }
}
