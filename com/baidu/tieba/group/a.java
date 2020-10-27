package com.baidu.tieba.group;

import com.baidu.live.tbadk.core.sharedpref.SharedPrefConfig;
import com.baidu.tbadk.TbadkSettings;
/* loaded from: classes23.dex */
public class a {
    private static a jnP;
    private boolean jnO = false;

    public static a cFL() {
        if (jnP == null) {
            synchronized (a.class) {
                if (jnP == null) {
                    jnP = new a();
                }
            }
        }
        return jnP;
    }

    private a() {
        initConfig();
    }

    private void initConfig() {
        this.jnO = TbadkSettings.getInst().loadBoolean(SharedPrefConfig.HAS_SHOWED_DEL_GA_TIP, false);
    }

    public boolean cFM() {
        return this.jnO;
    }

    public void qC(boolean z) {
        this.jnO = z;
        TbadkSettings.getInst().saveBoolean(SharedPrefConfig.HAS_SHOWED_DEL_GA_TIP, z);
    }
}
