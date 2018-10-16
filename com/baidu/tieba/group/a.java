package com.baidu.tieba.group;

import com.baidu.tbadk.TbadkSettings;
/* loaded from: classes3.dex */
public class a {
    private static a egO;
    private boolean egN = false;

    public static a aIw() {
        if (egO == null) {
            synchronized (a.class) {
                if (egO == null) {
                    egO = new a();
                }
            }
        }
        return egO;
    }

    private a() {
        initConfig();
    }

    private void initConfig() {
        this.egN = TbadkSettings.getInst().loadBoolean("has_showed_del_ga_tip", false);
    }

    public boolean aIx() {
        return this.egN;
    }

    public void hv(boolean z) {
        this.egN = z;
        TbadkSettings.getInst().saveBoolean("has_showed_del_ga_tip", z);
    }
}
