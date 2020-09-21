package com.baidu.tieba.group;

import com.baidu.live.tbadk.core.sharedpref.SharedPrefConfig;
import com.baidu.tbadk.TbadkSettings;
/* loaded from: classes22.dex */
public class a {
    private static a iMC;
    private boolean iMB = false;

    public static a czg() {
        if (iMC == null) {
            synchronized (a.class) {
                if (iMC == null) {
                    iMC = new a();
                }
            }
        }
        return iMC;
    }

    private a() {
        initConfig();
    }

    private void initConfig() {
        this.iMB = TbadkSettings.getInst().loadBoolean(SharedPrefConfig.HAS_SHOWED_DEL_GA_TIP, false);
    }

    public boolean czh() {
        return this.iMB;
    }

    public void pF(boolean z) {
        this.iMB = z;
        TbadkSettings.getInst().saveBoolean(SharedPrefConfig.HAS_SHOWED_DEL_GA_TIP, z);
    }
}
