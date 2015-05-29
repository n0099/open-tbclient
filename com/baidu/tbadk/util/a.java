package com.baidu.tbadk.util;

import android.text.TextUtils;
import com.baidu.tbadk.TbadkSettings;
/* loaded from: classes.dex */
public class a {
    private static a asc = null;

    private a() {
    }

    public static synchronized a DP() {
        a aVar;
        synchronized (a.class) {
            if (asc == null) {
                asc = new a();
            }
            aVar = asc;
        }
        return aVar;
    }

    public void DQ() {
        String DR = DR();
        if (!TextUtils.isEmpty(DR)) {
            com.baidu.adp.lib.f.d.hl().a(DR, 10, null, 0, 0, null, new Object[0]);
        }
    }

    public String DR() {
        return TbadkSettings.getInst().loadString("ad_url", null);
    }
}
