package com.baidu.tieba.group;

import com.baidu.tbadk.TbadkSettings;
/* loaded from: classes5.dex */
public class a {
    private static a fVM;
    private boolean fVL = false;

    public static a bsB() {
        if (fVM == null) {
            synchronized (a.class) {
                if (fVM == null) {
                    fVM = new a();
                }
            }
        }
        return fVM;
    }

    private a() {
        initConfig();
    }

    private void initConfig() {
        this.fVL = TbadkSettings.getInst().loadBoolean("has_showed_del_ga_tip", false);
    }

    public boolean bsC() {
        return this.fVL;
    }

    public void kU(boolean z) {
        this.fVL = z;
        TbadkSettings.getInst().saveBoolean("has_showed_del_ga_tip", z);
    }
}
