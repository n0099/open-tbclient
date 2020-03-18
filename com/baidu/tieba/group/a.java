package com.baidu.tieba.group;

import com.baidu.live.tbadk.core.sharedpref.SharedPrefConfig;
import com.baidu.tbadk.TbadkSettings;
/* loaded from: classes10.dex */
public class a {
    private static a gWQ;
    private boolean gWP = false;

    public static a bNa() {
        if (gWQ == null) {
            synchronized (a.class) {
                if (gWQ == null) {
                    gWQ = new a();
                }
            }
        }
        return gWQ;
    }

    private a() {
        initConfig();
    }

    private void initConfig() {
        this.gWP = TbadkSettings.getInst().loadBoolean(SharedPrefConfig.HAS_SHOWED_DEL_GA_TIP, false);
    }

    public boolean bNb() {
        return this.gWP;
    }

    public void mC(boolean z) {
        this.gWP = z;
        TbadkSettings.getInst().saveBoolean(SharedPrefConfig.HAS_SHOWED_DEL_GA_TIP, z);
    }
}
