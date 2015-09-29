package com.baidu.tbadk.util;

import android.text.TextUtils;
import com.baidu.tbadk.TbadkSettings;
/* loaded from: classes.dex */
public class a {
    private static a azo = null;

    private a() {
    }

    public static synchronized a Et() {
        a aVar;
        synchronized (a.class) {
            if (azo == null) {
                azo = new a();
            }
            aVar = azo;
        }
        return aVar;
    }

    public void Eu() {
        String Ev = Ev();
        if (!TextUtils.isEmpty(Ev)) {
            com.baidu.adp.lib.f.c.ha().a(Ev, 10, null, 0, 0, null, new Object[0]);
        }
    }

    public String Ev() {
        return TbadkSettings.getInst().loadString("ad_url", null);
    }
}
