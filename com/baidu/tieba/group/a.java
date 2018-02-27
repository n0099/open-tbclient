package com.baidu.tieba.group;

import com.baidu.tbadk.TbadkSettings;
/* loaded from: classes3.dex */
public class a {
    private static a eev;
    private boolean eeu = false;

    public static a aBR() {
        if (eev == null) {
            synchronized (a.class) {
                if (eev == null) {
                    eev = new a();
                }
            }
        }
        return eev;
    }

    private a() {
        initConfig();
    }

    private void initConfig() {
        this.eeu = TbadkSettings.getInst().loadBoolean("has_showed_del_ga_tip", false);
    }

    public boolean aBS() {
        return this.eeu;
    }

    public void gH(boolean z) {
        this.eeu = z;
        TbadkSettings.getInst().saveBoolean("has_showed_del_ga_tip", z);
    }
}
