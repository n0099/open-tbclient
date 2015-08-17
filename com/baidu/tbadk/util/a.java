package com.baidu.tbadk.util;

import android.text.TextUtils;
import com.baidu.tbadk.TbadkSettings;
/* loaded from: classes.dex */
public class a {
    private static a azf = null;

    private a() {
    }

    public static synchronized a Ev() {
        a aVar;
        synchronized (a.class) {
            if (azf == null) {
                azf = new a();
            }
            aVar = azf;
        }
        return aVar;
    }

    public void Ew() {
        String Ex = Ex();
        if (!TextUtils.isEmpty(Ex)) {
            com.baidu.adp.lib.f.c.hc().a(Ex, 10, null, 0, 0, null, new Object[0]);
        }
    }

    public String Ex() {
        return TbadkSettings.getInst().loadString("ad_url", null);
    }
}
