package com.baidu.tbadk.util;

import android.text.TextUtils;
import com.baidu.tbadk.TbadkSettings;
/* loaded from: classes.dex */
public class a {
    private static a ayn = null;

    private a() {
    }

    public static synchronized a Ei() {
        a aVar;
        synchronized (a.class) {
            if (ayn == null) {
                ayn = new a();
            }
            aVar = ayn;
        }
        return aVar;
    }

    public void Ej() {
        String Ek = Ek();
        if (!TextUtils.isEmpty(Ek)) {
            com.baidu.adp.lib.f.c.hb().a(Ek, 10, null, 0, 0, null, new Object[0]);
        }
    }

    public String Ek() {
        return TbadkSettings.getInst().loadString("ad_url", null);
    }
}
