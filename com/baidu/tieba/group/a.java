package com.baidu.tieba.group;

import com.baidu.tbadk.TbadkSettings;
/* loaded from: classes3.dex */
public class a {
    private static a egP;
    private boolean egO = false;

    public static a aIw() {
        if (egP == null) {
            synchronized (a.class) {
                if (egP == null) {
                    egP = new a();
                }
            }
        }
        return egP;
    }

    private a() {
        initConfig();
    }

    private void initConfig() {
        this.egO = TbadkSettings.getInst().loadBoolean("has_showed_del_ga_tip", false);
    }

    public boolean aIx() {
        return this.egO;
    }

    public void hv(boolean z) {
        this.egO = z;
        TbadkSettings.getInst().saveBoolean("has_showed_del_ga_tip", z);
    }
}
