package com.baidu.tieba.group;

import com.baidu.live.tbadk.core.sharedpref.SharedPrefConfig;
import com.baidu.tbadk.TbadkSettings;
/* loaded from: classes10.dex */
public class a {
    private static a ikH;
    private boolean ikG = false;

    public static a chD() {
        if (ikH == null) {
            synchronized (a.class) {
                if (ikH == null) {
                    ikH = new a();
                }
            }
        }
        return ikH;
    }

    private a() {
        initConfig();
    }

    private void initConfig() {
        this.ikG = TbadkSettings.getInst().loadBoolean(SharedPrefConfig.HAS_SHOWED_DEL_GA_TIP, false);
    }

    public boolean chE() {
        return this.ikG;
    }

    public void on(boolean z) {
        this.ikG = z;
        TbadkSettings.getInst().saveBoolean(SharedPrefConfig.HAS_SHOWED_DEL_GA_TIP, z);
    }
}
