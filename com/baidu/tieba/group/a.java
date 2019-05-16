package com.baidu.tieba.group;

import com.baidu.tbadk.TbadkSettings;
/* loaded from: classes5.dex */
public class a {
    private static a fVJ;
    private boolean fVI = false;

    public static a bsw() {
        if (fVJ == null) {
            synchronized (a.class) {
                if (fVJ == null) {
                    fVJ = new a();
                }
            }
        }
        return fVJ;
    }

    private a() {
        initConfig();
    }

    private void initConfig() {
        this.fVI = TbadkSettings.getInst().loadBoolean("has_showed_del_ga_tip", false);
    }

    public boolean bsx() {
        return this.fVI;
    }

    public void kT(boolean z) {
        this.fVI = z;
        TbadkSettings.getInst().saveBoolean("has_showed_del_ga_tip", z);
    }
}
