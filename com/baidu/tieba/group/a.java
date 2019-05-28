package com.baidu.tieba.group;

import com.baidu.tbadk.TbadkSettings;
/* loaded from: classes5.dex */
public class a {
    private static a fVK;
    private boolean fVJ = false;

    public static a bsz() {
        if (fVK == null) {
            synchronized (a.class) {
                if (fVK == null) {
                    fVK = new a();
                }
            }
        }
        return fVK;
    }

    private a() {
        initConfig();
    }

    private void initConfig() {
        this.fVJ = TbadkSettings.getInst().loadBoolean("has_showed_del_ga_tip", false);
    }

    public boolean bsA() {
        return this.fVJ;
    }

    public void kT(boolean z) {
        this.fVJ = z;
        TbadkSettings.getInst().saveBoolean("has_showed_del_ga_tip", z);
    }
}
