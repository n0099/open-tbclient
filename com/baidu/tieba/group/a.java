package com.baidu.tieba.group;

import com.baidu.live.tbadk.core.sharedpref.SharedPrefConfig;
import com.baidu.tbadk.TbadkSettings;
/* loaded from: classes5.dex */
public class a {
    private static a gcO;
    private boolean gcN = false;

    public static a bsI() {
        if (gcO == null) {
            synchronized (a.class) {
                if (gcO == null) {
                    gcO = new a();
                }
            }
        }
        return gcO;
    }

    private a() {
        initConfig();
    }

    private void initConfig() {
        this.gcN = TbadkSettings.getInst().loadBoolean(SharedPrefConfig.HAS_SHOWED_DEL_GA_TIP, false);
    }

    public boolean bsJ() {
        return this.gcN;
    }

    public void kV(boolean z) {
        this.gcN = z;
        TbadkSettings.getInst().saveBoolean(SharedPrefConfig.HAS_SHOWED_DEL_GA_TIP, z);
    }
}
