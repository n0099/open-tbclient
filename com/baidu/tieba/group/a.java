package com.baidu.tieba.group;

import com.baidu.live.tbadk.core.sharedpref.SharedPrefConfig;
import com.baidu.tbadk.TbadkSettings;
/* loaded from: classes7.dex */
public class a {
    private static a gQb;
    private boolean gQa = false;

    public static a bKb() {
        if (gQb == null) {
            synchronized (a.class) {
                if (gQb == null) {
                    gQb = new a();
                }
            }
        }
        return gQb;
    }

    private a() {
        initConfig();
    }

    private void initConfig() {
        this.gQa = TbadkSettings.getInst().loadBoolean(SharedPrefConfig.HAS_SHOWED_DEL_GA_TIP, false);
    }

    public boolean bKc() {
        return this.gQa;
    }

    public void mj(boolean z) {
        this.gQa = z;
        TbadkSettings.getInst().saveBoolean(SharedPrefConfig.HAS_SHOWED_DEL_GA_TIP, z);
    }
}
