package com.baidu.tieba.group;

import com.baidu.live.tbadk.core.sharedpref.SharedPrefConfig;
import com.baidu.tbadk.TbadkSettings;
/* loaded from: classes23.dex */
public class a {
    private static a jtM;
    private boolean jtL = false;

    public static a cIm() {
        if (jtM == null) {
            synchronized (a.class) {
                if (jtM == null) {
                    jtM = new a();
                }
            }
        }
        return jtM;
    }

    private a() {
        initConfig();
    }

    private void initConfig() {
        this.jtL = TbadkSettings.getInst().loadBoolean(SharedPrefConfig.HAS_SHOWED_DEL_GA_TIP, false);
    }

    public boolean cIn() {
        return this.jtL;
    }

    public void qL(boolean z) {
        this.jtL = z;
        TbadkSettings.getInst().saveBoolean(SharedPrefConfig.HAS_SHOWED_DEL_GA_TIP, z);
    }
}
