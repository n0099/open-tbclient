package com.baidu.tbadk.util;

import android.text.TextUtils;
import com.baidu.tbadk.TbadkSettings;
import com.baidu.tbadk.core.atomData.SignAllForumAdvertActivityConfig;
/* loaded from: classes.dex */
public class a {
    private static a azS = null;

    private a() {
    }

    public static synchronized a Fl() {
        a aVar;
        synchronized (a.class) {
            if (azS == null) {
                azS = new a();
            }
            aVar = azS;
        }
        return aVar;
    }

    public void Fm() {
        String Fn = Fn();
        if (!TextUtils.isEmpty(Fn)) {
            com.baidu.adp.lib.g.c.dF().a(Fn, 10, null, 0, 0, null, new Object[0]);
        }
    }

    public String Fn() {
        return TbadkSettings.getInst().loadString(SignAllForumAdvertActivityConfig.AD_URL, null);
    }
}
