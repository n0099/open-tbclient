package com.baidu.tieba.group;

import com.baidu.tbadk.TbadkSettings;
/* loaded from: classes3.dex */
public class a {
    private static a esA;
    private boolean esz = false;

    public static a aKY() {
        if (esA == null) {
            synchronized (a.class) {
                if (esA == null) {
                    esA = new a();
                }
            }
        }
        return esA;
    }

    private a() {
        initConfig();
    }

    private void initConfig() {
        this.esz = TbadkSettings.getInst().loadBoolean("has_showed_del_ga_tip", false);
    }

    public boolean aKZ() {
        return this.esz;
    }

    public void hK(boolean z) {
        this.esz = z;
        TbadkSettings.getInst().saveBoolean("has_showed_del_ga_tip", z);
    }
}
