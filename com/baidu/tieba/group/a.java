package com.baidu.tieba.group;

import com.baidu.live.tbadk.core.sharedpref.SharedPrefConfig;
import com.baidu.tbadk.TbadkSettings;
/* loaded from: classes23.dex */
public class a {
    private static a jbu;
    private boolean jbt = false;

    public static a cCE() {
        if (jbu == null) {
            synchronized (a.class) {
                if (jbu == null) {
                    jbu = new a();
                }
            }
        }
        return jbu;
    }

    private a() {
        initConfig();
    }

    private void initConfig() {
        this.jbt = TbadkSettings.getInst().loadBoolean(SharedPrefConfig.HAS_SHOWED_DEL_GA_TIP, false);
    }

    public boolean cCF() {
        return this.jbt;
    }

    public void qk(boolean z) {
        this.jbt = z;
        TbadkSettings.getInst().saveBoolean(SharedPrefConfig.HAS_SHOWED_DEL_GA_TIP, z);
    }
}
