package com.baidu.tieba.group;

import com.baidu.tbadk.TbadkSettings;
/* loaded from: classes3.dex */
public class a {
    private static a eeL;
    private boolean eeK = false;

    public static a aBS() {
        if (eeL == null) {
            synchronized (a.class) {
                if (eeL == null) {
                    eeL = new a();
                }
            }
        }
        return eeL;
    }

    private a() {
        initConfig();
    }

    private void initConfig() {
        this.eeK = TbadkSettings.getInst().loadBoolean("has_showed_del_ga_tip", false);
    }

    public boolean aBT() {
        return this.eeK;
    }

    public void gM(boolean z) {
        this.eeK = z;
        TbadkSettings.getInst().saveBoolean("has_showed_del_ga_tip", z);
    }
}
