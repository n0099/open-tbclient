package com.baidu.tieba.group;

import com.baidu.tbadk.TbadkSettings;
/* loaded from: classes3.dex */
public class a {
    private static a erU;
    private boolean erT = false;

    public static a aKA() {
        if (erU == null) {
            synchronized (a.class) {
                if (erU == null) {
                    erU = new a();
                }
            }
        }
        return erU;
    }

    private a() {
        initConfig();
    }

    private void initConfig() {
        this.erT = TbadkSettings.getInst().loadBoolean("has_showed_del_ga_tip", false);
    }

    public boolean aKB() {
        return this.erT;
    }

    public void hK(boolean z) {
        this.erT = z;
        TbadkSettings.getInst().saveBoolean("has_showed_del_ga_tip", z);
    }
}
