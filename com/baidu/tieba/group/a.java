package com.baidu.tieba.group;

import com.baidu.live.tbadk.core.sharedpref.SharedPrefConfig;
import com.baidu.tbadk.TbadkSettings;
/* loaded from: classes10.dex */
public class a {
    private static a hGH;
    private boolean hGG = false;

    public static a bXB() {
        if (hGH == null) {
            synchronized (a.class) {
                if (hGH == null) {
                    hGH = new a();
                }
            }
        }
        return hGH;
    }

    private a() {
        initConfig();
    }

    private void initConfig() {
        this.hGG = TbadkSettings.getInst().loadBoolean(SharedPrefConfig.HAS_SHOWED_DEL_GA_TIP, false);
    }

    public boolean bXC() {
        return this.hGG;
    }

    public void nG(boolean z) {
        this.hGG = z;
        TbadkSettings.getInst().saveBoolean(SharedPrefConfig.HAS_SHOWED_DEL_GA_TIP, z);
    }
}
