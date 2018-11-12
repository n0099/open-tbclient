package com.baidu.tieba.group;

import com.baidu.tbadk.TbadkSettings;
/* loaded from: classes3.dex */
public class a {
    private static a eij;
    private boolean eii = false;

    public static a aHU() {
        if (eij == null) {
            synchronized (a.class) {
                if (eij == null) {
                    eij = new a();
                }
            }
        }
        return eij;
    }

    private a() {
        initConfig();
    }

    private void initConfig() {
        this.eii = TbadkSettings.getInst().loadBoolean("has_showed_del_ga_tip", false);
    }

    public boolean aHV() {
        return this.eii;
    }

    public void hF(boolean z) {
        this.eii = z;
        TbadkSettings.getInst().saveBoolean("has_showed_del_ga_tip", z);
    }
}
