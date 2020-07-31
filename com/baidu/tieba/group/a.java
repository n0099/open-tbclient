package com.baidu.tieba.group;

import com.baidu.live.tbadk.core.sharedpref.SharedPrefConfig;
import com.baidu.tbadk.TbadkSettings;
/* loaded from: classes17.dex */
public class a {
    private static a iqK;
    private boolean iqJ = false;

    public static a cld() {
        if (iqK == null) {
            synchronized (a.class) {
                if (iqK == null) {
                    iqK = new a();
                }
            }
        }
        return iqK;
    }

    private a() {
        initConfig();
    }

    private void initConfig() {
        this.iqJ = TbadkSettings.getInst().loadBoolean(SharedPrefConfig.HAS_SHOWED_DEL_GA_TIP, false);
    }

    public boolean cle() {
        return this.iqJ;
    }

    public void oS(boolean z) {
        this.iqJ = z;
        TbadkSettings.getInst().saveBoolean(SharedPrefConfig.HAS_SHOWED_DEL_GA_TIP, z);
    }
}
