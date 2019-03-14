package com.baidu.tieba.group;

import com.baidu.tbadk.TbadkSettings;
/* loaded from: classes5.dex */
public class a {
    private static a fEY;
    private boolean fEX = false;

    public static a blf() {
        if (fEY == null) {
            synchronized (a.class) {
                if (fEY == null) {
                    fEY = new a();
                }
            }
        }
        return fEY;
    }

    private a() {
        initConfig();
    }

    private void initConfig() {
        this.fEX = TbadkSettings.getInst().loadBoolean("has_showed_del_ga_tip", false);
    }

    public boolean blg() {
        return this.fEX;
    }

    public void ke(boolean z) {
        this.fEX = z;
        TbadkSettings.getInst().saveBoolean("has_showed_del_ga_tip", z);
    }
}
