package com.baidu.tbadk.util;

import android.text.TextUtils;
import com.baidu.tbadk.TbadkSettings;
import com.baidu.tbadk.core.atomData.SignAllForumAdvertActivityConfig;
/* loaded from: classes.dex */
public class a {
    private static a aDN = null;

    private a() {
    }

    public static synchronized a Hm() {
        a aVar;
        synchronized (a.class) {
            if (aDN == null) {
                aDN = new a();
            }
            aVar = aDN;
        }
        return aVar;
    }

    public void Hn() {
        String Ho = Ho();
        if (!TextUtils.isEmpty(Ho)) {
            com.baidu.adp.lib.g.c.hr().a(Ho, 10, null, 0, 0, null, new Object[0]);
        }
    }

    public String Ho() {
        return TbadkSettings.getInst().loadString(SignAllForumAdvertActivityConfig.AD_URL, null);
    }
}
