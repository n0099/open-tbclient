package com.baidu.tieba.group;

import com.baidu.tbadk.TbadkSettings;
/* loaded from: classes3.dex */
public class a {
    private static a esB;
    private boolean esA = false;

    public static a aKY() {
        if (esB == null) {
            synchronized (a.class) {
                if (esB == null) {
                    esB = new a();
                }
            }
        }
        return esB;
    }

    private a() {
        initConfig();
    }

    private void initConfig() {
        this.esA = TbadkSettings.getInst().loadBoolean("has_showed_del_ga_tip", false);
    }

    public boolean aKZ() {
        return this.esA;
    }

    public void hK(boolean z) {
        this.esA = z;
        TbadkSettings.getInst().saveBoolean("has_showed_del_ga_tip", z);
    }
}
