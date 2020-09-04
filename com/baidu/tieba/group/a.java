package com.baidu.tieba.group;

import com.baidu.live.tbadk.core.sharedpref.SharedPrefConfig;
import com.baidu.tbadk.TbadkSettings;
/* loaded from: classes17.dex */
public class a {
    private static a iFh;
    private boolean iFg = false;

    public static a cvN() {
        if (iFh == null) {
            synchronized (a.class) {
                if (iFh == null) {
                    iFh = new a();
                }
            }
        }
        return iFh;
    }

    private a() {
        initConfig();
    }

    private void initConfig() {
        this.iFg = TbadkSettings.getInst().loadBoolean(SharedPrefConfig.HAS_SHOWED_DEL_GA_TIP, false);
    }

    public boolean cvO() {
        return this.iFg;
    }

    public void pz(boolean z) {
        this.iFg = z;
        TbadkSettings.getInst().saveBoolean(SharedPrefConfig.HAS_SHOWED_DEL_GA_TIP, z);
    }
}
