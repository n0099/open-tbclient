package com.baidu.tieba.group;

import com.baidu.live.tbadk.core.sharedpref.SharedPrefConfig;
import com.baidu.tbadk.TbadkSettings;
/* loaded from: classes5.dex */
public class a {
    private static a gbX;
    private boolean gbW = false;

    public static a bsG() {
        if (gbX == null) {
            synchronized (a.class) {
                if (gbX == null) {
                    gbX = new a();
                }
            }
        }
        return gbX;
    }

    private a() {
        initConfig();
    }

    private void initConfig() {
        this.gbW = TbadkSettings.getInst().loadBoolean(SharedPrefConfig.HAS_SHOWED_DEL_GA_TIP, false);
    }

    public boolean bsH() {
        return this.gbW;
    }

    public void kV(boolean z) {
        this.gbW = z;
        TbadkSettings.getInst().saveBoolean(SharedPrefConfig.HAS_SHOWED_DEL_GA_TIP, z);
    }
}
