package com.baidu.tieba;

import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes.dex */
public class a {
    public static void a(com.baidu.tbadk.coreExtra.data.d dVar) {
        if (dVar != null) {
            if (dVar.bfj != 0) {
                com.baidu.tbadk.core.sharedPref.b.getInstance().putString("app_entrance_nologin", dVar.bfj + "");
            }
            if (dVar.bfi != 0 && TbadkCoreApplication.getCurrentAccount() != null) {
                com.baidu.tbadk.core.sharedPref.b.getInstance().putString("app_entrance_" + TbadkCoreApplication.getCurrentAccount(), dVar.bfi + "");
            }
        }
    }

    public int RN() {
        String string;
        if (TbadkCoreApplication.getCurrentAccount() == null) {
            string = com.baidu.tbadk.core.sharedPref.b.getInstance().getString("app_entrance_nologin", "");
        } else {
            string = com.baidu.tbadk.core.sharedPref.b.getInstance().getString("app_entrance_" + TbadkCoreApplication.getCurrentAccount(), "");
        }
        int h = com.baidu.adp.lib.g.b.h(string, 0);
        if (h != 1 && h == 2) {
            return 1;
        }
        return 2;
    }
}
