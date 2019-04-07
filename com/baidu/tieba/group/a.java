package com.baidu.tieba.group;

import com.baidu.tbadk.TbadkSettings;
/* loaded from: classes5.dex */
public class a {
    private static a fEM;
    private boolean fEL = false;

    public static a blc() {
        if (fEM == null) {
            synchronized (a.class) {
                if (fEM == null) {
                    fEM = new a();
                }
            }
        }
        return fEM;
    }

    private a() {
        initConfig();
    }

    private void initConfig() {
        this.fEL = TbadkSettings.getInst().loadBoolean("has_showed_del_ga_tip", false);
    }

    public boolean bld() {
        return this.fEL;
    }

    public void ke(boolean z) {
        this.fEL = z;
        TbadkSettings.getInst().saveBoolean("has_showed_del_ga_tip", z);
    }
}
