package com.baidu.tieba.group;

import com.baidu.live.tbadk.core.sharedpref.SharedPrefConfig;
import com.baidu.tbadk.TbadkSettings;
/* loaded from: classes10.dex */
public class a {
    private static a gVJ;
    private boolean gVI = false;

    public static a bMM() {
        if (gVJ == null) {
            synchronized (a.class) {
                if (gVJ == null) {
                    gVJ = new a();
                }
            }
        }
        return gVJ;
    }

    private a() {
        initConfig();
    }

    private void initConfig() {
        this.gVI = TbadkSettings.getInst().loadBoolean(SharedPrefConfig.HAS_SHOWED_DEL_GA_TIP, false);
    }

    public boolean bMN() {
        return this.gVI;
    }

    public void mw(boolean z) {
        this.gVI = z;
        TbadkSettings.getInst().saveBoolean(SharedPrefConfig.HAS_SHOWED_DEL_GA_TIP, z);
    }
}
