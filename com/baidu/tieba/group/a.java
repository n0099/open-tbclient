package com.baidu.tieba.group;

import com.baidu.live.tbadk.core.sharedpref.SharedPrefConfig;
import com.baidu.tbadk.TbadkSettings;
/* loaded from: classes23.dex */
public class a {
    private static a jHT;
    private boolean jHS = false;

    public static a cNf() {
        if (jHT == null) {
            synchronized (a.class) {
                if (jHT == null) {
                    jHT = new a();
                }
            }
        }
        return jHT;
    }

    private a() {
        initConfig();
    }

    private void initConfig() {
        this.jHS = TbadkSettings.getInst().loadBoolean(SharedPrefConfig.HAS_SHOWED_DEL_GA_TIP, false);
    }

    public boolean cNg() {
        return this.jHS;
    }

    public void rp(boolean z) {
        this.jHS = z;
        TbadkSettings.getInst().saveBoolean(SharedPrefConfig.HAS_SHOWED_DEL_GA_TIP, z);
    }
}
