package com.baidu.tieba.group;

import com.baidu.tbadk.TbadkSettings;
/* loaded from: classes5.dex */
public class a {
    private static a gbz;
    private boolean gby = false;

    public static a buP() {
        if (gbz == null) {
            synchronized (a.class) {
                if (gbz == null) {
                    gbz = new a();
                }
            }
        }
        return gbz;
    }

    private a() {
        initConfig();
    }

    private void initConfig() {
        this.gby = TbadkSettings.getInst().loadBoolean("has_showed_del_ga_tip", false);
    }

    public boolean buQ() {
        return this.gby;
    }

    public void le(boolean z) {
        this.gby = z;
        TbadkSettings.getInst().saveBoolean("has_showed_del_ga_tip", z);
    }
}
