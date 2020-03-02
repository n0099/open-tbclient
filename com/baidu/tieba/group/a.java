package com.baidu.tieba.group;

import com.baidu.live.tbadk.core.sharedpref.SharedPrefConfig;
import com.baidu.tbadk.TbadkSettings;
/* loaded from: classes10.dex */
public class a {
    private static a gVx;
    private boolean gVw = false;

    public static a bML() {
        if (gVx == null) {
            synchronized (a.class) {
                if (gVx == null) {
                    gVx = new a();
                }
            }
        }
        return gVx;
    }

    private a() {
        initConfig();
    }

    private void initConfig() {
        this.gVw = TbadkSettings.getInst().loadBoolean(SharedPrefConfig.HAS_SHOWED_DEL_GA_TIP, false);
    }

    public boolean bMM() {
        return this.gVw;
    }

    public void mw(boolean z) {
        this.gVw = z;
        TbadkSettings.getInst().saveBoolean(SharedPrefConfig.HAS_SHOWED_DEL_GA_TIP, z);
    }
}
