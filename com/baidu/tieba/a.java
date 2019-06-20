package com.baidu.tieba;

import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes.dex */
public class a {
    public static void a(com.baidu.tbadk.coreExtra.data.e eVar) {
        if (eVar != null) {
            if (eVar.ceJ != 0) {
                com.baidu.tbadk.core.sharedPref.b.agM().putString("app_entrance_nologin", eVar.ceJ + "");
            }
            if (eVar.ceI != 0 && TbadkCoreApplication.getCurrentAccount() != null) {
                com.baidu.tbadk.core.sharedPref.b.agM().putString("app_entrance_" + TbadkCoreApplication.getCurrentAccount(), eVar.ceI + "");
            }
        }
    }

    public int azd() {
        String string;
        if (TbadkCoreApplication.getCurrentAccount() == null) {
            string = com.baidu.tbadk.core.sharedPref.b.agM().getString("app_entrance_nologin", "");
        } else {
            string = com.baidu.tbadk.core.sharedPref.b.agM().getString("app_entrance_" + TbadkCoreApplication.getCurrentAccount(), "");
        }
        int f = com.baidu.adp.lib.g.b.f(string, 0);
        if (f != 1 && f == 2) {
            return 1;
        }
        return 2;
    }
}
