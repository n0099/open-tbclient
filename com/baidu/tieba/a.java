package com.baidu.tieba;

import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes.dex */
public class a {
    public static void a(com.baidu.tbadk.coreExtra.data.e eVar) {
        if (eVar != null) {
            if (eVar.aNF != 0) {
                com.baidu.tbadk.core.sharedPref.b.getInstance().putString("app_entrance_nologin", eVar.aNF + "");
            }
            if (eVar.aNE != 0 && TbadkCoreApplication.getCurrentAccount() != null) {
                com.baidu.tbadk.core.sharedPref.b.getInstance().putString("app_entrance_" + TbadkCoreApplication.getCurrentAccount(), eVar.aNE + "");
            }
        }
    }

    public int TD() {
        String string;
        if (TbadkCoreApplication.getCurrentAccount() == null) {
            string = com.baidu.tbadk.core.sharedPref.b.getInstance().getString("app_entrance_nologin", "");
        } else {
            string = com.baidu.tbadk.core.sharedPref.b.getInstance().getString("app_entrance_" + TbadkCoreApplication.getCurrentAccount(), "");
        }
        int l = com.baidu.adp.lib.g.b.l(string, 0);
        if (l != 1 && l == 2) {
            return 1;
        }
        return 2;
    }
}
