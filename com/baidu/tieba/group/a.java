package com.baidu.tieba.group;

import com.baidu.live.tbadk.core.sharedpref.SharedPrefConfig;
import com.baidu.tbadk.TbadkSettings;
/* loaded from: classes22.dex */
public class a {
    private static a jut;
    private boolean jus = false;

    public static a cHR() {
        if (jut == null) {
            synchronized (a.class) {
                if (jut == null) {
                    jut = new a();
                }
            }
        }
        return jut;
    }

    private a() {
        initConfig();
    }

    private void initConfig() {
        this.jus = TbadkSettings.getInst().loadBoolean(SharedPrefConfig.HAS_SHOWED_DEL_GA_TIP, false);
    }

    public boolean cHS() {
        return this.jus;
    }

    public void qO(boolean z) {
        this.jus = z;
        TbadkSettings.getInst().saveBoolean(SharedPrefConfig.HAS_SHOWED_DEL_GA_TIP, z);
    }
}
