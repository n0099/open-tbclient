package com.baidu.tieba;

import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes.dex */
public class a {
    public static void a(com.baidu.tbadk.coreExtra.data.b bVar) {
        if (bVar != null) {
            if (bVar.aot != 0) {
                com.baidu.tbadk.core.sharedPref.b.uo().putString("app_entrance_nologin", new StringBuilder(String.valueOf(bVar.aot)).toString());
            }
            if (bVar.aos != 0 && TbadkCoreApplication.getCurrentAccount() != null) {
                com.baidu.tbadk.core.sharedPref.b.uo().putString("app_entrance_" + TbadkCoreApplication.getCurrentAccount(), new StringBuilder(String.valueOf(bVar.aos)).toString());
            }
        }
    }

    public int IL() {
        String string;
        if (TbadkCoreApplication.getCurrentAccount() == null) {
            string = com.baidu.tbadk.core.sharedPref.b.uo().getString("app_entrance_nologin", "");
        } else {
            string = com.baidu.tbadk.core.sharedPref.b.uo().getString("app_entrance_" + TbadkCoreApplication.getCurrentAccount(), "");
        }
        int g = com.baidu.adp.lib.g.b.g(string, 0);
        if (g != 1 && g == 2) {
            return 1;
        }
        return 2;
    }
}
