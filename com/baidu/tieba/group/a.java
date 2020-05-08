package com.baidu.tieba.group;

import com.baidu.live.tbadk.core.sharedpref.SharedPrefConfig;
import com.baidu.tbadk.TbadkSettings;
/* loaded from: classes10.dex */
public class a {
    private static a hGN;
    private boolean hGM = false;

    public static a bXz() {
        if (hGN == null) {
            synchronized (a.class) {
                if (hGN == null) {
                    hGN = new a();
                }
            }
        }
        return hGN;
    }

    private a() {
        initConfig();
    }

    private void initConfig() {
        this.hGM = TbadkSettings.getInst().loadBoolean(SharedPrefConfig.HAS_SHOWED_DEL_GA_TIP, false);
    }

    public boolean bXA() {
        return this.hGM;
    }

    public void nG(boolean z) {
        this.hGM = z;
        TbadkSettings.getInst().saveBoolean(SharedPrefConfig.HAS_SHOWED_DEL_GA_TIP, z);
    }
}
