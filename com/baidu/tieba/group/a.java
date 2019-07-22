package com.baidu.tieba.group;

import com.baidu.tbadk.TbadkSettings;
/* loaded from: classes5.dex */
public class a {
    private static a gaJ;
    private boolean gaI = false;

    public static a buC() {
        if (gaJ == null) {
            synchronized (a.class) {
                if (gaJ == null) {
                    gaJ = new a();
                }
            }
        }
        return gaJ;
    }

    private a() {
        initConfig();
    }

    private void initConfig() {
        this.gaI = TbadkSettings.getInst().loadBoolean("has_showed_del_ga_tip", false);
    }

    public boolean buD() {
        return this.gaI;
    }

    public void le(boolean z) {
        this.gaI = z;
        TbadkSettings.getInst().saveBoolean("has_showed_del_ga_tip", z);
    }
}
