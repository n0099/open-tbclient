package com.baidu.tieba.group;

import com.baidu.live.tbadk.core.sharedpref.SharedPrefConfig;
import com.baidu.tbadk.TbadkSettings;
/* loaded from: classes8.dex */
public class a {
    private static a gTv;
    private boolean gTu = false;

    public static a bLg() {
        if (gTv == null) {
            synchronized (a.class) {
                if (gTv == null) {
                    gTv = new a();
                }
            }
        }
        return gTv;
    }

    private a() {
        initConfig();
    }

    private void initConfig() {
        this.gTu = TbadkSettings.getInst().loadBoolean(SharedPrefConfig.HAS_SHOWED_DEL_GA_TIP, false);
    }

    public boolean bLh() {
        return this.gTu;
    }

    public void mu(boolean z) {
        this.gTu = z;
        TbadkSettings.getInst().saveBoolean(SharedPrefConfig.HAS_SHOWED_DEL_GA_TIP, z);
    }
}
