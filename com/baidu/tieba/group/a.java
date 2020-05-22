package com.baidu.tieba.group;

import com.baidu.live.tbadk.core.sharedpref.SharedPrefConfig;
import com.baidu.tbadk.TbadkSettings;
/* loaded from: classes10.dex */
public class a {
    private static a hVz;
    private boolean hVy = false;

    public static a cdY() {
        if (hVz == null) {
            synchronized (a.class) {
                if (hVz == null) {
                    hVz = new a();
                }
            }
        }
        return hVz;
    }

    private a() {
        initConfig();
    }

    private void initConfig() {
        this.hVy = TbadkSettings.getInst().loadBoolean(SharedPrefConfig.HAS_SHOWED_DEL_GA_TIP, false);
    }

    public boolean cdZ() {
        return this.hVy;
    }

    public void ob(boolean z) {
        this.hVy = z;
        TbadkSettings.getInst().saveBoolean(SharedPrefConfig.HAS_SHOWED_DEL_GA_TIP, z);
    }
}
