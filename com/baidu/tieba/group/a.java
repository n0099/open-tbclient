package com.baidu.tieba.group;

import com.baidu.live.tbadk.core.sharedpref.SharedPrefConfig;
import com.baidu.tbadk.TbadkSettings;
/* loaded from: classes23.dex */
public class a {
    private static a jHV;
    private boolean jHU = false;

    public static a cNg() {
        if (jHV == null) {
            synchronized (a.class) {
                if (jHV == null) {
                    jHV = new a();
                }
            }
        }
        return jHV;
    }

    private a() {
        initConfig();
    }

    private void initConfig() {
        this.jHU = TbadkSettings.getInst().loadBoolean(SharedPrefConfig.HAS_SHOWED_DEL_GA_TIP, false);
    }

    public boolean cNh() {
        return this.jHU;
    }

    public void rp(boolean z) {
        this.jHU = z;
        TbadkSettings.getInst().saveBoolean(SharedPrefConfig.HAS_SHOWED_DEL_GA_TIP, z);
    }
}
