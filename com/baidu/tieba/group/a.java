package com.baidu.tieba.group;

import com.baidu.live.tbadk.core.sharedpref.SharedPrefConfig;
import com.baidu.tbadk.TbadkSettings;
/* loaded from: classes10.dex */
public class a {
    private static a hWm;
    private boolean hWl = false;

    public static a ceg() {
        if (hWm == null) {
            synchronized (a.class) {
                if (hWm == null) {
                    hWm = new a();
                }
            }
        }
        return hWm;
    }

    private a() {
        initConfig();
    }

    private void initConfig() {
        this.hWl = TbadkSettings.getInst().loadBoolean(SharedPrefConfig.HAS_SHOWED_DEL_GA_TIP, false);
    }

    public boolean ceh() {
        return this.hWl;
    }

    public void ob(boolean z) {
        this.hWl = z;
        TbadkSettings.getInst().saveBoolean(SharedPrefConfig.HAS_SHOWED_DEL_GA_TIP, z);
    }
}
