package com.baidu.tieba;

import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes.dex */
public class a {
    public static void a(com.baidu.tbadk.coreExtra.data.d dVar) {
        if (dVar != null) {
            if (dVar.aBP != 0) {
                com.baidu.tbadk.core.sharedPref.b.getInstance().putString("app_entrance_nologin", dVar.aBP + "");
            }
            if (dVar.aBO != 0 && TbadkCoreApplication.getCurrentAccount() != null) {
                com.baidu.tbadk.core.sharedPref.b.getInstance().putString("app_entrance_" + TbadkCoreApplication.getCurrentAccount(), dVar.aBO + "");
            }
        }
    }

    public int Ov() {
        String string;
        if (TbadkCoreApplication.getCurrentAccount() == null) {
            string = com.baidu.tbadk.core.sharedPref.b.getInstance().getString("app_entrance_nologin", "");
        } else {
            string = com.baidu.tbadk.core.sharedPref.b.getInstance().getString("app_entrance_" + TbadkCoreApplication.getCurrentAccount(), "");
        }
        int g = com.baidu.adp.lib.g.b.g(string, 0);
        if (g != 1 && g == 2) {
            return 1;
        }
        return 2;
    }
}
