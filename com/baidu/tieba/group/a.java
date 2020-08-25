package com.baidu.tieba.group;

import com.baidu.live.tbadk.core.sharedpref.SharedPrefConfig;
import com.baidu.tbadk.TbadkSettings;
/* loaded from: classes17.dex */
public class a {
    private static a iFb;
    private boolean iFa = false;

    public static a cvM() {
        if (iFb == null) {
            synchronized (a.class) {
                if (iFb == null) {
                    iFb = new a();
                }
            }
        }
        return iFb;
    }

    private a() {
        initConfig();
    }

    private void initConfig() {
        this.iFa = TbadkSettings.getInst().loadBoolean(SharedPrefConfig.HAS_SHOWED_DEL_GA_TIP, false);
    }

    public boolean cvN() {
        return this.iFa;
    }

    public void px(boolean z) {
        this.iFa = z;
        TbadkSettings.getInst().saveBoolean(SharedPrefConfig.HAS_SHOWED_DEL_GA_TIP, z);
    }
}
