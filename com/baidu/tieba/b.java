package com.baidu.tieba;

import com.baidu.live.tbadk.core.sharedpref.SharedPrefConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes.dex */
public class b {
    public static void a(com.baidu.tbadk.coreExtra.data.e eVar) {
        if (eVar != null) {
            if (eVar.ejA != 0) {
                com.baidu.tbadk.core.sharedPref.b.aVP().putString(SharedPrefConfig.APP_ENTRANCE_NO_LOGIN_KEY, eVar.ejA + "");
            }
            if (eVar.ejz != 0 && TbadkCoreApplication.getCurrentAccount() != null) {
                com.baidu.tbadk.core.sharedPref.b.aVP().putString(SharedPrefConfig.APP_ENTRANCE_PREFIX + TbadkCoreApplication.getCurrentAccount(), eVar.ejz + "");
            }
        }
    }

    public int bmp() {
        String string;
        if (TbadkCoreApplication.getCurrentAccount() == null) {
            string = com.baidu.tbadk.core.sharedPref.b.aVP().getString(SharedPrefConfig.APP_ENTRANCE_NO_LOGIN_KEY, "");
        } else {
            string = com.baidu.tbadk.core.sharedPref.b.aVP().getString(SharedPrefConfig.APP_ENTRANCE_PREFIX + TbadkCoreApplication.getCurrentAccount(), "");
        }
        int i = com.baidu.adp.lib.f.b.toInt(string, 0);
        if (i != 1 && i == 2) {
            return 1;
        }
        return 2;
    }
}
