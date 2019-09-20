package com.baidu.tieba;

import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes.dex */
public class b {
    public static void a(com.baidu.tbadk.coreExtra.data.e eVar) {
        if (eVar != null) {
            if (eVar.cgO != 0) {
                com.baidu.tbadk.core.sharedPref.b.ahU().putString("app_entrance_nologin", eVar.cgO + "");
            }
            if (eVar.cgN != 0 && TbadkCoreApplication.getCurrentAccount() != null) {
                com.baidu.tbadk.core.sharedPref.b.ahU().putString("app_entrance_" + TbadkCoreApplication.getCurrentAccount(), eVar.cgN + "");
            }
        }
    }

    public int aAH() {
        String string;
        if (TbadkCoreApplication.getCurrentAccount() == null) {
            string = com.baidu.tbadk.core.sharedPref.b.ahU().getString("app_entrance_nologin", "");
        } else {
            string = com.baidu.tbadk.core.sharedPref.b.ahU().getString("app_entrance_" + TbadkCoreApplication.getCurrentAccount(), "");
        }
        int f = com.baidu.adp.lib.g.b.f(string, 0);
        if (f != 1 && f == 2) {
            return 1;
        }
        return 2;
    }
}
