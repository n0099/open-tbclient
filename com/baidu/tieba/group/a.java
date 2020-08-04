package com.baidu.tieba.group;

import com.baidu.live.tbadk.core.sharedpref.SharedPrefConfig;
import com.baidu.tbadk.TbadkSettings;
/* loaded from: classes17.dex */
public class a {
    private static a iqM;
    private boolean iqL = false;

    public static a cld() {
        if (iqM == null) {
            synchronized (a.class) {
                if (iqM == null) {
                    iqM = new a();
                }
            }
        }
        return iqM;
    }

    private a() {
        initConfig();
    }

    private void initConfig() {
        this.iqL = TbadkSettings.getInst().loadBoolean(SharedPrefConfig.HAS_SHOWED_DEL_GA_TIP, false);
    }

    public boolean cle() {
        return this.iqL;
    }

    public void oS(boolean z) {
        this.iqL = z;
        TbadkSettings.getInst().saveBoolean(SharedPrefConfig.HAS_SHOWED_DEL_GA_TIP, z);
    }
}
