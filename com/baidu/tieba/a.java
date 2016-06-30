package com.baidu.tieba;

import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes.dex */
public class a {
    public static void a(com.baidu.tbadk.coreExtra.data.a aVar) {
        if (aVar != null) {
            if (aVar.afX != 0) {
                com.baidu.tbadk.core.sharedPref.b.sO().putString("app_entrance_nologin", new StringBuilder(String.valueOf(aVar.afX)).toString());
            }
            if (aVar.afW != 0 && TbadkCoreApplication.getCurrentAccount() != null) {
                com.baidu.tbadk.core.sharedPref.b.sO().putString("app_entrance_" + TbadkCoreApplication.getCurrentAccount(), new StringBuilder(String.valueOf(aVar.afW)).toString());
            }
        }
    }

    public int HF() {
        String string;
        if (TbadkCoreApplication.getCurrentAccount() == null) {
            string = com.baidu.tbadk.core.sharedPref.b.sO().getString("app_entrance_nologin", "");
        } else {
            string = com.baidu.tbadk.core.sharedPref.b.sO().getString("app_entrance_" + TbadkCoreApplication.getCurrentAccount(), "");
        }
        int g = com.baidu.adp.lib.h.b.g(string, 0);
        if (g != 1 && g == 2) {
            return 1;
        }
        return 2;
    }
}
