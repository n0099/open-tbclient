package com.baidu.tieba.group;

import com.baidu.live.tbadk.core.sharedpref.SharedPrefConfig;
import com.baidu.tbadk.TbadkSettings;
/* loaded from: classes10.dex */
public class a {
    private static a gVv;
    private boolean gVu = false;

    public static a bMJ() {
        if (gVv == null) {
            synchronized (a.class) {
                if (gVv == null) {
                    gVv = new a();
                }
            }
        }
        return gVv;
    }

    private a() {
        initConfig();
    }

    private void initConfig() {
        this.gVu = TbadkSettings.getInst().loadBoolean(SharedPrefConfig.HAS_SHOWED_DEL_GA_TIP, false);
    }

    public boolean bMK() {
        return this.gVu;
    }

    public void mw(boolean z) {
        this.gVu = z;
        TbadkSettings.getInst().saveBoolean(SharedPrefConfig.HAS_SHOWED_DEL_GA_TIP, z);
    }
}
